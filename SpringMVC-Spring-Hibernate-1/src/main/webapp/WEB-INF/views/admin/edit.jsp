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

<%@include file="../include/header.jsp"%>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/admin"> 系统账户列表</a>  /  修改账号
            </span>
                </div>
                <div class="box-body form">
                    <form action="/admin/new" method="post">
                        <input type="hidden" name="id" value="${account.id}">
                        <label>真实姓名</label>
                        <input type="text" name="accountname" value="${account.accountname}">
                        <label>账号 <span class="muted">(用于登录系统)</span></label>
                        <input type="text" name="username" value="${account.username}">
                        <label>密码 <span class="muted"></span></label>
                        <input type="password" value="${account.password}" name="password">
                        <label>联系电话</label>
                        <input type="text" name="phonenumber" value="${account.password}">
                        <label>请选择角色</label>
                        <select name="role.id">
                            <option value="1" ${account.role.id==1?"checked":''}>管理员</option>
                            <option value="2" ${account.role.id==2?'checked':''}>普通员工</option>
                        </select>

                        <div class="form-group">
                            <label>状态</label>
                            <select class="form-control" name="enable" >
                                <option value="1" ${account.role.id==1?"checked":''}>正常</option>
                                <option value="0" ${account.role.id==0?"checked":''}>禁用</option>
                            </select>
                        </div>

                        <div class="form-actions">
                            <button class="button button-flat-action button-pill">保存</button>
                        </div>
                    </form>
                </div>
            </div>


        </div>

    </div>
</div>

<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.js"></script>

</body>
</html>