package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.Article;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.util.ZzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by libp on 2018/5/23 21:38
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping("/v1/random")
    public Object getRandomContent(
            @RequestParam(name = "category", required = false, defaultValue = "z1")
                    String category){
        return articleService.random(category);
    }

    @ResponseBody
    @GetMapping("/v1/recommend")
    public Object getRecommendContent(
            @RequestParam(name = "category", required = false, defaultValue = "z1")
                    String category){
        return articleService.recommend(category);
    }

    @ResponseBody
    @GetMapping("/v1/articleID")
    public Object getArticleById(
            @RequestParam(name = "id", required = false, defaultValue = "145528")
                    int id){
        return articleService.articleID(id);
    }

    @ResponseBody
    @GetMapping("/v1/insertRecommend")
    public ZzResult insertRecommend(
            @RequestParam(name = "id", required = false, defaultValue = "145528")
                    int id){
        return articleService.insertRecommend(id);
    }

    @ResponseBody
    @GetMapping("/v1/selectArticleByPage")
    public Object selectArticleByPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleService.selectArticleByPage();
        PageInfo page = new PageInfo(list);
        return page;
    }
}
