<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HRWizard</title>
</head>
<body>
<h1>PROFILE</h1>
<hr>
<br>
<div>
    <img src="avatar.png" alt="mdo">
    <h2>${user.firstName}</h2>
    <hr>
    <br>
    <b>${user.email}</b>
    <br>
    <b>${user.phoneNumber}</b>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Logout">
    </form>
    <#if user.isAdmin()??>
        <a href="/admin">
            Admin panel
        </a><br>
    </#if>
</div>
</body>
</html>
