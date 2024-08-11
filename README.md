## Spring Annotation

### Annotation

코드에 특별한 기능을 수행하도록 명시해 주는 것

- 컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
- 소프트웨어 개발 툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보를 제공
- 실행시(런타임시) 특정 기능을 실행하도록 정보를 제공

### @RestController

객체 데이터인 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송

### @RequestMapping

요청을 특정 메서드와 매핑하기 위해 사용하는 것이며, 여러개의 메소드에 공통적인 url은 class에 설정

### @GetMapping

@PostMapping
@PutMapping
@DeleteMapping

각각 GET/POST/PUT/DELETE 요청을 특정 핸들러 메서드에 매핑하기 위한 어노테이션

### @RequestBody

@ResponseBody

각각 HTTP요청 body를 자바객체로 변환하고 자바객체를 다시 HTTP 응답 body로 변환

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
