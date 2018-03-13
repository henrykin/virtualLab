<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表界面</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	// 工具栏
	/* var toolbar = [ {
		id : 'button-view',	
		text : '查看',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '新增',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	}]; */
	//定义冻结列
	var frozenColumns = [ [ {
		field : 'id',
		checkbox : true,
		rowspan : 2
	}, {
		field : 'username',
		title : '名称',
		width : 80,
		rowspan : 2
	} ] ];


	// 定义标题栏
	var columns = [ [ {
		field : 'phone',
		title : '电话',
		width : 120,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'roleNames',
		title : '对应角色',
		width : 800,
		rowspan : 2
	} ] ];
	$(function(){
		// 初始化 datagrid
		// 创建grid
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			toolbar : toolbar,
			url : "/userController_pageQuery",
			pagination:true,
			fit:true,
			idField : 'id', 
			frozenColumns : frozenColumns,
			columns : columns,
			onClickRow : onClickRow,
			//为数据表格绑定双击事件
			onDblClickRow : doDblClickRow
		});
		
		$("body").css({visibility:"visible"});
		
		// 修改取派员窗口
		$('#addUserWindow').window({
	        title: '修改用户权限',
	        width: 400,
	        modal: true,//遮罩效果
	        shadow: true,//阴影效果
	        closed: true,//默认关闭
	        height: 400,
	        resizable:false
	    });
		
	});
	//数据表格绑定的双击行事件对应的函数--双击
	function doDblClickRow(rowIndex, rowData) {
		//alert("双击表格数据");
		//打开添加用户权限的窗口
		$('#addUserWindow').window("open");
		//alert(rowData.username);
		//使用form表单对象的load方法回显数据
		$("#addUserForm").form("load",rowData);
	}
	
	// 单击
	function onClickRow(rowIndex){

	}
	
	function doAdd() {
		//alert("添加用户");
		//$('#addUserWindow').window("open");
	}

	function doView() {
		//alert("编辑用户");
		var item = $('#grid').datagrid('getSelected');
		console.info(item);
		//window.location.href = "edit.html";
	}

	function doDelete() {
		alert("删除用户");
		var ids = [];
		var items = $('#grid').datagrid('getSelections');
		for(var i=0; i<items.length; i++){
		    ids.push(items[i].id);	    
		}
			
		console.info(ids.join(","));
		
		$('#grid').datagrid('reload');
		$('#grid').datagrid('uncheckAll');
	}
	
</script>		
</head>
<body class="easyui-layout" style="visibility:hidden;">
    <div region="center" border="false">
    	<table id="grid"></table>
	</div>
	
	<!-- 修改用户权限管理窗口 -->
	<div class="easyui-window" title="对用户权限添加" id="addUserWindow" collapsible="false" 
		minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addUserForm" action="/userController_add" method="post">
				<input type="hidden" name="id">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">用户基本信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="username" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
	           			<td>选择角色:</td>
	           			<td colspan="3" id="roleTD">
	           			<script type="text/javascript">
	           				$(function(){
	           					//页面加载完成后，发送ajax请求，获取所有的角色数据
	           					$.post('/roleController_listajax',function(data){
	           						//alert(data);
	           						//在ajax回调函数中，解析json数据，展示为checkbox
	           						for(var i=0;i<data.length;i++){
	           							var id = data[i].id;
	           							var name = data[i].name;
	           							$('#roleTD').append('<input id="'+ id +'" type="checkbox" name="roleIds" value="'+ id+'"><label for="'+id+'">'+ name+'</label>');
	           						}
	           					});
	           				});
	           				</script>
	           				</td>
	           			</tr>
					</table>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			//为保存按钮绑定事件
			$("#save").click(function(){
				//表单校验，如果通过，提交表单
 				var v = $("#addUserForm").form("validate");
				if(v){
					$("#addUserForm").submit();
				}
			});
		});
	</script>
</body>
</html>