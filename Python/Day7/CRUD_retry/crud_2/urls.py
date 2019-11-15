from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('menu_form/', views.menu_form),
    path('menu_send/', views.menu_send),
    path('<int:pk>/detail/', views.detail),
    path('<int:pk>/update/', views.update),
    path('<int:pk>/update_complete/', views.update_complete),
    path('<int:pk>/delete/', views.delete)
]