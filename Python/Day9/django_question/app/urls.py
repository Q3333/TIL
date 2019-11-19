from django.urls import path
from . import views

app_name = "app"
urlpatterns = [
    path('index/', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:q_id>/detail/', views.detail, name="detail"),
    path('<int:q_id>/<int:c_id>/choice_edit/', views.choice_edit, name="choice_edit"),
    path('<int:q_id>/delete/', views.delete, name="delete"),
    path('<int:q_id>/survey/', views.survey, name="survey"),
]