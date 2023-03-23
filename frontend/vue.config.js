const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: "../src/main/resources/static",  // 빌드 타겟 디렉토리
  devServer: {

    proxy: {
        '/api': {
          // '/api' 로 들어오면 포트 8081(스프링 서버)로 보낸다
          target: 'http://localhost:8081',
          changeOrigin: true // cross origin 허용
        }
    }
  }
})
//module.exports = {
//  // npm run build 타겟 디렉토리
//  outputDir: '../src/main/resources/static',
//
//  // npm run serve 개발 진행시에 포트가 다르기때문에 프록시 설정
//  devServer: {
//    proxy: 'http://localhost:8082'
//  }
//};