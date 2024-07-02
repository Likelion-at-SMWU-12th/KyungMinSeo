# 장고의 Forms

Tags: HW

<aside>
🟢 공식 문서 참조

[https://docs.djangoproject.com/ko/5.0/topics/forms/](https://docs.djangoproject.com/ko/5.0/topics/forms/)

</aside>

# GET 과 POST

GET : 제출된 문자열들을 URL형태로 반환해준다. 

ex. https://docs.djangoproject.com/search/?q=forms&release=1 

POST : 장고의 로그인 Form은 POST 메서드로 반환된다. 

# Django Form class

장고에서 제공하는 클래스로 HTML의 <input> 태그에 맵핑된다. 데이터가 제출될 때는 유효성 검사를 수행해주고 브라우저 상에서 사용자에게는 HTML widget으로 표시된다. 

# Django instance rendering

장고에서는 3가지 방법으로 객체를 렌더링한다.

1. 뷰(데이터베이스)에서 객체 가져오기
2. 템플릿 컨텍스트로 전달하기
3. 템플릿 변수를 사용하여 HTML 마크업으로 전달하기

폼을 처리할 때는 일반적으로 뷰에서(데이터베이스에서) 폼을 인스턴스화한다.

폼 양식을 렌더링할 때는 양식을 미리 채워둘 수도 있는데,

1. 저장된 모델 인스턴스의 데이터
2. 다른 곳에서 수집한 데이터
3. 이전 HTML 양식 제출에서 받은 데이터

# **Building a form field in Django**

```python
from django import forms

class NameForm(forms.Form):
    your_name = forms.CharField(label="Your name", max_length=100)
```

- 사용 가능한 Form field
    
    [`BooleanField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#booleanfield), [`CharField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#charfield), [`ChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#choicefield), [`TypedChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#typedchoicefield), [`DateField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#datefield), [`DateTimeField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#datetimefield), [`DecimalField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#decimalfield), [`DurationField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#durationfield), [`EmailField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#emailfield), [`FileField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#filefield), [`FilePathField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#filepathfield), [`FloatField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#floatfield), [`ImageField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#imagefield), [`IntegerField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#integerfield), [`GenericIPAddressField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#genericipaddressfield), [`MultipleChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#multiplechoicefield), [`TypedMultipleChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#typedmultiplechoicefield), [`NullBooleanField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#nullbooleanfield), [`RegexField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#regexfield), [`SlugField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#slugfield), [`TimeField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#timefield), [`URLField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#urlfield), [`UUIDField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#uuidfield), [`ComboField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#combofield), [`MultiValueField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#multivaluefield), [`SplitDateTimeField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#splitdatetimefield), [`ModelMultipleChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#modelmultiplechoicefield), [`ModelChoiceField`](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#modelchoicefield) .
    
- field에서 사용 가능한 속성들
    - [required](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#required): 보통 필드는 required는 True로 기본 설정되므로, 폼에서 빈 칸을 허용하기 위해서는`required=False` 로 설정해야 한다.
    - [label](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#label): HTML에서 필드를 렌더링할때 사용하는 레이블.
    - [initial](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#initial): 폼이 나타날 때 해당 필드의 초기 값.
    - [widget](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#widget): 사용할 디스플레이 위젯.
    - [help_text](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#help-text) : 필드 사용법을 보여주는 추가적인 문구.
    - [error_messages](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#error-messages): 해당 필드의 에러 메시지 목록. 필요하면 문구를 수정할 수 있다.
    - [disabled](https://docs.djangoproject.com/en/2.0/ref/forms/fields/#disabled): 이 옵션이 `True` 일때 해당 필드를 볼 수는 있지만 편집이 안됨.

# View

폼 양식이 있는 뷰와 동일한 뷰에서 들어온 데이터를 처리하는 것이 일반적이다.

1. 양식을 띄울 URL에 대한 뷰에서 폼을 인스턴스화한다. 
    1. is_valid() : 양식으로 들어온 데이터가 유효한지 체크한다. 유효하면 True를 반환하고 데이터를 cleaned_data 속성에 배치한다. 

```python
from django.http import HttpResponseRedirect
from django.shortcuts import render

from .forms import NameForm

def get_name(request):
    # if this is a POST request we need to process the form data
    if request.method == "POST":
        # create a form instance and populate it with data from the request:
        form = NameForm(request.POST)
        # check whether it's valid:
        if form.is_valid():
            # process the data in form.cleaned_data as required
            # ...
            # redirect to a new URL:
            return HttpResponseRedirect("/thanks/")

    # if a GET (or any other method) we'll create a blank form
    else:
        form = NameForm()

    return render(request, "name.html", {"form": form})
```

이 뷰로 GET이 들어오면 비어있는 form 이 생성되고 렌더링된다. `form = NameForm()`

POST가 들어오면 뷰는 다시 폼을 생성하고 요청의 데이터로 클래스를 채운다(form binding). `form = NameForm(request.POST)`

이후에 is_valid()를 통해서 form 이 유효하여 통과되고 나서 처리할 과정들을 넣어줄 수 있다. 

# Template

템플릿에서 {{ form }}을 넣으면 장고 템플릿 언어에 의해 HTML로 풀어져 보이게 된다. 

```html
<form action="/your-name/" method="post">
    {% csrf_token %}
    {{ form }}
    <input type="submit" value="Submit">
</form>
```

# cleaned_data

제출된 데이터가 유효성 검증이 된 이후 form.cleaed_data에 저장되게 된다. 

따라서 form.cleaed_data에서 필드 값을 가져와 유효성 검증이 완료된 필드값을 가져올 수 있다. 

```python
from django.core.mail import send_mail

**if form.is_valid():**
    subject = **form.cleaned_data[**"subject"]
    message = form.cleaned_data["message"]
    sender = form.cleaned_data["sender"]
    cc_myself = form.cleaned_data["cc_myself"]

    recipients = ["info@example.com"]
    if cc_myself:
        recipients.append(sender)

    send_mail(subject, message, sender, recipients)
    return HttpResponseRedirect("/thanks/")
```