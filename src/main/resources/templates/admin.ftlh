<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HRWizard</title>
</head>
<body>
<h1 style="text-align: center">ADMIN Panel</h1><hr>
<table class="table table-hover table-dark">
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Phone number</th>
        <th scope="col">AActive</th>
        <th scope="col">Role</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th>${user.role}</th>
        </tr>
    <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>
