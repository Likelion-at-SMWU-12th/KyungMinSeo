## Django

- python 언어로 이루어진 웹 애플리케이션 프레임워크.

## MVT Pattern

- **Model**
  - 데이터 모델을 의미
  - Django의 model 모듈을 이요하여 models.py 파일에 class를 만들고 속성을 기입
- **Template**
  - 사용자가 직접 접근하는 html 같은 페이지
  - urls.py에서 url 패턴에 따라 특정 함수를 불러오도록 설정하여 사용자에게 보여줌
- **View**
  - Template에서 받아지는 request를 처리하고 response를 해주는 역할

<img width="1146" alt="image" src="https://github.com/Likelion-at-SMWU-12th/KyungMinSeo/assets/110973127/71d24952-84b3-4014-a6ee-7b8ea6d7591f">

## Model과 View의 관계

- Model은 View에 의해 요청되는 데이터를 제공한다.
- View는 Model 에게 조회, 갱신, 삭제를 요청하여 DB에 적용한다.

## Template과 View의 관계

- Template은 View에게 client에게 받은 데이터(request)를 넘겨준다.
- View는 Template에게 response로 보여줄 데이터를 제공한다.

## 웹페이지 동작

1. 클라이언트로 부터 요청(Request)를 받으면 URLconf 모듈을 이용하여 URL을 분석한다.
2. URL 분석 결과를 통해 해당 URL에 매칭되는 View를 실행한다.
3. View는 자신의 로직을 실행하고, 데이터베이스 처리가 필요하면 Model을 통해 처리하고 그결과를 반환 받는다.
4. View는 자신의 로직 처리가 끝나면 Template을 사용하여 클라이언트에 전송할 HTML 파일을 생성한다.
5. View는 최종 결과로 HTML 파일을 클라이언트에게 보내 응답(Response)한다.
