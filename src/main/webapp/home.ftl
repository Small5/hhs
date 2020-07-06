<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://java.sun.com/jsf/facelets">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="webicon/logo.png">
    <title>决策系统</title>
    <#--  <link href="css/bootstrap.css" rel="stylesheet">  -->
    <!--<script src="css/ol3-layerswitcher.js" type="text/javascript"></script> -->
    <#--  <link href="css/navbar.css" rel="stylesheet">  -->
    <#--  <link href="css/toplayer.css" rel="stylesheet">  -->
    <#--<link href="starter-template.css" rel="stylesheet">-->
    <#--  <link rel="stylesheet" type="text/css" href="css/ol.css" />  -->
    <#--  <link rel="stylesheet" type="text/css" href="css/ol3-layerswitcher.css" />  -->
    <#--<link rel="stylesheet" type="text/css" href="css/style.css"/>-->
    <script>
        var timestamp = new Date().getTime()
        var cssList = [
            'css/bootstrap.css', 
            'css/navbar.css',
            'css/toplayer.css',
            'css/ol.css',
            'css/ol3-layerswitcher.css',
            'static/css/style.css',
            'easyUI/themes/default/easyui.css',
            'easyUI/themes/icon.css',
            'easyUI/web.css',
            'static/js/jqueryPagination/pagination.css'
            ]
        for(var i = 0; i < cssList.length; i++) {
            var url = '<link rel="stylesheet" type="text/css" href="' + cssList[i] + '?time=' + timestamp + '">'
            document.write(url)
        }
    </script>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  	<#--  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>  -->
  	<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <#--  <link rel="stylesheet" type="text/css" href="static/css/style.css?x=123"/>  -->
    <#--  <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">  -->
    <#--<link rel="stylesheet" type="text/css" href="css/web.css">-->
    <#--  <link rel="stylesheet" type="text/css" href="easyUI/web.css">
    <link rel="stylesheet" type="text/css" href="static/js/jqueryPagination/pagination.css"/>  -->
</head>

<body>
<#--  <body onLoad="init()">  -->

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div id="navigation" class="container">
        <img id="navigation-pic" alt="" src="webicon/logo-1.png" />
        <img id="navigation-logo" alt="" src="webicon/logo-right.png" />
    </div>
</div>

<!-- 地图 -->
<#--  <div id="map" style="z-index:-1;position:fixed ;width:100%; height:100%;margin-top:0px"></div>  -->
<div id="map2" style="z-index: -1; position: fixed; width: 100%; height: 100%; margin-top: 0px">
    <#include "GIS.ftl">
</div>

<div class="container" id="main">
    <!-- 下拉 -->
    <!--流域管理-->
    <div class="navbar-1" id="navbar-1" >
        <div class="div-inline" id="zhedie-1">
        <div class="collapse watershed_wrap" id="accordion" data-toggle="collapse" data-parent="#zhedie-1" >
            <#--<div class="panel panel-default">
            <div id="heihe"><a class="liuyu" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" style="color:#FFFFFF">黑河流域</a></div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                <p style="color:#FFFFFF">编辑 删除 显示GIS</p>
                </div>
            </div>
            </div>-->
            <#--制作流域模板-->
            <div id="waterlist_template" class="panel panel-default" style="display: none; text-align: center;">
                <#--<div class="panel panel-default">-->
                    <div id={$watershedid}><a class="liuyu" data-toggle="collapse" data-parent="#accordion" href={$numhref} style="color:#FFFFFF">{$watershedname}</a></div>
                    <div id={$num} class="panel-collapse collapse">
                        <div class="panel-body">
                            <div id={$tbid}>
                                <a href="javascript:void(0)" id={$editBtnid} class="easyui-linkbutton" plain="true" data-toggle="modal" data-target="#myModal-editWatershed">${edit}</a>
                                <a href="javascript:void(0)" id={$deleteBtnid} class="easyui-linkbutton" plain="true" >${delete}</a>
                                <a href="javascript:void(0)" id={$autowatershedBtnid} class="easyui-linkbutton" plain="true" >${sdb}</a>
                            </div>
                        </div>
                    </div>
                <#--</div>-->
            </div>
            <div class="panel panel-default addwatershed" style="display: none">
            <div class="small-bar" id="riveradd"><a class="liuyu" data-toggle="modal" data-target="#myModal-addRiver" href="" style="color:#FFFFFF">新增流域</a></div>
            
            </div>
        </div>
        <div id="lyxmgl" data-toggle="collapse" data-parent="#navbar-1"  href="#accordion" >
            <a data-toggle="collapse" data-parent="#navbar-1"  href="#accordion" style="color:#FFFFFF">流域管理</a>
        </div>
        </div>
    </div>
    <!--项目管理-->
    <div class="navbar-3" id="navbar-3">
        <div class="div-inline" id="zhedie-3">
            <div class="panel-collapse collapse project_wrap" id="accordion-3" data-toggle="collapse" data-parent="#zhedie-3">
                <#--制作项目模板-->
                <div id="projectlist_template" class="panel panel-default" style="display: none; text-align: center;">
                   <#-- <div class="panel panel-default">-->
                    <div id={$projectid}><a class="liuyu" data-toggle="collapse" data-parent="#accordion" href={$pnumhref} style="color:#FFFFFF">{$projectname}</a></div>
                    <div id={$pnum} class="panel-collapse collapse">
                        <div class="panel-body">
                            <div id={$tbid}>
                                <a href="javascript:void(0)" id={$peditBtnid} class="easyui-linkbutton"
                                    plain="true" data-toggle="modal" data-target="#myModal-editProject">${edit}</a>
                                <a href="javascript:void(0)" id={$pdeleteBtnid} class="easyui-linkbutton" plain="true" >${delete}</a>
                                <a href="javascript:void(0)" id={$okBtnid} class="easyui-linkbutton" plain="true" >${open}</a>
                            </div>
                        </div>
                    </div>
                    <#--</div>-->
                </div>
                <div class="panel panel-default addproject" style="display: none">
                    <div id="projectadd"><a class="liuyu" data-toggle="modal" data-target="#myModal-addProject" href="" style="color:#FFFFFF">新增项目</a></div>
                </div>
            </div>
            <div id="jczc" href="#accordion-3" data-toggle="collapse" data-parent="#navbar-3">
                <a href="#accordion-3" data-toggle="collapse" data-parent="#navbar-3" style="color:#FFFFFF">决策支持</a>
            </div>
        </div>
    </div>
    <!--  目标设定  -->
    <div class="navbar-2" id="navbar-2">
        <div class="div-inline" id="zhedie-5">
            <div class="panel-collapse collapse" id="accordion-5" data-toggle="collapse" data-parent="#zhedie-5">
            </div>
            <div id="qjsz" href="#accordion-5" data-toggle="collapse" data-parent="#navbar-2">
                <a href="#accordion-5" data-toggle="modal" data-target="#myModal_setGoal" href="" style="color:#FFFFFF">目标设定</a>
            </div>
        </div>
    </div>
    <!--  情景设置  -->
    <div class="navbar-2" id="navbar-5">
        <div class="div-inline" id="zhedie-5">
            <div class="panel-collapse collapse" id="accordion-5" data-toggle="collapse" data-parent="#zhedie-5">
            </div>
            <div id="qjsz" href="#accordion-5" data-toggle="collapse" data-parent="#navbar-5">
                <a href="#accordion-5" data-toggle="modal" data-target="#myModal_setCondition" href="" style="color:#FFFFFF">情景设置</a>
            </div>
        </div>
    </div>
    <!--情景模拟-->
    <div class="navbar-2" id="navbar-4">
        <div class="div-inline" id="zhedie-5">
            <div class="panel-collapse collapse" id="accordion-5" data-toggle="collapse" data-parent="#zhedie-5">
            </div>
            <div id="qjsz" href="#accordion-5" data-toggle="collapse" data-parent="#navbar-4">
                <a href="#accordion-5" data-toggle="modal" data-target="#myModal_result" href="" style="color:#FFFFFF">情景模拟</a>
            </div>
        </div>
    </div>

    <div id="others" class="accordion-6">
        <a id="more-login" href="#table-user" data-toggle="modal" data-parent="#others" data-target="#myModal-login"><img class="btn_1" onclick="change_2(this)" alt="" title="未登录" src="webicon/webicon_more.png" /></a>
        <a id="more-logined" href="#table-user" data-toggle="collapse" data-parent="#others" ><img class="btn_1" onclick="change(this)" alt="" title="更多" src="webicon/webicon_more.png" /></a>
        <div id="table-user" class="panel-collapse collapse"  data-toggle="collapse" data-parent="#others"order="0" cellpadding="0" cellspacing="0">
            <table>
                <tr><td><a id="custom_1" data-toggle="modal" data-target="#myModal-user"><img class="btn_1" alt="个人中心" title="个人信息" src="webicon/webicon_admin.png" /></a></td></tr>
                <tr><td><a id="custom_2"  data-toggle="modal" data-target="#myModal-message"><img class="btn_1" onclick="change_1(this)" alt="" title="消息通告" src="webicon/webicon_message2.png" /></a></td></tr>
                <tr><td><a id="custom_4" href="http://www.baidu.com/"><img class="btn_1" alt="" title="退出系统" src="webicon/webicon_exit.png" /></a></td></tr>
                <tr><td><a id="custom_3" data-toggle="modal" data-target="#myModal-about"><img class="btn_1" alt="关于系统" title="关于系统" src="webicon/webicon_about.png" /></a></td></tr>
            </table>
        </div>
    </div>
</div>


<div id="legend" class="btn-group dropup">
    <button id="btn-legend" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" data-stopPropagation="true" style="color:#FFFFFF;font-size: small;">图例</button>
    <ul id="menu-legend" class="dropdown-menu" role="menu" >
        <li id="lyzs" style="color: #FFFFFF;" data-stopPropagation=”true”>流域可持续发展指数</li>
        <li id="szyzs" style="color: #FFFFFF;" data-stopPropagation=”true”>水资源可持续发展指数</li>
        <li id="stzs" style="color: #FFFFFF;" data-stopPropagation=”true”>生态可持续发展指数</li>
        <li id="shjjzs" style="color: #FFFFFF;" data-stopPropagation=”true”>社会经济可持续发展指数</li>
    </ul>
</div>
<div id="copyright"><strong>Copyright © 2018 中国科学院寒区旱区环境与工程研究所</strong></div>

<!-- 模态框（新增流域） -->
<div class="modal fade" id="myModal-addRiver" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-addRiver" style="width: 70%;">
        <div class="modal-content" id="content-addRiver">
            <div class="modal-header" id="header-addRiver">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel_addRiver" style="text-align: center; color:#FFFFFF">
                    新增流域
                </h4>
            </div>
            <div class="modal-body" id="body-addRiver">
               <#include "AddWatershed.ftl">
            </div>
        </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!--模态框（新增项目）-->
<div class="modal fade" id="myModal-addProject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-addProject" style="width: 70%;">
        <div class="modal-content" id="content-addProject">
            <div class="modal-header" id="header-addProject">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel_addProject" style="text-align: center; color:#FFFFFF">
                    新增流域
                </h4>
            </div>
            <div class="modal-body" id="body-addProject">
                <#include "AddProject.ftl">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--模态框（编辑流域）-->
<div class="modal fade" id="myModal-editWatershed" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-editWatershed" style="width: 70%;">
        <div class="modal-content" id="content-editWatershed">
            <div class="modal-header" id="header-editWatershed">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel_editWatershed" style="text-align: center; color:#FFFFFF">
                    编辑流域
                </h4>
            </div>
            <div class="modal-body" id="body-editWatershed">
                <form class="admin-form" id="updateWatershed" action="updateWatershed.do" enctype="multipart/form-data" method="post" onsubmit="return updateWatershed();">
                    <div class="admin-form-item">
                        <label class="admin-form-label">${basinid}</label>
                        <div class="admin-input-block">
                            <input type="text" class="admin-input" readonly="readonly" id="wedit_id" name="id">
                        </div>
                    </div>
                    <div class="admin-form-item">
                        <label class="admin-form-label">${basin}</label>
                        <div class="admin-input-block">
                            <input type="text" class="admin-input" id="wedit_name" name="name">
                        </div>
                    </div>
                    <div class="admin-form-item">
                        <label class="admin-form-label">${description}</label>
                        <div class="admin-input-block">
                            <input type="text" class="admin-input" id="wedit_describe" name="describe">
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
                        <button class="admin-btn admin-btn-blue" type="submit">${save}</button>
                        <button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
                    </div>
                </form>
                <#--<#include "projectedit.ftl">-->
            </div>
        </div>/.modal-content -->
    </div><!-- /.modal -->
</div>
<!--模态框（编辑项目）-->
<div class="modal fade " id="myModal-editProject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-addProject" style="width: 70%;">
        <div class="modal-content" id="content-addProject">
            <div class="modal-header" id="header-addProject">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel_addProject" style="text-align: center; color:#FFFFFF">
                    编辑项目
                </h4>
            </div>
            <div class="modal-body" id="body-addProject">
                    <form class="admin-form" id="updateProject" action="updateProject.do" enctype="multipart/form-data" method="post" onsubmit="return updateProject();">
                        <div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${base}</div>
                        <div class="admin-form-item">
                            <label class="admin-form-label">${pname}</label>
                            <div class="admin-input-block">
                                <input type="text" class="admin-input" id="pedit_name" name="name" value="">
                            </div>
                        </div>
                        <div class="admin-form-item">
                            <label class="admin-form-label">${description}</label>
                            <div class="admin-input-block">
                                <input type="text" class="admin-input" id="pedit_describe" name="describe" >
                            </div>
                        </div>
                        <div class="admin-form-item">
                            <label class="admin-form-label">${cwid}</label>
                            <div class="admin-input-block">
                                <input type="text" class="admin-input" id="pedit_watershedId" name="watershedId" >
                            </div>
                        </div>
                        <div class="admin-form-tip"><i class="icon iconfont icon-left">&#xe60d;</i>${bps}</div>
                        <div class="admin-form-item">
                            <div class="admin-inline">
                                <label class="admin-form-label">${baseyear}</label>
                                <div class="admin-input-block">
                                    <input type="text" class="admin-input" id="pedit_baseYear" name="baseYear" readonly="readonly">
                                </div>
                            </div>
                            <div class="admin-inline">
                                <label class="admin-form-label"><span style="float: left;margin-left:40px;">----</span>${targetyear}</label>
                                <div class="admin-input-block">
                                    <input type="text" class="admin-input" id="pedit_goalYear" name="goalYear">
                                </div>
                            </div>
                        </div>
                        <div class="admin-form-item">
                            <label class="admin-form-label">${step}</label>
                            <div class="admin-input-block">
                                <select id="pedit_step" name="step" class="admin-select">
                                    <option value="年">年</option>
                                    <option value="月">月</option>
                                    <option value="日">日</option>
                                </select>
						        <input type="text" class="admin-input" id="pedit_step" name="step" value="${project.step}">
                            </div>
                        </div>
                        <div class="admin-form-item  admin-form-btn">
                            <button class="admin-btn admin-btn-blue" type="submit" >${save}</button>
                            <button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
                        </div>
                    </form>
                <#--<#include "projectedit.ftl">-->
            </div>
        </div>
    </div><!-- /.modal -->
</div>

<!-- 模态框（设置目标） -->
<div class="modal fade" id="myModal_setGoal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-setGoal">
        <div class="modal-content" id="content-setCondition">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="text-align:left;color:#000">
                    &times;
                </button>
                <h3 class="modal-title"  style="text-align: center;color:#FFFFFF">
                    目标设定
                </h3>
            </div>
            <div class="modal-body" id="body-setGoal">
                <#include "goal.ftl">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框（设置情景） -->
<div class="modal fade" id="myModal_setCondition" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-setCondition">
        <div class="modal-content" id="content-setCondition">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="text-align:left;color:#000">
                    &times;
                </button>
                <h3 class="modal-title"  style="text-align: center;color:#FFFFFF">
                    情景设置
                </h3>
            </div>
            <div class="modal-body" id="body-setCondition">
                <#include "toStuation.ftl">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框（模拟结果） -->
<div class="modal fade " id="myModal_result" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="dialog-result">
        <div class="modal-content" id="content-result">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title"  style="text-align: center;color:#FFFFFF">
                    情景模拟
                </h3>
            </div>
            <div class="modal-body" id="body-result">
                <#include "jumpToResult.ftl">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框（通知） -->
<div class="modal fade" id="myModal-message" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="myModalLabel1" style="text-align: center;">
                    方案xx决策研讨！
                </h3>
            </div>
            <div class="modal-body">
                <p  >主持人：王教授</p>
                <p  >会议时间：2018年11月1日19：00</p>
                <p  >会议主要内容：对项目20181101进行决策探讨</p>
                <p  >参会人员：Dr.li, Dr.zhang, Pro.zhou</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框（个人信息） -->
<div class="modal fade" id="myModal-user" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="myModalLabel2" style="text-align: center;">
                    个人信息
                </h3>
            </div>
            <div class="modal-body">
                <form class="admin-form">
                    <input type="text" class="form-control" id="userid" value="" name="id" style="display:none;">
                    <div class="admin-form-item">
                        <label class="admin-form-label">用户名</label>
                        <div class="admin-input-block">
                            <input readonly="readonly" type="text" class="admin-input" id="accountNumber" name="accountNumber" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="admin-form-item">
                        <label class="admin-form-label">昵称</label>
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
                        <label class="admin-form-label">密码</label>
                        <div class="admin-input-block">
                            <input type="password" class="admin-input" id="password" name="password" placeholder="">
                        </div>
                    </div>
                    <div class="admin-form-item">
                        <label class="admin-form-label">确认密码</label>
                        <div class="admin-input-block">
                            <input type="password" class="admin-input" id="repwd" name="repwd" placeholder="${pwd02}">
                        </div>
                    </div>
                    <hr/>
                    <div class="admin-form-item  admin-form-btn">
                        <a onclick="savechanges();" class="admin-btn admin-btn-blue" style="margin-right: 15px;">保存</a>
                        <button class="admin-btn admin-btn-grey">取消</button>
                    </div>
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<#--<#include "UserInformation.ftl">-->

<!-- 系统介绍 -->
<div class="modal fade" id="myModal-about" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="myModalLabel">
                    <p style="text-align: center;">系统介绍</p>
                </h3>
            </div>
            <div class="modal-body">
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active" style="width: 33.3%; text-align: center;"><a href="#home" data-toggle="tab" id="tab1">黑河集成建模</a></li>
                    <li style="width: 33.3%; text-align: center;"><a href="#risdss" data-toggle="tab" id="tab2">RisDSS</a></li>
                    <li style="width: 33.3%; text-align: center;"><a href="#connect-us" data-toggle="tab" id="tab3">联系我们</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="home" style="width: 100%;">
                        <iframe src="./static/page/about/IntegratedIntroduction.html" frameborder="0" scrolling="no" id="adminFrameId1" name="adminFrameName"  style="width: 100%; border: 0; margin: 0;"></iframe>
                    </div>
                    <div class="tab-pane fade" id="risdss" style="width: 100%;">
                        <iframe src="./static/page/about/SystemIntroduction.html" frameborder="0" scrolling="no" id="adminFrameId2" name="adminFrameName"  style="width: 100%; border: 0; margin: 0;"></iframe>
                    </div>
                    <div class="tab-pane fade" id="connect-us" style="width: 100%;">
                        <iframe src="./static/page/about/ContactUs.html" frameborder="0" scrolling="no" id="adminFrameId3" name="adminFrameName"  style="width: 100%; border: 0; margin: 0;"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</div> <!-- /container -->

<div id="introduction" data-spy="scroll" data-target="#navbar-example" data-offset="0" style="height:200px;overflow:auto; position: relative;">
    <h3>联系我们</h3>
    <p>地址：兰州市东岗西路320号 兰州 甘肃</p>
    <p>电话：0931－4967250</p>
    <p>传真：0931－4967235</p>
    <p>电子邮件：rslab@lzb.ac.cn</p>
    <p>邮编：730000   Zip：730000</p>
    <h3>CONTACT US</h3>
    <p>Addr：320 Donggang West Road,Lanzhou,Gansu
    <p>Tel：+0086 931 4967250</p>
    <p>Fax：+0086 931 4967235</p>
    <p>E-mail：rslab@lzb.ac.cn</p>
    <p>Zip：730000</p>
</div>
<div class="wrapper" style="margin: 0 auto;">

</div>
<!-- 登录模态框 -->
<div class="modal fade" id="myModal-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" id="modal-dialog-login">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="btn-login" style="text-align: center;">
                    请登录
                </h3>
            </div>
            <div class="modal-body">
                <form class="form-signin" role="form">
                    <input type="text" class="form-control" placeholder="邮箱或手机号" required autofocus>
                    <p></p>
                    <input type="password" class="form-control" placeholder="密码" required>
                    <label class="checkbox">
                        <input type="checkbox" value="remember-me">记住我
                    </label>
                    <button class="btn btn-lg btn-primary btn-block" type="button" ><!-- type="submit" -->登录</button>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>

<script type="text/javascript" src="easyUI/js/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/js/jquery.easyui.min.js"></script>
<#--  <script src="js/jquery.min.js"></script>  -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/ol-debug.js"> </script>
<script src="http://api.tianditu.gov.cn/api?v=4.0&tk=68828149f28340319fc1fb3ec980f93e"></script>
<script src="js/ol3-layerswitcher.js" type="text/javascript"></script>
<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> -->
<script src="./js/jquery-form.js"></script>
<script>
    function updateWatershed() {
        $('#updateWatershed').ajaxSubmit( {
            url : "updateWatershed.do",
            success: function(data) {
                alert("success!")
                window.location.reload()
            }
        });
        return false;
    }
</script>
<!--流域列表-->
<script type="text/javascript">
    //获取流域名
    $.get(
        "getwatershedbyUser.do",
        [],
        function(data){
            if(data.isEmpty!="1"){
                // alert("拿到了流域名信息")
                console.log(data.length)
                /*获取流域展开模板*/
                var waterlist_template = $("#waterlist_template").html();
                var addwatershed = $(".addwatershed").html();

                $.each(data,function (i,item) {
                    var waterlist;
                    waterlist = waterlist_template;
                    waterlist = waterlist.replace(/\{\$watershedid\}/gi,item.id);
                    waterlist = waterlist.replace(/\{\$num\}/gi,i);
                    waterlist = waterlist.replace(/\{\$numhref\}/gi,"#"+i);
                    waterlist = waterlist.replace(/\{\$watershedname\}/gi,item.name);
                    waterlist = waterlist.replace(/\{\$tbid\}/gi,"tb_"+i);
                    waterlist = waterlist.replace(/\{\$editBtnid\}/gi,"editBtn_"+i);
                    waterlist = waterlist.replace(/\{\$deleteBtnid\}/gi,"deleteBtn_"+i);
                    waterlist = waterlist.replace(/\{\$autowatershedBtnid\}/gi,"autowatershedBtnid_"+i);

                    $('.watershed_wrap').append(waterlist);
                    var watershed_id = item.id;
                    //在append后绑定控件函数，编辑、删除流域和设置默认流域
                    $("#"+"editBtn_"+i).bind("click",function() {
                        console.log("响应编辑");
                        console.log(watershed_id);
                        $.get('watershededit.do', {
                            id: watershed_id
                        }, function(data) {
                            console.log("成功");
                            $.get(
                                "watershedMsg.do",
                                [],
                                function(data){
                                    console.log(data)
                                    if(data.isEmpty!="1"){ // data.isEmpty!="1"!$.isEmptyObject(data)
                                        console.log(data.name)
                                        $("#wedit_id").val(data.id),
                                        $("#wedit_name").val(data.name),
                                        $("#wedit_describe").val(data.describe)
                                    } else{
                                        alert("出错")
                                    }
                                    console.log(data);
                                }
                            );
                        })
                    })
                    var mess = $.messager;
                    console.log(mess);
                    $("#"+"deleteBtn_"+i).bind("click",function(){
                            console.log("触发了删除操作");
                            console.log(mess);
                            mess.confirm("操作提示", "您确定要删除这条记录吗？", function(data) {
                                if (data) {
                                    $.get('deleteWatershed.do', {
                                        id : watershed_id
                                    }, function(data) {
                                        alert('成功设置为默认流域', data.content, 'info');
                                        /*$(".pagination-load").trigger("click");*/
                                    })
                                } else {
                                }
                            });
                    })
                    $("#"+"autowatershedBtnid_"+i).bind("click",function() {
                            $.get('autowatershed.do', {
                                id: watershed_id
                            }, function(data) {
                                alert('提示', data.content, 'info');
                                //刷新父页面，即home.do
                                //parent.location.reload( );
                            })
                    })
                });
                $('.watershed_wrap').append(addwatershed);  
            } else{
                alert("没有拿到流域名信息")
            }
            console.log(data);
        }
    );
</script>
<!--用户信息脚本-->
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
<!--项目列表-->
<script type="text/javascript">
//获取项目名
$.get(
        "getProjectByUser.do",
        [],
        function(data){
            if(data.isEmpty!="1"){
                // alert("拿到了项目信息")
                console.log(data.length)
                /*获取流域展开模板*/
                var projectlist_template = $("#projectlist_template").html();
                var addproject = $(".addproject").html();

                $.each(data,function (i,item) {
                    var projectlist;
                    projectlist = projectlist_template;
                    projectlist = projectlist.replace(/\{\$projectid\}/gi,item.id);
                    projectlist = projectlist.replace(/\{\$pnum\}/gi,"p"+i);
                    projectlist = projectlist.replace(/\{\$pnumhref\}/gi,"#p"+i);
                    projectlist = projectlist.replace(/\{\$projectname\}/gi,item.name);
                    projectlist = projectlist.replace(/\{\$ptbid\}/gi,"tbp_"+i);
                    projectlist = projectlist.replace(/\{\$peditBtnid\}/gi,"peditBtn_"+i);
                    projectlist = projectlist.replace(/\{\$pdeleteBtnid\}/gi,"pdeleteBtn_"+i);
                    projectlist = projectlist.replace(/\{\$okBtnid\}/gi,"okBtn_"+i);

                    $('.project_wrap').append(projectlist);
                    var project_id = item.id;
                    //在append后绑定控件函数，编辑、删除流域和设置默认流域
                    $("#"+"peditBtn_"+i).bind("click",function() {
                        console.log("响应编辑");

                        console.log(project_id);
                        $.get('projectedit.do', {
                            id: project_id
                        }, function(data) {
                            console.log("成功");
                            //$('#myModal-editProject').on('shown.bs.modal', function () {
                                $.get(
                                    "projectMsg.do",
                                    [],
                                    function(data){
                                        console.log(data)
                                        if(data.isEmpty!="1"){ // data.isEmpty!="1"!$.isEmptyObject(data)
                                            console.log(data.name)
                                            $("#pedit_name").val(data.name)
                                            //$("#project-edit #name").value = 1
                                            $("#pedit_describe").val(data.describe),
                                                $("#pedit_watershedId").val(data.watershedId),
                                                $("#pedit_baseYear").val(data.baseYear)
                                            $("#pedit_goalYear").val(data.goalYear)
                                        } else{
                                            alert("出错")
                                        }
                                        console.log(data);
                                    }
                                );
                            //})
                            // window.location.href='jumpToProjectdedit.do';
                        })
                    })

                    var mess = $.messager;
                    console.log(mess);
                    $("#"+"pdeleteBtn_"+i).bind("click",function(){
                        console.log("触发了删除操作");
                        /*console.log(mess);*/
                        mess.confirm("操作提示", "您确定要删除这条记录吗？您不可以删除默认项目。", function(data) {
                            if (data) {
                                <#--  $.post('deleteProject.do', {
                                    id : project_id
                                }, function(data) {
                                    /*$(".pagination-load").trigger("click");*/
                                })  -->
                                $.ajax({
                                    type: 'POST',
                                    url: 'deleteProject.do',
                                    data: {
                                        id : project_id
                                    },
                                    success: function (data) {                                       
                                        if(data && data.success) {
                                            console.log("delete success")
                                            alert("delete success")
                                            window.location.reload()
                                        }
                                    },
                                });
                            } else {
                            }
                        });
                    })
                    $("#"+"okBtn_"+i).bind("click",function() {
                        $.get('autoproject.do', {
                            id: project_id
                        }, function(data) {
                            //location.href = 'assess.do';
                        })
                    })
                });
                $('.project_wrap').append(addproject);
            } else{
                alert("没有拿到项目信息")
            }
            console.log(data);
        }
);
</script>
<!--用户信息脚本-->
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
<!--退出系统-->
<script>
    function exit(){
        //console.log("退出");
        window.location.href='logout.do';
    }
</script>
<!--地图显示脚本-->
<script>
    function init(){
        layers = new T.Map("map", {datasourcesControl:true});
        var layers_ter=[
            new ol.layer.Tile({
                title: "地形图",
                source: new ol.source.XYZ({
                    url:"http://t3.tianditu.gov.cn/DataServer?T=ter_w&x={x}&y={y}&l={z}&tk=68828149f28340319fc1fb3ec980f93e"
                })
            })
        ];

        var map=new ol.Map({
            layers: layers_ter,
            target:'map',
            view:new ol.View({
                projection: 'EPSG:4326',
                center:[98, 39.2],
                zoom:8,
                extent:[89.07715,34.25537,103.75488,45.00000]
            }) ,
            controls: ol.control.defaults({
                attributionOptions: {
                    collapsible: false
                }
            })
        });

        var layersimg= new ol.layer.Tile({
            title: "卫星图",
            source: new ol.source.XYZ({
                url:"http://t3.tianditu.com/DataServer?T=img_w&x={x}&y={y}&l={z}&tk=68828149f28340319fc1fb3ec980f93e"
            })
        });
        map.addLayer(layersimg);

        var tian_di_tu_annotation = new ol.layer.Tile({
            title: "文字标注",
            source: new ol.source.XYZ({
                url: 'http://t3.tianditu.com/DataServer?T=cva_w&x={x}&y={y}&l={z}&tk=68828149f28340319fc1fb3ec980f93e'
            })
        });
        map.addLayer(tian_di_tu_annotation);

        var test =  new ol.layer.Tile({
            source:new ol.source.TileWMS({

                url:'219.246.35.16:8081/geoserver/Qilian_Basin/wms',params:{
                    'LAYERS':'Qilian_basin_clip',//此处可以是单个图层名称，也可以是图层组名称，或多个图层名称
                    'TILED':true
                },
                serverType:'geoserver'    //服务器类型
            })
        });
        test.setOpacity(0.8);
        map.addLayer(test);

        //添加比例尺控件
        var scaleLineControl = new ol.control.ScaleLine({
            //设置比例尺单位为degreees/imperial/us/nautical/metric
            units:"metric",
            target: 'scalebar',
            className: 'ol-scale-line'
        });
        map.addControl(scaleLineControl);
        //实例化ZoomSlider控件并加载到地图容器中
        var zoomslider = new ol.control.ZoomSlider();
        map.addControl(zoomslider);


        var layerSwitcher = new ol.control.LayerSwitcher({
            tipLabel: 'Légende' /* Optional label for button */});
        map.addControl(layerSwitcher);
    }

</script>
<script type="text/javascript">
    var times = -1;
    function change(btn) {
        btn.src = times % 2 == 1 ? 'webicon/webicon_moreopen.png' : 'webicon/webicon_more.png';
        btn.title = times % 2 == 0 ? '更多' : '收起';
        times++;
    }
</script>
<script type="text/javascript">
    var times = 0;
    function change_1(btn) {
        btn.src = times == 0 ? 'webicon/webicon_message2.png' : 'webicon/webicon_message1.png';
        times++;
    }
</script>
<script type="text/javascript">
    var times = 0;
    function change_2(btn) {
        btn.src = times == 0 ? 'wwebicon/webicon_more.png' : '';
        times++;
    }
</script>

<script>
    $("#menu-legend,#map").on("click",function (e) {
        e.stopPropagation();
    })

</script>

<script>
    $(function () {
        // $("[data-toggle='popover']").popover();
    });
</script>
<script language="JavaScript">
    var pee = -390;
    var drec = 40;
    var speed = 20;
    var l = pee;
    //This is the function that closes the menu
    function Proj7GlideBack() {
        l += drec;
        document.getElementById('menuBar').style.left = l + 'px';
        if (l < 0){
            setTimeout('Proj7GlideBack()', speed);//setTimeout方法用于在指定的毫秒数后调用函数或计算表达式
        } else {
            document.getElementById('glidetextLink').onclick = moveIn;
        }
    }
    //This is the function that opens the menu
    function Proj7GlideOut() {
        l -= drec;
        document.getElementById('menuBar').style.left = l + 'px';
        if (l > pee){
            setTimeout('Proj7GlideOut()', speed);
        } else {
            document.getElementById('glidetextLink').onclick = moveOut;
        }
    }
    function moveIn() {
        Proj7GlideOut();
        return false;
    }
    function moveOut() {
        Proj7GlideBack();
        return false;
    }
    <!--NNresizeFix Reloads the page to workaround a Netscape Bug-->
    if (document.layers) {
        origWidth = innerWidth;//innerWidth - 浏览器窗口的内部宽度
        origHeight = innerHeight;
    }
    function reDo() {
        if (innerWidth != origWidth || innerHeight != origHeight)
            location.reload();
    }
    if (document.layers)
        onresize = reDo;
</script>

<script type="text/javascript">
    //显示悬浮层
    function showInform(){
        document.getElementById("inform").style.display='block';
        // document.getElementById("inform").css("display","block");
    }
    //隐藏悬浮层
    function hiddenInform(event){
        var informDiv = document.getElementById('inform');
        var x=event.clientX;
        var y=event.clientY;
        var divx1 = informDiv.offsetLeft;
        var divy1 = informDiv.offsetTop;
        var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
        var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
        if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
            document.getElementById('inform').style.display='none';
        }
        else{
            document.getElementById('inform').style.display='none';
        }
    }
</script>
<script type="text/javascript">
    //显示模型运行悬浮层
    function showInform_runmodel(){
        document.getElementById("inform_runmodel").style.display='block';
        // document.getElementById("inform").css("display","block");
    }
    //隐藏悬浮层
    function hiddenInform_runmodel(event){
        var informDiv = document.getElementById('inform_runmodel');
        var x=event.clientX;
        var y=event.clientY;
        var divx1 = informDiv.offsetLeft;
        var divy1 = informDiv.offsetTop;
        var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
        var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
        if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
            document.getElementById('inform_runmodel').style.display='none';
        }
        else{
            document.getElementById('inform_runmodel').style.display='none';
        }
    }
    //显示目标设定悬浮层
    function showInform_settarget(){
        document.getElementById("inform_settarget").style.display='block';
        // document.getElementById("inform").css("display","block");
    }
    //隐藏悬浮层
    function hiddenInform_settarget(event){
        var informDiv = document.getElementById('inform_settarget');
        var x=event.clientX;
        var y=event.clientY;
        var divx1 = informDiv.offsetLeft;
        var divy1 = informDiv.offsetTop;
        var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
        var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
        if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
            document.getElementById('inform_settarget').style.display='none';
        }
        else{
            document.getElementById('inform_settarget').style.display='none';
        }
    }
</script>
<!-- </script>
    $(function(){
var tag = false,ox = 0,left = 0,bgleft = 0;
$('.progress_btn').mousedown(function(e) {
    ox = e.pageX - left;
    tag = true;
});

$(document).mouseup(function() {
    tag = false;
});

$('.progress').mousemove(function(e) {//鼠标移动
    if (tag) {
         left = e.pageX - ox;
         if (left <= 0) {
            left = 0;
         }else if (left > 300) {
            left = 300;
         }
        $('.progress_btn').css('left', left);
        $('.progress_bar').width(left);
        $('.text').html(parseInt((left/300)*100) + '%');
    }
});

$('.progress_bg').click(function(e) {//鼠标点击
     if (!tag) {
         bgleft = $('.progress_bg').offset().left;
         left = e.pageX - bgleft;
         if (left <= 0) {
             left = 0;
        }else if (left > 300) {
             left = 300;
        }
        $('.progress_btn').css('left', left);
        $('.progress_bar').animate({width:left},300);
        $('.text').html(parseInt((left/300)*100) + '%');
     }
});
});
</script> -->

<!-- 滑块控制 -->
<script>
    var slider1 = document.getElementById("slider1") // 滑块1
    var slider2 = document.getElementById("slider2") // 滑块2
    var mask1 = document.getElementById("mask1") // 水的dom
    var mask2 = document.getElementById("mask2") // 生态dom
    var barleft = 0; // 伸长大小
    var waterValue = document.getElementById("water-value")
    var ecologyValue = document.getElementById("ecology-value")
    var societyValue = document.getElementById("society-value")
    waterValue.oninput = function() {
        v = this.value
        var mask1Width = parseFloat(mask1.style.width).toFixed(0)
        var mask2Width = parseFloat(mask2.style.width).toFixed(0)
        var totalWidth = parseFloat(mask1Width) + parseFloat(mask2Width)
        var water_value = v
        var ecology_value = totalWidth - v
        var society_value = 100 - totalWidth
        if(water_value < 0 || ecology_value < 0 || society_value < 0) {
            waterValue.value = 100 - mask2Width - (100 - mask2Width - mask1Width)
            alert("输入参数越界")
        } else {
            waterValue.value = water_value
            ecologyValue.value = ecology_value
            societyValue.value = society_value
            mask1.style.width = water_value + "%"
            mask2.style.width = ecology_value + "%"
            slider1.style.left = water_value + "%"
        }
    }
    ecologyValue.oninput = function() {
        v = this.value
        var mask1Width = parseFloat(mask1.style.width).toFixed(0)
        var mask2Width = parseFloat(mask2.style.width).toFixed(0)
        var totalWidth = 100 - mask1Width
        var water_value = mask1Width
        var ecology_value = v
        var society_value = totalWidth - v
        if(water_value < 0 || ecology_value < 0 || society_value < 0) {
            ecologyValue.value = 100 - mask1Width - (100 - mask1Width - mask2Width)
            alert("输入参数越界")
        } else {
            waterValue.value = water_value
            ecologyValue.value = ecology_value
            societyValue.value = society_value
            mask2.style.width = ecology_value + "%"
            slider2.style.left = parseInt(v) + parseInt(mask1Width) + "%"
        }
    }
    societyValue.oninput = function() {
        v = this.value
        var mask1Width = parseFloat(mask1.style.width).toFixed(0)
        var mask2Width = parseFloat(mask2.style.width).toFixed(0)
        var totalWidth = 100 - mask1Width
        var water_value = 100 - totalWidth
        var ecology_value = totalWidth - v
        var society_value = v
        if(water_value < 0 || ecology_value < 0 || society_value < 0) {
            societyValue.value = 100 - mask1Width - mask2Width
            alert("输入参数越界")
        } else {
            waterValue.value = water_value
            ecologyValue.value = ecology_value
            societyValue.value = society_value
            mask2.style.width = ecology_value + "%"
            slider2.style.left = totalWidth - v + parseInt(mask1Width) + "%"
        }
    }
    slider1.onmousedown = function(event){
        var event = event || window.event;
        var leftVal = event.clientX - this.offsetLeft;
        var that = this; // 拖动一定写到 down 里面才可以
        var mask1Width = parseFloat(mask1.style.width).toFixed(0) // 水所占百分比的值（不带百分号）如30.0
        var mask2Width = parseFloat(mask2.style.width).toFixed(0) // 生态所占百分比的值（不带百分号）如30.0
        var totalWidth = parseFloat(mask1Width) + parseFloat(mask2Width) // 水和生态所占百分比的值的和
        document.onmousemove = function(event){
            var event = event || window.event;
            barleft = (event.clientX - leftVal) / 300 * 100;
            if(barleft < 0) // 边界控制边界控制，使滑块不过界
                barleft = 0;
            else if(barleft > scroll.offsetWidth - slider1.offsetWidth)
                barleft = scroll.offsetWidth - slider1.offsetWidth;
            else if(barleft > totalWidth) // 边界控制，使滑块不过界
                barleft = totalWidth
            that.style.left = barleft + "%" // 修改滑块位置
            mask1.style.width = barleft +'%' // 修改mask1宽度
            mask2.style.width = totalWidth - barleft + "%" // 修改mask2宽度
            waterValue.value = barleft.toFixed(0) // 修改输入框水的比例值
            ecologyValue.value = (totalWidth - barleft).toFixed(0) // 修改输入框生态的比例值
            societyValue.value = 100 - totalWidth // 修改输入框社会的比例值
            window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();       //防止选择内容--当拖动鼠标过快时候，弹起鼠标，bar也会移动，修复bug
        }
    }
    slider2.onmousedown = function(event){
        var event = event || window.event;
        var leftVal = event.clientX - this.offsetLeft;
        var mask1Width = parseFloat(mask1.style.width)
        var totalWidth = 100 - mask1Width // 2，3部分的总宽度，在滑动时不变
        var that = this;
        // 拖动一定写到 down 里面才可以
        document.onmousemove = function(event) {
            var event = event || window.event;
            barleft = ((event.clientX - leftVal) / 300) * 100;
            if(barleft < 0)
                barleft = 0;
            else if(barleft > scroll.offsetWidth - slider2.offsetWidth)
                barleft = scroll.offsetWidth - slider2.offsetWidth;
            else if(barleft < mask1Width)
                barleft = mask1Width
            else if(barleft - mask1Width > totalWidth)
                barleft = 100
            mask2.style.width = barleft - mask1Width +'%' ;
            that.style.left = barleft + "%";
            waterValue.value = mask1Width.toFixed(0)
            ecologyValue.value = (barleft - mask1Width).toFixed(0)
            societyValue.value = 100 - parseFloat(parseFloat(mask2.style.width).toFixed(0)) - parseFloat(parseFloat(mask1.style.width).toFixed(0))
            window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
        }
    }
    document.onmouseup = function(){
        document.onmousemove = null; //弹起鼠标不做任何操作
    }
</script>
<script>
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight
                console.log(iframeWin.document.documentElement.scrollHeight)
                console.log(iframe.height)
            }
        }
    };
    $(function () {
        $('#myModal-about').on('shown.bs.modal', function () {
            setIframeHeight(document.getElementById('adminFrameId1'));
        })
    });
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        // 获取已激活的标签页的名称
        var activeTab = $(e.target).text()
        // 获取前一个激活的标签页的名称
        var previousTab = $(e.relatedTarget).text()
        console.log(activeTab, previousTab)
        switch (activeTab) {
            case "黑河集成建模":
                setIframeHeight(document.getElementById('adminFrameId1'))
                break;
            case "RisDSS":
                setIframeHeight(document.getElementById('adminFrameId2'))
                break;
            case "联系我们":
                setIframeHeight(document.getElementById('adminFrameId3'))
                break;
        }
    });
</script>
<!-- <script>
$(function(){
  $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
    // 获取已激活的标签页的名称
    var activeTab = $(e.target).text();
    // 获取前一个激活的标签页的名称
    var previousTab = $(e.relatedTarget).text();
    $(".active-tab span").html(activeTab);
    $(".previous-tab span").html(previousTab);
  });
});
</script> -->
<script type="text/javascript" src="goal/js/underscore-min.js"></script>
<script>
    $('#myModal_setGoal').on('shown.bs.modal', function () {
       'use strict';

    var _class, _temp, _class2, _temp2;

    var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

    function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

    function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

    function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

    var Legend = function () {
        function Legend() {
            _classCallCheck(this, Legend);

            this.valueOne = document.getElementById('goal_1');
            this.valueTwo = document.getElementById('goal_2');
            this.valueThree = document.getElementById('goal_3');
            //this.totalValue = document.getElementById('total');
        }

        _createClass(Legend, [{
            key: 'setValueOne',
            value: function setValueOne(value) {
                this.valueOne.textContent = value;
            }
        }, {
            key: 'setValueTwo',
            value: function setValueTwo(value) {
                this.valueTwo.textContent = value;
            }
        }, {
            key: 'setValueThree',
            value: function setValueThree(value) {
                this.valueThree.textContent = value;
            }
        }, {
            key: 'setTotalValue',
            value: function setTotalValue(value) {
                this.totalValue.textContent = value;
            }
        }, {
            key: 'updateValues',
            value: function updateValues(val1, val2, val3) {
                this.setValueOne(val1);
                this.setValueTwo(val2);
                this.setValueThree(val3);
            }
        }]);

        return Legend;
    }();

    var SliderWidget = (_temp = _class = function () {
        function SliderWidget(elem, widgetType) {
            _classCallCheck(this, SliderWidget);

            this.elem = elem;
            this.widgetType = widgetType;
            this.totalWidth;
            this.elemWidth;
        }

        _createClass(SliderWidget, [{
            key: 'setElemWidth',
            value: function setElemWidth(width) {
                var elem = this.elem;

                this.elemWidth = width;
                elem.style.width = width + 'px';
            }
        }, {
            key: 'getElemWidth',
            value: function getElemWidth() {
                return this.elemWidth;
            }
        }, {
            key: 'getElemWidthFromCss',
            value: function getElemWidthFromCss() {
                return parseFloat(this.elem.offsetWidth);
            }
        }]);

        return SliderWidget;
    }(), _class.WIDGET_TYPE = {
        HANDLE: 1,
        BAR: 2
    }, _temp);

    var SliderHandle = (_temp2 = _class2 = function (_SliderWidget) {
        _inherits(SliderHandle, _SliderWidget);

        function SliderHandle(elem, handleType) {
            _classCallCheck(this, SliderHandle);

            var _this = _possibleConstructorReturn(this, (SliderHandle.__proto__ || Object.getPrototypeOf(SliderHandle)).call(this, elem, SliderWidget.WIDGET_TYPE.HANDLE));

            _this.elemWidth = _this.getElemWidthFromCss();
            _this.handleType = handleType;
            _this.curPos;

            _this.bindEvents();
            return _this;
        }

        _createClass(SliderHandle, [{
            key: 'setPosition',
            value: function setPosition(x) {
                var elem = this.elem,
                    handleType = this.handleType;


                this.curPos = x;
                if (handleType === SliderHandle.HANDLE_TYPE.RIGHT) {
                    elem.style.transform = 'translate3d(-' + x + 'px, 0, 0)';
                } else {
                    elem.style.transform = 'translate3d(' + x + 'px, 0, 0)';
                }
            }
        }, {
            key: 'getPosition',
            value: function getPosition() {
                return this.curPos;
            }
        }, {
            key: 'bindEvents',
            value: function bindEvents() {
                var _this2 = this;

                var elem = this.elem,
                    bindEventHelper = this.bindEventHelper;


                var eventHelper = function eventHelper(e) {
                    e.preventDefault();
                    // We want the object with screenX property
                    if (e.touches) {
                        // Handle touch events
                        return e.touches[e.touches.length - 1];
                    }
                    return e;
                };

                elem.addEventListener('touchstart', function (e) {
                    return _this2.onPointerDown(eventHelper(e));
                });
                elem.addEventListener('mousedown', function (e) {
                    return _this2.onPointerDown(eventHelper(e));
                });

                window.addEventListener('touchmove', function (e) {
                    return _this2.onPointerMove(eventHelper(e));
                });
                window.addEventListener('mousemove', function (e) {
                    return _this2.onPointerMove(eventHelper(e));
                });

                window.addEventListener('touchend', function (e) {
                    return _this2.onPointerUp(eventHelper(e));
                });
                window.addEventListener('mouseup', function (e) {
                    return _this2.onPointerUp(eventHelper(e));
                });
            }
        }, {
            key: 'onPointerDown',
            value: function onPointerDown(e) {
                console.log('wrong poitner down');
            }
        }, {
            key: 'onPointerMove',
            value: function onPointerMove(e) {
                console.log('wrong poitner move');
            }
        }, {
            key: 'onPointerUp',
            value: function onPointerUp(e) {
                console.log('wrong poitner up');
            }
        }]);

        return SliderHandle;
    }(SliderWidget), _class2.HANDLE_TYPE = {
        RIGHT: 1,
        LEFT: 2
    }, _temp2);

    var SliderBar = function (_SliderWidget2) {
        _inherits(SliderBar, _SliderWidget2);

        function SliderBar(elem) {
            _classCallCheck(this, SliderBar);

            return _possibleConstructorReturn(this, (SliderBar.__proto__ || Object.getPrototypeOf(SliderBar)).call(this, elem, SliderWidget.WIDGET_TYPE.BAR));
        }

        return SliderBar;
    }(SliderWidget);

    var ThreeValueSlider = function () {
        function ThreeValueSlider(val1, val2, val3, totalVal) {
            _classCallCheck(this, ThreeValueSlider);

            this.sliderElem = document.getElementById('three-value-slider');

            var leftHandleElem = this.sliderElem.getElementsByClassName('slider-handle left')[0];
            this.leftHandle = new SliderHandle(leftHandleElem, SliderHandle.HANDLE_TYPE.LEFT);
            var rightHandleElem = this.sliderElem.getElementsByClassName('slider-handle right')[0];
            this.rightHandle = new SliderHandle(rightHandleElem, SliderHandle.HANDLE_TYPE.RIGHT);

            var leftBarElem = this.sliderElem.getElementsByClassName('slider-bar left')[0];
            this.leftBar = new SliderBar(leftBarElem);
            var middleBarElem = this.sliderElem.getElementsByClassName('slider-bar middle')[0];
            this.middleBar = new SliderBar(middleBarElem);
            var rightBarElem = this.sliderElem.getElementsByClassName('slider-bar right')[0];
            this.rightBar = new SliderBar(rightBarElem);

            this.value1 = val1;
            this.value2 = val2;
            this.value3 = val3;
            this.totalValue = totalVal;
            this.totalWidth = this.getTotalWidth();
            console.log('total.width')
            console.log(this.totalWidth)

            this.leftBar.setElemWidth(this.getWidthByValue(this.value1));
            this.middleBar.setElemWidth(this.getWidthByValue(this.value2));
            this.rightBar.setElemWidth(this.getWidthByValue(this.value3));

            // Placing handles at the right position
            this.leftHandle.setPosition(this.leftBar.getElemWidth());
            this.rightHandle.setPosition(this.rightBar.getElemWidth());

            this.bindEvents();
            this.trackLeftHandle();
            this.trackRightHandle();

            this.legend = new Legend();
            this.legend.setTotalValue(totalVal);
            this.legend.updateValues(val1, val2, val3);
        }

        _createClass(ThreeValueSlider, [{
            key: 'trackRightHandle',
            value: function trackRightHandle() {
                var _this4 = this;

                var rightHandle = this.rightHandle,
                    leftBar = this.leftBar,
                    rightBar = this.rightBar,
                    middleBar = this.middleBar;


                var tracker = {
                    pointerDown: false,
                    startX: 0,
                    rightBarStartWidth: 0,
                    middleBarStartWidth: 0,
                    handleStartPos: 0
                };

                var updateValues = function updateValues() {
                    var totalValue = _this4.totalValue,
                        value1 = _this4.value1;
                    // Value calculated based on rightBar delta

                    var newValue3 = _this4.getValueByWidth(rightBar.getElemWidth());
                    var newValue2 = totalValue - newValue3 - value1;

                    _this4.value3 = newValue3;
                    _this4.value2 = newValue2;

                    _this4.legend.updateValues(_this4.value1, _this4.value2, _this4.value3);
                };

                rightHandle.onPointerDown = function (e) {
                    console.log('rightHanlde on pointer down', e);
                    tracker.startX = e.screenX;
                    tracker.rightBarStartWidth = rightBar.getElemWidth();
                    tracker.middleBarStartWidth = middleBar.getElemWidth();
                    tracker.handleStartPos = rightHandle.getPosition();
                    tracker.pointerDown = true;
                };

                rightHandle.onPointerMove = function (e) {
                    if (!tracker.pointerDown) return;

                    var currentX = e.screenX;
                    var delta = tracker.startX - currentX;

                    var middleBarWidth = tracker.middleBarStartWidth - delta;
                    var rightBarWidth = tracker.rightBarStartWidth + delta;
                    if (middleBarWidth < 0) {
                        // right handle is next to the left handle
                        if (middleBar.getElemWidth() > 0) {
                            rightHandle.setPosition(_this4.totalWidth - leftBar.getElemWidth());
                            middleBar.setElemWidth(0);
                            rightBar.setElemWidth(_this4.totalWidth - leftBar.getElemWidth());

                            updateValues();
                        }
                    } else if (rightBarWidth < 0) {
                        // Right handle is at the very right
                        if (rightHandle.getPosition() > 0) {
                            rightHandle.setPosition(0);
                            rightBar.setElemWidth(0);
                            middleBar.setElemWidth(_this4.totalWidth - leftBar.getElemWidth());

                            updateValues();
                        }
                    } else {
                        rightHandle.setPosition(tracker.handleStartPos + delta);
                        rightBar.setElemWidth(tracker.rightBarStartWidth + delta);
                        middleBar.setElemWidth(tracker.middleBarStartWidth - delta);

                        updateValues();
                    }
                    console.log('values: ', leftBar.value, middleBar.value, rightBar.value);
                };

                rightHandle.onPointerUp = function (e) {
                    console.log('rightHanlde on pointer up', e);
                    tracker.pointerDown = false;
                };
            }
        }, {
            key: 'trackLeftHandle',
            value: function trackLeftHandle() {
                var _this5 = this;

                var leftHandle = this.leftHandle,
                    leftBar = this.leftBar,
                    middleBar = this.middleBar,
                    rightBar = this.rightBar;


                var tracker = {
                    pointerDown: false,
                    startX: 0,
                    leftBarStartWidth: 0,
                    middleBarStartWidth: 0,
                    handleStartPos: 0
                };

                var updateValues = function updateValues() {
                    var totalValue = _this5.totalValue,
                        value3 = _this5.value3;
                    // Value calculated based on leftBar delta

                    var newValue1 = _this5.getValueByWidth(leftBar.getElemWidth());
                    var newValue2 = totalValue - newValue1 - value3;

                    _this5.value1 = newValue1;
                    _this5.value2 = newValue2;

                    _this5.legend.updateValues(_this5.value1, _this5.value2, _this5.value3);
                };

                leftHandle.onPointerDown = function (e) {
                    console.log('leftHandle on pointer down', e);
                    tracker.startX = e.screenX;
                    tracker.leftBarStartWidth = leftBar.getElemWidth();
                    tracker.middleBarStartWidth = middleBar.getElemWidth();
                    tracker.handleStartPos = leftHandle.getPosition();
                    tracker.pointerDown = true;
                    console.log('tracker ', tracker);
                };

                leftHandle.onPointerMove = function (e) {
                    if (!tracker.pointerDown) return;

                    var currentX = e.screenX;
                    var delta = currentX - tracker.startX;

                    var middleBarWidth = tracker.middleBarStartWidth - delta;
                    var leftBarWidth = tracker.leftBarStartWidth + delta;
                    if (middleBarWidth < 0) {
                        // Left handle is next to the right handle
                        if (middleBar.getElemWidth() > 0) {
                            leftHandle.setPosition(_this5.totalWidth - rightBar.getElemWidth());
                            middleBar.setElemWidth(0);
                            leftBar.setElemWidth(_this5.totalWidth - rightBar.getElemWidth());

                            updateValues();
                        }
                    } else if (leftBarWidth < 0) {
                        // Left handle is at the very left
                        if (leftHandle.getPosition() > 0) {
                            leftHandle.setPosition(0);
                            leftBar.setElemWidth(0);
                            middleBar.setElemWidth(_this5.totalWidth - rightBar.getElemWidth());

                            updateValues();
                        }
                    } else {
                        leftHandle.setPosition(tracker.handleStartPos + delta);
                        leftBar.setElemWidth(tracker.leftBarStartWidth + delta);
                        middleBar.setElemWidth(tracker.middleBarStartWidth - delta);

                        updateValues();
                    }

                    console.log('values: ', leftBar.value, middleBar.value, rightBar.value);
                };

                leftHandle.onPointerUp = function (e) {
                    console.log('leftHandle on pointer up', e);
                    tracker.pointerDown = false;
                };
            }
        }, {
            key: 'bindEvents',
            value: function bindEvents() {
                var _this6 = this;

                var leftHandle = this.leftHandle,
                    rightHandle = this.rightHandle,
                    leftBar = this.leftBar,
                    middleBar = this.middleBar,
                    rightBar = this.rightBar;


                var updateWidth = _.throttle(function () {
                    var value1 = _this6.value1,
                        value2 = _this6.value2,
                        value3 = _this6.value3;

                    _this6.totalWidth = _this6.getTotalWidth();
                    leftBar.setElemWidth(_this6.getWidthByValue(value1));
                    middleBar.setElemWidth(_this6.getWidthByValue(value2));
                    rightBar.setElemWidth(_this6.getWidthByValue(value3));

                    leftHandle.setPosition(leftBar.getElemWidth());
                    rightHandle.setPosition(rightBar.getElemWidth());
                    console.log('update width to: ', _this6.totalWidth);
                }, 100);
                window.addEventListener('resize', updateWidth);
            }
        }, {
            key: 'getWidthByValue',
            value: function getWidthByValue(value) {
                var totalValue = this.totalValue,
                    totalWidth = this.totalWidth;

                return value / totalValue * totalWidth;
            }
        }, {
            key: 'getValueByWidth',
            value: function getValueByWidth(width) {
                var totalValue = this.totalValue,
                    totalWidth = this.totalWidth;

                return Math.round(width / totalWidth * totalValue);
            }
        }, {
            key: 'getTotalWidth',
            value: function getTotalWidth() {
                var sliderElem = this.sliderElem,
                    leftHandle = this.leftHandle;

                var sliderWidth = parseFloat(sliderElem.offsetWidth);
                var handleWidth = leftHandle.getElemWidth();

                // Exclude padding widths
                var totalWidth = sliderWidth - 2 * handleWidth;
                if (totalWidth < 0) totalWidth = 2 * handleWidth;

                return totalWidth;
            }
        }]);

        return ThreeValueSlider;
    }();

    var slider = new ThreeValueSlider(25, 25, 50, 100); 
    })
</script>
<#--情景设置页面JS： start-->
<script>
$('#myModal_setCondition').on('shown.bs.modal', function () {
    //获取水资源管理参数
    $.get("getWaterPara.do",
        {
            <#--"id" : "${projectId}"-->
            /*"id" : "8120d8fa-8c2a-406c-8860-3334976d322f"*/
        }, function(data) {
            console.log(data);
            var i=0;
            if(data != undefined){
                for(i;i<=data.length;i++){
                    if(data[i].countyId=="0"){
                        document.getElementById("toSituation_up1").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down1").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb1").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur1").value = data[i].surSup;
                        document.getElementById("toSituation_gw1").value = data[i].gwsup;
                        document.getElementById("toSituation_sup1").value = data[i].supWater;
                    }else if(data[i].countyId=="1"){
                        document.getElementById("toSituation_up2").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down2").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb2").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur2").value = data[i].surSup;
                        document.getElementById("toSituation_gw2").value = data[i].gwsup;
                        document.getElementById("toSituation_sup2").value = data[i].supWater;
                    }else if(data[i].countyId=="2"){
                        document.getElementById("toSituation_up3").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down3").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb3").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur3").value = data[i].surSup;
                        document.getElementById("toSituation_gw3").value = data[i].gwsup;
                        document.getElementById("toSituation_sup3").value = data[i].supWater;
                    }else if(data[i].countyId=="620702"){
                        document.getElementById("toSituation_up4").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down4").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb4").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur4").value = data[i].surSup;
                        document.getElementById("toSituation_gw4").value = data[i].gwsup;
                        document.getElementById("toSituation_sup4").value = data[i].supWater;
                    }else if(data[i].countyId=="620723"){
                        document.getElementById("toSituation_up5").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down5").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb5").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur5").value = data[i].surSup;
                        document.getElementById("toSituation_gw5").value = data[i].gwsup;
                        document.getElementById("toSituation_sup5").value = data[i].supWater;
                    }else if(data[i].countyId=="620724"){
                        document.getElementById("toSituation_up6").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down6").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb6").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur6").value = data[i].surSup;
                        document.getElementById("toSituation_gw6").value = data[i].gwsup;
                        document.getElementById("toSituation_sup6").value = data[i].supWater;
                    }else if(data[i].countyId=="152923"){
                        document.getElementById("toSituation_up7").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down7").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb7").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur7").value = data[i].surSup;
                        document.getElementById("toSituation_gw7").value = data[i].gwsup;
                        document.getElementById("toSituation_sup7").value = data[i].supWater;
                    }else if(data[i].countyId=="620921"){
                        document.getElementById("toSituation_up8").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down8").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb8").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur8").value = data[i].surSup;
                        document.getElementById("toSituation_gw8").value = data[i].gwsup;
                        document.getElementById("toSituation_sup8").value = data[i].supWater;
                    }else if(data[i].countyId=="620722"){
                        document.getElementById("toSituation_up9").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down9").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb9").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur9").value = data[i].surSup;
                        document.getElementById("toSituation_gw9").value = data[i].gwsup;
                        document.getElementById("toSituation_sup9").value = data[i].supWater;
                    }else if(data[i].countyId=="620721"){
                        document.getElementById("toSituation_up10").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down10").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb10").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur10").value = data[i].surSup;
                        document.getElementById("toSituation_gw10").value = data[i].gwsup;
                        document.getElementById("toSituation_sup10").value = data[i].supWater;
                    }else if(data[i].countyId=="620902"){
                        document.getElementById("toSituation_up11").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down11").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb11").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur11").value = data[i].surSup;
                        document.getElementById("toSituation_gw11").value = data[i].gwsup;
                        document.getElementById("toSituation_sup11").value = data[i].supWater;
                    }else if(data[i].countyId=="620200"){
                        document.getElementById("toSituation_up12").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down12").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb12").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur12").value = data[i].surSup;
                        document.getElementById("toSituation_gw12").value = data[i].gwsup;
                        document.getElementById("toSituation_sup12").value = data[i].supWater;
                    }else if(data[i].countyId=="632222"){
                        document.getElementById("toSituation_up13").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down13").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb13").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur13").value = data[i].surSup;
                        document.getElementById("toSituation_gw13").value = data[i].gwsup;
                        document.getElementById("toSituation_sup13").value = data[i].supWater;
                    }else{
                        document.getElementById("toSituation_up14").value = data[i].upstreamwater;
                        document.getElementById("toSituation_down14").value = data[i].flowDown;
                        document.getElementById("toSituation_wdb14").value = data[i].waterdistribution;
                        document.getElementById("toSituation_sur14").value = data[i].surSup;
                        document.getElementById("toSituation_gw14").value = data[i].gwsup;
                        document.getElementById("toSituation_sup14").value = data[i].supWater;
                    }

                }
            }
        })
    //获取气候情景参数
    $.get("getClimateScePara.do",
        {
            <#--"id" : "${projectId}"-->
        }, function(data) {
            //console.log(data);
            var i=0;
            if(data != null){
                for(i;i<=data.length;i++){
                    if(data[i].countyId=="0"){
                        document.getElementById("toSituation_rain_inc_1").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_1").value = data[i].tempChange;
                    }else if(data[i].countyId=="1"){
                        document.getElementById("toSituation_rain_inc_2").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_2").value = data[i].tempChange;
                    }else if(data[i].countyId=="2"){
                        document.getElementById("toSituation_rain_inc_3").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_3").value = data[i].tempChange;
                    }else if(data[i].countyId=="620702"){
                        document.getElementById("toSituation_rain_inc_4").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_4").value = data[i].tempChange;
                    }else if(data[i].countyId=="620723"){
                        document.getElementById("toSituation_rain_inc_5").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_5").value = data[i].tempChange;
                    }else if(data[i].countyId=="620724"){
                        document.getElementById("toSituation_rain_inc_6").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_6").value = data[i].tempChange;
                    }else if(data[i].countyId=="152923"){
                        document.getElementById("toSituation_rain_inc_7").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_7").value = data[i].tempChange;
                    }else if(data[i].countyId=="620921"){
                        document.getElementById("toSituation_rain_inc_8").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_8").value = data[i].tempChange;
                    }else if(data[i].countyId=="620722"){
                        document.getElementById("toSituation_rain_inc_9").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_9").value = data[i].tempChange;
                    }else if(data[i].countyId=="620721"){
                        document.getElementById("toSituation_rain_inc_10").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_10").value = data[i].tempChange;
                    }else if(data[i].countyId=="620902"){
                        document.getElementById("toSituation_rain_inc_11").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_11").value = data[i].tempChange;
                    }else if(data[i].countyId=="620200"){
                        document.getElementById("toSituation_rain_inc_12").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_12").value = data[i].tempChange;
                    }else if(data[i].countyId=="632222"){
                        document.getElementById("toSituation_rain_inc_13").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_13").value = data[i].tempChange;
                    }else{
                        document.getElementById("toSituation_rain_inc_14").value = data[i].preChangeR;
                        document.getElementById("toSituation_temp_inc_14").value = data[i].tempChange;
                    }

                }
            }

        })
    //获取社会经济情景参数
    $.get("getSocEcoPara.do",
        {
            <#--"id" : "${projectId}"-->
        }, function(data) {
            console.log(data);
            var i=0;
            if(data != null){
                for(i;i<=data.length;i++){
                    if(data[i].countyId=="0"){
                        document.getElementById("toSituation_licy1").value = data[i].popolicy;
                        document.getElementById("toSituation_arg1").value = data[i].iararg;
                        document.getElementById("toSituation_ind1").value = data[i].iarind;
                        document.getElementById("toSituation_ser1").value = data[i].iarser;
                        document.getElementById("toSituation_urban1").value = data[i].negak;
                    }else if(data[i].countyId=="1"){
                        document.getElementById("toSituation_licy2").value = data[i].popolicy;
                        document.getElementById("toSituation_arg2").value = data[i].iararg;
                        document.getElementById("toSituation_ind2").value = data[i].iarind;
                        document.getElementById("toSituation_ser2").value = data[i].iarser;
                        document.getElementById("toSituation_urban2").value = data[i].negak;
                    }else if(data[i].countyId=="2"){
                        document.getElementById("toSituation_licy3").value = data[i].popolicy;
                        document.getElementById("toSituation_arg3").value = data[i].iararg;
                        document.getElementById("toSituation_ind3").value = data[i].iarind;
                        document.getElementById("toSituation_ser3").value = data[i].iarser;
                        document.getElementById("toSituation_urban3").value = data[i].negak;
                    }else if(data[i].countyId=="620702"){
                        document.getElementById("toSituation_licy4").value = data[i].popolicy;
                        document.getElementById("toSituation_arg4").value = data[i].iararg;
                        document.getElementById("toSituation_ind4").value = data[i].iarind;
                        document.getElementById("toSituation_ser4").value = data[i].iarser;
                        document.getElementById("toSituation_urban4").value = data[i].negak;
                    }else if(data[i].countyId=="620723"){
                        document.getElementById("toSituation_licy5").value = data[i].popolicy;
                        document.getElementById("toSituation_arg5").value = data[i].iararg;
                        document.getElementById("toSituation_ind5").value = data[i].iarind;
                        document.getElementById("toSituation_ser5").value = data[i].iarser;
                        document.getElementById("toSituation_urban5").value = data[i].negak;
                    }else if(data[i].countyId=="620724"){
                        document.getElementById("toSituation_licy6").value = data[i].popolicy;
                        document.getElementById("toSituation_arg6").value = data[i].iararg;
                        document.getElementById("toSituation_ind6").value = data[i].iarind;
                        document.getElementById("toSituation_ser6").value = data[i].iarser;
                        document.getElementById("toSituation_urban6").value = data[i].negak;
                    }else if(data[i].countyId=="152923"){
                        document.getElementById("toSituation_licy7").value = data[i].popolicy;
                        document.getElementById("toSituation_arg7").value = data[i].iararg;
                        document.getElementById("toSituation_ind7").value = data[i].iarind;
                        document.getElementById("toSituation_ser7").value = data[i].iarser;
                        document.getElementById("toSituation_urban7").value = data[i].negak;
                    }else if(data[i].countyId=="620921"){
                        document.getElementById("toSituation_licy8").value = data[i].popolicy;
                        document.getElementById("toSituation_arg8").value = data[i].iararg;
                        document.getElementById("toSituation_ind8").value = data[i].iarind;
                        document.getElementById("toSituation_ser8").value = data[i].iarser;
                        document.getElementById("toSituation_urban8").value = data[i].negak;
                    }else if(data[i].countyId=="620722"){
                        document.getElementById("toSituation_licy9").value = data[i].popolicy;
                        document.getElementById("toSituation_arg9").value = data[i].iararg;
                        document.getElementById("toSituation_ind9").value = data[i].iarind;
                        document.getElementById("toSituation_ser9").value = data[i].iarser;
                        document.getElementById("toSituation_urban9").value = data[i].negak;
                    }else if(data[i].countyId=="620721"){
                        document.getElementById("toSituation_licy10").value = data[i].popolicy;
                        document.getElementById("toSituation_arg10").value = data[i].iararg;
                        document.getElementById("toSituation_ind10").value = data[i].iarind;
                        document.getElementById("toSituation_ser10").value = data[i].iarser;
                        document.getElementById("toSituation_urban10").value = data[i].negak;
                    }else if(data[i].countyId=="620902"){
                        document.getElementById("toSituation_licy11").value = data[i].popolicy;
                        document.getElementById("toSituation_arg11").value = data[i].iararg;
                        document.getElementById("toSituation_ind11").value = data[i].iarind;
                        document.getElementById("toSituation_ser11").value = data[i].iarser;
                        document.getElementById("toSituation_urban11").value = data[i].negak;
                    }else if(data[i].countyId=="620200"){
                        document.getElementById("toSituation_licy12").value = data[i].popolicy;
                        document.getElementById("toSituation_arg12").value = data[i].iararg;
                        document.getElementById("toSituation_ind12").value = data[i].iarind;
                        document.getElementById("toSituation_ser12").value = data[i].iarser;
                        document.getElementById("toSituation_urban12").value = data[i].negak;
                    }else if(data[i].countyId=="632222"){
                        document.getElementById("toSituation_licy13").value = data[i].popolicy;
                        document.getElementById("toSituation_arg13").value = data[i].iararg;
                        document.getElementById("toSituation_ind13").value = data[i].iarind;
                        document.getElementById("toSituation_ser13").value = data[i].iarser;
                        document.getElementById("toSituation_urban13").value = data[i].negak;
                    }else{
                        document.getElementById("toSituation_licy14").value = data[i].popolicy;
                        document.getElementById("toSituation_arg14").value = data[i].iararg;
                        document.getElementById("toSituation_ind14").value = data[i].iarind;
                        document.getElementById("toSituation_ser14").value = data[i].iarser;
                        document.getElementById("toSituation_urban14").value = data[i].negak;
                    }

                }
            }

        })
    //获取土地利用参数
    $.get("getLandUseScePara.do",
        {
            <#--"id" : "${projectId}"-->
        }, function(data) {
            console.log(data);

            var i=0;
            if(data != null){
                for(i;i<=data.length;i++){
                    if(data[i].countyId=="0"){
                        document.getElementById("toSituation_form1").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest1").value = data[i].landForestR;
                        document.getElementById("toSituation_grass1").value = data[i].landGrassR;
                        document.getElementById("toSituation_water1").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare1").value = data[i].landBareR;
                        //document.getElementById("toSituation_city1").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh1").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn1").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil1").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg1").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft1").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot1").value = data[i].cpcotR;
                    }else if(data[i].countyId=="1"){
                        document.getElementById("toSituation_form2").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest2").value = data[i].landForestR;
                        document.getElementById("toSituation_grass2").value = data[i].landGrassR;
                        document.getElementById("toSituation_water2").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare2").value = data[i].landBareR;
                        //document.getElementById("toSituation_city2").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh2").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn2").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil2").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg2").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft2").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot2").value = data[i].cpcotR;
                    }else if(data[i].countyId=="2"){
                        document.getElementById("toSituation_form3").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest3").value = data[i].landForestR;
                        document.getElementById("toSituation_grass3").value = data[i].landGrassR;
                        document.getElementById("toSituation_water3").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare3").value = data[i].landBareR;
                        //document.getElementById("toSituation_city3").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh3").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn3").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil3").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg3").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft3").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot3").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620702"){
                        document.getElementById("toSituation_form4").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest4").value = data[i].landForestR;
                        document.getElementById("toSituation_grass4").value = data[i].landGrassR;
                        document.getElementById("toSituation_water4").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare4").value = data[i].landBareR;
                        //document.getElementById("toSituation_city4").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh4").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn4").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil4").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg4").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft4").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot4").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620723"){
                        document.getElementById("toSituation_form5").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest5").value = data[i].landForestR;
                        document.getElementById("toSituation_grass5").value = data[i].landGrassR;
                        document.getElementById("toSituation_water5").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare5").value = data[i].landBareR;
                        //document.getElementById("toSituation_city5").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh5").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn5").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil5").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg5").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft5").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot5").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620724"){
                        document.getElementById("toSituation_form6").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest6").value = data[i].landForestR;
                        document.getElementById("toSituation_grass6").value = data[i].landGrassR;
                        document.getElementById("toSituation_water6").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare6").value = data[i].landBareR;
                        //document.getElementById("toSituation_city6").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh6").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn6").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil6").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg6").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft6").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot6").value = data[i].cpcotR;
                    }else if(data[i].countyId=="152923"){
                        document.getElementById("toSituation_form7").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest7").value = data[i].landForestR;
                        document.getElementById("toSituation_grass7").value = data[i].landGrassR;
                        document.getElementById("toSituation_water7").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare7").value = data[i].landBareR;
                        //document.getElementById("toSituation_city7").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh7").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn7").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil7").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg7").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft7").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot7").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620921"){
                        document.getElementById("toSituation_form8").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest8").value = data[i].landForestR;
                        document.getElementById("toSituation_grass8").value = data[i].landGrassR;
                        document.getElementById("toSituation_water8").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare8").value = data[i].landBareR;
                        //document.getElementById("toSituation_city8").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh8").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn8").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil8").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg8").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft8").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot8").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620722"){
                        document.getElementById("toSituation_form9").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest9").value = data[i].landForestR;
                        document.getElementById("toSituation_grass9").value = data[i].landGrassR;
                        document.getElementById("toSituation_water9").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare9").value = data[i].landBareR;
                        //document.getElementById("toSituation_city9").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh9").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn9").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil9").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg9").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft9").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot9").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620721"){
                        document.getElementById("toSituation_form10").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest10").value = data[i].landForestR;
                        document.getElementById("toSituation_grass10").value = data[i].landGrassR;
                        document.getElementById("toSituation_water10").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare10").value = data[i].landBareR;
                        //document.getElementById("toSituation_city10").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh10").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn10").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil10").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg10").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft10").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot10").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620902"){
                        document.getElementById("toSituation_form11").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest11").value = data[i].landForestR;
                        document.getElementById("toSituation_grass11").value = data[i].landGrassR;
                        document.getElementById("toSituation_water11").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare11").value = data[i].landBareR;
                        //document.getElementById("toSituation_city11").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh11").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn11").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil11").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg11").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft11").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot11").value = data[i].cpcotR;
                    }else if(data[i].countyId=="620200"){
                        document.getElementById("toSituation_form12").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest12").value = data[i].landForestR;
                        document.getElementById("toSituation_grass12").value = data[i].landGrassR;
                        document.getElementById("toSituation_water12").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare12").value = data[i].landBareR;
                        //document.getElementById("toSituation_city12").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh12").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn12").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil12").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg12").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft12").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot12").value = data[i].cpcotR;
                    }else if(data[i].countyId=="632222"){
                        document.getElementById("toSituation_form13").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest13").value = data[i].landForestR;
                        document.getElementById("toSituation_grass13").value = data[i].landGrassR;
                        document.getElementById("toSituation_water13").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare13").value = data[i].landBareR;
                        //document.getElementById("toSituation_city13").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh13").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn13").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil13").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg13").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft13").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot13").value = data[i].cpcotR;
                    }else{
                        document.getElementById("toSituation_form14").value = data[i].landFarmR;
                        document.getElementById("toSituation_forest14").value = data[i].landForestR;
                        document.getElementById("toSituation_grass14").value = data[i].landGrassR;
                        document.getElementById("toSituation_water14").value = data[i].waterArea;
                        //document.getElementById("toSituation_bare14").value = data[i].landBareR;
                        //document.getElementById("toSituation_city14").value = data[i].landCityR;
                        //document.getElementById("toSituation_wh14").value = data[i].cpwhR;
                        //document.getElementById("toSituation_corn14").value = data[i].cpcornR;
                        //document.getElementById("toSituation_oil14").value = data[i].cpoilR;
                        //document.getElementById("toSituation_veg14").value = data[i].cpvegR;
                        //document.getElementById("toSituation_ft14").value = data[i].cpftr;
                        //document.getElementById("toSituation_cot14").value = data[i].cpcotR;
                    }

                }
            }

        })
        $(function() {
            //页面初始化以后加载图表：气候情景温度变化图
            showFigure_1();
            //气候情景：降水变化图
            showFigure_2();
            //土地利用情景中的耕地面积变化图表
            // land_show_1();
            //土地类型中不同土地类型面积变化
            // land_show_2();
            //水资源管理情景中的用水量变化
            showArea_usingng_water();
            //人口比例变化
            quchang_show_1();

            //滑过保存按钮，提示保存
            $("body").on("mouseover",".admin-card-title button",function(){
                var that = this;
                layer.tips('${clicksave}', that,{time:1000});
            })
            //保存
            $("body").on("click",".admin-card-title button",function(){
                var load=parent.layer.load('',{shade:[0.3,"#000"]});
                setTimeout(function(){
                    //关闭加载
                    parent.layer.close(load);
                    parent.layer.msg('${savesuccess}',{time:1000});
                },2000)
            })

        });
    $("#selectCounty_climate").on("change", function() {
        showFigure_1();
        showFigure_2();
    });
    //气候情景降水变化图
    function showFigure_1() {
        $.get("getClimateScenarioByUsername.do",
                {
                    "countyId" : document.getElementById("selectCounty_climate").value
                },
            //"geTblClimateScenarioYearsByfldCRPType.do",//watershedController.java
            //{
            //"fldCRPType" : "8.5",
            //"countryId" : document.getElementById("selectCounty_climate").value,
            //},
            function(data){
                console.log(data.length);
            var xdata=[],UpRainUpper=[],UpRainULower=[],
            MidRainUpper=[],MidRainLower=[],
            DownRainUpper=[],DownRainLower=[];
            for(var i=0; i<data.length; i++)
                {
                xdata[i]=data[i].fldYear;
                UpRainUpper[i]=data[i].upRainUpper;
                UpRainULower[i]=data[i].upRainULower;
                MidRainUpper[i]=data[i].midRainUpper;
                MidRainLower[i]=data[i].midRainLower;
                DownRainUpper[i]=data[i].downRainUpper;
                DownRainLower[i]=data[i].downRainLower;
                }
            if (data.length>=1){
            //var titletext=data[0].fldYear+'~'+data[data.length-1].fldYear+'${Curveofprecipitation}'; //' ${temcurve}';
            }
            var Chart = echarts.init(document.getElementById('showArea-1'));
            var option = {
                    title: {
                        text: '${Curveofprecipitation}',
                        x: 'center',
                        y: 'top',
                        textStyle: {
                            fontSize: 14,
                            fontWeight: 'bold',
                            color: '#333' // 主标题文字颜色
                        },
                    },
            tooltip : {
                trigger : 'axis',
            },
            legend : {
                data : [ '${UpRainUpper}', '${UpRainULower}', '${MidRainUpper}',
                    '${MidRainLower}','${DownRainUpper}','${DownRainLower}'],
                x: 'center',
                padding: [25,5,5,5]
            },
            grid : {
                left : '5%',
                right : '1%',
                containLabel : true
            },
            toolbox : {
                show : true,
                feature : {
                    saveAsImage : {show: true}
                }
            },
            xAxis : {
                type : 'category',
                boundaryGap : false,
                data : xdata,
                name : '${year}'
                /*nameLocation:'middle',
                nameTextStyle: {
                    fontWeight:'normal',
                        fontSize:20,
                        padding: [-10,0,0,0]

                }*/
            },
            yAxis : {
                type : 'value',
//					axisLabel : {
//              		formatter: '{value} °C'
//          	},
                name : '${Precipitation}'
                /*nameLocation:'middle',
                nameTextStyle: {
                    fontWeight:'normal',
                        fontSize:20,
                        padding: [0,0,-10,0]

                }*/
            },
            series : [ {
                name : '${UpRainUpper}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : UpRainUpper
            }, {
                name : '${UpRainULower}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : UpRainULower
            }, {
                name : '${MidRainUpper}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : MidRainUpper
            } , {
                name : '${MidRainLower}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : MidRainLower
            } , {
                name : '${DownRainUpper}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : DownRainUpper
            } , {
                name : '${DownRainLower}',
                type : 'line',
                itemStyle : {  
                    normal : {  
                        lineStyle:{  
                            width:4
                        }  
                    }  
                },   
                data : DownRainLower
            } ]
        };
        Chart.setOption(option);
    })}
    
    //气候情景：温度变化图
    function showFigure_2() {
        
            $.get("getClimateScenarioByUsername.do",
                    {
                        "countyId" : document.getElementById("selectCounty_climate").value
                    },
                //"geTblClimateScenarioYearsByfldCRPType.do",//watershedController.java
                //{
                //"fldCRPType" : "8.5",
                //"countryId" : document.getElementById("selectCounty_climate").value,
                //},
                function(data){
                    console.log(data.length);
                var xdata=[],UpTempUpper=[],UpTempULower=[],
                MidTempUpper=[],MidTempLower=[],
                DownTempUpper=[],DownTempLower=[];
                for(var i=0; i<data.length; i++)
                    {
                    xdata[i]=data[i].fldYear;
                    UpTempUpper[i]=data[i].upTempUpper;
                    UpTempULower[i]=data[i].upTempULower;
                    MidTempUpper[i]=data[i].midTempUpper;
                    MidTempLower[i]=data[i].midTempLower;
                    DownTempUpper[i]=data[i].downTempUpper;
                    DownTempLower[i]=data[i].downTempLower;
                    }
                if (data.length>=1){
                //var titletext=data[0].fldYear+'~'+data[data.length-1].fldYear+'${Curveofprecipitation}'; //' ${temcurve}';
                }
                var Chart = echarts.init(document.getElementById('showArea-2'));
                var option = {
                        title: {
                            text: '${temcurve}',
                            x: 'center',
                            y: 'top',
                            textStyle: {
                                fontSize: 14,
                                fontWeight: 'bold',
                                color: '#333' // 主标题文字颜色
                            },
                        },
                tooltip : {
                    trigger : 'axis',
                },
                legend : {
                    data : [ '${UpTempUpper}', '${UpTempULower}', '${MidTempUpper}',
                        '${MidTempLower}','${DownTempUpper}','${DownTempLower}'],
                    x: 'center',
                    padding: [25,5,5,5]
                },
                grid : {
                    left : '5%',
                    right : '1%',
                    containLabel : true
                },
                toolbox : {
                    show : true,
                    feature : {
                        saveAsImage : {show: true}
                    }
                },
                xAxis : {
                    type : 'category',
                    boundaryGap : false,
                    data : xdata,
                    name : '${year}'
                    /*nameLocation:'middle',
                    nameTextStyle: {
                        fontWeight:'normal',
                            fontSize:20,
                            padding: [-10,0,0,0]

                    }*/
                },
                yAxis : {
                    type : 'value',
//					axisLabel : {
//              		formatter: '{value} °C'
//          	},
                    name : '${tem}'
                    /*nameLocation:'middle',
                    nameTextStyle: {
                        fontWeight:'normal',
                            fontSize:20,
                            padding: [0,0,-10,0]

                    }*/
                },
                series : [ {
                    name : '${UpTempUpper}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : UpTempUpper
                }, {
                    name : '${UpTempULower}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : UpTempULower
                }, {
                    name : '${MidTempUpper}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : MidTempUpper
                } , {
                    name : '${MidTempLower}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : MidTempLower
                } , {
                    name : '${DownTempUpper}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : DownTempUpper
                } , {
                    name : '${DownTempLower}',
                    type : 'line',
                    itemStyle : {  
                        normal : {  
                            lineStyle:{  
                                width:4
                            }  
                        }  
                    },   
                    data : DownTempLower
                } ]
            };
            Chart.setOption(option);
        })

            <#--$.get("geTblClimateScenarioYearsByfldCRPType.do",-->
                <#--{-->
                <#--"fldCRPType":"8.5",-->
                <#--"countryId" : document.getElementById("selectCounty_climate").value,-->
                <#--},-->
                    <#--function(data){-->
                    <#--var xdata=[],averagePrecip=[];-->
                    <#--for(var i=0; i<data.length; i++)-->
                        <#--{-->
                        <#--xdata[i]=data[i].fldDate;-->
                        <#--averagePrecip[i]=data[i].fldPrecipitation;-->
                        <#--}-->
                    <#--if (data.length>=1){-->
                    <#--var titletext=data[0].fldDate+'~'+data[data.length-1].fldDate+' ${Curveofprecipitation}';-->
                    <#--}-->
                <#--var Chart = echarts.init(document.getElementById('showArea-2'));-->
                <#--var option = {-->
                        <#--title: {-->
                            <#--text: titletext,-->
                            <#--x: 'center',-->
                            <#--y: 'top',-->
                            <#--textStyle: {-->
                                <#--fontSize: 14,-->
                                <#--fontWeight: 'bold',-->
                                <#--color: '#333' // 主标题文字颜色-->
                            <#--},-->
                        <#--},-->
                <#--tooltip : {-->
                    <#--trigger : 'axis'-->
                <#--},-->
                <#--legend : {-->
                    <#--data : [ '${AveragePrecipitation}', -->
                                <#--],-->
                    <#--x: 'center',-->
                    <#--padding: [25,5,5,5]-->
                <#--},-->
                <#--grid : {-->
                    <#--left : '5%',-->
                    <#--right : '1%',-->
                    <#--containLabel : true-->
                <#--},-->
                <#--toolbox : {-->
                    <#--show: true,-->
                    <#--feature : {-->
                        <#--saveAsImage : {show: true}-->
                    <#--}-->
                <#--},-->
                <#--xAxis : {-->
                    <#--type : 'category',-->
                    <#--boundaryGap : false,-->
                    <#--name : '${year}',-->
                    <#--data : xdata-->
                <#--},-->
                <#--yAxis : {-->
                    <#--type : 'value',-->
                    <#--name : '${Precipitation}(mm)'-->
                <#--},-->
                <#--series : [ {-->
                    <#--name : '${AveragePrecipitation}',-->
                    <#--type : 'line',-->
                    <#--itemStyle : {  -->
                        <#--normal : {  -->
                            <#--lineStyle:{  -->
                                <#--width:4-->
                            <#--}  -->
                        <#--}  -->
                    <#--},   -->
                    <#--data : averagePrecip-->
<#--// 				-->
                <#--} ]-->
            <#--};-->
            <#--Chart.setOption(option);-->
            <#--}) -->
        }
    $("#selectCounty_land").on("change", function() {
        land_show_1();
        land_show_2();
    });
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
    
    
    //水资源管理情景中的用水量变化
    function showArea_usingng_water() {
    $.get('getTblMidDownWaterAllo.do',
            [],
            function(data){
        var xdata=[], fldWaterUseMid=[], fldWaterUseDown=[];
        for(var i=0; i<data.length; i++)
        {
            xdata[i]=data[i].fldDate;
            fldWaterUseMid[i]=data[i].fldWaterUseMid/100000000;
            fldWaterUseDown[i]=data[i].fldWaterUseDown/100000000;
        }
        if (data.length>=1){
        var titletext=data[0].fldDate+'~'+data[data.length-1].fldDate+'${usingwater}';
        }
    var Chart = echarts.init(document.getElementById('using-water'));
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
            data : [ '${MWV}', '${DWV}' ],
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
            name : '${WC}',
        },
        series : [ {
            name : '${MWV}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            }, 
            data : fldWaterUseMid
        }, {
            name : '${DWV}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            }, 
            data : fldWaterUseDown
        
        } ]
    };
    Chart.setOption(option);
    })};
    
    $("#selectCounty_quchang").on("change", function() {
        quchang_show_1();
    });
    //人口比例变化
    function quchang_show_1() {
    $.get('getTblHydrEngineeringByfldCountyCode.do',
            {fldCountyCode:$("#selectCounty_quchang").val()},
            function(data){
        var xdata=[], fldMainCanWUE=[], fldBranCanWUE=[], fldDouWUE=[], fldNongWUE=[], fldMaoWUE=[], fldSprWUE=[], fldDropWUE=[];
        //            干渠利用率                               支渠利用率                              斗渠利用率                    农渠利用率			毛渠利用率			喷灌用水效率	滴灌用水效率
        for(var i=0; i<data.length; i++)
        {
            xdata[i]=data[i].fldDate;
            fldMainCanWUE[i]=data[i].fldMainCanWUE;
            fldBranCanWUE[i]=data[i].fldBranCanWUE;
            fldDouWUE[i]=data[i].fldDouWUE;
            fldNongWUE[i]=data[i].fldNongWUE;
            fldMaoWUE[i]=data[i].fldMaoWUE;
            fldSprWUE[i]=data[i].fldSprWUE;
            fldDropWUE[i]=data[i].fldDropWUE;
        }
    if (data.length>=1){
    var titletext=data[0].fldDate+'~'+data[data.length-1].fldDate+'${showArea5}';	
    }
    var Chart = echarts.init(document.getElementById('showArea-5'));
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
            data : [ '${Main}', '${Branch}', '${Ditch}', '${Agricultural}', '${Gross}', '${Sprinkler}', '${Drip}' ],
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
            name : '${userate}',
        },
        series : [ {
            name : '${Main}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldMainCanWUE
        }, {
            name : '${Branch}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldBranCanWUE
        }, {
            name : '${Ditch}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldDouWUE
        }, {
            name : '${Agricultural}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldNongWUE
        }, {
            name : '${Gross}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldMaoWUE
        }, {
            name : '${Sprinkler}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldSprWUE
        }, {
            name : '${Drip}',
            type : 'line',
            itemStyle : {  
                normal : {  
                    lineStyle:{  
                        width:4
                    }  
                }  
            },   
            data : fldDropWUE
        } ]
    };
    Chart.setOption(option);
    })}

})
</script>
<#--情景设置页面JS： end-->
<#--情景模拟页面JS： start-->
<script type="text/javascript">
    $('#myModal_result').on('shown.bs.modal', function () {
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
        function getDataYearlyAsList(years){
                $("#jumpToResult_resultTable").find("tbody").empty()
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
        queryAvailable()
                //土地利用情景中的耕地面积变化图表
        land_show_1();
        //土地类型中不同土地类型面积变化
        land_show_2();
        $.get("getClimateScePara.do",
            {
                <#--"id" : "${projectId}"-->
            }, function(data) {
                console.log(data);
                var i=0;
                if(data != null){
                    for(i;i<=data.length;i++){
                        if(data[i].countyId=="0"){
                            document.getElementById("jumpToResult_rain_inc_1").innerHTML=data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_1").innerHTML=data[i].tempChange;
                        }else if(data[i].countyId=="1"){
                            document.getElementById("jumpToResult_rain_inc_2").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_2").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="2"){
                            document.getElementById("jumpToResult_rain_inc_3").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_3").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620702"){
                            document.getElementById("jumpToResult_rain_inc_4").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_4").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620723"){
                            document.getElementById("jumpToResult_rain_inc_5").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_5").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620724"){
                            document.getElementById("jumpToResult_rain_inc_6").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_6").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="152923"){
                            document.getElementById("jumpToResult_rain_inc_7").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_7").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620921"){
                            document.getElementById("jumpToResult_rain_inc_8").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_8").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620722"){
                            document.getElementById("jumpToResult_rain_inc_9").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_9").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620721"){
                            document.getElementById("jumpToResult_rain_inc_10").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_10").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620902"){
                            document.getElementById("jumpToResult_rain_inc_11").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_11").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="620200"){
                            document.getElementById("jumpToResult_rain_inc_12").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_12").innerHTML = data[i].tempChange;
                        }else if(data[i].countyId=="632222"){
                            document.getElementById("jumpToResult_rain_inc_13").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_13").innerHTML = data[i].tempChange;
                        }else{
                            document.getElementById("jumpToResult_rain_inc_14").innerHTML = data[i].preChangeR;
                            document.getElementById("jumpToResult_temp_inc_14").innerHTML = data[i].tempChange;
                        }

                    }
                }

            })
        //获取土地利用参数
        $.get("getLandUseScePara.do",
            {
                <#--"id" : "${projectId}"-->
            }, function(data) {
                console.log(data);

                var i=0;
                if(data != null){
                    for(i;i<=data.length;i++){
                        if(data[i].countyId=="0"){
                            document.getElementById("jumpToResult_form1").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest1").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass1").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water1").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare1").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city1").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh1").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn1").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil1").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg1").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft1").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot1").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="1"){
                            document.getElementById("jumpToResult_form2").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest2").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass2").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water2").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare2").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city2").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh2").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn2").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil2").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg2").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft2").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot2").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="2"){
                            document.getElementById("jumpToResult_form3").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest3").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass3").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water3").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare3").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city3").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh3").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn3").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil3").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg3").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft3").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot3").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620702"){
                            document.getElementById("jumpToResult_form4").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest4").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass4").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water4").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare4").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city4").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh4").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn4").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil4").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg4").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft4").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot4").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620723"){
                            document.getElementById("jumpToResult_form5").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest5").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass5").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water5").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare5").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city5").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh5").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn5").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil5").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg5").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft5").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot5").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620724"){
                            document.getElementById("jumpToResult_form6").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest6").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass6").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water6").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare6").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city6").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh6").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn6").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil6").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg6").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft6").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot6").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="152923"){
                            document.getElementById("jumpToResult_form7").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest7").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass7").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water7").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare7").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city7").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh7").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn7").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil7").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg7").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft7").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot7").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620921"){
                            document.getElementById("jumpToResult_form8").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest8").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass8").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water8").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare8").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city8").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh8").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn8").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil8").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg8").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft8").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot8").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620722"){
                            document.getElementById("jumpToResult_form9").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest9").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass9").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water9").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare9").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city9").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh9").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn9").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil9").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg9").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft9").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot9").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620721"){
                            document.getElementById("jumpToResult_form10").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest10").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass10").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water10").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare10").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city10").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh10").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn10").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil10").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg10").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft10").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot10").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620902"){
                            document.getElementById("jumpToResult_form11").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest11").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass11").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water11").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare11").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city11").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh11").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn11").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil11").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg11").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft11").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot11").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="620200"){
                            document.getElementById("jumpToResult_form12").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest12").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass12").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water12").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare12").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city12").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh12").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn12").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil12").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg12").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft12").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot12").innerHTML = data[i].cpcotR;
                        }else if(data[i].countyId=="632222"){
                            document.getElementById("jumpToResult_form13").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest13").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass13").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water13").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare13").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city13").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh13").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn13").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil13").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg13").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft13").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot13").innerHTML = data[i].cpcotR;
                        }else{
                            document.getElementById("jumpToResult_form14").innerHTML = data[i].landFarmR;
                            document.getElementById("jumpToResult_forest14").innerHTML = data[i].landForestR;
                            document.getElementById("jumpToResult_grass14").innerHTML = data[i].landGrassR;
                            document.getElementById("jumpToResult_water14").innerHTML = data[i].waterArea;
                            //document.getElementById("jumpToResult_bare14").innerHTML = data[i].landBareR;
                            //document.getElementById("jumpToResult_city14").innerHTML = data[i].landCityR;
                            //document.getElementById("jumpToResult_wh14").innerHTML = data[i].cpwhR;
                            //document.getElementById("jumpToResult_corn14").innerHTML = data[i].cpcornR;
                            //document.getElementById("jumpToResult_oil14").innerHTML = data[i].cpoilR;
                            //document.getElementById("jumpToResult_veg14").innerHTML = data[i].cpvegR;
                            //document.getElementById("jumpToResult_ft14").innerHTML = data[i].cpftr;
                            //document.getElementById("jumpToResult_cot14").innerHTML = data[i].cpcotR;
                        }

                    }
                }

            })
        //获取社会经济情景参数
        $.get("getSocEcoPara.do",
            {
                <#--"id" : "${projectId}"-->
            }, function(data) {
                console.log(data);
                var i=0;
                if(data != null){
                    for(i;i<=data.length;i++){
                        if(data[i].countyId=="0"){
                            document.getElementById("jumpToResult_licy1").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg1").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind1").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser1").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar1").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="1"){
                            document.getElementById("jumpToResult_licy2").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg2").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind2").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser2").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar2").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="2"){
                            document.getElementById("jumpToResult_licy3").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg3").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind3").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser3").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar3").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620702"){
                            document.getElementById("jumpToResult_licy4").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg4").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind4").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser4").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar4").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620723"){
                            document.getElementById("jumpToResult_licy5").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg5").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind5").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser5").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar5").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620724"){
                            document.getElementById("jumpToResult_licy6").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg6").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind6").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser6").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar6").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="152923"){
                            document.getElementById("jumpToResult_licy7").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg7").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind7").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser7").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar7").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620921"){
                            document.getElementById("jumpToResult_licy8").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg8").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind8").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser8").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar8").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620722"){
                            document.getElementById("jumpToResult_licy9").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg9").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind9").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser9").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar9").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620721"){
                            document.getElementById("jumpToResult_licy10").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg10").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind10").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser10").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar10").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620902"){
                            document.getElementById("jumpToResult_licy11").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg11").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind11").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser11").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar11").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="620200"){
                            document.getElementById("jumpToResult_licy12").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg12").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind12").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser12").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar12").innerHTML = data[i].negak;
                        }else if(data[i].countyId=="632222"){
                            document.getElementById("jumpToResult_licy13").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg13").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind13").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser13").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar13").innerHTML = data[i].negak;
                        }else{
                            document.getElementById("jumpToResult_licy14").innerHTML = data[i].popolicy;
                            document.getElementById("jumpToResult_arg14").innerHTML = data[i].iararg;
                            document.getElementById("jumpToResult_ind14").innerHTML = data[i].iarind;
                            document.getElementById("jumpToResult_ser14").innerHTML = data[i].iarser;
                            document.getElementById("jumpToResult_urpar14").innerHTML = data[i].negak;
                        }

                    }
                }

            })
        //获取水资源管理参数
        $.get("getWaterPara.do",
            {
                <#--"id" : "${projectId}"-->
            }, function(data) {
                console.log(data);
                var i=0;
                if(data != null){
                    for(i;i<=data.length;i++){
                        if(data[i].countyId=="0"){
                            // document.getElementById("jumpToResult_up1").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down1").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb1").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur1").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw1").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup1").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="1"){
                            //document.getElementById("jumpToResult_up2").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down2").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb2").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur2").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw2").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup2").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="2"){
                            //document.getElementById("jumpToResult_up3").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down3").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb3").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur3").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw3").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup3").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620702"){
                            //document.getElementById("jumpToResult_up4").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down4").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb4").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur4").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw4").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup4").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620723"){
                            //document.getElementById("jumpToResult_up5").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down5").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb5").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur5").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw5").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup5").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620724"){
                            //document.getElementById("jumpToResult_up6").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down6").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb6").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur6").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw6").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup6").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="152923"){
                            //document.getElementById("jumpToResult_up7").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down7").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb7").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur7").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw7").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup7").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620921"){
                            //document.getElementById("jumpToResult_up8").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down8").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb8").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur8").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw8").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup8").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620722"){
                            //document.getElementById("jumpToResult_up9").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down9").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb9").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur9").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw9").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup9").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620721"){
                            //document.getElementById("jumpToResult_up10").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down10").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb10").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur10").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw10").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup10").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620902"){
                            //document.getElementById("jumpToResult_up11").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down11").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb11").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur11").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw11").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup11").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="620200"){
                            //document.getElementById("jumpToResult_up12").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down12").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb12").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur12").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw12").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup12").innerHTML = data[i].supWater;
                        }else if(data[i].countyId=="632222"){
                            //document.getElementById("jumpToResult_up13").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down13").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb13").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur13").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw13").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup13").innerHTML = data[i].supWater;
                        }else{
                            //document.getElementById("jumpToResult_up14").innerHTML = data[i].upstreamwater;
                            document.getElementById("jumpToResult_down14").innerHTML = data[i].flowDown;
                            document.getElementById("jumpToResult_wdb14").innerHTML = data[i].waterdistribution;
                            document.getElementById("jumpToResult_sur14").innerHTML = data[i].surSup;
                            document.getElementById("jumpToResult_gw14").innerHTML = data[i].gwsup;
                            document.getElementById("jumpToResult_sup14").innerHTML = data[i].supWater;
                        }

                    }
                }
            })
    })
    //获取气候情景参数
</script>
<script>
    function updateProject() {
        $('#updateProject').ajaxSubmit( {
            url : "updateProject.do",
            success: function(data) {
                alert("success!")
                window.location.reload()
            }
        });
        return false;
    }
</script>
<#--情景模拟页面JS： end-->
</body>
</html>
