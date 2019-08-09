# Linux 2일차

### 1일차 복습



#### [리눅스 구성]

- **커널** - 프로세스 관리 ,파일 시스템, 장치 관리, 메모리 관리

​	      컴퓨터의 모든 자원 초기화와 제어



- **셀(shell)** - 사용자 인터페이스로서 명령어 해석, 프로그래밍 기능(.sh)

리눅스 기본 셀  = bash shell



- **응용프로그램**



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/gujo.PNG>)







#### [가상 머신 프로그램 - virtual box, vmware, virtual pc등]

pc에 설치되어 있는 운영체제(호스트 OS)에 가상의 시스템(머신)을 생성한 후에,

여기에 다른 운영체제(게스트 OS)를 구성할 수 있도록 해주는 프로그램



#### 리눅스 파티션 구성

/ : root 파티션, 시스템 설정등 주요 내용 저장

/boot : boot 파티션, 리눅스 부팅 커널이 저장

swap : 메모리(RAM) 가 부족할 때 사용되는 영역 (RAM의 2배 size 권장)



/usr : 명령어, 응용프로그램 등이 주로 저장 

/var : 주로 로그 파일 저장 

/tmp : 시스템 사용 중에 발생하는 임시 파일 저장

/home : 사용자의 홈 디렉토리로 사용되는 영역



date : 현재 날짜, 시간 출력

clear : 터미널에서 보이는 화면의 내용을 지우고 커서를 화면 자측 상단으로 이동

man : 리눅스가 제공하는 명령어들의 사용법을 보려면

passwd : 비밀번호 변경

ctrl+d, exit : 터미널 종료



#### 리눅스 파일의 종류

일반파일, 디렉토리, 심볼릭 파일, 디바이스 파일



dev : 장치 파일이 담긴 디렉토리

media : CD_ROM이나 USB 같은 외부 장치를 연결하는 디렉토리 

opt : 추가 패키지가 설치되는 디렉토리 

sys : 리눅스 커널과 관련된 파일이 저장되어 있는 디렉토리

run : 실행중인 서비스와 관련된 파일들이 저장되는 디렉토리

proc : 프로세스 정보 등 커널 관련 정보가 저장되는 디렉토리





#### 주요 명령어 



file : 파일의 종류 확인

ls -l : 현재 디렉토리 내용의 상세 확인 

ls -a : 디렉토리 내용 숨김파일 포함해서 확인

ls -F : 디렉토리 내용의 파일 종류

dir, vdir : ls명령의 심볼릭 링크



pwd : 터미널에서 현재 경로(디렉토리) 확인 : pwd

cd : 디렉토리 이동 

- / 절대경로 
- . 현재 경로
- .. 부모 경로



mkdir : 디렉토리 만들기

mkdir - p 중간 디렉토리를 자동으로 생성하는 옵션

rmdir :디렉토리 삭제 (-p 옵션 가능)



cat [파일명] : 텍스트 파일의 내용 확인 (-n옵션)

more [파일명], less [파일명] : 텍스트 파일의 내용을 화면 단위로 출력 

tail [파일명] : : 텍스트 파일의 내용중 뒷 부분만 일부 출력



cp , cp-r : 파일,디렉토리 복사

mv : 파일 이동, 파일 이름 변경

rm , rm -r :파일 삭제 , 디렉토리 삭제



하드 링크 : 기존 파일에 새로운 파일명을 추가로 생성 (inode 값이 동일)

ln [원본파일] [하드링크파일] : 하드링크 파일 생성



심볼릭 링크 :  원본 파일을 가리키는 새로운 파일을 생성 (바로가기)

ln-s  [원본파일] [심볼릭 링크파일] : 심볼릭 링크 파일 생성



inode :  파일에 대한 정보를 가지고 있는 특별한 구조체 (파일의 종류, 크기, 소유자, 파일 변경 시간, 파일 상세 정보, 파일 데이터 블록 주소 저장)



touch : 빈 파일 생성, 파일의 수정날짜, 시간 변경

grep [검색어] [대상파일명] : 파일의 내용을 검색

find : 파일 검색





#### vi 편집기 



입력 모드 - i ,a ,o

명령모드 - esc



명령 모드에서 커서를 한행 앞으로 이동 : -, k

명령 모드에서 커서를 한행 뒤로 이동 : +, j

명령 모드에서 저장 : wq, ZZ

명령 모드에서 저장 안하고 vi 종료  q, :q!

명령 모드에서 특정 행으로 이동하려면 행번호G, :행번호



명령 모드에서 커서 위치한 한 글자 삭제 x

명령 모드에서 커서 위치한 한 단어 삭제 dw

명령 모드에서 커서 위치한 한 라인 삭제 dd



명령 모드에서 커서 위치한 한 행 복사 		yy

명령 모드에서 커서 위치한 행 아래 붙여넣기 p

명령 모드에서 커서 위치한 한 행 잘라내기 dd



명령 모드에서 파일 내용 중 특정 문자열을 (위 방향으로 ) 검색 ?검색 문자열

명령 모드에서 파일 내용 중 특정 문자열을 (아래 방향으로 ) 검색 /검색 문자열



명령 모드에서 파일 내용 중 커서가 위치한 행에서 특정 문자열을 다른 문자열로 바꾸기 

: s/문자열1/문자열2/g





명령 모드에서 커서가 위치한 행아래 다른 파일을 읽어 들여서 삽입하기 

: r 대상파일 



명령 모드에서 다른 지정한 파일로 전환하려면

:w

:e 지정파일



vi test1.txt test2.txt test3.txt

편집후 .. 다음 파일로 전환하려면 

명령모드에서

:w 

:n



vi 편집기 사용 중 셀 명령을 실행시키려면

명령 모드에서 :! 셀 명령어

ex) :! ls



vi 편집기 사용 중 셀 명령을 실행시키기 위해 vi 편집기를 빠져나오려면

명령 모드에서 :sh 한 후에 셀 명령어 수행하고 vi 편집기로 돌아오려면 exit





##### 로그인 상태 변경 : bash, su







##  **입출력 방향 바꾸기**



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/IPOP.PNG>)



- 출력 결과를 파일로 저장 (덮어 씌우기)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/OP.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/OP2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/OP3.PNG>)



cat > out1 을 하면

입력을 바로 받아서 file로 저장할 수 있다.



- 출력 결과를 파일로 저장 (밑에 덧쓰기) 



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/OOP.PNG>)





- 오류 리다이렉션

  

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/or.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/or2.PNG>)



오류 메세지를 파일로 리다이렉션 하기 위해서는 2> 을 반드시 붙여 주어야 한다.



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/or3.PNG>)



- 입력 리다이렉션

  

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/IP.PNG>)



out1의 내용을 입력 리다이렉션으로(ls -R의 경로로) 사용함.





## **배시** **셸** **환경설정**



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/s.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/s2.PNG>)



set은 전체, env 환경변수만





- 쉘 변수 관련



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sh.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sh2.PNG>)





- 쉘 환경변수 설정하기

  

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sh_e.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sh_e2.PNG>)





- 앨리어스 (alias) 관련



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/A.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/A2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/A3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/A4.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/a5.PNG>)





- 히스토리 ( 예전에 쳤던 내용들 보기)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/h.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/h2.PNG>)





### 프롬프트 설정



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/p.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/p2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/p3.PNG>)







컬러 프롬프트 변경

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/p_c.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/p_c2.PNG>)





### 환경 설정 파일





![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs4.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs5.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/hs6.PNG>)







su -

cd /usr/local

pwd -> usr local이어야함

tar -xvf /home/hadoop/Downloads/jdk~ (탭)

chown -R hadoop:hadoop ./jdk1.8 ~(탭)

(소유자 변경, 확인은 ls-l) 



계정 변경

su - hadoop

vi .bash_profile

PATH위에

JAVA_HOME=/usr/local/jdk1.8.0_221

PATH 마지막에 bin:$JAVA_HOME/bin 

추가



source ./.bash_profile

javac





# 파일 접근 권한 관리하기



#### 파일의 속성



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/F.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/F2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/F3.PNG>)



#### 파일의 접근 권한 

rwx = 읽기,쓰기,실행



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FG.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FG2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FG3.PNG>)



#### 기호를 이용한 파일 접근 권한 변경



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FI.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FI2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FI3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FI4.PNG>)



#### 숫자를 이용한 파일 접근 권한 변경



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS4.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS5.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FS6.PNG>)



#### 기본 접근 권한 설정



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB3.PNG>)



마스크가 077이면 다른 사용자나 그룹 사람들에게 아무 권한도 주지 않겠다는 의미다.



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB4.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB5.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/FB6.PNG>)





# 프로세스 관리



#### 프로세스의 개념

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro.PNG>)





#### 프로세스 관리 명령

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro4.PNG>)



<au는 자주 씀>

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro5.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro6.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro7.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro8.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro9.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro10.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pro11.PNG>)





[yum 업데이트]

Yum은 Yellow dog Updater ,Modified의 약자



### pgrep



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pg.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pg2.PNG>)





#### signal



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sig.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/sig2.PNG>)





#### Kill(시그널이랑 연결해서 사용가능)

ex) kill -9 1001



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/k.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/k2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/k3.PNG>)



#### 프로세스 관리 도구



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pm.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pm2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/pm3.PNG>)



※ 시스템 감시 화면 으로도 확인 가능

![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/gnome.PNG>)





## 포그라운드, 백그라운드 프로세스와 작업 제어



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/j.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/j2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/j3.PNG>)







#### 작업 전환하기



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/jc.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/jc2.PNG>)





#### 로그아웃 후에도 백그라운드 작업 계속 실행하기 : nohup



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/jb.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/jb2.PNG>)





#### 작업 예약



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja2.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja3.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja4.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja5.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja6.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja7.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja8.PNG>)



![1564104618052](<https://github.com/Q3333/ITL/blob/master/Linux/190809/images/ja9.PNG>)

