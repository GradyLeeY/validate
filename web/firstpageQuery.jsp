<%--
  Created by IntelliJ IDEA.
  User: fuyun
  Date: 20-4-25
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随机验证码</title>
    <style type="text/css">
        .code_a{
            color: #0000ff;
            font-size: 12px;
            text-decoration: none;
            cursor: pointer;
        }
        #cvs{
            cursor: pointer;
        }
    </style>
    <script src="js/firstQuery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        var valicode;
        function changeCode(){
            var cvs = document.getElementById("cvs");
            valicode = drawcode(cvs);
        }
        function valiCode(){
            var code = document.getElementById("inCode").value;
            if(code.toLowerCase() == valicode.toLowerCase()){
                return true;
            }
            else{
                document.getElementById("err").innerHTML = "输入的验证码错误！";
                changeCode();
                return false;
            }
        }
        window.onload = changeCode;
    </script>

</head>
<body>
<form action="index.jsp" method="post">
    <label>验证码：</label>
    <input type="text" id="inCode" name="inCode" />
    <canvas id="cvs" onclick="changeCode()"></canvas>
    <a class="code_a" onclick="changeCode()">换一张</a><br />
    <input type="submit" value="登录" onclick="return valiCode()" />
</form>
<div style="color:red" id="err"></div>
</body>
</html>
