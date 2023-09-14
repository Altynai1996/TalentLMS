package com.digitalnomads.api;

import lombok.Data;
import com.digitalnomads.api.entities.BaseEntity;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data

public abstract class ApiRequest {
    protected String url;
    protected RequestSpecification requestSpecification;
    /*
    RequestSpecification - это интерфейс библиотеки RestAssured о том, как сделать запрос к серверу
    для тестирования API.
    Куда отправить запрос, какие параметры и заголовки добавить, и что использовать в теле запроса.
    baseUri(String uri): Устанавливает базовый URI для всех запросов.
    basePath(String path): Устанавливает базовый путь для всех запросов.
    header(String name, Object value): Добавляет заголовок к запросу.
    param(String name, Object value): Добавляет параметр запроса.
    body(Object object): Устанавливает тело запроса.
    queryParam(String name, Object value): Добавляет параметр запроса в URL.
     */
    protected String apiKey;
    protected Response response;


    public ApiRequest(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        BasicAuthScheme auth = new BasicAuthScheme();
        auth.setUserName(this.apiKey);
        auth.setPassword("");
        this.requestSpecification = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri(this.url)
                .build();
    }

    public static Map<String, String> generateParams(String key, String value) {
        return new HashMap<>() {{
            put(key, value);
        }};
    }

    private void logResponse() {
        log.warn("Response is:");
        log.warn(this.response.getBody().asString());
        log.warn("Status code is: {}", String.valueOf(this.response.getStatusCode()));
    }

    public static String getEndPoint(String... args) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(args).forEach(a -> builder.append(a).append("/"));
        return builder.deleteCharAt(builder.length() - 1).toString();

    }

    public Response get(String endPoint) {
        log.info("Performed GET {}", endPoint);
        this.response = RestAssured.given()
                .spec(requestSpecification)
                .get(endPoint);
        return this.response;
    }

    public Response getWithParams(String endPoint, Map<String, String> params) {
        log.info("Performed GET {}", endPoint);
        this.response = RestAssured.given()
                .spec(requestSpecification)
                .formParams(params)
                .get(endPoint);
        logResponse();
        return this.response;
    }
    public Response post(String endPoint, String body) {
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = RestAssured.given()
                .spec(requestSpecification)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }
 public Response postWithParams(String endPoint, Map<String, String> params) {
        log.info("Performed POST {}", endPoint);
        this.response = RestAssured.given()
                .spec(requestSpecification)
                .formParams(params)
                .post(endPoint);
        logResponse();
        return this.response;
    }

    public <T extends BaseEntity> T extractObjectFromResponse(Class<T> tClass) {
        try {
            return this.response
                    .then()
                    .extract()
                    .body()
                    .as(tClass);
        } catch (Exception e) {
            log.error("Can not parse response {0}", e);
            return null;
            //Общий результат этого метода - извлечение объекта из тела ответа HTTP-запроса
            // и его преобразование в объект указанного класса. Параметр tClass предоставляет
            // информацию о том, какой класс ожидается в ответе, чтобы выполнить соответствующее
            // преобразование.
        }

    }
}








