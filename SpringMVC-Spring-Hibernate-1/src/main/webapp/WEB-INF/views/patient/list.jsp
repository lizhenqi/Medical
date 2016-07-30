<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                    <span class="title">搜索</span>
                </div>
                <div class="box-body search-box">
                    <form action="" class="form-search">
                        <input type="text" placeholder="姓名">
                        <input type="text" placeholder="身份证号">
                        <input type="text" placeholder="电话">
                        <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
                    </form>
                </div>
            </div>

            <%----------------------------------------------------------------------------%>
            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-building"></i> 患者列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/patient/new"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="20">
                                <input type="checkbox" name="">
                            </th>
                            <th width="100">姓名</th>
                            <th width="100">性别</th>
                            <th width="150">电话</th>
                            <th width="200">医保类型</th>
                            <th>地址</th>
                            <th width="50">状态</th>
                            <th width="140">创建日期</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${patients}" var="pat">
                            <tr>
                                <td>
                                    <input type="checkbox" name="" id="">
                                </td>
                                <td><a href="/patient/edit/${pat.id}">${pat.name}</a></td>
                                <td>${pat.sex}</td>
                                <td>${pat.phonenumber}</td>
                                <td>${pat.insurance.insurancename}</td>
                                <td>${pat.address}</td>
                                <td>在诊</td>
                                <td>${pat.createtime}</td>
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

</body>
</html>