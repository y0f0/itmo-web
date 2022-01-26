<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#-- @ftlvariable name="user_id" type="java.lang.Long" -->
<#-- @ftlvariable name="posts" type="java.util.List" -->
<#-- @ftlvariable name="logged_user_id" type="java.lang.Long" -->

<#import "./common.ftlh" as c>
<#import "./misc/notFound.ftlh" as error>

<#if user_id??>
    <#assign key="id">
    <#assign value=user_id>
    <#if !user_id?is_number>
        <@c.page>
            No such user
        </@c.page>
    </#if>
<#elseif handle??>
    <#assign key="handle">
    <#assign value=handle>
</#if>
<#assign u = c.findByUser(users, key, value)!/>

<#if u == "null">
    <@c.page>
        No such user
    </@c.page>
<#else>
        <@c.page>
            <div class="userPage">
                <#if logged_user_id?? && u.getId() == logged_user_id>
                    <@c.userlink u true/>
                <#else>
                    <@c.userlink u false/>
                </#if>
                <img class="userImage" src="/img/no-title.jpeg" alt="title">

                <ul class="userInfo">
                    <li>id: ${u.id}</li>
                    <li>handle: ${u.handle}</li>
                    <li>name: ${u.name}</li>
                    <li>posts:
                        <a href="posts?user_id=${u.id}">
                            ${CountPosts(posts, "user_id", u.id)}
                        </a>
                    </li>
                </ul>
            </div>
            <div class="moveUserBar">
                <@userArrow getPrev(users, key, value), "←"/>
                <@userArrow getNext(users, key, value), "→"/>
            </div>
        </@c.page>
</#if>


<#macro userArrow user arrow>
    <#if user != "null">
        <a class="moveArrowActive" href="/user?handle=${user.handle}">${arrow}</a>
    <#else>
        <span class="moveArrowPassive">${arrow}</span>
    </#if>
</#macro>

<#function getNext items key value>
    <#list items as item>
        <#if item[key] == value>
            <#if item_has_next>
                <#return items[item_index + 1]>
            <#else>
                <#return "null">
            </#if>
        </#if>
    </#list>
</#function>

<#function getPrev items key value>
    <#list items as item>
        <#if item[key] == value>
            <#if item_index gt 0>
                <#return items[item_index - 1]>
            <#else>
                <#return "null">
            </#if>
        </#if>
    </#list>
</#function>

<#function CountPosts items key id>
    <#assign postAmmount=0/>
    <#list items as item>
        <#if item.getUserId() == id>
            <#assign postAmmount = postAmmount + 1>
        </#if>
    </#list>

    <#return postAmmount/>
</#function>
