# Node.js 2일차



## Node.js 내장모듈



- Node.js 는 모듈로 생성 가능하다.

- 모듈 하나가 여러 개의 모듈을 사용할 수 있다

- 모듈 하나가 여러 개의 모듈에 사용될 수도 있다.

  

ex)
calc.js

```js
function add(a, b) {
  return a + b;
}
module.exports = add;
```

main.js

```js
const add = require('./calc.js');
console.log(add(1, 2)); // 3
```

##### ※require : 함수 안에 불러올 모듈의 경로 지정 (파일 경로에서 js나 json 같은 확장자는 생략 가능)



node main 하면 3이 출력됨.



ex2)

##### require을 하게 되면 객체를 통째로 가져오기 때문에 따로 .add나 .multiply로 속성에 접근해야 한다.

calc.js

```js
function add(a, b) {
  return a + b;
}
function substract(a, b) {
  return a - b;
}
function multiply(a, b) {
  return a * b;
}
function divide(a, b) {
  return a / b;
}
module.exports = {
  add: add,
  substract: substract,
  multiply: multiply,
  divide: divide
};
```

main.js

```js
const add = require('./calc.js').add;
const multiply = require('./calc.js').multiply;

console.log(multiply(add(1,2), add(2,3))); // 15
```



모듈을 통째로 옮겨주려면 exports를 사용,

하나하나 옮겨주려면 export를 사용한다.

ex3)

calc.js

```js
exports.add = function(a, b) {
  return a + b;
};

exports.substract = function(a, b) {
  return a - b;
};

exports.multiply = function(a, b) {
  return a * b;
};

exports.divide = function(a, b) {
  return a / b;
};
```

main.js

```js
const add = require('./calc.js').add;
const multiply = require('./calc.js').multiply;

console.log(multiply(add(1,2), add(2,3)); // 15
```







#### **ES2015** **모듈**

- 자바스크립트  자체 모듈 시스템 문법

- ##### require와 module.exports가 import, export default로 바뀌었습니다. 

- 노드에서도 9 버전부터 ES2015의 모듈 시스템을 사용 가능

- 파일의 확장자를 mjs로 지정해야 합니다.

- 실행 시 node --experimental-modules [파일명] 

(node.js 10버전은 실행 X, 12버전부터 호환됨.)



#### **global** **객체**

- 브라우저의 window와 같은 전역 객체

- 모든 파일에서 접근 가능

- global도 생략 가능 (require 함수는 global.require에서 global이 생략된 것입니다, console 객체도  global.console입니다.)

- 노드에는 DOM이나 BOM이 없어 window와 document 객체를 사용할 수 없습니다. 

- global 전역객체는 간단한 데이터를 파일끼리 공유할 때 사용하기도 합니다



ex)

```js
//globalA.js
module.exports = () => global.message;
```



```js
//globalB.js
const A = require('./globalA');
global.message ='안녕하세요';
console.log(A());
```

global.message 전역객체를 공유한다.







### **console** **객체**

- console 객체는 디버깅을 위해 사용 (개발 중 변수에 값 확인, 에러 발생 시 에러 내용을 콘솔에 출력, 코드 실행 시간 확인)

- **console.time(****레이블****)** : console.timeEnd(레이블)과 대응되어 같은 레이블을 가진 time과 timeEnd 사이의 시간을 측정합니다.

- **console.log(****내용****)** :  로그를 콘솔에 출력합니다. console.log(내용, 내용, ...)처럼 여러 내용을 동시에 표시할 수도 있습니다.

- **console.error(****에러 내용**) : 에러를 콘솔에 출력

- **console.dir(****객체****,** **옵션****)** : 객체를 콘솔에 출력할 때 사용합니다. 첫 번째 인자로 표시할 객체를 넣고, 두 번째 인자로 옵션을 넣습니다. 옵션의 colors를 true로 하면 콘솔에 색이 추가되어 보기가 한결 편해집니다. depth는 객체 안의 객체를 몇 단계까지 보여줄지를 결정합니다. 기본값은 2입니다.

- **console.trace(****레이블****)** : 에러가 어디서 발생했는지 추적할 수 있게 해줍니다. 보통은 에러 발생 시 에러 위치를 알려주므로 자주 사용하지는 않지만, 위치가 나오지 않는다면 사용할 만합니다.



### **타이머 **객체

- 타이머 기능을 제공하는 함수인 setTimeout, setInterval, setImmediate는 노드에서 window 대신 global 객체 안에 들어 있습니다. 

- setTimeout(콜백 함수, 밀리초): 주어진 밀리초(1000분의 1초) 이후에 콜백 함수를 실행합니다.

- setInterval(콜백 함수, 밀리초): 주어진 밀리초마다 콜백 함수를 반복 실행합니다.

- setImmediate(콜백 함수): 콜백 함수를 즉시 실행합니다.

- 타이머 함수들은 모두 id를 반환하며,  id를 사용하여 타이머를 취소할 수 있습니다.

- clearTimeout(아이디): setTimeout을 취소합니다.

- clearInterval(아이디): setInterval을 취소합니다.

- clearImmediate(아이디): setImmediate를 취소합니다.  

- setImmediate(콜백)과 setTimeout(콜백, 0)에 담긴 콜백 함수는 이벤트 루프를 거친 뒤 즉시 실행됩니다

- 파일 시스템 접근, 네트워킹 같은 I/O 작업의 콜백 함수 안에서 타이머를 호출하는 경우 setImmediate는 setTimeout(콜백, 0)보다 먼저 실행됩니다.



ex)

```js
//timer.js

const timeout = setTimeout(() => {
  console.log('1.5초 후 실행');
}, 1500);

const interval = setInterval(() => {
  console.log('1초마다 실행');
}, 1000);

const timeout2 = setTimeout(() => {
  console.log('실행되지 않습니다');
}, 3000);

setTimeout(() => {
  clearTimeout(timeout2);
  clearInterval(interval);
}, 2500); 
const immediate = setImmediate(() => {
  console.log('즉시 실행');
});

const immediate2 = setImmediate(() => {
  console.log('실행되지 않습니다');
});

clearImmediate(immediate2);
//실행결과 : 즉시실행 -> 1초마다실행 -> 1.5초후 실행 -> 1초마다실행 

```



###  **__**__filename, ____dirname

- 노드는 ______filename, __dirname이라는 키워드로 경로에 대한 정보를 제공합니다. 

- 파일에 ______filename, __dirname을 넣어두면 실행 시 현재 파일명과 파일 경로로 바뀝니다. 

  

```js
//filename.js

console.log(__filename);
console.log(__dirname);

```





### **module 과** **exports**

- 모듈을 만들 때 module객체의 exports 또는 exports 객체로도 모듈을 만들 수 있습니다.
- module.exports로 한 번에 대입하는 대신, 각각의 변수를 exports 객체에 하나씩 넣었습니다. 
- console.log(module.exports === exports)를 하면 true가 나옵니다
- exports 객체에 add 함수를 넣으면 module.exports에도 add 함수가 들어갑니다.
- module.exports에는 어떤 값이든 대입해도 되지만, exports에는 반드시 객체처럼 속성명과 속성값을 대입해야 합니다. 





- exports에 다른 값을 대입하면 객체의 참조 관계가 끊겨 더 이상 모듈로 기능하지 않습니다.
- exports를 사용할 때는 객체만 사용할 수 있습니다.
- exports와 module.exports에는 참조 관계가 있으므로 한 모듈에 exports 객체와 module.exports를 동시에 사용하지 않는 것이 좋습니다.





###  **process** **객체**

- 현재 실행되고 있는 노드 프로세스에 대한 정보를 담고 있습니다
- 운영체제나 실행 환경별로 다른 동작을 하고 싶을 때 사용합니다. 
- Node.js에만이 존재하는 객체



**process** **객체의** **Property**

- argv : 실행 매개 변수를 나타냅니다.
- env : 컴퓨터 환경과 관련된 정보를 나타냅니다.
- version : Node.js 버전을 나타냅니다.
- versions : Node.js와 종속된 프로그램 버전을 나타냅니다.
- arch : 프로세서의 아키텍처를 나타냅니다.
- platform : 플랫폼을 나타냅니다.
- pid - 현재 프로세스의 아이디 
- execpath - 노드의 경로



**process** **객체의** **Method**

exit([exitCode = 0]) : 프로그램을 종료합니다. (매개변수 생략가능)

memoryUsage() : 메모리 사용 정보 객체를 리턴합니다.

uptime() : 현재 프로그램이 실행된 시간을 리턴합니다.

cwd() - 현재 프로세스가 실행되는 위치

cpuUsage() - 현재 cpu 사용량







#### 콜백함수 - 프로미스(Promise)

- ES2015부터는 자바스크립트와 노드의 API들이 콜백 대신 프로미스(Promise) 기반으로 재구성됩니다.

- 콜백 헬(callback hell) 극복



•new Promise로 프로미스를 생성할 수 있다

•resolve와 reject를 매개변수로 갖는 콜백 함수를 넣어줍니다

•promise 변수에 then과 catch 메서드를 붙일 수 있습니다. 

•프로미스 내부에서 resolve가 호출되면 then이 실행되고, reject가 호출되면 catch가 실행됩니다.

•resolve와 reject에 넣어준 인자는 각각 then과 catch의 매개변수에서 받을 수 있습니다. 





#### process.nextTick(콜백)

- 이벤트 루프가 다른 콜백 함수들보다 nextTick의 **콜백 함수를 우선**으로 처리하도록 만듭니다.

- process.nextTick으로 받은 콜백 함수나 resolve된 Promise는 다른 이벤트 루프에서 대기하는 콜백 함수보다- 먼저 실행됩니다. 

- Microtask를 재귀 호출하게 되면 이벤트 루프는 다른 콜백 함수보다 Microtask를 우선하여 처리하므로 콜백 함수들이 실행되지 않을 수도 있습니다.

  

실행결과 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result1.PNG>)



### **querystring**  **Module**

- WHATWG 방식의 url 대신 기존 노드의 url을 사용할 때 search 부분을 사용하기 쉽게 객체로 만드는 모듈 
- [http](http://nodejs.org/api/querystring.html)[://nodejs.org/api/querystring.html](http://nodejs.org/api/querystring.html)
- querystring.stringify(obj, [sep], [eq]) - 쿼리 객체를 쿼리 문자열로 변환해 리턴
- querystring.parse(str, [sep], [eq], [options]) - 쿼리 문자열을 쿼리 객체로 변환해 리턴
- querystring.escape
- querystring.unescape



ex)

```js
// querystringExample.js
var querystring = require('querystring'); 
var qStr = 'where=nexearch&query=querystring&sm=top_hty&fbm=1&ie=utf8';
var qObj = querystring.parse(qStr); // 일반적인 사용
var qObj2 = querystring.parse(qStr, '&', '=', { maxKeys: 3 });
// 구분 문자열이 다를 경우 &와 = 자리에 해당 문자를 넣어 사용합니다.
// maxKeys로 3을 넘겨주면 값을 3개만 가져옵니다. 
console.log(qObj); // 쿼리의 값들을 모두 가져옴
console.log(querystring.stringify(qObj));
console.log(querystring.stringify(qObj, '; ', '->')); 
console.log(qObj2); // 쿼리의 값을 3개만 가져옴
console.log(querystring.stringify(qObj2));
console.log(querystring.stringify(qObj2, '; ', '->'));
```



결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result2.PNG>)





###  **crypto**  

- 암호화를 도와주는 모듈
- 비밀번호는 단방향 암호화(복호화할 수 없는 암호화 방식) 알고리즘을 사용해서 암호화합니다. 
- 복호화 - 암호화된 문자열을 원래 문자열로 되돌려놓는 것
- 단방향 암호화 알고리즘은 주로 해시 기법을 사용합니다. 
- 해시 기법 - 어떠한 문자열을 고정된 길이의 다른 문자열로 바꿔버리는 방식
- createHash(알고리즘): 사용할 해시 알고리즘을 넣어줍니다. md5, sha1, sha256, sha512 등이 가능하지만, md5와 sha1은 이미 취약점이 발견되었습니다. 현재는 sha512 정도로 충분하지만, 나중에 sha512마저도 취약해지면 더 강화된 알고리즘으로 바꿔야 합니다.
- update(문자열): 변환할 문자열을 넣어줍니다.
- digest(인코딩): 인코딩할 알고리즘을 넣어줍니다. base64, hex, latin1이 주로 사용되는데, 그중 base64가 결과 문자열이 가장 짧아 애용됩니다. 결과물로 변환된 문자열을 반환합니다.



```js
//hash.js

const crypto = require('crypto');
console.log('base64:', crypto.createHash('sha512').update('비밀번호').digest('base64'));
console.log('hex:', crypto.createHash('sha512').update('비밀번호').digest('hex'));
console.log('base64:', crypto.createHash('sha512').update('다른 비밀번호').digest('base64'));

```



결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result3.PNG>)







- 현재는 주로 pbkdf2나 bcrypt, scrypt라는 알고리즘으로 비밀번호를 암호화하고 있습니다.

- pbkdf2는 기존 문자열에 salt라고 불리는 문자열을 붙인 후 해시 알고리즘을 반복해서 적용하는 것입니다.



```js
//pbkdf2.js   - sha512로 변환된 결괏값을 다시 sha512로 변환하는 과정을 10만 번 반복

const crypto = require('crypto');
crypto.randomBytes(64, (err, buf) => {
  const salt = buf.toString('base64');
  console.log('salt:', salt);
  crypto.pbkdf2('비밀번호', salt, 100000, 64,'sha512', (err, key) => {
    console.log('password:', key.toString('base64'));
  });
});

```



•randomBytes() 메서드로 64바이트 길이의 문자열을 만들어줍니다

•pbkdf2() 메서드에는 순서대로 비밀번호, salt, 반복 횟수, 출력 바이트, 해시 알고리즘을 인자로 넣어줍니다.

•bcrypt나 scrypt보다 취약하므로 나중에 더 나은 보안이 필요하면 scrypt 방식을 사용하면 됩니다. 



결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result4.PNG>)





### **양방향 암호화**   

- 암호화된 문자열을 복호화 가능
- 암호를 복호화하려면 암호화할 때 사용한 키와 같은 키를 사용
- crypto.createCipher(알고리즘, 키): 암호화 알고리즘과 키를 넣어줍니다. 암호화 알고리즘은 aes-256-cbc를 사용했습니다. 다른 알고리즘을 사용해도 됩니다. 사용 가능한 알고리즘 목록은 crypto.getCiphers()를 하면 볼 수 있습니다.
- cipher.update(문자열, 인코딩, 출력 인코딩): 암호화할 대상과 대상의 인코딩, 출력 결과물의 인코딩을 넣어줍니다. 보통 문자열은 utf8 인코딩을, 암호는 base64를 많이 사용합니다.
- cipher.final(출력 인코딩): 출력 결과물의 인코딩을 넣어주면 암호화가 완료됩니다.
- crypto.createDecipher(알고리즘, 키): 복호화할 때 사용합니다. 암호화할 때 사용했던 알고리즘과 키를 그대로 넣어주어야 합니다.
- decipher.update(문자열, 인코딩, 출력 인코딩): 암호화된 문장, 그 문장의 인코딩, 복호화할 인코딩을 넣어줍니다. createCipher의 update()에서 utf8, base64 순으로 넣었다면 createDecipher의 update()에서는 base64, utf8 순으로 넣으면 됩니다.
- decipher.final(출력 인코딩): 복호화 결과물의 인코딩을 넣어줍니다.



```js
//cipher.js

const crypto = require('crypto');

const cipher = crypto.createCipher('aes-256-cbc','열쇠');
let result = cipher.update('암호화할 문장','utf8','base64');
result += cipher.final('base64');
console.log('암호화:', result);

const decipher = crypto.createDecipher('aes-256-cbc','열쇠');
let result2 = decipher.update(result,'base64','utf8');
result2 += decipher.final('utf8');
console.log('복호화:', result2);

```





결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result5.PNG>)









## **util**   

- node.js의 보조적인 유용한 기능들을 모아놓은 모듈
- http://nodejs.org/api/util.html
- util.format(format, [...]) - console.log() 메소드와 비슷한 기능을 합니다. 차이점이라면 console.log()는 화면에 출력하는 역할을 하지만 util.format은 문자열로 반환합니다.
- util.debug(string)
- util.error([...])
- util.puts([...])
- util.print([...])
- util.log(string)
- util.inspect(object, [options])
- Customizing util.inspect colors
- util.isArray(object)
- util.isRegExp(object)
- util.isDate(object)
- util.isError(object)
- util.pump(readableStream, writableStream, [callback])
- util.inherits(constructor, superConstructor)
- util.deprecate: 함수가 deprecated 처리되었음을 알려줍니다. 첫 번째 인자로 넣은 함수를 사용했을 때 경고 메시지가 출력됩니다. 두 번째 인자로 경고 메시지 내용을 넣으면 됩니다. 함수가 조만간 사라지거나 변경될 때 알려줄 수 있어 유용합니다.
- util.promisify: 콜백 패턴을 프로미스 패턴으로 바꿔줍니다. 바꿀 함수를 인자로 제공하면 됩니다. 이렇게 바꾸어두면 async/await 패턴까지 사용할 수 있어 좋습니다.



ex)

```js
//util.js

const util = require('util');
const crypto = require('crypto');

const dontUseMe = util.deprecate((x, y) => {
  console.log(x + y);
},'dontUseMe 함수는 deprecated되었으니 더 이상 사용하지 마세요!');
dontUseMe(1, 2);

const randomBytesPromise = util.promisify(crypto.randomBytes);
randomBytesPromise(64)
  .then((buf) => {
    console.log(buf.toString('base64'));
  })
  .catch((error) => {
    console.error(error);
  });

```



결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result6.PNG>)







##  **fs**

- 파일 시스템에 접근하는 모듈
- 파일을 생성하거나 삭제하고, 읽거나 쓸 수 있습니다. 
- 폴더를 생성하거나 삭제 할 수 있습니다.
- readFile(file, encoding, callback) : 파일을 비동기적으로 읽습니다.
- readFileSync(file, encoding) : 파일을 동기적으로 읽습니다.
- writeFile(file, data, encoding, callback) : 파일을 비동기적으로 씁니다.
- writeFileSync(file, data, encoding) : 파일을 동기적으로 씁니다.
- fs.appendFile() : appends specified content to a file. If the file does not exist, the file will be created
- fs.open()  : takes a "flag" as the second argument, if the flag is "w" for "writing", the specified file is opened for writing. If the file does not exist, an empty file is created
- fs.unlink() :  deletes the specified file
- fs.rename() :  renames the specified file
- readFile의 결과물은 버퍼라는 형식으로 제공됩니다.
- 버퍼는 사람이 읽을 수 있는 형식이 아니므로 toString()을 사용해 문자열로 변환합니다





ex) 파일 읽기

```js
//readFile.js

const fs = require('fs');
fs.readFile('./readme.txt', (err, data) => {
  if (err) {
    throw err;
  }
  console.log(data);
  console.log(data.toString());
});

```



결과화면 :



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Node.js/190730/images/result7.PNG>)



ex ) 파일 생성

```js
var fs = require('fs');
fs.appendFile('mynewfile1.txt', 'Hello content!', function (err) {
  if (err) throw err;
  console.log('Saved!');
});

```



파일 생성2

```js
var fs = require('fs');
fs.open('mynewfile2.txt', 'w', function (err, file) {
  if (err) throw err;
  console.log('Saved!');
});

```



파일 생성3

```js
var fs = require('fs');
fs.writeFile('mynewfile3.txt', 'Hello content!', function (err) {
  if (err) throw err;
  console.log('Saved!');
});

```



### 수행평가? : node.js를 이용하여 웹 구현