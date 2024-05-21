from django.contrib import admin
from .models import Post , Profile, Comment

# Register your models here.
# admin.site.register(Post)
admin.site.register(Profile)
admin.site.register(Comment)

class CommentInLine(admin.TabularInline):   #StackedInLine도 사용 가능
    model=Comment
    extra=5
    min_num=3
    max_num=5
    verbose_name='댓글'
    verbose_name_plural='댓글들'

class PostModelAdmin(admin.ModelAdmin):
    list_display = ['id', 'image', 'contentn', 'created_at', 'view_count', 'writer']
    # list_editable = ['contentn', 'writer']
    list_filter = ['created_at']
    search_fields = ['id', 'writer__username']
    search_help_text=['게시판번호, 작성자 검색이 가능합니다.']
    readonly_fields=['view_count', 'created_at']
    inlines=[CommentInLine]

admin.site.register(Post, PostModelAdmin)
