<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表展示页面</title>
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
	$(function(){
		$("#grid").datagrid({
			toolbar : [
				{
					id : 'add',
					text : '添加权限',
					iconCls : 'icon-add',
					handler : function(){
						location.href='${pageContext.request.contextPath}/admin/function_add';
					}
				},{
					id : 'delete',
					text : '删除权限',
					iconCls : 'icon-cancel',
					handler : doDelete
				}         
			],
			url : '/functionController_pageQuery',
			pagination : true,//分页条
			fit : true,//撑满
			//为数据表达绑定双击事件
			onDblClickRow : doDblClickRow,
			columns : [[
			  {
				  field : 'id',
				  title : '编号',
				  width : 200,
				  checkbox:true
			  },
			  {
				  field : 'name',
				  title : '名称',
				  width : 200
			  },  
			  {
				  field : 'description',
				  title : '描述',
				  width : 500
			  },  
			  {
				  field : 'generatemenu',
				  title : '是否生成菜单',
				  width : 50,
				  formatter : function(data, row, index){
					  if(data == "1"){
						  return "是";
					  }else{
						  return "否";
					  }
				  }
			  },  
			  {
				  field : 'zindex',
				  title : '优先级',
				  width : 50
			  },  
			  {
				  field : 'page',
				  title : '路径',
				  width : 200
			  }
			]]
		});
		
		// 修改取派员窗口
		$('#editFunctionWindow').window({
	        title: '修改权限数据',
	        width: 800,
	        modal: true,//遮罩效果
	        shadow: true,//阴影效果
	        closed: true,//默认关闭
	        height: 600,
	        resizable:false
	    });
	});
	
	//数据表格绑定的双击事件对应的函数
	function doDblClickRow(rowIndex, rowData){
		//alert("双击数据表格");
		//打开修改权限的窗口
		$('#editFunctionWindow').window("open");
		//使用form表单对象的load方法回显数据
		$('#editFunctionForm').form("load",rowData);
	}
	
	//删除操作的js代码
	function doDelete(){
		var items = $('#grid').datagrid('getSelections');
		if(items.length > 0){
			$.messager.confirm("提示窗口", "是否确认删除", function(r){
				if(r){
					var arr = new Array();
					for(var i=0; i<items.length; i++){
						arr.push(items[i].id);
					}
					
					var ids=arr.join(",");
                    $.post("/functionController_delete",{ids:ids},function(data){
                        $('#grid').datagrid('reload');
                    });
				}
			})
		}else{
			$.messager.alert("提示信息", "请选择数据", "warning");
		}
	}
</script>	
</head>
<body class="easyui-layout">
	<div data-options="region:'center'">
		<table id="grid"></table>
	</div>
	
	<!-- 修改权限管理窗口 -->
	<div class="easyui-window" title="对权限进行修改" id="editFunctionWindow" collapsible="false" 
		minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-edit" href="#" class="easyui-linkbutton" plain="true" >修改保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editFunctionForm" action="/userController_edit" method="post">
				<input type="hidden" name="id">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">功能权限信息</td>
					</tr>
					<tr>
						<td width="200">关键字</td>
						<td>
							<input type="text" name="code" class="easyui-validatebox" data-options="required:true" />						
						</td>
					</tr>
					<tr>
						<td>名称</td>
						<td><input type="text" name="name" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>访问路径</td>
						<td><input type="text" name="page"  /></td>
					</tr>
					<tr>
						<td>是否生成菜单</td>
						<td>
							<select name="generatemenu" class="easyui-combobox">
								<option value="0">不生成</option>
								<option value="1">生成</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>优先级</td>
						<td>
							<input type="text" name="zindex" class="easyui-numberbox" data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>父功能点</td>
						<td>
							<input name="pid" class="easyui-combobox" data-options="valueField:'id',textField:'name',url:'/functionController_listajax'"/>
						</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>
							<textarea name="description" rows="4" cols="60"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			//为保存按钮绑定事件
			$("#edit").click(function(){
				//表单校验，如果通过，提交表单
 				var v = $("#editFunctionForm").form("validate");
				if(v){
					$("#editFunctionForm").submit();
				}
			});
		});
	</script>
	
</body>
</html>