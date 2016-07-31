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
                <div class="box-header" style="text-align: center">
                    <ul class="unstyled inline ">
                        <li><a href="/admin/new"><i class="fa fa-plus"></i> 个人信息</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tr>
                            <th style="width: 160px;color:blue">账号:</th>
                            <th style="color: red">${account.username}</th>
                        </tr><tr>
                            <th style="width: 160px;color:blue">姓名:</th>
                            <th style="color: red">${account.accountname}</th>
                        </tr>
                        <tr>
                            <th>联系电话:</th>
                            <th style="color: red">${account.phonenumber}</th>
                        </tr>
                        <tr>
                            <th>角色:</th>
                            <th style="color: red">${account.role.rolename}</th>
                        </tr>


                    </table>
                </div>

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