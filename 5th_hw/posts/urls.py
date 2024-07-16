from django.urls import path, include
from .views import PostModelViewSet, CommentModelViewSet
from rest_framework import routers


app_name = 'blog'
router = routers.DefaultRouter()

router.register(r'post', PostModelViewSet, basename='post')
router.register(r'comment', CommentModelViewSet , basename='comment')


urlpatterns = [
    path('', include(router.urls)),
]