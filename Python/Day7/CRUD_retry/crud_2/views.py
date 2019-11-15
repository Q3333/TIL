from django.shortcuts import render,redirect
from .models import Menu

# Create your views here.
def index(request):
    menu_list = Menu.objects.order_by('-id')
    context = {
        'menu_list' : menu_list
    }
    return render(request,"crud_2/index.html",context)

def menu_form(request):
    return render(request, "crud_2/menu_form.html")

def menu_send(request):
    menu = Menu()
    menu.name = request.POST.get("menu") 
    menu.price = request.POST.get("price")
    menu.content = request.POST.get("content")
    menu.save()
    return redirect("/crud_2/")

def detail(request, pk):
    menu_detail = Menu.objects.get(pk=pk)
    context = {
        "menu_detail" : menu_detail
    }
    return render(request, 'crud_2/menu_detail.html', context)
    
def update(request,pk):
    menu_detail = Menu.objects.get(pk=pk)
    context = {
        "menu_detail" : menu_detail
    }
    return render(request, 'crud_2/menu_update.html', context)

def update_complete(request,pk):
    get_menu = Menu.objects.get(pk=pk)
    name = request.POST.get("menu")
    price = request.POST.get("price")
    content = request.POST.get("content")
    get_menu.name = name
    get_menu.price = price
    get_menu.content = content
    get_menu.save()
    return redirect(f'/crud_2/{get_menu.id}/detail/')

def delete(request,pk):
    menu = Menu.objects.get(pk=pk)
    menu.delete()
    return redirect("/crud_2/")