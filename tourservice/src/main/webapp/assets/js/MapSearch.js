$(function () {
    $(".go").click(function () {
        let region = $(".content").val()
        console.log(region)
        $.ajax({
            type: "get",
            url: "/api/mapsearch/regionaltour?region=" + region,
            success: function (r) {
                console.log(r)
                for (let p = 0; p < r.list.length; p++) {
                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
                        mapOption = {
                            center: new kakao.maps.LatLng(r.list[0].mapy, r.list[0].mapx), // 지도의 중심좌표
                            level: 5// 지도의 확대 레벨
                        };
                }
                var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다  
                for (let i = 0; i < r.list.length; i++) {
                    var positions = [{
                        content: '<div"> 관광지명 : ' + r.list[i].title + '</div>' +
                            '<div>' + "관광지 주소 : " + r.list[i].addr1 + '</div>',
                        latlng: new kakao.maps.LatLng(r.list[i].mapy, r.list[i].mapx)
                    }]
                    console.log(r.list[i].institutionNm)
                    for (var j = 0; j < positions.length; j++) {
                        // 마커를 생성합니다
                        var marker = new kakao.maps.Marker({
                            map: map, // 마커를 표시할 지도
                            position: positions[j].latlng // 마커의 위치
                        });

                        // 마커에 표시할 인포윈도우를 생성합니다 
                        var infowindow = new kakao.maps.InfoWindow({
                            content: positions[j].content // 인포윈도우에 표시할 내용
                        });
                        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                    }
                    // 마커 이미지의 이미지 주소입니다
                    function makeOverListener(map, marker, infowindow) {
                        return function () {
                            infowindow.open(map, marker);
                        };
                    }
                    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
                    function makeOutListener(infowindow) {
                        return function () {
                            infowindow.close();
                        };
                    }
                }
            }
        })
    })


})