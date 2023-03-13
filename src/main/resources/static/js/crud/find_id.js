function findId(){
    /*member.js의 함수 사용*/
    memberDTO = memberForm();
    /*member 객체 restcontroller에 전송*/
    fetch('/api/get/findId',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            alert('your id : '+response.userId);
        }else{
            alert('wrong name or email!');
        }
    })
    .catch(() => {
        alert('wrong name or email!');
    });
}