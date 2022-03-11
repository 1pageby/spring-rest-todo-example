# SPRING-REST-TODO-SERVICE easy example

### Prepared

* jdk 1.8 +
* MySQL

### IDE

* Eclipse, IDEA, VSCode all support `gradle` IDE.

### DB connection settings

* change application.propperties
```
spring.datasource.url=jdbc:mysql://{DB_HOST:DB_PORT}/{DB_NAME}
spring.datasource.username={DB_USERNAME}
spring.datasource.password={DB_PASSWORD}
```

### Build

* build jar

```
./gradlew clean build
```


### Swagger

> http://localhost:8080/swagger-ui/