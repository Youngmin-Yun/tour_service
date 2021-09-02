$(function(){
    let id = $("#id").val()
    $.ajax({
        type:"get",
        url:"/api/mytourlist/list?seq="+id,
        success:function(r){
            $(".content").html("")
            for(let i = 0; i < r.list.length; i++){
                var lat = r.list[i].mapy
                var lng = r.list[i].mapx
                var title = r.list[i].title 
                let tag = 
                '<div class="title">' + title + '</div>' +
                '<button class = "delete"  data-seq="'+r.list[i].seq+'">삭제</button>'+
                '<div class="adr">' + r.list[i].addr1 + '</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'
                $(".content").append(tag)
            }
            $(".delete").click(function(){
                let seq = $(this).attr("data-seq")
                $.ajax({
                    type:"delete",
                    url:"/api/delete/mytourPlace?id="+id+"&seq="+seq,
                    success:function(r){
                        alert(r.message)
                        location.reload()
                    }
                })
            })
        }
    })
})