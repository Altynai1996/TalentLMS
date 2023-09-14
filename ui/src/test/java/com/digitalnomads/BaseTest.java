package com.digitalnomads;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.digitalnomads.ui.driversFactory.Driver;
import com.digitalnomads.ui.helper.ElementActions;
import com.digitalnomads.ui.pages.FoodPage;
import com.digitalnomads.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public ElementActions elementActions;
    public FoodPage foodPage;
    public HomePage homePage;


    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        foodPage = new FoodPage();
        homePage = new HomePage();
        Configuration.headless=false;
        Configuration.timeout=10000;
        Configuration.screenshots=true;
        Configuration.browserSize="1920x1080";

    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
