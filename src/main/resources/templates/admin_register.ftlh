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
    <a href="/">HRWizard</a>
</div>
<div class="section" id="result-container">
    <div class="container">
        <div class="section_header">
            <h2 class="section_title">Admin registration</h2>
        </div>
        <form action="/registerAdmin" method="post">
            Admin first name: <label>
                <input type="text" name="firstName">
            </label><br><br>
            Admin last name: <label>
                <input type="text" name="lastName">
            </label><br><br>
            Password: <label>
                <input type="password" name="password">
            </label><br><br>
            Admin email: <label>
                <input type="email" name="email">
            </label><br><br>
            Admin phone: <label>
                <input type="text" name="phoneNumber">
            </label><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Create">
        </form>
    </div>
</div>


</body>
</html>