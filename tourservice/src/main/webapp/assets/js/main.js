$(function () {
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
})