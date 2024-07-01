from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.

#hw3
class User(AbstractUser):
    phone = models.CharField(verbose_name='전화번호', max_length=11) # verbose : 상세한
