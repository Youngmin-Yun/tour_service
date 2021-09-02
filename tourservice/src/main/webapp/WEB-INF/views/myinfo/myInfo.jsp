<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/myInfo.js"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="title">
        <img src="https://cdn.icon-icons.com/icons2/426/PNG/512/Map_1135px_1195280_42272.png" style="height: 100px; width: 100px;" onclick="location.href='/'">
        <h1>내가 만든 여행</h1>
    </div>
    <input value="${member.seq}" id = "id" hidden/>
    <a id="festival">행사</a>
    <a id="place">관광지</a>
    <a id="accommodation">숙소</a>
</body>
</html>