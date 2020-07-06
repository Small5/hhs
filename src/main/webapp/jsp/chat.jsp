<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://wwww.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    </head>

    <body>
        alert("!!!!!");
        <%
            String userName,speech;
            File chatRecord=new File("chatrecord/test.txt");
            FileWriter fwriter=new FileWriter(chatRecord);
            BufferedWriter bfwriter=new BufferedWriter(fwriter);
        
            request.setCharacterEncoding("gbk");
            userName="admin";
            //userName=(String)session.getAttribute("userName");
  	    Date now=new Date();
            speech=request.getParameter("speech");
            //alert(speech);
            if(speech!=null && speech.toString()!=""){
                String info=now.toString()+"  "+userName+":"+"\n"+speech+"\n";
                bfwriter.write(info,0,info.length());
                bfwriter.flush();
                bfwriter.close();
                //if(application.getAttribute("app_speech")==""){
                //    application.setAttribute("app_speech",info);
                }
               // else{
               //     temp=(String)application.getAttribute("app_speech");
               //     if(temp!=null)
               //         info=temp+info;
               //     application.setAttribute("app_speech",info);
               //}
            }
            fwriter.close();
        %>
    </body>

</html>
