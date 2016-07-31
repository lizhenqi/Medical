<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试</title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/style.css">
</head>
<body>

<%@include file="../include/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-user-md"></i> 系统账号列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/admin/new"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">账户名称</th>
                            <th width="200">员工姓名</th>
                            <th>电话</th>
                            <th>最后登录时间</th>
                            <th>最后登录IP</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${accountList}" var="accounts">
                            <tr>
                                <td>${accounts.username}</td>
                                <td>${accounts.accountname}</td>
                                <td>${accounts.phonenumber}</td>
                                <td>TODO</td>
                                <td>TODO</td>
                                <td>

                                    <a href="/admin/edit/${accounts.id}">修改</a>


                                    <c:choose>
                                        <c:when test="${accounts.enable==true}">
                                            <a href="#"><span class='label label-success'>正常</span></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="#"><span class='label label-danger'style="color: #ffa489">禁用</span></a>
                                        </c:otherwise>
                                    </c:choose>

                                    <a href="javascript:;" data="${accounts.id}" class="delBtn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>


        </div>

    </div>
</div>

<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.js"></script>
<script>
    <%--确认删除--%>
    $(function () {
        $(".delBtn").click(function () {
            if (confirm("您确定要删除？")) {
                var id = $(this).attr("data");
                window.location.href = "/admin/del/" + id;
            }
        })


    })

</script>
</body>
</html>