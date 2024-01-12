package tests.providers;

import configuration.ConfigProvider;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecificationProvider {
    ConfigProvider configProvider = new ConfigProvider();

    public RequestSpecification getRequestSpecification() {
        return given()
                .basePath(configProvider.getConfigProperties("detailsSuffix"))
                .contentType(ContentType.JSON);
    }

    public RequestSpecification getRequestSpecificationWithId(int id) {
        return given()
                .basePath(configProvider.getConfigProperties("detailsSuffixWithId"))
                .pathParam("id", id)
                .contentType(ContentType.JSON);
    }
}
