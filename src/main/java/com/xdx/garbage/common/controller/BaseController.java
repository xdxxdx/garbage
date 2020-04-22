package com.xdx.garbage.common.controller;

import com.github.pagehelper.PageHelper;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.dto.PageResponse;
import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**  
* <p>Title: BaseController</p>  
* <p>Description: Controller的基类，处理异常，公共方法 </p>  
* @author xdx
* @date 2018年8月9日  
*/  
public abstract class BaseController<E extends BaseService<T>,T> {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected  E service;

	/**
	 * 通用列表查询
	 * @param selectOption 查询参数
	 * @param pageSize 页大小
	 * @param pageNum  页码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/list",method = RequestMethod.GET )
	protected BaseResponse<List<T>> list(HttpServletRequest request, T selectOption,
										 @RequestParam(value = "limit",required = false) Integer pageSize,
										 @RequestParam(value = "page",required = false) Integer pageNum){
		if(pageNum != null && pageSize != null){
			PageHelper.startPage(pageNum, pageSize);
		}
		List<T> result = service.selectList(selectOption);
		return PageResponse.successPage(result);
	}

	/**
	 * 通用列表查询
	 * @param queryParam 查询参数
	 * @param pageSize 页大小
	 * @param pageNum  页码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/lists",method = RequestMethod.GET )
	protected BaseResponse<Map<String,Object>> listByQueryParam(HttpServletRequest request, QueryParam queryParam,
																@RequestParam(value = "limit",required = false) Integer pageSize,
																@RequestParam(value = "page",required = false) Integer pageNum){
		if(pageNum != null && pageSize != null){
			PageHelper.startPage(pageNum, pageSize);
		}
		queryParam.formatSort();
		List<T> result = service.selectListByQueryParam(queryParam);
		Long size=service.selectCountByQueryParam(queryParam);
		Map<String,Object> map=new HashMap<>();
		map.put("items",result);
		map.put("total",size);
		return PageResponse.<Map<String,Object>>success4element(map);
	}
	/**
	 * 通用更新操作
	 * 注意body中需要包含主键
	 * @param entity
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public BaseResponse<?> modify(HttpServletRequest request, @RequestBody T entity, @PathVariable("id")String id){
		service.updateSelectiveById(entity);
		return BaseResponse.success4element(entity);
	}

	/**
	 * 通用查询明细操作
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public BaseResponse<T> cat(HttpServletRequest request, @PathVariable("id") String id){
		T t = service.selectById(id);
		return BaseResponse.success(t);
	}


	/**
	 * 通用删除操作
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public BaseResponse<?> del(HttpServletRequest request, @PathVariable String id){
		service.deleteById(id);
		return BaseResponse.success4element(null);
	}

	/**
	 * 通用隐式删除操作
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="hidden/{id}",method = RequestMethod.POST)
	public BaseResponse<?> hidden( @PathVariable long id){
		service.hiddenById(id);
		return BaseResponse.success4element(null);
	}

	/**
	 * 通用的新增操作
	 * @param entity
	 * @return
	 */
	@PostMapping("/add")
	public BaseResponse add(@RequestBody T entity){
		if(service.insertSelective(entity)>0){
			return BaseResponse.success4element(null);
		}else{
			return BaseResponse.fail(-1);
		}
	}
}