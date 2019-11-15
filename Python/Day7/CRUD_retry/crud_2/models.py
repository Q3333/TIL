from django.db import models

# Create your models here.
class Menu(models.Model):
    name = models.CharField(max_length=30)
    price = models.IntegerField()
    content = models.TextField()
    date = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.id} , {self.name}"