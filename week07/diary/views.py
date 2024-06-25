from django.shortcuts import render
from django.http import HttpResponse

from django.views.generic import ListView
from .models import Write_Todo

# Create your views here.

def function_view(request, date, month):
    context = {
        'date': date,
        'month': month
    }
    return render(request, 'diary_detail.html', context)


class class_view(ListView):
    model=Write_Todo
    template_name='todo_detail.html'

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['date'] = self.kwargs['date']
        context['month'] = self.kwargs['month']
        return context