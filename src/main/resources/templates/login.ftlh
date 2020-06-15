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
    <title>Login</title>
</head>
<body style="background: pink lighten-4">
<div class="container center-align">
    <form method="post" id="loginForm">
        <h2 class="brown-darken-4-text" style="margin-top: 15%">Login</h2>
        <label>
            <input name="email" type="email" class="validate" placeholder="email" style="margin-bottom: 5%">
        </label>
        <label>
            <input name="password" type="password" class="password-field" placeholder="password" style="margin-bottom: 5%">
        </label>
        <div style="margin-bottom: 2%"><a href="/register">Register</a></div>
        <label>
            <input type="submit" value="login"
                   class="btn waves-effect blue-grey ">
        </label>
    </form>
    <a class="btn waves-effect blue-grey" href="https://discord.com/api/oauth2/authorize?client_id=715678906987839491&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fdiscord&response_type=code&scope=identify%20email%20connections%20guilds">Login with Discord</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</body>
</html>