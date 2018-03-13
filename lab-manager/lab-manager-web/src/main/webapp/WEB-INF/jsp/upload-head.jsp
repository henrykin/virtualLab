<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传web聊天室的个人头像</title>
<!-- web聊天室引入的文件  开始 -->
<link rel="stylesheet" href="${ctx}/static/plugins/amaze/css/amazeui.min.css">
<link rel="stylesheet" href="${ctx}/static/plugins/amaze/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/plugins/contextjs/css/context.standalone.css">
<script src="${ctx}/static/plugins/jquery/jquery-2.1.4.min.js"></script>
<script src="${ctx}/static/plugins/amaze/js/amazeui.min.js"></script>
<script src="${ctx}/static/plugins/amaze/js/app.js"></script>
<script src="${ctx}/static/plugins/layer/layer.js"></script>
<script src="${ctx}/static/plugins/laypage/laypage.js"></script>
<script src="${ctx}/static/plugins/contextjs/js/context.js"></script>
<script>
    var path = '${ctx}';
</script>
<script src="${ctx}/static/plugins/sockjs/sockjs.js"></script>
<!-- web聊天室引入的文件  结束 -->
</head>
<body>
	<div class="am-cf admin-main">
		<!-- content start -->
    	<div class="admin-content">
    		<div class="am-cf am-padding">
            	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人设置</strong> / <small>form</small></div>
        	</div>
        	<div class="am-tabs am-margin" data-am-tabs>
        		<ul class="am-tabs-nav am-nav am-nav-tabs">
                	<!-- <li class="am-active"><a href="#tab1">修改头像</a></li> -->
                	<li><a href="#tab2">修改头像</a></li>
            	</ul>
            	<div class="am-tabs-bd">
            		<div class="am-tab-panel am-fade" id="tab2">
	                    <form class="am-form am-form-horizontal" action="${ctx}/${userid}/upload" enctype="multipart/form-data" method="post" onsubmit="return checkFileType();" style="text-align: center;">
	                        <div style="text-align: center;margin-bottom: 10px">
	                            <img class="am-circle" src="${ctx}/${loginUser.profilehead}" width="140" height="140" alt="Amayadream"/>
	                        </div>
	                        <div class="am-form-group am-form-file">
	                            <button type="button" class="am-btn am-btn-secondary am-btn-sm">
	                                <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
	                            <input id="file" type="file" name="file">
	                        </div>
	                        <div id="file-list"></div>
	                        <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-upload"></span> 上传头像</button>
	                        <script>
	                            $(function() {
	                                $('#file').on('change', function() {
	                                    var fileNames = '';
	                                    $.each(this.files, function() {
	                                        fileNames += '<span class="am-badge">' + this.name + '</span> ';
	                                    });
	                                    $('#file-list').html(fileNames);
	                                });
	                            });
	                        </script>
	                    </form>
                	</div>
                	
            	</div>
        	</div>
        	
    	</div>
	</div>
	<script type="text/javascript">
		if("${message}"){
	        layer.msg('${message}', {
	            offset: 0,
	        });
	    }
		if("${error}"){
	        layer.msg('${error}', {
	            offset: 0,
	            shift: 6
	        });
	    }
		
		function checkFileType(){
	        var format = ["bmp","jpg","gif","png"];
	        var filename = $("#file").val();
	        var ext = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
	        if(jQuery.inArray(ext, format) != -1){
	            return true;
	        }else{
	            layer.msg('头像格式只能是bmp,jpg,gif,png!', {
	                offset: 0,
	                shift: 6
	            });
	            return false;
	        }
	    }
	</script>
</body>
</html>