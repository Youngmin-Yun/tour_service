$(function () {
    var region = document.location.href.split("=")
    console.log(region[1])
    $.ajax({
        type: "get",
        url: "/api/search/tour?region=" + region[1],
        success: function (r) {
            console.log(r)
            $(".content").html("")
            for (let i = 0; i < r.tour.length; i++) {
                var lat = r.tour[i].mapy
                var lng = r.tour[i].mapx
                var title = r.tour[i].title
                let tag =
                    '<input type="checkbox" name = "check" class="check" value="' + r.tour[i].seq + '">' +
                    '<div class="title">' + title + '</div>' +
                    '<div class="adr">' + r.tour[i].addr1 + '</div>' +
                    '<a href="https://map.kakao.com/link/map/' + title + ',' + lat + ',' + lng + '" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
        }
    })
    $("#selectPlc").click(function () {
        let count = $("input:checkbox[name=check]:checked")
        console.log(count.length)
        let data = ""
        count.each(function () {
            var chk = $(this).val();
            data += chk+","
        });
        data = data.substr(0, data.length-1);
        let id = $("#id").val()
        $.ajax({
            type: "post",
            url: "/api/mytourlist/list?id="+id+"&seq="+data,
            success: function (r) {
                alert(r.message)
            }
        })
    })
})