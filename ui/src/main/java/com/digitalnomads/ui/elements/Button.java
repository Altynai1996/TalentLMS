package com.digitalnomads.ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Button extends BaseElement {
    public SelenideElement button;

    public Button(String xpath) {
        this.button=$(By.xpath(xpath));
    }
    public Button(String tag, String txt){
        this.button=$(By.xpath("//" + tag + "[normalize-space()='" + txt + "']"));
    }
    public Button click() {
        elementActions.clickButton(button);
        return this;
    }
}