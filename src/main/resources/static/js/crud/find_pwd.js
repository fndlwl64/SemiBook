function findPwd(){
    /*member.js의 함수 사용*/
    memberDTO = memberForm();
    /*member 객체 restcontroller에 전송*/
    fetch('/api/get/findPwd',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            alert('your password : '+response.password);
        }else{
            alert('wrong ID or email!');
        }
    })
    .catch(() => {
        alert('wrong ID or email!');
    });
}