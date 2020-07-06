<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="img/logo.ico">
<!-- Bootstrap -->
<script src="js/jquery.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css" />
<!-- <link href='http://fonts.useso.com/css?family=PT+Sans:400,700'
	rel='stylesheet' type='text/css'> -->
<style type="text/css">
html, body {
	background-color: rgb(233, 233, 232);
}

.content {
	background: #fff;
	border-radius: 8px;
	padding-bottom: 30px;
	overflow: hidden;
	font-family: Helvetica, Arial, "Hiragino Sans GB", "Microsoft Yahei",
		"微软雅黑", STHeiti, "华文细黑", sans-serif;
	color: #666;
	font-size: 14px;
	border-radius: 20px;
	width: 50%;
	margin-top: 6%;
	margin-left: auto;
	margin-right: auto;
	padding-top: 30px;
}

.title {
	text-align: center;
	font-family: "黑体";
	font-size: 30px;
	margin-bottom: 50px;
}

.btnn {
	text-align: center;
}

#mya {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body onload="getTime();">

	<div class="content">
		<p class="title">请设置默认项目</p>
		<div class="btnn">
			<a id="mya" href="projectlist.do" class="btn"><span id="myspan">返回项目列表</span></a>
		</div>
	</div>

	<!-- 
	<script type="text/javascript">
		function getTime(){
			setInterval("clock()", 1000);
		}
		
		function clock() {
			var time = 3;
			$("#mya").text(time + "秒后返回项目列表");
			time--;
			if (time == -1) {
				window.location.href = 'projectlist.do';
			}
		}
		
	</script>
	 
	 -->

</body>
</html>