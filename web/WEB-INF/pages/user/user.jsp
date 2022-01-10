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
                    <td>username</td>
                    <td>profile</td>
                    <td>deptId</td>
                    <td>operate</td>
                </tr>

                </thead>
                <c:forEach items="${requestScope.userList}" var="userList">
                    <tr>
                        <td>${userList.id}</td>
                        <td>${userList.username}</td>
                        <td><img width="40px" src="${userList.profile}"></td>
                        <td>${userList.deptName}</td>
                        <td>
                            <button data-id="${userList.id}" type="button" class="delete btn btn-primary">delete</button>
                            <a href="user/update?id=${userList.id}" type="button" class="modify btn btn-primary">modify</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="user?currentPage=${requestScope.currentPage-1<1?1:requestScope.currentPage-1}&pageSize=2" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" step="1" end="${requestScope.totalPage}" var="page">
                        <li><a href="user?currentPage=${page}&pageSize=${requestScope.pageSize}">${page}</a></li>
                    </c:forEach>
                    <li>
                        <a href="user?currentPage=${requestScope.currentPage+1>requestScope.totalPage?requestScope.totalPage:requestScope.currentPage+1}&pageSize=2" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-2"></div>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(".delete").click(function () {
        let id = $(this).attr("data-id");
        $.get("user/delete?id=" + id, function () {
            location.href = "user";
        })
    })
</script>
</body>
</html>
