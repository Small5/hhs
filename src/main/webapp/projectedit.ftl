<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>修改项目</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	</head>
	<body class="childrenBody">
		<#--  <div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${modify}</div>  -->
		<div class="admin-content" id="project-edit">
			<form class="admin-form" action="updateProject.do" enctype="multipart/form-data" method="post">
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${base}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${pname}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="name" name="name">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${description}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="describe" name="describe" >
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${cwid}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="watershedId" name="watershedId" >
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${bps}</div>
				<div class="admin-form-item">
					<div class="admin-inline">
						<label class="admin-form-label">${baseyear}</label>
						<div class="admin-input-block">
							<input type="text" class="admin-input" id="baseYear" name="baseYear" readonly="readonly">
						</div>
					</div>
					<div class="admin-inline">
						<label class="admin-form-label"><span style="float: left;margin-left:40px;">----</span>${targetyear}</label>
						<div class="admin-input-block">
							<input type="text" class="admin-input" id="goalYear" name="goalYear">
						</div>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${step}</label>
					<div class="admin-input-block">
						<select id="step" name="step" class="admin-select">
							<option value="年">年</option>
							<option value="月">月</option>
							<option value="日">日</option>
						</select>
						<!-- 
						<input type="text" class="admin-input" id="step" name="step" value="${project.step}">
						-->
					</div>
				</div>
				<div class="admin-form-item  admin-form-btn">
					<button class="admin-btn admin-btn-blue" type="submit" >${save}</button>
					<button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
				</div>
			</form>
		</div>
		<#--<script type="text/javascript" src="easyUI/js/jquery.min.js"></script>-->
		<#--<script src="static/js/jquery-1.11.1.min.js"></script>-->
		<#--<script type="text/javascript">
			//获取当前用户信息
			$.get(
					"projectMsg.do",
					[],
					function(data) {
							console.log(data)
							if (data.isEmpty != "1") { // !$.isEmptyObject(data)

								//$('#name').textbox('setValue', data.name);
								console.log(data.name)
								//$('#describe').textbox('setValue', data.describe);
								//$('#watershedId').textbox('setValue', data.watershedId);
								//$('#baseYear').textbox('setValue', data.baseYear);
								//$('#goalYear').textbox('setValue', data.goalYear);
								$("#name").val(data.name),
								$("#describe").val(data.describe),
								$("#watershedId").val(data.watershedId),
								$("#baseYear").val(data.baseYear),
								$("#goalYear").val(data.goalYear)
							} else {
								alert("出错")
							}
							console.log(data);
					}
			);
			// $("#name").style("margin: 10px")
			// $("#name").val('5')
			// $("#describe").val('1')
			// $("#watershedId").val('2')
			// $("#baseYear").val('3')
			// $("#goalYear").val('4')
			//console.log('\t\t\t\t\t"projectMsg.do",\n' + '\t\t\t\t\t{id: \'1b720cad-8713-4523-ae69-c965ffd2d971\'},')
		</script>-->
	</body>
</html>
