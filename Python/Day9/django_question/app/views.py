from django.shortcuts import render, redirect
from .models import Question,Choice

# Create your views here.
def index(request):
    questions = Question.objects.all()
    context = {
        'questions': questions,
    }
    return render(request,"app/index.html",context)

def detail(request,q_id):
    q = Question.objects.get(id=q_id)

    choices = q.choice_set.all()

    context ={
        'q' : q ,
        'choices' : choices
    }

    return render(request,"app/detail.html",context)

def new(request):
    if request.method == "POST":
        q = Question(question=request.POST.get('title'))
        q.save()
        return redirect('app:index')
    else:
    # 폼 html 을 불러오는 부분.
        return render(request,"app/new.html")
    

def delete(request, q_id):
    q = Question.objects.get(id=q_id)
    q.delete()
    return redirect('app:index')


def choice_edit(request,q_id,c_id):

    cho = Choice.objects.get(id=c_id)

    if request.method == "POST":

        c_text = request.POST.get('c_text')

        cho.survey = c_text
        cho.save()
        return redirect("app:detail", q_id)

    else :
        context = {
            'choice' : cho
        }
        return render(request,"app/choice_edit.html", context)
     
    

def survey(request,q_id):
    q_text = request.POST.get('q_text')
    q = Question.objects.get(id=q_id)
    c = Choice()
    c.survey = q_text
    c.question = q
    c.save()
    return redirect('app:detail', q_id)
    