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
            <li class="active">新增</li>
        </ol>
        <div class="panel panel-default">
            <div class="panel-heading">新增角色
                <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i>
                </div>
            </div>
            <div class="panel-body">
                <form id="roleForm" role="form">
                    <div class="form-group">
                        <label>角色名</label>
                        <input type="text" class="form-control" id="txtrolename" placeholder="请输入角色名">
                    </div>
                    
                    <div class="form-group">
                        <label>角色说明</label>
                        <input type="text" class="form-control" id="txtcomment" placeholder="请输入角色说明">
                    </div>
                    <button id="insertBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <button id="resetBtn" type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 清空</button>
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
        $("#insertBtn").click(function(){
            var loadingIndex = null;
            var txtrolename = $("#txtrolename").val();
            var txtcomment = $("#txtcomment").val();
            if(txtrolename == "") {
                layer.msg("角色名不能为空", {time:2000, icon:5, shift:6}, function(){});
                return;
            }

            $.ajax({
                type : "POST",
                url : "${APP_PATH}/role/insertRole",
                data : {
                    "name" : txtrolename,
                    "comment" : txtcomment
                },
                beforeSend : function() {
                    loadingIndex = layer.msg('处理中', {icon: 16});
                },
                success : function(result) {
                    layer.close(loadingIndex);
                    if(result.success) {
                        // layer.msg('角色信息保存成功', {time:2000, icon:5, shift:6}, function(){});
                        window.location.href = "${APP_PATH}/role/index";
                    } else {
                        layer.msg("角色信息保存失败", {time:2000, icon:5, shift:6}, function(){});
                    }
                }

            });
        });

        $("#resetBtn").click(function(){
            $("#roleForm")[0].reset();
        })

    });
</script>
</body>
</html>
