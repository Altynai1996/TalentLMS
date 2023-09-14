package com.digitalnomads.api.asserts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import com.digitalnomads.api.entities.User;
@Slf4j
public class UserAssert {
    Response response;
    public UserAssert(Response response){
        this.response=response;
    }
    public static UserAssert assertThat(Response response){
        return new UserAssert(response);
    }
    public UserAssert isEquals(User expectedUser) {
        User actualUser = this.response.as(User.class);
        actualUser.isEquals(expectedUser);
        return this;
    }

    public UserAssert isIdNotNull() {
        User actualUser = this.response.as(User.class);
        Assertions.assertThat(actualUser.getId()).isNotNull();
        log.info("ID {} of user not NULL", actualUser.getId());
        return this;
    }

}
