<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Profile</title>
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="pink lighten-2 nav-wrapper">
            <a href="/" class="brand-logo"><img src="https://avatars.mds.yandex.net/get-pdb/1946597/e91f3ac0-a30b-42c6-a3ba-732fcf4700b4/s1200"
                                                class="material-icons" alt="logo" style ="max-width: 50px"/>Inspiration</a>
            <ul class="right hide-on-med-and-down">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </nav>
</div>
<div class="container center-align" style="padding-top: 3%">
    <img src="${user.avatarPath}" alt="Avatar" style="height: 5%; width: 5%">
    <p>${user.nickName}</p>
    <p>${user.role}</p>
    <#if user.role.authority == "AUTHOR">
        <p>
            <a href="/newPost">Write new post</a>
        </p>
    </#if>

</div>
</body>
</html>