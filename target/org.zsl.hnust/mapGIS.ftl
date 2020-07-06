<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>流域可持续发展决策支持系统</title>
<!-- -------------------------leaflet------------------------- -->
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.2.0/dist/leaflet.css" 
	integrity="sha512-M2wvCLH6DSRazYeZRIm1JnYyh22purTM+FDB5CsyxtQJYeKq83arPe5wgbNmcFXGqiSH2XR8dT/fJISVA1r/zQ==" 
	crossorigin="" />
	<!-- Make sure you put this AFTER Leaflet's CSS -->
<script src="https://unpkg.com/leaflet@1.2.0/dist/leaflet.js" 
	integrity="sha512-lInM/apFSqyy1o6s89K4iQUKg6ppXEgsVxT35HbzUupEVRh2Eu9Wdl4tHj7dZO0s1uvplcYGmt3498TtHq+log==" 
	crossorigin=""></script>
	
<!-- -------------------------geoJson数据------------------------- -->
<script type="text/javascript" src="gis/geoJson/county.json"></script><!-- 区域 -->
<script type="text/javascript" src="gis/geoJson/boundary.json"></script><!-- 区域底色 -->
<script type="text/javascript" src="gis/geoJson/river.json"></script><!-- 黑河流域 -->

<!-- --------------------------esri-------------------------- -->
<link href="gis/esri/flatui/css/bootstrap.min.css" rel="stylesheet">
	<!-- Loading Flat UI -->
<link href="gis/esri/flatui/css/flat-ui.css" rel="stylesheet">
<link rel="shortcut icon" href="gis/esri/flatui/img/favicon.ico">
	<!-- 加载leaflet-->
<script src="gis/esri/esri-leaflet/esri-leaflet.js"></script>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- <script src="echarts/echarts.min.js"></script> -->
<script src="echarts/echarts.js"></script>


<!-- --------------------------easyui-------------------------- -->
<link rel="stylesheet" type="text/css" href="gis/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="gis/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="gis/easyui/themes/demo.css">
<script type="text/javascript" src="gis/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="gis/easyui/js/jquery.easyui.min.js"></script>
<#--  <link rel="stylesheet" type="text/css" href="gis/css/gis.css">  -->
<script>
	var timestamp = new Date().getTime()
	var cssList = [
		'gis/css/gis.css', 
		]
	for(var i = 0; i < cssList.length; i++) {
		var url = '<link rel="stylesheet" type="text/css" href="' + cssList[i] + '?time=' + timestamp + '">'
		document.write(url)
	}
</script>
</head>
<body>
<!-- 创建div用来显示底图 -->
<div id="mapid"></div>

<script type="text/javascript">	
	//底图定义
	//1.彩色底图
	var map1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
		attribution: null
		});
	//2.灰色底图（esri自定义底图）
		map2 = L.esri.basemapLayer("chinagray");
		map3 = L.esri.basemapLayer("TianDiTuSat");
		map4 = L.esri.basemapLayer("TianDiTuSat_A");
	//3.天地影像图（esri自定义底图）
	var map5 = L.layerGroup([map3, map4]);//定义图层组
	//WMS方式获取图层
	var boundary = L.tileLayer.wms('http://210.77.68.221:10004/geoserver/heihe/wms?', {
	    	layers: 'boundary',
	    	format: 'image/png',
	    	transparent: true
		});
		//geoJson数据形式获取
		country = L.geoJson(statesData, {
			style: style,
			onEachFeature: onEachFeature
		});
		//L.geoJson(statesData);
			//L.tileLayer.wms('http://210.77.68.214:8080/geoserver/risdss/wms?', {
	        //layers: 'county',
	        //format: 'image/png',
	        //transparent: true
    	//});
		cities = L.tileLayer.wms('http://210.77.68.221:10004/geoserver/heihe/wms?', {
	        layers: 'citys_gws84',
	        format: 'image/png',
	        transparent: true
   	 	});
		river = L.tileLayer.wms('http://210.77.68.221:10004/geoserver/heihe/wms?', {
	        layers: 'river',
	        format: 'image/png',
	        transparent: true
    	});
	var map = L.map('mapid', {
	    center: [40.19, 99.03],//显示中心坐标
	    zoom: 7,//默认显示级别
	    minZoom: 5,//最小显示级别
	    maxZoom: 12,//最大显示级别
	    layers: [map1,country]
	});

/*
	//点击地图获取坐标
	//1
	var popup = L.popup();
	function onMapClick(e) {
	   popup
	        .setLatLng(e.latlng)
	        .setContent("You clicked the map at " + e.latlng.toString())
	        .openOn(map);
	}
	map.on('click', onMapClick);
	//2
	//function onMapClick(e) {
	//    alert("You clicked the map at " + e.latlng);
	//}
	//map.on('click', onMapClick);
*/

		var baseMaps = {
			    "<span style='color: red'>${colormap}</span>": map1,
			    "<span style='color: red'>${graymap}</span>": map2,
			    "<span style='color: red'>${imgmap}</span>": map5
			    
			};
		
		var overlayMaps = {
				"<span style='color: blue'>${boundary}</span>": boundary,
				"<span style='color: blue'>${county}</span>": country,
			    "<span style='color: blue'>${town}</span>": cities,
			    "<span style='color: blue'>${river}</span>": river	   
			};
		
		
		
		//setPosition('topleft')控件定位topleft'地图的左上角'topright'地图的右上角'bottomleft'地图的左下角'bottomright'地图的右下角。
		L.control.layers(baseMaps,overlayMaps).setPosition('topleft').addTo(map);

/*=======================================================================================================*/
		//每个区域添加颜色
		function getColor(d) {
			//console.log("断点1");
			/*if(d==30){
				return '#800026';
			}else if(d==1){
				return '#BD0026';
			}else if(d==6){
				return '#E31A1C';
			}else if(d==13){
				return '#FC4E2A';
			}else if(d==32 || d==37){
				return '#A5A552';
			}else if(d==15){
				return '#FEB24C';
			}else if(d==17){
				return '#00DB00';
			}else if(d==19){
				return '#E1E100';
			}else if(d==20){
				return '#9F0050';
			}else if(d==21){
				return '#0000C6';
			}else if(d==22){
				return '#737300';
			}else if(d==23){
				return '#984B4B';
			}else if(d==28){
				return '#D94600';
			}else if(d==29){
				return '#6FB7B7';
			}else if(d==33){
				return '#02DF82';
			}else if(d==38){
				return '#750075';
			}else if(d==36){
				return '#5B00AE';
			}else if(d==34){
				return '#8C8C00';
			}else{
				return '#FF0000';
			}*/
			if(d==38){
				return '#800026';
			}else if(d==30){
				return '#BD0026';
			}else if(d==22){
				return '#E31A1C';
			}else if(d==25 || d==26 || d==14){
				return '#A5A552';
			}else if(d==17){
				return '#FEB24C';
			}else if(d==23){
				return '#00DB00';
			}else if(d==28){
				return '#E1E100';
			}else if(d==20){
				return '#9F0050';
			}else if(d==29){
				return '#0000C6';
			}else if(d==34){
				return '#737300';
			}else if(d==1){
				return '#984B4B';
			}else{
				return '#FF0000';
			}
		}

		//添加边框样式
		function style(feature) {
			//console.log("断点2");
			return {
				fillColor: getColor(feature.properties.gid),
				weight: 0.5,
				opacity: 1,
				color: 'white',
				dashArray: '3',
				fillOpacity: 0.7
			};
		}

		//添加监听
		function highlightFeature(e) {
			//console.log("断点3");
			var layer = e.target;

			layer.setStyle({
				weight: 5,
				color: '#000000',
				dashArray: '1',
				fillOpacity: 0.7
			});

			if(!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
				layer.bringToFront();
			}
			//info.update(layer.feature.properties);
		}

		function resetHighlight(e) {
			//console.log("断点4");
			country.resetStyle(e.target);
			//info.update();
		}

		function zoomToFeature(e) {
			//console.log("断点5");
			map.fitBounds(e.target.getBounds());
		}

		function onEachFeature(feature, layer) {
			//console.log("断点6");
			layer.on({
				mouseover: highlightFeature,
				mouseout: resetHighlight,
				click: Threeindex
			});
		}

/*=========================================绘制图标============================================*/	
		var content1 = '<div id="marker1" class="echarts"></div>';
		var content2 = '<div id="marker2" class="echarts"></div>';
		var content3 = '<div id="marker3" class="echarts"></div>';
		var content4 = '<div id="marker4" class="echarts"></div>';
		var content5 = '<div id="marker5" class="echarts"></div>';
		var content6 = '<div id="marker6" class="echarts"></div>';
		var content7 = '<div id="marker7" class="echarts"></div>';
		var content8 = '<div id="marker8" class="echarts"></div>';
		var content9 = '<div id="marker9" class="echarts"></div>';
		var content10 = '<div id="marker10" class="echarts"></div>';
		var content11 = '<div id="marker11" class="echarts"></div>';
		var content12 = '<div id="marker12" class="echarts"></div>';
		var content13 = '<div id="marker13" class="echarts"></div>';
		var content14 = '<div id="marker14" class="echarts"></div>';
		var content15 = '<div id="marker15" class="echarts"></div>';
		var content16 = '<div id="marker16" class="echarts"></div>';
		var content17 = '<div id="marker17" class="echarts"></div>';
		var content18 = '<div id="marker18" class="echarts"></div>';
		
		function Threeindex(){
//------------------------------------------------额济纳旗---------------------------------------------------
	    	$.get("getEvallevel.do",
	                {"year":document.getElementById('yearid').value},function(data){
	                	console.log(data);
	                	//console.log("断点8");
	    				country.eachLayer(function (layer) {
	    					if(layer.feature.properties.Name_CN=="额济纳旗"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content1,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${ejinaqi}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${ejinaqi}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker1'));
	    							   option = {
	    									   title: { 
	    										   text:"${ejinaqi}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[0].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[0].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[0].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[0].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}',
	    			    						                		}
	    			    						                    }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//----------------------------------------------嘉峪关市------------------------------------------------
	    					}else if(layer.feature.properties.Name_CN=="嘉峪关市"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content2,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${jiayuguan}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${jiayuguan}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker2'));
	    							   option = {
	    									   title: { 
	    										   text:"${jiayuguan}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[1].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[1].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[1].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[1].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//----------------------------------甘州区----------------------------------------------
	    					} else if(layer.feature.properties.Name_CN=="甘州区"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content3,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${ganzhou}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${ganzhou}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker3'));
	    							   option = {
	    									   title: { 
	    										   text:"${ganzhou}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[2].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[2].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[2].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[2].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//------------------------------------------肃南县-----------------------------------------
	    					}else if(layer.feature.properties.Name_CN=="肃南裕固族自治县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content4,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${sunan}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${sunan}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker4'));
	    							   option = {
	    									   title: { 
	    										   text:"${sunan}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[3].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[3].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[3].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[3].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//-------------------------------------------民乐县---------------------------------------
	    					} else if(layer.feature.properties.Name_CN=="民乐县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content5,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${minle}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${minle}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker5'));
	    							   option = {
	    									   title: { 
	    										   text:"${minle}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[4].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[4].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[4].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[4].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
	//---------------------------------------临泽县--------------------------------
	    					} else if(layer.feature.properties.Name_CN=="临泽县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content6,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${linze}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${linze}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker6'));
	    							   option = {
	    									   title: { 
	    										   text:"${linze}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[5].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[5].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[5].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[5].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
	 //-----------------------------高台县-------------------------------------------------
	    					} else if(layer.feature.properties.Name_CN=="高台县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content7,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${gaotai}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${gaotai}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker7'));
	    							   option = {
	    									   title: { 
	    										   text:"${gaotai}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[6].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[6].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[6].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[6].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//-------------------------------山丹县---------------------------------
	    					} else if(layer.feature.properties.Name_CN=="山丹县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content8,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${shandan}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${shandan}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker8'));
	    							   option = {
	    									   title: { 
	    										   text:"${shandan}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[7].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[7].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[7].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[7].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
	  ///------------------------------------肃州区----------------------------------
	    					} else if(layer.feature.properties.Name_CN=="肃州区"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content9,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${suzhou}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${suzhou}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker9'));
	    							   option = {
	    									   title: { 
	    										   text:"${suzhou}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[8].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[8].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[8].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[8].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
	    //--------------------------金塔县-----------------------------------
	    					} else if(layer.feature.properties.Name_CN=="金塔县"){   
	    						//console.log("${ejinaqi}");
	    						layer.bindPopup(content10,{});
	    						   layer.on('popupopen', function(e) {
	    							   
	    							   document.getElementById("bottom-panel").style.cssText = "height:220px;width:84vw;";
	    							   document.getElementById("social_ratio_place").innerHTML = "${jinta}"+document.getElementById("indexid").value;
	    							   document.getElementById("social_change_place").innerHTML = "${jinta}"+"${findex}";
	    							   //三个指标柱状图
	    							   var myChart = echarts.init(document.getElementById('marker10'));
	    							   option = {
	    									   title: { 
	    										   text:"${jinta}"
	    									   },
	    									   grid:{
	    						                    x:25,
	    						                    y:45,
	    						                    x2:5,
	    						                    y2:20
	    						                },
	    									   tooltip: {
	    						                    trigger: 'axis'
	    						                },
	    						                
	    						                xAxis: [{
	    						                    type: 'category',
	    						                    data: ['${level}']
	    						                }],
	    						                yAxis: [{
	    						                    type: 'value',
	    						                    min: 0,
	    						                    max: 5,
	    						                    interval: 0.5,
	    						                    axisLabel: {
	    						                        formatter: '{value}'
	    						                    }
	    						                }],
	    						                series: [{
	    						                    name: '${index1}',
	    						                    type: 'bar',
	    						                    data: [data[9].totalscore]
	    						                }, {
	    						                    name: '${index2}',
	    						                    type: 'bar',
	    						                    data: [data[9].goal1score]
	    						                }, {
	    						                    name: '${index3}',
	    						                    type: 'bar',
	    						                    data: [data[9].goal2score]
	    						                },{
	    						                    name: '${index4}',
	    						                    type: 'bar',
	    						                    data: [data[9].goal3score]
	    						                }]
	    						            };
	    							   myChart.setOption(option);
	    							   
	    							   //底部左侧
	    							   $.get("getleftdata.do",
	    						                {"projectId":"${projectId}",
	    						                 "countyId":layer.feature.properties.Admin_Code
	    						                 },function(data){
	    						    				 console.log(data);
	    						    				var leftChart = echarts.init(document.getElementById('leftechart-social'));
	    						    				var yeardata=[], valuedata=[];
	    						    				for(var i=0;i<data.length;i++){
	    						                        yeardata[i]=data[i].year;
	    						                        if(document.getElementById('indexid').value == "人均GDP" || 
	    						                        		document.getElementById('indexid').value == "GDP per capita"){
	    						                        	valuedata[i]=data[i].gdpPerCapita;
	    						                        }else if(document.getElementById('indexid').value == "水生产力" || 
	    						                        		document.getElementById('indexid').value == "Water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivity;
	    						                        }else if(document.getElementById('indexid').value == "水压力" || 
	    						                        		document.getElementById('indexid').value == "Water stress"){
	    						                        	valuedata[i]=data[i].waterPressure;
	    						                        }else if(document.getElementById('indexid').value == "安全饮用水比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of safe water"){
	    						                        	valuedata[i]=data[i].safeDrinkingWaterR;
	    						                        }else if(document.getElementById('indexid').value == "水资源管理执行度" || 
	    						                        		document.getElementById('indexid').value == "Degree of water management"){
	    						                        	valuedata[i]=data[i].iwrmR;
	    						                        }else if(document.getElementById('indexid').value == "可操作合约有效性" || 
	    						                        		document.getElementById('indexid').value == "Availability of water agreement"){
	    						                        	valuedata[i]=data[i].transboundaryAvailability;
	    						                        }else if(document.getElementById('indexid').value == "可持续湿地面积" || 
	    						                        		document.getElementById('indexid').value == "Sustainable wetland"){
	    						                        	valuedata[i]=data[i].areaWetland;
	    						                        }else if(document.getElementById('indexid').value == "下游可持续发展最小需水量" || 
	    						                        		document.getElementById('indexid').value == "Min water sustains development of downstream"){
	    						                        	valuedata[i]=data[i].waterDemandEco;
	    						                        }else if(document.getElementById('indexid').value == "中游地下水开采量" || 
	    						                        		document.getElementById('indexid').value == "Groundwater extract of mid-reaches"){
	    						                        	valuedata[i]=data[i].groundwaterMining;
	    						                        }else if(document.getElementById('indexid').value == "中游生态系统用水量" || 
	    						                        		document.getElementById('indexid').value == "Water consumption in the middle reaches ecosystem"){
	    						                        	valuedata[i]=data[i].waterUseEco;
	    						                        }else if(document.getElementById('indexid').value == "森林覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of forest cover"){
	    						                        	valuedata[i]=data[i].forestCoverR;
	    						                        }else if(document.getElementById('indexid').value == "可持续森林管理覆盖率" || 
	    						                        		document.getElementById('indexid').value == "Percentage of sustainable forest cover"){
	    						                        	valuedata[i]=data[i].forestSustainableR;
	    						                        }else if(document.getElementById('indexid').value == "山地绿色覆盖指数" || 
	    						                        		document.getElementById('indexid').value == "Mountain green index"){
	    						                        	valuedata[i]=data[i].mountainGreenCoverR;
	    						                        }else if(document.getElementById('indexid').value == "就业人口人均GDP" || 
	    						                        		document.getElementById('indexid').value == "Per capita GDP of employed population"){
	    						                        	valuedata[i]=data[i].gdpPerCapitaEmployed;
	    						                        }else if(document.getElementById('indexid').value == "教育就业培训的年轻人比例" || 
	    						                        		document.getElementById('indexid').value == "Rate of young people accepting vocational training"){
	    						                        	valuedata[i]=data[i].youthEmpR;
	    						                        }else if(document.getElementById('indexid').value == "旅游业在GDP中的比例" || 
	    						                        		document.getElementById('indexid').value == "Proportion of tourism in GDP"){
	    						                        	valuedata[i]=data[i].gdpTourismR;
	    						                        }else if(document.getElementById('indexid').value == "土地消耗率" || 
	    						                        		document.getElementById('indexid').value == "Rate of land consumption"){
	    						                        	valuedata[i]=data[i].landPopuR;
	    						                        }else if(document.getElementById('indexid').value == "城镇化率" || 
	    						                        		document.getElementById('indexid').value == "Urbanization rate"){
	    						                        	valuedata[i]=data[i].urbanR;
	    						                        }else if(document.getElementById('indexid').value == "可持续社会福利指数" || 
	    						                        		document.getElementById('indexid').value == "Sustainable society welfare index"){
	    						                        	valuedata[i]=data[i].avgWelfare;
	    						                        }else if(document.getElementById('indexid').value == "农业水生产力" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water productivity"){
	    						                        	valuedata[i]=data[i].waterProductivityAgri;
	    						                        }else if(document.getElementById('indexid').value == "农业水利用率" || 
	    						                        		document.getElementById('indexid').value == "Agricultural water use efficiency"){
	    						                        	valuedata[i]=data[i].waterUseEffiAgri;
	    						                        }else if(document.getElementById('indexid').value == "每公顷农产品产值" || 
	    						                        		document.getElementById('indexid').value == "Crop production per hectare"){
	    						                        	valuedata[i]=data[i].agriOutputPerHectare;
	    						                        }else{
	    						                        	valuedata[i]=data[i].areaCrop;
	    						                        }
	    						                        
	    						                    }
	    						    				 
	    						    				leftoption = 
	    						    						{
	    			    									   grid:{
	    			    						                    top:'40px',
	    						    								right:'40px',
	    						    								left:'20px',
	    						    								bottom:'20px',
	    						    								containLabel:true
	    			    						                },
	    			    						               legend: {
	    			    						    		        data:[document.getElementById('indexid').value],
	    			    						    		        x:'center',
	    			    						    		        y:'5%',     
	    			    						    		   }, 
	    			    						    		   toolbox: {
	    			    						    			   x:'right',
	    			    						    			   show:true,
	    			    						    		       feature: {
	    			    						    		            magicType : {show: true, type: ['line', 'bar']},
	    			    						    		    	   	restore: {show : true},
	    			    						    		            saveAsImage: {show:true}
	    			    						    		       }
	    			    						    		   },
	    			    									   tooltip: {
	    			    						                    trigger: 'axis',
	    			    						                    axisPointer:{
	    			    						                    	type:'cross'
	    			    						                    }
	    			    						                },
	    			    						                calculable : true,
	    			    						                xAxis: [{
	    			    						                	name: '${year}',
	    			    						                    type: 'category',
	    			    						                    data: yeardata,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel:{
	    			    						                    	interval: 0
	    						    					            },
	    			    						                    axisTick: {
		    											                alignWithLabel: true,
		    											                interval:0
		    											            }
	    			    						                }],
	    			    						                yAxis: [{
	    			    						                	name: '${indexnum}',
	    			    						                    type: 'value',
	    			    						                    max:'dataMax',
	    			    						                    min: 'dataMin',
	    			    						                    //min: 0,
	    			    						                    //interval: 50,
	    			    						                    axisLine:{
	    			    						                    	lineStyle:{
	    			    						                    		width:'2'
	    			    						                    	}
	    			    						                    },
	    			    						                    axisLabel: {
	    			    						                        formatter: '{value}'
	    			    						                    }
	    			    						                }],
	    			    						                dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								//start : 0,
	    						    								//end : 100,
	    						    								//height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    		},
	    			    						                series: [{
	    			    						                    name: document.getElementById('indexid').value,
	    			    						                    type: 'line',
	    			    						                    symbolSize: 8,
	    			    						                    
	    			    						                    itemStyle : {  
	    			    						                        normal : {  
	    			    						                            lineStyle:{  
	    			    						                            	width:5
	    			    						                            }  
	    			    						                        }  
	    			    						                    },   
	    			    						                    data: valuedata
	    			    						                }],  
	    			    						            };
	    			    							   leftChart.setOption(leftoption);		
	    						    		});
	    							   		console.log("=="+document.getElementById('yearid').value);
	    							   		//底部右侧					
									    	$.get("leafletD.do",
									                {"name":layer.feature.properties.Name_CN,
									    			 "year":document.getElementById('yearid').value},function(data){
									    			//console.log("===="+document.getElementById('yearid').value);
	    						    				var leftChart = echarts.init(document.getElementById('rightechart-social'));
	    						    				
	    						    				leftoption = 
	    						    					{
	    						    						tooltip : {
	    						    							trigger : 'item',
	    						    							formatter:'{b}'
	    						    							
	    						    						},
	    						    						grid:{
	    						    							top:'40px',
    						    								right:'40px',
    						    								left:'20px',
    						    								bottom:'20px',
    						    								containLabel:true
	    			    						            },
	    						    						toolbox : {
	    						    							show : true,
	    						    							feature : {
	    						    								restore : {
	    						    									show : true
	    						    								},
	    						    								saveAsImage : {
	    						    									show : true
	    						    								}
	    						    							}
	    						    						},
	    						    						calculable : true,
	    						    						xAxis : [{
	    						    								type : 'category',
	    						    								axisLabel:{
	    						    									interval: 0,
	    						    									fontSize: 10,
	    						    					            },
	    						    								data : ['${right1}',
	       			    						                    	'${right2}',
	       			    						                    	'${right3}',
	       			    						                    	'${right4}',
	       			    						                    	'${right5}',
	       			    						                    	'${right6}',
	       			    						                    	'${right7}',
	       			    						                    	'${right8}',
	       			    						                    	'${right9}'].map(function (str) {
	       			    						                         return str.replace(' ', '\n')
	       			    						                     })
	    						    							}
	    						    						],
	    						    						yAxis : [{
	    						    								show:false,
	    						    								type : 'value',
	    						    							}
	    						    						],
	    						    						dataZoom : {
	    						    							 	show : true,
	    						    								realtime : true,
	    						    								start : 0,
	    						    								end : 100,
	    						    								height:20,
	    						    								bottom:'0px',
	    						    								handleStyle:{
	    						    									color:'#191970',
	    						    									borderWidth:5
	    						    								}
	    						    								
	    						    				    	},
	    						    						series : [{
	    						    							     type:'bar',
	    						    								 data:[data[0].aq/12,data[0].eq/1.0,data[0].mgwd/5.2,data[0].gdp/26,data[0].iagdp/5,data[0].mia/560,data[0].pop/87,data[0].dfa/87,data[0].dla/32],
	    						    								 barWidth: 25, 
	    						    								 itemStyle:{
	    						    									 normal:{
	    						    										 color:'#4169E1' 
	    						    									 }
	    						    								 },
	    						    								 label:{
	    						    									 normal:{
	    						    										 show:true,
							    											 position:'top',
							    											 formatter: function(params){
							    												    if(params.value==data[0].aq/12){
							    							                            return data[0].aq+'/12';
							    							                        }else if(params.value==data[0].eq/1.0){
							    							                            return data[0].eq+'/1';
							    							                        }else if(params.value==data[0].mgwd/5.2){
							    							                            return data[0].mgwd+'/5.2';
							    							                        }else if(params.value==data[0].gdp/26){
							    							                            return data[0].gdp+'/26';
							    							                        }else if(params.value==data[0].iagdp/5){
							    							                            return data[0].iagdp+'/5';
							    							                        }else if(params.value==data[0].mia/560){
							    							                            return data[0].mia+'/560';
							    							                        }else if(params.value==data[0].pop/87){
							    							                            return data[0].pop+'/87';
							    							                        }else if(params.value==data[0].dfa/87){
							    							                            return data[0].dfa+'/87';
							    							                        }else{
							    							                        	return data[0].dla+'/32';
							    							                        }
							    												},
							    											 color:'#B22222'
	    						    									 }	 
						    										 },
			    						    						 markLine : {
			    						    				                data: [{type : '100%>100%', 
			    						    				                     yAxis: 1
			    						    				                     }],
			    						    				                lineStyle: {
			    						    				                	normal:{
			    						    				                		color:'#B22222'
			    						    				                	}
			    						    				                }
			    						    				         }
	    						    						}]
	    						    					},
	    			    							   leftChart.setOption(leftoption);
	    						    				
	    						    		});
	    							   
	    						   	   }); 
//-------------------------------祁连县------------------------------------------------
	    					}
	    					
	    				});
	    	});
	    };
	    
/*=======================================================评价指标选框=================================*/	
		//console.log("获取评价指标");
		var index = L.control();
		index.onAdd = function(map) {
			this._div = L.DomUtil.create('div', 'index'); // create a div with a class "info"
			this.update();
			return this._div;
		};

		index.update = function(props) {
			this._div.innerHTML = '<a>${evaindex}</a>'+
				'<select id="indexid">'+
			'</select>';
		};		
		index.setPosition('topleft').addTo(map);
		
		if("${Language}" == "chinese"){
			$.get("indexTypeCH.do",
	                [],function(data){			
						for (var i = 0; i < data.length; i++) {	
							if(data[i]=="人均GDP"){
								$("#indexid").append("<option selected='selected' value='"+ data[i] + "'>" + data[i] + "</option>");
							}else{	
								$("#indexid").append("<option value='"+ data[i] + "'>" + data[i] + "</option>");
							}
						}
			});	
		}else{
			$.get("indexTypeEN.do",
	                [],function(data){			
						for (var i = 0; i < data.length; i++) {	
							if(data[i]=="GDP per capita"){
								$("#indexid").append("<option selected='selected' value='"+ data[i] + "'>" + data[i] + "</option>");
							}else{	
								$("#indexid").append("<option value='"+ data[i] + "'>" + data[i] + "</option>");
							}
						}
			});	
		}
		
		
		
/*=======================================================年份选框=================================*/			
			
			
			//console.log("获取年份");
			var year = L.control();
			year.onAdd = function(map) {
				this._div = L.DomUtil.create('div', 'year'); // create a div with a class "info"
				this.update();
				return this._div;
			};	
			//method that we will use to update the control based on feature properties passed
			year.update = function(props) {
				this._div.innerHTML = '<a>${year}</a>'+
					'<select id="yearid">'+
				'</select>';
			};		
			year.setPosition('topleft').addTo(map);
			
			$.ajax({
			    type: "get",
			    url: "getyears.do",
				data: {
					<#--  "projectId" :"${projectId}"  -->
				},
			    async:false,
			    success: function(data){
			    	if(data){
			    		console.log(data);
			    		var programme_sel = [];
			    		//programme_sel.push('<option value =""selected>请选择</ option>');
			    			
			    		for(var i=0;i<data.length;i++){
			    			
			    			programme_sel.push('<option value ="'+data[i]+'">'+data[i]+'</option>');
			    		}
			    		$("#yearid").html(programme_sel.join(' '));
			    	}else{
			    		alert("error!查询错误");
			    	}
			    }
	     });	
		
/*===========================================图例=============================================*/			
		var legend = L.control();
		legend.onAdd = function(map) {
			this._div = L.DomUtil.create('div', 'legend'); // create a div with a class "info"
			this.update();
			return this._div;
		};

		//method that we will use to update the control based on feature properties passed
		//legend.update = function(props) {
		//	this._div.innerHTML = '<div><img src="image/legend1.png"></div>'
			//'<div id="leg"><div style="width:20px;height:20px;background-color:#808080"></div><a style="font-size: 10px;">流域边界</a></div>'+
			//'<div id="leg1"><div style="width:40px;height:15px;background-color:#B22222"></div><a style="font-size: 10px;">生态指标</a><div style="width:40px;height:15px;background-color:#2F4F4F"></div><a style="font-size: 10px;">社会经济指标</a><div style="width:40px;height:15px;background-color:#20B2AA"></div><a style="font-size: 10px;">水管理指标</a></div>'+
			//'<div id="leg2"><div style="width:10px;height:10px;background-color:red"></div><a style="font-size: 10px;">城镇</a></div>'+
			//'<div id="leg3"><div style="width:50px;height:2px;background-color:#4B0082"></div><a style="font-size: 10px;">水系</a></div>';
		//};		
		//legend.setPosition('bottomleft').addTo(map);
		
/*========================================面板================================================*/
 		var Panel = L.control();
 		Panel.onAdd = function(map) {
			this._div = L.DomUtil.create('div', 'Panel'); // create a div with a class "info"
			this.update();
			return this._div;
		};
//'<div><img src="gis/image/legend.png"></div>'+
		//method that we will use to update the control based on feature properties passed
		Panel.update = function(props) {
			if("${Language}"=="chinese"){
				this._div.innerHTML =
					<#--  '<div><img src="gis/image/tuliz.png"></div>'+  -->
					'<div class="BottomPanel" id="bottom-panel" style="height:220px;width:84vw;display:none"  data-bind = "basicinfoGDPPanelInit">'+
						'<div style="background-color:white" align="right"><img class="button-img" src="gis/image/close.png" style="width: 10px;height: 10px;"/></div>'+
						'<div class = "panel-div"style="height:210px;width:100%;background-color:white">'+
							'<div id="leftechart-gdp" class="col-xs-6" style="border-right:2px dashed #483D8B;height:100%;">'+
								'<div class="basicinfo-bottomtitle" style="position:relative;top:4px">'+
								 	'<a id="social_ratio_place">黑河流域</a>'+
						    	'</div>'+
						    	'<div id="leftechart-social" class="basicinfo-bottom-panelleft-chart"></div>'+
							'</div>'+
							'<div  id="rightechart-gdp" class="col-xs-6" style="height:100%;">'+
								'<div class="basicinfo-bottomtitle" style="position:relative;top:4px">'+
									 '<a id="social_change_place">流域可持续发展指标</a>'+
							     '</div>'+
							     '<div id="rightechart-social" class="basicinfo-bottom-panelright-chart"></div>'+
							'</div>'+
						'</div>'+
					'</div>'
			}else{
				this._div.innerHTML =
					'<div><img src="gis/image/tulienglish.png"></div>'+
					'<div class="BottomPanel" id="bottom-panel" style="height:220px;width:84vw;display:none"  data-bind = "basicinfoGDPPanelInit">'+
						'<div style="background-color:white" align="right"><img class="button-img" src="gis/image/close.png" style="width: 10px;height: 10px;"/></div>'+
						'<div class = "panel-div"style="height:210px;width:100%;background-color:white">'+
							'<div id="leftechart-gdp" class="col-xs-6" style="border-right:2px dashed #483D8B;height:100%;">'+
								'<div class="basicinfo-bottomtitle" style="position:relative;top:4px">'+
								 	'<a id="social_ratio_place">黑河流域</a>'+
						    	'</div>'+
						    	'<div id="leftechart-social" class="basicinfo-bottom-panelleft-chart"></div>'+
							'</div>'+
							'<div  id="rightechart-gdp" class="col-xs-6" style="height:100%;">'+
								'<div class="basicinfo-bottomtitle" style="position:relative;top:4px">'+
									 '<a id="social_change_place">流域可持续发展指标</a>'+
							     '</div>'+
							     '<div id="rightechart-social" class="basicinfo-bottom-panelright-chart"></div>'+
							'</div>'+
						'</div>'+
					'</div>'
			}
			
		};		
		Panel.setPosition('bottomleft').addTo(map);

		
		$(document).ready(function(){
			  $(".button-img").click(function(){
			    $(".BottomPanel").slideUp("slow");
			  });
			});
		
		
		
</script>
</body>
</html>