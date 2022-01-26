<#-- @ftlvariable name="articles" type="ru.itmo.wp.model.domain.Article[]" -->

<#import "commons.ftlh" as c>

<@c.page>
    <div class="article">
        <template>
            <tr>
                <article>
                    <div class="title"></div>
                    <div class="information"></div>
                    <div class="body"></div>
                    <div class="footer">
                        <div class="left">
                            <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                            <span class="positive-score">+173</span>
                            <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                        </div>
                        <div class="right">
                            <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                            in
                            <a class="date"></a>
                            <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                            <a href="#">68</a>

                        </div>
                    </div>
                </article>
            </tr>
        </template>
    </div>

    <script>
        $(function () {
            ajax(
                {
                    action: "findAllArticles"
                },
                function (response) {
                    response["articles"].forEach(function (article) {
                        const $article = $($(".article template").prop("content")).clone();
                        $article.find(".title").text(article["title"]);
                        $article.find(".information").text("id=" + article["id"] + " user_id=" + article["userId"]);

                        $article.find(".body").text(article["text"]);
                        $article.find(".date").text(article["creationTime"]);
                        $(".article").append($article);
                    });
                });
        });
    </script>
</@c.page>

