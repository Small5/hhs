<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>个人信息修改</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
		<script src="static/js/jquery-1.11.1.min.js"></script>
	</head>
	<body class="childrenBody">
		<div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${pim}</div>
		<div class="admin-content">
			<form class="admin-form">
				<input type="text" class="form-control" id="userid" value="" name="id" style="display:none;">
				<div class="admin-form-item">
					<label class="admin-form-label">${username}</label>
					<div class="admin-input-block">
						<input readonly="readonly" type="text" class="admin-input" id="accountNumber" name="accountNumber" placeholder="请输入用户名">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${nickname}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="nickName" name="nickName" placeholder="${nickname1}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">Email</label>
					<div class="admin-input-block">
						<input type="email" class="admin-input" id="Email" name="Email" placeholder="example@xx.com">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${pwd1}</label>
					<div class="admin-input-block">
						<input type="password" class="admin-input" id="password" name="password" placeholder="${pwd01}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${pwd2}</label>
					<div class="admin-input-block">
						<input type="password" class="admin-input" id="repwd" name="repwd" placeholder="${pwd02}">
					</div>
				</div>
				<hr />
				<!-- 
				<div class="admin-form-item">
					<label class="admin-form-label">${lage}</label>
					<div class="admin-input-block">
						<label class="admin-radio">
							<input type="radio" name="language" checked="checked" value="chinese"/>
							<span>
								<i class="icon iconfont">&#xe6d7;</i>
								<i class="icon iconfont">&#xe75b;</i>
							</span>
							${chinese}
						</label>
						<label class="admin-radio">
							<input type="radio" name="language"  value="english"/>
							<span>
								<i class="icon iconfont">&#xe6d7;</i>
								<i class="icon iconfont">&#xe75b;</i>
							</span>
							English
						</label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${ngo}</label>
					<div class="admin-input-block">
						<label class="admin-radio">
							<input id="radio_2_1" type="radio" name="guide" checked="checked" value="y"/>
							<span>
								<i class="icon iconfont">&#xe6d7;</i>
								<i class="icon iconfont">&#xe75b;</i>
							</span>
							${need}
						</label>
						<label class="admin-radio">
							<input id="radio_2_2" type="radio" name="guide" value="n" />
							<span>
								<i class="icon iconfont">&#xe6d7;</i>
								<i class="icon iconfont">&#xe75b;</i>
							</span>
							${notneed}
						</label>
					</div>
				</div>
				 -->
				<div class="admin-form-item  admin-form-btn">
					<a onclick="savechanges();" class="admin-btn admin-btn-blue" style="margin-right: 15px;">${save}</a>
					<button class="admin-btn admin-btn-grey">${reset}</button>
				</div>
			</form>
		</div>
		
		<script type="text/javascript">
			//获取当前用户信息
			$.get(
					"getCurrentUser.do",
					[],
					function(data){
						if(data.isEmpty!="1"){
							$("#userid").val(data.id),
							$("#accountNumber").val(data.accountNumber),
							$("#nickName").val(data.nickName),
							$("#Email").val(data.eMail)
						} else{
							alert("出错，请重新登录!")
						}
						console.log(data);
					}
				);
			
			//修改信息
			function updateUser(){
				$.post(
					"updateUser.do",
					{
						id:$("#userid").val(),
						accountNumber:$("#accountNumber").val(),
						nickName:$("#nickName").val(),
						password:$("#password").val(),
						repwd:$("#repwd").val(),
						eMail:$("#Email").val()
					},
					function(data){
						console.log(data);
						alert(data.content);
					}
				);
			}
			
			
			$.get(
					"getUserLanguageAndGuid.do",
					[],
					function(data){
						var str1 = "input:radio[value="+data.language+"]";
						var str2 = "input:radio[value="+data.guide+"]";
						$(str1).parent().parent().click();
						$(str2).parent().parent().click();
					}
				);
			
			function saveUserLanguageAndGuide(){
				$.post(
						"updateUserLanguageAndGuide.do",
						{
							language:$("input[name='language']:checked").val(),
							guide:$("input[name='guide']:checked").val()
						},
						function(data){
							
						}
						);
			}
			
			function savechanges(){
				updateUser();
				saveUserLanguageAndGuide();
			}
		</script>
	
	</body>
</html>
