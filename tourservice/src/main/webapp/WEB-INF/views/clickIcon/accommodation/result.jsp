<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/AccommodationSearchResult.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=69b11500eae54120938848c2574ad745&libraries=services"></script>
    <title>방방곡곡 구석구석</title>
</head>
<body>
    <div class="title">
        <%@include file = "/WEB-INF/views/clickIcon/accommodation/search.jsp"%>
        <input value="${member.seq}" id = "id" hidden/>
        <button id = "selectAcc">숙소 저장</button>
    </div>
    <div class="contents">
    </div>
</body>
</html>