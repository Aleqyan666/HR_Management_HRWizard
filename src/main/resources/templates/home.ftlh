<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HRWizard</title>
</head>
<body>
<header id="site-header" class="header">
    <div class="container">
        <#if company??>
        <h3>Company name: <i>${company.name}</i></h3>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Logout">
        </form>
        <br><br>
        <h3>${company.name}</h3>
        <table>
            <tr>
                <th><a href="/registerUser">Add User</a></th>
                <th><a href="/registerAdmin">Add Admin</a></th>
            </tr>
        </table>
        <#elseif user??>
            <h3><i>${user.firstName}</i></h3>>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Logout">
            </form>
        <#else >
        <div class="header_inner">
            <div class="header_logo">Ship</div>
            <nav class="navigation">
                <a class="nav_link" href="/#about">About</a>
                <a class="nav_link" href="/login">LogIn</a>
            </nav>
        </div>
        <div class="intro">
            <div class="intro_inner">
                <div class="container">
                    <h1 class="intro_title">Welcome</h1>
                    <h2 class="intro_subtitle">Build Your Ship</h2>
                </div>
            </div>
        </div>

        <div class="section" id="about">
            <div class="container">
                <div class="section_header">
                    <h3 class="section_subtitle">What we do</h3>
                    <h2 class="section_title">Story about us</h2>
                    <div class="section_text">
                        <p>
                            Every business has a story to tell.
                            We believe an “About” page should always
                            include a piece of the story about you or
                            your company. This is especially true for
                            bloggers and smaller companies. People
                            love brands with personalities nowadays.
                            And stories are powerful mediums for you to
                            connect with your audience.
                            People tell stories. It’s what we do as humans!
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <div class="statistics">
            <div class="container">
                <div class="stat">
                    <div class="stat_item">
                        <div class="stat_count">27</div>
                        <div class="stat_text">faithful partner</div>
                    </div>
                    <div class="stat_item">
                        <div class="stat_count">120+</div>
                        <div class="stat_text">happy client</div>
                    </div>
                    <div class="stat_item">
                        <div class="stat_count">15</div>
                        <div class="stat_text">award winner</div>
                    </div>
                    <div class="stat_item">
                        <div class="stat_count">99</div>
                        <div class="stat_text">cup of coffee</div>
                    </div>
                    <div class="stat_item">
                        <div class="stat_count">150</div>
                        <div class="stat_text">members</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#if>
</header>
<a href="#site-header" class="back-to-header">Header</a>
</body>
</html>
