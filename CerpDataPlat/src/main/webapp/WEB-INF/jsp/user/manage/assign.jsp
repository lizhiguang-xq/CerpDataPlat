<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <ol class="breadcrumb">
        <li><a href="#">首页</a></li>
        <li><a href="#">数据列表</a></li>
        <li class="active">分配角色</li>
    </ol>
    <div class="panel panel-default">
        <div class="panel-body">
            <form id="roleForm" role="form" class="form-inline">
                <input type="hidden" name="userid" value="${user.id}">
                <div class="form-group">
                    <label for="leftList">未分配角色列表</label><br>
                    <select id="leftList" name="unassignroleids" class="form-control" multiple size="10" style="width:300px;overflow-y:auto;">
                        <c:forEach items="${unassignedRoles}" var="role" varStatus="status">
                            <option value="${role.id}">${status.index+1}.${role.name}(${role.id})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <ul>
                        <li id="l2rBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                        <br>
                        <li id="r2lBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                    </ul>
                </div>
                <div class="form-group" style="margin-left:40px;">
                    <label for="rightList">已分配角色列表</label><br>
                    <select id="rightList" name="assignroleids" class="form-control" multiple size="10" style="width:300px;overflow-y:auto;">
                        <c:forEach items="${assignedRoles}" var="role" varStatus="status">
                            <option value="${role.id}">${status.index+1}.${role.name}(${role.id})</option>
                        </c:forEach>
                    </select>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {


        $("#l2rBtn").click(function () {
            var selItem = $("#leftList :selected");
            if(selItem.length == 0) {
                layer.msg("请选择需要分配的角色数据", {time:2000, icon:5, shift:6}, function(){});
            } else {

                $.ajax({
                    type : "POST",
                    url : "${APP_PATH}/user/manage/doAssign",
                    data : $("#roleForm").serialize(),
                    beforeSend : function () {
                        loadingIndex = layer.msg('处理中', {icon: 16});
                    },
                    success : function ( result ) {
                        layer.close(loadingIndex);
                        if (result.success) {
                            $("#rightList").append(selItem);
                            layer.msg("分配角色成功", {time:2000, icon:6}, function(){});
                        } else {
                            layer.msg("分配角色失败", {time:2000, icon:5, shift:6}, function(){});
                        }
                    }
                });
            }
        });

        $("#r2lBtn").click(function () {
            var selItem = $("#rightList :selected");
            if(selItem.length == 0) {
                layer.msg("请选择需要取消的角色数据", {time:2000, icon:5, shift:6}, function(){});
            } else {
                $.ajax({
                    type : "POST",
                    url : "${APP_PATH}/user/manage/undoAssign",
                    data : $("#roleForm").serialize(),
                    beforeSend : function () {
                        loadingIndex = layer.msg('处理中', {icon: 16});
                    },
                    success : function ( result ) {
                        layer.close(loadingIndex);
                        if (result.success) {
                            $("#leftList").append(selItem);
                            layer.msg("取消分配角色成功", {time:2000, icon:6}, function(){});
                        } else {
                            layer.msg("取消分配角色失败", {time:2000, icon:5, shift:6}, function(){});
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>

