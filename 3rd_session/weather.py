import requests
import json

city = "New York"
apikey = "3a6039d196040082907e6bd63aeb18e7"
lang="kr"

api = f"https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apikey}&lang={lang}&units=metric"

result = requests.get(api)

data = json.loads(result.text)

# print(data["name"], '의 날씨입니다.')
# print('날씨는', data['weather'][0]['description'], '입니다.')
# print('현재 온도는', data['main']['temp'], '입니다.')
# print('하지만 체감 온도는', data['main']['feels_like'], '입니다.')
# print('최저 기온은', data['main']['temp_min'], '입니다.')cle
# print('최고 기온은', data['main']['temp_max'], '입니다.')
# print('기압은', data['main']['pressure'], '입니다.')
# print('습도는', data['main']['humidity'], '입니다.')

print('--------------------------------')
print(data["name"], '의 날씨입니다.')
print('--------------------------------')
print('날씨\t\t',data['weather'][0]['description'] )
print('현재 온도\t', data['main']['temp'])
print('체감 온도\t', data['main']['feels_like'])
print('최저 기온\t', data['main']['temp_min'])
print('최고 기온\t', data['main']['temp_max'])
print('기압\t\t', data['main']['pressure'])
print('습도\t\t', data['main']['humidity'])
print('풍속\t\t', data['wind']['speed'])

if 'rain' in data:
    print('강수량\t\t', data['rain']['1h'])
else:
    print('강수량\t\t', '0')
