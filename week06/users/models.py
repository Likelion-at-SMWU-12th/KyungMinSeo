from django.db import models
from django.contrib.auth.models import AbstractUser, UserManager as DjangoUserManager

# Create your models here.

#hw3
class User(AbstractUser):
    phone = models.CharField(verbose_name='전화번호', max_length=11) # verbose : 상세한

class UserInfo(models.Model):
    phone_sub = models.CharField(verbose_name='보조_전화번호', max_length=11) # 보조 전화번호 필드
    user = models.ForeignKey(to='User', on_delete=models.CASCADE) # 외래 키 설정, on_delete : CASCADE | PROTECT | SET_NULL | SET_DEFAULT | DO_NOTHING
