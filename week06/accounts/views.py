from django.shortcuts import render, redirect
from .forms import SignUpForm
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth import login, logout

# Create your views here.

def signup_view(request):
    # GET 요청 시 HTML 응답
    if request.method == 'GET':
        form = SignUpForm
        context = {'form' : form}
        return render(request, 'accounts/signup.html', context)
    
    else:
        form =SignUpForm(request.POST)
        if form.is_valid():
            instance = form.save()
            return redirect('index')
        else:
            return redirect('accounts/signup')
        

def login_view(request):
    if request.method == 'GET':
        return render(request, 'accounts/login.html', {'form' : AuthenticationForm})
    
    else:
        form =AuthenticationForm(request, request.POST)
        if form.is_valid():
            login(request, form.user_cache)
            return redirect('index')
        else:
            return render(request, 'accounts/login.html', {'form':form})