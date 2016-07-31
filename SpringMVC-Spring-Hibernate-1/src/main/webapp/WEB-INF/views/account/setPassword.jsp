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
              <a href="#"> 个人信息</a>  /  修改密码
            </span>
                </div>
                <div class="box-body form">

                    <form method="post" id="changePasswordForm">
                                <label >旧密码</label>
                                <input type="password"   placeholder="请输入旧密码" name="oldPassword" autofocus>

                                <label >新密码</label>
                                <input type="password"   placeholder="请输入新密码" name="newPassword" id="idnewPassword">
                                <label >确认密码</label>
                                <input type="password"   placeholder="请确认密码" name="replyPassword">

                        <div class="form-actions">
                            <button id="saveBtn" class="button button-flat-action button-pill">保存</button>
                        </div>
                    </form>

                </div>
            </div>


        </div>

    </div>
</div>
<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.js"></script>
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/validata/jquery.validate.min.js"></script>


<script>


    $("#saveBtn").click(function(){
        $("#changePasswordForm").submit();
    });

    //    验证
    $("#changePasswordForm").validate({
        errorClass:"text-danger",
        errorElement:"span",
        rules:{
            oldPassword:{
                required:true,
                remote:"/account/validate/password"
//                验证旧密码
            },newPassword:{
                required:true,
                rangelength:[3,18]
            },replyPassword:{
                required:true,
                rangelength:[3,18],
                equalTo:"#idnewPassword"
//                注意是：#id
            }
        },
        messages:{
            oldPassword:{
                required:"请输入旧密码",
                remote:"旧密码错误"
            },newPassword:{
                required:"请输入新密码",
                rangelength:"密码长度3~18位"
            },replyPassword:{
                required:"请确认密码",
                rangelength:"密码长度3~18位",
                equalTo:"两次密码不一致"
            }
        },
        submitHandler:function(form){
            var password=$("#idnewPassword").val();
            $.post("/account/password",{"password":password})
                    .done(function(data){
                        if(data=="success"){
                            alert("密码修改成功，请重新登录！");
                            window.location.href="/login";
                        }
                    })
                    .fail(function(){
                        alert("修改密码异常！")
                    });
        }
    });


</script>


</body>
</html>