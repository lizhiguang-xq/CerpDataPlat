<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        table tbody tr:nth-child(odd){background:#F4F4F4;}
        table tbody td:nth-child(even){color:#C00;}
    </style>
</head>

<body>


<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i>用户数据列表</h3>
        </div>
        <div class="panel-body">
            <form class="form-inline" role="form" style="float:left;">
                <div class="form-group has-feedback">
                    <div class="input-group">
                        <div class="input-group-addon">查询条件</div>
                        <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件(用户名,独立单元ID)">
                    </div>
                </div>
                <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
            </form>
            <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
            <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/user/manage/add'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
            <br>
            <hr style="clear:both;">
            <div class="table-responsive">
                <table class="table  table-bordered">
                    <thead>
                    <tr >
                        <th width="30">#</th>
                        <th width="30"><input type="checkbox"></th>
                        <th>用户ID</th>
                        <th>用户名</th>
                        <th>独立单元ID</th>
                        <th>接口权限</th>
                        <th width="100">操作</th>
                    </tr>
                    </thead>
                    <tbody id="userData">

                    </tbody>
                    <tfoot>
                        <tr >
                            <td colspan="7" align="center">
                                <ul class="pagination">

                                </ul>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/layer/layer.js"></script>
<script type="text/javascript">
    var likeflg = false;
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

        queryPage(1);

        $("#queryBtn").click(function(){
            var queryText = $("#queryText").val();
            if(queryText==""){
                likeflg = false;
            }else {
                likeflg = true;
            }
            queryPage(1);
        })
    });
    $("tbody .btn-success").click(function(){
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function(){
        window.location.href = "edit.html";
    });

    function queryPage(pageno) {
        var loadingIndex = null;
        var jsonData = {"pageno" : pageno, "pagesize" : 2 };
        if(likeflg == true) {
            jsonData.queryText = $("#queryText").val();
        }
        $.ajax({
            type : "POST",
            url : "${APP_PATH}/user/manage/queryPage",
            data : jsonData,
            beforeSend : function() {
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success : function (result) {
                layer.close(loadingIndex);
                if(result.success) {
                    //渲染分页数据
                    var tableContent="";
                    var pageContent="";

                    var userPage = result.data1;
                    var users = userPage.datas;
                    var totalpageno = userPage.totalpageno;

                    $.each(users, function(i, user) {
                        tableContent+='<tr>';
                        tableContent+='<td>'+(i+1)+'</td>';
                        tableContent+='<td><input type="checkbox"></td>';
                        tableContent+='    <td>'+user.id+'</td>';
                        tableContent+='    <td>'+user.user_name+'</td>';
                        tableContent+='    <td>'+user.entryid+'</td>';
                        tableContent+='    <td>'+user.opers+'</td>';
                        tableContent+='    <td>';
                        // tableContent+='    <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                        tableContent+='<button type="button" onclick="toEditPage('+user.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>    ';
                        tableContent+='<button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                        tableContent+='</td>';
                        tableContent+='</tr>';
                    });

                    if(pageno==1) {
                        pageContent+='<li class=\"disabled\"><a href=\"#\">上一页</a></li>';
                    } else {
                        pageContent+='<li><a href="#" onclick="queryPage('+(pageno-1)+')">上一页</a></li>';
                    }

                    for(var i=1; i<=totalpageno; i++) {
                        if(i==pageno) {
                            pageContent+='<li class="active"><a href="#">'+i+'<span class="sr-only">(current)</span></a></li>';
                        } else {
                            pageContent+='<li><a href="#" onclick="queryPage('+i+')">'+i+'</a></li>';
                        }
                    }

                    if(pageno==totalpageno) {
                        pageContent+='<li class=\"disabled\"><a href=\"#\">下一页</a></li>';
                    } else {
                        pageContent+='<li><a href="#" onclick="queryPage('+(pageno+1)+')">下一页</a></li>';
                    }

                    $("#userData").html(tableContent);
                    $(".pagination").html(pageContent);

                } else {
                    layer.msg("用户分页信息查询失败", {time:2000, icon:5, shift:6}, function(){});
                }
            }
        });
    }

    function toEditPage(id) {
        window.location.href = "${APP_PATH}/user/manage/editUser?id="+id;
    }
</script>
</body>
</html>

