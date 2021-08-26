$(function () {
    $.ajax({
        type: "get",
        url: "/api/top100place",
        success: function (r) {
            console.log(r)
            $(".contents").html("")
            for (let i = 0; i < r.data.length; i++) {
                let tag =
                    '<div class="title">' +
                    '<tr class="contents">' +
                    '<td>' +
                    '<p>순위 : ' + r.data[i].rk + '위</p>' +
                    '</td>' +
                    '<td>' +
                    '<p>장소명 : ' + r.data[i].itsBroNm + '</p>' +
                    '</td>' +
                    '<td>' +
                    '<p>주소 : ' + r.data[i].dtlAddrNm + '</p>' +
                    '</td>' +
                    '<td>' +
                    '<div id="staticMap'+r.data[i].rk+'"style="width:300px;height:150px;"></div>' +
                    '</td>' +
                    '</tr>'
                '</div>'
                $(".contents").append(tag)
                // 주소-좌표 변환 객체를 생성합니다
                var geocoder = new kakao.maps.services.Geocoder();

                // 주소로 좌표를 검색합니다
                geocoder.addressSearch(r.data[i].dtlAddrNm, function (result, status) {

                    // 정상적으로 검색이 완료됐으면 
                    if (status === kakao.maps.services.Status.OK) {

                        var coords = new kakao.maps.LatLng(result[0].x, result[0].y);
                        console.log(coords)
                        var markers = [
                            {
                                position: new kakao.maps.LatLng(coords.La, coords.Ma), 
                                text: r.data[i].itsBroNm  // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
                            }
                        ];
                        
                        var staticMapContainer  = document.getElementById('staticMap'+r.data[i].rk) // 이미지 지도를 표시할 div  
                        var staticMapOption = { 
                                center: new kakao.maps.LatLng(coords.La, coords.Ma), // 이미지 지도의 중심좌표
                                level: 6, // 이미지 지도의 확대 레벨
                                marker: markers // 이미지 지도에 표시할 마커 
                            };    
                        // 이미지 지도를 생성합니다
                        var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
                    }
                });
            }
        }
    })
})