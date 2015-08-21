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
<script type="text/javascript" src="<%=resource %>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=resource %>/js/common.js"></script>
<title>认证进度查询</title>
</head>
<body>
  <div class="wrap">
    <section class="main">
      <div class="input_con padding0"><input type="text" class="form-control" placeholder="请输入您的车架号"></div>
      <div class="tips"><span>!</span>您的实名认证已经通过</div>
      <div class="tips"><span>!</span>您实名照片的姓名、证件号码、证件地址、有效期（由审核人员多项复选决定）与您所填信息不一致，您的实名认证未通过，请重新认证</div>
      <div class="btns"><a href="carframeCheck.html" class="btn_common">查询</a></div>
    </section>
  </div>
</body>
</html>