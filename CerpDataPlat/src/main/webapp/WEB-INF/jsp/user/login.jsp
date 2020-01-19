<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="/CerpDataPlat/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CerpDataPlat/css/font-awesome.min.css">
    <link rel="stylesheet" href="/CerpDataPlat/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">TASLY-CERP系统接口平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form id="loginForm" action="doLogin" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="user_name" id="user_name" name="user_name" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <%--<div class="form-group has-success has-feedback">--%>
            <%--<select class="form-control" >--%>
                <%--<option value="member">会员</option>--%>
                <%--<option value="user">管理</option>--%>
            <%--</select>--%>
        <%--</div>--%>
        <%--<div class="checkbox">--%>
            <%--<label>--%>
                <%--<input type="checkbox" value="remember-me"> 记住我--%>
            <%--</label>--%>
            <%--<br>--%>
            <%--<label>--%>
                <%--忘记密码--%>
            <%--</label>--%>
            <%--<label style="float:right">--%>
                <%--<a href="reg.html">我要注册</a>--%>
            <%--</label>--%>
        <%--</div>--%>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="/CerpDataPlat/jquery/jquery-2.1.1.min.js"></script>
<script src="/CerpDataPlat/bootstrap/js/bootstrap.min.js"></script>
<script src="/CerpDataPlat/layer/layer.js"></script>
<script>
    function dologin() {
        var user_name = $("#user_name").val();
        if(user_name==""){
            layer.msg("用户名不能为空", {time:2000, icon:5, shift:6}, function(){});
            return;
        }
        var password = $("#password").val();
        if(password==""){
            layer.msg("密码不能为空", {time:2000, icon:5, shift:6}, function(){});
            return;
        }
        // $("#loginForm").submit();
        var loadingIndex = null;
        $.ajax({
            type : "POST",
            url : "doAjaxLogin",
            data : {
                "user_name" : user_name,
                "password" : password
            },
            beforeSend : function(){
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success : function(result){
                layer.close(loadingIndex);
                if(result.success) {
                    window.location.href="/CerpDataPlat/quartz/listJob";
                } else {
                    layer.msg("用户登陆失败 用户名或密码错误", {time:2000, icon:5, shift:6}, function(){});

                }
            }

        });

    }
</script>
</body>
</html>