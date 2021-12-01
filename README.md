# Weather-bot
<p align="center"><img src="https://cdn-icons-png.flaticon.com/512/1163/1163624.png"
alt="Weather" height="300" />

# Description
This bot is based on <img src="https://cdn-icons-png.flaticon.com/512/226/226777.png" alt="Weather" height="30"/> platform and <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png" alt="Weather" height="20" /> 
.You can know the weather on your location.

## Development
- Development language: **Java 8**
- Framework: **Spring Boot 2.5.5**
- Libraries: **Lombok, MapStruct**
- API: **Yandex Weather Api**
- Build automation: **Gradle**

## API

- Find all person who use our bot and who sent his location
  -  http://localhost:8080/find-all-users
- Find all customers who use our bot
  -  http://localhost:8080/find-all-users
- Find the person on id
  -  http://localhost:8080/find-user-by-id/{id}
- Find the person and history of him location
  -  http://localhost:8080/find-history-user-by-id/{id}
  
 ## How to launch
 1. You must to install wrbhook in your browser where url - http://localhost:8080/, and mytoken - token is your bot. For example: https://api.telegram.org/bot(mytoken)/setWebhook?url=https://mywebpagetorespondtobot/mymethod
 2. Write the command inside your project.
 '''gradle
    ./gradlew bootrun
 '''
