from django.db import models

# Create your models here.

class Post (models.Model):
    image = models.ImageField(verbose_name='이미지')
    contentn = models.TextField('내용')
    created_at = models.DateTimeField('작성일')
    view_count = models.IntegerField('조회수', default=0) 

class Profile(models.Model):
    profile_img = models.ImageField(verbose_name='프로필사진')
    profile_name = models.TextField('닉네임')
    birthday = models.DateField('생년월일')
    profile_comment = models.TextField('한줄소개')