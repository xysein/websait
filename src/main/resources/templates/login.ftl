<#import 'parts/login.ftl' as login>
<#import 'parts/common.ftl' as common>

<@common.page>
    <div>Login Page</div>
    <@login.login "/login">
        <a href="/registration">Registration</a>
    </@login.login>
</@common.page>