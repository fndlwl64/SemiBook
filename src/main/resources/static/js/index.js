window.onload = function(){
    const headerTag = document.querySelector('#header');
    const sectionTag = document.querySelector('#section');
    const articleTag = document.querySelector('#article');
    const loginInput = document.querySelector('#login');
    console.log('success');
    loginInput.addEventListener('click',(event)=>{
        event.preventDefault();

        const script = document.createElement('script');
        script.src = '/js/login.js';
        document.head.appendChild(script);

//        headElement.innerHTML =
//        `
//            <meta charset="UTF-8">
//            <title>Login</title>
//            <script src="/js/index.js"></script>
//            <script src="/js/login.js"></script>
//            <script src="/js/crud/member.js"></script>
//            <script src="/js/crud/login.js"></script>
//        `

        articleTag.innerHTML =
        `
        <form>
          <table>
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
              <td><div id="join"><input type="button" value="Join"></input></div></td>
            </tr>
          </table>
        </form>
        `;
    });
}