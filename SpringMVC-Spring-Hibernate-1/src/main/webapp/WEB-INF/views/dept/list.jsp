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
                    <span class="title"><i class="fa fa-sitemap"></i> 科室列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="new-dept.html"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">科室名称</th>
                            <th width="200">负责人</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>内科</th>
                            <th>张晓明</th>
                            <th>
                                <a href="">修改</a>
                                <a href="#">删除</a>
                            </th>
                        </tr>
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