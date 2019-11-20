from django.shortcuts import render
from .models import Movie
import csv, datetime

# Create your views here.
def index(request):
    
    # t = Movie.objects.get(title="third")
    # t.delete()
    # t.save()
    m = Movie.objects.all()
    context = {
        "m" : m
    }
    return render(request,"movies/index.html",context)


# 데이터 읽어와서 넣어주기
# def index(request):
#     count = 0
#     f = open('./movies/templates/movies/data.csv', 'r', encoding='utf-8')
#     rdr = csv.Dic
#     for line in rdr:
#         # print("title : " + line[0])
#         # print("title_en : " + line[1])
#         # print("audience : " + line[2])
#         # print("open_date : " + line[3])
#         # print("genre : " + line[4])
#         # print("watch_grade : " + line[5])
#         # print("score : " + line[6])
#         # print("poster_url : " + line[7])
#         # print("description : " + line[8])

#         if count>0 :
            
#             # a = line[3][0:4]
#             # b = line[3][4:6]
#             # c = line[3][6:8]

#             # time = f"{a}-{b}-{c}"

#             # d = datetime.strptime(line[3], '%Y%m%d')
#             # print(d)

#             day = datetime.datetime.strptime(line[3], '%Y%m%d')

#             print(day)
#             # Movie.objects.create(
#             #     title = line[0], 
#             #     title_en = line[1], 
#             #     audience = int(line[2]), 
#             #     open_date = day, 
#             #     genre = line[4], 
#             #     watch_grade = line[5], 
#             #     score = line[6], 
#             #     poster_url = line[7], 
#             #     description = line[8] 
#             # ) 
#         count = count+1
         
#     return render(request,"movies/index.html")