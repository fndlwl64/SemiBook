function joinOption(){
    /*member.js의 함수 사용*/
    memberDTO = memberForm();
    /*member 객체 restcontroller에 전송*/
    fetch("/api/post/member",{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            location.href = '/user/login';
        }else{
            alert('fail');
        }
    })
    .catch(() => {
        alert('fail');
    });

}