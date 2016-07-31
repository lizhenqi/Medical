<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
              <a href="/disease"> 病种列表</a>  /  修改疾病
            </span>
                </div>
                <div class="box-body form">
                    <form action="/disease/new" method="post">
                        <input type="hidden" name="id" value="${disease.id}">
                        <label>疾病名称</label>
                        <input type="text" name="entityname" value="${disease.entityname}">
                        <label>所属科室</label>
                        <select id="ks" name="dept.id" >
                            <option value=""></option>
                            <c:forEach items="${deptList}" var="depts">
                                <option value="${depts.id==disease.dept.id?"checked":''}">${depts.deptname}</option>
                            </c:forEach>
                        </select>

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