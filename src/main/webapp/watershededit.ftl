<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>编辑流域</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
	</head>
	<body class="childrenBody">
		<div class="admin-page-title"><i class="icon iconfont icon-left">&#xe600;</i>${edit}</div>
		<div class="admin-content">
			<form id="updateWatershed" class="admin-form" action="home.do" enctype="multipart/form-data" method="post" onsubmit="return updateWatershed();">
				<div class="admin-form-item">
					<label class="admin-form-label">${basinid}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" readonly="readonly" id="id" name="id" value="${watershed.id}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${basin}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="name" name="name" value="${watershed.name}">
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${description}</label>
					<div class="admin-input-block">
						<input type="text" class="admin-input" id="describe" name="describe" value="${watershed.describe}">
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${climate}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${climatey}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblClimateScenarioYear" name="tblClimateScenarioYear"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${climatem}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblClimateScenarioMonth" name="tblClimateScenarioMonth"/></label>
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${land}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${landtype}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblLandUseSce" name="tblLandUseSce"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${planting}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblCropPattern" name="tblCropPattern"/></label>
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${economic}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${gdp}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblSocioEconSce" name="tblSocioEconSce"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${policy}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblPrefPolicy" name="tblPrefPolicy"//></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${water}<</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblHydrEngineering" name="tblHydrEngineering"/></label>
					</div>
				</div>
				<div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${resources}</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${areawater}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblWaterResManSce" name="tblWaterResManSce"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${three}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblWaterUseCounty" name="tblWaterUseCounty"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${right}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblWaterRightCounty" name="tblWaterRightCounty"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${middle}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblMidDownWaterAllo" name="tblMidDownWaterAllo"/></label>
					</div>
				</div>
				<div class="admin-form-item">
					<label class="admin-form-label">${consumption}</label>
					<div class="admin-input-block">
						<label class="admin-btn"><input type="file" id="tblWaterAlloCounty" name="tblWaterAlloCounty"/></label>
					</div>
				</div>
				<div class="admin-form-item  admin-form-btn">
					<button class="admin-btn admin-btn-blue" type="submit" >${save}</button>
					<button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
				</div>
			</form>
		</div>
		<script src="./js/jquery-form.js"></script>
	<script>
		function updateWatershed() {
			$('#updateWatershed').ajaxSubmit( {
				url : "updateWatershed.do",
				success: function(data) {
					alert(data);
				}
			});
			return false;
		}
	</script>

	</body>
</html>
