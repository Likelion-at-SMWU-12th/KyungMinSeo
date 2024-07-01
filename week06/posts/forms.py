from django import forms
from .models import Post

# hw3 : Form
class PostBasedForm(forms.Form):
    image = forms.ImageField()
    content = forms.CharField(widget=forms.Textarea)
    CATEGORY_CHOICES = [
        ('1', '일반'),
        ('2', '계정'),
    ]
    category = forms.ChoiceField(label='카테고리', choices=CATEGORY_CHOICES)

# hw3 : ModelForm
class PostModelForm(forms.ModelForm):
    class Meta:
        model = Post
        fields = '__all__'