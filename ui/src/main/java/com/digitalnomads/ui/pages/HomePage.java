package com.digitalnomads.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.digitalnomads.ui.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage {

    public Button foodBtn= new Button("a", "Еда");
    public Button pharmacyBtn= new Button("a", "Аптека");


    public HomePage openSite() {
        open("https://nambafood.kg");
        return this;
    }

    public FoodPage clickTheFoodButtonOnBasePage() {
      foodBtn.click();
        return new FoodPage();
    }
}