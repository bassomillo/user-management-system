<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<h1 style="text-align: center;height: 100px;line-height: 100px">
    modify user information
</h1>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="user/update" method="post" enctype="multipart/form-data">
                <img width="50px" src="${requestScope.user.profile}">
                <input type="hidden" name="id" value="${requestScope.user.id}">
                <div class="form-group">
                    <label for="username">username</label>
                    <input value="${requestScope.user.username}" class="form-control" id="username" name="username" placeholder="username"><span id="msg" style="color: red"></span>
                </div>

                <div class="form-group">
                    <label for="profile">profile</label>
                    <input type="file" id="profile" name="profile">
                </div>

                <div class="form-group">
                    <label for="profile">profile</label>
                    <select name="deptId" class="form-control">
                        <c:forEach items="${requestScope.deptList}" var="deptList">
                            <option value="${deptList.id}">${deptList.name}</option>
                        </c:forEach>
                    </select>
                </div>



                <button type="submit" class="btn btn-default">register</button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<script>
    let usernameInput = document.getElementById("username");
    let passwordInput = document.getElementById("password");
    document.getElementById("username").addEventListener("blur",function (){
        Ajax("POST","user/checkUserName","username="+usernameInput.value,function (data1){
            if(data1==="nullUsername"){
                document.getElementById("msg").setAttribute("style","color: red")
                document.getElementById("msg").innerText = "username cannot be null"
            }
            if(data1==="yes"){
                document.getElementById("msg").setAttribute("style","color: red")
                document.getElementById("msg").innerText = "username has already exist"
            }
            if(data1==="no"){
                document.getElementById("msg").setAttribute("style","color: blue")
                document.getElementById("msg").innerText = "username can be used"
            }
        });
    })
    function Ajax(method,url, data,fun){
        var xhr = new XMLHttpRequest()
        console.log(xhr.readyState)
        // => 0
        // 初始化 请求代理对象
        xhr.open(method, url)
        xhr.setRequestHeader("content-Type","application/x-www-form-urlencoded;charset=utf-8")
        console.log(xhr.readyState)
        // => 1
        // open 方法已经调用，建立一个与服务端特定端口的连接
        xhr.send(data)
        xhr.addEventListener('readystatechange', function ()
        {
            switch (this.readyState) {
                case 2:
// => 2
// 已经接受到了响应报文的响应头
// 可以拿到头
// console.log(this.getAllResponseHeaders())
                    console.log(this.getResponseHeader('server'))
// 但是还没有拿到体
                    console.log(this.responseText)
                    break
                case 3:
// => 3
// 正在下载响应报文的响应体，有可能响应体为空，也有可能不完整
// 在这里处理响应体不保险（不可靠）
                    console.log(this.responseText)
                    break
                case 4:
// => 4
// 一切 OK （整个响应报文已经完整下载下来了）
// 这里处理响应体
                    console.log(this.responseText)
                    fun(this.responseText);
                    break
            }
        })
    }
</script>


</body>
</html>
