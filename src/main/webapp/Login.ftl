<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta http-equiv="X-UA-Compatible" content="IE=10">
<meta http-equiv="X-UA-Compatible" content="IE=11">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>流域可持续发展决策支持系统</title>
<link rel="shortcut icon" href="login/image/favicon.png" type="image/x-icon" />
<script type="text/javascript" src="login/js/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="login/css/login.css">

</head>
<body class="aa">
	<!-- <div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1;background-image: url('login/image/login.png');background-size:100% 100% "> -->
		<div class="wrapper">
			<div class="container">
				<div style="width:320px; height: 100px;background: url('login/image/login_logo.png') no-repeat center;padding-left: 260px;padding-top: 20px">	
				</div>
				
				<form class="form">
					<input type="text" placeholder="Username" name="accountNumber" id="loginname" value="">
					<input type="password" placeholder="Password" name="userpwd" id="password" value="">
					<button type="submit" id="to-recover" style="font-size: 17px;">${login}</button>
					<button type="submit" id="login-guest" style="font-size: 16px;">${tourist}</button>
					<div class="danger-error" style="display: none;color: red;"> 账号或密码错误</div>
				</form>
				<div class="col-xs-12 barter_btnDiv">
					<button class="barter_btn"  onClick="ToRegist()">没有账号?前往注册</button>
				</div>
			</div>
			<div class="down" style="text-align:center; color:#000000">
				<font color="#ff8000">${hhs}</font>
			</div>
		</div>
	<!-- </div> -->
	
	<script type="text/javascript">
	$('#to-recover').click(function (event) {
		event.preventDefault();
				$.ajax({
	            type: "post",
	            url: "login.do",
	            data: {
	                accountNumber: document.getElementById("loginname").value,
	                userpwd: document.getElementById("password").value,
	            },
	            success:function(data){
	                if(data=='0'){//返回0报错
	                    $(".danger-error").css("display","block");
	                }else{//返回1成功
	                    window.location.href='home.do';
	                }
	            }  
	        });
	});
	 $("#login-guest").click(function (event) {
			event.preventDefault();
			$.ajax({
	            type: "post",
	            url: "login.do",
	            data: {
	                accountNumber: 'guest356246547',
	                userpwd: '123456',
	            },
	            success:function(data){
	                if(data=='0'){
	                    $(".danger-error").css("display","block");
	                }else{
	                    window.location.href='home.do';
	                }
	            }
        	});
		});

	 function ToRegist(){
		 window.location.href='regist.ftl';
	 }
	</script>
</body>
</html>