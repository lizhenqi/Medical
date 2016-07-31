<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!-- Main Header -->
<header class="main-header">
    <div class="navbar navbar-static-top">
        <div class="navbar-inner">
            <a class="brand" href="#">凯盛医疗</a>
            <ul class="nav">
                <li class="active" style="margin-left: 30px"><a href="/home"><i class="fa fa-home"></i> 首页</a></li>
                <li style="margin-left: 60px"><a href="/patient"><i class="fa fa-building"></i> 病人档案</a></li>

                <li style="margin-left: 60px"><a href="#"><i class="fa fa-stethoscope"></i>  就诊记录</a></li>
                <li style="margin-left: 60px"><a href="#"><i class="fa fa-bell-o"></i> 复诊提醒</a></li>
                <li style="margin-left: 60px"><a href="#"><i class="fa fa-bar-chart-o"></i> 数据统计</a></li>

               <%--管理员才能看--%>
                <shiro:hasRole name="管理员">
                   <li class="dropdown" style="margin-left: 60px">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-cogs"></i> 系统设置 <b class="caret"></b></a>
                       <ul class="dropdown-menu">
                           <li><a href="/dept"><i class="fa fa-sitemap"></i> 科室设置</a></li>
                           <li><a href="/disease"><i class="fa fa-medkit"></i> 病种设置</a></li>
                           <li><a href=""><i class="fa fa-bars"></i> 医保类型设置</a></li>
                           <li><a href=""><i class="fa fa-child"></i> 患者状态设置</a></li>
                           <li class="divider"></li>
                           <li><a href="/admin"><i class="fa fa-user-md"></i> 账号设置</a></li>
                       </ul>
                   </li>
               </shiro:hasRole>

                <li class="dropdown" style="margin-right: 0px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-cogs"></i> 个人设置 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/account/message">个人资料</a></li>
                        <li><a href="#">登录信息</a></li>
                        <li><a href="/account/password/">修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="/logOut">安全退出</a></li>
                    </ul>
                </li>

            </ul>

        </div>
    </div>

</header>

