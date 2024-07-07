from rest_framework import serializers
from django.contrib.auth import get_user_model

# 회원가입
class SignUpSerializer(serializers.ModelSerializer):
    class Meta:
        model = get_user_model()
        fields = ('username', 'email', 'password')

