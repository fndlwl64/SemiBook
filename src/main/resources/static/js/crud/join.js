function joinOption(sub){
    let memberDTO = {};
    for(var i=0; i<sub.length; i++){
        if(sub.elements[i].name !== ''){
            memberDTO[sub.elements[i].name] = sub.elements[i].value;
        }
    }

    console.log(JSON.stringify(memberDTO));
    /*member 객체 restcontroller에 전송*/
    fetch("post/member",{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(memberDTO),
    }).then((response) => response.json()).then((data) => console.log(data))

    return true;
}