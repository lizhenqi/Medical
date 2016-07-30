<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/style.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue-light.min.css">
    <link rel="stylesheet" href="/static/plugins/simditor/styles/simditor.css">
</head>
<body>

<%@include file="../include/header.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="patient-list.html"> 患者列表</a>  /  新增患者
            </span>
                </div>
                <div class="box-body form">
                    <form action="/patient/new" method="post" id="new">

                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" name="name">
                        </div>

                        <label>性别</label>
                        <select name="sex" id="">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>

                        <label>身份证号</label>
                        <input type="text" name="idnumber">
                        <label>年龄</label>
                        <input type="text" name="age">
                        <label>电话</label>
                        <input type="text" name="phonenumber">

                        <label>医保类型</label>
                        <select name="insurance.id">
                            <c:forEach items="${insurances}" var="ins">
                                <option value="${ins.id}">${ins.insurancename}</option>
                            </c:forEach>
                        </select>

                        <div class="form-group" id="allergy">
                            <label>过敏史</label>
                            <textarea name="context" id="context" rows="10" class="form-control"> </textarea>
                        </div>
                        <div class="form-group" id="comment">
                            <label>备注</label>
                            <textarea name="remark" id="remark" rows="10" class="form-control"> </textarea>
                        </div>
                        <button class="btn bg-primary">保存</button>
                    </form>
                </div>
            </div>


        </div>

    </div>
</div>


<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.js"></script>
<script src="/static/plugins/simditor/scripts/module.min.js"></script>
<script src="/static/plugins/simditor/scripts/hotkeys.min.js"></script>
<script src="/static/plugins/simditor/scripts/uploader.min.js"></script>
<script src="/static/plugins/simditor/scripts/simditor.min.js"></script>
<script src="/static/plugins/validata/jquery.validate.min.js"></script>

<script>
    $(function () {
        var context = new Simditor({
            textarea: $("#context"),

        })
        var remark = new Simditor({
            textarea: $("#remark")
        })

        $("#new").validate({
            errorClass: "text-danger",
            errorElement: "span",
            rules: {
                name: {
                    required: true
                },
                tel: {
                    required: true,
                    digits: true
                },
                idnumber: {
                    required: true,
                    digits: true
                },
                age: {
                    required: true,
                    digits: true

                },
                phonenumber: {
                    required: true,
                    digits: true
                }

            },
            messages: {
                name: {
                    required: "请输入病患名称"
                },
                tel: {
                    required: "请输入联系电话",
                    digits: "请输入数字"
                },
                idnumber: {
                    required: "请输入身份证号",
                    digits: "请输入数字"
                },
                age: {
                    required: "请输入病人年龄",
                    digits: "请输入数字"
                },
                phonenumber: {
                    required: "请输入病人电话",
                    digits: "请输入数字"
                }
            },
        })


    });
</script>

</body>
</html>