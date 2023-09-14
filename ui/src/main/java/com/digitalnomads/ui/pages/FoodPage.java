package com.digitalnomads.ui.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class FoodPage extends BasePage {
    public ElementsCollection foodSection=$$("//div[@class='cat-wrap']/a");

    public FoodPage clickTheFirstElement( ){
        elementActions.clickButton(foodSection.get(0));
        return this;
    }
}

