from django.shortcuts import render, redirect
from .forms import SignUpForm
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth import login, logout
from django.contrib.auth.password_validation import validate_password
from django.contrib.auth import get_user_model
from django.core.exceptions import ValidationError
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view

from .serializers import SignUpSerializer

# Create your views here.

# def signup_view(request):
#     # GET 요청 시 HTML 응답
#     if request.method == 'GET':
#         form = SignUpForm
#         context = {'form' : form}
#         return render(request, 'accounts/signup.html', context)
    
#     else:
#         form =SignUpForm(request.POST)
#         if form.is_valid():
#             instance = form.save()
#             return redirect('index')
#         else:
#             return redirect('accounts/signup')
        

# def login_view(request):
#     if request.method == 'GET':
#         return render(request, 'accounts/login.html', {'form' : AuthenticationForm})
    
#     else:
#         form =AuthenticationForm(request, request.POST)
#         if form.is_valid():
#             login(request, form.user_cache)
#             return redirect('index')
#         else:
#             return render(request, 'accounts/login.html', {'form':form})
        
# def logout_view(request):
#     if request.user.is_authenticated:
#         logout(request)
#     return redirect('index')

# 회원 가입
@api_view(['POST'])
def signup(request):
    email = request.data.get('email')
    password = request.data.get('password')
    password2 = request.data.get('password2')
    username = request.data.get('username')

    # 비밀번호 일치 확인
    if password != password2:
        return Response({"password": ["입력한 비밀번호가 다릅니다."]}, status=status.HTTP_400_BAD_REQUEST)
    
    # 비밀번호 유효성 검사
    try:
        validate_password(password)
    except ValidationError as e:
        return Response({"password": e.messages}, status=status.HTTP_400_BAD_REQUEST)

    # serializer로 유효성 검사 후 데이터 전달
    serializer = SignUpSerializer(data=request.data)
    serializer.email = email
    serializer.username = username

    if serializer.is_valid(raise_exception=True):
        user = serializer.save()
        user.set_password(password)
        user.save()

        return Response(serializer.data, status=status.HTTP_201_CREATED)
    
# 회원 조회
@api_view(['GET'])
def getUserInfo(request):
    username = request.query_params.get('username')

    User = get_user_model()

    try:
        user = User.objects.get(username=username)
        
        user_info = {
            "username": user.username,
            "email": user.email,
            "phone": user.phone  # 만약 User 모델에 phone 필드가 없고 Profile 모델에 있다면 이렇게 접근
        }

        return Response(user_info, status=status.HTTP_200_OK)
    
    except User.DoesNotExist:
        return Response("해당 username을 가진 사용자가 없습니다.", status=status.HTTP_404_NOT_FOUND)
