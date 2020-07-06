<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=9">
	<meta http-equiv="X-UA-Compatible" content="IE=10">
	<meta http-equiv="X-UA-Compatible" content="IE=11">
    <title>流域可持续发展决策支持系统</title>
    <meta name="description" content="overview & stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <#--  <link rel="stylesheet" href="gis/css/bootstrap.min.css"/>  -->
    <#--  <link rel="stylesheet" href="gis/css/bootstrap-responsive.min.css"/>  -->
    <link rel="stylesheet" href="gis/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="gis/css/jquery-ui-1.10.2.custom.min.css"/>
    <link rel="stylesheet" href="gis/css/ace.min.css"/>
    <link rel="stylesheet" href="gis/css/canvasXpress.css" type="text/css"/>

    <!--[if lt IE 9]><script type="text/javascript" src="./js/flashcanvas.js"></script><![endif]-->
    <script type="text/javascript" src="gis/js/canvasXpress.min.js"></script>
    <script type="text/javascript" src="gis/js/jquery.min.js"></script>
    <script type="text/javascript" src="gis/js/jquery-ui-1.10.2.custom.min.js"></script>
    <script type="text/javascript" src="gis/js/echarts-all.js"></script>
    <script src="static/js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  	<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  	<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  	<link rel="stylesheet" href="jqueryui/style.css">
    <style type="text/css">
        #gis_page {overflow: hidden; position: relative; width: 100%;height: 100%;}
        #gis_page #mapframe{width:100%; border: 0;height: 100%;}
        #gis_page #right_flash,#right_flash2{width: 433px; height: auto; position: absolute; right: -400px; top: 6%; margin-top: 0;}
        #gis_page .situation-toggle{font-size: 14px; text-align:left; position: absolute; left: 0px;top: 0px;z-index: 110;}
        #gis_page .situation{width:400px; position: relative; right:-33px; top:0px; z-index:10;}
        #gis_page #right_flash2{right: -600px; margin-top: 100px; height: 300px; z-index: 20; width: 633px;}
        <#--  #gis_page #right_flash2.down{margin-top: 278px;}  -->
        #gis_page .widget-body{border-top: 1px solid #CCCCCC;}
        #gis_page .widget-header {
            margin: 0;
        }
        #gis_page .widget-box {
            margin: 0;
        }
    </style>
</head>

<body><!-- onload="showDemo();" -->
<div id="gis_page">
<iframe id="mapframe" src="mapgis.do" scrolling="no"></iframe>
<div id="right_flash">
    <div class="widget-header situation-toggle" id="situation-toggle1" style="cursor: pointer; font-family: '微软雅黑';">
        	<p style="writing-mode : tb-rl;">${scecon}</p><br />
    </div>
    <#--  <button type="button" id="situation-toggle1" class="btn btn-primary" style="cursor: pointer; font-family: '微软雅黑';">${scecon}</button>  -->
    <div id="situation1" class="widget-box situation">
        <div class="widget-body">
            <div class="widget-main">
            	<p>
				  <label for="amount">下游分水系数</label>
				  <input type="text" id="amount" value="8" style="border:0; color:#f6931f; font-weight:bold;" >
				</p>
				<#--  <div id="slider-range-max"></div>  -->
                <input id="slider-range-max" class="easyui-slider" value="8"  style="width:374px" data-options="showTip:false, rule:[8,'|',9,'|',10,'|',11], min:8, max:11, step:1">
                <#--  <div id="slider"></div>  -->
                <!-- <div class="row-fluid">
                    	${up}：
                    <input type="text" id="situation-1" value="${value1}" style="width:30px;height:10px">${wanmu}
                    <div id="slider-1" style="float:right;display:inline;"></div>
                    <hr style="margin:0px;height:4px">
                </div>
                <div class="row-fluid">
                    <span style="visibility:hidden">${zxwater}：</span> ${zhong}&nbsp;${xia}
                </div>
                <div class="row-fluid">
                    	${zxwater}：
                    <input type="text" id="situation-2-1" value="${value6}" style="width:25px;height:10px">
                    <input type="text" id="situation-2-2" value="${value7}" style="width:25px;height:10px">${yilifang}
                    <div id="slider-2" style="float:right;display:inline;"></div>
                </div>
                <div class="row-fluid">
                    	${mid}：
                    <input type="text" id="situation-3" value="${value2}" style="width:30px;height:10px">${wanmu}
                    <div id="slider-3" style="float:right;display:inline;"></div>
                </div>
                <div class="row-fluid">
                    	${mids}：
                    <input type="text" id="situation-4" value="${value3}" style="width:30px;height:10px">${wanmu}
                    <div id="slider-4" style="float:right;display:inline;"></div>
                </div>
                <div class="row-fluid">
                    	${midd}：
                    <input type="text" id="situation-5" value="${value4}" style="width:30px;height:10px">${wanmu}
                    <div id="slider-5" style="float:right;display:inline;"></div>
                    <hr style="margin:0px;height:4px">
                </div>
                <div class="row-fluid">
                    	${down}：
                    <input type="text" id="situation-6" value="${value5}" style="width:30px;height:10px">${wanmu}
                    <div id="slider-6" style="float:right;display:inline;"></div>
                    <hr style="margin:0px;height:4px">
                </div> -->
                <div class="row-fluid" style="text-align:center;margin: 20px 0 0 0;">
                    <button class="btn btn-mini btn-success" type="button" id="btn_eval">${EA}</button>
                </div>

            </div>
        </div>
    </div>
</div>

<div id="right_flash2" style="top:12%">
    <div class="widget-header situation-toggle" id="situation-toggle2" style="cursor: pointer; font-family: '微软雅黑';">
        	<p style="writing-mode : tb-rl;">${result}</p><br /><
    </div>
    <div id="situation2" class="widget-box situation" style="width: 600px;">
        <div class="widget-body">
        <select id="select_score" class="admin-select" style="height: auto;">
			<option value="0">${index1}</option>
			<option value="1">${index2}</option>
			<option value="2">${index3}</option>
			<option value="3">${index4}</option>
		</select>
        <!-- 
        	<button id="switch" class="btn btn-info" style="border: 3px;padding: 0 8px;margin-bottom: -10px;z-index: 9999;">切换视图</button>-->
        	<button id="downexcel"  onclick="window.location.href= 'downexcel1.do'">${downresult}</button>
        <!-- <button id="downpdf" class="btn btn-info" style="border: 3px;padding: 0 8px;margin-bottom: -10px;z-index: 9999;" onclick="window.location.href= 'downPDF.do'">下载评价结果</button>
         -->
            <div id="echarts" class="widget-main" style="margin-top: -12px;">
            	
            	<div id="gis-chart-1" style="width:100%; height: 300px;"></div>
            </div>
            <div id="scatter" class="widget-main" style="display: none; height: 338px; padding: 0;margin-top: -22px;">
            	<canvas id='canvas2' width='600' height='340'></canvas>
            </div>
        </div>
    </div>
</div>
</div>
<!-- 情景控制slider模块显示及控制 -->
<script type="text/javascript">
    console.log('abcdefghi')
	$("#select_score").on("click", function() {
		getdatayear();
	});
    $(function () {
    	//drawchart();
    	//console.log(getdata());
    	getdatayear();
    	
        $("#mapframe").attr("height", $(window).height());
        <#--  $("#slider-1").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value1},
            range: "min",
            min: 0,
            max: 500,
            step: 1,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-1").val(val);
            }
        });

        $("#slider-2").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value6},
            range: "min",
            min: 0,
            max: 500,
            step: 1,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-2-1").val(val);
                $("#situation-2-2").val(500 - val);
            }
        });

        $("#slider-3").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value2},
            range: "min",
            min: 0,
            max: 500,
            step: 10,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-3").val(val);
            }
        });

        $("#slider-4").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value3},
            range: "min",
            min: 0,
            max: 500,
            step: 1,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-4").val(val);
            }
        });

        $("#slider-5").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value4},
            range: "min",
            min: 0,
            max: 500,
            step: 5,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-5").val(val);
            }
        });

        $("#slider-6").css({
            width: '42%',
            margin: '5px 5px 15px 5px'
        }).slider({
            value: ${value5},
            range: "min",
            min: 0,
            max: 500,
            step: 5,
            slide: function (event, ui) {
                var val = parseInt(ui.value);
                $("#situation-6").val(val);
            }
        });  -->

    });
    
    /*$("#btn_eval").on("click",function(){
		
		$.post("startAssessTest.do", 
			{projectId:"${projectId}"},
				//function(indistr) {
			function(data){
			alert(data.content);
			
			//alert(indistr);
			//window.location.href='gis.do';
		});
		
	});
    //绑定btn_eval按钮的点击事件
    
    $("#btn_eval").bind("click", function () {
        //使用ajax将数据发送到服务端
        $.get("stuationControl.do",{
        	 "upstreamCultivatedArea":document.getElementById("situation-1").value,
        	 "midstreamWater":document.getElementById("situation-2-1").value,
 			 "downstreamWater":document.getElementById("situation-2-1").value,
 			 "midStreamCultivatedArea":document.getElementById("situation-3").value,
 			 "midStreamWetLandArea":document.getElementById("situation-4").value,
 			 "midStreamDripIrrigation":document.getElementById("situation-5").value,
 			 "downStreamCultivatedArea":document.getElementById("situation-6").value
        },function(data){
        	if(data.success){
        		location.href = "jumpToAbstract.do";
        	}else{
        		alert(data.content);
        	}
        	
        	
        });

    });*/

    /*最右测滑入滑出*/
    var clicknum1 = false,
        clicknum2 = false;
    console.log('$("#situation-toggle1")')
    console.log($("#situation-toggle1"))
    $("#situation-toggle1").click(function () {
        if(!clicknum2){
            if(!clicknum1){
                $("#right_flash").animate({right: "0"});
                $("#right_flash2").addClass("down");
                $(this).html('<p style="writing-mode: tb-rl; ">${scecon}</p><br />>')
            }else {
                $("#right_flash").animate({right: "-400px"});
                $(this).html('<p style="writing-mode: tb-rl;">${scecon}</p><br /><')
                $("#right_flash2").removeClass("down");
            }
        }else{
            $("#right_flash2").animate({right: "-600px"}).addClass("down");
            $("#situation-toggle2").html('<p style="writing-mode : tb-rl;">${result}</p><br /><')
            $("#right_flash").animate({right: "0"});
            $(this).html('<p style="writing-mode : tb-rl;">${scecon}</p><br />>')
            
            clicknum2 = !clicknum2;
        }
        clicknum1 = !clicknum1;
        //console.log(clicknum1+"///"+clicknum2);
    });
    $("#situation-toggle2").click(function () {
        if(!clicknum1){
            if(!clicknum2){
                $("#right_flash2").animate({right: "0px"});
                $(this).html('<p style="writing-mode : tb-rl;">${result}</p><br />>')
            }else {
                $("#right_flash2").animate({right: "-600px"});
                $(this).html('<p style="writing-mode : tb-rl;">${result}</p><br /><')
            }
        }else{
            $("#right_flash").animate({right: "-400px"});
            $("#situation-toggle1").html('<p style="writing-mode : tb-rl;">${scecon}</p><br /><')
            $("#right_flash2").animate({right: "0px"}).removeClass("down");
            $(this).html('<p style="writing-mode : tb-rl;">${result}</p><br />>');
            clicknum1 = !clicknum1;
        }
        clicknum2 = !clicknum2;
        //console.log(clicknum1+"///"+clicknum2);
    });
    //根据年份获取数据
    function getdata(){
    	 var array = new Array();
         $.ajax({
 		    type: "get",
 		    url: "getyears.do",
 		    data: {
                 <#--  "projectId" :"${projectId}"  -->
            },
 		    //dataType:"json",
 		    async:false,
 		    success: function(data){
 		    	for(var i=0;i<data.length;i++){
 	    			//array[i]=new Array(data[i]);
 	    			//console.log("年份"+data[i]);
 	    			$.ajax({
 	    	    	    type: "get",
 	    	    	    url: "getGisEcharts.do",
 	    	    	    data: {
                             <#--  "projectId" :"${projectId}",  -->
                             "year":data[i]},
 	    	    	    //dataType:"json",
 	    	    	    async:false,
 	    	    	    success: function(data){
 	    	    	    	array[i]=data;
 	    	    		}
 	    	        })
 	    		}
 		    }
         });
         return array;
    }
    //console.log(getdata());
    //选择从新加载
    $("#select_score").on("change",function(){
    	getdatayear();
	});
    
    function toDecimal(x) { 
		   var f = parseFloat(x); 
		   if (isNaN(f)) { 
		    return; 
		   } 
		   f = Math.round(x*100)/100; 
		   return f; 
		  } 
    function getdatayear(){
    	var myChart = echarts.init(document.getElementById('gis-chart-1'));
    	var array = new Array();
    	array = getdata();
    	var array1 = new Array();
    	var array2 = new Array();
    	var array3 = new Array();
    	var array4 = new Array();
    	var array5 = new Array();
    	var array6 = new Array();
    	var array7 = new Array();
    	var array8 = new Array();
    	var array9 = new Array();
    	var array10 = new Array();
    	for(var i=0;i<array.length;i++){
    		array1[i] = array[i][0];
    		array2[i] = array[i][1];
    		array3[i] = array[i][2];
    		array4[i] = array[i][3];
    		array5[i] = array[i][4];
    		array6[i] = array[i][5];
    		array7[i] = array[i][6];
    		array8[i] = array[i][7];
    		array9[i] = array[i][8];
    		array10[i] = array[i][9];
    	}
    	/*
    	console.log(array1);
    	console.log(array2);
    	console.log(array3);
    	console.log(array4);
    	console.log(array5);
    	console.log(array6);
    	console.log(array7);
    	console.log(array8);
    	console.log(array9);
    	console.log(array10);
    	*/
    	var arrayear1 = new Array();
    	var arrayear2 = new Array();
    	var arrayear3= new Array();
    	var arrayear4 = new Array();
    	var arrayear5 = new Array();
    	var arrayear6 = new Array();
    	var arrayear7 = new Array();
    	var arrayear8 = new Array();
    	var arrayear9 = new Array();
    	var arrayear10 = new Array();
    	var year = new Array();
    	if(document.getElementById('select_score').value==0){
    		console.log(array1.length);
    	    console.log(array1);
    		for(var j=0;j<array1.length;j++){
        		arrayear1[j]=toDecimal(array1[j].totalindex);
        		arrayear2[j]=toDecimal(array2[j].totalindex);
        		arrayear3[j]=toDecimal(array3[j].totalindex);
        		arrayear4[j]=toDecimal(array4[j].totalindex);
        		arrayear5[j]=toDecimal(array5[j].totalindex);
        		arrayear6[j]=toDecimal(array6[j].totalindex);
        		arrayear7[j]=toDecimal(array7[j].totalindex);
        		arrayear8[j]=toDecimal(array8[j].totalindex);
        		arrayear9[j]=toDecimal(array9[j].totalindex);
        		arrayear10[j]=toDecimal(array10[j].totalindex);
        		year[j] = array1[j].year;
        	}
    	}else if(document.getElementById('select_score').value==1){
    		for(var j=0;j<array1.length;j++){
        		arrayear1[j]=toDecimal(array1[j].goal1index);
        		arrayear2[j]=toDecimal(array2[j].goal1index);
        		arrayear3[j]=toDecimal(array3[j].goal1index);
        		arrayear4[j]=toDecimal(array4[j].goal1index);
        		arrayear5[j]=toDecimal(array5[j].goal1index);
        		arrayear6[j]=toDecimal(array6[j].goal1index);
        		arrayear7[j]=toDecimal(array7[j].goal1index);
        		arrayear8[j]=toDecimal(array8[j].goal1index);
        		arrayear9[j]=toDecimal(array9[j].goal1index);
        		arrayear10[j]=toDecimal(array10[j].goal1index);
        		year[j] = array1[j].year;
        	}
    	}else if(document.getElementById('select_score').value==2){
    		for(var j=0;j<array1.length;j++){
        		arrayear1[j]=toDecimal(array1[j].goal2index);
        		arrayear2[j]=toDecimal(array2[j].goal2index);
        		arrayear3[j]=toDecimal(array3[j].goal2index);
        		arrayear4[j]=toDecimal(array4[j].goal2index);
        		arrayear5[j]=toDecimal(array5[j].goal2index);
        		arrayear6[j]=toDecimal(array6[j].goal2index);
        		arrayear7[j]=toDecimal(array7[j].goal2index);
        		arrayear8[j]=toDecimal(array8[j].goal2index);
        		arrayear9[j]=toDecimal(array9[j].goal2index);
        		arrayear10[j]=toDecimal(array10[j].goal2index);
        		year[j] = array1[j].year;
        	}
    	}else{
    		for(var j=0;j<array1.length;j++){
        		arrayear1[j]=toDecimal(array1[j].goal3index);
        		arrayear2[j]=toDecimal(array2[j].goal3index);
        		arrayear3[j]=toDecimal(array3[j].goal3index);
        		arrayear4[j]=toDecimal(array4[j].goal3index);
        		arrayear5[j]=toDecimal(array5[j].goal3index);
        		arrayear6[j]=toDecimal(array6[j].goal3index);
        		arrayear7[j]=toDecimal(array7[j].goal3index);
        		arrayear8[j]=toDecimal(array8[j].goal3index);
        		arrayear9[j]=toDecimal(array9[j].goal3index);
        		arrayear10[j]=toDecimal(array10[j].goal3index);
        		year[j] = array1[j].year;
        	}
    	}
    	
    	/*
    	console.log(arrayear1);
    	console.log(arrayear2);
    	console.log(arrayear3);
    	console.log(arrayear4);
    	console.log(arrayear5);
    	console.log(arrayear6);
    	console.log(arrayear7);
    	console.log(arrayear8);
    	console.log(arrayear9);
    	console.log(arrayear10);
    	console.log(year);
    	*/
    	var option = {
                title : {
                    text: '${etitle}',
                    x:'center',
                },
                tooltip : {
                    trigger: 'axis'
                },
                dataZoom: {
                    show: true,
                    start : 0,
                    height: 15
                },
                legend: {
                	x : 'center',
                	y : '32',
                    data:['${ganzhou}','${linze}','${gaotai}','${shandan}','${minle}','${sunan}','${jiayuguan}','${suzhou}','${jinta}','${ejinaqi}']
                },
                toolbox: {
                    show : true,
                    feature : {
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : year
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'${ganzhou}',
                        type:'line',
                        stack: 'a1',
                        data: arrayear1
                    },
                    {
                        name:'${linze}',
                        type:'line',
                        stack: 'a2',
                        data:  arrayear2
                    },
                    {
                        name:'${gaotai}',
                        type:'line',
                        stack: 'a3',
                        data: arrayear3
                    },
                    {
                        name:'${shandan}',
                        type:'line',
                        stack: 'a4',
                        data: arrayear4
                    },
                    {
                        name:'${minle}',
                        type:'line',
                        stack: 'a5',
                        data: arrayear5
                    },
                    {
                        name:'${sunan}',
                        type:'line',
                        stack: 'a6',
                        data: arrayear6
                    },
                    {
                        name:'${jiayuguan}',
                        type:'line',
                        stack: 'a7',
                        data: arrayear7
                    },
                    {
                        name:'${suzhou}',
                        type:'line',
                        stack: 'a8',
                        data: arrayear8
                    },
                    {
                        name:'${jinta}',
                        type:'line',
                        stack: 'a9',
                        data: arrayear9
                    },
                    {
                        name:'${ejinaqi}',
                        type:'line',
                        stack: 'a10',
                        data: arrayear10
                    }
                ]
            };
    	myChart.setOption(option);
    }
 
	
    
</script>
<!-- <script>
//	评价结果切换显示
var switchnum = true;
$("#switch").click(function(){
	if(switchnum == true){
		console.log("switchtrue");
		switchnum = false;
		$("#echarts").css("display","none");
		$("#scatter").css("display","block");
	}else{
		console.log("switchfalse");
		switchnum = true;
		$("#scatter").css("display","none");
		$("#echarts").css("display","block");
	}
});

		var showDemo = function(){
			var cx2 = new CanvasXpress("canvas2",
	          {
	            "y" : {
	              "vars" : ["Variable1", "Variable2", "Variable3", "Variable4", "Variable5", "Variable6", "Variable7", "Variable8", "Variable9", "Variable10", "Variable11", "Variable12", "Variable13", "Variable14", "Variable15", "Variable16", "Variable17", "Variable18", "Variable19", "Variable20", "Variable21", "Variable22", "Variable23", "Variable24", "Variable25", "Variable26", "Variable27", "Variable28", "Variable29", "Variable30", "Variable31", "Variable32", "Variable33", "Variable34", "Variable35", "Variable36", "Variable37", "Variable38", "Variable39", "Variable40", "Variable41", "Variable42", "Variable43", "Variable44", "Variable45", "Variable46", "Variable47", "Variable48", "Variable49", "Variable50", "Variable51", "Variable52", "Variable53", "Variable54", "Variable55", "Variable56", "Variable57", "Variable58", "Variable59", "Variable60", "Variable61", "Variable62", "Variable63", "Variable64", "Variable65", "Variable66", "Variable67", "Variable68", "Variable69", "Variable70", "Variable71", "Variable72", "Variable73", "Variable74", "Variable75", "Variable76", "Variable77", "Variable78", "Variable79", "Variable80", "Variable81"],
	              "smps" : ["Sample1", "Sample2", "Sample3"],
	              "data" : [[-5, 5, 5], [-5, 15, 15], [-5, 25, 25], [-5, 35, 35], [-5, 45, 45], [-5, 35, 55], [-5, 25, 65], [-5, 15, 75], [-5, 5, 85], [-15, 15, 5], [-15, 25, 15], [-15, 35, 25], [-15, 45, 35], [-15, 55, 45], [-15, 45, 55], [-15, 35, 65], [-15, 25, 75], [-15, 15, 85], [-25, 25, 5], [-25, 35, 15], [-25, 45, 25], [-25, 55, 35], [-25, 65, 45], [-25, 55, 55], [-25, 45, 65], [-25, 35, 75], [-25, 25, 85], [-35, 35, 5], [-35, 45, 15], [-35, 55, 25], [-35, 65, 35], [-35, 75, 45], [-35, 65, 55], [-35, 55, 65], [-35, 45, 75], [-35, 35, 85], [-45, 45, 5], [-45, 55, 15], [-45, 65, 25], [-45, 75, 35], [-45, 85, 45], [-45, 75, 55], [-45, 65, 65], [-45, 55, 75], [-45, 45, 85], [-55, 35, 5], [-55, 45, 15], [-55, 55, 25], [-55, 65, 35], [-55, 75, 45], [-55, 65, 55], [-55, 55, 65], [-55, 45, 75], [-55, 35, 85], [-65, 25, 5], [-65, 35, 15], [-65, 45, 25], [-65, 55, 35], [-65, 65, 45], [-65, 55, 55], [-65, 45, 65], [-65, 35, 75], [-65, 25, 85], [-75, 15, 5], [-75, 25, 15], [-75, 35, 25], [-75, 45, 35], [-75, 55, 45], [-75, 45, 55], [-75, 35, 65], [-75, 25, 75], [-75, 15, 85], [-85, 5, 5], [-85, 15, 15], [-85, 25, 25], [-85, 35, 35], [-85, 45, 45], [-85, 35, 55], [-85, 25, 65], [-85, 15, 75], [-85, 5, 85]]
	            }
	          },
	          {"graphType": "Scatter3D",
	           "scatterType": "bar",
	           "xAxis": ["Sample1"],
	           "yAxis": ["Sample2"],
	           "zAxis": ["Sample3"]
	          }
	        );
	        var showCode = function (e, id) {
		        var cx = CanvasXpress.getObject(id)
		        cx.stopEvent(e);
		        cx.cancelEvent(e);
		        cx.updateCodeDiv(10000);
		        return false;
		    }
		}
</script>
 -->
 <script type="text/javascript">
 $(function() {
	var n = 10.8123;
    $( "#slider-range-max" ).slider({
        //range: "max",
        min: 8.0,
        //max: 10.801,
        //value: 2,
        //slide: function( event, ui ) {
        //$( "#amount" ).val( ui.value.toFixed(1) );
        //}
        onComplete: function(value) {
            console.log(value)
            $( "#amount" ).val(value)
        }
    });
    <#--  $( "#amount" ).val( $( "#slider-range-max" ).slider( "value" ).toFixed(1) );  -->
});
 
 /*
 	   $.post(
			"setFlowdown.do",
			{
				"projectId" : "${projectId}",
				"countyId" : arr[i][1],
				"Upstreamwater":arr[i][2],
				"FlowDown":arr[i][3],
				"Waterdistribution":arr[i][4], 
				"SurSup":arr[i][5],
				"GWSup":arr[i][6], 
				"SupWater":arr[i][7]
			}, function(data) {
				//alert(data.content);
		})*/
	$("#btn_eval").on("click",function(){
		$.ajax({
			 type: "post",
			 url: "setFlowdown.do",
			 data: {"flowdown" :document.getElementById('amount').value},
			 		    //dataType:"json",
			 async:false,
			 success: function(data){
			 		  console.log(data.content);	
			 		}
			 });
 	  	$.ajax({
			 type: "post",
			 url: "startAll.do",
			 data: {"projectId":"${projectId}",
				 	"economicFrist":"true"},
			 		    //dataType:"json",
			 async:false,
			 success: function(data){
			 		  console.log(data.content);	
			 		}
			 });
 	  });
 </script>
</body>
