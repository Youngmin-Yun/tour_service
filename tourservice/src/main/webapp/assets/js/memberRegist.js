$(function(){
    let idcheck = false;
    $("#confirmId").click(function(){
        const pattern = /\s/g;
        let id = $("#id").val()
        if(id == "" || id == null || id == undefined){
            alert("아이디를 입력해주세요")
            return
        }
        if(id.match(pattern)){
            alert("아이디에 공백이 있습니다")
            return
        }
        $.ajax({
            type:"get",
            url:"/api/memberRegist/id?id="+id,
            success:function(r){
                alert(r.message)
                idcheck = !r.status
            }
        })
    })
    $("#registBtn").click(function(){
        if(idcheck == false){
            alert("아이디 중복확인 해주세요")
            return
        }
        const pattern = /\s/g;
        let id = $("#id").val()
        if(id == "" || id == null || id == undefined){
            alert("아이디를 입력해주세요")
            return
        }
        let pwd = $("#pwd").val()
        if(pwd == "" || pwd == null || pwd == undefined){
            alert("비밀번호를 입력해주세요")
            return
        }
        if(pwd.match(pattern)){
            alert("비밀번호에 공백이 있습니다")
            return
        }
        let confirmPwd = $("#confirmPwd").val()
        if(pwd != confirmPwd){
            alert("비밀번호가 일치하지 않습니다")
            return
        }
        let name = $("#name").val()
        if(name == "" || name == null || name == undefined){
            alert("이름을 입력해주세요")
            return
        }
        if(name.match(pattern)){
            alert("이름에 공백이 있습니다")
            return
        }
        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 이메일 확인하는 정규표현식
        let email = $("#email").val()
        if(email == "" || email == null || email == undefined){
            alert("이메일을 입력해주세요")
            return
        }
        if(!email.match(patternEmail)){
            alert("올바른 이메일 형식으로 입력해주세요")
            return
        }
        let address = $("#address").val()
        
        const patternPhone = /^\d{3}-\d{3,4}-\d{4}$/;
        let phone = $("#phone").val()
        if(phone == "" || phone == null || phone == undefined){
            alert("전화번호를 입력해주세요")
            return
        }
        if(!phone.match(patternPhone)){
            alert("올바른 전화번호 형식으로 입력해주세요 ex)010-1234-5678")
            return
        }
        let data = {
            mb_name: name,
            mb_pwd: pwd,
            mb_email: email,
            mb_id: id,
            mb_phone: phone,
            mb_address: address
        }
        console.log(data)
        $.ajax({
            type:"post",
            url:"/api/memeberRegist",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message)
                if(r.status){
                    location.href="/"
                }
            },
            error:function(e){
                console.log(e)
            }
        })
    })
})