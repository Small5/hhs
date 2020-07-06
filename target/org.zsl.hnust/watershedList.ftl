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
        <script type="text/javascript" src="easyUI/js/jquery.min.js"></script>
        <script type="text/javascript" src="easyUI/js/jquery.easyui.min.js"></script>
        
        <link rel="stylesheet" type="text/css" href="static/js/jqueryPagination/pagination.css"/>
		<link rel="stylesheet" type="text/css" href="static/css/style.css" />
    </head>
 
    <body class="childrenBody">
    	<div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${title}</div>
    	<div class="admin-content">
        	<blockquote class="admin-elem-quote admin-content-top">
				<span class="admin-inline">${basin}：</span>
				<input class="admin-input admin-inline" type="text" id="name" name="name" placeholder="${keyword}" />
				<a href="javascript:void(0)" id="search_btn" class="admin-btn admin-inline admin-btn-normal" data-options="iconCls:'icon-search'"><i class="icon iconfont">&#xe601;</i>${find}</a>
				<a class="admin-btn admin-inline" href="addwatershedpage.do" target="adminFrameName"><i class="icon iconfont">&#xe621;</i>${new}</a>
			</blockquote>
        <div class="hr"></div>
        <table id="dg" style="width:auto;height:auto;" data-options="url:'getWatershedByName.do',method:'get'" toolbar="#tb">
            <thead>
                <tr>
                    <th data-options="field:'id',width:200">${basinid}</th>
                    <th data-options="field:'name',width:200">${basin}</th>
                    <th data-options="field:'describe',width:700">${description}</th>
                </tr>
            </thead>
        </>
        <div id="tb">
        <a id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit();">${edit}</a>
        <a href="javascript:void(0)" id="deleteBtn" class="easyui-linkbutton" iconCls="icon-cut" plain="true" >${delete}</a>
        <a href="javascript:void(0)" id="autowatershedBtn" class="easyui-linkbutton" iconCls="icon-redo" plain="true" >${sdb}</a>
    </div>
 	</div>
    </body>
 
    <script type="text/javascript">
        $(function() {
            var pager = $('#dg').datagrid().datagrid('getPager');
        })
        
                
        $("#search_btn").click(function(){
            var name = $("#name").val();
            $('#dg').datagrid('load',{
                name: name
            });
        })
        
        function edit(){
        	var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.get('watershededit.do', {
                    id: row.id
                }, function(data) {
                    //$.messager.alert('提示', data.content, 'info');
                    
                    window.location.href='jumpToWatershededit.do';
                })
            } else {
                $.messager.alert('提示', "请选中一个流域", 'info');
            }
        }
        //$("#editBtn").onclick(function() {
        //	console.log("已响应");
        	/*
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.post('Watershededit.do', {
                    id: row.id
                }, function(data) {
                    //$.messager.alert('提示', data.content, 'info');
                    console.log("成功");
                    //window.location.href='jumpToWatershededit.do';
                })
            } else {
                $.messager.alert('提示', "请选中一个流域", 'info');
            }
        })*/
        
        
        $("#deleteBtn").click(function(){
            var row = $('#dg').datagrid('getSelected');
            
            if (row) {
                $.messager.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
                    if (data) {
                        $.get('deleteWatershed.do', {
                            id : row.id
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
        $("#autowatershedBtn").click(function() {
            var row = $('#dg').datagrid('getSelected');
            if(row) {
                $.get('autowatershed.do', {
                    id: row.id
                }, function(data) {
                    $.messager.alert('提示', data.content, 'info');
                  	//刷新父页面，即home.do
                    //parent.location.reload( ); 
                })
            } else {
                $.messager.alert('提示', "请选中一个流域", 'info');
            }
        })
        
    </script>
    
</html>
