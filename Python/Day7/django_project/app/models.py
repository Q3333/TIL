from django.db import models

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=10)
    #CharField는 max_length가 필요하다.
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    #auto_now_add 를 True로 하면 데이터가 들어갈 때 마다 시스템의 현재 시간을 넣어줌
    updated_at = models.DateTimeField(auto_now=True)
     #auto_now 는 생성이 아니라 수정될 때 마다 시간이 자동으로 등록

    def __str__(self):
        # return f"{self.id} : {self.title}"
        return f"{self.title}"

class Subway(models.Model):
    name = models.CharField(max_length=20)
    date = models.DateTimeField()
    menu = models.CharField(max_length=20)
    size = models.IntegerField()
    bread = models.CharField(max_length=20)
    sauce = models.CharField(max_length=100)

    def __str__(self):
        return f" id : {self.id} {self.name}님이 주문하신 메뉴는 {self.menu}이며, size는 {self.size}, 빵은 {self.bread}, 추가 토핑은 {self.sauce}입니다. "