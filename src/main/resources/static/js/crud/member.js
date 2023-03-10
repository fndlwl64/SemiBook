function memberForm(){
    /*form 태그 내의 회원 정보*/
    const sub = document.forms[0];
    let memberDTO = {};
    for(var i=0; i<sub.length; i++){
        if(sub.elements[i].name !== ''){
            memberDTO[sub.elements[i].name] = sub.elements[i].value;
        }
    }
    return memberDTO;
}
