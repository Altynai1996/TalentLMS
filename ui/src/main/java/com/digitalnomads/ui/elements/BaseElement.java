package com.digitalnomads.ui.elements;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.digitalnomads.ui.helper.ElementActions;
import com.digitalnomads.ui.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement extends BasePage {
    ElementActions elementActions=new ElementActions();
    public SelenideElement btn;


}