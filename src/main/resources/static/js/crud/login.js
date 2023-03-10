function loginOption(){
    /*member.js의 함수 사용*/
    let memberDTO = memberForm();
    /*객체 restcontroller에 전송*/
    fetch('/api/post/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            console.log(response);
            localStorage.setItem("jwt-token",response.grantType+' '+response.accessToken);
            location.href = '/web/main/home';
        }else{1
            alert('fail');
        }
    })
    .catch(() => {
        alert('login fail');
    });
}