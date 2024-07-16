from rest_framework.serializers import ModelSerializer
from .models import Post, Comment

class CommentSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'

class PostSerializer(ModelSerializer):
    comments = CommentSerializer(many=True, read_only=True, source='comment')

    class Meta:
        model = Post
        fields = '__all__'

