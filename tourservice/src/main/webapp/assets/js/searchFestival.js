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
                '<input type="checkbox" name = "check" class="check" value="'+r.festival[i].seq+'">'+
                '<div class="title">' + title + '</div>' +
                '<div class="tel">' + r.festival[i].tel + '</div>' +
                '<div class="adr">' + r.festival[i].addr1 + '</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
                
            }
            // 체크박스 다중 선택했을 경우, 콘솔을 띄우기 위함
            $(".check").click(function(){
                for(let i = 0; i<$(".check:checked").length; i++){
                    console.log($(".check:checked").eq(i).val())
                }
            })
        }
    })
    $("#selectFesti").click(function(){
        let count = $("input:checkbox[name=check]:checked")
        console.log(count.length)
        let data = ""
        count.each(function () {
            var chk = $(this).val();
            data += chk+","
        });
        let id = $("#id").val()
        // 로그인 기능 만들면 id는 케시값으로 해서 입력하도록 해야함
        data = data.substr(0, data.length-1);
        $.ajax({
            type: "post",
            url: "/api/mytourlist/festi?id="+id+"&seq="+data,
            success: function (r) {
                alert(r.message)
            }
        })
    })
})