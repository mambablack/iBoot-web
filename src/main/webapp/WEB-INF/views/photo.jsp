<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<script type="text/javascript" src="<%=resource%>/js/watermark.js"></script>
<script type="text/javascript" src="<%=resource%>/js/dmuploader.js"></script>
<script type="text/javascript" src="<%=resource%>/js/lrz.mobile.min.js"></script>
<title>入网资料</title>
</head>
<body>
	<div class="wrap">
		<section class="main">
			<div id="imgUpload">
				<div class="img_upload_content">
					<h1>上传头像所在面</h1>
					<div id="file1" class="img_upload rel">
						<div class="img_show" id="imageimage">
							<img id="file1_img" name="file1_img1" src="<%=resource%>/images/img-upload-front.jpg" width="240" class="margin0auto">
						</div>
						<label id="img1_label" class="btn_upload abs"><input id="file1_input" type="file" accept="image/*" style="opacity: 0;" ><span id="file1_span" class="abs"></span></label>
					</div>
					<div class="tips gray">
						<span>!</span>拍照时请确保签发机关、有效期限等信息清晰可见！
					</div>
					<h1>上传国徽所在面</h1>
					<div id="file2" class="img_upload rel">
						<div class="img_show">
							<img id="file2_img" name="file2_img2" src="<%=resource%>/images/img-upload-back.jpg" width="240" class="margin0auto">
						</div>
						<label id="img2_label" class="btn_upload abs"><input id="file2_input" type="file" accept="image/*" style="opacity: 0;"><span id="file2_span" class="abs"></span></label>
					</div>
					<div class="tips gray">
						<span>!</span>拍照时请确保签发机关、有效期限等信息清晰可见！
					</div>
					<h1>上传本人持证照</h1>
					<div id="file3" class="img_upload rel">
						<div class="img_show">
							<img id="file3_img" name="file3_img3" src="<%=resource%>/images/personWithIdCard.jpg" width="240" class="margin0auto">
						</div>
						<label id="img3_label" class="btn_upload abs"><input id="file3_input" type="file" accept="image/*" style="opacity: 0;"><span id="file3_span" class="abs"></span></label>
					</div>
					<div class="tips gray">
						<span>!</span>拍照时请确保签发机关、有效期限等信息清晰可见！
					</div>
					<div class="attention">为避免证件照被非法利用，上传后将自动添加"仅限中国联通实名验证使用"字样水印！</div>
				</div>
				<div id="tips" class="tips">
				</div>
			<form id="photoForm" action="<%=path %>/wx/photo" method="post" enctype="multipart/form-data">
				<div class="btns clearfix">
					<div class="btns">
						<input type="hidden" id="photo1" name="photo1">
						<input type="hidden" id="photo2" name="photo2">
						<input type="hidden" id="photo3" name="photo3">
						<input type="hidden" id="vin" name="vin" value="${vin}">
      					<input type="hidden" id="idName" name="idName" value="${idName}">
      					<input type="hidden" id="idNo" name="idNo" value="${idNo}">
      					<input type="hidden" id="idStartDate" name="idStartDate" value="${idStartDate}">
      					<input type="hidden" id="idEndDate" name="idEndDate" value="${idEndDate}">
      					<input type="hidden" id="contactTel" name="contactTel" value="${contactTel}">
						<a href="javascript:submit()" class="btn_common">确定上传</a>
					</div>
				</div>
			</form>
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
		var photoUrl = "<%=path %>/wx/photoupload";  
		$("#file1_input").change(function(){
			lrz(this.files[0], {
		        width:1000,
		        height:1000,
		        // 压缩开始
		        before: function() {
		            console.log('压缩开始');
		        },
		        // 压缩失败
		        fail: function(err) {
		            console.error(err);
		        },
		        // 压缩结束（不论成功失败）
		        always: function() {
		            /* console.log('压缩结束'); */
		        },
		        // 压缩成功
		        done: function (results) {
		        	console.log("压缩成功");
					console.log(results);
					//上传base64
					$.post(photoUrl, { photo: results.base64 }, 
					  function (text, status) {
						console.log(text.value);
						$("#file1_span").remove();
						$("#file1_img").attr("src", text.value);
						$("#photo1").val(text.key);
					});
		        }
		    });
		});
		$("#file2_input").change(function(){
			lrz(this.files[0], {
		        width:1000,
		        height:1000,
		        // 压缩开始
		        before: function() {
		            console.log('压缩开始');
		        },
		        // 压缩失败
		        fail: function(err) {
		            console.error(err);
		        },
		        // 压缩结束（不论成功失败）
		        always: function() {
		            /* console.log('压缩结束'); */
		        },
		        // 压缩成功
		        done: function (results) {
		        	console.log("压缩成功");
					console.log(results);
					//上传base64
					$.post(photoUrl, { photo: results.base64 }, 
					  function (text, status) {
						console.log(text.value);
						$("#file2_span").remove();
						$("#file2_img").attr("src", text.value);
						$("#photo2").val(text.key);
					});
		        }
		    });
		});
		$("#file3_input").change(function(){
			lrz(this.files[0], {
		        width:1000,
		        height:1000,
		        // 压缩开始
		        before: function() {
		            console.log('压缩开始');
		        },
		        // 压缩失败
		        fail: function(err) {
		            console.error(err);
		        },
		        // 压缩结束（不论成功失败）
		        always: function() {
		            /* console.log('压缩结束'); */
		        },
		        // 压缩成功
		        done: function (results) {
		        	console.log("压缩成功");
					console.log(results);
					//上传base64
					$.post(photoUrl, { photo: results.base64 }, 
					  function (text, status) {
						console.log(text.value);
						$("#file3_span").remove();
						$("#file3_img").attr("src", text.value);
						$("#photo3").val(text.key);
					});
		        }
		    });
		});
		 
	  });
	
	
		function submit(){
			var f1 = $("#photo1").val();
			var f2 = $("#photo2").val();
			var f3 = $("#photo3").val();
			if(!f1){
				$("#tips").html("<span>!</span>请选择头像所在面照片");
				return false;
			}
			if(!f2){
				$("#tips").html("<span>!</span>请选择国徽所在面照片");
				return false;
			}
			if(!f2){
				$("#tips").html("<span>!</span>请选择本人持证照");
				return false;
			}
			
			$("#photoForm").submit();
		}
	</script>
</body>
</html>