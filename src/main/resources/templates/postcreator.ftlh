<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>New post</title>
</head>
<body>
<form method="post">
    <label>
        <p>
            <input name="title" type="text" placeholder="Title">
        </p>
    </label>
    <label>
        <p>
            <textarea name="content" placeholder="Poem"></textarea>
        </p>
    </label>
    <p>
        Choose more suitable type:
        <label>
            <select name="postType">
                <option value="LOVE" selected>Love</option>
                <option value="SADNESS">Sadness</option>
                <option value="OTHER">Other</option>
            </select>
        </label>
    </p>
    <input type="submit" value="Send">
</form>
</body>
</html>