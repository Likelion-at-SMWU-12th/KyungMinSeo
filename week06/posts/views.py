from django.shortcuts import render
from django.http import HttpResponse, JsonResponse

# Create your views here.
# def url_view(request):
#     return HttpResponse('url.view')

# def url_view(request):
#     data={'code':'001', 'msg':'OK'}
#     return JsonResponse(data)

def url_view(request):
    data={'code':'001', 'msg':'OK'}
    return HttpResponse('<h1>url_views</h1>')

def url_parameter_view(request, username):
    print(username)
    return HttpResponse()