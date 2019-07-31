# Node.js 3일차

## Node.js 내장모듈2



### fs



비동기와 동기 파일 읽기



비동기는 순서가 랜덤으로 나온다.



ex)
//async.js -> 비동기 

```js
//async.js
const fs = require('fs');
console.log('시작');
fs.readFile('./readme2.txt', (err, data) => {
  if (err) {
    throw err;
  }
  console.log('1번', data.toString());
});
fs.readFile('./readme2.txt', (err, data) => {
  if (err) {
    throw err;
  }
  console.log('2번', data.toString());
});
fs.readFile('./readme2.txt', (err, data) => {
  if (err) {
    throw err;
  }
  console.log('3번', data.toString());
});
console.log('끝');

```



ex ) sync.js -> 동기

```js
//sync.js

const fs = require('fs');

console.log('시작');
let data = fs.readFileSync('./readme2.txt');
console.log('1번', data.toString());
data = fs.readFileSync('./readme2.txt');
console.log('2번', data.toString());
data = fs.readFileSync('./readme2.txt');
console.log('3번', data.toString());
console.log('끝');

```





실행결과 : 비동기

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190731/images/result1.PNG>)



실행결과:동기

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190731/images/result2.PNG>)



### 

#### fs - 복사

- copyFile() - node 8.5 버전에서 새로 추가된 파일 복사 메서드
- 첫 번째 인자로 복사할 파일을, 두 번째 인자로 복사될 경로를, 세 번째 인자로 복사 후 실행될 콜백 함수를 지정합니다.  



ex)

```js
//copyFile.js

const fs = require('fs');

fs.copyFile('readme4.txt','writeme4.txt', (error) => {
  if (error) {
    return console.error(error);
  }
  console.log('복사 완료');
});

```



실행결과:

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190731/images/result3.PNG>)

