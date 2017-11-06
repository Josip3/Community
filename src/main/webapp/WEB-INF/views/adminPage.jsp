<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="icon" href="/image/kek.bmp">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="boot/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../boot/css/bootstrap.css">
    <link rel="stylesheet" href="../css/adminstyle.css">
</head>
<body>



<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
            <div id="sidebar" class="well sidebar-nav">
                <h5><i class="glyphicon glyphicon-home"></i>
                    <small><b>ADMIN</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">Add</a></li>
                    <li><a href="#">Search</a></li>
                </ul>
                <h5><i class="glyphicon glyphicon-user"></i>
                    <small><b>USER</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a class="glyphicon glyphicon-list" href="#"> User List</a></li>
                    <li><a class="glyphicon glyphicon-stats" href="#"> Statistic</a></li>
                </ul>

            </div>
        </div>
        <div class="col-md-8">

            <div class="col-md-8"id="users">
                <div id="sidebars" class="well sidebar-nav">
                    <h5><i class="glyphicon glyphicon-user"></i>
                        <small><b>User List</b></small>
                    </h5>
                    <c:forEach items="${users}" var="user">

                        <h5 class="userList">
                             <label>ID      : </label>    ${user.id}       <br>
                             <label>Имя     : </label>    ${user.name}     <br>
                             <label>Возраст : </label>    ${user.age}      <br>
                             <label>Фамилия : </label>    ${user.lastName} <br>
                             <label>Почта   : </label>    ${user.email}    <br>
                             <label>Пароль  : </label>    ${user.password} <br>
                        </h5>

                        <form action="/user/delete/${user.id}" method="get">
                            <input type="submit" value="delete user">
                        </form>

                        <form action="/update/name/${user.id}" method="get">
                            <input type="submit" value="update name">
                            <input type="text" placeholder="${user.name}">
                        </form>

                        <form action="update/surname/${user.id}" method="get">
                            <input type="submit" value="update lastn">
                            <input type="text" placeholder="${user.lastName}">
                        </form>

                        <form action="/update/age/${user.id}" method="get">
                            <input type="submit" value="update   age">
                            <input type="text" placeholder="${user.age}">
                        </form>

                        <br>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>