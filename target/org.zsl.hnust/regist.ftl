<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="regist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="regist/css/style.css" />
<script type="text/javascript" src="login/js/jquery.min.js"></script>
<script src="regist/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">


function ok_or_errorByRegister(r) {
	var affirm_psd = $("#affirm_psd");
	var psd_r = $("#psd_r");
	var nikename_r = $("#nikename_r");
	var email_r = $("#email_r");
	var affirm_psd_v = $("#affirm_psd").val();
	var psd_r_v = $("#psd_r").val();
	var nikename_r_v = $("#nikename_r").val();
	var email_r_v = $("#email_r").val();
	var content = $(r).val();
	if (content == "") {
		$(r).parent().next().next().css("display", "block");
		return false;
	} else {
		$(r).parent().next().css("display", "block");
		$(r).parent().next().next().css("display", "none");
		if (psd_r_v == "") {
			$(psd_r).parent().next().css("display", "none");
			$(psd_r).parent().next().next().css("display", "none");
			$(psd_r).parent().next().next().css("display", "block");
			return false;
		}
		if (affirm_psd_v == "") {
			$(affirm_psd_v).parent().next().css("display", "none");
			$(affirm_psd_v).parent().next().next().css("display", "none");
			$(affirm_psd_v).parent().next().next().css("display", "block");
			return false;
		}
		if (psd_r_v == affirm_psd_v) {
			$(affirm_psd).parent().next().css("display", "none");
			$(affirm_psd).parent().next().next().css("display", "none");
			$(psd_r).parent().next().css("display", "none");
			$(psd_r).parent().next().next().css("display", "none");
			$(affirm_psd).parent().next().css("display", "block");
			$(psd_r).parent().next().css("display", "block");
		}else {
			$(affirm_psd).parent().next().css("display", "none");
			$(affirm_psd).parent().next().next().css("display", "none");
			$(psd_r).parent().next().css("display", "none");
			$(psd_r).parent().next().next().css("display", "none");
			$(psd_r).parent().next().css("display", "block");
			$(affirm_psd).parent().next().next().css("display", "block");
			return false;
		}

		if (nikename_r_v == "") {
			$(nikename_r).parent().next().css("display", "none");
			$(nikename_r).parent().next().next().css("display", "none");
			$(nikename_r).parent().next().next().css("display", "block");
			return false;
		}
		if (email_r_v == "") {
			$(email_r).parent().next().css("display", "none");
			$(email_r).parent().next().next().css("display", "none");
			$(email_r).parent().next().next().css("display", "block");
			return false;
		}
	}
}

function barter_btn(bb) {
	$(bb).parent().parent().fadeOut(1000);
	$(bb).parent().parent().siblings().fadeIn(2000);
}
</script>
</head>

<body class="login_body">
<div class="register_body">
	<div class="col-xs-12 register_title">注册</div>
	<form action="" class="register" method="post">
		<div class="nav">
			<div class="nav register_nav">
				<div class="col-xs-4">
					用户名:
				</div>
				<div class="col-xs-6">
					<input type="text" name="" id="name_r" value="" placeholder="&nbsp;&nbsp;用户名" onBlur="javascript:ok_or_errorByRegister(this)" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_psdnav">
				<div class="col-xs-4">
					密&nbsp;&nbsp;&nbsp;码:
				</div>
				<div class="col-xs-6">
					<input type="password" name="" id="psd_r" value="" placeholder="&nbsp;&nbsp;密码" onBlur="javascript:ok_or_errorByRegister(this)" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_affirm">
				<div class="col-xs-4">
					确认密码:
				</div>
				<div class="col-xs-6">
					<input type="password" name="" id="affirm_psd" value="" placeholder="&nbsp;&nbsp;确认密码" onBlur="javascript:ok_or_errorByRegister(this)" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_nick">
				<div class="col-xs-4">
					昵称:
				</div>
				<div class="col-xs-6">
					<input type="text" name="" id="nickname_r" value="" placeholder="&nbsp;&nbsp;昵称" onBlur="javascript:ok_or_errorByRegister(this)" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_email">
				<div class="col-xs-4">
					邮箱:
				</div>
				<div class="col-xs-6">
					<input type="text" name="" id="email_r" value="" placeholder="&nbsp;&nbsp;邮箱" onBlur="javascript:ok_or_errorByRegister(this)" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="col-xs-12 register_btn_div">
				<input type="button" class="sub_btn" value="注册" id="register" style="background: #31B0D5;"/>
			</div>
		</div>
	</form>
	<div class="col-xs-12 barter_register">
		<button class="barter_registerBtn" onClick="ToLogin()" style="">已有账号?返回登录</button>
	</div>
</div>
<script type="text/javascript">
	function ToLogin(){
		 window.location.href='login.do';
	 }


	$("#register").click(function (event) {
		event.preventDefault();
		var name_r_state = $('#name_r');
		var psd_r_state = $('#psd_r');
		var affirm_psd_state = $('#affirm_psd');
		var name_r = $('#name_r').val();
		var psd_r = $('#psd_r').val();
		var affirm_psd = $('#affirm_psd').val();
		if (name_r == '') {
			name_r_state.parent().next().next().css("display", "block");
			return false;
		} else if (psd_r == '') {
			psd_r_state.parent().next().next().css("display", "block");
			return false;
		} else if (affirm_psd == '') {
			affirm_psd_state.parent().next().next().css("display", "block");
			return false;
		} else if (psd_r != affirm_psd) {
			return false;
		}else {
			$.ajax({
		            type: "post",
		            url: "register.do",
		            data: {
		                username: document.getElementById("name_r").value,
		                userpwd: document.getElementById("psd_r").value,
		                userpwd1:document.getElementById("affirm_psd").value,
		                nickname:document.getElementById("nickname_r").value,
		                email:document.getElementById("email_r").value
		            },
		            success:function(data){
		            	console.log(data);
		                if(data=='1'){
		                    window.location.href='login.do';
		                }else{
		                	alert("该用户已存在，请换一个用户名！");
		                }
		            }
	        });
		}
	});
</script>
</body>
</html>