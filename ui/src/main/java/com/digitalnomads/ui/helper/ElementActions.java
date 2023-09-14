package com.digitalnomads.ui.helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.digitalnomads.ui.driversFactory.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    public ElementActions clickButton(SelenideElement element) {
        element.shouldBe(Condition.visible).click();
        return this;
    }

    public ElementActions writeText(SelenideElement element, String txt) {
        element.shouldBe(Condition.visible).sendKeys(txt);
        return this;
    }
    public ElementActions scrollToElement(SelenideElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Selenide.webdriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public ElementActions clickViaJavaScript(SelenideElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click(true);", element);
        return this;

    }

    public ElementActions highlightElement(SelenideElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid green");
        return this;
    }

    public ElementActions scrollToTop(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        return this;
    }
    public ElementActions moveToElement(SelenideElement element){
        element.shouldBe(Condition.visible).hover();
        return this;
    }
}

