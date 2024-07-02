from django.contrib import admin
from .models import User

# Register your models here.

@admin.register(User) # User 모델을 admin에 등록
class PostModelAdmin(admin.ModelAdmin): # 관리자 클래스 정의
    pass # 빈 클래스