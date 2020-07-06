<!DOCTYPE html>
<html>
 
    <head>
        <meta charset="UTF-8">
        <meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
        <title></title>
        <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="css/web.css">
        <!-- <link rel="stylesheet" type="text/css" href="easyUI/web.css"> -->
        <script type="text/javascript" src="easyUI/js/jquery.min.js"></script>
        <script type="text/javascript" src="easyUI/js/jquery.easyui.min.js"></script>
        
        <link rel="stylesheet" type="text/css" href="static/js/jqueryPagination/pagination.css"/>
		<link rel="stylesheet" type="text/css" href="static/css/style.css" />
    </head>
 
    <body class="childrenBody">
    	<div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${title}</div>
    	<div class="admin-content">
        	<blockquote class="admin-elem-quote admin-content-top">
				<span class="admin-inline">${pname}：</span>
				<input class="admin-input admin-inline" id="name" name="name" type="text" placeholder="${keyword}" />
				<a href="javascript:void(0)" id="search_btn" class="admin-btn admin-inline admin-btn-normal" data-options="iconCls:'icon-search'"><i class="icon iconfont">&#xe601;</i>${find}</a>
				<a class="admin-btn admin-inline" href="addProjectpage.do" target="adminFrameName"><i class="icon iconfont">&#xe621;</i>${new}</a>
			</blockquote>
        <div class="hr"></div>
        <table id="dg" style="width:auto;height:auto;" data-options="rownumbers:true,singleSelect:true,pagination:true,url:'getProjectByName.do',method:'get'" toolbar="#tb">
            <thead>
                <tr>
                    <!-- <th data-options="field:'id',width:200">${pid}</th> -->
                    <th data-options="field:'name',width:200">${pname}</th>
                    <!-- <th data-options="field:'watershedId'width:100,">${wid}</th> -->
                    <th data-options="field:'describe',width:200" width="40%">${description}</th>
                    <th data-options="field:'createTime',width:200">${time}</th>
                    <th data-options="field:'baseYear',width:100">${baseyear}</th>
                    <th data-options="field:'goalYear',width:100">${targetyear}</th>
                    <th data-options="field:'step',width:100">${step}</th>
                </tr>
            </thead>
        </table>
        <div id="tb">
            <a id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit();">${edit}</a>
            <a href="javascript:void(0)" id="deleteBtn" class="easyui-linkbutton" iconCls="icon-cut" plain="true">${delete}</a>
            <a href="javascript:void(0)" id="okBtn" class="easyui-linkbutton" iconCls="icon-ok" plain="true">${open}</a>
            <!-- <a href="javascript:void(0)" id="autoprojectBtn" class="easyui-linkbutton" iconCls="icon-redo" plain="true" >${sdp}</a> -->
        </div>
 		</div>
    </body>
 
    <script type="text/javascript">
        $(function() {
            var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
        })
 
        $("#search_btn").click(function() {
            var name = $("#name").val();
            $('#dg').datagrid('load', {
                name: name
            });
        })
        
        function edit(){
        	
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.get('projectedit.do', {
                    id: row.id
                }, function(data) {
                    //$.messager.alert('提示', data.content, 'info');
                  
                    window.location.href='jumpToProjectdedit.do';
                })
            } else {
                $.messager.alert('提示', "请选中一个项目", 'info');
            }
        }
 
        $("#deleteBtn").click(function() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.messager.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
                    if(data) {
                        $.post('deleteProject.do', {
                            id: row.id
                        }, function(data) {
                            $.messager.alert('提示', data.content, 'info');
                            $(".pagination-load").trigger("click");
                        })
                    } else {
 
                    }
                });
            } else {
                $.messager.alert('提示', "请选中要删除的行", 'info');
            }
        })
        
        /*
        $("#autoprojectBtn").click(function() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.get('autoproject.do', {
                    id: row.id
                }, function(data) {
                    $.messager.alert('提示', data.content, 'info');
                })
            } else {
                $.messager.alert('提示', "请选中一个项目", 'info');
            }
        })
        */
 
        $("#okBtn").click(function() {
            var row = $('#dg').datagrid('getSelected');
            //console.log("rowid"+row.id);
            if(row) {
            	//保存用户项目id
            	$.get('autoproject.do', {
                    id: row.id
                    window.alert(id)
                }, function(data) {
                    //$.messager.alert('提示', data.content, 'info');
                	//location.href = 'assess.do?id='+row.id;
                    location.href = 'assess.do';
                });
            } else {
                $.messager.alert('提示', "请选中要评价的项目", 'info');
            }
        })
    </script>
 
</html>