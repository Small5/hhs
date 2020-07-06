<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta http-equiv="X-UA-Compatible" content="IE=10">
<meta http-equiv="X-UA-Compatible" content="IE=11">
<title>黑河流域生态-水文-经济系统模拟与预测</title>
<script type="text/javascript" src="index/js/jquery-1.7.2.js"></script>
<link href="index/css/playground.css" media="all" rel="stylesheet" type="text/css" /> 
<style type="text/css">
html,body{margin:0;padding:0}
body{font:76% arial,sans-serif}
p{margin:0 10px 10px}
a{display:block;color:#981793;padding:10px}

/* layout */
body{center no-repeat)}
div#header{font-family: 微软雅黑;font-weight:bolder; font-size: 40px;height:280px;line-height:80px;margin:0;padding-top:120px;color:#000000}
div#footer{color:#FFF}
div#footer p{margin:0;padding:5px 10px}

div#extra{clear:both;width:100%;}

/* Place all stylesheet code here */

@-webkit-keyframes bigAssButtonPulse {
  from { background-color: #1e6a0f; -webkit-box-shadow: 0 0 25px #333; }
  50% { background-color: #39ba1f; -webkit-box-shadow: 0 0 75px #39ba1f; }
  to { background-color: #1e6a0f; -webkit-box-shadow: 0 0 25px #333; }
}

@-webkit-keyframes greenPulse {
  from { background-color: #1e6a0f; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #39ba1f; -webkit-box-shadow: 0 0 27px #39ba1f; }
  to { background-color: #1e6a0f; -webkit-box-shadow: 0 0 9px #333; }
}

@-webkit-keyframes bluePulse {
  from { background-color: #036075; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #2daebf; -webkit-box-shadow: 0 0 27px #2daebf; }
  to { background-color: #036075; -webkit-box-shadow: 0 0 9px #333; }
}

@-webkit-keyframes redPulse {
  from { background-color: #8c2305; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #e33100; -webkit-box-shadow: 0 0 27px #e33100; }
  to { background-color: #8c2305; -webkit-box-shadow: 0 0 9px #333; }
}

@-webkit-keyframes magentaPulse {
  from { background-color: #470123; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #a9014b; -webkit-box-shadow: 0 0 27px #a9014b; }
  to { background-color: #470123; -webkit-box-shadow: 0 0 9px #333; }
}

@-webkit-keyframes orangePulse {
  from { background-color: #b84c04; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #ff5c00; -webkit-box-shadow: 0 0 27px #ff5c00; }
  to { background-color: #b84c04; -webkit-box-shadow: 0 0 9px #333; }
}

@-webkit-keyframes orangellowPulse {
  from { background-color: #bd5000; -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: #ffb515; -webkit-box-shadow: 0 0 27px #ffb515; }
  to { background-color: #bd5000; -webkit-box-shadow: 0 0 9px #333; }
}

a.button {
	-webkit-animation-duration: 2s;
	-webkit-animation-iteration-count: infinite; 
}

.green.button { -webkit-animation-name: greenPulse;animation-name: greenPulse; -webkit-animation-duration: 2s;animation-duration: 2s; }
.blue.button { -webkit-animation-name: bluePulse; -webkit-animation-duration: 2s; }
.red.button { -webkit-animation-name: redPulse; -webkit-animation-duration: 2s; }
.magenta.button { -webkit-animation-name: magentaPulse; -webkit-animation-duration: 2s; }
.orange.button { -webkit-animation-name: orangePulse; -webkit-animation-duration: 2s; }
.orangellow.button { -webkit-animation-name: orangellowPulse; -webkit-animation-duration: 2s; }

.wall-of-buttons { width: 100%; height: 100%; text-align: center; }
.wall-of-buttons a.button { display: inline-block; margin: 0 100px 60px 0; } 

li{
	float: left;
	list-style: none;
}
</style>


</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1;background-image: url('index/image/index.png');background-size:100% 100% ">
	
		<div style="padding-left: 85%">
			<ul>
				<li><a id="china" style="color:#8B0000;font-weight: bolder;line-height:36px;" onclick="Chinese();">中文版</a></li>
				<li><a id="english" style="color:#8B0000;font-weight: bolder;line-height:36px;" onclick="English();">English</a></li>
			</ul>
			
		</div>
		<div id="container">
			<div id="header">
				<p align="center">黑河流域生态-水文-经济系统模拟与预测</p>
				<p align="center">Simulation And Prediction of Ecological-Hydrological-Economic System In The Heihe River Basin</p>
			</div>
			<div id="extra">	
				<div class="wall-of-buttons"> 
					<p>
						<a id="a1" class="large green button" href="login.do">流域可持续发展决策支持系统</a>
					  	<a id="a2" class="large blue button" href="http://210.26.55.249/water_zh/">地下水实时模拟监测系统</a>
					  	<br />
					</p>
				</div>
			</div>
			<div id="footer"><p align="center" style="color: #000000;font-weight: bolder;">Copyright © 2018 中国科学院寒区旱区环境与工程研究所. All rights reserved.</p></div>		
		</div>
	</div>
	<script type="text/javascript">
		console.log($(window).height());
		var height = $(window).height()-467;
		document.getElementById( "extra" ).style.height = height+"px";
	</script>
	<script type="text/javascript">
		
	
		function Chinese(){
			$.get("index.do",
			      {language:"chinese"},
			      function(data){
			      	//console.log("目前选择:china");
			      	document.getElementById("a1").innerHTML="流域可持续发展决策支持系统";
			      	document.getElementById("a2").innerHTML="地下水实时模拟监测系统";
			      }
			);
		}
		function English(){

			$.get("index.do",
			      {language:"english"},
			      function(data){
			      	//console.log("目前选择:english");
			      	document.getElementById("a1").innerHTML="River Basin Sustainable Development Decision Support System";
			      	document.getElementById("a2").innerHTML="Groundwater Real-Time Simulation Monitoring System";
			      }
			);
		}
	
	

	</script>

</body>
</html>