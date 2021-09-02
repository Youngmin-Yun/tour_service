<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/login.js"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <img src="https://cdn.icon-icons.com/icons2/426/PNG/512/Map_1135px_1195280_42272.png" style="height: 100px; width: 100px;" onclick="location.href='/'">
        <h1>방방곡곡 구석구석</h1>
    <div class="login_form">
        <input type="text" placeholder="아이디" id = "user_id">
        <input type="password" placeholder="비밀번호" id = "user_pwd">
        <button id = "btn">로그인</button>
    </div>
</body>
</html>