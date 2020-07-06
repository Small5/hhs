<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="X-UA-Compatible" content="IE=10">
    <meta http-equiv="X-UA-Compatible" content="IE=11">
    <title>${title}</title>
    <link rel="icon" href="static/images/favicon.png">
    <link rel="stylesheet" type="text/css" href="static/css/style.css"/>
</head>

<body onload="A();">
<input id="role" value="${role}" style="display: none;"/>
<div class="admin-layout">
    <!-- 顶部 -->
    <div class="admin-header">
        <div class="admin-header-logo"><img src="static/images/title - Web2.png" style="height: 56px;width: 572px"/></div>
        <div class="admin-header-menu">
            <i class="icon iconfont">&#xe61a;</i>
            <a id="userinformation" href="userinformation.do" target="adminFrameName" title="点击修改个人信息">${user.nickName}</a>
            <span>${nickname}</span><a onclick="exit();">${exit}</a>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="admin-side" id="aaa">
        <div class="navBar">
            <ul class="admin-nav">
                <li class="admin-nav-item admin-item-link">
                    <a href="watershedlist.do" target="adminFrameName">
                        <i class="icon iconfont icon-left" style="font-size: 14px;">&#xe699;</i>
                        <cite>${rbm}</cite>
                        <i class="icon iconfont icon-right">&#xe650;</i>
                    </a>
                    <dl class="admin-nav-child">
                        <dd>
                            <a href="gis.do" target="adminFrameName">
                                <i class="icon iconfont icon-left">&#xe701;</i>
                                <cite>${hrb}</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li class="admin-nav-item admin-item-link">
                    <a href="projectlist.do" target="adminFrameName">
                        <i class="icon iconfont icon-left">&#xed95;</i>
                        <cite>${dms}</cite>
                    </a>
                </li>
                <li class="admin-nav-item admin-item-link" style="display: none;">
                    <a href="static/page/userList.html" target="adminFrameName">
                        <i class="icon iconfont icon-left">&#xe602;</i>
                        <cite>${um}</cite>
                    </a>
                </li>
                <li class="admin-nav-item">
                    <a href="javascript:;" target="adminFrameName">
                        <i class="icon iconfont icon-left">&#xe63c;</i>
                        <cite>${about}</cite>
                        <i class="icon iconfont icon-right">&#xe650;</i>
                    </a>
                    <dl class="admin-nav-child">
                        <dd>
                            <a href="static/page/about/IntegratedIntroduction.html" target="adminFrameName">
                                <i class="icon iconfont icon-left">&#xe701;</i>
                                <cite>${him}</cite>
                            </a>
                        </dd>
                        <dd class="">
                            <a href="static/page/about/SystemIntroduction.html" target="adminFrameName">
                                <i class="icon iconfont icon-left">&#xe701;</i>
                                <cite>DisDSS</cite>
                            </a>
                        </dd>
                        <dd class="">
                            <a href="static/page/about/ContactUs.html" target="adminFrameName">
                                <i class="icon iconfont icon-left">&#xe701;</i>
                                <cite>${contact}</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="admin-display-arrow" id="bbb">
        <a href="javascript:;"></a>
    </div>
    <!-- 右侧内容 -->
    <div class="admin-body">
        <div class="admin-cont-item">
            <iframe id="adminFrameId" name="adminFrameName" frameborder="0" src="gis.do"></iframe>
            <!--<iframe id="adminFrameId" name="adminFrameName" frameborder="0" src="page/projectList.html"></iframe>-->
        </div>
    </div>
    <!-- 底部 -->
    <div class="admin-footer">
        <p>${hhs}</p>
    </div>
</div>

<script src="static/js/jquery-2.2.3.min.js" type="text/javascript"></script>
<script src="static/js/layer/layer.js"></script>
<script type="text/javascript">
    //侧边栏动效
    $(".admin-nav-item > a").on("click",function(){
        $(this).siblings(".admin-nav-child").stop().slideToggle("fast");
        $(this).find(".icon-right").toggleClass("turn");
        $(this).parent().siblings().find(".admin-nav-child").stop().slideUp("fast");
        $(this).parent().siblings().find(".icon-right").removeClass("turn");
    });
    $(".admin-nav-child dd").on("click",function(){
        $(this).addClass("active");
        $(this).siblings().removeClass("active");
        $(this).parent().parent().siblings().find("dd").removeClass("active")
    });
    $(".admin-item-link a").on("click",function(){
        $(".admin-nav").find("dd").removeClass("active");
    })

    //侧边栏收起
    var flag=1;
    $(".admin-display-arrow a").on("click",function(){
        if(flag==1){
            $(".admin-side").stop().animate({"left":"-180px"},"fast");
            $(".admin-body").stop().animate({"left":"0"},"fast");
            $(".admin-footer").stop().animate({"left":"0"},"fast");
            $(".admin-display-arrow").stop().animate({"left":"0px"},"fast");
            $(this).addClass("active");
            flag=2;
        }else{
            $(".admin-side").stop().animate({"left":"0px"},"fast");
            $(".admin-body").stop().animate({"left":"180px"},"fast");
            $(".admin-footer").stop().animate({"left":"180px"},"fast");
            $(".admin-display-arrow").stop().animate({"left":"180px"},"fast");
            $(this).removeClass("active");
            flag=1;
        }
    })

    //根据用户权限显示内容，将左侧菜单清除，同时删除用户修改url
    function A(){
        var aaa = document.getElementById("aaa");
        var bbb = document.getElementById("bbb");
        if(document.getElementById("role").value==3){
            aaa.parentNode.removeChild(aaa);
            bbb.parentNode.removeChild(bbb);
            $(".admin-body").css("left",0);
            $("#userinformation").removeAttr("href");
            //console.log("已执行");
        }
    }

    function exit(){
        //console.log("退出");
        window.location.href='logout.do';
    }
</script>
</body>

</html>