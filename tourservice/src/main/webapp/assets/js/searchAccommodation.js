$(function(){
    var region = document.location.href.split("=")
    console.log(region[1])
    $.ajax({
        type:"get",
        url:"/api/search/accommodation?region="+region[1],
        success:function(r){
            console.log(r)
            $(".content").html("")
            for(let i = 0; i<r.accommodation.length; i++){
                var lat = r.accommodation[i].mapy
                var lng = r.accommodation[i].mapx
                var title = r.accommodation[i].title 
                let tag = 
                '<input type="checkbox" name = "check" class="check" value="'+r.accommodation[i].seq+'">'+
                '<div class="title">'+title+'</div>'+
                '<div class="tel">'+r.accommodation[i].tel+'</div>'+
                '<div class="adr">'+r.accommodation[i].addr1+'</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
        }
    })
    $("#selectAcc").click(function(){
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
            url: "/api/insert/mytouracc?id="+id+"&seq="+data,
            success: function (r) {
                alert(r.message)
            }
        })
    })
})