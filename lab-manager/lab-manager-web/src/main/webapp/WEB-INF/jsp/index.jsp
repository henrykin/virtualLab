<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>虚拟实验室首页</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/zhouyu/test1.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<img src="/images/logo2.jpg" alt="logo" class="logo">
			<h3 class="title">第一虚拟实验室 The First Virtual Class --相关虚拟实验课程</h3>
		</div>
	</div>
<div id="myCarousel" class="carousel slide" style="width:100%;height:400px;">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="/images/1.jpg" alt="First slide" style="width:100%;height:400px;">
		</div>
		<div class="item">
			<img src="/images/2.jpg" alt="Second slide" style="width:100%;height:400px;">
		</div>
		<div class="item">
			<img src="/images/3.jpg" alt="Third slide" style="width:100%;height:400px;">
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>   
     <div class="main">
     
    <div class="container1 clearfix">
       <div class="intro">
 	     <div class="hot"><h1>热门虚拟实验课程推荐</h1>
 	   </div>
 	  <div class="teach ">
 		<a href="/physical" target="_blank"  ">
 			<div class="detailFather">
 				<img src="/images/physical.jpg" alt="教程图片" class="view">
 			</div>
 		 		<div class="introduction">
 			<h3 class="center">物理</h3>
            <div class="btn"><a href="/physical" target="_blank"><span class="BTN">立即体验</span></a></div>
 			
 		</div>
 		</a>

 	 </div>
 		
 	 <div class="teach ">
 		<a href="/chemistry" target="_blank">
 			<div class="detailFather">
 				<img src="/images/huaxue.jpg" alt="教程图片" class="view">
 			</div>
 		
 		<div class="introduction">
 			<h3 class="center">化学</h3>
 			<div class="btn"><a href="/chemistry" target="_blank"><span class="BTN">立即体验</span></a></div>
 		</div>
 		</a>
 	 </div>
     
     <div class="teach ">
 		<a href="/information-technology" target="_blank"  >
 			<div class="detailFather">
 				<img src="/images/information.jpg" alt="教程图片" class="view">
 			</div>
 		
 		<div class="introduction">
 			<h3 class="center">信息科学</h3>
 			<div class="btn"><a href="/information-technology" target="_blank"><span class="BTN">立即体验</span></a></div>
 		</div>
 		</a>
 	 </div>
</div>
 </div>
</div>
</body>
</html>