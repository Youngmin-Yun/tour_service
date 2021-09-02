$(function () {
    $("#registBtn").click(function(){
        location.href = "/regist"
    })
    $("#myTour").click(function(){
        location.href = "/myinfo"
    })
    $("#loginBtn").click(function(){
        location.href = "/login"
    })
    $(".go").click(function () {
        let search = $(".content").val()
        console.log(search)
        $.ajax({
            type: "get",
            url: "/api/main?region="+search,
            success: function (r) {
                console.log(r)
                location.href = "/search/festival?region="+search
            }
        })
    })
    $("#logoutBtn").click(function(){
        if(confirm("로그아웃 하시겠습니까?")){
            location.href = "/logout"
        }
    })
})