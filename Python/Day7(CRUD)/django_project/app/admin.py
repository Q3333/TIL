from django.contrib import admin
from .models import Board
from .models import Subway

# Register your models here.

class BoardAdmin(admin.ModelAdmin):
    fields = ['content', 'title']
    #내용 순서를 콘텐츠 - 타이틀로
    list_display = ["title", "updated_at"]
    #리스트에서 보여주는 값들을 제목 + 업데이트된 날짜로
    list_filter = ["updated_at"]
    #시간 별 필터(일주일,한달 등)
    search_fields = ["title", "content"]
    #검색창

class SubwayAdmin(admin.ModelAdmin):
    fields = ['name', 'menu']
    #내용 순서를 콘텐츠 - 타이틀로
    list_display = ["id", "menu", "name", "date"]
    #리스트에서 보여주는 값들을 제목 + 업데이트된 날짜로
    list_filter = ["date"]
    #시간 별 필터(일주일,한달 등)
    search_fields = ["id", "name"]
    #검색창

admin.site.register(Board , BoardAdmin)
admin.site.register(Subway , SubwayAdmin)