<%-- 
    Document   : index
    Created on : Jan 30, 2018, 11:37:13 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate Example</title>
    </head>
    <body>
    <center>
        <form method="post" action="add">
            <table>
                <tr>
                    <td>Enter Name:<input type="text" placeholder="Insert your name" name="name"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Click"/></td>
                </tr>
            </table>
        </form>
        <form method="post" action="del">
            <table>
                <tr>
                    <td>Enter Name:<input type="text" placeholder="Delete your name" name="name"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Click"/></td>
                </tr>
            </table>
        </form>
        <form method="post" action="update">
            <table>
                <tr>
                    <td>Enter Name:<input type="text" placeholder="Update your name" name="name"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Click"/></td>
                </tr>
            </table>
        </form>
        <form method="post" action="display">
            <table>
                <tr>
                    <td><input type="submit" value="Click to Display"/></td>
                </tr>
            </table>
        </form>
    </center> 
    <center>
        <h1>${inserted}</h1>
        <h2>${del}</h2>
        <h3>${updated}</h3>
        <h4>${display}</h4>

    </center>
</body>
</html>
