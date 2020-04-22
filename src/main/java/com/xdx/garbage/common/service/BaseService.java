package com.xdx.garbage.common.service;


import com.xdx.garbage.common.dto.QueryParam;

import java.util.List;

public interface BaseService<T> {
    /**
     * 查询
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 通过Id查询
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 根据ID集合来查询
     *
     * @param ids
     * @return
     */
    //  List<T> selectListByIds(List<Object> ids);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);


    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> selectListAll();


    /**
     * 查询总记录数
     *
     * @return
     */
    Long selectCountAll();

    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(T entity);


    /**
     * 插入 不插入null字段
     *
     * @param entity
     */
    int insertSelective(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据Id删除
     *
     * @param id
     */
    void deleteById(Object id);


    /**
     * 根据id更新
     *
     * @param entity
     */
    int updateById(T entity);


    /**
     * 不update null
     *
     * @param entity
     */
    int updateSelectiveById(T entity);

    /**
     * 根据queryParam来动态查询
     * @param queryParam
     * @return
     */
    List<T>selectListByQueryParam(QueryParam queryParam);

    /**
     * 根据queryParam查询总记录数
     * @param queryParam
     * @return
     */
    Long selectCountByQueryParam(QueryParam queryParam);

    /**
     * 隐式删除
     * @param id
     * @return
     */
    int hiddenById(long id);
}