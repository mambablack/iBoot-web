<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String resource = path + "/resources";
%>
<!Doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<link rel="stylesheet" type="text/css" href="<%=resource%>/css/global.css">
<link rel="stylesheet" type="text/css" href="<%=resource%>/css/base.css">
<script type="text/javascript" src="<%=resource%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=resource%>/js/common.js"></script>
<title>车架验证</title>
</head>
<body>
	<div class="wrap">
		<section class="main">
			<form id="vinForm" action="<%=path%>/wx/vin" method="post">
				<div class="input_con">
					<select id="carSeries" name="carSeries" class="form-control">
						<option selected="selected" value="1">宝马</option>
						<option value="2">捷豹</option>
					</select>
				</div>
				<div class="input_con padding0">
					<input id="vin" name="vin" type="text" class="form-control" placeholder="请输入您的车架号">
				</div>
				<div>&nbsp;</div>
				<div id="tips" class="tips">
				</div>
				<div class="btns">
					<a href="javascript:submit()" class="btn_common">下一步</a>
				</div>
		</section>
	</div>
	</form>
	<script>
  $(document).ready(function(){
	  $(".select").change(function(){
			/* $(this).siblings("input").val($(this).text()) */
			$("#carSeries_input").val($("#carSeries").text());
		});
	  	/* var useragent = navigator.userAgent;
	    if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
	        alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
	        var opened = window.open('about:blank', '_self');
	        opened.opener = null;
	        opened.close();
	    } */
  });
  function submit(){
		var vin = $("#vin").val();
		if(!vin){
			$("#tips").html("<span>!</span>车架号不能为空,请输入车架号码");
			$("#tips").show();
			$("#vin").focus();
			return false;
		}
		var url = "<%=path%>/wx/checkVin";
			$.getJSON(url,{vin:vin}, function(data) {
				console.log(data);
				if(data.result=="0"){
					$("#vinForm").submit();
				}else {
					$("#tips").html("<span>!</span>您的车架号"+vin+"验证不通过，请核实您的车架号码");
					$("#tips").show();
				}
			});

		}
	</script>
</body>
</html>