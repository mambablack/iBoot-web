/*选择框*/
$(document).ready(function(e){
	$(".select option").click(function(){
		$(this).parent().siblings("input").val($(this).val())
	})
})


/*上传图片*/
$(document).ready(function(e){
	$(".btn_upload input[type='file']").change(function(){
		var a = $(this).val();
		$(this).parent().siblings(".img_show").children("img").attr("src",a)
	})
})