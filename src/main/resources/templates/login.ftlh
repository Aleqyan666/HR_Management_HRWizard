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
        <h2>Login</h2>
        <form action="/login" method="post">
            Email: <label>
                <input type="email" name="username">
            </label><br><br>
            Password: <label>
                <input type="password" name="password">
            </label><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Login">
        </form>
        <div>
            <a href="/signup">SignUp</a>
        </div>
    </div>
</div>
</body>
</html>