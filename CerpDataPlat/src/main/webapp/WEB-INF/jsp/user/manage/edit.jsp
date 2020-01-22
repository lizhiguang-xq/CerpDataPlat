<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
    <link rel="stylesheet" href="${APP_PATH}/css/doc.min.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
    </style>
</head>

<body>

<div class="container-fluid">
    <div>
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
            <li><a href="#">数据列表</a></li>
            <li class="active">修改</li>
        </ol>
        <div class="panel panel-default">
            <div class="panel-heading">修改用户
                <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i>
                </div>
            </div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" class="form-control" id="txtusername" value="${user.user_name}" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label>用户密码</label>
                        <input type="text" class="form-control" id="txtpassword" value="${user.password}" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <label>独立单元ID</label>
                        <input type="text" class="form-control" id="txtentryid" value="${user.entryid}" placeholder="请输入独立单元ID">
                    </div>
                    <div class="form-group">
                        <label>接口权限</label>
                        <input type="text" class="form-control" id="txtopers" value="${user.opers}" placeholder="请输入接口权限">
                    </div>
                    <button id="updateBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 修改</button>
                    <button type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<%--<script src="${APP_PATH}/script/docs.min.js"></script>--%>
<script src="${APP_PATH}/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        // $(".list-group-item").click(function(){
        //     if ( $(this).find("ul") ) {
        //         $(this).toggleClass("tree-closed");
        //         if ( $(this).hasClass("tree-closed") ) {
        //             $("ul", this).hide("fast");
        //         } else {
        //             $("ul", this).show("fast");
        //         }
        //     }
        // });
        $("#updateBtn").click(function(){
            var loadingIndex = null;
            var txtusername = $("#txtusername").val();
            var txtpassword = $("#txtpassword").val();
            var txtentryid = $("#txtentryid").val();
            var txtopers = $("#txtopers").val();
            var txtid = ${user.id};
            if(txtusername == "") {
                layer.msg("用户名不能为空", {time:2000, icon:5, shift:6}, function(){});
                return;
            }
            if(txtpassword=="") {
                layer.msg("密码不能为空", {time:2000, icon:5, shift:6}, function(){});
                return;
            }
            if(txtentryid=="") {
                layer.msg("独立单元ID不能为空", {time:2000, icon:5, shift:6}, function(){});
                return;
            }
            if(txtid=="") {
                layer.msg("ID为空, 无法更新", {time:2000, icon:5, shift:6}, function(){});
                return;
            }

            $.ajax({
                type : "POST",
                url : "${APP_PATH}/user/manage/updateUser",
                data : {
                    "user_name" : txtusername,
                    "password" : txtpassword,
                    "entryid" : txtentryid,
                    "opers" : txtopers,
                    "id" : txtid
                },
                beforeSend : function() {
                    loadingIndex = layer.msg('处理中', {icon: 16});
                },
                success : function(result) {
                    layer.close(loadingIndex);
                    if(result.success) {
                        layer.msg('用户信息更新成功', {time:2000, icon:1, shift:1}, function(){});
                        <%--window.location.href = "${APP_PATH}/user/manage/index";--%>
                    } else {
                        layer.msg("用户信息更新失败", {time:2000, icon:5, shift:6}, function(){});
                    }
                }

            });
        });

    });
</script>
</body>
</html>
