from django.shortcuts import render

# Create your views here.

def MyHobby(request):
    return render(request, 'myhobby.html')