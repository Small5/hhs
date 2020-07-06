<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>目标体系</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css" />
		<script type="text/javascript" src="static/js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="static/js/layer/layer.js"></script>
		<script type="text/javascript" src="static/js/echarts-all.js"></script>
	</head>

	<body class="childrenBody">
		<#--<div class="admin-page-title admin-page-title-steps">-->
			<#--<div class="fl">-->
				<#--<i class="icon iconfont icon-left">&#xe600;</i>${system}-->
			<#--</div>-->
			<#--<!--步骤条&ndash;&gt;-->
			<#--<div class="admin-steps-wrap fr">-->
				<#--<div class="admin-steps">-->
					<#--<div class="admin-steps-item admin-steps-item-finish">-->
						<#--<a href="goal.do" target="adminFrameName">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>1</span>-->
								<#--<em>${goal}</em>-->
							<#--</div>-->
							<#--<div class="admin-steps-item-tail"></div>-->
						<#--</a>-->
					<#--</div>-->
					<#--<div class="admin-steps-item admin-steps-item-process">-->
						<#--<a href="javascript:;" target="adminFrameName">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>2</span>-->
								<#--<em>${scene}</em>-->
							<#--</div>-->
							<#--<div class="admin-steps-item-tail"></div>-->
						<#--</a>-->
					<#--</div>-->
					<#--<div class="admin-steps-item">-->
						<#--<a href="jumpToResult.do" target="adminFrameName">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>3</span>-->
								<#--<em>${scene1}</em>-->
							<#--</div>-->
						<#--</a>-->
					<#--</div>-->
				<#--</div>-->
			<#--</div>-->
		<#--</div>-->
		<div id="toSituation">
			<div class="admin-tab">
				<ul class="admin-tab-top">
					<li id="stuation-1" class="admin-this">${climate}</li>
					<li id="stuation-2">${land}</li>
					<li id="stuation-3">${soc}</li>
					<li id="stuation-4">${water}</li>
				</ul>
				<div class="admin-tab-cont">
					<!--气候情景-->
					<div class="admin-tab-item active">
						<div class="fl" style="width: 100%;">
							<div class="admin-card">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${climate}</h3>
									<button class="admin-btn admin-btn-blue" id="climate_submit">${save}</button>
								</div>
								<div class="admin-card-content" style="height: 687px !important;min-height: 687px;">
									<table class="admin-table admin-stuation-table">
										<thead>
											<tr>
												<th><p align="left">${county}</p></th>
												<th><p align="left">${rain}(%／${toalyear}${nian})</p></th>
												<th><p align="left">${temp}(℃／${toalyear}${nian})</p></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input id="toSituation_country1" value="0" style="display: none;"/><p align="left">${quanliuyu}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_1" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_1" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country2" value="1" style="display: none;"/><p align="left">${upstream}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_2" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_2" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country3" value="2" style="display: none;"/><p align="left">${mal}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_3" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_3" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country4" value="620702" style="display: none;"/><p align="left">${ganzhou}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_4" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_4" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country5" value="620723" style="display: none;"/><p align="left">${linze}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_5" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_5" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country6" value="620724" style="display: none;"/><p align="left">${gaotai}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_6" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_6" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country7" value="152923" style="display: none;"/><p align="left">${ejinaqi}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_7" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_7" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country8" value="620921" style="display: none;"/><p align="left">${jinta}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_8" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_8" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country9" value="620722" style="display: none;"/><p align="left">${minle}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_9" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_9" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country10" value="620721" style="display: none;"/><p align="left">${sunan}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_10" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_10" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country11" value="620902" style="display: none;"/><p align="left">${suzhou}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_11" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_11" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country12" value="620200" style="display: none;"/><p align="left">${jiayuguan}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_12" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_12" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country13" value="632222" style="display: none;"/><p align="left">${qilian}</td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_13" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_13" value="0.8" style="text-align: right;"/></td>
											</tr>
											<tr>
												<td><input id="toSituation_country14" value="620725" style="display: none;"/><p align="left">${shandan}</p></td>
												<td><input class="admin-input" type="text" id="toSituation_rain_inc_14" value="5" style="text-align: right;"/></td>
												<td><input class="admin-input" type="text" id="toSituation_temp_inc_14" value="0.8" style="text-align: right;"/></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="fr" style="width: 75%;padding-left: 10px;">
							<div class="admin-card admin-card-select">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${sc}</h3>
									<select id="selectCounty_climate" class="admin-select">
										<option value="620702">${ganzhou}</option>
										<option value="620723">${linze}</option>
										<option value="620724">${gaotai}</option>
										<option value="152923">${ejinaqi}</option>
										<option value="620921">${jinta}</option>
										<option value="620722">${minle}</option>
										<option value="620721">${sunan}</option>
										<option value="620902">${suzhou}</option>
										<option value="620200">${jiayuguan}</option>
										<option value="632222">${qilian}</option>
										<option value="620725">${shandan}</option>
										<option value="0">${quanliuyu}</option>
										<option value="1">${upstream}</option>
										<option value="2">${mal}</option>
									</select>
								</div>
							</div>
							<div class="admin-card">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${tempbiao}</h3>
								</div>
								<div class="admin-card-content admin-card-content-chart">
									<div class="admin-chart-wrap" id="showArea-1"></div>
								</div>
							</div>
							<div class="admin-card">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${rainbiao}</h3>
								</div>
								<div class="admin-card-content admin-card-content-chart">
									<div class="admin-chart-wrap" id="showArea-2"></div>
								</div>
							</div>
						</div>
					</div>
					
					<script type="text/javascript">
					//获取气候情景参数
					<#--$.get("getClimateScePara.do", -->
						<#--{-->
						<#--"id" : "${projectId}"-->
						<#--}, function(data) {-->
						<#--//console.log(data);-->
						<#--var i=0;-->
						 <#--if(data != null){-->
						    	<#--for(i;i<=data.length;i++){-->
						    		<#--if(data[i].countyId=="0"){-->
						    			<#--document.getElementById("rain_inc_1").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_1").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="1"){-->
						    			<#--document.getElementById("rain_inc_2").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_2").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="2"){-->
						    			<#--document.getElementById("rain_inc_3").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_3").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620702"){-->
						    			<#--document.getElementById("rain_inc_4").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_4").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620723"){-->
						    			<#--document.getElementById("rain_inc_5").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_5").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620724"){-->
						    			<#--document.getElementById("rain_inc_6").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_6").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="152923"){-->
						    			<#--document.getElementById("rain_inc_7").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_7").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620921"){-->
						    			<#--document.getElementById("rain_inc_8").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_8").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620722"){-->
						    			<#--document.getElementById("rain_inc_9").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_9").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620721"){-->
						    			<#--document.getElementById("rain_inc_10").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_10").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620902"){-->
						    			<#--document.getElementById("rain_inc_11").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_11").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620200"){-->
						    			<#--document.getElementById("rain_inc_12").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_12").value = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="632222"){-->
						    			<#--document.getElementById("rain_inc_13").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_13").value = data[i].tempChange;-->
						    		<#--}else{-->
						    			<#--document.getElementById("rain_inc_14").value = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_14").value = data[i].tempChange;-->
						    		<#--}-->
						    	<#---->
						    	<#--}-->
						 <#--}-->
						<#---->
					<#--})-->
					//保存气候情景参数
					$("#climate_submit").click(function() {
						//console.log("执行到此");
						var arr=new Array();  //定义一个形如表格的二维数组
				        arr[0]=new Array(
				        		document.getElementById("toSituation_country1").value,
				        		document.getElementById("toSituation_rain_inc_1").value,
				        		document.getElementById("toSituation_temp_inc_1").value);
				        arr[1]=new Array(
				        		document.getElementById("toSituation_country2").value,
				        		document.getElementById("toSituation_rain_inc_2").value,
				        		document.getElementById("toSituation_temp_inc_2").value);
				        arr[2]=new Array(
				        		document.getElementById("toSituation_country3").value,
				        		document.getElementById("toSituation_rain_inc_3").value,
				        		document.getElementById("toSituation_temp_inc_3").value);
				        arr[3]=new Array(
				        		document.getElementById("toSituation_country4").value,
				        		document.getElementById("toSituation_rain_inc_4").value,
				        		document.getElementById("toSituation_temp_inc_5").value);
				        arr[4]=new Array(
				        		document.getElementById("toSituation_country5").value,
				        		document.getElementById("toSituation_rain_inc_5").value,
				        		document.getElementById("toSituation_temp_inc_5").value);
				        arr[5]=new Array(
				        		document.getElementById("toSituation_country6").value,
				        		document.getElementById("toSituation_rain_inc_6").value,
				        		document.getElementById("toSituation_temp_inc_6").value);
				        arr[6]=new Array(
				        		document.getElementById("toSituation_country7").value,
				        		document.getElementById("toSituation_rain_inc_7").value,
				        		document.getElementById("toSituation_temp_inc_7").value);
				        arr[7]=new Array(
				        		document.getElementById("toSituation_country8").value,
				        		document.getElementById("toSituation_rain_inc_8").value,
				        		document.getElementById("toSituation_temp_inc_8").value);
				        arr[8]=new Array(
				        		document.getElementById("toSituation_country9").value,
				        		document.getElementById("toSituation_rain_inc_9").value,
				        		document.getElementById("toSituation_temp_inc_9").value);
				        arr[9]=new Array(
				        		document.getElementById("toSituation_country10").value,
				        		document.getElementById("toSituation_rain_inc_10").value,
				        		document.getElementById("toSituation_temp_inc_10").value);
				        arr[10]=new Array(
				        		document.getElementById("toSituation_country11").value,
				        		document.getElementById("toSituation_rain_inc_11").value,
				        		document.getElementById("toSituation_temp_inc_11").value);
				        arr[11]=new Array(
				        		document.getElementById("toSituation_country12").value,
				        		document.getElementById("toSituation_rain_inc_12").value,
				        		document.getElementById("toSituation_temp_inc_12").value);
				        arr[12]=new Array(
				        		document.getElementById("toSituation_country13").value,
				        		document.getElementById("toSituation_rain_inc_13").value,
				        		document.getElementById("toSituation_temp_inc_13").value);
				        arr[13]=new Array(
				        		document.getElementById("toSituation_country14").value,
				        		document.getElementById("toSituation_rain_inc_14").value,
				        		document.getElementById("toSituation_temp_inc_14").value);
				        //console.log(arr[0][1]+"  "+arr[0][2]+"  "+arr[0][3]+"  "+arr.length);
						for(var i=0;i<arr.length;i++){
							$.post(
									"saveClimatePara.do",
									{
										"countyId" : arr[i][0],
										"rainInc" : arr[i][1],
										"tempInc" : arr[i][2],
									}, function(data) {
										//alert(data.content);
								})
							}
					})
					</script>
					<!--土地利用情景-->
					<div class="admin-tab-item">
						<div class="admin-card">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${land}</h3>
								<button class="admin-btn admin-btn-blue" id="landuse_submit">${save}</button>
							</div>
							<div class="admin-card-content">
								<table class="admin-table admin-stuation-table">
									<thead>
										<!-- <tr>
											<th rowspan="2"><p align="left">${county}</p></th>
											<th colspan="6" width="80%" style="display: none;"><p>${rate1}(%)</p></th>
											<th colspan="6">${rate2}(%)</th>
										</tr> -->
										<tr>
											<th><p align="left">${county}</p></th>
											<th><p align="left">${geng}(%／${toalyear}${nian})</p></th>
											<th><p align="left">${lin}</p></th>
											<th><p align="left">${cao}</p></th>
											<th><p align="left">${shui}</p></th>
											<!-- <th>${luo}</th>
											<th>${cheng}</th>
											<th>${mai}</th>
											<th>${yu}</th>
											<th>${you}</th>
											<th>${shu}</th>
											<th>${guo}</th>
											<th>${mian}</th> -->
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="toSituation_country1l" value="0" style="display: none;"/><p align="left">${quanliuyu}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form1" value="0" style="text-align: right;" /></td>
											<td><input class="admin-input" type="text" id="toSituation_forest1" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass1" value="0.8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water1" value="1.25" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare1" value="-2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city1" value="10" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh1" value="0.82" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn1" value="0.5" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil1" value="0.5" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg1" value="0.56" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft1" value="1.2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot1" value="1.1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country2l" value="1" style="display: none;"/><p align="left">${upstream}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass2" value="6" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water2" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare2" value="-1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city2" value="0.1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh2" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn2" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil2" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg2" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft2" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot2" value="6" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country3l" value="2" style="display: none;"/><p align="left">${mal}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass3" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water3" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city3" value="9" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft3" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot3" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country4l" value="620702" style="display: none;"/><p align="left">${ganzhou}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form4" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest4" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass4" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water4" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare4" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city4" value="7" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh4" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn4" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil4" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg4" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft4" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot4" value="2" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country5l" value="620723" style="display: none;"/><p align="left">${linze}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form5" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest5" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass5" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water5" value="3" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare5" value="-1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city5" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh5" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn5" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil5" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg5" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft5" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot5" value="3" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country6l" value="620724" style="display: none;"/><p align="left">${gaotai}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form6" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest6" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass6" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water6" value="3" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare6" value="0" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city6" value="6" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh6" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn6" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil6" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg6" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft6" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot6" value="2" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country7l" value="152923" style="display: none;"/><p align="left">${ejinaqi}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form7" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest7" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass7" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water7" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city7" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft7" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot7" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country8l" value="620921" style="display: none;"/><p align="left">${jinta}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form8" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest8" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass8" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water8" value="2" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare8" value="-1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city8" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh8" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn8" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil8" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg8" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft8" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot8" value="3" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country9l" value="620722" style="display: none;"/><p align="left">${minle}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form9" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest9" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass9" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water9" value="2" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare9" value="0" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city9" value="4" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh9" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn9" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil9" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg9" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft9" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot9" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country10l" value="620721" style="display: none;"/><p align="left">${sunan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form10" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest10" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass10" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water10" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft10" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot10" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country11l" value="620902" style="display: none;"/><p align="left">${suzhou}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form11" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest11" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass11" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water11" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city11" value="8" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft11" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot11" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country12l" value="620200" style="display: none;"/><p align="left">${jiayuguan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form12" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest12" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass12" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water12" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare12" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city12" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh12" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn12" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil12" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg12" value="2" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft12" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot12" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country13l" value="632222" style="display: none;"/><p align="left">${qilian}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form13" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest13" value="4" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass13" value="5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water13" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare13" value="-1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft13" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot13" value="1" /></td> -->
										</tr>
										<tr>
											<td><input id="toSituation_country14l" value="620725" style="display: none;"/><p align="left">${shandan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_form14" value="-5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_forest14" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_grass14" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_water14" value="1" style="text-align: right;"/></td>
											<!-- <td><input class="admin-input" type="text" id="toSituation_bare14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_city14" value="3" /></td>
											<td><input class="admin-input" type="text" id="toSituation_wh14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_corn14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_oil14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_veg14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_ft14" value="1" /></td>
											<td><input class="admin-input" type="text" id="toSituation_cot14" value="1" /></td> -->
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="admin-card admin-card-select">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${sc}</h3>
								<select id="selectCounty_land" class="admin-select">
									<option value="620702">${ganzhou}</option>
									<option value="620723">${linze}</option>
									<option value="620724">${gaotai}</option>
									<option value="152923">${ejinaqi}</option>
									<option value="620921">${jinta}</option>
									<option value="620722">${minle}</option>
									<option value="620721">${sunan}</option>
									<option value="620902">${suzhou}</option>
									<option value="620200">${jiayuguan}</option>
									<option value="632222">${qilian}</option>
									<option value="620725">${shandan}</option>
									<option value="0">${quanliuyu}</option>
									<option value="1">${upstream}</option>
									<option value="2">${mal}</option>
								</select>
							</div>
						</div>
						<div>
							<div class="admin-card fl" style="width: 100%;">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${gengbian}</h3>
								</div>
								<div class="admin-card-content admin-card-content-chart">
									<div class="admin-chart-wrap" id="land_show_1"></div>
								</div>
							</div>
							<div class="admin-card fr" style="width: 100%;">
								<div class="admin-card-title">
									<h3 style="font-size: 14px;">${landbian}</h3>
								</div>
								<div class="admin-card-content admin-card-content-chart">
									<div class="admin-chart-wrap" id="land_show_2"></div>
								</div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
					//获取土地利用参数
					$.get("getLandUseScePara.do", 
						{
						<#--  "id" : "${projectId}"  -->
						}, function(data) {
						console.log(data);
						
						var i=0;
						 if(data != null){
						    	for(i;i<=data.length;i++){
						    		if(data[i].countyId=="0"){
						    			document.getElementById("form1").value = data[i].landFarmR;
						    			document.getElementById("forest1").value = data[i].landForestR;
						    			document.getElementById("grass1").value = data[i].landGrassR;
						    			document.getElementById("water1").value = data[i].waterArea;
						    			//document.getElementById("bare1").value = data[i].landBareR;
						    			//document.getElementById("city1").value = data[i].landCityR;
						    			//document.getElementById("wh1").value = data[i].cpwhR;
						    			//document.getElementById("corn1").value = data[i].cpcornR;
						    			//document.getElementById("oil1").value = data[i].cpoilR;
						    			//document.getElementById("veg1").value = data[i].cpvegR;
						    			//document.getElementById("ft1").value = data[i].cpftr;
						    			//document.getElementById("cot1").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="1"){
						    			document.getElementById("form2").value = data[i].landFarmR;
						    			document.getElementById("forest2").value = data[i].landForestR;
						    			document.getElementById("grass2").value = data[i].landGrassR;
						    			document.getElementById("water2").value = data[i].waterArea;
						    			//document.getElementById("bare2").value = data[i].landBareR;
						    			//document.getElementById("city2").value = data[i].landCityR;
						    			//document.getElementById("wh2").value = data[i].cpwhR;
						    			//document.getElementById("corn2").value = data[i].cpcornR;
						    			//document.getElementById("oil2").value = data[i].cpoilR;
						    			//document.getElementById("veg2").value = data[i].cpvegR;
						    			//document.getElementById("ft2").value = data[i].cpftr;
						    			//document.getElementById("cot2").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="2"){
						    			document.getElementById("form3").value = data[i].landFarmR;
						    			document.getElementById("forest3").value = data[i].landForestR;
						    			document.getElementById("grass3").value = data[i].landGrassR;
						    			document.getElementById("water3").value = data[i].waterArea;
						    			//document.getElementById("bare3").value = data[i].landBareR;
						    			//document.getElementById("city3").value = data[i].landCityR;
						    			//document.getElementById("wh3").value = data[i].cpwhR;
						    			//document.getElementById("corn3").value = data[i].cpcornR;
						    			//document.getElementById("oil3").value = data[i].cpoilR;
						    			//document.getElementById("veg3").value = data[i].cpvegR;
						    			//document.getElementById("ft3").value = data[i].cpftr;
						    			//document.getElementById("cot3").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620702"){
						    			document.getElementById("form4").value = data[i].landFarmR;
						    			document.getElementById("forest4").value = data[i].landForestR;
						    			document.getElementById("grass4").value = data[i].landGrassR;
						    			document.getElementById("water4").value = data[i].waterArea;
						    			//document.getElementById("bare4").value = data[i].landBareR;
						    			//document.getElementById("city4").value = data[i].landCityR;
						    			//document.getElementById("wh4").value = data[i].cpwhR;
						    			//document.getElementById("corn4").value = data[i].cpcornR;
						    			//document.getElementById("oil4").value = data[i].cpoilR;
						    			//document.getElementById("veg4").value = data[i].cpvegR;
						    			//document.getElementById("ft4").value = data[i].cpftr;
						    			//document.getElementById("cot4").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620723"){
						    			document.getElementById("form5").value = data[i].landFarmR;
						    			document.getElementById("forest5").value = data[i].landForestR;
						    			document.getElementById("grass5").value = data[i].landGrassR;
						    			document.getElementById("water5").value = data[i].waterArea;
						    			//document.getElementById("bare5").value = data[i].landBareR;
						    			//document.getElementById("city5").value = data[i].landCityR;
						    			//document.getElementById("wh5").value = data[i].cpwhR;
						    			//document.getElementById("corn5").value = data[i].cpcornR;
						    			//document.getElementById("oil5").value = data[i].cpoilR;
						    			//document.getElementById("veg5").value = data[i].cpvegR;
						    			//document.getElementById("ft5").value = data[i].cpftr;
						    			//document.getElementById("cot5").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620724"){
						    			document.getElementById("form6").value = data[i].landFarmR;
						    			document.getElementById("forest6").value = data[i].landForestR;
						    			document.getElementById("grass6").value = data[i].landGrassR;
						    			document.getElementById("water6").value = data[i].waterArea;
						    			//document.getElementById("bare6").value = data[i].landBareR;
						    			//document.getElementById("city6").value = data[i].landCityR;
						    			//document.getElementById("wh6").value = data[i].cpwhR;
						    			//document.getElementById("corn6").value = data[i].cpcornR;
						    			//document.getElementById("oil6").value = data[i].cpoilR;
						    			//document.getElementById("veg6").value = data[i].cpvegR;
						    			//document.getElementById("ft6").value = data[i].cpftr;
						    			//document.getElementById("cot6").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="152923"){
						    			document.getElementById("form7").value = data[i].landFarmR;
						    			document.getElementById("forest7").value = data[i].landForestR;
						    			document.getElementById("grass7").value = data[i].landGrassR;
						    			document.getElementById("water7").value = data[i].waterArea;
						    			//document.getElementById("bare7").value = data[i].landBareR;
						    			//document.getElementById("city7").value = data[i].landCityR;
						    			//document.getElementById("wh7").value = data[i].cpwhR;
						    			//document.getElementById("corn7").value = data[i].cpcornR;
						    			//document.getElementById("oil7").value = data[i].cpoilR;
						    			//document.getElementById("veg7").value = data[i].cpvegR;
						    			//document.getElementById("ft7").value = data[i].cpftr;
						    			//document.getElementById("cot7").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620921"){
						    			document.getElementById("form8").value = data[i].landFarmR;
						    			document.getElementById("forest8").value = data[i].landForestR;
						    			document.getElementById("grass8").value = data[i].landGrassR;
						    			document.getElementById("water8").value = data[i].waterArea;
						    			//document.getElementById("bare8").value = data[i].landBareR;
						    			//document.getElementById("city8").value = data[i].landCityR;
						    			//document.getElementById("wh8").value = data[i].cpwhR;
						    			//document.getElementById("corn8").value = data[i].cpcornR;
						    			//document.getElementById("oil8").value = data[i].cpoilR;
						    			//document.getElementById("veg8").value = data[i].cpvegR;
						    			//document.getElementById("ft8").value = data[i].cpftr;
						    			//document.getElementById("cot8").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620722"){
						    			document.getElementById("form9").value = data[i].landFarmR;
						    			document.getElementById("forest9").value = data[i].landForestR;
						    			document.getElementById("grass9").value = data[i].landGrassR;
						    			document.getElementById("water9").value = data[i].waterArea;
						    			//document.getElementById("bare9").value = data[i].landBareR;
						    			//document.getElementById("city9").value = data[i].landCityR;
						    			//document.getElementById("wh9").value = data[i].cpwhR;
						    			//document.getElementById("corn9").value = data[i].cpcornR;
						    			//document.getElementById("oil9").value = data[i].cpoilR;
						    			//document.getElementById("veg9").value = data[i].cpvegR;
						    			//document.getElementById("ft9").value = data[i].cpftr;
						    			//document.getElementById("cot9").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620721"){
						    			document.getElementById("form10").value = data[i].landFarmR;
						    			document.getElementById("forest10").value = data[i].landForestR;
						    			document.getElementById("grass10").value = data[i].landGrassR;
						    			document.getElementById("water10").value = data[i].waterArea;
						    			//document.getElementById("bare10").value = data[i].landBareR;
						    			//document.getElementById("city10").value = data[i].landCityR;
						    			//document.getElementById("wh10").value = data[i].cpwhR;
						    			//document.getElementById("corn10").value = data[i].cpcornR;
						    			//document.getElementById("oil10").value = data[i].cpoilR;
						    			//document.getElementById("veg10").value = data[i].cpvegR;
						    			//document.getElementById("ft10").value = data[i].cpftr;
						    			//document.getElementById("cot10").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620902"){
						    			document.getElementById("form11").value = data[i].landFarmR;
						    			document.getElementById("forest11").value = data[i].landForestR;
						    			document.getElementById("grass11").value = data[i].landGrassR;
						    			document.getElementById("water11").value = data[i].waterArea;
						    			//document.getElementById("bare11").value = data[i].landBareR;
						    			//document.getElementById("city11").value = data[i].landCityR;
						    			//document.getElementById("wh11").value = data[i].cpwhR;
						    			//document.getElementById("corn11").value = data[i].cpcornR;
						    			//document.getElementById("oil11").value = data[i].cpoilR;
						    			//document.getElementById("veg11").value = data[i].cpvegR;
						    			//document.getElementById("ft11").value = data[i].cpftr;
						    			//document.getElementById("cot11").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="620200"){
						    			document.getElementById("form12").value = data[i].landFarmR;
						    			document.getElementById("forest12").value = data[i].landForestR;
						    			document.getElementById("grass12").value = data[i].landGrassR;
						    			document.getElementById("water12").value = data[i].waterArea;
						    			//document.getElementById("bare12").value = data[i].landBareR;
						    			//document.getElementById("city12").value = data[i].landCityR;
						    			//document.getElementById("wh12").value = data[i].cpwhR;
						    			//document.getElementById("corn12").value = data[i].cpcornR;
						    			//document.getElementById("oil12").value = data[i].cpoilR;
						    			//document.getElementById("veg12").value = data[i].cpvegR;
						    			//document.getElementById("ft12").value = data[i].cpftr;
						    			//document.getElementById("cot12").value = data[i].cpcotR;
						    		}else if(data[i].countyId=="632222"){
						    			document.getElementById("form13").value = data[i].landFarmR;
						    			document.getElementById("forest13").value = data[i].landForestR;
						    			document.getElementById("grass13").value = data[i].landGrassR;
						    			document.getElementById("water13").value = data[i].waterArea;
						    			//document.getElementById("bare13").value = data[i].landBareR;
						    			//document.getElementById("city13").value = data[i].landCityR;
						    			//document.getElementById("wh13").value = data[i].cpwhR;
						    			//document.getElementById("corn13").value = data[i].cpcornR;
						    			//document.getElementById("oil13").value = data[i].cpoilR;
						    			//document.getElementById("veg13").value = data[i].cpvegR;
						    			//document.getElementById("ft13").value = data[i].cpftr;
						    			//document.getElementById("cot13").value = data[i].cpcotR;
						    		}else{
						    			document.getElementById("form14").value = data[i].landFarmR;
						    			document.getElementById("forest14").value = data[i].landForestR;
						    			document.getElementById("grass14").value = data[i].landGrassR;
						    			document.getElementById("water14").value = data[i].waterArea;
						    			//document.getElementById("bare14").value = data[i].landBareR;
						    			//document.getElementById("city14").value = data[i].landCityR;
						    			//document.getElementById("wh14").value = data[i].cpwhR;
						    			//document.getElementById("corn14").value = data[i].cpcornR;
						    			//document.getElementById("oil14").value = data[i].cpoilR;
						    			//document.getElementById("veg14").value = data[i].cpvegR;
						    			//document.getElementById("ft14").value = data[i].cpftr;
						    			//document.getElementById("cot14").value = data[i].cpcotR;
						    		}
						    	
						    	}
						 }
						
					})
					//保存土地利用情景参数
					$("#landuse_submit").click(function() {
						//console.log("执行到此");
						var arr=new Array();  //定义一个形如表格的二维数组
				        arr[0]=new Array(
									document.getElementById("toSituation_country1l").value,
									document.getElementById("toSituation_form1").value,
				    			document.getElementById("toSituation_forest1").value,
				    			document.getElementById("toSituation_grass1").value,
				    			document.getElementById("toSituation_water1").value
				    			//document.getElementById("toSituation_bare1").value,
				    			//document.getElementById("toSituation_city1").value
				    			//document.getElementById("toSituation_wh1").value,
				    			//document.getElementById("toSituation_corn1").value,
				    			//document.getElementById("toSituation_oil1").value,
				    			//document.getElementById("toSituation_veg1").value,
				    			//document.getElementById("toSituation_ft1").value,
				    			//document.getElementById("toSituation_cot1").value
				    			);
				        arr[1]=new Array(
									document.getElementById("toSituation_country2l").value,
									document.getElementById("toSituation_form2").value,
				    			document.getElementById("toSituation_forest2").value,
				    			document.getElementById("toSituation_grass2").value,
				    			document.getElementById("toSituation_water2").value
				    			//document.getElementById("toSituation_bare2").value,
				    			//document.getElementById("toSituation_city2").value
				    			//document.getElementById("toSituation_wh2").value,
				    			//document.getElementById("toSituation_corn2").value,
				    			//document.getElementById("toSituation_oil2").value,
				    			//document.getElementById("toSituation_veg2").value,
				    			//document.getElementById("toSituation_ft2").value,
				    			//document.getElementById("toSituation_cot2").value
				    			);
				        arr[2]=new Array(
									document.getElementById("toSituation_country3l").value,
									document.getElementById("toSituation_form3").value,
				    			document.getElementById("toSituation_forest3").value,
				    			document.getElementById("toSituation_grass3").value,
				    			document.getElementById("toSituation_water3").value
				    			//document.getElementById("toSituation_bare3").value,
				    			//document.getElementById("toSituation_city3").value
				    			//document.getElementById("toSituation_wh3").value,
				    			//document.getElementById("toSituation_corn3").value,
				    			//document.getElementById("toSituation_oil3").value,
				    			//document.getElementById("toSituation_veg3").value,
				    			//document.getElementById("toSituation_ft3").value,
				    			//document.getElementById("toSituation_cot3").value
				    			);
				        arr[3]=new Array(
									document.getElementById("toSituation_country4l").value,
									document.getElementById("toSituation_form4").value,
				    			document.getElementById("toSituation_forest4").value,
				    			document.getElementById("toSituation_grass4").value,
				    			document.getElementById("toSituation_water4").value
				    			//document.getElementById("toSituation_bare4").value,
				    			//document.getElementById("toSituation_city4").value
				    			//document.getElementById("toSituation_wh4").value,
				    			//document.getElementById("toSituation_corn4").value,
				    			//document.getElementById("toSituation_oil4").value,
				    			//document.getElementById("toSituation_veg4").value,
				    			//document.getElementById("toSituation_ft4").value,
				    			//document.getElementById("toSituation_cot4").value
				    			);
				        arr[4]=new Array(
									document.getElementById("toSituation_country5l").value,
									document.getElementById("toSituation_form5").value,
				    			document.getElementById("toSituation_forest5").value,
				    			document.getElementById("toSituation_grass5").value,
				    			document.getElementById("toSituation_water5").value
				    			//document.getElementById("toSituation_bare5").value,
				    			//document.getElementById("toSituation_city5").value
				    			//document.getElementById("toSituation_wh5").value,
				    			//document.getElementById("toSituation_corn5").value,
				    			//document.getElementById("toSituation_oil5").value,
				    			//document.getElementById("toSituation_veg5").value,
				    			//document.getElementById("toSituation_ft5").value,
				    			//document.getElementById("toSituation_cot5").value
				    			);
				        arr[5]=new Array(
									document.getElementById("toSituation_country6l").value,
									document.getElementById("toSituation_form6").value,
				    			document.getElementById("toSituation_forest6").value,
				    			document.getElementById("toSituation_grass6").value,
				    			document.getElementById("toSituation_water6").value
				    			//document.getElementById("toSituation_bare6").value,
				    			//document.getElementById("toSituation_city6").value
				    			//document.getElementById("toSituation_wh6").value,
				    			//document.getElementById("toSituation_corn6").value,
				    			//document.getElementById("toSituation_oil6").value,
				    			//document.getElementById("toSituation_veg6").value,
				    			//document.getElementById("toSituation_ft6").value,
				    			//document.getElementById("toSituation_cot6").value
				    			);
				        arr[6]=new Array(
									document.getElementById("toSituation_country7l").value,
									document.getElementById("toSituation_form7").value,
				    			document.getElementById("toSituation_forest7").value,
				    			document.getElementById("toSituation_grass7").value,
				    			document.getElementById("toSituation_water7").value
				    			//document.getElementById("toSituation_bare7").value,
				    			//document.getElementById("toSituation_city7").value
				    			//document.getElementById("toSituation_wh7").value,
				    			//document.getElementById("toSituation_corn7").value,
				    			//document.getElementById("toSituation_oil7").value,
				    			//document.getElementById("toSituation_veg7").value,
				    			//document.getElementById("toSituation_ft7").value,
				    			//document.getElementById("toSituation_cot7").value
				    			);
				        arr[7]=new Array(
									document.getElementById("toSituation_country8l").value,
									document.getElementById("toSituation_form8").value,
				    			document.getElementById("toSituation_forest8").value,
				    			document.getElementById("toSituation_grass8").value,
				    			document.getElementById("toSituation_water8").value
				    			//document.getElementById("toSituation_bare8").value,
				    			//document.getElementById("toSituation_city8").value
				    			//document.getElementById("toSituation_wh8").value,
				    			//document.getElementById("toSituation_corn8").value,
				    			//document.getElementById("toSituation_oil8").value,
				    			//document.getElementById("toSituation_veg8").value,
				    			//document.getElementById("toSituation_ft8").value,
				    			//document.getElementById("toSituation_cot8").value
				    			);
				        arr[8]=new Array(
									document.getElementById("toSituation_country9l").value,
									document.getElementById("toSituation_form9").value,
				    			document.getElementById("toSituation_forest9").value,
				    			document.getElementById("toSituation_grass9").value,
				    			document.getElementById("toSituation_water9").value
				    			//document.getElementById("toSituation_bare9").value,
				    			//document.getElementById("toSituation_city9").value
				    			//document.getElementById("toSituation_wh9").value,
				    			//document.getElementById("toSituation_corn9").value,
				    			//document.getElementById("toSituation_oil9").value,
				    			//document.getElementById("toSituation_veg9").value,
				    			//document.getElementById("toSituation_ft9").value,
				    			//document.getElementById("toSituation_cot9").value
				    			);
				        arr[9]=new Array(
									document.getElementById("toSituation_country10l").value,
									document.getElementById("toSituation_form10").value,
				    			document.getElementById("toSituation_forest10").value,
				    			document.getElementById("toSituation_grass10").value,
				    			document.getElementById("toSituation_water10").value
				    			//document.getElementById("toSituation_bare10").value,
				    			//document.getElementById("toSituation_city10").value
				    			//document.getElementById("toSituation_wh10").value,
				    			//document.getElementById("toSituation_corn10").value,
				    			//document.getElementById("toSituation_oil10").value,
				    			//document.getElementById("toSituation_veg10").value,
				    			//document.getElementById("toSituation_ft10").value,
				    			//document.getElementById("toSituation_cot10").value
				    			);
				        arr[10]=new Array(
									document.getElementById("toSituation_country11l").value,
									document.getElementById("toSituation_form11").value,
				    			document.getElementById("toSituation_forest11").value,
				    			document.getElementById("toSituation_grass11").value,
				    			document.getElementById("toSituation_water11").value
				    			//document.getElementById("toSituation_bare11").value,
				    			//document.getElementById("toSituation_city11").value
				    			//document.getElementById("toSituation_wh11").value,
				    			//document.getElementById("toSituation_corn11").value,
				    			//document.getElementById("toSituation_oil11").value,
				    			//document.getElementById("toSituation_veg11").value,
				    			//document.getElementById("toSituation_ft11").value,
				    			//document.getElementById("toSituation_cot11").value
				    			);
				        arr[11]=new Array(
									document.getElementById("toSituation_country12l").value,
									document.getElementById("toSituation_form12").value,
				    			document.getElementById("toSituation_forest12").value,
				    			document.getElementById("toSituation_grass12").value,
				    			document.getElementById("toSituation_water12").value
				    			//document.getElementById("toSituation_bare12").value,
				    			//document.getElementById("toSituation_city12").value
				    			//document.getElementById("toSituation_wh12").value,
				    			//document.getElementById("toSituation_corn12").value,
				    			//document.getElementById("toSituation_oil12").value,
				    			//document.getElementById("toSituation_veg12").value,
				    			//document.getElementById("toSituation_ft12").value,
				    			//document.getElementById("toSituation_cot12").value
				    			);
				        arr[12]=new Array(
									document.getElementById("toSituation_country13l").value,
									document.getElementById("toSituation_form13").value,
				    			document.getElementById("toSituation_forest13").value,
				    			document.getElementById("toSituation_grass13").value,
				    			document.getElementById("toSituation_water13").value
				    			//document.getElementById("toSituation_bare13").value,
				    			//document.getElementById("toSituation_city13").value
				    			//document.getElementById("toSituation_wh13").value,
				    			//document.getElementById("toSituation_corn13").value,
				    			//document.getElementById("toSituation_oil13").value,
				    			//document.getElementById("toSituation_veg13").value,
				    			//document.getElementById("toSituation_ft13").value,
				    			//document.getElementById("toSituation_cot13").value
				    			);
				        arr[13]=new Array(
									document.getElementById("toSituation_country14l").value,
									document.getElementById("toSituation_form14").value,
				    			document.getElementById("toSituation_forest14").value,
				    			document.getElementById("toSituation_grass14").value,
				    			document.getElementById("toSituation_water14").value
				    			//document.getElementById("toSituation_bare14").value,
				    			//document.getElementById("toSituation_city14").value
				    			//document.getElementById("toSituation_wh14").value,
				    			//document.getElementById("toSituation_corn14").value,
				    			//document.getElementById("toSituation_oil14").value,
				    			//document.getElementById("toSituation_veg14").value,
				    			//document.getElementById("toSituation_ft14").value,
				    			//document.getElementById("toSituation_cot14").value
				    			);
				        //console.log(arr[0][1]+"  "+arr[0][2]+"  "+arr[0][3]+"  "+arr.length);
						for(var i=0;i<arr.length;i++){
							$.post(
									"saveLandUsePara.do",
									{
										<#--  "projectId" :   -->
										"countyId" : arr[i][0],
										"LandFarmR": arr[i][1], 
										"LandForestR":arr[i][2],
										"LandGrassR":arr[i][3],
										"WaterArea":arr[i][4], 
										"LandBareR":'0',
										"LandCityR":'0',
										"CPWhR":'0',
										"CPCornR":'0', 
										"CPOilR":'0',
										"CPVegR":'0',
										"CPFTR":'0',
										"CPCotR":'0'
									}, function(data) {
										//alert(data.content);
								})
							}
					})
					</script>
					<!--社会经济情景-->
					<div class="admin-tab-item">
						<div class="admin-card">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${soc}</h3>
								<button class="admin-btn admin-btn-blue" id="soceco_submit">${save}</button>
							</div>
							<div class="admin-card-content">
								<table class="admin-table admin-stuation-table">
									<thead>
										<tr>
											<th><p align="left">${county}</p></th>
											<th><p align="left">${popo}</p></th>
											<th><p align="left">${aptr}(%／${toalyear}${nian})<p></th>
											<th><p align="left">${itpr}(%／${toalyear}${nian})</p></th>
											<th><p align="left">${sitpr}(%／${toalyear}${nian})</p></th>
											<th><p align="left">${urpar}</p></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="toSituation_country1s" value="0" style="display: none;"/><p align="left">${quanliuyu}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy1" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg1" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind1" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser1" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban1" value="0" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country2s" value="1" style="display: none;"/><p align="left">${upstream}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser2" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban2" value="0" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country3s" value="2" style="display: none;"/><p align="left">${mal}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser3" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban3" value="0" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country4s" value="620702" style="display: none;"/><p align="left">${ganzhou}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy4" value="0.0069" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg4" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind4" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser4" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban4" value="-0.0698" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country5s" value="620723" style="display: none;"/><p align="left">${linze}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy5" value="-0.0069" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg5" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind5" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser5" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban5" value="-0.0698" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country6s" value="620724" style="display: none;"/><p align="left">${gaotai}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy6" value="-0.0081" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg6" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind6" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser6" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban6" value="-0.0698" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country7s" value="152923" style="display: none;"/><p align="left">${ejinaqi}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy7" value="-0.003" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg7" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind7" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser7" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban7" value="0.0228" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country8s" value="620921" style="display: none;"/><p align="left">${jinta}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy8" value="0.0108" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg8" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind8" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser8" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban8" value="-0.0618" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country9s" value="620722" style="display: none;"/><p align="left">${minle}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy9" value="-0.0055" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg9" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind9" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser9" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban9" value="-0.0698" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country10s" value="620721" style="display: none;"/><p align="left">${sunan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy10" value="-0.0049" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg10" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind10" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser10" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban10" value="-0.0518" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country11s" value="620902" style="display: none;"/><p align="left">${suzhou}<p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy11" value="0.01" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg11" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind11" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser11" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban11" value="-0.0618" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country12s" value="620200" style="display: none;"/><p align="left">${jiayuguan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy12" value="0.0356" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg12" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind12" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser12" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban12" value="-0.1115" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country13s" value="632222" style="display: none;"/><p align="left">${qilian}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy13" value="-0.0049" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg13" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind13" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser13" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban13" value="-0.0518" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country14s" value="620725" style="display: none;"/><p align="left">${shandan}</p></td>
											<td><input class="admin-input" type="text" id="toSituation_licy14" value="-0.015" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_arg14" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ind14" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_ser14" value="8" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_urban14" value="-0.0698" style="text-align: right;"/></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 隐藏不显示 -->
						<div class="admin-card admin-card-select" style="display: none;">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${sc}</h3>
								<select id="selectCounty_quchang" class="admin-select">
									<option value="620702">${ganzhou}</option>
									<option value="620723">${linze}</option>
									<option value="620724">${gaotai}</option>
									<option value="152923">${ejinaqi}</option>
									<option value="620921">${jinta}</option>
									<option value="620722">${minle}</option>
									<option value="620721">${sunan}</option>
									<option value="620902">${suzhou}</option>
									<option value="620200">${jiayuguan}</option>
									<option value="632222">${qilian}</option>
									<option value="620725">${shandan}</option>
									<option value="0">${quanliuyu}</option>
									<option value="1">${upstream}</option>
									<option value="2">${mal}</option>
								</select>
							</div>
						</div>
						<!-- 隐藏不显示 -->
						<div class="admin-card" style="display: none;">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${qcbiao}</h3>
							</div>
							<div class="admin-card-content admin-card-content-chart">
								<div class="admin-chart-wrap" id="showArea-5"></div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
					//获取社会经济情景参数
					$.get("getSocEcoPara.do", 
						{
						<#--  "id" : "${projectId}"  -->
						}, function(data) {
						console.log(data);
						var i=0;
						 if(data != null){
						    	for(i;i<=data.length;i++){
						    		if(data[i].countyId=="0"){
						    			document.getElementById("licy1").value = data[i].popolicy;
						    			document.getElementById("arg1").value = data[i].iararg;
						    			document.getElementById("ind1").value = data[i].iarind;
						    			document.getElementById("ser1").value = data[i].iarser;
						    			document.getElementById("urban1").value = data[i].negak;
						    		}else if(data[i].countyId=="1"){
						    			document.getElementById("licy2").value = data[i].popolicy;
						    			document.getElementById("arg2").value = data[i].iararg;
						    			document.getElementById("ind2").value = data[i].iarind;
						    			document.getElementById("ser2").value = data[i].iarser;
						    			document.getElementById("urban2").value = data[i].negak;
						    		}else if(data[i].countyId=="2"){
						    			document.getElementById("licy3").value = data[i].popolicy;
						    			document.getElementById("arg3").value = data[i].iararg;
						    			document.getElementById("ind3").value = data[i].iarind;
						    			document.getElementById("ser3").value = data[i].iarser;
						    			document.getElementById("urban3").value = data[i].negak;
						    		}else if(data[i].countyId=="620702"){
						    			document.getElementById("licy4").value = data[i].popolicy;
						    			document.getElementById("arg4").value = data[i].iararg;
						    			document.getElementById("ind4").value = data[i].iarind;
						    			document.getElementById("ser4").value = data[i].iarser;
						    			document.getElementById("urban4").value = data[i].negak;
						    		}else if(data[i].countyId=="620723"){
						    			document.getElementById("licy5").value = data[i].popolicy;
						    			document.getElementById("arg5").value = data[i].iararg;
						    			document.getElementById("ind5").value = data[i].iarind;
						    			document.getElementById("ser5").value = data[i].iarser;
						    			document.getElementById("urban5").value = data[i].negak;
						    		}else if(data[i].countyId=="620724"){
						    			document.getElementById("licy6").value = data[i].popolicy;
						    			document.getElementById("arg6").value = data[i].iararg;
						    			document.getElementById("ind6").value = data[i].iarind;
						    			document.getElementById("ser6").value = data[i].iarser;
						    			document.getElementById("urban6").value = data[i].negak;
						    		}else if(data[i].countyId=="152923"){
						    			document.getElementById("licy7").value = data[i].popolicy;
						    			document.getElementById("arg7").value = data[i].iararg;
						    			document.getElementById("ind7").value = data[i].iarind;
						    			document.getElementById("ser7").value = data[i].iarser;
						    			document.getElementById("urban7").value = data[i].negak;
						    		}else if(data[i].countyId=="620921"){
						    			document.getElementById("licy8").value = data[i].popolicy;
						    			document.getElementById("arg8").value = data[i].iararg;
						    			document.getElementById("ind8").value = data[i].iarind;
						    			document.getElementById("ser8").value = data[i].iarser;
						    			document.getElementById("urban8").value = data[i].negak;
						    		}else if(data[i].countyId=="620722"){
						    			document.getElementById("licy9").value = data[i].popolicy;
						    			document.getElementById("arg9").value = data[i].iararg;
						    			document.getElementById("ind9").value = data[i].iarind;
						    			document.getElementById("ser9").value = data[i].iarser;
						    			document.getElementById("urban9").value = data[i].negak;
						    		}else if(data[i].countyId=="620721"){
						    			document.getElementById("licy10").value = data[i].popolicy;
						    			document.getElementById("arg10").value = data[i].iararg;
						    			document.getElementById("ind10").value = data[i].iarind;
						    			document.getElementById("ser10").value = data[i].iarser;
						    			document.getElementById("urban10").value = data[i].negak;
						    		}else if(data[i].countyId=="620902"){
						    			document.getElementById("licy11").value = data[i].popolicy;
						    			document.getElementById("arg11").value = data[i].iararg;
						    			document.getElementById("ind11").value = data[i].iarind;
						    			document.getElementById("ser11").value = data[i].iarser;
						    			document.getElementById("urban11").value = data[i].negak;
						    		}else if(data[i].countyId=="620200"){
						    			document.getElementById("licy12").value = data[i].popolicy;
						    			document.getElementById("arg12").value = data[i].iararg;
						    			document.getElementById("ind12").value = data[i].iarind;
						    			document.getElementById("ser12").value = data[i].iarser;
						    			document.getElementById("urban12").value = data[i].negak;
						    		}else if(data[i].countyId=="632222"){
						    			document.getElementById("licy13").value = data[i].popolicy;
						    			document.getElementById("arg13").value = data[i].iararg;
						    			document.getElementById("ind13").value = data[i].iarind;
						    			document.getElementById("ser13").value = data[i].iarser;
						    			document.getElementById("urban13").value = data[i].negak;
						    		}else{
						    			document.getElementById("licy14").value = data[i].popolicy;
						    			document.getElementById("arg14").value = data[i].iararg;
						    			document.getElementById("ind14").value = data[i].iarind;
						    			document.getElementById("ser14").value = data[i].iarser;
						    			document.getElementById("urban14").value = data[i].negak;
						    		}
						    	
						    	}
						 }
						
					})
					//保存社会经济情景参数
					$("#soceco_submit").click(function() {
						
						var arr=new Array();  //定义一个形如表格的二维数组
				        arr[0]=new Array(
									document.getElementById("toSituation_country1s").value,
									document.getElementById("toSituation_licy1").value,
				    			document.getElementById("toSituation_arg1").value,
				    			document.getElementById("toSituation_ind1").value,
				    			document.getElementById("toSituation_ser1").value,
				    			document.getElementById("toSituation_urban1").value)
				        arr[1]=new Array(
									document.getElementById("toSituation_country2s").value,
									document.getElementById("toSituation_licy2").value,
				    			document.getElementById("toSituation_arg2").value,
				    			document.getElementById("toSituation_ind2").value,
				    			document.getElementById("toSituation_ser2").value,
				    			document.getElementById("toSituation_urban2").value);
				        arr[2]=new Array(
									document.getElementById("toSituation_country3s").value,
									document.getElementById("toSituation_licy3").value,
				    			document.getElementById("toSituation_arg3").value,
				    			document.getElementById("toSituation_ind3").value,
				    			document.getElementById("toSituation_ser3").value,
				    			document.getElementById("toSituation_urban3").value);
				        arr[3]=new Array(
									document.getElementById("toSituation_country4s").value,
									document.getElementById("toSituation_licy4").value,
				    			document.getElementById("toSituation_arg4").value,
				    			document.getElementById("toSituation_ind4").value,
				    			document.getElementById("toSituation_ser4").value,
				    			document.getElementById("toSituation_urban4").value);
				        arr[4]=new Array(
									document.getElementById("toSituation_country5s").value,
									document.getElementById("toSituation_licy5").value,
				    			document.getElementById("toSituation_arg5").value,
				    			document.getElementById("toSituation_ind5").value,
				    			document.getElementById("toSituation_ser5").value,
				    			document.getElementById("toSituation_urban5").value);
				        arr[5]=new Array(
									document.getElementById("toSituation_country6s").value,
									document.getElementById("toSituation_licy6").value,
				    			document.getElementById("toSituation_arg6").value,
				    			document.getElementById("toSituation_ind6").value,
				    			document.getElementById("toSituation_ser6").value,
				    			document.getElementById("toSituation_urban6").value);
				        arr[6]=new Array(
									document.getElementById("toSituation_country7s").value,
									document.getElementById("toSituation_licy7").value,
				    			document.getElementById("toSituation_arg7").value,
				    			document.getElementById("toSituation_ind7").value,
				    			document.getElementById("toSituation_ser7").value,
				    			document.getElementById("toSituation_urban7").value);
				        arr[7]=new Array(
									document.getElementById("toSituation_country8s").value,
									document.getElementById("toSituation_licy8").value,
				    			document.getElementById("toSituation_arg8").value,
				    			document.getElementById("toSituation_ind8").value,
				    			document.getElementById("toSituation_ser8").value,
				    			document.getElementById("toSituation_urban8").value);
				        arr[8]=new Array(
									document.getElementById("toSituation_country9s").value,
									document.getElementById("toSituation_licy9").value,
				    			document.getElementById("toSituation_arg9").value,
				    			document.getElementById("toSituation_ind9").value,
				    			document.getElementById("toSituation_ser9").value,
				    			document.getElementById("toSituation_urban9").value);
				        arr[9]=new Array(
									document.getElementById("toSituation_country10s").value,
									document.getElementById("toSituation_licy10").value,
				    			document.getElementById("toSituation_arg10").value,
				    			document.getElementById("toSituation_ind10").value,
				    			document.getElementById("toSituation_ser10").value,
				    			document.getElementById("toSituation_urban10").value);
				        arr[10]=new Array(
									document.getElementById("toSituation_country11s").value,
									document.getElementById("toSituation_licy11").value,
				    			document.getElementById("toSituation_arg11").value,
				    			document.getElementById("toSituation_ind11").value,
				    			document.getElementById("toSituation_ser11").value,
				    			document.getElementById("toSituation_urban11").value);
				        arr[11]=new Array(
									document.getElementById("toSituation_country12s").value,
									document.getElementById("toSituation_licy12").value,
				    			document.getElementById("toSituation_arg12").value,
				    			document.getElementById("toSituation_ind12").value,
				    			document.getElementById("toSituation_ser12").value,
				    			document.getElementById("toSituation_urban12").value);
				        arr[12]=new Array(
									document.getElementById("toSituation_country13s").value,
									document.getElementById("toSituation_licy13").value,
				    			document.getElementById("toSituation_arg13").value,
				    			document.getElementById("toSituation_ind13").value,
				    			document.getElementById("toSituation_ser13").value,
				    			document.getElementById("toSituation_urban13").value);
				        arr[13]=new Array(
									document.getElementById("toSituation_country14s").value,
									document.getElementById("toSituation_licy14").value,
				    			document.getElementById("toSituation_arg14").value,
				    			document.getElementById("toSituation_ind14").value,
				    			document.getElementById("toSituation_ser14").value,
				    			document.getElementById("toSituation_urban14").value);
				        
						for(var i=0;i<arr.length;i++){
							$.post(
									"saveSocEcoPara.do",
									{
										<#--  "projectId" :   -->
										"countyId" : arr[i][0],
										 "popolicy":arr[i][1], 
										 "IARArg":arr[i][2], 
										 "IARInd":arr[i][3], 
										 "IARSer":arr[i][4],
										 "negak":arr[i][5]
									}, function(data) {
										//alert(data.content);
								})
							}
					})
					</script>
					<!--水资源管理情景-->
					<div class="admin-tab-item">
						<div class="admin-card">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${water}</h3>
								<button class="admin-btn admin-btn-blue" id="water_submit">${save}</button>
							</div>
							<div class="admin-card-content">
								<table class="admin-table admin-stuation-table">
									<thead>
										<tr>
											<th><p align="left">${county}</p></th>
											<th style="display: none;"><p align="left">${shang}(${e})</p></th>
											<th><p align="left">${xia}(${e})</p></th>
											<th><p align="left">${drink}(%)</p></th>
											<th><p align="left">${dbw}(%／${toalyear}${nian})</p></th>
											<th><p align="left">${dxw}(%／${toalyear}${nian})</p></th>
											<th><p align="left">${fn}(${e})</p></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input id="toSituation_country1w" value="0" style="display: none;"/><p align="left">${quanliuyu}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up1" value="22" style="text-align: right;"/></td>
											<#--<td><input class="admin-input" type="text" id="toSituation_down1" value="10" style="text-align: right;"/></td>-->
											<td><input class="admin-input" type="text" id="toSituation_down1" value="哈哈哈哈" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb1" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur1" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw1" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup1" value="2" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country2w" value="1" style="display: none;"/><p align="left">${upstream}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up2" value="20" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down2" value="10" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb2" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur2" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw2" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup2" value="1" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country3w" value="2" style="display: none;"/><p align="left">${mal}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up3" value="20" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down3" value="10" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb3" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur3" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw3" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup3" value="1" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country4w" value="620702" style="display: none;"/><p align="left">${ganzhou}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up4" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down4" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb4" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur4" value="-3.35" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw4" value="5.94" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup4" value="1.28" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country5w" value="620723" style="display: none;"/><p align="left">${linze}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up5" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down5" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb5" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur5" value="-0.42" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw5" value="6.75" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup5" value="0.1" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country6w" value="620724" style="display: none;"/><p align="left">${gaotai}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up6" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down6" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb6" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur6" value="-0.43" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw6" value="9.32" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup6" value="0.08" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country7w" value="152923" style="display: none;"/><p align="left">${ejinaqi}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up7" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down7" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb7" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur7" value="0.3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw7" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup7" value="0.11" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country8w" value="620921" style="display: none;"/><p align="left">${jinta}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up8" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down8" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb8" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur8" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw8" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup8" value="0.52" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country9w" value="620722" style="display: none;"/><p align="left">${minle}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up9" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down9" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb9" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur9" value="1.71" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw9" value="18.25" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup9" value="0.07" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country10w" value="620721" style="display: none;"/><p align="left">${sunan}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up10" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down10" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb10" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur10" value="11.51" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw10" value="4.25" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup10" value="0.03" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country11w" value="620902" style="display: none;"/><p align="left">${suzhou}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up11" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down11" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb11" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur11" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw11" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup11" value="1.07" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country12w" value="620200" style="display: none;"/><p align="left">${jiayuguan}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up12" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down12" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb12" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur12" value="0.16" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw12" value="0.52" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup12" value="0.94" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country13w" value="632222" style="display: none;"/><p align="left">${qilian}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up13" value="2" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down13" value="0" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb13" value="3" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur13" value="0.5" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw13" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup13" value="0.04" style="text-align: right;"/></td>
										</tr>
										<tr>
											<td><input id="toSituation_country14w" value="620725" style="display: none;"/><p align="left">${shandan}</p></td>
											<td style="display: none;"><input class="admin-input" type="text" id="toSituation_up14" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_down14" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_wdb14" value="1" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sur14" value="-0.31" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_gw14" value="1.74" style="text-align: right;"/></td>
											<td><input class="admin-input" type="text" id="toSituation_sup14" value="0.12" style="text-align: right;"/></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 
						<div class="admin-card admin-card-select">
							<div class="admin-card-title">
								<h3>选择县区</h3>
								<select class="admin-select">
									<option value="620702">甘州</option>
									<option value="620723">临泽</option>
									<option value="620724">高台</option>
									<option value="152923">额济纳旗</option>
									<option value="620921">金塔</option>
									<option value="620722">民乐</option>
									<option value="620721">肃南</option>
									<option value="620902">肃州</option>
									<option value="620200">嘉峪关市</option>
									<option value="632222">祁连</option>
									<option value="620725">山丹</option>
									<option value="620902">全流域</option>
									<option value="620902">上游</option>
									<option value="620200">中下游</option>
								</select>
							</div>
						</div>
						 -->
						 <!-- 隐藏不显示 -->
						<div class="admin-card" style="display: none;">
							<div class="admin-card-title">
								<h3 style="font-size: 14px;">${waterbian}</h3>
							</div>
							<div class="admin-card-content admin-card-content-chart">
								<div class="admin-chart-wrap" id="using-water"></div>
							</div>
						</div>
						<#--  <div class="admin-tab-item-zu" style="text-align: right;">
							<a href="jumpToResult.do" target="adminFrameName" class="admin-btn">${next}</a>
						</div>  -->
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		<#--//获取水资源管理参数-->
		<#--$.get("getWaterPara.do", -->
			<#--{-->
			<#--"id" : "${projectId}"-->
			<#--}, function(data) {-->
			<#--console.log(data);-->
			<#--var i=0;-->
			 <#--if(data != undefined){-->
			    	<#--for(i;i<=data.length;i++){-->
			    		<#--if(data[i].countyId=="0"){-->
			    			<#--document.getElementById("up1").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down1").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb1").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur1").value = data[i].surSup;-->
			    			<#--document.getElementById("gw1").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup1").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="1"){-->
			    			<#--document.getElementById("up2").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down2").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb2").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur2").value = data[i].surSup;-->
			    			<#--document.getElementById("gw2").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup2").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="2"){-->
			    			<#--document.getElementById("up3").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down3").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb3").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur3").value = data[i].surSup;-->
			    			<#--document.getElementById("gw3").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup3").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620702"){-->
			    			<#--document.getElementById("up4").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down4").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb4").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur4").value = data[i].surSup;-->
			    			<#--document.getElementById("gw4").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup4").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620723"){-->
			    			<#--document.getElementById("up5").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down5").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb5").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur5").value = data[i].surSup;-->
			    			<#--document.getElementById("gw5").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup5").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620724"){-->
			    			<#--document.getElementById("up6").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down6").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb6").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur6").value = data[i].surSup;-->
			    			<#--document.getElementById("gw6").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup6").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="152923"){-->
			    			<#--document.getElementById("up7").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down7").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb7").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur7").value = data[i].surSup;-->
			    			<#--document.getElementById("gw7").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup7").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620921"){-->
			    			<#--document.getElementById("up8").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down8").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb8").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur8").value = data[i].surSup;-->
			    			<#--document.getElementById("gw8").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup8").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620722"){-->
			    			<#--document.getElementById("up9").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down9").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb9").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur9").value = data[i].surSup;-->
			    			<#--document.getElementById("gw9").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup9").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620721"){-->
			    			<#--document.getElementById("up10").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down10").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb10").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur10").value = data[i].surSup;-->
			    			<#--document.getElementById("gw10").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup10").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620902"){-->
			    			<#--document.getElementById("up11").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down11").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb11").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur11").value = data[i].surSup;-->
			    			<#--document.getElementById("gw11").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup11").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="620200"){-->
			    			<#--document.getElementById("up12").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down12").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb12").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur12").value = data[i].surSup;-->
			    			<#--document.getElementById("gw12").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup12").value = data[i].supWater;-->
			    		<#--}else if(data[i].countyId=="632222"){-->
			    			<#--document.getElementById("up13").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down13").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb13").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur13").value = data[i].surSup;-->
			    			<#--document.getElementById("gw13").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup13").value = data[i].supWater;-->
			    		<#--}else{-->
			    			<#--document.getElementById("up14").value = data[i].upstreamwater;-->
			    			<#--document.getElementById("down14").value = data[i].flowDown;-->
			    			<#--document.getElementById("wdb14").value = data[i].waterdistribution;-->
			    			<#--document.getElementById("sur14").value = data[i].surSup;-->
			    			<#--document.getElementById("gw14").value = data[i].gwsup;-->
			    			<#--document.getElementById("sup14").value = data[i].supWater;-->
			    		<#--}-->
			    	<#---->
			    	<#--}-->
			 <#--}-->
			<#---->
		<#--})-->
		<#--//保存水资源管理参数-->
					$("#water_submit").click(function() {

						var arr=new Array();  //定义一个形如表格的二维数组
				        arr[0]=new Array(
									document.getElementById("toSituation_country1w").value,
									document.getElementById("toSituation_up1").value,
				    			document.getElementById("toSituation_down1").value,
				    			document.getElementById("toSituation_wdb1").value,
				    			document.getElementById("toSituation_sur1").value,
				    			document.getElementById("toSituation_gw1").value,
				    			document.getElementById("toSituation_sup1").value)
				        arr[1]=new Array(
									document.getElementById("toSituation_country2w").value,
									document.getElementById("toSituation_up2").value,
				    			document.getElementById("toSituation_down2").value,
				    			document.getElementById("toSituation_wdb2").value,
				    			document.getElementById("toSituation_sur2").value,
				    			document.getElementById("toSituation_gw2").value,
				    			document.getElementById("toSituation_sup2").value);
				        arr[2]=new Array(
									document.getElementById("toSituation_country3w").value,
									document.getElementById("toSituation_up3").value,
				    			document.getElementById("toSituation_down3").value,
				    			document.getElementById("toSituation_wdb3").value,
				    			document.getElementById("toSituation_sur3").value,
				    			document.getElementById("toSituation_gw3").value,
				    			document.getElementById("toSituation_sup3").value);
				        arr[3]=new Array(
									document.getElementById("toSituation_country4w").value,
									document.getElementById("toSituation_up4").value,
				    			document.getElementById("toSituation_down4").value,
				    			document.getElementById("toSituation_wdb4").value,
				    			document.getElementById("toSituation_sur4").value,
				    			document.getElementById("toSituation_gw4").value,
				    			document.getElementById("toSituation_sup4").value);
				        arr[4]=new Array(
									document.getElementById("toSituation_country5w").value,
									document.getElementById("toSituation_up5").value,
				    			document.getElementById("toSituation_down5").value,
				    			document.getElementById("toSituation_wdb5").value,
				    			document.getElementById("toSituation_sur5").value,
				    			document.getElementById("toSituation_gw5").value,
				    			document.getElementById("toSituation_sup5").value);
				        arr[5]=new Array(
									document.getElementById("toSituation_country6w").value,
									document.getElementById("toSituation_up6").value,
				    			document.getElementById("toSituation_down6").value,
				    			document.getElementById("toSituation_wdb6").value,
				    			document.getElementById("toSituation_sur6").value,
				    			document.getElementById("toSituation_gw6").value,
				    			document.getElementById("toSituation_sup6").value);
				        arr[6]=new Array(
									document.getElementById("toSituation_country7w").value,
									document.getElementById("toSituation_up7").value,
				    			document.getElementById("toSituation_down7").value,
				    			document.getElementById("toSituation_wdb7").value,
				    			document.getElementById("toSituation_sur7").value,
				    			document.getElementById("toSituation_gw7").value,
				    			document.getElementById("toSituation_sup7").value);
				        arr[7]=new Array(
									document.getElementById("toSituation_country8w").value,
									document.getElementById("toSituation_up8").value,
				    			document.getElementById("toSituation_down8").value,
				    			document.getElementById("toSituation_wdb8").value,
				    			document.getElementById("toSituation_sur8").value,
				    			document.getElementById("toSituation_gw8").value,
				    			document.getElementById("toSituation_sup8").value);
				        arr[8]=new Array(
									document.getElementById("toSituation_country9w").value,
									document.getElementById("toSituation_up9").value,
				    			document.getElementById("toSituation_down9").value,
				    			document.getElementById("toSituation_wdb9").value,
				    			document.getElementById("toSituation_sur9").value,
				    			document.getElementById("toSituation_gw9").value,
				    			document.getElementById("toSituation_sup9").value);
				        arr[9]=new Array(
									document.getElementById("toSituation_country10w").value,
									document.getElementById("toSituation_up10").value,
				    			document.getElementById("toSituation_down10").value,
				    			document.getElementById("toSituation_wdb10").value,
				    			document.getElementById("toSituation_sur10").value,
				    			document.getElementById("toSituation_gw10").value,
				    			document.getElementById("toSituation_sup10").value);
				        arr[10]=new Array(
									document.getElementById("toSituation_country11w").value,
									document.getElementById("toSituation_up11").value,
				    			document.getElementById("toSituation_down11").value,
				    			document.getElementById("toSituation_wdb11").value,
				    			document.getElementById("toSituation_sur11").value,
				    			document.getElementById("toSituation_gw11").value,
				    			document.getElementById("toSituation_sup11").value);
				        arr[11]=new Array(
									document.getElementById("toSituation_country12w").value,
									document.getElementById("toSituation_up12").value,
				    			document.getElementById("toSituation_down12").value,
				    			document.getElementById("toSituation_wdb12").value,
				    			document.getElementById("toSituation_sur12").value,
				    			document.getElementById("toSituation_gw12").value,
				    			document.getElementById("toSituation_sup12").value);
				        arr[12]=new Array(
									document.getElementById("toSituation_country13w").value,
									document.getElementById("toSituation_up13").value,
				    			document.getElementById("toSituation_down13").value,
				    			document.getElementById("toSituation_wdb13").value,
				    			document.getElementById("toSituation_sur13").value,
				    			document.getElementById("toSituation_gw13").value,
				    			document.getElementById("toSituation_sup13").value);
				        arr[13]=new Array(
									document.getElementById("toSituation_country14w").value,
									document.getElementById("toSituation_up14").value,
				    			document.getElementById("toSituation_down14").value,
				    			document.getElementById("toSituation_wdb14").value,
				    			document.getElementById("toSituation_sur14").value,
				    			document.getElementById("toSituation_gw14").value,
				    			document.getElementById("toSituation_sup14").value);

						for(var i=0;i<arr.length;i++){
							$.post(
									"saveWaterPara.do",
									{
										<#--  "projectId" :   -->
										"countyId" : arr[i][0],
										"Upstreamwater":arr[i][1],
										"FlowDown":arr[i][2],
										"Waterdistribution":arr[i][3],
										"SurSup":arr[i][4],
										"GWSup":arr[i][5],
										"SupWater":arr[i][6]
									}, function(data) {
										//alert(data.content);
								})
							}
					})
		</script>
		<!-- 
		<script src="static/js/jquery-2.2.3.min.js"></script>
		<script src="static/js/layer/layer.js"></script>
		<script src="static/js/echarts-all.js"></script>
		 -->

		<script>
			//步骤条宽度设置
			/*function StepsWidth(){
				var width=($(".admin-steps").width()-350)/2+"px";
				$(".admin-steps-item-tail").width(width);
			}
			StepsWidth();
			$(window).on("resize",function(){
				StepsWidth()
			});
			*/
			//选项卡
			$("#toSituation .admin-tab .admin-tab-item").eq(0).show().siblings().hide();//显示第一个，隐藏其他的
			$("#toSituation .admin-tab .admin-tab-top li").on("click", function() {//选项卡切换
				var i = $(this).index();
				$(this).addClass("admin-this").siblings().removeClass("admin-this");
				$("#toSituation .admin-tab .admin-tab-cont .admin-tab-item").eq(i).show().siblings().hide();
			});
			
			
			$("#toSituation span").on("click",function(){
				$("#toSituation input").trigger("change");
			});
			
			//点击选项卡头部加载数据
			$("#toSituation #stuation-1").on("click",function(){
				//气候情景：温度变化图
				showFigure_1();
 				//气候情景：降水变化图
				showFigure_2();
			});
			$("#toSituation #stuation-2").on("click",function(){
				//土地利用情景中的耕地面积变化图表
				land_show_1();
 				//土地利用情景中的不同土地类型面积变化
				land_show_2();
			})
			$("#toSituation #stuation-3").on("click",function(){
				quchang_show_1();
			})
			$("#toSituation #stuation-4").on("click",function(){
				//水资源管理情景中的用水量变化
				showArea_usingng_water()
			})
			//土地利用情景中的耕地面积变化图表
			function land_show_1() {
					$.get('getTblLandUseSceByfldCountyCode.do',
							{fldCountyCode:$("#selectCounty_land").val()},
									function(data){
							var xdata=[], fldFarmArea=[];
							for(var i=0; i<data.length; i++)
							{
									xdata[i]=data[i].fldDate;
									fldFarmArea[i]=data[i].fldFarmArea;
									
							}
							if (data.length>=1){
							var titletext=data[0].fldDate+'~'+data[data.length-1].fldDate+' '+$("#selectCounty_land").find("option:selected").text()+'${landchange}';
							}
					var Chart = echarts.init(document.getElementById('land_show_1'));
					var option = {
									title: {
											text: titletext,
											x: 'center',
											y: 'top',
											textStyle: {
													fontSize: 14,
													fontWeight: 'bold',
													color: '#333' // 主标题文字颜色
											},
									},
							tooltip : {
									trigger : 'axis'
							},
							legend : {
									data : [ '${landarea}' ],
									x: 'center',
									padding: [25,5,5,5]
							},
							grid : {
									left : '5%',
									right : '1%',
									containLabel : true
							},
							toolbox : {
									show:true,
									feature : {
											saveAsImage : {show:true,}
									}
							},
							xAxis : {
									type : 'category',
									boundaryGap : false,
									name : '${year}',
									data : xdata
							},
							yAxis : {
									type : 'value',
									name : '${mu}',
							},
							series : [ {
									name : '${landarea}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldFarmArea
							}]
					};
					Chart.setOption(option);
					})
			}
			//土地类型中不同土地类型面积变化
			function land_show_2() {
					$.get('getTblLandUseSceByfldCountyCode.do',
									{fldCountyCode : $("#selectCounty_land").val()},
									function(data){
											var xdata=[], fldWetlandArea=[], fldForestArea=[], fldGrassArea=[], fldHuYangArea=[], fldWaterArea=[];
											for(var i=0; i<data.length; i++)
											{
													xdata[i]=data[i].fldDate;
													fldWetlandArea[i]=data[i].fldWetlandArea;
													fldForestArea[i]=data[i].fldForestArea;
													fldGrassArea[i]=data[i].fldGrassArea;
													fldHuYangArea[i]=data[i].fldHuYangArea;
													fldWaterArea[i]=data[i].fldWaterArea;
											}
											if (data.length>=1){
											var titletext=data[0].fldDate+'~'+data[data.length-1].fldDate+' '+$("#selectCounty_land").find("option:selected").text()+'${areachange}';
											}
					var Chart = echarts.init(document.getElementById('land_show_2'));
					var option = {
									title: {
											text: titletext,
											x: 'center',
											y: 'top',
											textStyle: {
													fontSize: 14,
													fontWeight: 'bold',
													color: '#333' // 主标题文字颜色
											},
									},
							tooltip : {
									trigger : 'axis'
							},
							legend : {
									data : [ '${Wetland}', '${Forest}','${Grass}','${Populus}','${Waterarea}' ],
									x: 'center',
									padding: [25,5,5,5]
							},
							grid : {
									left : '5%',
									right : '1%',
									containLabel : true
							},
							toolbox : {
									show:true,
									feature : {
											saveAsImage : {show:true}
									}
							},
							xAxis : {
									type : 'category',
									boundaryGap : false,
									name : '${year}',
									data : xdata
							},
							yAxis : {
									type : 'value',
									name : '${mu}',
							},
							series : [  {
									name : '${Wetland}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldWetlandArea
							}, {
									name : '${Forest}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldForestArea
							}, {
									name : '${Grass}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldGrassArea
							}, {
									name : '${Populus}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldHuYangArea
							}, {
									name : '${Waterarea}',
									type : 'line',
									itemStyle : {  
											normal : {  
													lineStyle:{  
															width:4
													}  
											}  
									},   
									data : fldWaterArea
							} ]
					};
					Chart.setOption(option);
					})
			}
		</script>
	</body>
</html>