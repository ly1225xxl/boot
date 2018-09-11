<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>职员信息</title>
</head>
<body>
<table width="100%" bgcolor="#ffe4c4">
    <th>编号</th>
    <th>姓名</th>
    <th>工作</th>
    <th>上司</th>
    <th>日期</th>
    <th>工资</th>
    <th>奖金</th>
    <th>部门</th>
    <th>修改</th>
    <th>删除</th>
        <#list emplist as e>
            <tr>
                <td align="center">${e.empno?c}</td>
                <td align="center">${e.ename}</td>
                <td align="center">${e.job}</td>
                <td align="center">${e.mgr?c}</td>
                <td align="center">${e.hiredate}</td>
                <td align="center">${e.sal}</td>
                <td align="center">${e.comm}</td>
                <td align="center">${e.deptno?c}</td>
                <td align="center"><a href="/premergeemp?empno=${e.empno?c}">修改</a></td>
                <td align="center"><a href="/deleteemp?empno=${e.empno?c}">删除</a></td>
            </tr>
        </#list>
    <tr><td colspan="10"><a href="addemp.html">添加员工</a></td></tr>
</table>
</body>
</html>