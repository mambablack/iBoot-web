<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String resource = path +"/resources";
%>
<!Doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="<%=resource %>/css/global.css">
<link rel="stylesheet" type="text/css" href="<%=resource %>/css/base.css">
<link rel="stylesheet" type="text/css" href="<%=resource %>/css/mobiscroll1.css">
<link rel="stylesheet" type="text/css" href="<%=resource %>/css/mobiscroll.css">
<link rel="stylesheet" type="text/css" href="<%=resource %>/css/mobiscroll2.css">
<script type="text/javascript" src="<%=resource %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=resource %>/js/common.js"></script>
<script type="text/javascript" src="<%=resource %>/js/common.js"></script>
<script type="text/javascript" src="<%=resource %>/js/mobiscroll1.js"></script>
<script type="text/javascript" src="<%=resource %>/js/mobiscroll3.js"></script>
<script type="text/javascript" src="<%=resource %>/js/mobiscroll.js"></script>
<script type="text/javascript" src="<%=resource %>/js/mobiscroll2.js"></script>
<script type="text/javascript" src="<%=resource %>/js/mobiscroll4.js"></script>
<title>实名登记入口</title>
</head>
<body>
  <div class="wrap">
    <section class="main">
      <div id="entranceSelect">
        <div class="entrance">
          <a href="<%= path %>/wx/vin">
            <img src="<%=resource %>/images/entrance1.jpg" width="100%">
            <p>车联网用户实名登记入口</p>
          </a>
        </div>
        <div class="entrance">
          <a href="<%= path %>/wx/vin">
            <img src="<%=resource %>/images/entrance2.jpg" width="100%">
            <p>手机实名登记入口</p>
          </a>
        </div>
      </div>
    </section>
  </div>
  <script>
  $(document).ready(function(){
	  	/* var useragent = navigator.userAgent;
	    if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
	        alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
	        var opened = window.open('about:blank', '_self');
	        opened.opener = null;
	        opened.close();
	    } */
  });
  </script>
</body>
</html>