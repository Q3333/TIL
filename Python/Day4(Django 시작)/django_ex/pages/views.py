from django.shortcuts import render
from django.http import HttpResponse
from faker import Faker
import random
from datetime import datetime

# Create your views here.
fake = Faker('ko_KR')


def index(request):
    return render(request, 'index.html')


def age(request, age):
    context = {
        'age': age
    }
    return render(request, 'age.html', context)


def squ(request, number):
    context = {
        'number': number*number
    }
    return render(request, 'squ.html', context)


def plus(request, base_number, target_number):

    context = {
        'num1': base_number,
        'num2': target_number,
        'result_number': base_number+target_number
    }
    return render(request, 'plus.html', context)


def minus(request, base_number, target_number):

    context = {
        'num1': base_number,
        'num2': target_number,
        'result_number': base_number-target_number
    }
    return render(request, 'minus.html', context)


def multi(request, base_number, target_number):

    context = {
        'num1': base_number,
        'num2': target_number,
        'result_number': base_number*target_number
    }
    return render(request, 'multi.html', context)


def div(request, base_number, target_number):

    context = {
        'num1': base_number,
        'num2': target_number,
        'result_number': base_number/target_number
    }
    return render(request, 'div.html', context)


def profile(request, name, age):

    list_name1 = ["시끄러운", "푸른", "적색", "조용한",
                  "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심많은"]
    list_name2 = ["늑대", "태양", "양", "매", "황소",
                  "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"]
    list_name3 = ["와(과) 함께 춤을", "의 기상", "은(는) 그림자속에", "", "", "", "의 환생", "의 죽음", "아래에서", "를(을) 보라", "이(가) 노래하다", "그림자", "의 일격", "에게 쫒기는 남자", "의 행진 ", "의 왕",
                  "의 유령", "을 죽인자", "는(은) 맨날 잠잔다", "처럼", "의 고향", "의 전사", "은(는) 나의친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이", "를(을) 쓰러트린자", "의 혼 ", "은(는) 말이 없다"]

    name1 = random.choice(list_name1)
    name2 = random.choice(list_name2)
    name3 = random.choice(list_name3)

    lotto = random.sample(range(1, 47), 6)

    # 쌤 답
    # lotto.sort()
    # l_num = [str(l)for l in lotto]

    # context = {
    #     'name': name,
    #     'age': age,
    #     "i2": f"{name1} {name2} {name3}",
    #     'lotto': ", ".join(l_num)
    # }

    # 이 3줄이 # l_num = [str(l)for l in lotto]와 같은 의미다.
    # l_num = []
    # for l in lotto:
    #     l_num.append(str(l))

    lotto2 = ""

    while(len(lotto) > 0):
        tmp = 99
        for i in lotto:
            if i < tmp:
                tmp = i
            else:
                continue
        lotto2 = f"{lotto2} {tmp} "
        pop_num = lotto.index(tmp)
        lotto.pop(pop_num)

    context = {
        'name': name,
        'age': age,
        "i2": f"{name1} {name2} {name3}",
        'lotto': lotto2
    }

    return render(request, 'profile.html', context)


def job(request, name):

    context = {
        'name': name,
        'job': fake.job()
    }

    return render(request, 'job.html', context)


def image(request):

    num = random.choice(range(1, 1000))

    url = f'https://picsum.photos/id/{num}/1200/800'

    context = {
        'url': url
    }

    return render(request, 'image.html', context)


def dtl(request):
    foods = ["짜장면", "탕수육", "짬뽕", "양장피", "군만두", "고추잡채", "볶음밥"]
    my_sentence = "life is short, you need python"
    messages = ['apple', 'banana', 'cucumber', 'mango']
    datetimenow = datetime.now()  # 현재시간
    empty_list = []

    context = {
        "foods": foods,
        "my_sentence": my_sentence,
        "messages": messages,
        "timenow": datetimenow,
        "empty_list": empty_list,
    }

    return render(request, 'dtl.html', context)


def birth(request):
    datetimenow = datetime.now()  # 현재시간
    time2 = datetime(2020, 2, 15)
    result = (time2 - datetimenow).days

    context = {
        "timenow": datetimenow,
        "time2": time2,
        "result": result,
    }

    # 샘 코드

    # today = datetime.now()

    # if today.month == 2 and today.date ==15:
    #     res = True
    # else:
    #     res = False

    # context = {
    #     'result':res
    # }

    return render(request, 'birth.html', context)
