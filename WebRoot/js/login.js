$(function(){
	
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
	});
	
	
	/***
	 *
	 * Login登录前判断
	 *
	 */
	//得到表单
	var loginForm = document.getElementById('loginForm');
	
	//账号密码需要匹配的正则表达式(只能使用数字+字母)
	var reg = "^[A-Za-z0-9]+$";
	//给登录按钮增加 点击判断
	var btnSubmit = document.getElementById('sbm');
	btnSubmit.onclick = function() {
		//得到account的值
		var account = document.getElementById('u').value;
		//得到password的值
		var password = document.getElementById('p').value;
		
		if(account!=null && account!=""
			&& password!=null && password!="") {
			if(account.match(reg) && password.match(reg)) {
				loginForm.submit();
			} else {
				alert("账号名和密码必须为数字或字母!!!");
			}
		} else {
			alert("账号和密码不得为空!!!");
		}
	};
});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


/**
 * 快速注册
 */
var reMethod = "POST",
	pwdmin = 6;

$(document).ready(function() {
	$('#reg').click(function() {

		//判断用户名是否为空
		var passwd = document.getElementById('passwd').value;
		var passwd2 = document.getElementById('passwd2').value;
		if ($('#user').val()=="") {
			$('#user').focus();
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}
		
		//账号密码需要匹配的正则表达式(只能使用数字+字母)
		var reg = "^[A-Za-z0-9]+$";
		//得到account的值(在这用user)
		var user = document.getElementById('user').value;
		if (!user.match(reg)) {
			$('#user').focus();
			$('#userCue').html("<font color='red'><b>×账号名必须为数字或字母!!!</b></font>");
			return false;
		}
		
		//密码一是否为空
		if ($('#passwd').val()=="") {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码不能为空</b></font>");
			return false;
		}
		
		//密码_1是否合法
		var passwd = document.getElementById('passwd').value;
		//密码判断
		if (!passwd.match(reg)) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码必须为数字或字母!!!</b></font>");
			return false;
		}
		
		
		//密码二是否为空
		if ($('#passwd2').val()=="") {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×确认密码不能为空</b></font>");
			return false;
		}
		
//		//确认密码 是否为空
//		if ($('#passwd2').val() == "") {
//			$('#passwd2').focus();
//			$('#userCue').html("<font color='red'><b>×请确认密码!!!</b></font>");
//			return false;
//		}	
		
		//确认密码是否相同
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}	
		
		//全部没问题 提交
		$('#regUser').submit();
	});
	

});

