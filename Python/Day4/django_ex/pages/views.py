from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.


def index(request):
    return render(request, 'index.html')


def age(request, age):
    context = {
        'age': age
    }
    return render(request, 'age.html', context)


def number(request, number):
    context = {
        'number': number*number
    }
    return render(request, 'number.html', context)


def plus(request, base_number, target_number):

    context = {
        'result_number': base_number+target_number
    }
    return render(request, 'plus.html', context)


def minus(request, base_number, target_number):

    context = {
        'result_number': base_number-target_number
    }
    return render(request, 'minus.html', context)


def multi(request, base_number, target_number):

    context = {
        'result_number': base_number*target_number
    }
    return render(request, 'multi.html', context)


def div(request, base_number, target_number):

    context = {
        'result_number': base_number/target_number
    }
    return render(request, 'div.html', context)
