<#-- @ftlvariable name="user_id" type="java.lang.Long" -->
<#-- @ftlvariable name="post_id" type="java.lang.Long" -->
<#-- @ftlvariable name="posts" type="java.util.List" -->

<#import "./common.ftlh" as c>
<#import "./misc/postNotFound.ftlh" as error>
<#import "./posts.ftlh" as postTemplate>

<#if post_id?? && c.findByPost(posts, "id", post_id) != "null">
    <@c.page>
        <@postTemplate.page [c.findByPost(posts, "id", post_id)] c.findByPost(posts, "id", post_id).text?length />
    </@c.page>
<#else>
    <@error.page/>
</#if>
