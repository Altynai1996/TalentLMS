package com.digitalnomads;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FoodTest extends BaseTest {
    @Test
    public void testFoodButtons() {
        homePage.openSite()
                .clickTheFoodButtonOnBasePage()
                .clickTheFirstElement();
    }

    @Test
    public void checkKitchenAmountTest() {
        homePage.openSite().clickTheFoodButtonOnBasePage();
        Assert.assertEquals(foodPage.foodSection.size(), 16);
    }

    @Test
    public void checkNationalFood() {
        homePage.openSite().clickTheFoodButtonOnBasePage();
        Assert.assertTrue(foodPage.foodSection.stream().anyMatch(element -> element.getText().contains("НАЦИОНАЛЬНАЯ КУХНЯ")));
        Assert.assertTrue(foodPage.foodSection.stream().anyMatch(element -> element.getText().contains("КИТАЙСКАЯ КУХНЯ")));
        //foodPage.foodSection.forEach(element -> System.out.println(element.getText()));
    }



    @Test
    public void selenideTest() {
        open("https://nambafood.kg/");
        $(By.xpath("//a[@href='/food']")).click();
        $$(By.xpath("//div[@class='cat-wrap']/a")).shouldHave(CollectionCondition.size(16));
        $$(By.xpath("//div[@class='cat-wrap']/a")).shouldHave(CollectionCondition.itemWithText("НАЦИОНАЛЬНАЯ КУХНЯ"));

    }
}
