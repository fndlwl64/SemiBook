async function loginOption(){
    let memberDTO = {
        userId : document.getElementsByName('userId')[0].value,
        password : document.getElementsByName('password')[0].value
    };
    console.log(memberDTO);

    let check = false;
    /*객체 restcontroller에 전송*/

    await fetch('api/post/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(memberDTO),
    })
    .then(response => response.json())
    .then(response => {
        if(response){
            localStorage.setItem("jwt-token",response.accessToken);
            check = true;
        }
    });

    console.log(await check);
    if(await check === false){
        alert('login fail');
    }else{
        location.href = 'main';
    }
}