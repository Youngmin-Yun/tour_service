<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/main.js"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="title">
        <h1>방방곡곡 구석구석</h1>
    </div>
    <div class="search">
        <div class="place">
            <input type="text" class = "content" placeholder="어디 가보실래요? ex) 제주도"></input>
            <button class="go">검색</button>
        </div>
    </div>
    <div class="shortcut">
        <a href="/search/accom" class="accommodation">숙소 검색</a>
        <a href="/map" class="map">지도 검색</a>
        <a href="/topCafeAndRestaurant" class="topCafe">많이 찾는 식당 & 카페 top100</a>
        <a href="/top100place" class="topPlace">많이 찾는 장소 top100</a>
    </div>
</body>
</html>