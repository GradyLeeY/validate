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
        #imageCode{
            cursor: pointer;
        }
    </style>
    <script type="text/javascript">
        function changeCode() {
            var imgCode = document.getElementById("imageCode");
            imgCode.src = "FirstServlet?"+Math.random();
        }

    </script>
</head>
<body>
    <form action="ValicodeServlet" method="post">
        <label>验证码:</label>
        <input type="text" id="inCode" name="inCode"/>
        <img onclick="changeCode()" src="FirstServlet" align="center" id="imageCode"/>
        <a onclick="changeCode()" class="code_a">换一张</a><br/>
        <input type="submit" value="登录"/>
    </form>
    <div style="color: red">
        ${err}
    </div>
</body>
</html>
