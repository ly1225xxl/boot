<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门信息</title>
</head>
<body>
<table bgcolor="#5f9ea0" align="center" width="100%">
    <th>部门编号</th>
    <th>部门姓名</th>
    <th>部门地址</th>
    <th>修改</th>
    <th>删除</th>
        <#list dept as d>
            <tr>
                <td align="center">${d.deptno}</td>
                <td align="center">${d.dname}</td>
                <td align="center">${d.loc}</td>
                <td align="center"><a href="/premergedept?deptno=${d.deptno?c}">修改</a></td>
                <td align="center"><a href="/deletedept?deptno=${d.deptno?c}">删除</a></td>
            </tr>
        </#list>
    <tr>
        <td colspan="5"><a href="adddept.html">添加部门</a></td>
    </tr>
</table>
</body>
