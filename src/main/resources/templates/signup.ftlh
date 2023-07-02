<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ship</title>
</head>
<body>

<div class="header" id="navbar-top">
    <a href="/">Ship</a>
</div>
<div class="section" id="result-container">
    <div class="container">
        <div class="section_header">
            <h2 class="section_title">Company registration</h2>
        </div>
        <form action="/signup" method="post" enctype="multipart/form-data">
            Company name: <label>
                <input type="text" name="name">
            </label><br><br>
            Password: <label>
                <input type="password" name="password">
            </label><br><br>
            Company email: <label>
                <input type="email" name="email">
            </label><br><br>
            Company phone: <label>
                <input type="text" name="phone_number">
            </label><br><br>
<#--            Company logo: <label>-->
<#--                <input type="file" name="logo"/>-->
<#--            </label><br><br>-->
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="SIGN_UP">
        </form>
        <#if erroreMessage??>
            <h2 style='color: red'>${errorMessage}</h2>
        </#if>
    </div>
</div>


</body>
</html>