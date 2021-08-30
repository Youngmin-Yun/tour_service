<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/AccommodationSearch.js"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="top">
        <h1>숙소</h1>
    </div>
    <div class="search">
        <div class="place">
            <select id="cata">
                <option value="">전체</option>
                <option value="리조트">리조트</option>
                <option value="호텔">호텔</option>
                <option value="펜션">펜션</option>
                <option value="모텔">모텔</option>
                <option value="여관">여관</option>
                <option value="민박">민박</option>
            </select>
            <input type="text" class = "content" placeholder="지역을 입력해주세요 ex) 제주도"></input>
            <button class="go">검색</button>
            <a href="/">메인으로 가기</a>
        </div>
    </div>
</body>
</html>