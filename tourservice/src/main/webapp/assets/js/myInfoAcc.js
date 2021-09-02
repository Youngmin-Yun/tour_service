$(function(){
    let id = $("#id").val()
    console.log(id)
    $.ajax({
        type:"get",
        url:"/api/select/mytouracc?seq="+id,
        success:function(r){
            console.log(r)
            $(".content").html("")
            for(let i = 0; i < r.list.length; i++){
                var lat = r.list[i].mapy
                var lng = r.list[i].mapx
                var title = r.list[i].title 
                let tag = 
                '<div class="title">' + title + '</div>' +
                '<button id = "delete" value = "'+r.list[i].seq+'">삭제</button>'+
                '<div class="tel">' + r.list[i].tel + '</div>' +
                '<div class="adr">' + r.list[i].addr1 + '</div>'+
                '<a href="https://map.kakao.com/link/map/'+title+','+lat+','+lng+'" target="_blank">지도보기</a>'

                $(".content").append(tag)
            }
            $("#delete").click(function(){
                let seq = $("#delete").val()
                $.ajax({
                    type:"delete",
                    url:"/api/delete/mytouracc?id="+id+"&seq="+seq,
                    success:function(r){
                        alert(r.message)
                        location.reload()
                    }
                })
            })
        }
    })
})