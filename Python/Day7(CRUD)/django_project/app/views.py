from django.shortcuts import render
from app.models import Subway

# Create your views here.
def index(request):
   return render(request, 'app/index.html')

def subway_order(request):
   return render(request, 'app/subway_order.html')


def subway_result(request):
   name = request.POST.get('name')
   date = request.POST.get('date')
   radio = request.POST.get('radio')
   size = request.POST.get('size')
   bread = request.POST.get('bread')
   checkboxlist = request.POST.getlist('checkbox')

   checkbox_string = ", ".join(checkboxlist)

   Subway.objects.create(name=name, date=date, menu=radio, size=size, bread=bread, sauce=checkbox_string) 

   b = Subway.objects.all()
   # b = Subway.objects.filter(id=number)
   
   context ={
        'subway_list' : b
   }
    
   return render(request, 'app/subway_result_model.html', context)



def subway_result_number(request,number):


   b = Subway.objects.filter(id=number)
   
   context ={
        'subway_list' : b
   }
    
   return render(request, 'app/subway_result_model.html', context)