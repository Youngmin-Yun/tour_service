$(function () {
    $("#cata").change(function () {
        let type = $(this).find("option:selected").val()
        getType(type)
    })
    getType("")
    function getType(type) {
        $(".go").click(function () {
            let region = $(".content").val()
            console.log(region)
            let url = "/api/accommodation/search"
            $.ajax({
                type: "get",
                url: url,
                success: function (r) {
                    console.log(r)
                    location.href = "/search/accom/result?type="+type+"&region="+region
                }
            })
        })
    }
})