<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>详细信息</title>
</head>
<body>
    <form action="/mergeemp" method="post">
        <table>
            <tr>
                <td>编号</td>
                <td><input name="empno" value="${emp.empno?c}"/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input name="ename" value="${emp.ename}"/></td>
            </tr>
            <tr>
                <td>工作</td>
                <td><input name="job" value="${emp.job}"/></td>
            </tr>
            <tr>
                <td>上司</td>
                <td><input name="mgr" value="${emp.mgr?c}"/></td>
            </tr>
            <tr>
                <td>日期</td>
                <td><input name="hiredate" value="${emp.hiredate}"/></td>
            </tr>
            <tr>
                <td>工资</td>
                <td><input name="sal" value="${emp.sal?c}"/></td>
            </tr>
            <tr>
                <td>奖金</td>
                <td><input name="comm" value="${emp.comm?c}"/></td>
            </tr>
            <tr>
                <td>部门</td>
                <td><input name="deptno" value="${emp.deptno?c}"/></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>