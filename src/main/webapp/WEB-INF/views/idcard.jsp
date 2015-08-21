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
<title>实名验证</title>
</head>
<body>
  <div class="wrap">
    <section class="main">
    <form id="form" action="<%=path %>/wx/idcard" method="post">
      <div id="idCheck">
      	<div class="input_con">
      		<input type="text" class="form-control" placeholder="请选择证件类型" value="身份证">
	      	<select class="form-control select">
		      <option selected="selected">身份证</option>
		      <option>军官证</option>
		      <option>港澳通行证</option>
		    </select>
	      </div>
	      <div class="input_con"><input id="idName" name="idName" type="text" class="form-control" placeholder="请输入您的姓名"></div>
	      <div class="input_con"><input id="idNo" name="idNo" type="text" class="form-control" placeholder="请输入您的证件号码"></div>
	      <div class="input_con clearfix">
	      	<div class="percent47"><input id="idStartDate" name="idStartDate" class="appDate form-control"  type="text" placeholder="请选择证件起始日期"></div>
	      	<div class="percent6">~</div>
	      	<div class="percent47" style=""><input id="idEndDate" name="idEndDate" class="appDate form-control" type="text" placeholder="请选择证件到期期限"></div>
	      </div>
	      <div class="input_con padding0"><input id="contactTel" name="contactTel" type="text" class="form-control" placeholder="请输入您的联系号码"></div>
	      <div class="tips" id="tips"></div>
	      <!-- <div class="tips" style="hidden">您的证件号码已经登记5张通讯卡，不能再行登记</div>
	      <div class="tips" style="hidden">您的实名信息未能通过校验，请核实您的姓名、证件号及有效期</div> -->
	      <div class="btns"><a href="javascript:submit()" class="btn_common">下一步</a></div>
      </div>
      <input type="hidden" id="vin" name="vin" value="${vin}">
      <input type="hidden" id="carSeries" name="carSeries" value="${carSeries}">
      </form>
    </section>
  </div>
<script type="text/javascript">
$(document).ready(function(){
	  /* var useragent = navigator.userAgent;
	  if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
	      alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
	      var opened = window.open('about:blank', '_self');
	      opened.opener = null;
	      opened.close();
	  } */
});
        $(function () {
			var currYear = (new Date()).getFullYear();	
			var opt={};
			opt.date = {preset : 'date'};
			opt.datetime = {preset : 'datetime'};
			opt.time = {preset : 'time'};
			opt.default = {
				theme: 'android-ics light', //皮肤样式
		        display: 'modal', //显示方式 
		        mode: 'scroller', //日期选择模式
				dateFormat: 'yyyy-mm-dd',
				lang: 'zh',
				showNow: true,
				nowText: "今天",
		        startYear: currYear - 50, //开始年份
		        endYear: currYear + 50 //结束年份
			};

		  	$(".appDate").mobiscroll($.extend(opt['date'], opt['default']));
        });
        function submit(){
        	var idName = $("#idName").val();
        	var idNo = $("#idNo").val();
        	var idStartDate = $("#idStartDate").val();
        	var idEndDate = $("#idEndDate").val();
        	var contactTel = $("#contactTel").val();
        	
        	
        	if(!idName){
    			$("#tips").html("<span>!</span>姓名不能为空,请输入姓名");
    			$("#tips").show();
    			$("#idName").focus();
    			return false;
    		}
        	if(!idNo){
    			$("#tips").html("<span>!</span>证件号码不能为空,请输入证件号码");
    			$("#tips").show();
    			$("#idNo").focus();
    			return false;
    		}
        	if(!idStartDate){
    			$("#tips").html("<span>!</span>证件起始日期不能为空,请输入证件起始日期");
    			$("#tips").show();
    			/* $("#idStartDate").focus(); */
    			return false;
    		}
        	if(!idEndDate){
    			$("#tips").html("<span>!</span>证件到期期限不能为空,请输入证件到期期限");
    			$("#tips").show();
    			/* $("#idEndDate").focus(); */
    			return false;
    		}
    		if(!contactTel){
    			$("#tips").html("<span>!</span>联系号码不能为空,请输入联系号码");
    			$("#tips").show();
    			$("#contactTel").focus();
    			return false;
    		}
    		var url = "<%=path%>/wx/checkIdcard";
			$.getJSON(url,{idName:idName,idNo: idNo,idStartDate: idStartDate,idEndDate: idEndDate,contactTel: contactTel}, function(data) {
				console.log(data);
				if(data.result=="0"){
					$("#form").submit();
				}else {
					console.log("error");
					$("#tips").html("<span>!</span>您的实名信息未能通过校验，请核实您的姓名、证件号及有效期");
					$("#tips").show();
				}
			});
        }
</script>
</body>
</html>