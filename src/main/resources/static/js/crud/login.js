async function loginOption(){
    /*member.js의 함수 사용*/
    let memberDTO = memberForm();
    /*객체 restcontroller에 전송*/
    await fetch('/api/post/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            localStorage.setItem("jwt-tokens",response.grantType+' '+response.accessToken);
        }else{
            alert('fail');
        }
    })
    .catch(() => {
        alert('login fail');
    });
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '/web/main/home', true);
    xhr.setRequestHeader('Authorization', localStorage.getItem('jwt-tokens'));
    xhr.onload = function() {
      if (xhr.status === 200) {
        console.log(xhr.responseText);
      }
    };
    xhr.send();
}