from django.urls import path, include
# from .views import signup_view, login_view, logout_view, 
from .views import signup, getUserInfo

app_name = 'accounts'

urlpatterns = [
    path('signup/', signup, name='signup' ),
    path('user/', getUserInfo, name="getUserInfo" )
    # path('signup/', signup_view, name='signup'),
    # path('login/', login_view, name='login'),
    # path('logout/', logout_view, name='logout')
]