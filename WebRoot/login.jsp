<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>简洁大气快速登录注册模板</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
</head>
<body>
<h1>Blog 欢迎登陆<sup>2016</sup></h1>
<%
	String errorMsg = request.getParameter("msg");
	if(errorMsg != null) {
		switch(Integer.valueOf(errorMsg)) {
			/*登录失败*/
			case 1 : out.print("<script>alert('账号或密码错误!!!');</script>"); 
				break;
			case 2 : out.print("<script>alert('该用户名不存在!!!');</script>"); 
				break;
			case 3 : out.print("<script>alert('账号及密码不得为空!!!');</script>"); 
				break;
			/*注册*/
			case 21 :
					out.print("<script>alert('该账户已经存在，需要重新注册!!!');</script>");
				break;
			case 22 :
					out.print("<script>alert('账户创建失败，需要重新注册!!!');</script>");
				break;
			case 23 :
					out.print("<script>alert('注册成功!!!');</script>");
				break;
			case 24 :
			 		out.print("<script>alert('账号及密码不得为空，需要重新注册!!!');</script>");
			 	break;
			//需要登录才能访问的页面
			case 31 :
			 		out.print("<script>alert('请先登录 !!!');</script>");
			break;
		}
	}
 %>
<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

      <!--登录-->
      <div class="web_login" id="web_login"> 
         <div class="login-box">
    
      <div class="login_form">
	  	<form action="./LoginServlet" id="loginForm" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
            <input type="hidden" name="to" value="log"/>
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="account" class="inputstyle"/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="password" class="inputstyle"/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;">
                <input type="button" id="sbm" value="登 录" style="width:150px;" class="button_blue"/>
                </div>
              </form>
           </div>
           
      </div>
               
     </div>
            <!--登录end-->
  </div>

  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login">
    <form name="form2" id="regUser" accept-charset="utf-8"  action="./RegisterServlet" method="post">
	      <input type="hidden" name="to" value="reg"/>
		  <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>

                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="account" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" />
                    </div>
                    
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">昵称：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="qq" name="username" maxlength="10" class="inputstyle2"/>
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="注册"/>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
    </div>
    </div>
    <!--注册end-->
</div>
<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body></html>