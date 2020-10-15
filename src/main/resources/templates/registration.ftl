<#import 'parts/login.ftl' as login>
<#import 'parts/common.ftl' as common>

<@common.page>
    <div>
        Add new user
        {message}
    </div>
    <@login.login "/registration"/>
</@common.page>