from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('index/', views.index),
    path('subway_order/', views.subway_order),
    path('subway_result/', views.subway_result),
    path('subway_result/<int:number>', views.subway_result_number),
]
