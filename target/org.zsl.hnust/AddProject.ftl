<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>新增项目</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	</head>
	<body class="childrenBody">
		<#--<div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${addp}</div>-->
		<div class="admin-content">
			<form id="addProject" class="admin-form" action="addProject.do" enctype="multipart/form-data" method="post" onsubmit="return addProject();">
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${base}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${pname}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="name" name="name" placeholder="${pnamein}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${description}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="describe" name="describe" placeholder="${descriptionin}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${cwid}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="watershedId" name="watershedId" placeholder="${cwidin}">
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${bps}</div>
				<div class="admin-form-item">
					<div class="admin-inline">
						<label class="admin-form-label">${baseyear}</label>
						<div class="admin-input-block">
						<!-- <input type="text" class="admin-input" id="baseYear" name="baseYear" placeholder="${baseyearin}"> -->
							<input type="text" class="admin-input" id="baseYear" name="baseYear" value = "2012" readonly="readonly">
						</div>
					</div>
					<div class="admin-inline">
						<label class="admin-form-label"><span style="float: left;margin-left:40px;">----</span>${targetyear}</label>
						<div class="admin-input-block">
							<input type="text" class="admin-input" id="goalYear" name="goalYear" placeholder="${targetyearin}">
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
						<input type="text" class="admin-input" id="step" name="step" placeholder="${stepin}">
						-->
					</div>
				</div>
				<div class="admin-form-item  admin-form-btn">
					<button class="admin-btn admin-btn-blue" type="submit">${save}</a>
					<button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
				</div>
			</form>
		</div>
	</body>
	<script>
		function addProject() {
			$('#addProject').ajaxSubmit( {
				url : "addProject.do",
				success: function(data) {
					alert("success!")
					window.location.reload()
				}
			});
			return false;
		}
	</script>
</html>