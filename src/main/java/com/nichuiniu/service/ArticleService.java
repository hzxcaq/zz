package com.nichuiniu.service;

import com.nichuiniu.model.Article;
import com.nichuiniu.util.ZzResult;

import java.util.List;

/**
 * Created by libp on 2018/5/23 22:05
 */
public interface ArticleService {

    Article selectByPrimaryKey (int id);

    Article random(String category);

    Article recommend(String category);

    Article articleID(int id);

    List<Article> selectArticleByPage();

    ZzResult insertRecommend(int id);

}
