<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/memberRegist.js"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="top">
        <img src="https://cdn.icon-icons.com/icons2/426/PNG/512/Map_1135px_1195280_42272.png" style="height: 100px; width: 100px;" onclick="location.href='/'">
        <h1 id = "title">회원가입</h1>
    </div>
    <div class="content">
        <p>아이디</p>
        <input type="text" id="id"></input>
        <button id = "confirmId">중복확인</button>
        <p>비밀번호</p>
        <input type="password" id="pwd"></input>
        <p>비밀번호 확인</p>
        <input type="password" id="confirmPwd"></input>
        <p>이메일</p>
        <input type="text" id="email"></input>
        <p>이름</p>
        <input type="text" id="name"></input>
        <p>전화번호</p>
        <input type="text" id="phone"></input>
        <p>주소</p>
        <input type="text" id="address"></input>
    </div>
    <div class="regist">
        <button id = "registBtn">회원가입</button>
    </div>
</body>
</html>