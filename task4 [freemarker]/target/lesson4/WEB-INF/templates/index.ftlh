<#import "./posts.ftlh" as p>
<#import "./common.ftlh" as c>
<#-- @ftlvariable name="posts" type="ru.itmo.web.lesson4.model.Post[]" -->

<@c.page>
    <@p.page posts 250/>
</@c.page>