package com.digitalnomads.api.apiTests.users.apiTests;
import com.digitalnomads.api.controllers.UserController;
import org.testng.annotations.BeforeSuite;

import static com.digitalnomads.api.application.TalentLMSBaseEndPoint.BASE_URL;


public class BaseApiTests {
    protected UserController userController;

    @BeforeSuite(alwaysRun = true)
    public void setUpControllers() {
        this.userController = new UserController(BASE_URL);
    }
}

