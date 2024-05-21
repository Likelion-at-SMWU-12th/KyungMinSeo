from django.contrib import admin
from .models import Post , Profile, Comment

# Register your models here.
# admin.site.register(Post)
admin.site.register(Profile)
admin.site.register(Comment)

@admin.register(Post)
class PostModelAdmin(admin.ModelAdmin):
    list_display = ['id', 'image', 'contentn', 'created_at', 'view_count', 'writer']
    # list_editable = ['contentn', 'writer']
    list_filter = ['created_at']
    search_fields = ['id', 'writer__username']
    search_help_text=['게시판번호, 작성자 검색이 가능합니다.']