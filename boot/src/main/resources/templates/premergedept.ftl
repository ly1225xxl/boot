<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改部门信息</title>
</head>
<body>
    <form action="/mergedept" method="post">
        <table>
            <tr>
                <td>编号</td>
                <td><input name="deptno" value="${dept.deptno}"/></td>
            </tr>
            <tr>
                <td>名称</td>
                <td><input name="dname" value="${dept.dname}"/></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input name="loc" value="${dept.loc}"/></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>

</body>
</html>