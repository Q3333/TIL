# Linux 1일차



### **리눅스의** **특징**

- 리눅스는 공개 소프트웨어이며 무료로 사용할 수 있다.
- 유닉스와의 완벽한 호환성을 유지한다.
- 서버용 운영체제로 많이 사용된다.
- 편리한 GUI 환경을 제공한다.



### **리눅스의** **구조**

- #### 커널: 리눅스의 핵심

  - 프로세스/메모리/파일 시스템/장치 관리
  - 컴퓨터의 모든 자원 초기화 및 제어 기능

  

- #### 셸: 사용자 인터페이스

  - 명령 해석
  - 프로그래밍 기능
  - 리눅스 기본 셸: 배시 셸(리눅스 셸)

  

- #### 응용 프로그램

  - 각종 프로그래밍 개발 도구
  - 문서 편집 도구
  - 네트워크 관련 도구 등



##### 

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/gujo.PNG>)





기본 홈 디렉토리 : /home/hadoop

hadoop@master~

~의 의미는 홈 디렉토리라는 소리임.

master는 네트워크?이름 



## 리눅스 명령어

- ##### pwd : 현재 경로 확인 (cd ~ 는 홈디렉토리로 이동)

- ##### clear : 화면 지우기

- ##### ls : 파일 목록 ( ls -a 는 숨김파일도 보여줌) 

  - ##### ex) ls /tmp 는 tmp의 파일목록을 봄, 그냥ls는 현재 디렉토리 목록

  - ls -F 라고 하면 심벌릭 링크에 @가 같이 표시됨. /표시는 디렉토리를 의미한다.

- ##### vi : 편집기 모드 (i누르면 insert, esc누르면 명령어 모드 + 콜론 : )

##### <

##### ls 옵션

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/img4.PNG>)



ls -l

ls -d

ls- R (파일 목록들의 절대 경로들 + 하위 내용들도 보여준다.)

ls -F

ls -i (번호 목록 까지 보여줌)

정도는 알아두어야 한다.



##### 상세정보를 읽는 방법

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/img5.PNG>)



ls 와 비슷한 기능을 하는게 dir vdir

##### >

- ##### su : 유저변경, 기본 su만 쓰면 root , su - hadoop시는 hadoop계정으로 이동

- date : 날짜와 시간 출력
- man : 메뉴얼, 사용방법 출력 ex) man clear
- passwd : 비밀번호 변경 
- file : 파일 종류 확인하는 명령어 ex) **file 파일이름**

- ##### mkdir : 폴더 만들기 , -p를 달면 중간 과정에 있는 디렉토리들도 생성이 됨.

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mkdir.PNG>)



- ##### rmdir : 폴더 삭제, -p를 달면 중간 과정에 있는 디렉토리들도 삭제 (빈디렉토리만 삭제 가능)

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rmdir.PNG>)



- cat : 텍스트 파일 내용 확인 

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/cat.PNG>)



- more : 화면 단위로 파일 내용 출력하기

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/more.PNG>)



- less : 개선된 화면 단위 파일 내용 출력하기

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/less.PNG>)



- tail : 파일 뒷 부분 출력하기

  <참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/tail.PNG>)



- #### cp : 파일(디렉토리) 복사하기

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/cp.PNG>)

  

  <참고 2>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/cp2.PNG>)

  

  <참고 3>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/cp3.PNG>)

  

  <참고 4>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/cp4.PNG>)



- #### mv : 파일 이동하고 파일명 바꾸기

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mv.PNG>)

​		<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mv1.PNG>)



​		<참고 3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mv2.PNG>)



​		<참고 4>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mv3.PNG>)



​		<참고 5>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/mv4.PNG>)



- #### rm: 파일 삭제하기

  <참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rm.PNG>)

​		<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rm1.PNG>)



​		<참고 3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rm2.PNG>)



​		<참고 4>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rm3.PNG>)



​		<참고 5>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/rm4.PNG>)



그 외 명령어

<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/img1.PNG>)





## 파일 다루기 



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/file.PNG>)



- #### ln : 하드 링크 만들기

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/ln.PNG>)

  

  <참고 2>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/ln2.PNG>)

  

  <참고 3>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/ln3.PNG>)

  

  <참고 4>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/ln4.PNG>)

  

  <참고 5>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/ln5.PNG>)

  

링크와 복사의 차이 :

링크는 원본을 변경하면 같이 변경이 되고

복사는 원본을 변경해도 변경이 따로 적용이 된다.





#####  심벌릭 링크 만들기 : -s 옵션 (심벌릭 링크는 바로가기와 같음)



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/sln.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/sln2.PNG>)





- #### touch : 빈 파일 생성하기, 수정 시간 변경하기 

  

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/touch.PNG>)

  

  <참고 2>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/touch2.PNG>)

  

  <참고 3>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/touch3.PNG>)

  

  <참고 4>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/touch4.PNG>)



- #### grep : 파일 내용 검색하기

  

  <참고 사진>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/grep.PNG>)

  

  <참고 2>

  ![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/grep2.PNG>)



- #### find : 파일 찾기



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/find.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/find2.PNG>)



<참고 3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/find3.PNG>)



<참고 4>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/find4.PNG>)





- whereis : 명령의 위치 찾기
  - /bin, /usretcusretcsbinusrsbin//share/man 정해진 위치검색



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/whereis.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/whereis2.PNG>)



- which : 명령의 위치 찾기
  - 에일리어스나 PATH 환경 변수로 지정된 경로에서 파일을 검색



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/which.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/which2.PNG>)





### 리눅스 파일

#### **파일의 종류**

- 파일: 관련 있는 정보들의 집합

- 리눅스는 파일을 효과적으로 관리하기 위해 디렉터리를 사용

- 리눅스에서 파일은 사용 목적에 따라 일반 파일, 디렉터리, 심벌릭 링크, 장치 파일로 구분



#### **일반 파일**(Regular File)

- 데이터를 저장하는 데 주로 사용

- 각종 텍스트 파일, 실행 파일, 이미지 파일 등 리눅스에서 사용하는 대부분의 파일은 일반 파일에 해당

- 텍스트 파일은 문서 편집기를 사용하여 내용을 보거나 편집할 수 있으나, 실행 파일이나 이미지 파일의 경우 해당 파일의 내용을 확인할 수 있는 특정 응용 프로그램이 있어야 확인할 수 있음

- 실행 파일이나 이미지 파일의 경우 바이너리 형태로 데이터가 저장되어 바이너리 파일이라고 함

  

#### **디렉터리**(Directory)

- 리눅스에서는 디렉터리도 파일로 취급

- 디렉터리 파일에는 해당 디렉터리에 저장된 파일이나 하위 디렉터리에 대한 정보가 저장

  

#### **심벌릭** **링크**

- 원본 파일을 대신하여 다른 이름으로 파일명을 지정한 것(윈도의 바로가기 파일과 비슷)

  

#### **장치파일**

- 리눅스에서는 하드디스크나 키보드 같은 각종 장치도 파일로 취급







#### 리눅스의 계층구조

<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/img2.PNG>)





#### 리눅스 디렉토리의 주요 기능

<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/img2.PNG>)



#### 리눅스 경로

##### **경로명**

- 파일 시스템에서 디렉터리 계층 구조에 있는 특정 파일이나 디렉터리의 위치 표시

- 경로명에서 각 경로를 구분하는 구분자로 /을 사용

- 경로명에서 가장 앞에 있는 /은 루트 디렉터리를 뜻하지만 경로명 중간에 있는 /은 구분자

- 예: bin/ls에서 맨 앞의 /은 루트 디렉터리를 의미하고, 중간에 있는 /은 디렉터리 이름과 파일명을 구분하는 구분자

  

**절대 경로명**

- 항상 루트 디렉터리부터 시작

- 반드시 /으로 시작한다.

- 루트 디렉터리부터 시작하여 특정 파일이나 디렉터리의 위치까지 이동하면서 거치게 되는 모든 중간 디렉터리의 이름을 표시

- 특정 위치를 가리키는 절대 경로명은 항상 동일

  

**상대 경로명**

- 현재 디렉터리를 기준으로 시작
- / 이외의 문자로 시작
- 현재 디렉터리를 기준으로 서브 디렉터리로 내려가면 그냥 서브 디렉터리명을 추가
- 현재 디렉터리를 기준으로 상위 디렉터리로 가려면 ..(마침표 두 개)를 추가
- 상대 경로명은 현재 디렉터리가 어디냐에 따라 달라짐



##### 절대경로 이동법

루트 : cd /

home : cd / home

boot : cd / boot

lib : cd /lib

ls : cd /ls

user : cd/home/hadoop (~디렉토리)



##### 상대경로 이동법

cd ../..

cd ../../boot





#### 파일 이름 규칙

**파일과 디렉터리 이름 규칙**

- 파일과 디렉터리 이름에는 /을 사용할 수 없다. /은 경로명에서 구분자로 사용하기 때문이다.
- 파일과 디렉터리의 이름에는 알파벳, 숫자, 붙임표(-), 밑줄( _), 마침표(.)만 사용한다.
- 파일과 디렉터리의 이름에는 공백문자, *, |, ", ', @, #, $, %, ^, & 등을 사용하면 안 된다.
- 파일과 디렉터리 이름의 영문은 대문자와 소문자를 구별하여 다른 글자로 취급한다.
- 파일과 디렉터리의 이름이 .(마침표)로 시작하면 숨김 파일로 간주한다.



##### 파일 이름 예

- 좋은 이름: game.txt, hello.c, test, sample11
- 나쁜 이름: &game, *dir, my home, game\
- 사용할 수 없는 이름: myhome/, /test, bad/name





## 문서 편집하기



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/MP.PNG>)



#### **모드형과** **비모드형** **편집기**

##### 모드형 (ex : vi 편집기)

- 입력 모드와 명령 모드가 구분

- 입력 모드는 텍스트를 입력할 수 있는 모드이고, 명령 모드는 텍스트를 수정하거나 삭제하고 복사와 붙이기 등 편집을 하는 모드
- 같은 글자라도 입력 모드에서는 텍스트로 처리하여 입력되고, 명령 모드에서는 텍스트로 입력되는 것이 아니라 편집 명령으로 사용
- vi는 모드형 편집기 (명령모드에서 dd하면 한줄삭제됨)
  - wq는 저장삭제, q!는 저장안하고 삭제
  - 

##### 비모드형

- 입력 모드와 명령 모드가 구분되어 있지 않음
-  편집 기능을  Ctrl이나 Alt 같은 특수 키와 함께 사용
-  한글과 워드는 비모드형 편집기



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/MP2.PNG>)



### vi

##### 모드 종류

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_mode.PNG>)



##### 유용한 명령어들 

<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi2.PNG>)



<참고 3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi3.PNG>)



<참고 4>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi4.PNG>)



<참고 5>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi5.PNG>)



화면 이동시키기

(긴 파일 읽을 때 )



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_move.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_move2.PNG>)



파일 편집하기 (잘라내기, 붙여넣기 , 되돌리기 등등)



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_edit.PNG>)



<참고 2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_edit2.PNG>)



<참고 3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_edit3.PNG>)



<참고 4>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_edit4.PNG>)







#### 범위 지정 편집



yy : 복사

dd : 잘라내기(삭제)

p : 붙여넣기



<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_search.PNG>)



문서에서 해당 단어 검색

/단어



##### 파일에서 텍스트 내용 바꾸기

<참고 사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_change.PNG>)



##### 여러 파일 같이 편집하기(파일 내용 불러오기)

<참고사진>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_file_read.PNG>)



<참고2>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_file_read2.PNG>)



<참고3>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_file_read3.PNG>)





##### vi에서 셀 명령 사용하기

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/vi_shell.PNG>)



# 셸

#### 셸의 기능

- 명령어 해석기 기능, 프로그래밍 기능, 사용자 환경 설정 기능

  -명령어 해석기 

  - 해석기(interpreter)와 번역기(translater)기능 

  -프로그래밍 기능
  
  - 셸은 자체 내의 프로그래밍 기능이 있어 반복적으로 수행하는 작업을 하나의 프로그램으로 작성 가능
  
  -사용자 환경 설정 기능 : 
  
  - 사용자 환경을 설정할 수 있도록 초기화 파일 기능을 제공 
  
  - 초기화 파일에는 명령을 찾아오는 경로를 설정하거나, 파일과 디렉터리를 새로 생성할 때 기본 권한을 설정하거나, 다양한 환경 변수 등을 설정



#### 셸의 종류

- 본 셸, 콘 셸, C 셸, 배시 셸, 대시 셸



리눅스의 기본 셸은 배시 셸(bash shell)



##### 출력

echo : 한줄 출력 ex) echo ㅎㅇ

printf : 형식 출력 ex) printf "%d + %d = %d\n" 10 10 20



* 전체 선택 : *



ex) ls *



cp * 경로 (현재 경로의 모든 파일을 경로(ex ./tmp) 에 복사한다.)



- 이전 경로로 이동 : cd





- 특수문자 ;과 |
  - ;(쌍반점,세미콜론) 과 |(파이프)는 명령과 명령을 연결
  - ;은 연결된 명령을 왼쪽부터 차례로 실행
  - |는 왼쪽 명령의 실행 결과를 오른쪽 명령의 입력으로 전달



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/date.PNG>)



- 기능 없애고 출력

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190808/images/print.PNG>)