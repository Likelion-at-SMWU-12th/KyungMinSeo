from rest_framework.serializers import ModelSerializer
from .models import Post, User, Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__'
        

class PostListSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = ['id', 'writer','contentn','created_at','view_count']
        depth = 1

class PostCreateSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = ['image', 'contentn']

class UserModelSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = ['username','email','date_joined']

class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth = 1

class CommentListModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'