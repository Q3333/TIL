from django.shortcuts import render
import random
import requests

# Create your views here.

def artii_form(request):
   return render(request, 'app/artii_form.html')


def artii_result(request):
    text = request.GET.get('text')

    f_url = "http://artii.herokuapp.com/fonts_list"
    fonts = requests.get(f_url).text
    fonts = fonts.split('\n')

    font = random.choice(fonts)

    url = f'http://artii.herokuapp.com/make?text={text}&font={font}'
    res = requests.get(url).text

    context= {
        'res' : res
    }

    return render(request, 'app/artii_result.html', context)

def user_new(request):
    return render(request, 'app/user_new.html')

def user_create(request):
    username = request.POST.get('name')
    pw = request.POST.get('pw')

    context = {
        'username': username,
        'pw':pw
    }

    return render(request, 'app/user_create.html', context)

def subway_order(request):
    return render(request, 'app/subway_order.html')

def subway_result(request):
    name = request.POST.get('name')
    date = request.POST.get('date')
    radio = request.POST.get('radio')
    size = request.POST.get('size')
    bread = request.POST.get('bread')
    checkboxlist = request.POST.getlist('checkbox')

    # checkbox =""

    # for i in checkboxlist :
    #     checkbox = f'{checkbox} {i} '

    context ={
        'name' : name,
        'date' : date,
        'radio': radio,
        'size' :size,
        'bread':bread,
        'checkbox': ", ".join(checkboxlist)
    }
    
    return render(request, 'app/subway_result.html', context)


def static_example(request):
    return render(request, 'app/static.html')

def index(request):
    return render(request,'app/index.html')