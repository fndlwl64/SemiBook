window.onload = function(){
    const headElement = document.head;
    const headerTag = document.querySelector('#header');
    const sectionTag = document.querySelector('#section');
    const articleTag = document.querySelector('#article');
    const loginInput = document.querySelector('#login');

    loginInput.addEventListener('click',(event)=>{
        event.preventDefault();
        headElement.innerHTML =
        `
            <meta charset="UTF-8">
            <title>Login</title>
            <script src="/js/crud/member.js"></script>
            <script src="/js/crud/login.js"></script>
        `

        articleTag.innerHTML =
        `
        <form>
          <table id="login">
            <tr>
              <th>id</th>
              <td><input type="text" name="userId"></td>
            </tr>
            <tr>
              <th>password</th>
              <td><input type="password" name="password"></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input type="button" value="submit" onclick="return loginOption();"></td>
            </tr>
            <tr>
              <td><a href="/user/join">Join</a></td>
              <td><a href="/user/find_id">Find ID</a></td>
              <td><a href="/user/find_pwd">Find PWD</a></td>
            </tr>
          </table>
        </form>
        `;
    });
}