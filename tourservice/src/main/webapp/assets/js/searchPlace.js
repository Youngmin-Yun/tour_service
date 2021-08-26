$(function(){
    var region = document.location.href.split("=")
    console.log(region[1])
    $.ajax({
        type:"get",
        url:"/api/search/tour?region="+region[1],
        success:function(r){
            console.log(r)
            $(".content").html("")
            for(let i = 0; i<r.tour.length; i++){
                var lat = r.tour[i].mapy
                var lng = r.tour[i].mapx
                var title = r.tour[i].title 
                let tag = 
                '<div class="title">'+title+'</div>'+
                '<div class="adr">'+r.tour[i].addr1+'</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
        }
    })
})