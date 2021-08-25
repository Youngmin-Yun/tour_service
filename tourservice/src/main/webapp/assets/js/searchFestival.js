$(function(){
    var region = document.location.href.split("=")
    console.log(region[1])
    $.ajax({
        type:"get",
        url:"/api/search/festival?region="+region[1],
        success:function(r){
            console.log(r)
            $(".content").html("")
            for(let i = 0; i<r.festival.length; i++){
                let tag = 
                '<div class="title">'+r.festival[i].title+'</div>'+
                '<div class="tel">'+r.festival[i].tel+'</div>'+
                '<div class="adr">'+r.festival[i].addr1+'</div>'
                $(".content").append(tag)
            }
        }
    })
})