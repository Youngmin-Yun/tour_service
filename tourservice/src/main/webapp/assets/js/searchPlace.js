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
                let tag = 
                '<div class="title">'+r.tour[i].title+'</div>'+
                '<div class="adr">'+r.tour[i].addr1+'</div>'
                $(".content").append(tag)
            }
        }
    })
})