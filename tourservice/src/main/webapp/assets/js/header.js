$(function () {
    var region = document.location.href.split("=")
    console.log(region[1])
    $("#festival").click(function () {
        location.href = "/search/festival?region=" + region[1]
    })
    $("#place").click(function () {
        location.href = "/search/place?region=" + region[1]
    })
    $("#accommodation").click(function () {
        location.href = "/search/accommodation?region=" + region[1]
    })
    $(".go").click(function () {
        let search = $(".content").val()
        console.log(search)
        $.ajax({
            type: "get",
            url: "/api/search/festival?region=" + search,
            success: function (r) {
                console.log(r)
                location.href = "/search/festival?region="+search
                $(".content").html("")
                for (let i = 0; i < r.festival.length; i++) {
                    let tag =
                        '<div class="title">' + r.festival[i].title + '</div>' +
                        '<div class="tel">' + r.festival[i].tel + '</div>' +
                        '<div class="adr">' + r.festival[i].addr1 + '</div>'
                    $(".content").html(tag)
                }
            }
        })
    })
})