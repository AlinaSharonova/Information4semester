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
    <title>Post</title>
</head>
<body>
<#include "navbar.ftlh">
<h1>
    ${post.title}
</h1>
<p>
    ${post.content}
</p>
<h6>
    ${post.writeDate}
</h6>
<#if auth??>
<form action="/post/${post.id}/like">
    <input type="submit" value="like">
</form>
</#if>
<hr>
<#if auth??>
    <form method="post">
        <label>
            <textarea name="content"></textarea>
        </label>
        <input type="submit" value="Send">
    </form>
</#if>
<#list comments as comment>
    <p style="border: 2px double hotpink; padding-bottom: 2em">
        <strong>${comment.user.nickName}</strong><br>
        ${comment.content}
    </p>
</#list>
<hr>
</body>
</html>