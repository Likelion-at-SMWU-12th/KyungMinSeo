from django.db import models

# Create your models here.

class Write_Todo(models.Model):
    todo=models.TextField('할 일')
    todo_detail=models.TextField('설명')
    created_at=models.DateTimeField('작성일')
    completed=models.BooleanField('완료 여부')
    