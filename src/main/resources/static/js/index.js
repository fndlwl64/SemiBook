window.onload = function(){
    const headerTag = document.querySelector('#header');
    const sectionTag = document.querySelector('#section');
    const articleTag = document.querySelector('#article');
    const loginInput = document.querySelector('#login');

    /*HTML 스크립트*/
    loginInput.addEventListener('click',(event)=>{
        event.preventDefault();
        /*새로운 페이지에 필요한 js*/
        const script = document.createElement('script');
        script.src = '/js/login.js';
        document.head.appendChild(script);

        while (articleTag.firstChild) {
          articleTag.removeChild(articleTag.firstChild);
        };

        articleTag.insertAdjacentHTML('afterbegin',
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
        `
        );
    });
}