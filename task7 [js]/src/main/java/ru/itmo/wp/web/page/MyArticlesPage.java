package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/** @noinspection unused*/
public class MyArticlesPage {
    ArticleService articleService = new ArticleService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new RedirectException("/index");
        }

        view.put("myArticles", articleService.findAllByUserId(user.getId()));
    }

    private void changeStatus(HttpServletRequest request, Map<String, Object> view) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new RedirectException("/index");
        }

        long id = Long.parseLong(request.getParameter("id")); //NOTE: validate
        Article article = articleService.find(id);

        if (article.getUserId() != user.getId()) {
            throw new RedirectException("/myArticles");
        }

        article.setHidden(!article.isHidden());
        articleService.updateStatus(article);
    }

    private void isHidden(HttpServletRequest request, Map<String, Object> view) {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/index");
        }

        view.put("isHidden", articleService.find(Long.parseLong(request.getParameter("id"))).isHidden());
    }
}