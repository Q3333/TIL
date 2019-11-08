from flask import Flask, render_template, request
import requests
import random
from decouple import config #.env 파일에 저장된 token을 받아오는 패키지
from pprint import pprint

app = Flask(__name__)
 # env의 토큰 값을 받아옴
token = config('TOKEN')
    #telegram bot api api 문서에 request url
    # >> https://api.telegram.org/bot<token>/METHOD_NAME
base_url = f"https://api.telegram.org/bot{token}"   

    #다른 def에서도 사용할 수 있게 전역변수설정
res = requests.get(f'{base_url}/getUpdates').json() 

@app.route('/telegram')
def telegram():
    
    res = requests.get(f'{base_url}/getUpdates').json()
    chat_id = res['result'][0]['message']['chat']['id']
    # pprint(res)
    # print(chat_id)

    lotto = random.sample(range(1,47),6)

    send_url = f'/sendmessage?chat_id={chat_id}&text=로또 번호 추첨입니다! {lotto}'
   
    res = requests.get(base_url+send_url).json()

    # pprint(res)

    return ''

@app.route('/chat')
def chat():
    return render_template("chat.html")

@app.route('/send_msg')
def send_msg():
    #form 에서 chat이라는 이름의 데이터를 받아오는 곳
    req = request.args.get("chat")

    # chat_id 값을 받아오기 위해 사용되는 chat id
    chat_id = res['result'][0]['message']['chat']['id']

    # telegram에 메세지를 보내기 위한 url
    send_url = f'/sendmessage?chat_id={chat_id}&text={req}'
   
    response = requests.get(base_url+send_url).json

    pprint(response)
    
    return "보내기 완료."

@app.route('/', methods=['POST'])
def tel_web():
    C_ID = config("C_ID")
    C_SC = config("C_SC")
    url = "https://openapi.naver.com/v1/language/translate"

    headers ={
        # "Content-Type": "application/json;charset=utf-8",
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
        "X-Naver-Client-Id": C_ID,
        "X-Naver-Client-Secret": C_SC
    }

    req = request.get_json().get('message')

    # pprint(req)

    if req is not None:
        chat_id = req.get('chat').get('id')
        text = req.get('text')

    # print(chat_id, text)

    if "로또" in text:
        lotto = random.sample(range(1,47),6)
        # print(lotto)
        send_url = f'/sendmessage?chat_id={chat_id}&text={lotto}'
        response = requests.get(base_url+send_url).json
        # pprint(response)

    elif "/인디안 이름" in text:
        list_name1 = ["시끄러운", "푸른" , "적색","조용한" ,"웅크린","백색","지혜로운","용감한","날카로운","욕심많은"]
        list_name2 = ["늑대","태양","양","매","황소","불꽃","나무","달빛","말","돼지","하늘","바람"]
        list_name3 = ["와(과) 함께 춤을","의 기상","은(는) 그림자속에","", "", "", "의 환생","의 죽음","아래에서","를(을) 보라","이(가) 노래하다","그림자","의 일격","에게 쫒기는 남자","의 행진 ","의 왕","의 유령","을 죽인자","는(은) 맨날 잠잔다","처럼","의 고향","의 전사","은(는) 나의친구","의 노래","의 정령","의 파수꾼","의 악마","와(과) 같은 사나이","를(을) 쓰러트린자","의 혼 ","은(는) 말이 없다"]

        name1 = random.choice(list_name1)
        name2 = random.choice(list_name2)
        name3 = random.choice(list_name3)

        send_url = f"/sendmessage?chat_id={chat_id}&text=당신의 인디안 이름은 '{name1} {name2} {name3}' 입니다."
        response = requests.get(base_url+send_url).json

    elif "/번역" in text:
        # message = text[3:]
        re_txt = text.replace("/번역", "")

        data = {
        "source" : "ko",
        "target" : "ja",
        "text" : re_txt
        }

        req = requests.post(url, headers=headers, data=data).json()

        msg = req['message']['result']['translatedText']

        #msg = req.get('message').get('result').get('translatedText')

        send_url = f"/sendmessage?chat_id={chat_id}&text=번역된 내용은 '{msg}' 입니다."
        response = requests.get(base_url+send_url).json


    else :
        send_url = f'/sendmessage?chat_id={chat_id}&text={text}'
        response = requests.get(base_url+send_url).json

    return '', 200

@app.route('/papago')
def papago():
    C_ID = config("C_ID")
    C_SC = config("C_SC")
    url = "https://openapi.naver.com/v1/language/translate"

    headers ={
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
        "X-Naver-Client-Id": C_ID,
        "X-Naver-Client-Secret": C_SC
    }

    data = {
        "source" : "ko",
        "target" : "ja",
        "text" : "안녕하세요" 
    }

    req = requests.post(url, headers=headers, data=data).json()

    # pprint(req)

    mg = req['message']['result']['translatedText']
    # print(mg)
    return mg

if __name__ == "__main__":
    app.run(debug=True)
