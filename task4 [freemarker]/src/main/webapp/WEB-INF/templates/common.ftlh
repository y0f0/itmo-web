<#-- @ftlvariable name="posts" type="ru.itmo.web.lesson4.model.Post[]" -->
<#-- @ftlvariable name="post" type="ru.itmo.web.lesson4.model.Post" -->

<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="stylesheet" href="/css/normalize.css">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="icon" href="/favicon.ico">
    </head>
    <body>
    <@header/>
    <div class="middle">
        <@sidebar/>
        <main>
            <#nested/>
        </main>
    </div>
    <@footer/>
    </body>
    </html>
</#macro>

<#macro header>
    <header>
        <a href="#" class="logo"><img alt="Codeforces" title="Codeforces"
                                      src="/img/codeforces-logo-with-telegram.png"></a>
        <div class="languages">
            <a href="#"><img alt="In English" title="In English"
                             src="/img/gb.png"></a>
            <a href="#"><img alt="In Russian" title="In Russian"
                             src="/img/ru.png"></a>
        </div>
        <div class="enter-or-register-box">
            <#if logged_user_id?? && findByUser(users, "id", logged_user_id)!="null">
                <@userlink findByUser(users, "id", logged_user_id) true/>
                |
                <a href="/logout">Logout</a>
            <#else>
                <a href="/enter">Enter</a>
                |
                <a href="/register">Register</a>
            </#if>
        </div>
        <nav>
            <#assign items=[
            {"href": "/index", "name": "Home"},
            {"href": "/misc/help", "name": "Help"},
            {"href": "/users", "name": "Users"},
            {"href": "/contests", "name": "Contests"}
            ]/>
            <ul>
                <#list items as item>
                    <li>
                        <#if uri?starts_with(item.href)>
                            <a style="text-decoration: underline;" href="${item.href}">${item.name}</a>
                        <#else>
                            <a href="${item.href}">${item.name}</a>
                        </#if>
                    </li>
                </#list>
            </ul>
        </nav>
    </header>
</#macro>

<#macro sidebar>
    <aside>
        <#list posts?reverse as post>
            <section>
                <div class="header">
                    Post #${post.id}
                </div>
                <div class="body">
                    <#if post.text?length gt 250>
                        <@postParagraphParser post.text?substring(0, 250) "..."/>
                    <#else>
                        <@postParagraphParser post.text ""/>
                    </#if>
                </div>
                <div class="footer">
                    <a href="/post?post_id=${post.id}">View all</a>
                </div>
            </section>
        </#list>
    </aside>
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

<#macro footer>
    <footer>
        2010-2021 &copy; by Mike Mirzayanov
    </footer>
</#macro>

<#macro userlink user>
<#-- @ftlvariable name="user" type="ru.itmo.web.lesson4.model.User" -->
    <a href="/user?handle=${user.handle}">${user.name}</a>
</#macro>

<#function findByUser users key value>
    <#list users as user>
        <#if key == "id" && user.getId() == value>
            <#return user/>
        <#elseif key == "handle" && user.getHandle() == value>
            <#return user/>
        <#elseif key == "name" && user.getName() == value>
            <#return user/>
        <#elseif key == "color" && user.getColor() == value>
            <#return user/>
        </#if>
    </#list>
    <#return "null">
</#function>

<#function findByPost post key value>
    <#list posts as post>
        <#if key == "id" && post.getId() == value>
            <#return post/>
        <#elseif key == "title" && post.getTitle() == value>
            <#return post/>
        <#elseif key == "text" && post.getText() == value>
            <#return post/>
        <#elseif key == "user_id" && post.getUserId() == value>
            <#return post/>
        </#if>
    </#list>
    <#return "null">
</#function>

<#macro userlink user nameOnly>
    <#if nameOnly>
        ${user.getHandle()}
    <#else>
        <#assign map={"RED" : "red", "BLUE" : "blue", "GREEN" : "green" }>
        <a style="color:${map[user.getColor()]}; text-decoration: none"
           href="/user?handle=${user.getHandle()}">${user.getHandle()}</a>
    </#if>
</#macro>

