<%--
  User: bassomillo
  Date: 2021/12/28
  Time: 13:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <base href="<%=basePath%>">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1 style="text-align: center;height: 100px;line-height: 100px">
    user management system login
</h1>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="user/login" method="post">
                <div class="form-group" id="profile" style="height: 100px;width: 100px">

                </div>
                <div class="form-group">
                    <label for="username">username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="username"><span id="msg" style="color: red"></span>
                </div>
                <div class="form-group">
                    <label for="password">password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="password"><span id="msg1" style="color: red"></span>
                </div>
                <div class="form-group">
                    <label for="password">verification</label>
                    <input type="password" class="form-control" id="verification" name="verification" placeholder="verification">
                    <img src="user/verification" id="verify">
                </div>
                <button type="submit" class="btn btn-default">Login</button>
            </form>
            Not have an account?

            <a href="register.jsp">register</a>
        </div>
        <div class="col-md-4"></div>

    </div>
</div>

<script>
    let usernameInput = document.getElementById("username");
    let passwordInput = document.getElementById("password");
    document.getElementById("username").addEventListener("blur",function (){
       $.post("user/getProfile", {username:usernameInput.value},function (data){
           if(data){
               document.getElementById("profile").innerHTML = "<img style='width: 100px' src='"+data+"'/>"
               document.getElementById("msg").innerText = data
           }else {
               document.getElementById("profile").innerHTML = ""
           }
       })
    })
    document.getElementById("verify").addEventListener("click",function (){
        document.getElementById("verify").setAttribute("src","user/verify");
    })
</script>


</body>
</html>
