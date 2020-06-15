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
    <title>Inspiration</title>
</head>
<body>
<#include "navbar.ftlh">
<a style="font-size: 2em;
          font-weight: bolder;
          color: black;
          padding-left: 10%"
   href="/popular">
    Popular stories
</a>
<div class="container">
    <div class="card large">
        <h4><a href="/post/${popularPost.id}">${popularPost.title}</a></h4>
        <h6>${popularPost.postType}</h6>
        <p>${popularPost.content}</p>
    </div>
</div>
<a style="font-size: 2em;
   font-weight: bolder;
   color: black;
   padding-left: 10%"
   href="/latest">
    Latest stories
</a>
<div class="container">
    <div class="card large">
        <h4><a href="/post/${latestPost.id}">${latestPost.title}</a></h4>
        <h6>${latestPost.postType}</h6>
        <p>${latestPost.content}</p>
    </div>
</div>
<footer class="pink lighten-2 page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Inspiration</h5>
                <p class="grey-text text-lighten-4"></p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="">Contact</a></li>
                    <li><a class="grey-text text-lighten-3" href="">Privacy</a></li>
                    <li><a class="grey-text text-lighten-3" href="">Advertise</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2020 Inspiration
            <a class="grey-text text-lighten-4 right" href="">More Links</a>
        </div>
    </div>
</footer>
</body>
</html>