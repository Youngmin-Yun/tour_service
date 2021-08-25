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
                let tag = 
                '<div class="title">'+r.accommodation[i].title+'</div>'+
                '<div class="tel">'+r.accommodation[i].tel+'</div>'+
                '<div class="adr">'+r.accommodation[i].addr1+'</div>'
                $(".content").append(tag)
            }
        }
    })
})