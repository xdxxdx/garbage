package com.xdx.garbage.controller.back;

import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.entity.TNews;
import com.xdx.garbage.service.NewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ele/news")
public class NewsController extends BaseController<NewsService, TNews> {

}
