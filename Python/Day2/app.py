from flask import Flask, render_template, request
import random
import requests
from pprint import pprint

app = Flask(__name__)

@app.route('/')
def hello():
    name ="World!!"
    return f'Hello {name}!'

@app.route('/mulcam')
def mulcam():
    return 'Hello mulcam'

@app.route('/greeting/<string:name>')
def greeting(name):
    return f"{name} 님 안녕하세요"

@app.route('/lunch/<int:num>')
def lunch(num):
    menu = ["짜장면", "짬뽕", "라면", "스파게티", "스테이크", "삼겹살"]
    order = random.sample(menu,num)
    return render_template('menu.html', menu=order)

@app.route('/lotto')
def lotto():
    lotto_num = range(1,47)
    lotto_6 = random.sample(lotto_num,6)
    return str(lotto_6)

@app.route('/html')
def html():
    multiline = '''
    <h1> This is H1 Tag </h1>
    <p> This is P Tag </p>
    '''
    return multiline


@app.route('/hi/<string:name>')
def hi(name):
    return render_template('hi.html', name=name)


@app.route('/fake_naver')
def fake_naver():
    return render_template('fake_naver.html')

@app.route('/fake_google')
def fake_google():
    return render_template('fake_google.html')

@app.route('/send')
def send():
    return render_template('send.html')

@app.route('/receive')
def receive():
    name = request.args.get('name')
    message = request.args.get('message')
    return render_template('receive.html', name=name, msg=message)


#인디언식 이름짓기
@app.route('/naming')
def naming(): 
    return render_template("naming_send.html")

@app.route('/naming_result')
def naming_result():
    
    date = request.args.get("date")
    name = request.args.get('name')

    year = int(date[3:4]) 
    month = int(date[5:7]) -1
    day = int(date[8:10]) -1

    list_name1 = ["시끄러운", "푸른" , "적색","조용한" ,"웅크린","백색","지혜로운","용감한","날카로운","욕심많은"]
    list_name2 = ["늑대","태양","양","매","황소","불꽃","나무","달빛","말","돼지","하늘","바람"]
    list_name3 = ["와(과) 함께 춤을","의 기상","은(는) 그림자속에"," ", " ", " ", "의 환생","의 죽음","아래에서","를(을) 보라","이(가) 노래하다","그림자","의 일격","에게 쫒기는 남자","의 행진 ","의 왕","의 유령","을 죽인자","는(은) 맨날 잠잔다","처럼","의 고향","의 전사","은(는) 나의친구","의 노래","의 정령","의 파수꾼","의 악마","와(과) 같은 사나이","를(을) 쓰러트린자","의 혼 ","은(는) 말이 없다"]

    name1_pop = list_name1.pop(year)
    name2_pop = list_name2.pop(month)
    name3_pop = list_name3.pop(day)

    # name1 = random.sample(list_name1,1)
    # name1 = random.choice(list_name1) 도 가능
    # name2 = random.sample(list_name2,1)
    # name3 = random.sample(list_name3,1)

    # name1_pop = name1.pop(0)
    # name2_pop = name2.pop(0)
    # name3_pop = name3.pop(0)

    fullname = f"{name1_pop} {name2_pop} {name3_pop}"

    return render_template("naming_result.html" , name=name , indian=fullname)

@app.route('/lotto_get')
def lotto_get():
    return render_template('lotto_get.html')

@app.route('/lotto_num')
def lotto_num():
    num = request.args.get("num")
    url = f"https://dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={num}"
    res = requests.get(url).json()
    # pprint(res)

    #List comprehension
    #[ 받는 변수 for 받는 변수 in 리스트(튜플) ]
    wnum  = [ res[f'drwtNo{i}'] for i in range(1,7)]
    lotto = random.sample(range(1,47),6)

    count = list(set(wnum) & set(lotto))
    len_count = len(count)
    message = ""

    if (len_count == 6) :
        message = "1등입니다!"
    elif (len_count == 5) :
        message = "2등입니다!"
    elif (len_count == 4) :
        message = "3등입니다!"
    elif (len_count == 3) :
        message = "4등입니다!"
    else :
        message = "꽝 입니다!"
 

    return render_template('lotto_result.html', num=num, wnum=wnum, lotto=lotto, message=message)
if __name__ == "__main__":
    app.run(debug=True, port=8000)