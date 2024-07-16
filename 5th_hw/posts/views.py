from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet
from django_filters.rest_framework import DjangoFilterBackend

from .models import Post, Comment
from .serializers import PostSerializer, CommentSerializer

# Create your views here.

# 게시글 뷰셋
class PostModelViewSet(ModelViewSet):
    queryset=Post.objects.all()
    serializer_class=PostSerializer

    # 카테고리로 검색 필드 설정
    filter_backends = [DjangoFilterBackend] 
    filterset_fields = ['post_writer_id']

# 댓글 뷰셋
class CommentModelViewSet(ModelViewSet):
    queryset=Comment.objects.all()
    serializer_class=CommentSerializer



