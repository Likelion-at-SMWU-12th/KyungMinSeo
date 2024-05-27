from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def function_view(request, date, month):
    context = {
        'date': date,
        'month': month
    }
    return render(request, 'diary_detail.html', context)
