<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/MapSearch.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=69b11500eae54120938848c2574ad745"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="top">
        <h1>지도로 관광지 검색</h1>
        <div class="search">
            <div class="place">
                <input type="text" class = "content" value="제주" placeholder="어디 가보실래요? ex) 제주도"></input>
                <button class="go">검색</button>
                <a href="/">메인으로 가기</a>
            </div>
        </div>
    </div>
    <div class="contents">
        <div id="map" style="width:100%;height:800px;"></div>
    </div>
</body>
</html>