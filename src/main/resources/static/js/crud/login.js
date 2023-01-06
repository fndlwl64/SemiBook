function loginOption(sub){
    /*전송할 객체 생성*/
    let memberDTO = {};
    for(var i=0; i<sub.length ; i++){
        if(sub.elements[i].name !== ''){
            const name = sub.elements[i].name;
            const value = sub.elements[i].value;
            console.log(name);
            memberDTO[sub.elements[i].name] = sub.elements[i].value;
        }
    }

    let dd= {name:'aaa', id : 'ddd'};
    /*객체 restcontroller에 전송*/
    fetch("get/member", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(memberDTO),
    }).then((response) => response.json()).then((data) => console.log(data));
    return false;
}