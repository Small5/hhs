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
    <script type="text/javascript" src="goal/js/jquery-1.7.2.js"></script>
</head>
<style>
    /*.body {*/
    /*display: -webkit-box;*/
    /*display: -moz-box;*/
    /*display: -webkit-flex;*/
    /*display: -ms-flexbox;*/
    /*display: box;*/
    /*display: flex;*/
    /*-webkit-box-orient: vertical;*/
    /*-moz-box-orient: vertical;*/
    /*-o-box-orient: vertical;*/
    /*-webkit-flex-direction: column;*/
    /*-ms-flex-direction: column;*/
    /*flex-direction: column;*/
    /*-webkit-box-pack: center;*/
    /*-moz-box-pack: center;*/
    /*-o-box-pack: center;*/
    /*-ms-flex-pack: center;*/
    /*-webkit-justify-content: center;*/
    /*justify-content: center;*/
    /*-webkit-box-align: center;*/
    /*-moz-box-align: center;*/
    /*-o-box-align: center;*/
    /*-ms-flex-align: center;*/
    /*-webkit-align-items: center;*/
    /*align-items: center;*/
    /*}*/
    #goal_page .container {
        height: 100px;
        display: -webkit-box;
        display: -moz-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: box;
        display: flex;
        -webkit-box-align: center;
        -moz-box-align: center;
        -o-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
        padding: 0px 15%;
        width: 100%;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }
    #goal_page .legend {
        list-style: none;
        display: -webkit-box;
        display: -moz-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: box;
        display: flex;
        -webkit-box-pack: center;
        -moz-box-pack: center;
        -o-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        color: #999;
    }
    #goal_page .legend li {
        margin: 0 10px;
    }
    #goal_page .legend .value-one span,
    #goal_page .legend .value-two span,
    #goal_page .legend .value-three span {
        display: inline-block;
        /* width: 3em; */
        padding-left: 10px;
    }
    #goal_page .legend i {
        display: inline-block;
        width: 10px;
        height: 10px;
    }
    #goal_page .legend .value-one > i {
        background-color: #ff0;
    }
    #goal_page .legend .value-two > i {
        background-color: #ffa500;
    }
    #goal_page .legend .value-three > i {
        background-color: #f00;
    }
    #goal_page .three-value-slider {
        position: relative;
        width: 100%;
        white-space: nowrap;
        display: -webkit-box;
        display: -moz-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: box;
        display: flex;
        -webkit-box-align: center;
        -moz-box-align: center;
        -o-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
        height: 20px;
        margin: 0 25px;
    }
    #goal_page .three-value-slider .slider-handle {
        display: block;
        position: absolute;
        top: 0;
        background-color: #fff;
        height: 20px;
        width: 25px;
        border: 1px solid #888;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        cursor: pointer;
        border-radius: 15px;
        padding: 0 3px;
    }
    #goal_page .three-value-slider .slider-handle.left {
        left: 0;
    }
    #goal_page .three-value-slider .slider-handle.right {
        right: 0;
    }
    #goal_page .three-value-slider .slider-bar {
        display: inline-block;
        height: 10px;
        margin-left: 0;
    }
    #goal_page .three-value-slider .slider-bar.left {
        background-color: #ff0;
        border-top-left-radius: calc(10px/2);
        border-bottom-left-radius: calc(10px/2);
        <#--  padding-right: calc(25px/2);  -->
        margin-right: calc(25px/2);
    }
    #goal_page .three-value-slider .slider-bar.middle {
        background-color: #ffa500;
        <#--  padding: 0 calc(25px/2);  -->
        margin: 0 calc(25px/2);
    }
    #goal_page .three-value-slider .slider-bar.right {
        background-color: #f00;
        border-top-right-radius: calc(10px/2);
        border-bottom-right-radius: calc(10px/2);
        <#--  padding-left: calc(25px/2);  -->
        margin-left: calc(25px/2);
    }
</style>
<body class="childrenBody">
<div id="goal_page">
    <!--选项卡-->
    <div class="admin-tab">
        <ul class="admin-tab-top">
            <li id="target-1" class="admin-this">${goalset}</li>
            <li id="target-2">${arch}</li>
        </ul>
        <div class="admin-tab-cont">
            <div class="admin-tab-item active" style="width: 100%;margin: 0 auto;">
                <div class="admin-tab-title">${goal}</div>
                <div class="admin-tab-title" style="font-size: 16px;color: red;">${desc}</div>
                <div class="admin-tab-title"">
                <form style="font-size: 16px">
                    赋权值方式：
                    <select style="width:200px;" id="select_fuzhi">
                        <option value="1" selected="selected">客观赋权值</option>
                        <option value="2">主观赋权值</option>
                    </select>
                </form>
            </div>
            <div class="admin-tab-title">

                <div class="body">
                    <ul class="legend">
                        <li class="value-one">
                            <span style="font-family: '微软雅黑';font-weight: bolder; color: #000000">三类具体目标权重设置</span>
                        </li>
                        <li class="value-one">
                            <i></i><span>水</span>
                        </li>
                        <li class="value-two">
                            <i></i><span>生态</span>
                        </li>
                        <li class="value-three">
                            <i></i><span>社会经济</span>
                        </li>
                        <!-- <li class="total-value">
                            <span id="total" style="color: #000000"></span>
                        </li> -->
                    </ul>
                    <div class="container">
                        <three-value-slider id="three-value-slider" class="three-value-slider">
                            <span class="slider-bar left"></span>
                            <span class="slider-handle left" style="background: white; margin-top: 0; margin-left: 0;"></span>
                            <span class="slider-bar middle"></span>
                            <span class="slider-handle right" style="background: white; margin-top: 0; margin-left: 0;"></span>
                            <span class="slider-bar right"></span>
                        </three-value-slider>
                    </div>
                </div>

            </div>

            <!--目标一-->
            <div class="admin-check-tree">
                <ul>
                    <li class="father_li">
                        <span><i class="icon iconfont">&#xe701;</i></span>
                        <input class="admin-checkbox" type="checkbox" name="index_1" id="index_1" checked="checked">
                        <label class="admin-check-label" for="index_1" style="font-weight: bold;">${goal1}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        (${weight}<span id="goal_1"></span>
                        <!-- <input class="admin-input" type="text" id="goal_1" name="goal_1" value="20" style="width:30px;"> -->%)
                        <ul>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_1_1" id="index_1_1">
                                <label class="admin-check-label" for="index_1_1" style="font-weight: normal">${sub}1.1&nbsp;&nbsp;${i11}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_1_1" id="index_1_1_1" checked="checked" >
                                        <label class="admin-check-label" for="index_1_1_1" style="font-weight: normal">${index}1.1.1&nbsp;&nbsp;${i111}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_111" name="index_111" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_1_2" id="index_1_1_2" >
                                        <label class="admin-check-label" for="index_1_1_2" style="font-weight: normal">${index}1.1.2&nbsp;&nbsp;${i112}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_112" name="index_112" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_1_2" id="index_1_2" >
                                <label class="admin-check-label" for="index_1_2" style="font-weight: normal">${sub}1.2&nbsp;&nbsp;${i12}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_2_1" id="index_1_2_1" >
                                        <label class="admin-check-label" for="index_1_2_1" style="font-weight: normal">${index}1.2.1&nbsp;&nbsp;${i121}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_121" name="index_121" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_1_3" id="index_1_3" >
                                <label class="admin-check-label" for="index_1_3" style="font-weight: normal">${sub}1.3&nbsp;&nbsp;${i13}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_3_1" id="index_1_3_1" >
                                        <label class="admin-check-label" for="index_1_3_1" style="font-weight: normal">${index}1.3.1&nbsp;&nbsp;${i131}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_131" name="index_131" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_3_2" id="index_1_3_2" >
                                        <label class="admin-check-label" for="index_1_3_2" style="font-weight: normal">${index}1.3.2&nbsp;&nbsp;${i132}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_132" name="index_132" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_1_4" id="index_1_4" >
                                <label class="admin-check-label" for="index_1_4" style="font-weight: normal">${sub}1.4&nbsp;&nbsp;${i14}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_4_1" id="index_1_4_1" >
                                        <label class="admin-check-label" for="index_1_4_1" style="font-weight: normal">${index}1.4.1&nbsp;&nbsp;${i141}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_141" name="index_141" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_4_2" id="index_1_4_2" >
                                        <label class="admin-check-label" for="index_1_4_2" style="font-weight: normal">${index}1.4.2&nbsp;&nbsp;${i142}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_142" name="index_142" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_4_3" id="index_1_4_3" >
                                        <label class="admin-check-label" for="index_1_4_3" style="font-weight: normal">${index}1.4.3&nbsp;&nbsp;${i143}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_143" name="index_143" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_1_4_4" id="index_1_4_4" >
                                        <label class="admin-check-label" for="index_1_4_4" style="font-weight: normal">${index}1.4.4&nbsp;&nbsp;${i144}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_144" name="index_144" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--目标二-->
            <div class="admin-check-tree">
                <ul>
                    <li class="father_li">
                        <span><i class="icon iconfont">&#xe701;</i></span>
                        <input class="admin-checkbox" type="checkbox" name="index_2" id="index_2" checked="checked" >
                        <label class="admin-check-label" for="index_2" style="font-weight: bold;">${goal2}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        (${weight}<span id="goal_2"></span>
                        <!-- <input class="admin-input" type="text" id="goal_2" name="goal_2" value="" style="width: 30px;"> -->%)
                        <ul>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_2_1" id="index_2_1" >
                                <label class="admin-check-label" for="index_2_1" style="font-weight: normal">${sub} 2.1&nbsp;&nbsp;${i21}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_2_1_1" id="index_2_1_1" >
                                        <label class="admin-check-label" for="index_2_1_1" style="font-weight: normal">${index}2.1.1&nbsp;&nbsp;${i211}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_211" name="index_211" value=" " style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_2_2" id="index_2_2" >
                                <label class="admin-check-label" for="index_2_2" style="font-weight: normal">${sub}2.2&nbsp;&nbsp;${i22}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_2_2_1" id="index_2_2_1" >
                                        <label class="admin-check-label" for="index_2_2_1" style="font-weight: normal">${index}2.2.1&nbsp;&nbsp;${i221}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_221" name="index_221" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_2_3" id="index_2_3" >
                                <label class="admin-check-label" for="index_2_3" style="font-weight: normal">${sub}2.3&nbsp;&nbsp;${i23}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_2_3_1" id="index_2_3_1" >
                                        <label class="admin-check-label" for="index_2_3_1" style="font-weight: normal">${index}2.3.1&nbsp;&nbsp;${i231}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_231" name="index_231" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--目标三-->
            <div class="admin-check-tree">
                <ul>
                    <li class="father_li">
                        <span><i class="icon iconfont">&#xe701;</i></span>
                        <input class="admin-checkbox" type="checkbox" name="index_3" id="index_3" checked="checked" >
                        <label class="admin-check-label" for="index_3" style="font-weight: bold;">${goal3}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        (${weight}<span id="goal_3"></span>
                        <!-- <input class="admin-input" type="text" id="goal_3" name="goal_3" value="40" style="width: 30px;"> -->%)
                        <ul>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_1" id="index_3_1" >
                                <label class="admin-check-label" for="index_3_1" style="font-weight: normal">${sub}3.1&nbsp;&nbsp;${i31}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_1_1" id="index_3_1_1" >
                                        <label class="admin-check-label" for="index_3_1_1" style="font-weight: normal">${index}3.1.1&nbsp;&nbsp;${i311}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_311" name="index_311" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_2" id="index_3_2" >
                                <label class="admin-check-label" for="index_3_2" style="font-weight: normal">${sub}3.2&nbsp;&nbsp;${i32}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_2_1" id="index_3_2_1" >
                                        <label class="admin-check-label" for="index_3_2_1" style="font-weight: normal">${index}3.2.1&nbsp;&nbsp;${i321}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_321" name="index_321" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_3" id="index_3_3" >
                                <label class="admin-check-label" for="index_3_3" style="font-weight: normal">${sub}3.3&nbsp;&nbsp;${i33}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_3_1" id="index_3_3_1" >
                                        <label class="admin-check-label" for="index_3_3_1" style="font-weight: normal">${index}3.3.1&nbsp;&nbsp;${i331} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_331" name="index_331" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_4" id="index_3_4" >
                                <label class="admin-check-label" for="index_3_4" style="font-weight: normal">${sub}3.4&nbsp;&nbsp;${i34}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_4_1" id="index_3_4_1" >
                                        <label class="admin-check-label" for="index_3_4_1" style="font-weight: normal">${index}3.4.1&nbsp;&nbsp;${i341} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_341" name="index_341" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_5" id="index_3_5" >
                                <label class="admin-check-label" for="index_3_5" style="font-weight: normal">${sub}3.5&nbsp;&nbsp;${i35}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_5_1" id="index_3_5_1" >
                                        <label class="admin-check-label" for="index_3_5_1" style="font-weight: normal">${index}3.5.1&nbsp;&nbsp;${i351}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_351" name="index_351" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_5_2" id="index_3_5_2" >
                                        <label class="admin-check-label" for="index_3_5_2" style="font-weight: normal">${index}3.5.2&nbsp;&nbsp;${i352}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_352" name="index_352" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_6" id="index_3_6" >
                                <label class="admin-check-label" for="index_3_6" style="font-weight: normal">${sub}标3.6 &nbsp;&nbsp;${i36}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_6_1" id="index_3_6_1" >
                                        <label class="admin-check-label" for="index_3_6_1" style="font-weight: normal">${index}3.6.1&nbsp;&nbsp;${i361} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_361" name="index_361" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_7" id="index_3_7" >
                                <label class="admin-check-label" for="index_3_7" style="font-weight: normal">${sub}3.7 &nbsp;&nbsp;${i37}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_7_1" id="index_3_7_1" >
                                        <label class="admin-check-label" for="index_3_7_1" style="font-weight: normal">${index}3.7.1&nbsp;&nbsp;${i371} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_371" name="index_371" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_7_2" id="index_3_7_2" >
                                        <label class="admin-check-label" for="index_3_7_2" style="font-weight: normal">${index}3.7.2&nbsp;&nbsp;${i372}</label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_372" name="index_372" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_7_3" id="index_3_7_3" >
                                        <label class="admin-check-label" for="index_3_7_3" style="font-weight: normal">${index}3.7.3&nbsp;&nbsp;${i373} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_373" name="index_373" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                            <li class="father_li">
                                <span><i class="icon iconfont">&#xe701;</i></span>
                                <input class="admin-checkbox" type="checkbox" name="index_3_8" id="index_3_8" >
                                <label class="admin-check-label" for="index_3_8" style="font-weight: normal">${sub}3.8&nbsp;&nbsp;${i38}</label>
                                <ul>
                                    <li class="sub_li">
                                        <input class="admin-checkbox" type="checkbox" name="index_3_8_1" id="index_3_8_1" >
                                        <label class="admin-check-label" for="index_3_8_1" style="font-weight: normal">${index}3.8.1&nbsp;&nbsp;${i381} </label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weight}<input class="admin-input" type="text" id="index_381" name="index_381" value="" style="width: 50px; height: 20px;background-color: rgb(207, 207, 207);" readonly="readonly">
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div>
                <div class="admin-form-item  admin-form-btn">
                    <button class="admin-btn admin-btn-blue" id="submit">${save}</button>
                    <button class="admin-btn admin-btn-grey" type="reset">${reset}</button>
                </div>
            </div>
        </div>
        <div class="admin-tab-item">
            <div class="admin-tab-title">${goalset}</div>
            <div id="chart" style="width: 100%;min-height: 450px;"></div>
            <#--  <div style="text-align: right;margin: 10px 0;">
                <a class="admin-btn" href="toStuation.do" target="adminFrameName">${next}</a>
            </div>  -->
        </div>
    </div>
</div>
</div>
<script src="static/js/jquery-2.2.3.min.js"></script>
<script src="static/js/echarts-all.js"></script>
<script type="text/javascript">
    $("#select_fuzhi").on("change",function(){
        if(document.getElementById('select_fuzhi').value == '2'){
            document.getElementById("goal_1").readOnly=false;
            document.getElementById("goal_2").readOnly=false;
            document.getElementById("goal_3").readOnly=false;
            document.getElementById("index_111").readOnly=false;
            document.getElementById("index_112").readOnly=false;
            document.getElementById("index_121").readOnly=false;
            document.getElementById("index_131").readOnly=false;
            document.getElementById("index_132").readOnly=false;
            document.getElementById("index_141").readOnly=false;
            document.getElementById("index_142").readOnly=false;
            document.getElementById("index_143").readOnly=false;
            document.getElementById("index_144").readOnly=false;
            document.getElementById("index_211").readOnly=false;
            document.getElementById("index_221").readOnly=false;
            document.getElementById("index_231").readOnly=false;
            document.getElementById("index_311").readOnly=false;
            document.getElementById("index_321").readOnly=false;
            document.getElementById("index_331").readOnly=false;
            document.getElementById("index_341").readOnly=false;
            document.getElementById("index_351").readOnly=false;
            document.getElementById("index_352").readOnly=false;
            document.getElementById("index_361").readOnly=false;
            document.getElementById("index_371").readOnly=false;
            document.getElementById("index_372").readOnly=false;
            document.getElementById("index_373").readOnly=false;
            document.getElementById("index_381").readOnly=false;
        }else{
            document.getElementById("goal_1").readOnly=true;
            document.getElementById("goal_2").readOnly=true;
            document.getElementById("goal_3").readOnly=true;
            document.getElementById("index_111").readOnly=true;
            document.getElementById("index_112").readOnly=true;
            document.getElementById("index_121").readOnly=true;
            document.getElementById("index_131").readOnly=true;
            document.getElementById("index_132").readOnly=true;
            document.getElementById("index_141").readOnly=true;
            document.getElementById("index_142").readOnly=true;
            document.getElementById("index_143").readOnly=true;
            document.getElementById("index_144").readOnly=true;
            document.getElementById("index_211").readOnly=true;
            document.getElementById("index_221").readOnly=true;
            document.getElementById("index_231").readOnly=true;
            document.getElementById("index_311").readOnly=true;
            document.getElementById("index_321").readOnly=true;
            document.getElementById("index_331").readOnly=true;
            document.getElementById("index_341").readOnly=true;
            document.getElementById("index_351").readOnly=true;
            document.getElementById("index_352").readOnly=true;
            document.getElementById("index_361").readOnly=true;
            document.getElementById("index_371").readOnly=true;
            document.getElementById("index_372").readOnly=true;
            document.getElementById("index_373").readOnly=true;
            document.getElementById("index_381").readOnly=true;
        }
    });

    $.get("getGoal.do", {
        <#--  "id" : "${projectId}"  -->
        //"id" : "3ec75f9d-a1aa-4455-a753-e8fc50f188c8"
    }, function(data) {
        console.log("获取的目标数据："+data);

        //console.log("121"+data.index_121_status);
        //判断是否选中
        if(data.index_111_status==1){
            $("#index_111").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_1_1").attr("checked",true);
            $("#index_1_1").attr("checked",true);
        }
        if(data.index_112_status==1){
            $("#index_112").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_1_2").attr("checked",true);
            $("#index_1_1").attr("checked",true);
        }
        if(data.index_121_status==1){
            $("#index_121").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_2_1").attr("checked",true);
            $("#index_1_2").attr("checked",true);
        }
        if(data.index_131_status==1){
            $("#index_131").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_3_1").attr("checked",true);
            $("#index_1_3").attr("checked",true);
        }
        if(data.index_132_status==1){
            $("#index_132").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_3_2").attr("checked",true);
            $("#index_1_3").attr("checked",true);
        }
        if(data.index_141_status==1){
            $("#index_141").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_4_1").attr("checked",true);
            $("#index_1_4").attr("checked",true);
        }
        if(data.index_142_status==1){
            $("#index_142").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_4_2").attr("checked",true);
            $("#index_1_4").attr("checked",true);
        }
        if(data.index_143_status==1){
            $("#index_143").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_4_3").attr("checked",true);
            $("#index_1_4").attr("checked",true);
        }
        if(data.index_144_status==1){
            $("#index_144").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_1_4_4").attr("checked",true);
            $("#index_1_4").attr("checked",true);
        }
        if(data.index_211_status==1){
            $("#index_211").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_2_1_1").attr("checked",true);
            $("#index_2_1").attr("checked",true);
        }
        if(data.index_221_status==1){
            $("#index_221").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_2_2_1").attr("checked",true);
            $("#index_2_2").attr("checked",true);
        }
        if(data.index_231_status==1){
            $("#index_231").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_2_3_1").attr("checked",true);
            $("#index_2_3").attr("checked",true);
        }
        if(data.index_311_status==1){
            $("#index_311").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_1_1").attr("checked",true);
            $("#index_3_1").attr("checked",true);
        }
        if(data.index_321_status==1){
            $("#index_321").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_2_1").attr("checked",true);
            $("#index_3_2").attr("checked",true);
        }
        if(data.index_331_status==1){
            $("#index_331").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_3_1").attr("checked",true);
            $("#index_3_3").attr("checked",true);
        }
        if(data.index_341_status==1){
            $("#index_341").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_4_1").attr("checked",true);
            $("#index_3_4").attr("checked",true);
        }
        if(data.index_351_status==1){
            $("#index_351").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_5_1").attr("checked",true);
            $("#index_3_5").attr("checked",true);
        }
        if(data.index_352_status==1){
            $("#index_352").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_5_2").attr("checked",true);
            $("#index_3_5").attr("checked",true);
        }
        if(data.index_361_status==1){
            $("#index_361").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_6_1").attr("checked",true);
            $("#index_3_6").attr("checked",true);
        }
        if(data.index_371_status==1){
            $("#index_371").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_7_1").attr("checked",true);
            $("#index_3_7").attr("checked",true);
        }
        if(data.index_372_status==1){
            $("#index_372").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_7_2").attr("checked",true);
            $("#index_3_7").attr("checked",true);
        }
        if(data.index_373_status==1){
            $("#index_373").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_7_3").attr("checked",true);
            $("#index_3_7").attr("checked",true);
        }
        if(data.index_381_status==1){
            $("#index_381").attr("readonly", true).css('background-color','#FFFFFF');
            $("#index_3_8_1").attr("checked",true);
            $("#index_3_8").attr("checked",true);
        }

        //若是新建项目，将数据初始化
        document.getElementById("goal_1").value = data.goal_1;
        document.getElementById("goal_2").value = data.goal_2;
        document.getElementById("goal_3").value = data.goal_3;
        document.getElementById("index_111").value = data.index_111;
        document.getElementById("index_112").value = data.index_112;
        document.getElementById("index_121").value = data.index_121;
        document.getElementById("index_131").value = data.index_131;
        document.getElementById("index_132").value = data.index_132;
        document.getElementById("index_141").value = data.index_141;
        document.getElementById("index_142").value = data.index_142;
        document.getElementById("index_143").value = data.index_143;
        document.getElementById("index_144").value = data.index_144;
        document.getElementById("index_211").value = data.index_211;
        document.getElementById("index_221").value = data.index_221;
        document.getElementById("index_231").value = data.index_231;
        document.getElementById("index_311").value = data.index_311;
        document.getElementById("index_321").value = data.index_321;
        document.getElementById("index_331").value = data.index_331;
        document.getElementById("index_341").value = data.index_341;
        document.getElementById("index_351").value = data.index_351;
        document.getElementById("index_352").value = data.index_352;
        document.getElementById("index_361").value = data.index_361;
        document.getElementById("index_371").value = data.index_371;
        document.getElementById("index_372").value = data.index_372;
        document.getElementById("index_373").value = data.index_373;
        document.getElementById("index_381").value = data.index_381;

    });



    $("#submit").click(function() {
        var goal_1, goal_2, goal_3, index_111, index_112, index_121,
            index_131, index_132, index_141, index_142, index_143, index_144, index_211, index_221, index_231,
            index_311, index_321, index_331, index_341, index_351, index_352, index_361,
            index_371, index_372, index_373, index_381;
        //判断状态
        if($("#index_1").is(":checked")){
            goal_1 = 1;
        }else{
            goal_1 = 0;
        }
        if($("#index_2").is(":checked")){
            goal_2 = 1;
        }else{
            goal_2 = 0;
        }
        if($("#index_3").is(":checked")){
            goal_3 = 1;
        }else{
            goal_3 = 0;
        }
        if($("#index_1_1_1").is(":checked")){
            index_111 = 1;
        }else{
            index_111 = 0;
        }
        if($("#index_1_1_2").is(":checked")){
            index_112 = 1;
        }else{
            index_112 = 0;
        }
        if($("#index_1_2_1").is(":checked")){
            index_121 = 1;
        }else{
            index_121 = 0;
        }
        if($("#index_1_3_1").is(":checked")){
            index_131 = 1;
        }else{
            index_131 = 0;
        }
        if($("#index_1_3_2").is(":checked")){
            index_132 = 1;
        }else{
            index_132 = 0;
        }
        if($("#index_1_4_1").is(":checked")){
            index_141 = 1;
        }else{
            index_141 = 0;
        }
        if($("#index_1_4_2").is(":checked")){
            index_142 = 1;
        }else{
            index_142 = 0;
        }
        if($("#index_1_4_3").is(":checked")){
            index_143 = 1;
        }else{
            index_143 = 0;
        }
        if($("#index_1_4_4").is(":checked")){
            index_144 = 1;
        }else{
            index_144 = 0;
        }
        if($("#index_2_1_1").is(":checked")){
            index_211 = 1;
        }else{
            index_211 = 0;
        }
        if($("#index_2_2_1").is(":checked")){
            index_221 = 1;
        }else{
            index_221 = 0;
        }
        if($("#index_2_3_1").is(":checked")){
            index_231 = 1;
        }else{
            index_231 = 0;
        }
        if($("#index_3_1_1").is(":checked")){
            index_311 = 1;
        }else{
            index_311 = 0;
        }
        if($("#index_3_2_1").is(":checked")){
            index_321 = 1;
        }else{
            index_321 = 0;
        }
        if($("#index_3_3_1").is(":checked")){
            index_331 = 1;
        }else{
            index_331 = 0;
        }
        if($("#index_3_4_1").is(":checked")){
            index_341 = 1;
        }else{
            index_341 = 0;
        }
        if($("#index_3_5_1").is(":checked")){
            index_351 = 1;
        }else{
            index_351 = 0;
        }
        if($("#index_3_5_2").is(":checked")){
            index_352 = 1;
        }else{
            index_352 = 0;
        }
        if($("#index_3_6_1").is(":checked")){
            index_361 = 1;
        }else{
            index_361 = 0;
        }
        if($("#index_3_7_1").is(":checked")){
            index_371 = 1;
        }else{
            index_371 = 0;
        }
        if($("#index_3_7_2").is(":checked")){
            index_372 = 1;
        }else{
            index_372 = 0;
        }
        if($("#index_3_7_3").is(":checked")){
            index_373 = 1;
        }else{
            index_373 = 0;
        }
        if($("#index_3_8_1").is(":checked")){
            index_381 = 1;
        }else{
            index_381 = 0;
        }
        /*console.log("状态："+goal_1+"/"+goal_2+"/"+goal_3+"/"+index_111+"/"+index_112+"/"+index_121+"/"+
                index_131+"/"+index_132+"/"+index_141+"/"+index_142+"/"+index_143+"/"+index_144+"/"+
                index_211+"/"+index_221+"/"+index_231+"/"+
                index_311+"/"+index_321+"/"+index_331+"/"+index_341+"/"+
                index_351+"/"+index_352+"/"+index_361+"/"+
                index_371+"/"+index_372+"/"+index_373+"/"+index_381);*/

        $.get("addGoal.do", {
            <#--  "projectId" : "${projectId}",  -->
            //"projectId" : "3ec75f9d-a1aa-4455-a753-e8fc50f188c8",
            "goal_1" : String(document.getElementById("goal_1").innerText),
            "goal_2" : String(document.getElementById("goal_2").innerText),
            "goal_3" : String(document.getElementById("goal_3").innerText),
            "index_111" : String(document.getElementById("index_1_1_1").checked),
            "index_112" : String(document.getElementById("index_1_1_2").checked),
            "index_121" : String(document.getElementById("index_1_2_1").checked),
            "index_131" : String(document.getElementById("index_1_3_1").checked),
            "index_132" : String(document.getElementById("index_1_3_2").checked),
            "index_141" : String(document.getElementById("index_1_4_1").checked),
            "index_142" : String(document.getElementById("index_1_4_2").checked),
            "index_143" : String(document.getElementById("index_1_4_3").checked),
            "index_144" : String(document.getElementById("index_1_4_4").checked),
            "index_211" : String(document.getElementById("index_2_1_1").checked),
            "index_221" : String(document.getElementById("index_2_2_1").checked),
            "index_231" : String(document.getElementById("index_2_3_1").checked),
            "index_311" : String(document.getElementById("index_3_1_1").checked),
            "index_321" : String(document.getElementById("index_3_2_1").checked),
            "index_331" : String(document.getElementById("index_3_3_1").checked),
            "index_341" : String(document.getElementById("index_3_4_1").checked),
            "index_351" : String(document.getElementById("index_3_5_1").checked),
            "index_352" : String(document.getElementById("index_3_5_2").checked),
            "index_361" : String(document.getElementById("index_3_6_1").checked),
            "index_371" : String(document.getElementById("index_3_7_1").checked),
            "index_372" : String(document.getElementById("index_3_7_2").checked),
            "index_373" : String(document.getElementById("index_3_7_3").checked),
            "index_381" : String(document.getElementById("index_3_8_1").checked),
            "goal_1_status" : goal_1,
            "goal_2_status" : goal_2,
            "goal_3_status" : goal_3,
            "index_111_status" : index_111,
            "index_112_status" : index_112,
            "index_121_status" : index_121,
            "index_131_status" : index_131,
            "index_132_status" : index_132,
            "index_141_status" : index_141,
            "index_142_status" : index_142,
            "index_143_status" : index_143,
            "index_144_status" : index_144,
            "index_211_status" : index_211,
            "index_221_status" : index_221,
            "index_231_status" : index_231,
            "index_311_status" : index_311,
            "index_321_status" : index_321,
            "index_331_status" : index_331,
            "index_341_status" : index_341,
            "index_351_status" : index_351,
            "index_352_status" : index_352,
            "index_361_status" : index_361,
            "index_371_status" : index_371,
            "index_372_status" : index_372,
            "index_373_status" : index_373,
            "index_381_status" : index_381

        }, function(data) {
            console.log(data);
            alert(data.content);
            drawtree();
        })
    })
</script>

<script type="text/javascript">
    //图表
    function drawtree() {
        var myChart = echarts.init(document.getElementById('chart'));
        var option = {
            title : {
                text : '',
                x : 'center'
            },
            tooltip : {
                trigger : 'item',
                triggerOn: 'mousemove',
                formatter : "{b}",
            },
            toolbox : {
                show : true,
                feature : {
                    saveAsImage : {
                        show : true
                    }
                }
            },
            calculable : true,
            series : [ {
                name : '树图',
                type : 'tree',
                orient : 'horizontal', // vertical horizontal
                // 根节点位置  {x: 'center',y: 10}
                rootLocation: {x: '10%', y: ''},
                layerPadding : 280,
                nodePadding : 30,
                symbol : 'circle',
                symbolSize : 10,
                roam: true,
                itemStyle : {
                    normal : {
                        color : '#337ab7',
                        label : {
                            show : true,
                            position : 'bottom',
                            verticalAlign: 'middle',
                            textStyle : {
                                color : '#cc9999',
                                fontSize : 14,
                                fontWeight : 'bolder'
                            }
                        },
                        lineStyle : {
                            color : '#000',
                            width : 2,
                            type : 'solid' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                        }
                    },
                },
                data : (function() {
                    var arr = [];
                    $.ajax({
                        type : "get",
                        async : false, //同步执行
                        url : "getGoalTree.do",
                        data : {},
                        dataType : "json", //返回数据形式为json
                        success : function(result) {
                            if (result) {
                                arr.push(result);
                            }
                        }
                    })
                    return arr;
                })()
            } ],
            expandAndCollapse: true,
            animationDuration: 550,
            animationDurationUpdate: 750
        };
        myChart.setOption(option);
    }
    //选项卡
    $(".admin-tab .admin-tab-item").eq(0).show().siblings().hide();//显示第一个，隐藏其他的
    $(".admin-tab .admin-tab-top li").on("click", function() {//选项卡切换
        var i = $(this).index();
        $(this).addClass("admin-this").siblings().removeClass("admin-this");
        $(".admin-tab .admin-tab-cont .admin-tab-item").eq(i).show().siblings().hide();
    })

    $("#target-2").on("click",function(){
        drawtree();
    })
</script>
<script type="text/javascript">
    $("input[type='checkbox']").change(
        function(e) {
            var text = $(this).parent().find($("input[type='text']"));
            var checbox = $(this).parent().find($("input[type='checkbox']"));
            if ($(this).attr("checked") == "checked") {
                $(text).attr("readonly", true).css('background-color','#CFCFCF').val(null);
                $(this).removeAttr("checked");
                $(checbox).removeAttr("checked");
            } else {
                $(text).attr("readonly", false).css('background-color','#FFFFFF').val("0");
                $(this).prop("checked", "checked");
                $(checbox).prop("checked", "checked");
                $(this).attr("checked", "checked");
                $(checbox).attr("checked", "checked");
            }
        });
</script>
<script type="text/javascript">
    //折叠
    $(".father_li > span").on("click",function(){
        $(this).children().toggleClass("collapse");
        $(this).siblings("ul").slideToggle("fast");
    })

    $(".father_li > span").children().toggleClass("collapse");
    $(".father_li > span").siblings("ul").slideToggle("fast");
    //步骤条宽度设置
    /*function StepsWidth(){
        var width=($(".admin-steps").width()-350)/2+"px";
        $(".admin-steps-item-tail").width(width);
    }
    StepsWidth();
    $(window).on("resize",function(){
        StepsWidth()
    });*/
</script>
<#--  <script type="text/javascript">
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
</script>  -->
</body>
</html>