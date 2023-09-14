package com.digitalnomads.api.asserts;

import com.digitalnomads.api.entities.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

@Slf4j
public class ApiAsserts {

    Response response;

    public ApiAsserts(Response response) {
        this.response = response;
    }

    public static ApiAsserts assertThat(Response response) {
        return new ApiAsserts(response);
    }

    public ApiAsserts isCorrectStatusCode(Integer expectedStatusCode) {
        int actualStatusCode = this.response.getStatusCode();
        Assertions.assertThat(actualStatusCode)
                .withFailMessage("Status code is not correct")
                .isEqualTo(expectedStatusCode);
        log.info("Status code is correct Actual {}, Expected {}", actualStatusCode, expectedStatusCode);
        return this;
    }

    public UserAssert isEquals(User expectedUser) {
        return UserAssert.assertThat(this.response);
    }
}

