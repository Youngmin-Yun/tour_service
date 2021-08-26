$(function () {
    var region = document.location.href.split("=")
    console.log(region[1])
    $.ajax({
        type: "get",
        url: "/api/search/festival?region=" + region[1],
        success: function (r) {
            console.log(r)
            $(".content").html("")
            for (let i = 0; i < r.festival.length; i++) {
                var lat = r.festival[i].mapy
                var lng = r.festival[i].mapx
                var title = r.festival[i].title 
                let tag =
                    '<div class="title">' + title + '</div>' +
                    '<div class="tel">' + r.festival[i].tel + '</div>' +
                    '<div class="adr">' + r.festival[i].addr1 + '</div>'+
                    '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
        }
    })
})