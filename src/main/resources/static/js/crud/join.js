async function joinOption(sub){
    let memberDTO = {};
    for(var i=0; i<sub.length; i++){
        if(sub.elements[i].name !== ''){
            memberDTO[sub.elements[i].name] = sub.elements[i].value;
        }
    }
    /*member 객체 restcontroller에 전송*/
    const response = await fetch("api/post/member",{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(memberDTO),
    });

    /*디버깅 시 문제*/
    let promise = await response.json();

    if (promise === 1){
        console.log('success')
        return true;
    }else if(promise === 0){
        alert('fail')
        /*임시 해결책*/
        location.href = "/join";
        /*return false 가 안 먹혀서 html 파일에서 form 태그의 action이 작동하는 문제 있음*/
        return false;
    }
}