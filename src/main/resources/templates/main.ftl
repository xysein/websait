<#import 'parts/common.ftl' as common>
<#import 'parts/login.ftl' as login>

<@common.page>

    <@login.logout/>
    <div>
        <form action="/main" method="post">
            <input type="text" name="text" placeholder="Text">
            <input type="text" name="tag" placeholder="Tag">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <div>
        <form action="/main" method="get">
            <input type="text" name="filter" value="${filter}">
            <button type="submit">Find</button>
        </form>
    </div>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <b>${message.tag}</b>
            <strong>${message.authorName}</strong>
        </div>
        <#else>
        No messages
    </#list>
</@common.page>