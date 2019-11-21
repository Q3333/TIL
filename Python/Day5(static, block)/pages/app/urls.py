from django.urls import path
from . import views

urlpatterns =[
    path('index/',views.index),
    path('artii_form/', views.artii_form),
    path('artii_result/', views.artii_result),
    path('user_new/', views.user_new),
    path('user_create/', views.user_create),
    path('subway_order/', views.subway_order),
    path('subway_result/', views.subway_result),
    path('static_example/', views.static_example),
    path('translate_form/', views.translate_form),
    path('translate_result/', views.translate_result),
]