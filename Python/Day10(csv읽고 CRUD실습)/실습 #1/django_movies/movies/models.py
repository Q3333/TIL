from django.db import models
from django.utils import timezone

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=50)
    title_en = models.CharField(max_length=50)
    audience = models.IntegerField(default=0)
    open_date = models.DateTimeField(default=timezone.now)
    genre = models.CharField(max_length=30)
    watch_grade = models.CharField(max_length=30)
    score = models.FloatField(default=0)
    poster_url = models.TextField(default="")
    description = models.TextField(default="")

    def __str__(self):
        return f'{self.title} > {self.score}'