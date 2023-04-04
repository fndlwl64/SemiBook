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

#ERD

![ERD](https://user-images.githubusercontent.com/98505324/229707902-662729ab-f80c-4331-bcd3-3b5345747bd5.jpeg)
