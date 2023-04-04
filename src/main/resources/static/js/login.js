const joinInput = document.querySelector('#join');
const articleTag = document.querySelector('#article');

/*HTML 스크립트*/
joinInput.addEventListener('click',(event)=>{

    event.preventDefault();
    document.head.removeChild(document.head.lastChild);

    /*RestAPI 에 접속하기 위한 js*/
    let script = document.createElement('script');
    script.src = '/js/crud/login.js';
    document.head.appendChild(script);
    script = document.createElement('script');
    script.src = '/js/crud/member.js';
    document.head.appendChild(script);

    while (articleTag.firstChild) {
      articleTag.removeChild(articleTag.firstChild);
    };

    articleTag.insertAdjacentHTML('afterbegin',
    `
        <form>
          <table>
            <tr>
              <th>NAME : </th>
              <td>
                <input type="text" name="name">
              </td>
            </tr>
            <tr>
              <th>GENDER : </th>
              <td>
                <select name="gender" name="gender">
                  <option value="MALE">male</option>
                  <option value="FEMALE">female</option>
                </select>
              </td>
            </tr>
            <tr>
              <th>ID : </th>
              <td>
                <input type="text" name="userId">
              </td>
            </tr>
            <tr>
              <th>PASSWORD : </th>
              <td>
                <input type="text" name="password">
              </td>
            </tr>
            <tr>
              <th>PASSWORD CHECK : </th>
              <td>
                <input type="password" id="pwdcheck">
              </td>
            </tr>
            <tr>
              <th>PHONE NUMBER : </th>
              <td>
                <input type="text" name="phone">
              </td>
            </tr>
            <tr>
              <th>EMAIL : </th>
              <td>
                <input type="text" name="email">
              </td>
            </tr>
            <tr>
              <th>ADDRESS : </th>
              <td>
                <input type="text" name="address">
              </td>
            </tr>
            <tr align="center">
              <td colspan="2"><input type="button" value="submit" onclick="return joinOption();"></input></td>
            </tr>
          </table>
        </form>
    `
    );
});
