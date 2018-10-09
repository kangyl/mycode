<%--
  Created by IntelliJ IDEA.
  User: myPc
  Date: 2018/10/9
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../static/common/vue.js" type="text/javascript"></script>

</head>
<body>
<div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>{{details()}}</h1>
</div>
<script type="text/javascript">
    var vm = new Vue({
        el: '#vue_det',
        data: {
            site: "菜鸟教程",
            url: "www.runoob.com",
            alexa: "10000"
        },
        methods: {
            details: function () {
                return this.site + " - 学的不仅是技术，更是梦想！";
            }
        }
    });
</script>
</body>
</html>
