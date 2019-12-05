# Heroku 배포



## IaaS

### -IaaS (Infrastructure as a Service)

컴퓨터를 빌리는 것이기 때문에 배포를 할 때의 모든 것들을 직접 준비해야함,

(코스트가 많이 든다)





## PaaS 

### - PaaS (Platform as a Service)

서비스 배포 환경을 미리 구성, 제공해줌.

​	- Heroku, AWS EB 등이 있음.



## 순서

### 배포전

#### 1. github에 배포할려는 소스 올리기(new repo)

#### 2. decouple 설치

```
pip install python-decouple
```

#### 3. django-heroku 설치

```
pip install django-heroku
```





### 배포를 위한 설정

#### 1. Procfile(앱을 시작할 때 필요한 커맨드를 기록하는 파일) 설정

#### 2. gunicorn 설치 (uwsgi 대신 사용 heroku 추천)

```
pip install gunicorn
```

#### 3.runtime.txt 파일 생성

![image-20191205151944149](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205151944149.png)

#### 4. requirements.txt 파일 만들기

![image-20191205151955592](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205151955592.png)



### 배포

#### 1. 헤로쿠 가입

#### 2. 헤로쿠 cli 설치





## 사용법 

깃 배쉬에서 올리려는 폴더 인잇

```
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/Q3333/Heroku_Deploy.git
git push -u origin master
```



virtual venv 실행,(activate)

```
source venv/Scripts/activate
pip install python-decouple
```



settings 에서 시크릿키 복붙.

manage.py와 같은 위치에 .env를 만들고, 붙여넣는다.

#### .env 

```
SECRET_KEY='ㄴㅁㅇㅁㄴㅇㄴㅁㅇㅁㄴㅇㅁ'
DEBUG=True
```

=전후로 띄어쓰기 있으면 안됨.



그 후 setting에선 내용 삭제



![image-20191205143735859](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205143735859.png)



그 후 env파일에서 시크릿키 등록

![image-20191205143840487](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205143840487.png)



그 후 헤로크 설치

```
pip install django-heroku
```







그 후 세팅즈 가장 아래에 해당 내용 추가

```python
import django_heroku
django_heroku.settings(locals())
```

*맥사용자는 포스트그릴sql을 직접 설치?





manage.py랑 같은 위치에 

#### Procfile

파일을 하나 만들어줌.

내용은

```
web: gunicorn config.wsgi --log-file -
```



그 후 gunicorn 설치

```
pip install gunicorn
```





#### runtime.txt 파일을

 manage.py와 같은 위치에 생성

그 후 

```
python --version
```

을 입력해서 나오는 버전을 입력.



runtime.txt

```
python-3.7.5
```





마지막으로 

```
pip freeze > requirements.txt
```

파일 생성



#### 헤로쿠 가입 후 여기로 이동

 [Heroku Dev Center](https://devcenter.heroku.com/articles/getting-started) 



#### heroku cli 검색



![image-20191205151615676](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205151615676.png)



링크로 이동해서 윈도우 64비트 다운



전부 기본으로 넥스트, 인스톨



##### 그다음 vsc 껐다키고



#### heroku login

```
heroku login
```



#### heroku create 앱이름

```
heroku create 앱이름
```





그 후

```
git remote -v
```

쳐보면 헤로쿠 주소가 생성되어있음.





![image-20191205152318065](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152318065.png)





## 환경변수설정

```
heroku config:set DEBUG=True
```

![image-20191205152637979](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152637979.png)



```
heroku config:set SECRET_KEY='u$wxgf8_md971ysoph#o_h0y3xi_4mi@$+(^l$!wf4k-sei7oo'
```

![image-20191205152913546](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152913546.png)



#### @ 오류 발생시

![image-20191205152826295](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152826295.png)

해로쿠 홈페이지의 대쉬보드로 이동.



그 후 셋팅즈에서

![image-20191205152932409](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152932409.png)



Reveal Config Vars를 클릭하면



![image-20191205152958653](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205152958653.png)



여기서 직접 설정 가능 



### 오류 날시 수정 2

### 1.

```
heroku buildpacks:set heroku/python
```



### 2. 

#### 	오타수정 



```
heroku open
```



```
heroku run python manage.py migrate
```



ETIMEOUT이 뜨면 대쉬보드 more 에서



![image-20191205154618774](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191205154618774.png)



run console에서



bash run

치고

```
python manage.py migrate 
```

(heroku run 뺴고)





python manage.py createsuperuser

admin

이메일

비번



슈퍼유저 생성

