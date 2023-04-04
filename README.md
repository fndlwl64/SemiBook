# SemiBook

개인 프로젝트
- 회원 도메인
- Rest API로 기능 구현 + 자바스크립트 fetch 함수로 클라이언트 비동기적 데이터 처리

# 기술 스택
- JAVA , SpringBoot(2.7.7) , JPA, MySQL

# 프로젝트 구조
```bash
src
├─main
│  ├─generated
│  │  └─com
│  │      └─semi
│  │          └─book
│  │              └─dto
│  ├─java
│  │  └─com
│  │      └─semi
│  │          └─book
│  │              ├─api
│  │              ├─common
│  │              │  ├─config
│  │              │  └─jwt
│  │              ├─controller
│  │              ├─domain
│  │              ├─dto
│  │              ├─repository
│  │              └─service
│  └─resources
│      ├─static
│      │  ├─js
│      │  │  └─crud
│      │  ├─main
│      │  └─member
│      └─templates
└─test
    ├─generated_tests
    └─java
        └─com
            └─semi
                └─book
```

# ERD

![ERD](https://user-images.githubusercontent.com/98505324/229707902-662729ab-f80c-4331-bcd3-3b5345747bd5.jpeg)

# API
## 회원
- 로그인 'post/login'
- 회원가입 'post/member'
- 아이디 조회 'get/findId'
- 비밀번호 조회 'get/findPwd'

# Layerd Architecture 구현 패턴

![Layered Architecture](https://user-images.githubusercontent.com/98505324/229719978-f1df2ed6-ee50-4a8a-8b5c-96a7244b2e6b.jpeg)

- 각 레이어는 바로 밑의 레이어에만 영향을 끼치도록 설계
- 데이터를 가져올 때 DTO와 Entity(Domain Model) 객체를 구분하여 Repository에 접근하는 Entity을 독립시켜 변형을 최소화하고 클라이언트 요청을 받는 DTO의 객체를 유연하게 변경할 수 있도록 설계
- DTO에서 Entity 객체로 변환하는 객체를 매번 만드는 것은 번거롭고 실수가 생길 수 있음으로 MapStruct 라이브러리를 통해 변환해주는 인터페이스 생성

# 보안
### JWT
- Rest API에 맞는 로그인 보안 방식으로 토큰 인증 방식 사용
- 서버의 무상태성 유지함으로써 서버의 부담을 줄임
### DB와 JWT 비밀번호
- application-secret.yml에 따로 보관
- gitignore에 포함시켜 깃허브에 올라오지 않도록 

# 웹 페이지

- 템플릿 엔진 없이 자바스크립트만으로 웹 페이지 개발 시도
- 페이지 이동은 location.href / 비동기적 데이터 처리는 fetch 함수로 Rest Api를 사용하도록 설계
    - MPA 방식으로 웹 페이지 개발 시 JWT로 생성된 토큰이 웹 페이지에 남아있지 않은 문제 발생
    - 해결책으로 HTML 문서를 랜더링하지 않고 HTML 문서의 정보를 가지는 JS 파일만을 가져오도록 해서 토큰이 사라지지않도록 설계
    - `sample`
```
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
       --- HTML 문서 정보 ---
    `
    );
});
```
 
 # 실행
 자바 11 버전으로 실행이 가능하고 gradle로 개발했음으로 gradle.bat를 build 하면 됩니다.
 
 - gradle.bat을 빌드
 - 생성된 디렉토리 내부로 이동
 - jar 파일 실행
 ```bash
 $ gradle.bat build
 $ cd build/libs
 $ java -jar [jar 파일 이름].jar
```


