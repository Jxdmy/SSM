<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
    ul{
        list-style-type: none;
    }
    ul li{
        float: left;
        width: auto;
        margin: 0px 10px;
    }
</style>
<script type="text/javascript">
    function go(page) {
        $("#pageNum").val(page)
        $("#form").attr("action","http://localhost/student/list");
        $("#form").submit();
    }

    function loadGrade(studentno){
        var opt={
            url: "http://localhost/student/findGrade",
            type:"post",
            data:"studentno="+studentno,
            dataType: "json",
            success: function(data)  {
               alert(data.gradename);
                alert(data.gradeid);
            }
        };
        $.ajax(opt);
    }
</script>

<html>
<head>
    <title>Title</title>
</head>
    <body>
        <input type="text"/>
        <a href="#">添加</a>
        <form action="#" method="post" id="form">
            <input type="hidden" name="pageNum" id="pageNum" value="${pageNum}"/>
            <table>
                <thead>
                    <tr>
                        <td colspan="2">
                            <label for="studentname">姓名:</label>
                            <input id="studentname" type="text" name="studentname" value="${student.studentname}"/>
                        </td>
                        <td colspan="2">
                            <label for="identitycard">生份证号:</label>
                            <input id="identitycard" type="text" name="identitycard" value="${student.identitycard}"/>
                        </td>
                        <td>
                            <button onclick="go(1)">查询</button>
                        </td>
                    </tr>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>身份证号</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="student">
                        <tr>
                            <td>${student.studentno}</td>
                            <td>${student.studentname}</td>
                            <td>
                                <c:if test="${student.sex}">男</c:if>
                                <c:if test="${!student.sex}">女</c:if>
                            </td>
                            <td>${student.identitycard}</td>
                            <td>
                                <a href="#">删除</a>
                                <a href="#">查看</a>
                                <a href="#">修改</a>
                                <a href="javascript:void()" onclick="loadGrade(${student.studentno})">读大几</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">
                            <ul>
                                <li>
                                   <a href="javascript:go(1)">首页</a>
                                </li>
                                <li>
                                    <a href="javascript:go(${pageInfo.prePage})">上一页</a>
                                </li>
                                <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                    <li>
                                        <a href="javascript:go(${page})">第${page}页</a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <a href="javascript:go(${pageInfo.nextPage})">下一页</a>
                                </li>
                                <li>
                                    <a href="javascript:go(${pageInfo.pages})">末页</a>
                                </li>
                                <li>${pageInfo.pageNum}/${pageInfo.pages}</li>
                                <li>总数据量：${pageInfo.total}</li>
                            </ul>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </body>
</html>
