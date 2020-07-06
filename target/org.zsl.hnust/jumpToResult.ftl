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
		<!--<script type="text/javascript" src="easyUI/js/jquery.min.js"></script>-->
        <!--<script type="text/javascript" src="easyUI/js/jquery.easyui.min.js"></script>-->
		<style type="text/css">
		
		.admin-input{
			width: 80px;
			
		}
		.admin-table-wrap td{
			text-align: right;
		}
		</style>
	</head>
	<body class="childrenBody" onload="queryAvailable();">
		<#--<div class="admin-page-title admin-page-title-steps">-->
			<#--<div class="fl">-->
				<#--<i class="icon iconfont icon-left">&#xe600;</i>${system}-->
			<#--</div>-->
			<#--<!--步骤条&ndash;&gt;-->
			<#--<div class="admin-steps-wrap fr">-->
				<#--<div class="admin-steps">-->
					<#--<div class="admin-steps-item admin-steps-item-finish">-->
						<#--<a  href="goal.do" target="adminFrameName">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>1</span>-->
								<#--<em>${goal}</em>-->
							<#--</div>-->
							<#--<div class="admin-steps-item-tail"></div>-->
						<#--</a>-->
					<#--</div>-->
					<#--<div class="admin-steps-item admin-steps-item-finish">-->
						<#--<a href="toStuation.do" target="adminFrameName">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>2</span>-->
								<#--<em>${scene}</em>-->
							<#--</div>-->
							<#--<div class="admin-steps-item-tail"></div>-->
						<#--</a>-->
					<#--</div>-->
					<#--<div class="admin-steps-item admin-steps-item-process">-->
						<#--<a href="jumpToResult.do">-->
							<#--<div class="admin-steps-item-cont">-->
								<#--<span>3</span>-->
								<#--<em>${scene1}</em>-->
							<#--</div>-->
						<#--</a>-->
					<#--</div>-->
				<#--</div>-->
			<#--</div>-->
		<#--</div>-->
		<div id="jumpToResult">
			<!--选项卡-->
			<div class="admin-tab">
				<ul class="admin-tab-top">
					<li class="admin-this">${abstract}</li>
					<li>${scene1}</li>
					<li>${monidata}</li>
					<li>${pinggu}</li>
				</ul>
				<div class="admin-tab-cont">
					<div class="admin-tab-item active" style="width: 100%;margin: 0 auto;padding: 10px 10px 0 20px;">
						<div class="admin-tab-title">${juece}</div>
						<div class="admin-proj-infor">
							<span>${yanjiu}<em>${heihe}</em></span>
							<span>项目名称:<em>${system}</em></span>
						</div>
						<div class="admin-abstract">
							<div class="admin-table-wrap">
								<table class="admin-table admin-result-table">
									<thead>
										<tr>
											<th rowspan="2"><p align="left">${county}</p></th>
											<th colspan="2"><p>${climate}</p></th>
											<th colspan="4"><p>${land}</p></th>
											<th colspan="5"><p>${soc}</p></th>
											<th colspan="5"><p>${water}</p></th>
										</tr>
										<tr>
											<th rowspan="2"><p align="left">${rain}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${temp}(℃／${toalyear}${nian})</p></th>
											<!-- <th colspan="4"><p>${gengdi}(%／${toalyear})</p></th> -->
											<!-- <th colspan="6">${jiegou}(%)</th> -->
											<th rowspan="2"><p align="left">${geng}</p></th>
											<th rowspan="2"><p align="left">${lin}</p></th>
											<th rowspan="2"><p align="left">${cao}</p></th>
											<th rowspan="2"><p align="left">${shui}</p></th>
											<th rowspan="2"><p align="left">${popo}</p></th>
											<th rowspan="2"><p align="left">${aptr}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${itpr}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${sitpr}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${urpar}</p></th>
											<!-- <th rowspan="2"><p align="left">${shang}(${e}／${toalyear})</p></th> -->
											<th rowspan="2"><p align="left">${xia}(${e})</p></th>
											<th rowspan="2"><p align="left">${drink}(%)</p></th>
											<th rowspan="2"><p align="left">${dbw}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${dxw}(%／${toalyear}${nian})</p></th>
											<th rowspan="2"><p align="left">${fn}(${e})</p></th>
										</tr>
										<!-- <tr>
											<th><p align="left">${geng}</p></th>
											<th><p align="left">${lin}</p></th>
											<th><p align="left">${cao}</p></th>
											<th><p align="left">${shui}</p></th>
											<th>${luo}</th>
											<th>${cheng}</th>
											<th>${mai}</th>
											<th>${yu}</th>
											<th>${you}</th>
											<th>${shu}</th>
											<th>${guo}</th>
											<th>${mian}</th>
										</tr> -->
									</thead>
									<tbody>
										<tr>
											<td><input id="jumpToResult_country1" value="0" style="display: none;"/><p align="left">${quanliuyu}</p></td>
											<td id="jumpToResult_rain_inc_1"></td>
											<td id="jumpToResult_temp_inc_1"></td>
											<td id="jumpToResult_form1"></td>
											<td id="jumpToResult_forest1"></td>
											<td id="jumpToResult_grass1"></td>
											<td id="jumpToResult_water1"></td>
											<!-- <td id="jumpToResult_bare1"></td>
											<td id="jumpToResult_city1"/></td>
											<td id="jumpToResult_wh1"></td>
											<td id="jumpToResult_corn1"></td>
											<td id="jumpToResult_oil1"></td>
											<td id="jumpToResult_veg1"></td>
											<td id="jumpToResult_ft1"></td>
											<td id="jumpToResult_cot1"></td> -->
											<td id="jumpToResult_licy1"></td>
											<td id="jumpToResult_arg1"></td>
											<td id="jumpToResult_ind1"></td>
											<td id="jumpToResult_ser1"></td>
											<td id="jumpToResult_urpar1"></td>
											<!-- <td id="jumpToResult_up1"></td> -->
											<td id="jumpToResult_down1"></td>
											<td id="jumpToResult_wdb1"></td>
											<td id="jumpToResult_sur1"></td>
											<td id="jumpToResult_gw1"></td>
											<td id="jumpToResult_sup1"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country2" value="1" style="display: none;"/><p align="left">${upstream}</p></td>
											<td id="jumpToResult_rain_inc_2"></td>
											<td id="jumpToResult_temp_inc_2"></td>
											<td id="jumpToResult_form2"></td>
											<td id="jumpToResult_forest2"></td>
											<td id="jumpToResult_grass2"></td>
											<td id="jumpToResult_water2"></td>
											<!-- <td id="jumpToResult_bare2"></td>
											<td id="jumpToResult_city2"></td>
											<td id="jumpToResult_wh2"></td>
											<td id="jumpToResult_corn2"></td>
											<td id="jumpToResult_oil2"></td>
											<td id="jumpToResult_veg2"></td>
											<td id="jumpToResult_ft2"></td>
											<td id="jumpToResult_cot2"></td> -->
											<td id="jumpToResult_licy2"></td>
											<td id="jumpToResult_arg2"></td>
											<td id="jumpToResult_ind2"></td>
											<td id="jumpToResult_ser2"></td>
											<td id="jumpToResult_urpar2"></td>
											<!-- <td id="jumpToResult_up2"></td> -->
											<td id="jumpToResult_down2"></td>
											<td id="jumpToResult_wdb2"></td>
											<td id="jumpToResult_sur2"></td>
											<td id="jumpToResult_gw2"></td>
											<td id="jumpToResult_sup2"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country3" value="2" style="display: none;"/><p align="left">${mal}</p></td>
											<td id="jumpToResult_rain_inc_3"></td>
											<td id="jumpToResult_temp_inc_3"></td>
											<td id="jumpToResult_form3"></td>
											<td id="jumpToResult_forest3"></td>
											<td id="jumpToResult_grass3"></td>
											<td id="jumpToResult_water3"></td>
											<!-- <td id="jumpToResult_bare3"></td>
											<td id="jumpToResult_city3"></td>
											<td id="jumpToResult_wh3"></td>
											<td id="jumpToResult_corn3"></td>
											<td id="jumpToResult_oil3"></td>
											<td id="jumpToResult_veg3"></td>
											<td id="jumpToResult_ft3"></td>
											<td id="jumpToResult_cot3"></td> -->
											<td id="jumpToResult_licy3"></td>
											<td id="jumpToResult_arg3"></td>
											<td id="jumpToResult_ind3"></td>
											<td id="jumpToResult_ser3"></td>
											<td id="jumpToResult_urpar3"></td>
											<!-- <td id="jumpToResult_up3"></td> -->
											<td id="jumpToResult_down3"></td>
											<td id="jumpToResult_wdb3"></td>
											<td id="jumpToResult_sur3"></td>
											<td id="jumpToResult_gw3"></td>
											<td id="jumpToResult_sup3"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country4" value="620702" style="display: none;"/><p align="left">${ganzhou}</p></td>
											<td id="jumpToResult_rain_inc_4"></td>
											<td id="jumpToResult_temp_inc_4"></td>
											<td id="jumpToResult_form4"></td>
											<td id="jumpToResult_forest4"></td>
											<td id="jumpToResult_grass4"></td>
											<td id="jumpToResult_water4"></td>
											<!-- <td id="jumpToResult_bare4"></td>
											<td id="jumpToResult_city4"></td>
											<td id="jumpToResult_wh4"></td>
											<td id="jumpToResult_corn4"></td>
											<td id="jumpToResult_oil4"></td>
											<td id="jumpToResult_veg4"></td>
											<td id="jumpToResult_ft4"></td>
											<td id="jumpToResult_cot4"></td> -->
											<td id="jumpToResult_licy4"></td>
											<td id="jumpToResult_arg4"></td>
											<td id="jumpToResult_ind4"></td>
											<td id="jumpToResult_ser4"></td>
											<td id="jumpToResult_urpar4"></td>
											<!-- <td id="jumpToResult_up4"></td> -->
											<td id="jumpToResult_down4"></td>
											<td id="jumpToResult_wdb4"></td>
											<td id="jumpToResult_sur4"></td>
											<td id="jumpToResult_gw4"></td>
											<td id="jumpToResult_sup4"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country5" value="620723" style="display: none;"/><p align="left">${linze}</p></td>
											<td id="jumpToResult_rain_inc_5"></td>
											<td id="jumpToResult_temp_inc_5"></td>
											<td id="jumpToResult_form5"></td>
											<td id="jumpToResult_forest5"></td>
											<td id="jumpToResult_grass5"></td>
											<td id="jumpToResult_water5"></td>
											<!-- <td id="jumpToResult_bare5"></td>
											<td id="jumpToResult_city5"></td>
											<td id="jumpToResult_wh5"></td>
											<td id="jumpToResult_corn5"></td>
											<td id="jumpToResult_oil5"></td>
											<td id="jumpToResult_veg5"></td>
											<td id="jumpToResult_ft5"></td>
											<td id="jumpToResult_cot5"></td> -->
											<td id="jumpToResult_licy5"></td>
											<td id="jumpToResult_arg5"></td>
											<td id="jumpToResult_ind5"></td>
											<td id="jumpToResult_ser5"></td>
											<td id="jumpToResult_urpar5"></td>
											<!-- <td id="jumpToResult_up5"></td> -->
											<td id="jumpToResult_down5"></td>
											<td id="jumpToResult_wdb5"></td>
											<td id="jumpToResult_sur5"></td>
											<td id="jumpToResult_gw5"></td>
											<td id="jumpToResult_sup5"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country6" value="620724" style="display: none;"/><p align="left">${gaotai}</p></td>
											<td id="jumpToResult_rain_inc_6"></td>
											<td id="jumpToResult_temp_inc_6"></td>
											<td id="jumpToResult_form6"></td>
											<td id="jumpToResult_forest6"></td>
											<td id="jumpToResult_grass6"></td>
											<td id="jumpToResult_water6"></td>
											<!-- <td id="jumpToResult_bare6"></td>
											<td id="jumpToResult_city6"></td>
											<td id="jumpToResult_wh6"></td>
											<td id="jumpToResult_corn6"></td>
											<td id="jumpToResult_oil6"></td>
											<td id="jumpToResult_veg6"></td>
											<td id="jumpToResult_ft6"></td>
											<td id="jumpToResult_cot6"></td> -->
											<td id="jumpToResult_licy6"></td>
											<td id="jumpToResult_arg6"></td>
											<td id="jumpToResult_ind6"></td>
											<td id="jumpToResult_ser6"></td>
											<td id="jumpToResult_urpar6"></td>
											<!-- <td id="jumpToResult_up6"></td> -->
											<td id="jumpToResult_down6"></td>
											<td id="jumpToResult_wdb6"></td>
											<td id="jumpToResult_sur6"></td>
											<td id="jumpToResult_gw6"></td>
											<td id="jumpToResult_sup6"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country7" value="152923" style="display: none;"/><p align="left">${ejinaqi}</p></td>
											<td id="jumpToResult_rain_inc_7"></td>
											<td id="jumpToResult_temp_inc_7"></td>
											<td id="jumpToResult_form7"></td>
											<td id="jumpToResult_forest7"></td>
											<td id="jumpToResult_grass7"></td>
											<td id="jumpToResult_water7"></td>
											<!-- <td id="jumpToResult_bare7"></td>
											<td id="jumpToResult_city7"></td>
											<td id="jumpToResult_wh7"></td>
											<td id="jumpToResult_corn7"></td>
											<td id="jumpToResult_oil7"></td>
											<td id="jumpToResult_veg7"></td>
											<td id="jumpToResult_ft7"></td>
											<td id="jumpToResult_cot7"></td> -->
											<td id="jumpToResult_licy7"></td>
											<td id="jumpToResult_arg7"></td>
											<td id="jumpToResult_ind7"></td>
											<td id="jumpToResult_ser7"></td>
											<td id="jumpToResult_urpar7"></td>
											<!--  <td id="jumpToResult_up7"></td>-->
											<td id="jumpToResult_down7"></td>
											<td id="jumpToResult_wdb7"></td>
											<td id="jumpToResult_sur7"></td>
											<td id="jumpToResult_gw7"></td>
											<td id="jumpToResult_sup7"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country8" value="620921" style="display: none;"/><p align="left">${jinta}</p></td>
											<td id="jumpToResult_rain_inc_8"></td>
											<td id="jumpToResult_temp_inc_8"></td>
											<td id="jumpToResult_form8"></td>
											<td id="jumpToResult_forest8"></td>
											<td id="jumpToResult_grass8"></td>
											<td id="jumpToResult_water8"></td>
											<!-- <td id="jumpToResult_bare8"></td>
											<td id="jumpToResult_city8"></td>
											<td id="jumpToResult_wh8"></td>
											<td id="jumpToResult_corn8"></td>
											<td id="jumpToResult_oil8"></td>
											<td id="jumpToResult_veg8"></td>
											<td id="jumpToResult_ft8"></td>
											<td id="jumpToResult_cot8"></td> -->
											<td id="jumpToResult_licy8"></td>
											<td id="jumpToResult_arg8"></td>
											<td id="jumpToResult_ind8"></td>
											<td id="jumpToResult_ser8"></td>
											<td id="jumpToResult_urpar8"></td>
											<!-- <td id="jumpToResult_up8"></td> -->
											<td id="jumpToResult_down8"></td>
											<td id="jumpToResult_wdb8"></td>
											<td id="jumpToResult_sur8"></td>
											<td id="jumpToResult_gw8"></td>
											<td id="jumpToResult_sup8"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country9" value="620722" style="display: none;"/><p align="left">${minle}</p></td>
											<td id="jumpToResult_rain_inc_9"></td>
											<td id="jumpToResult_temp_inc_9"></td>
											<td id="jumpToResult_form9"></td>
											<td id="jumpToResult_forest9"></td>
											<td id="jumpToResult_grass9"></td>
											<td id="jumpToResult_water9"></td>
											<!-- <td id="jumpToResult_bare9"></td>
											<td id="jumpToResult_city9"></td>
											<td id="jumpToResult_wh9"></td>
											<td id="jumpToResult_corn9"></td>
											<td id="jumpToResult_oil9"></td>
											<td id="jumpToResult_veg9"></td>
											<td id="jumpToResult_ft9"></td>
											<td id="jumpToResult_cot9"></td> -->
											<td id="jumpToResult_licy9"></td>
											<td id="jumpToResult_arg9"></td>
											<td id="jumpToResult_ind9"></td>
											<td id="jumpToResult_ser9"></td>
											<td id="jumpToResult_urpar9"></td>
											<!-- <td id="jumpToResult_up9"></td> -->
											<td id="jumpToResult_down9"></td>
											<td id="jumpToResult_wdb9"></td>
											<td id="jumpToResult_sur9"></td>
											<td id="jumpToResult_gw9"></td>
											<td id="jumpToResult_sup9"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country10" value="620721" style="display: none;"/><p align="left">${sunan}</p></td>
											<td id="jumpToResult_rain_inc_10"></td>
											<td id="jumpToResult_temp_inc_10"></td>
											<td id="jumpToResult_form10"></td>
											<td id="jumpToResult_forest10"></td>
											<td id="jumpToResult_grass10"></td>
											<td id="jumpToResult_water10"></td>
											<!-- <td id="jumpToResult_bare10"></td>
											<td id="jumpToResult_city10"></td>
											<td id="jumpToResult_wh10"></td>
											<td id="jumpToResult_corn10"></td>
											<td id="jumpToResult_oil10"></td>
											<td id="jumpToResult_veg10"></td>
											<td id="jumpToResult_ft10"></td>
											<td id="jumpToResult_cot10"></td> -->
											<td id="jumpToResult_licy10"></td>
											<td id="jumpToResult_arg10"></td>
											<td id="jumpToResult_ind10"></td>
											<td id="jumpToResult_ser10"></td>
											<td id="jumpToResult_urpar10"></td>
											<!-- <td id="jumpToResult_up10"></td> -->
											<td id="jumpToResult_down10"></td>
											<td id="jumpToResult_wdb10"></td>
											<td id="jumpToResult_sur10"></td>
											<td id="jumpToResult_gw10"></td>
											<td id="jumpToResult_sup10"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country11" value="620902" style="display: none;"/><p align="left">${suzhou}</p></td>
											<td id="jumpToResult_rain_inc_11"></td>
											<td id="jumpToResult_temp_inc_11"></td>
											<td id="jumpToResult_form11"></td>
											<td id="jumpToResult_forest11"></td>
											<td id="jumpToResult_grass11"></td>
											<td id="jumpToResult_water11"></td>
											<!-- <td id="jumpToResult_bare11"></td>
											<td id="jumpToResult_city11"></td>
											<td id="jumpToResult_wh11"></td>
											<td id="jumpToResult_corn11"></td>
											<td id="jumpToResult_oil11"></td>
											<td id="jumpToResult_veg11"></td>
											<td id="jumpToResult_ft11"></td>
											<td id="jumpToResult_cot11"></td> -->
											<td id="jumpToResult_licy11"></td>
											<td id="jumpToResult_arg11"></td>
											<td id="jumpToResult_ind11"></td>
											<td id="jumpToResult_ser11"></td>
											<td id="jumpToResult_urpar11"></td>
											<!-- <td id="jumpToResult_up11"></td> -->
											<td id="jumpToResult_down11"></td>
											<td id="jumpToResult_wdb11"></td>
											<td id="jumpToResult_sur11"></td>
											<td id="jumpToResult_gw11"></td>
											<td id="jumpToResult_sup11"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country12" value="620200" style="display: none;"/><p align="left">${jiayuguan}</p></td>
											<td id="jumpToResult_rain_inc_12"></td>
											<td id="jumpToResult_temp_inc_12"></td>
											<td id="jumpToResult_form12"></td>
											<td id="jumpToResult_forest12"></td>
											<td id="jumpToResult_grass12"></td>
											<td id="jumpToResult_water12"></td>
											<!-- <td id="jumpToResult_bare12"></td>
											<td id="jumpToResult_city12"></td>
											<td id="jumpToResult_wh12"></td>
											<td id="jumpToResult_corn12"></td>
											<td id="jumpToResult_oil12"></td>
											<td id="jumpToResult_veg12"></td>
											<td id="jumpToResult_ft12"></td>
											<td id="jumpToResult_cot12"></td> -->
											<td id="jumpToResult_licy12"></td>
											<td id="jumpToResult_arg12"></td>
											<td id="jumpToResult_ind12"></td>
											<td id="jumpToResult_ser12"></td>
											<td id="jumpToResult_urpar12"></td>
											<!-- <td id="jumpToResult_up12"></td> -->
											<td id="jumpToResult_down12"></td>
											<td id="jumpToResult_wdb12"></td>
											<td id="jumpToResult_sur12"></td>
											<td id="jumpToResult_gw12"></td>
											<td id="jumpToResult_sup12"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country13" value="632222" style="display: none;"/><p align="left">${qilian}</p></td>
											<td id="jumpToResult_rain_inc_13"></td>
											<td id="jumpToResult_temp_inc_13"></td>
											<td id="jumpToResult_form13"></td>
											<td id="jumpToResult_forest13"></td>
											<td id="jumpToResult_grass13"></td>
											<td id="jumpToResult_water13"></td>
											<!-- <td id="jumpToResult_bare13"></td>
											<td id="jumpToResult_city13"/></td>
											<td id="jumpToResult_wh13"></td>
											<td id="jumpToResult_corn13"></td>
											<td id="jumpToResult_oil13"></td>
											<td id="jumpToResult_veg13"></td>
											<td id="jumpToResult_ft13"></td>
											<td id="jumpToResult_cot13"></td> -->
											<td id="jumpToResult_licy13"></td>
											<td id="jumpToResult_arg13"></td>
											<td id="jumpToResult_ind13"></td>
											<td id="jumpToResult_ser13"></td>
											<td id="jumpToResult_urpar13"></td>
											<!-- <td id="jumpToResult_up13"></td> -->
											<td id="jumpToResult_down13"></td>
											<td id="jumpToResult_wdb13"></td>
											<td id="jumpToResult_sur13"></td>
											<td id="jumpToResult_gw13"></td>
											<td id="jumpToResult_sup13"></td>
										</tr>
										<tr>
											<td><input id="jumpToResult_country14" value="620725" style="display: none;"/><p align="left">${shandan}</p></td>
											<td id="jumpToResult_rain_inc_14"></td>
											<td id="jumpToResult_temp_inc_14"></td>
											<td id="jumpToResult_form14"></td>
											<td id="jumpToResult_forest14"></td>
											<td id="jumpToResult_grass14"></td>
											<td id="jumpToResult_water14"></td>
											<!-- <td id="jumpToResult_bare14"></td>
											<td id="jumpToResult_city14"/></td>
											<td id="jumpToResult_wh14"></td>
											<td id="jumpToResult_corn14"></td>
											<td id="jumpToResult_oil14"></td>
											<td id="jumpToResult_veg14"></td>
											<td id="jumpToResult_ft14"></td>
											<td id="jumpToResult_cot14"></td> -->
											<td id="jumpToResult_licy14"></td>
											<td id="jumpToResult_arg14"></td>
											<td id="jumpToResult_ind14"></td>
											<td id="jumpToResult_ser14"></td>
											<td id="jumpToResult_urpar14"></td>
											<!-- <td id="jumpToResult_up14"></td> -->
											<td id="jumpToResult_down14"></td>
											<td id="jumpToResult_wdb14"></td>
											<td id="jumpToResult_sur14"></td>
											<td id="jumpToResult_gw14"></td>
											<td id="jumpToResult_sup14"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<#--<script type="text/javascript">-->
					<#--//获取气候情景参数-->
					<#--$.get("getClimateScePara.do", -->
						<#--{-->
						<#--"id" : "${projectId}"-->
						<#--}, function(data) {-->
						<#--console.log(data);-->
						<#--var i=0;-->
						 <#--if(data != null){-->
						    	<#--for(i;i<=data.length;i++){-->
						    		<#--if(data[i].countyId=="0"){-->
						    			<#--document.getElementById("rain_inc_1").innerHTML=data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_1").innerHTML=data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="1"){-->
						    			<#--document.getElementById("rain_inc_2").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_2").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="2"){-->
						    			<#--document.getElementById("rain_inc_3").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_3").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620702"){-->
						    			<#--document.getElementById("rain_inc_4").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_4").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620723"){-->
						    			<#--document.getElementById("rain_inc_5").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_5").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620724"){-->
						    			<#--document.getElementById("rain_inc_6").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_6").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="152923"){-->
						    			<#--document.getElementById("rain_inc_7").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_7").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620921"){-->
						    			<#--document.getElementById("rain_inc_8").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_8").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620722"){-->
						    			<#--document.getElementById("rain_inc_9").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_9").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620721"){-->
						    			<#--document.getElementById("rain_inc_10").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_10").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620902"){-->
						    			<#--document.getElementById("rain_inc_11").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_11").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="620200"){-->
						    			<#--document.getElementById("rain_inc_12").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_12").innerHTML = data[i].tempChange;-->
						    		<#--}else if(data[i].countyId=="632222"){-->
						    			<#--document.getElementById("rain_inc_13").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_13").innerHTML = data[i].tempChange;-->
						    		<#--}else{-->
						    			<#--document.getElementById("rain_inc_14").innerHTML = data[i].preChangeR;-->
						    			<#--document.getElementById("temp_inc_14").innerHTML = data[i].tempChange;-->
						    		<#--}-->
						    	<#---->
						    	<#--}-->
						 <#--}-->
						<#---->
					<#--})-->
					<#--//获取土地利用参数-->
					<#--$.get("getLandUseScePara.do", -->
						<#--{-->
						<#--"id" : "${projectId}"-->
						<#--}, function(data) {-->
						<#--console.log(data);-->
						<#---->
						<#--var i=0;-->
						 <#--if(data != null){-->
						    	<#--for(i;i<=data.length;i++){-->
						    		<#--if(data[i].countyId=="0"){-->
						    			<#--document.getElementById("form1").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest1").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass1").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water1").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare1").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city1").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh1").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn1").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil1").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg1").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft1").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot1").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="1"){-->
						    			<#--document.getElementById("form2").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest2").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass2").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water2").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare2").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city2").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh2").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn2").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil2").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg2").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft2").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot2").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="2"){-->
						    			<#--document.getElementById("form3").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest3").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass3").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water3").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare3").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city3").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh3").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn3").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil3").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg3").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft3").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot3").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620702"){-->
						    			<#--document.getElementById("form4").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest4").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass4").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water4").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare4").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city4").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh4").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn4").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil4").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg4").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft4").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot4").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620723"){-->
						    			<#--document.getElementById("form5").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest5").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass5").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water5").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare5").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city5").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh5").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn5").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil5").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg5").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft5").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot5").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620724"){-->
						    			<#--document.getElementById("form6").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest6").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass6").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water6").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare6").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city6").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh6").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn6").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil6").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg6").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft6").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot6").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="152923"){-->
						    			<#--document.getElementById("form7").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest7").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass7").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water7").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare7").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city7").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh7").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn7").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil7").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg7").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft7").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot7").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620921"){-->
						    			<#--document.getElementById("form8").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest8").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass8").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water8").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare8").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city8").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh8").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn8").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil8").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg8").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft8").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot8").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620722"){-->
						    			<#--document.getElementById("form9").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest9").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass9").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water9").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare9").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city9").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh9").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn9").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil9").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg9").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft9").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot9").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620721"){-->
						    			<#--document.getElementById("form10").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest10").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass10").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water10").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare10").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city10").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh10").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn10").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil10").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg10").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft10").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot10").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620902"){-->
						    			<#--document.getElementById("form11").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest11").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass11").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water11").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare11").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city11").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh11").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn11").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil11").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg11").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft11").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot11").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="620200"){-->
						    			<#--document.getElementById("form12").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest12").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass12").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water12").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare12").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city12").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh12").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn12").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil12").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg12").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft12").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot12").innerHTML = data[i].cpcotR;-->
						    		<#--}else if(data[i].countyId=="632222"){-->
						    			<#--document.getElementById("form13").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest13").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass13").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water13").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare13").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city13").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh13").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn13").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil13").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg13").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft13").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot13").innerHTML = data[i].cpcotR;-->
						    		<#--}else{-->
						    			<#--document.getElementById("form14").innerHTML = data[i].landFarmR;-->
						    			<#--document.getElementById("forest14").innerHTML = data[i].landForestR;-->
						    			<#--document.getElementById("grass14").innerHTML = data[i].landGrassR;-->
						    			<#--document.getElementById("water14").innerHTML = data[i].waterArea;-->
						    			<#--//document.getElementById("bare14").innerHTML = data[i].landBareR;-->
						    			<#--//document.getElementById("city14").innerHTML = data[i].landCityR;-->
						    			<#--//document.getElementById("wh14").innerHTML = data[i].cpwhR;-->
						    			<#--//document.getElementById("corn14").innerHTML = data[i].cpcornR;-->
						    			<#--//document.getElementById("oil14").innerHTML = data[i].cpoilR;-->
						    			<#--//document.getElementById("veg14").innerHTML = data[i].cpvegR;-->
						    			<#--//document.getElementById("ft14").innerHTML = data[i].cpftr;-->
						    			<#--//document.getElementById("cot14").innerHTML = data[i].cpcotR;-->
						    		<#--}-->
						    	<#---->
						    	<#--}-->
						 <#--}-->
						<#---->
					<#--})-->
					<#--//获取社会经济情景参数-->
					<#--$.get("getSocEcoPara.do", -->
						<#--{-->
						<#--"id" : "${projectId}"-->
						<#--}, function(data) {-->
						<#--console.log(data);-->
						<#--var i=0;-->
						 <#--if(data != null){-->
						    	<#--for(i;i<=data.length;i++){-->
						    		<#--if(data[i].countyId=="0"){-->
						    			<#--document.getElementById("licy1").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg1").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind1").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser1").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar1").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="1"){-->
						    			<#--document.getElementById("licy2").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg2").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind2").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser2").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar2").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="2"){-->
						    			<#--document.getElementById("licy3").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg3").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind3").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser3").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar3").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620702"){-->
						    			<#--document.getElementById("licy4").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg4").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind4").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser4").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar4").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620723"){-->
						    			<#--document.getElementById("licy5").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg5").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind5").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser5").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar5").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620724"){-->
						    			<#--document.getElementById("licy6").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg6").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind6").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser6").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar6").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="152923"){-->
						    			<#--document.getElementById("licy7").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg7").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind7").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser7").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar7").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620921"){-->
						    			<#--document.getElementById("licy8").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg8").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind8").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser8").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar8").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620722"){-->
						    			<#--document.getElementById("licy9").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg9").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind9").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser9").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar9").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620721"){-->
						    			<#--document.getElementById("licy10").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg10").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind10").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser10").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar10").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620902"){-->
						    			<#--document.getElementById("licy11").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg11").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind11").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser11").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar11").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="620200"){-->
						    			<#--document.getElementById("licy12").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg12").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind12").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser12").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar12").innerHTML = data[i].negak;-->
						    		<#--}else if(data[i].countyId=="632222"){-->
						    			<#--document.getElementById("licy13").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg13").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind13").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser13").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar13").innerHTML = data[i].negak;-->
						    		<#--}else{-->
						    			<#--document.getElementById("licy14").innerHTML = data[i].popolicy;-->
						    			<#--document.getElementById("arg14").innerHTML = data[i].iararg;-->
						    			<#--document.getElementById("ind14").innerHTML = data[i].iarind;-->
						    			<#--document.getElementById("ser14").innerHTML = data[i].iarser;-->
						    			<#--document.getElementById("urpar14").innerHTML = data[i].negak;-->
						    		<#--}-->
						    	<#---->
						    	<#--}-->
						 <#--}-->
						<#---->
					<#--})-->
					<#--//获取水资源管理参数-->
					<#--$.get("getWaterPara.do", -->
						<#--{-->
						<#--"id" : "${projectId}"-->
						<#--}, function(data) {-->
						<#--console.log(data);-->
						<#--var i=0;-->
						 <#--if(data != null){-->
						    	<#--for(i;i<=data.length;i++){-->
						    		<#--if(data[i].countyId=="0"){-->
						    			<#--//document.getElementById("up1").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down1").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb1").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur1").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw1").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup1").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="1"){-->
						    			<#--//document.getElementById("up2").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down2").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb2").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur2").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw2").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup2").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="2"){-->
						    			<#--//document.getElementById("up3").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down3").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb3").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur3").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw3").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup3").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620702"){-->
						    			<#--//document.getElementById("up4").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down4").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb4").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur4").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw4").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup4").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620723"){-->
						    			<#--//document.getElementById("up5").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down5").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb5").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur5").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw5").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup5").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620724"){-->
						    			<#--//document.getElementById("up6").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down6").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb6").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur6").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw6").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup6").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="152923"){-->
						    			<#--//document.getElementById("up7").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down7").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb7").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur7").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw7").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup7").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620921"){-->
						    			<#--//document.getElementById("up8").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down8").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb8").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur8").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw8").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup8").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620722"){-->
						    			<#--//document.getElementById("up9").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down9").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb9").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur9").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw9").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup9").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620721"){-->
						    			<#--//document.getElementById("up10").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down10").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb10").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur10").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw10").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup10").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620902"){-->
						    			<#--//document.getElementById("up11").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down11").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb11").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur11").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw11").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup11").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="620200"){-->
						    			<#--//document.getElementById("up12").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down12").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb12").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur12").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw12").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup12").innerHTML = data[i].supWater;-->
						    		<#--}else if(data[i].countyId=="632222"){-->
						    			<#--//document.getElementById("up13").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down13").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb13").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur13").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw13").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup13").innerHTML = data[i].supWater;-->
						    		<#--}else{-->
						    			<#--//document.getElementById("up14").innerHTML = data[i].upstreamwater;-->
						    			<#--document.getElementById("down14").innerHTML = data[i].flowDown;-->
						    			<#--document.getElementById("wdb14").innerHTML = data[i].waterdistribution;-->
						    			<#--document.getElementById("sur14").innerHTML = data[i].surSup;-->
						    			<#--document.getElementById("gw14").innerHTML = data[i].gwsup;-->
						    			<#--document.getElementById("sup14").innerHTML = data[i].supWater;-->
						    		<#--}-->
						    	<#---->
						    	<#--}-->
						 <#--}-->
						<#---->
					<#--})-->
					<#--</script>-->
					<div class="admin-tab-item" style="width: 85%;margin: 0 auto;">
						<div class="admin-tab-title">${startmodel}</div>
						<div class="admin-ribbons" >
							<div class="admin-ribbons-custom">${selpar}</div>
							<div>
								<div class="admin-yunxing-radio">
									<!-- 不使用经济代理模型  -->
									<label class="admin-radio">
										<input type="radio" id="radio7" name="a" value="true" checked="checked"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model7}
									</label>
									<!-- 使用经济代理模型 -->
									<label class="admin-radio">
										<input type="radio"  id="radio8" name="a" value="false"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model8}
									</label>
								</div>
								<div class="admin-yunxing-radio">
									<!-- 先触发生态水文代理模型  -->
									<label class="admin-radio">
										<input type="radio" id="radio1" name="0" value="false" checked="checked"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model1}
									</label>
									<!-- 先触发社会经济代理模型  -->
									<label class="admin-radio">
										<input type="radio"  id="radio2" name="0" value="true"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model2}
									</label>
								</div>
								<div class="admin-yunxing-radio">
									<!-- 使用缺省的生态水文代理模型  -->
									<label class="admin-radio">
										<input class="upload-model" type="radio" id="radio3" name="2" value="true" checked="checked"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model3}
									</label>
									<!-- 上传生态水文代理模型  -->
									<label class="admin-radio">
										<input class="upload-model" type="radio" id="radio4" name="2" value="false"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model4}
									</label>
								</div>
								<div class="admin-yunxing-radio">
									<!-- 使用缺省指标计算函数 -->
									<label class="admin-radio">
										<input class="upload-fun" type="radio" name="3" id="radio5" value="true" checked="checked"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model5}
									</label>
									<!-- 上传指标计算函数  -->
									<label class="admin-radio">
										<input class="upload-fun" type="radio" id="radio6" name="3" value="false"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model6}
									</label>
								</div>
							</div>
						</div>
<!-- -----------------------------------------上传代理模型------------------------------------------------------- -->
						<div class="admin-ribbons surrogate-model" style="display: none;">
							<div class="admin-ribbons-custom">${model4}</div>
							<div style="padding: 0;">
								<div class="admin-card fl" style="width: 100%;">
									<div class="admin-card-title">
										<h3>变量对照表</h3>
										<!-- <button id="add-variable" class="admin-btn admin-btn-blue">添加</button> -->
									</div>
									<div class="admin-card-content" style="max-height:419px;height: 419px;">
										<table class="variable-wrap admin-table admin-stuation-table">
											<thead>
												<tr>
													<th style="min-width: auto;width:auto;">变量名</th>
													<th>意义</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>PreChangeR</td>
													<td>降雨增加比例</td>
													<td>%</td>
												</tr>
												<tr>
													<td>TempChange</td>
													<td>温度变化</td>
													<td>℃</td>
												</tr>
												<tr>
													<td>LandForestR</td>
													<td>土地利用变化-林地</td>
													<td>%</td>
												</tr>
												<tr>
													<td>LandGrassR</td>
													<td>土地利用变化-草地</td>
													<td>%</td>
												</tr>
												<tr>
													<td>LandBareR</td>
													<td>土地利用变化-裸地</td>
													<td>%</td>
												</tr>
												<tr>
													<td>LandCityR</td>
													<td>土地利用变化-城镇</td>
													<td>%</td>
												</tr>
												<tr>
													<td>FlowYLX</td>
													<td>莺落峡流量输出</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>FlowOther</td>
													<td>其他河流流量输出</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>LandFarmR</td>
													<td>耕地变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>SupWater</td>
													<td>非农业供水量</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>FlowDown</td>
													<td>中下游分水比例</td>
													<td>%</td>
												</tr>
												<tr>
													<td>SurSup</td>
													<td>地表供水量</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>GWSup</td>
													<td>地下供水量</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>CropET</td>
													<td>作物蒸散发</td>
													<td>亿立方米</td>
												</tr>
												<tr>
													<td>WetlandArea</td>
													<td>湿地面积</td>
													<td>万亩</td>
												</tr>
												<tr>
													<td>CPWhR</td>
													<td>小麦耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>CPCornR</td>
													<td>玉米耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>CPOilR</td>
													<td>油料耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>CPVegR</td>
													<td>蔬菜耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>CPFTR</td>
													<td>果园耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>CPCotR</td>
													<td>棉花耕种面积变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>IARArg</td>
													<td>产业技术进步率-农业</td>
													<td>%</td>
												</tr>
												<tr>
													<td>IARInd</td>
													<td>产业技术进步率-工业</td>
													<td>%</td>
												</tr>
												<tr>
													<td>IARSer</td>
													<td>产业技术进步率-服务业</td>
													<td>%</td>
												</tr>
												<tr>
													<td>ArgValue</td>
													<td>农业产值</td>
													<td>亿元</td>
												</tr>
												<tr>
													<td>IndValue</td>
													<td>工业产值</td>
													<td>亿元</td>
												</tr>
												<tr>
													<td>SerValue</td>
													<td>服务业产值</td>
													<td>亿元</td>
												</tr>
												
												<tr>
													<td>LandCIR</td>
													<td>城镇工业用地变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>LandSerR</td>
													<td>服务业用地变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>WaterPR</td>
													<td>水价变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>EmpR</td>
													<td>就业率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>SurWDR</td>
													<td>地表需水量变化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>GWWDR</td>
													<td>地下需水量变化率</td>
													<td>%</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="fr" style="width: 59%;">
									<div class="admin-card">
										<div class="admin-card-title">
											<h3>代理模型函数规则说明</h3>
										</div>
										<div class="admin-card-content" style="max-height: unset;">
											<textarea class="admin-textarea admin-surrogate-textarea" disabled="disabled">代理模型函数说明
1.代理模型有若干个输入和输出。
2.如果代理模型的每个输出之间有调用关系，则被调用的输出函数要写在前面。
3.上传代理模型函数时，遵照以下约定：
	1)函数的输入输出变量，大小写敏感，严格按照给定的“变量对照表”来。
	2)函数中的所有字符为英文格式。
	3)函数放在txt文件中，每行为一个函数。
	4)函数表达式只能出现加、减、乘、除运算符（+，-，*，/），可以出现小括号。
	5)函数格式:
		每个函数格式如下：
		输出变量=函数体
		 举例： 输出为Y，输入为X，Z的函数Y=3X^5 Z^2-5〖(X+Z)〗^(-1) Z^3+7 要写为如下格式：   Y=3*X*X*X*X*X*Z*Z-5*Z*Z*Z/(X+Z)+7
											</textarea>
										</div>
									</div>
									<form class="admin-form" action="addAgentModel.do" enctype="multipart/form-data" method="post">
										<span>上传上游代理模型：<input type="file" id="upstream" name="upstream"/></span>
										<span>上传生态水文代理模型：<input type="file" id="hydrology" name="hydrology"/></span>
										<span>上传社会经济代理模型：<input type="file" id="economic" name="economic"/></span>
										<button class="admin-btn admin-btn-blue" id="agentmodel_submit" type="submit">保存</button>
									</form>
								</div>
							</div>
						</div>

<!-- -----------------------------------------上传指标计算函数------------------------------------------------------- -->						
						<div class="admin-ribbons surrogate-fun" style="display: none;">
							<div class="admin-ribbons-custom">${model6}</div>
							<div style="padding: 0;">
								<div class="admin-card fl" style="width: 100%;">
									<div class="admin-card-title">
										<h3>变量对照表</h3>
										<!-- <button id="add-variable" class="admin-btn admin-btn-blue">添加</button> -->
									</div>
									<div class="admin-card-content" style="max-height:340px;height: 340px;">
										<table class="variable-wrap admin-table admin-stuation-table">
											<thead>
												<tr>
													<th style="min-width: auto;width:auto;">变量名</th>
													<th>意义</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>waterProductivity</td>
													<td>提高水生产力到b%</td>
													<td></td>
												</tr>
												<tr>
													<td>waterPressure</td>
													<td>在各个层次上减小用水压力到m%</td>
													<td></td>
												</tr>
												<tr>
													<td>safeDrinkingWaterR</td>
													<td>提高流域社会安全饮用水人口比例到d%</td>
													<td></td>
												</tr>
												<tr>
													<td>iwrmR</td>
													<td>集成水资源管理执行度d%</td>
													<td></td>
												</tr>
												<tr>
													<td>transboundaryAvailability</td>
													<td>跨边界流域可操作合约有效性e%</td>
													<td></td>
												</tr>
												<tr>
													<td>areaWetland</td>
													<td>维持流域可持续湿地面积d万亩</td>
													<td></td>
												</tr>
												<tr>
													<td>waterDemandEco</td>
													<td>维持下游可持续生态系统发展所需最小分水量f亿m3</td>
													<td></td>
												</tr>
												<tr>
													<td>groundwaterMining</td>
													<td>中游地下水开采量i 亿m3</td>
													<td></td>
												</tr>
												<tr>
													<td>waterUseEco</td>
													<td>中游生态系统用水量j 亿m3</td>
													<td></td>
												</tr>
												<tr>
													<td>forestCoverR</td>
													<td>森林覆盖率b%</td>
													<td></td>
												</tr>
												<tr>
													<td>forestSustainableR</td>
													<td></td>
													<td>可持续森林管理覆盖b%</td>
												</tr>
												<tr>
													<td>mountainGreenCoverR</td>
													<td>山地绿色覆盖指数b%</td>
													<td></td>
												</tr>
												<tr>
													<td>gdpPerCapita</td>
													<td>人均GDP</td>
													<td></td>
												</tr>
												
												<tr>
													<td>gdpPerCapitaEmployed</td>
													<td>就业人口人均 GDP</td>
													<td></td>
												</tr>
												<tr>
													<td>youthEmpR</td>
													<td>年轻人（15-24）在教育，就业和培训中的比例</td>
													<td>%</td>
												</tr>
												<tr>
													<td>gdpTourismR</td>
													<td>旅游业产值在 GDP 中的比例</td>
													<td>%</td>
												</tr>
												<tr>
													<td>landPopuR</td>
													<td>土地利用率(土地消耗率与人口增长率的比率)</td>
													<td>%</td>
												</tr>
												<tr>
													<td>urbanR</td>
													<td>城镇化率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>avgWelfare</td>
													<td>人均社会福利</td>
													<td></td>
												</tr>
												<tr>
													<td>waterProductivityAgri</td>
													<td>提高农业水生产力到b</td>
													<td></td>
												</tr>
												
												<tr>
													<td>waterUseEffiAgri</td>
													<td>提高农业水利用效率到c%</td>
													<td></td>
												</tr>
												<tr>
													<td>agriOutputPerHectar</td>
													<td>提高每公顷农产品产值d元</td>
													<td></td>
												</tr>
												<tr>
													<td>areaCrop</td>
													<td>维持可持续发展的中游耕地面积在e万亩</td>
													<td></td>
												</tr>
												<tr>
													<td>GDP</td>
													<td>总产值</td>
													<td>元</td>
												</tr>
												<tr>
													<td>waterDemand</td>
													<td>总需水量</td>
													<td>m3</td>
												</tr>
												<tr>
													<td>waterConsumption</td>
													<td>总用水量</td>
													<td>亿m3</td>
												</tr>
												<tr>
													<td>freshWater</td>
													<td>淡水总量</td>
													<td>亿m3</td>
												</tr>
												<tr>
													<td>POPws</td>
													<td>饮用卫生达标水的人口数量</td>
													<td>万人</td>
												</tr>
												
												<tr>
													<td>POP</td>
													<td>区域总人口数量</td>
													<td>万人</td>
												</tr>
												<tr>
													<td>waterManageArea</td>
													<td>水管理措施影响到的区域面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>area</td>
													<td>区域总面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>contractArea</td>
													<td>合约影响到的地表水和地下水区域面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>Awet0</td>
													<td>基准年湿地面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>wet_rise_R</td>
													<td>湿地面积年增长率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>waterDemand</td>
													<td>区域总需水量</td>
													<td>m3</td>
												</tr>
												<tr>
													<td>St</td>
													<td>为区域地表水总用水量</td>
													<td>m3</td>
												</tr>
												<tr>
													<td>Farea</td>
													<td>区域森林面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>Larea</td>
													<td>区域陆地面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>FMarea</td>
													<td>受管理森林面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>Farea</td>
													<td>区域森林面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>MGarea</td>
													<td>山地所有绿色覆盖面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>Area</td>
													<td>山地所在区域总面积</td>
													<td>km2</td>
												</tr>
												<tr>
													<td>DGP</td>
													<td>区域总GDP</td>
													<td>万元</td>
												</tr>
												<tr>
													<td>POP</td>
													<td>区域总人口数量</td>
													<td>万人</td>
												</tr>
												
												<tr>
													<td>POPemp</td>
													<td>区域就业人口总数量</td>
													<td>万人</td>
												</tr>
												<tr>
													<td>Ypemp</td>
													<td>区域年轻人（15-24）在教育，就业和培训中的人口数量</td>
													<td>人</td>
												</tr>
												<tr>
													<td>Ypt</td>
													<td>区域年轻人总数量</td>
													<td>人</td>
												</tr>
												<tr>
													<td>Tourv</td>
													<td>旅游业产值</td>
													<td>万元</td>
												</tr>
												<tr>
													<td>LandConR</td>
													<td>土地消耗率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>POPgr</td>
													<td>人口增长率</td>
													<td>%</td>
												</tr>
												<tr>
													<td>POPurban</td>
													<td>城镇化人口数量</td>
													<td></td>
												</tr>
												<tr>
													<td>Ya</td>
													<td>农业总产值 </td>
													<td>元</td>
												</tr>
												<tr>
													<td>Qtot</td>
													<td>农业总用水量</td>
													<td>m3</td>
												</tr>
												<tr>
													<td>Ea</td>
													<td>作物总蒸腾量</td>
													<td>m3</td>
												</tr>
												<tr>
													<td>APtv</td>
													<td>农产品总产值</td>
													<td></td>
												</tr>
												<tr>
													<td>At</td>
													<td>农产品总种植面积</td>
													<td></td>
												</tr>
												<tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="fr" style="width: 59%;">
									<div class="admin-card">
										<div class="admin-card-title">
											<h3>指标计算函数规则说明</h3>
										</div>
										<div class="admin-card-content" style="max-height: unset;">
											<textarea class="admin-textarea admin-surrogate-textarea" disabled="disabled">指标函数说明
1.指标有若干个输入和输出。
2.如果指标的每个输出之间有调用关系，则被调用的输出函数要写在前面。
3.上传指标函数时，遵照以下约定：
	1)函数的输入输出变量，大小写敏感，严格按照给定的“变量对照表”来。
	2)函数中的所有字符为英文格式。
	3)函数放在txt文件中，每行为一个函数。
	4)函数表达式只能出现加、减、乘、除运算符（+，-，*，/），可以出现小括号。
	5)函数格式:
		每个函数格式如下：
		输出变量=函数体
		举例： 输出为Y，输入为X，Z的函数Y=3X^5 Z^2-5〖(X+Z)〗^(-1) Z^3+7 要写为如下格式：   Y=3*X*X*X*X*X*Z*Z-5*Z*Z*Z/(X+Z)+7
										
											</textarea>
										</div>
									</div>
									<span>上传指标计算函数：<input type="file" id="index"/></span>
									<button class="admin-btn admin-btn-blue" id="index_submit">保存</button>
								</div>
							</div>
						</div>
						
<!-- -------------------------------------------------------------------------------------------------------------- -->

						<!-- 模型运行-->
						<div class="admin-ribbons">
							<div class="admin-ribbons-custom">${startmodel}
							<button id="downexcel" onclick="window.location.href= 'downexcelmodel.do'">${download}</button>
							</div>
							<div class="admin-abstract">
								<div class="admin-table-wrap">
									<table class="admin-table admin-result-table">
										<thead>
											<tr>
												<th colspan="1" style="width: 50%">${time1}</th>
												<th colspan="1" style="width: 50%">${time2}</th>
											</tr>
										</thead>
										<tbody>
											<tr>
											<td id="start_time" style="text-align: center;">1</td>
											<td id="end_time" style="text-align: center;">1</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="admin-yunxing">
								<div class="admin-assessment" style="padding: 0;">
									<img src="static/images/loading.gif"/>
									<button id="toResult" class="admin-btn">${startmodel}</button>
								</div>
							</div>
						</div>
						<!-- 
							<div class="admin-ribbons">
							<div class="admin-ribbons-custom">${startmodel}</div>
							<div class="admin-yunxing">
								<img src="static/images/loading.gif"/>
								<button id="toResult"  class="admin-btn">${startmodel}</button>
							</div>
						</div>
						 -->
						
						<!-- <div class="admin-ribbons">
							<div class="admin-ribbons-custom">${Status}</div>
							<div class="admin-yunxing">
								${Used}<input id="txt" type="text" class="admin-input" readonly="readonly"/>${second}
							</div>
						</div> -->
					</div>
					
					<!-- 模拟结果 -->
					<div class="admin-tab-item" style="padding: 10px 20px 0;">
						<div class="admin-tab-title">${SSR}</div>
						<div class="admin-ribbons admin-ribbons-nob">
							<div class="admin-ribbons-custom">
								${SR}
								<select id="selectCounty_data" class="admin-select" style="height: auto;">
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
									<option value="0" selected="selected">${quanliuyu}</option>
									<option value="1">${upstream}</option>
									<option value="2">${mal}</option>
								</select>
								<button id="downexcel" onclick="window.location.href= 'downexcel2.do'">${download}</button>
							</div>
							
							<div>
								<div id ="result" class="admin-table-wrap" style="width: 100%; min-height: 240px; overflow: auto; border: none;">
									<table id="jumpToResult_resultTable" class="table admin-table admin-table-no">
										<thead>
											<tr>
												<th>${yearindex}</th>
												<th>${index}</th>
												<th>${index1}</th>
												<th>${index2}</th>
												<!-- <th>${index3}</th>
												<th>${index4}</th>
												<th>${index5}</th>
												<th>${index6}</th> -->
												<th>${index7}</th>
												<!-- <th>${index8}</th> -->
												<th>${index9}</th>
												<th>${index10}</th>
												<th>${index11}</th>
												<th>${index12}</th>
												<th>${index13}</th>
												<!-- <th>${index14}</th>
												<th>${index15}</th>
												<th>${index16}</th> -->
												<th>${index17}</th>
												<!-- <th>${index18}</th> -->
												<th>${index19}</th>
												<th>${index20}</th>
												<!-- <th>${index21}</th> -->
												<th>${index22}</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 可持续发展评价 -->
					<div class="admin-tab-item" style="width: 85%;margin: 0 auto;">
					  
						<div class="admin-ribbons">
							<div class="admin-ribbons-custom">${duo}</div>
							<div>
								<div class="admin-yunxing-radio">
									<span style="font-size: 14px;">${selecta}：</span>
									<label class="admin-radio" style="width: 30%;">
										<input type="radio" id="radio1" name="1" value="false" checked="checked"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model1}
									</label>
									<label class="admin-radio" style="width: 30%;">
										<input type="radio"  id="radio2" name="1" value="true"/>
										<span>
											<i class="icon iconfont">&#xe6d7;</i>
											<i class="icon iconfont">&#xe75b;</i>
										</span>
										${model2}
									</label>
								</div>
								<div class="admin-yunxing-radio">
									<div class="admin-yunxing" style="text-align: left;font-size: 14px;padding-bottom: 15px !important;">
										${pen}：<input id="num" type="text" class="admin-input" style="background-color: #FFFFFF;text-align:center;padding:0;margin: 0 5px;height: 32px;line-height: 32px;"/>
									</div>
									<div style="text-align: center;padding-top:10px;padding-bottom: 30px;">
										<button id="toTest" class="admin-btn admin-btn-blue" style="margin-right: 10px;">${ctst}</button>
										<button id="TestContinue" class="admin-btn admin-btn-blue" style="margin-right: 10px;">${testcontinue}</button>
										<button id="Testresult" class="admin-btn admin-btn-blue" style="margin-left: 10px;" onclick="getTestFlag();">${downloadtest}</button>
									</div>
								</div>
							</div>
						</div>
					 
						<!--添加-->
						<div class="admin-ribbons">
							<div class="admin-ribbons-custom">${Assessment}</div>
							<div class="admin-yunxing">
								<div class="admin-assessment" style="padding: 0;">
									<select id="select_quan">
										<option value="true" selected="selected">指标主观赋权</option>
										<option value="false">指标客观赋权</option>
									</select>
								</div>
								<hr>
								<div class="admin-assessment" style="padding: 0;">
									<img src="static/images/loading.gif"/>
									<button id="startEvalModel" class="admin-btn">${Assessment}</button>
								</div>
							</div>
						</div>
						<!---->
						<!--<div class="admin-assessment">
							<img src="static/images/loading.gif"/>
							<button id="startEvalModel" class="admin-btn">发展评价</button>-->
							
							<!-- 
							<button  type="button" id="testFunc" class="btn btn-primary pro-btn" onclick="javascript:;">测试解析函数</button>
				         	<button  type="button" id="testReadFunc" class="btn btn-primary pro-btn" onclick="javascript:;">测试读数据库</button>
				         	--> 
						<!--</div>-->
						<div class="admin-assessment-result">
							<a class="admin-btn" href="gis.do" target="adminFrameName">${ver}</a>
							<a class="admin-btn" href="report.html" target="adminFrameName">${vere}</a>
						</div>
						<!-- 
						<div class="admin-ribbons">
							<div class="admin-ribbons-custom">${toes}</div>
							<div class="admin-yunxing" style="font-size: 14px;">
								${toeuse}<input id="txt2" type="text" class="admin-input" readonly="readonly" style="margin:0 10px;text-align: center;padding: 0;height: 32px;line-height: 32px;"/>${second}
							</div>
						</div> 
						 -->
						</div>
					</div>
				</div>
			</div>
		
		
		<script type="text/javascript">
			//选项卡
			$("#jumpToResult .admin-tab .admin-tab-item").eq(0).show().siblings().hide();//显示第一个，隐藏其他的
			$("#jumpToResult .admin-tab .admin-tab-top li").on("click", function() {//选项卡切换
				var i = $(this).index();
				console.log(i)
				$(this).addClass("admin-this").siblings().removeClass("admin-this");
				$("#jumpToResult .admin-tab .admin-tab-cont .admin-tab-item").eq(i).show().siblings().hide();
			})
			
			//步骤条宽度设置
			/*function StepsWidth(){
				var width=($(".admin-steps").width()-350)/2+"px";
				$(".admin-steps-item-tail").width(width);
			}
			StepsWidth();
			$(window).on("resize",function(){
				StepsWidth();
			});
			*/
			//上传模型radio
			$(".upload-model").change(function(e){
				$(".surrogate-model").stop().slideToggle(0);
			})
			//上传计算函数radio
			$(".upload-fun").change(function(e){
				$(".surrogate-fun").stop().slideToggle(0);
			})
			
			//滑过添加按钮
			$("body").on("mouseover","#add-variable",function(){
				var that = this;
				layer.tips('点击添加变量', that,{time:1000});
			})
			//添加对照变量
			$("body").on("click","#add-variable",function(){
				var variable="<tr>"
								+"<td><input class='admin-input' type='text'/></td>"
								+"<td><input class='admin-input' type='text'/></td>"
								+"<td><input class='admin-input' type='text'/></td>"
							  +"</tr>"
				$(".variable-wrap").append(variable)
			})
			
			/*
			//滑过table提示编辑
			$("body").on("mouseover",".variable-wrap tr",function(){
				var that = this;
				layer.tips('点击编辑变量',that,{tips:4,time:1000});
			})
			*/
			//滑过保存按钮，提示保存
				$("body").on("mouseover",".admin-yunxing button",function(){
					var that = this;
					layer.tips('${Clicktorunmodel}', that,{time:1000});//${Clicktorunmodel}
				})
				//保存
				$("body").on("click",".admin-yunxing button",function(){
					var load=parent.layer.load('',{shade:[0.3,"#000"]});
					setTimeout(function(){
						//关闭加载
						parent.layer.close(load);
						//parent.layer.msg('END',{time:1000});
					},2000)
				})
				
			$.get("getStartTime.do", 
					{
						<#--  "projectId" : "${projectId}"  -->
					}, 
					function(data) {
						document.getElementById("start_time").innerHTML = data;
				});
			
			$.get("getEndTime.do", 
					{
					<#--  "projectId" : "${projectId}"  -->
					}, 
					function(data) {
						document.getElementById("end_time").innerHTML = data;
				});
			
			var goalyear = 0;
			$.get("getgoalyear.do", 
						{
						<#--  "projectId" : "${projectId}"  -->
						}, function(data) {
							goalyear = data;
							console.log(goalyear);
						});
			var c = 0;
			function timedCount(){
				console.log("当前C的值为:"+c);
				c = c + 1;
				t = setTimeout("timedCount()",1000);
				if(c> (goalyear-2012+1)*30){
					$.ajax({
						async:false,
						type: "post",
						url: "inputEndTime.do",
						data: { 
							"projectId" : "${projectId}",
						},
						success: function (data) {
							alert("Success！");
						}
					});
					$("#toResult").attr("disabled",false).text('${startmodel}');//${startmodel}
					$("#toResult").siblings('img').hide();
					$(".admin-tab .admin-tab-item").eq(2).show().siblings().hide();
					clearTimeout(t);
				}
			}
			
			//模型计算
			$("#toResult").on("click", function() {
				alert("${Modelcalculation}");
				$.ajax({
					async:false,
					type: "post",
					url: "inputStartTime.do",
					data: { 
						// "projectId" : "${projectId}",
					},
					success: function (data) {}
				});

				console.log("已触发经济模型:"+(new Date()));
				//被禁用的 input 元素既不可用，也不可点击。可以设置 disabled 属性，
				//直到满足某些其他的条件为止（比如选择了一个复选框等等）。然后，就需要通过 JavaScript 
				//来删除 disabled 值，将 input 元素的值切换为可用。
				$("#toResult").attr("disabled","true");
				$(this).attr("disabled",true).text('${moderuning}');//${moderuning}
				$(this).siblings('img').show();
				$.ajax({
					// async:false,
					async: true,
					cache: false,
					type: "post",
					url: "startProxyModel.do",
					data: { 
						// "projectId" : "${projectId}",
						"economicFrist":$("input[name='0']:checked").val(),      //radio button的选值  注意是Boolean类型   选择先计算经济模型true 否则为false
						//"useDefaultModel":$("input[name='2']:checked").val(),    //radio button的选值  注意是Boolean类型 选择使用缺省代理模型true 否则为false
						//"usrDefaultIndicator:$("input[name='3']:checked").val(),//radio button的选值  注意是Boolean类型 选择使用缺省指标函数true 否则为false
						//"useTerm":$("input[na"me='a']:checked").val()             //radio button的选值  注意是Boolean类型 选择不使用代理模型true 否则为false
					},
					success: function (data) {
						console.log("startProxyModel.do")
						console.log(data)
						alert(data);
						$.ajax({
							async:false,
							type: "post",
							url: "inputEndTime.do",
							data: { 
								// "projectId" : "${projectId}",
							},
							success: function (data) {
								console.log("inputEndTime.do Success！")
							}  
						});
					},
					complete: function () {
						$("#toResult").attr("disabled",false).text('${startmodel}');//${startmodel}
						$("#toResult").siblings('img').hide();
						$(".admin-tab .admin-tab-item").eq(2).show().siblings().hide();
					},
					error: function (xhr, status, error) {
						console.log(error)
					}
				});
			});
			/*
			$("#toResult").on("click", function() {
				console.log("已触发:"+(new Date()));
				//被禁用的 input 元素既不可用，也不可点击。可以设置 disabled 属性，
				//直到满足某些其他的条件为止（比如选择了一个复选框等等）。然后，就需要通过 JavaScript 
				//来删除 disabled 值，将 input 元素的值切换为可用。
				$("#toResult").attr("disabled","true");
				
				$(this).attr("disabled",true).text("${moderuning}");
				$(this).siblings('img').show();
				
				$.post("startProxyModel.do", {
					"projectId" : "${projectId}",
					"economicFrist":$("input[name='0']:checked").val(),      //radio button的选值  注意是Boolean类型   选择先计算经济模型true 否则为false
					"useDefaultModel":$("input[name='2']:checked").val(),    //radio button的选值  注意是Boolean类型 选择使用缺省代理模型true 否则为false
					"usrDefaultIndicator":$("input[name='3']:checked").val(),//radio button的选值  注意是Boolean类型 选择使用缺省指标函数true 否则为false
					"useTerm":$("input[name='a']:checked").val()             //radio button的选值  注意是Boolean类型 选择不使用代理模型true 否则为false
				}, function(data) {
					console.log("我已将模型运行完毕");
					alert(data.content);
					$("#toResult").attr("disabled",false).text("${startmodel}");
					$("#toResult").siblings('img').hide();
					$(".admin-tab .admin-tab-item").eq(2).show().siblings().hide();
						
				});
			});
			*/
			
			
			$("#toTest").on("click",function(){
				alert("${StartCalculation}");
				$("#toTest").attr("disabled","true");
				$.post("startTestMany.do", 
						{
							<#--  "projectId":"${projectId}",  -->
						 "economicFrist":$("input[name='a']:checked").val(),
						 "step":document.getElementById('num').value,
						 //"useTerm":"true",
						 "newStart":"true"
						},
							//function(indistr) {
						function(data){
							<#--  alert(data.content);  -->
							console.log("startTestMany.do")
							console.log(data)
						//console.log("${testend}");
						//clearTimeout(timer);
						//alert(indistr);
						//window.location.href='gis.do';
					});
			});
			
			$("#TestContinue").on("click",function(){
				alert("${CalculationContinue}");
				$("#toTest").attr("disabled","true");
				$.post("startTestMany.do", 
						{
							<#--  "projectId":"${projectId}",  -->
						 "economicFrist":$("input[name='a']:checked").val(),
						 "step":document.getElementById('num').value,
						 //"useTerm":"true",
						 "newStart":"false"
						},
							//function(indistr) {
						function(data){
							<#--  alert(data.content);  -->
							console.log("startTestMany.do")
							console.log(data)
						//console.log("${testend}");
						//clearTimeout(timer);
						//alert(indistr);
						//window.location.href='gis.do';
					});
			});
			
			function getTestFlag(){
				$.get("getTestFlag.do",
					 {}, 
					 function(data){
			        	if(data == "1"){
			        		alert("${wait}");
			        	}else{
			        		window.location.href='downexcel3.do';
			        	}
			        }
			    )
			};
			
			var time = 0;
			function timedEvalModel(){
				
				console.log("当前time的值为:"+time+"目标年："+goalyear);
				time =time+1;
				t=setTimeout("timedEvalModel()",1000);
				if(time> (goalyear-2012+1)*5){
					alert("Success！");
					$("#startEvalModel").attr("disabled",false).text("${Assessment}");
					$("#startEvalModel").siblings('img').hide();
					$(".admin-assessment-result").fadeIn("fast");
					clearTimeout(t);
				}
			}
			
			//评价
			$("#startEvalModel").on("click",function(){
				timedEvalModel();
				console.log("已触发评价模型:"+(new Date()));
				$("#startEvalModel").attr("disabled","true");
				$(this).attr("disabled",true).text("${Intheevaluation}");//${Intheevaluation}
				$(this).siblings('img').show();
				
				$.ajax({
						type: "post",
						url: "startAssess.do",
						data: {
								<#--  "projectId" :"${projectId}",  -->
								"sub":document.getElementById('select_quan').value},
						//dataType:"json",
						async:false,
						success: function(data){
							<#--  alert(data.content);  -->
							console.log("startTestMany.do")
							console.log(data)
							//clearTimeout(timer);
							$("#startEvalModel").attr("disabled",false).text("${Assessment}");
							$("#startEvalModel").siblings('img').hide();
							$(".admin-assessment-result").fadeIn("fast");
						}
			  });
				//$.post("startAssessTest.do",
				/*$.post("startAssess.do", 
					{projectId:"${projectId}"},
					//timeout:300000,
						//function(indistr) {
					function(data){
					alert(data.content);
					//$("#txt2").attr("value","");
					//console.log("${Evaluationend}");
					clearTimeout(timer);
					//alert(indistr);
					//window.location.href='gis.do';
					$("#startEvalModel").attr("disabled",false).text("${Assessment}");
					$("#startEvalModel").siblings('img').hide();
					$(".admin-assessment-result").fadeIn("fast");
				});*/
				//setTimeout(function(){
				//	$("#startEvalModel").attr("disabled",false).text("发展评价");
				//	$("#startEvalModel").siblings('img').hide();
				//	$(".admin-assessment-result").fadeIn("fast");
				//},4000);
			});
			
			$("#selectCounty_data").on("change", function() {
				$("#jumpToResult_resultTable").empty("");
				 var insertText = "<table id='jumpToResult_resultTable' class='table admin-table admin-table-no'>"+
				 "<thead><tr><th>${yearindex}</th>"+
				 "<th>${index}</th>"+
				 "<th>${index1}</th>"+
				 "<th>${index2}</th>"+
												//<!-- <th>${index3}</th>
												//<th>${index4}</th>
												//<th>${index5}</th>
												//<th>${index6}</th> -->
				"<th>${index7}</th>"+
												//<!-- <th>${index8}</th> -->
				"<th>${index9}</th>"+
				"<th>${index10}</th>"+
				"<th>${index11}</th>"+
				"<th>${index12}</th>"+
				"<th>${index13}</th>"+
												//<!-- <th>${index14}</th>
												//<th>${index15}</th>
												//<th>${index16}</th> -->
				"<th>${index17}</th>"+
												//<!-- <th>${index18}</th> -->
				"<th>${index19}</th>"+
				"<th>${index20}</th>"+
												//<!-- <th>${index21}</th> -->
				"<th>${index22}</th>"+
				 
				 "</tr></thead>"+
				 "<tbody>"+
				 //"<tr><td>${index}</td></tr>"+
				 //"<tr><td>${index1}</td></tr>"+
				 //"<tr><td>${index2}</td></tr>"+
				 //"<tr><td>${index3}</td></tr>"+
			     //"<tr><td>${index4}</td></tr>"+
				 //"<tr><td>${index5}</td></tr>"+
				 //"<tr><td>${index6}</td></tr>"+
				 //"<tr><td>${index7}</td></tr>"+
				 //"<tr><td>${index8}</td></tr>"+
				 //"<tr><td>${index9}</td></tr>"+
				 //"<tr><td>${index10}</td></tr>"+
				 //"<tr><td>${index11}</td></tr>"+
				 //"<tr><td>${index12}</td></tr>"+
				 //"<tr><td>${index13}</td></tr>"+
				 //"<tr><td>${index14}</td></tr>"+
				 //"<tr><td>${index15}</td></tr>"+
				 //"<tr><td>${index16}</td></tr>"+
				 //"<tr><td>${index17}</td></tr>"+
				 //"<tr><td>${index18}</td></tr>"+
				 //"<tr><td>${index19}</td></tr>"+
				 //"<tr><td>${index20}</td></tr>"+
				 //"<tr><td>${index21}</td></tr>"+
				 //"<tr><td>${index22}</td></tr>"+
				 "</tbody>"+
			 	 "</table>";
			 	document.getElementById("result").innerHTML=insertText;
			 	//$("#startEvalModel").text("年份数据不足").empty("");
			 	$("#startEvalModel").attr("disabled",false).text("${Assessment}");
				queryAvailable();
			});
			//获取模拟结果年份
			function queryAvailable(){
				$.get("queryAvailablews.do",
					 {"countyId" :$("#selectCounty_data").val()}, 
					 function(data){
			        	if(data.length>=1){
				        	getDataYearlyAsList(data);
			        	}
			        }
			    )
			};
			
			function toDecimal(x) { 
				   var f = parseFloat(x); 
				   if (isNaN(f)) { 
				    return; 
				   } 
				   f = Math.round(x*100)/100; 
				   return f; 
				  } 
			
			//获取模拟结果数据
			function getDataYearlyAsList(years){
				
			
		    	for(var i=0;i<years.length;i++){
		    		console.log("年份："+years[i]);
		    		var newTh = '<tr><td>'+years[i]+'</td></tr>';
		    		$("#jumpToResult_resultTable").append(newTh);
		    		var y = i + 1;
		    		console.log("y="+y);
		    		
		    		 $.ajax({
			 		    type: "get",
			 		    url: "getDataYearlyws.do",
			 		    data: {"countyId":$("#selectCounty_data").val(),
								"year" : years[i]},
			 		    //dataType:"json",
			 		    async:false,
			 		    success: function(data){
			 		    	var arr = new Array();
							//jsonData = JSON.stringify(data);
							console.log("data:"+data);
							if (data.length > 0) {
								for (j = 0; j < data.length; j++) {
									arr = [
										toDecimal(data[j].waterProductivity),
										toDecimal(data[j].waterPressure),
										toDecimal(data[j].safeDrinkingWaterR),
										toDecimal(data[j].groundwaterMining),
										toDecimal(data[j].forestCoverR),
										toDecimal(data[j].forestSustainableR),
										toDecimal(data[j].mountainGreenCoverR),
										toDecimal(data[j].gdpPerCapita),
										toDecimal(data[j].gdpPerCapitaEmployed),
										toDecimal(data[j].urbanR),
										toDecimal(data[j].waterProductivityAgri),
										toDecimal(data[j].waterUseEffiAgri),
										toDecimal(data[j].areaCrop)
										  ];
									console.log(arr.length);
									for(k = 0;k < arr.length;k++){
										var newTd = '<td>' + arr[k] + '</td>';
											$("#jumpToResult_resultTable tr:eq("+y+")").append(newTd);
									}
								}
							} else {
								alert("没数据!");
							}
			 		    }
			         });
		    		
					}
			};
			/*
			测试解析函数
			$("#testFunc").on("click", function() {
				$.post("testFunc.do", {
					"projectId" : "${projectId}",
				}, function(data) {
					alert(data);
				});
			});
			//测试读数据库
			$("#testReadFunc").on("click", function() {
				$.post("testReadFunc.do", {
					"projectId" : "${projectId}",
				}, function(data) {
					alert(data);
				});
			});
			*/
		</script>
	</body>
</html>