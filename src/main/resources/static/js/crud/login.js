function loginOption(){
    console.log('form : '+document.form);
    const sub = document.forms[0];

    let memberDTO = {};
    for(var i=0; i<sub.length; i++){
        if(sub.elements[i].name !== ''){
            memberDTO[sub.elements[i].name] = sub.elements[i].value;
        }
    }
    console.log(memberDTO);
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