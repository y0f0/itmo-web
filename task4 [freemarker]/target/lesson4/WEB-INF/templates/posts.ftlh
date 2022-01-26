<#import "./common.ftlh" as c>
<#import "./misc/notFound.ftlh" as error>
<#-- @ftlvariable name="posts" type="ru.itmo.web.lesson4.model.Post[]" -->
<#-- @ftlvariable name="user_id" type="java.lang.Long" -->

<#if user_id??>
    <#assign items = []>
    <#list posts as post>
        <#if post.getUserId() == user_id>
            <#assign items = items + [post]>
        </#if>
    </#list>
    <#assign user = c.findByUser(users, "id", user_id)/>
    <#if user != "null">
        <@c.page>
            <@page items 250/>
        </@c.page>
    <#else>
        <@error.page/>
    </#if>
</#if>

<#macro page posts border>
    <link rel="stylesheet" href="/css/post.css">
    <#list posts?reverse as post>
        <li style="list-style-type: none;">
            <article>
                <div class="title">${post.title}</div>

                <div class="information">By
                    <@c.userlink c.findByUser(users, "id", post.userId) false/>
                </div>

                <div class="body">
                    <@postParagraphParser post.text?truncate_w(border, "...") ""/>
                </div>
                <ul class="attachment">
                    <li><a href="/post?post_id=${post.id}">View all</a></li>
                </ul>
                <div class="footer">
                    <div class="left">
                        <img src="/img/voteUp.png" title="Vote Up" alt="Vote Up"/>
                        <span class="positive-score">+173</span>
                <img src="/img/VoteDown.png" title="Vote Down" alt="Vote Down"/>
                    </div>
                    <div class="right">
                        <img src="/img/date16x16.png" title="Publish Time" alt="Publish Time"/>
                        2 days ago
                        <img src="/img/comments16x16.png" title="Comments" alt="Comments"/>
                        <a href="#">68</a>
                    </div>
                </div>
            </article>
        </li>
    </#list>
</#macro>

<#macro postParagraphParser post ending>
    <#list post?split("\n") as paragraph>
        <#if paragraph?has_next>
            <p>${paragraph}</p>
        <#else>
            <p>${paragraph}${ending}</p>
        </#if>
    </#list>
</#macro>

