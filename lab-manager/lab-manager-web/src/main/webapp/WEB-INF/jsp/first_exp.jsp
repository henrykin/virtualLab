<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Unity WebGL Player | example1</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/exps/first_exp/TemplateData/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/exps/first_exp/TemplateData/style.css">
    <script src="${pageContext.request.contextPath }/exps/first_exp/TemplateData/UnityProgress.js"></script>  
    <script src="${pageContext.request.contextPath }/exps/first_exp/Build/UnityLoader.js"></script>
    <script>
      var gameInstance = UnityLoader.instantiate("gameContainer", "/exps/first_exp/Build/lessons.json", {onProgress: UnityProgress});
    </script>
    
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
    <div class="webgl-content" style="border:1px solid red;margin-top: 600px">
     <div id="gameContainer" style="width: 960px; height: 600px;"></div>
      <div class="footerUnity3d">
        <div class="webgl-logo"></div>
        <div class="fullscreenUnity3d" onclick="gameInstance.SetFullscreen(1)"></div>
        <div class="titleUnity3d">example1</div>
      </div>
      
      <!-- web聊天室页面部分 开始位置 -->
      <div style="width:960px;height: 630px;border: 1px solid green;">
    	
		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="" style="width: 80%;float:left;border: 1px solid black;">
					<!-- 聊天区 -->
		            <div class="am-scrollable-vertical" id="chat-view" style="height: 450px;">
		                <ul class="am-comments-list am-comments-list-flip" id="chat">
		                </ul>
		            </div>
		            <!-- 输入区 -->
		            <div class="am-form-group am-form">
		                <textarea class="" id="message" name="message" rows="5"  placeholder="这里输入你想发送的信息..."></textarea>
		            </div>
		            <!-- 接收者 -->
		            <div class="" style="float: left">
		                <p class="am-kai">发送给 : <span id="sendto">全体成员</span><button class="am-btn am-btn-xs am-btn-danger" onclick="$('#sendto').text('全体成员')">复位</button></p>
		            </div>
		            <!-- 按钮区 -->
		            <div class="am-btn-group am-btn-group-xs" style="float:right;">
		                <button class="am-btn am-btn-default" type="button" onclick="getConnection()"><span class="am-icon-plug"></span> 连接</button>
		                <button class="am-btn am-btn-default" type="button" onclick="closeConnection()"><span class="am-icon-remove"></span> 断开</button>
		                <button class="am-btn am-btn-default" type="button" onclick="checkConnection()"><span class="am-icon-bug"></span> 检查</button>
		                <button class="am-btn am-btn-default" type="button" onclick="clearConsole()"><span class="am-icon-trash-o"></span> 清屏</button>
		                <button class="am-btn am-btn-default" type="button" onclick="sendMessage()"><span class="am-icon-commenting"></span> 发送</button>
		            </div>
				</div>
				<!-- 列表区 -->
				<div class="am-panel am-panel-default" style="float:right;width: 20%;">
					<div class="am-panel-hd">
		                <h3 class="am-panel-title">在线列表 [<span id="onlinenum"></span>]</h3>
		            </div>
		            <!-- <ul class="am-list am-list-static am-list-striped" >
		                <li>图灵机器人 <button class="am-btn am-btn-xs am-btn-danger" id="tuling" data-am-button>未上线</button></li>
		            </ul> -->
		            <ul class="am-list am-list-static am-list-striped" id="list">
		            </ul>
				</div>
			</div>
		</div>
		<!-- content end -->
      </div>
      <!-- web聊天室页面部分 结束位置-->
      
    </div>
  <script>
	$(function () {
        context.init({preventDoubleContext: false});
        context.settings({compress: true});
        context.attach('#chat-view', [
            {header: '操作菜单',},
            {text: '清理', action: clearConsole},
            {divider: true},
            {
                text: '选项', subMenu: [
                {header: '连接选项'},
                {text: '检查1', action: checkConnection},
                {text: '连接', action: getConnection},
                {text: '断开', action: closeConnection}
            ]
            },
            {
                text: '销毁菜单', action: function (e) {
                e.preventDefault();
                context.destroy('#chat-view');
            }
            }
        ]);
    });
	if("${message}"){
        layer.msg('${message}', {
            offset: 0
        });
    }
	if("${error}"){
        layer.msg('${error}', {
            offset: 0,
            shift: 6
        });
    }
	var wsServer = null;
	var ws = null;
	wsServer = "ws://" + "120.79.52.130/" +"${pageContext.request.contextPath}" + "/chatServer";
	//建立连接通道
	ws = new WebSocket(wsServer); //创建WebSocket对象
	
	//如果连接成功，就会执行onopen
    ws.onopen = function (evt) {
        layer.msg("已经建立连接", { offset: 0});
    };
    
  	//如果服务器有消息发送过来，就会执行onmessage
    //客户端接收服务器端发送过来的消息，并显示在页面中
    ws.onmessage = function (evt) {
        analysisMessage(evt.data);  //解析后台传回的消息,并予以展示
    };
    
    //如果连接失败，就会执行onerror
    ws.onerror = function (evt) {
        layer.msg("产生异常", { offset: 0});
    };
    
    //如果连接断开，就会执行onclose
    ws.onclose = function (evt) {
        layer.msg("已经关闭连接", { offset: 0});
    };
    
    /**
     * 连接---这个是点击连接按钮
     */
    function getConnection(){
        if(ws == null){
            ws = new WebSocket(wsServer); //创建WebSocket对象
            ws.onopen = function (evt) {
                layer.msg("成功建立连接!", { offset: 0});
            };
            ws.onmessage = function (evt) {
                analysisMessage(evt.data);  //解析后台传回的消息,并予以展示
            };
            ws.onerror = function (evt) {
                layer.msg("产生异常", { offset: 0});
            };
            ws.onclose = function (evt) {
                layer.msg("已经关闭连接", { offset: 0});
            };
        }else{
            layer.msg("连接已存在!", { offset: 0, shift: 6 });
        }
    }
    
    /**
     * 关闭连接
     */
    function closeConnection(){
        if(ws != null){
            ws.close();
            ws = null;
            $("#list").html("");    //清空在线列表
            layer.msg("已经关闭连接", { offset: 0});
        }else{
            layer.msg("未开启连接", { offset: 0, shift: 6 });
        }
    }
    
    /**
     * 检查连接
     */
    function checkConnection(){
        if(ws != null){
            layer.msg(ws.readyState == 0? "连接异常":"连接正常", { offset: 0});
        }else{
            layer.msg("连接未开启!", { offset: 0, shift: 6 });
        }
    }
    
    /**
     * 发送信息给后台
     * 点击发送按钮，将用户输入的消息发送给服务器端
     */
    function sendMessage(){
        if(ws == null){
            layer.msg("连接未开启!", { offset: 0, shift: 6 });
            return;
        }
        //得到输入框输入的消息内容
        var message = $("#message").val();
        var to = $("#sendto").text() == "全体成员"? "": $("#sendto").text();
        if(message == null || message == ""){
            layer.msg("请不要惜字如金!", { offset: 0, shift: 6 });
            return;
        }
        /* $("#tuling").text() == "已上线"? tuling(message):console.log("图灵机器人未开启"); */  //检测是否加入图灵机器人
        //客户端向服务器端发送消息，发送给服务器端，服务器端使用onMessage来接收
        ws.send(JSON.stringify({
            message : {
                content : message,
                from : '${userid}',
                to : to,      //接收人,如果没有则置空,如果有多个接收人则用,分隔
                time : getDateFull()
            },
            type : "message"
        }));
    }
    
  	//将消息显示在页面中
    function analysisMessage(message){
        message = JSON.parse(message);
        if(message.type == "message"){      //会话消息----聊天对话
            showChat(message.message);
        }
        if(message.type == "notice"){       //提示消息----进来和离开
            showNotice(message.message);
        }
        if(message.list != null && message.list != undefined){      //在线列表
            showOnline(message.list);
        }
    }
  	
    /**
     * 展示提示信息----进来和离开
     */
    function showNotice(notice){
        $("#chat").append("<div><p class=\"am-text-success\" style=\"text-align:center\"><span class=\"am-icon-bell\"></span> "+notice+"</p></div>");
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面，滚动到最新消息
    }
    
    /**
     * 展示会话信息
     */
    function showChat(message){
        var to = message.to == null || message.to == ""? "全体成员" : message.to;   //获取接收人
        var isSef = '${userid}' == message.from ? "am-comment-flip" : "";   //如果是自己则显示在右边,他人信息显示在左边
        var html = "<li class=\"am-comment "+isSef+" am-comment-primary\"><a href=\"#link-to-user-home\"><img width=\"48\" height=\"48\" class=\"am-comment-avatar\" alt=\"\" src=\"${ctx}/"+message.from+"/head\"></a><div class=\"am-comment-main\">\n" +
                "<header class=\"am-comment-hd\"><div class=\"am-comment-meta\">   <a class=\"am-comment-author\" href=\"#link-to-user\">"+message.from+"</a> 发表于<time> "+message.time+"</time> 发送给: "+to+" </div></header><div class=\"am-comment-bd\"> <p>"+message.content+"</p></div></div></li>";
        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    }
    
    /**
     * 展示在线列表
     */
    function showOnline(list){
        $("#list").html("");    //清空在线列表
        $.each(list, function(index, item){     //添加私聊按钮
            var li = "<li>"+item+"</li>";
            if('${userid}' != item){    //排除自己
                li = "<li>"+item+" <button type=\"button\" class=\"am-btn am-btn-xs am-btn-primary am-round\" onclick=\"addChat('"+item+"');\"><span class=\"am-icon-phone\"><span> 私聊</button></li>";
            }
            $("#list").append(li);
        });
        $("#onlinenum").text($("#list li").length);     //获取在线人数
    }
    
    /**
     * 添加接收人----在线列表添加接收人
     */
    function addChat(user){
        var sendto = $("#sendto");
        var receive = sendto.text() == "全体成员" ? "" : sendto.text() + ",";
        if(receive.indexOf(user) == -1){    //排除重复
            sendto.text(receive + user);
        }
    }
    
    /**
     * 清空聊天区
     */
    function clearConsole(){
        $("#chat").html("");
    }
    
    function appendZero(s){return ("00"+ s).substr((s+"").length);}  //补0函数
    
    function getDateFull(){
        var date = new Date();
        var currentdate = date.getFullYear() + "-" + appendZero(date.getMonth() + 1) + "-" + appendZero(date.getDate()) + " " + appendZero(date.getHours()) + ":" + appendZero(date.getMinutes()) + ":" + appendZero(date.getSeconds());
        return currentdate;
    }
    
  </script>
</body>
</html>