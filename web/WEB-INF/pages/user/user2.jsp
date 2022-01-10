<%--
  User: bassomillo
  Date: 2022/1/7
  Time: 11:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<h1 style="text-align: center;height: 100px;line-height: 100px">
    user management system
</h1>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>id</td>
                    <td>profile</td>
                    <td>username</td>
                    <td>deptId</td>
                    <td>operate</td>
                </tr>

                </thead>
                <tbody id="data">

                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><button class="page-link">1</button></li>
                    <li><button class="page-link">2</button></li>

                </ul>
            </nav>
        </div>
        <div class="col-md-2"></div>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(function (){
        initTable("user2");
    })
    $(".page-link").click(function (){
        let currentPage = $(this).html()
        initTable("user2?currentPage="+currentPage)
    })
    function initTable(url){
        $.post(url,function (data){
            let users = data.data;
            let html = ""
            for(let user of users){
                html += "<tr><td>"+user.id+"</td>"+
                    "<td><img width='40px' src='"+user.profile+"'></td>"+
                    "<td>"+user.username+"</td>"+
                    "<td>"+user.deptName+"</td>"+
                    "<td>"+"<button data-id='"+user.id+"' type='button' class='delete btn btn-primary'>delete</button>"+
                    "<a href='user/update?id="+user.id+"' type='button' class='modify btn btn-primary'>modify</a>"+"</td></tr>"
            }
            $('#data').empty().html(html)
        })
    }



</script>
</body>
</html>
