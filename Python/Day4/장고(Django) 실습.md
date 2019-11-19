# 장고(Django) 실습

#### 장고 설치

```python
virtualenv venv

source venv/Scripts/activate

pip install django
```



#### 장고 명령어

```python
django-admin startproject @@@
```

@@@에 이름을 넣으면 폴더가 **2개** 생성되어 버린다.



그래서 폴더를 미리 하나 만들어주고 (cd로 들어가야함)

```python
django-admin startproject config .
```

라는 식으로 만들어주면 현재 폴더에서 config 폴더 하나만 생성이 된다.





#### 장고 서버 실행

```python
python manage.py runserver

python manage.py runserver 3000
```



기본포트는 8000, 직접 포트를 지정해줄 수 도 있다.





#### 파일 설명

##### init = 프로젝트로 묶어주는 파일



##### setting = 장고의 모든 설정을 하는 곳

SECRET_KEY = 중요한 내용을 다룰 때 사용하는 키, 배포할때는 숨겨야함

INSTALLED_APPS = 현재 깔린 앱들

MIDDLEWARE = request와 response 사이에서 동작하는 프레임워크 

ROOT_URLCONF = 기준되는 urls.py의 경로를 나타냄

TEMPLATES = TEMPLATES(사용자에게 보여주는 화면) 파일의 경로를 나타내줌,

WSGI_APPLICATION = WSGI_APPLICATION 에 대한 설정

DATABASES = DB 설정, sqlite가 기본이지만 mysql등으로 설정 가능

AUTH_PASSWORD_VALIDATORS = 비밀번호 검증을 위한 부분



#### LANGUAGE_CODE = ko-kr

#### TIME_ZONE = Asia/Seoul

로 바꿔줘야함.



##### ulrs = 플라스크에서의 @app.route 부분을 따로 만들어서 관리해주는 부분



##### wsgi = 배포를 할떄 사용하는 파일, 웹서버와 장고 사이의 통신을 담당해줌.



#### manage = 장고의 명령어를 실행해주는 파일, 변경할 일 거의 없음

manage파일이 오류가 뜨면 파이썬 64비트가아니라 32비트일경우, 가상환경(virtualenv)를 실행 안 시켰을 때의 오류가 대부분이다.



## 앱 만들기

```python
python manage.py startapp 앱이름
```



admin : 쉘 명령등을 대신해서 처리해주는?

apps : 건들일 일 없음

model : 데이터베이스의 구조를 적고 명세를 관리

test : 

views : 장고의 view(mvc의 컨트롤러)를 수정해주는 곳, 가장 많이 수정이 될 곳.

```python
def index():
    return render_template('index.html')
```

flask의 이 부분이 views에서 다뤄진다.



#### INSTALLED_APPS = [ '앱이름(pages)',

을 추가해줘야함. setting에



### Django 코딩 규칙

프로젝트의 코드는 맨 위에서부터 추가해감.

앱의 urls(없으므로 직접 만들어줘야함) 코드는 맨 아래부터 추가해감.



### 가장 많이 수정하는 3요소

urls, view, Template

이 3개 위주로 수정을 많이한다.

개발순서도 urls -> view -> template 순







## 실습



프로젝트 - setting에서

```python
INSTALLED_APPS = [
    'pages',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
```

인스톨드 앱에서 맨위에 앱 이름 추가



프로젝트 -urls에서

```python
from pages import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.index),
]

```

urlpatterns에서 아래에 view.index추가



view.py에서

```python
from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.


def index(request):
    return HttpResponse("Hello Django")

```

return 하는 def 함수 추가





## 실습2

앱 폴더에 templates폴더를 만든 뒤, index.html생성

```html
<h1>Index Page</h1>
<p>Hello Django!</p>
```





view.py에 return render로 html을 연결 

```python
def index(request):
    return render(request, 'index.html')

```



#### urls -> views -> Templates 순서를 기억!





#### 동적url

@app.route('/index/\<int:num>') 같은 부분



int, str 등의 값을 받아서 페이지에 띄워주므로 같은 페이지를 반복해서 만들지 않아도 된다.



int : 0또는 양의 정수와 매치

str : / 를 제외한 모든 문자열과 매치, 디폴트 값

slug : slug 형식 ( ASCII, 숫자, 하이픈, 밑줄) 과 매치

uuid : uuid 형식의 문자열과 매치



### 실습3



넘겨줄때는 딕셔너리 형태로 넘겨줘야함.



urls.py(프로젝트) 

```python
urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.index),
    path('<int:age>/', views.age),
]
```





views.py(앱)

```python
def age(request, age):
    context = {
        'age': age
        }
    return render(request, 'age.html', context)
```



age.html(템플릿)

```html
<h1>{{ age }}</h1>
```





연습1 : 숫자를 받아서 페이지 n 제곱 값을 나타내 보자.





문자(직업,주소) 랜덤으로 주는 패키지 : Faker

이미지 랜덤으로 주는 사이트 : Lorem Picsum





## templates dtl사용



```python
{% for f in foods %} 
{% endfor %}
```



for문은 항상 열고 닫아줘야한다.