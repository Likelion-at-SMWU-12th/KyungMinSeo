from django.db import models
from django.contrib.auth.models import AbstractUser, UserManager as DjangoUserManager

# Create your models here. 이 파일 수정 시 마이그레이션 할 것.

#hw3
class UserInfo(models.Model):
    phone_sub = models.CharField(verbose_name='보조_전화번호', max_length=11) # 보조 전화번호 필드
    user = models.ForeignKey(to='User', on_delete=models.CASCADE) # 외래 키 설정, on_delete : CASCADE | PROTECT | SET_NULL | SET_DEFAULT | DO_NOTHING

class UserManager(DjangoUserManager):
    def _create_user(self, username, email, password, **extra_fields): # 이메일 유효성 검사를 위한 내부 함수
        if not email:
            raise ValueError("이메일은 필수 값입니다. ")
        user = self.model(username=username, email=email, **extra_fields)
        user.set_password(password)
        user.save(using=self.db)
        return user
    
    def create_user(self, username, email=None, password=None, **extra_fields):
        extra_fields.setdefault('is_staff', False)
        extra_fields.setdefault('is_superuser', False)
        return self._create_user(username, email, password, **extra_fields) # 내부 함수 호출
    
    def create_superuser(self, username, email=None, password=None, **extra_fields):
        extra_fields.setdefault('is_staff', True)
        extra_fields.setdefault('is_superuser', True)
        return super().create_superuser(username, email, password, **extra_fields) # 수퍼 클래스의 create_superuser 호출
    
class User(AbstractUser):
    phone = models.CharField(verbose_name='전화번호', max_length=11) # verbose : 상세한
    objects = UserManager()