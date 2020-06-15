<!doctype html>
<#import "spring.ftl" as spring/>
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
    <title>Sign up</title>
</head>
<body style="background: pink lighten-2">
<div class="container center-align">
    <form method="post" id="signUpForm" onsubmit="return validate()">
        <h2 class="blue-grey-text" style="margin-top: 15%">Register</h2>
        <div style="min-height: 9em">
            <#if serverError??>
            <div id="serverError" style="color: #d92323; font-weight: bold">
                <p>${serverError}</p>
            </div>
            </#if>
            <label>
                <input name="email" type="email" class="validate" placeholder="email" id="emailInput">
            </label>
            <div id="emailError" style="color: #d92323; font-weight: bold">
            </div>
        </div>
        <div style="min-height: 9em">
            <label>
                <input name="nickName" type="text" class="validate" placeholder="nick name">
            </label>
            <div id="nickNameError" style="color: #d92323; font-weight: bold">
            </div>
        </div>
        <div style="min-height: 9em">
            <label>
                <input name="password" type="password" class="password-field" placeholder="password" id="passwordInput">
            </label>
            <div id="passwordError" style="color: #d92323; font-weight: bold">
            </div>
        </div>
        <div style="min-height: 9em">
            <label>
                <input name="repeatPassword" type="password" class="password-field" placeholder="repeat password"
                       id="passwordInputRepeat">
            </label>
            <div id="passwordRepeatError" style="color: #d92323; font-weight: bold">
            </div>
        </div>
        <div style="color: darkgoldenrod; margin-bottom: 2%">
            <strong>Already have account?</strong> <a href="/login">Sign in</a>
        </div>
        <label>
            <input type="submit" value="register"
                   class="btn waves-effect blue-grey" id="formSubmit">
        </label>
    </form>
</div>
<script>

    function validate() {
        let emailInput = document.getElementById("emailInput");
        let passwordInput = document.getElementById("passwordInput");
        let passwordInputRepeat = document.getElementById("passwordInputRepeat");
        let emailError = document.getElementById("emailError");
        let passwordError = document.getElementById("passwordError");
        let passwordRepeatError = document.getElementById("passwordRepeatError");
        const regExp = /.+@.+\..+/;
        if (!emailInput.value.match(regExp)) {
            emailError.style.color = "red";
            emailError.innerText = "Invalid email!";
            return false;
        } else {
            emailError.innerText = "";
        }
        if (passwordInput.value.length < 8) {
            passwordError.style.color = "red";
            passwordError.innerText = "Password's length less than 8!";
            return false;
        } else {
            passwordError.innerText = "";
        }
        if (!(passwordInput.value === passwordInputRepeat.value)) {
            passwordRepeatError.style.color = "red";
            passwordRepeatError.innerText = "Passwords do not mathes!"
            return false;
        } else {
            passwordRepeatError.innerText ="";
        }
        return true;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</body>
</html>