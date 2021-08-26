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
                '<div class="title">'+title+'</div>'+
                '<div class="tel">'+r.accommodation[i].tel+'</div>'+
                '<div class="adr">'+r.accommodation[i].addr1+'</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
        }
    })
})