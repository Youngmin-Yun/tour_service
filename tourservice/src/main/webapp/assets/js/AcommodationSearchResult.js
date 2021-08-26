$(function () {
    var type = getParameterByName('type')
    console.log(type)
    var region = getParameterByName('region')
    console.log(region)
    $.ajax({
        type: "get",
        url: "/api/accommodation/result?type=" + type + "&region=" + region,
        success: function (r) {
            console.log(r)
            $(".contents").html("")
            for (let i = 0; i < r.list.length; i++) {
                let tag =
                    '<div class="title">' +
                    '<tr class="contents">' +
                    '<td>' +
                    '<p>숙소명 : ' + r.list[i].title + '</p>' +
                    '</td>' +
                    '<td>' +
                    '<p>전화번호 : ' + r.list[i].tel + '</p>' +
                    '</td>' +
                    '<td>' +
                    '<p>주소 : ' + r.list[i].addr1 + '</p>' +
                    '</td>' +
                    '<td>' +
                    '<div id="staticMap'+r.list[i].seq+'" style="width:300px;height:150px;"></div>' +
                    '</td>' +
                    '</tr>'
                '</div>'
                $(".contents").append(tag)
                // 주소-좌표 변환 객체를 생성합니다
                var geocoder = new kakao.maps.services.Geocoder();

                // 주소로 좌표를 검색합니다
                geocoder.addressSearch(r.list[i].addr1, function (result, status) {

                    // 정상적으로 검색이 완료됐으면 
                    if (status === kakao.maps.services.Status.OK) {

                        var coords = new kakao.maps.LatLng(result[0].x, result[0].y);
                        var markers = [
                            {
                                position: new kakao.maps.LatLng(coords.La, coords.Ma), 
                                text: r.list[i].title  // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
                            }
                        ];
                        
                        var staticMapContainer  = document.getElementById('staticMap'+r.list[i].seq) // 이미지 지도를 표시할 div  
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
// 파라미터 값 가져오는 정규표현식
function getParameterByName(name) { 
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]"); 
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), 
    results = regex.exec(location.search); 
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " ")); 
}
