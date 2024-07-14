from django.db import models
from django.contrib.auth import get_user_model
from django_filters.rest_framework import DjangoFilterBackend


# Create your models here.
User = get_user_model()

# 게시글 모델
class Post(models.Model):
    post_title = models.TextField(verbose_name='게시글 제목')
    post_content = models.TextField(verbose_name='게시글 내용')
    post_created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)
    post_writer_id = models.ForeignKey(to=User, on_delete=models.CASCADE, verbose_name='글작성자', null=True, blank=True)

    # 카테고리로 검색 필드 설정
    filter_backends = [DjangoFilterBackend] 
    filterset_fields = ['post_writer_id']

# 댓글 모델
class Comment(models.Model):
    comment_content = models.TextField(verbose_name='댓글 내용')
    comment_created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)
    comment_post_id = models.ForeignKey(to=Post, on_delete=models.CASCADE, db_column="post_id")
    comment_writer_id = models.ForeignKey(to=User, on_delete=models.CASCADE, verbose_name='댓글작성자', null=True, blank=True)
