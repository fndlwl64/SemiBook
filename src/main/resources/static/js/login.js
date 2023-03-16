const joinInput = document.querySelector('#join');
const articleTag = document.querySelector('#article');
console.log(joinInput);
joinInput.addEventListener('click',(event)=>{
    console.log(event);
    event.preventDefault();

    articleTag.innerHTML = `
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
});
