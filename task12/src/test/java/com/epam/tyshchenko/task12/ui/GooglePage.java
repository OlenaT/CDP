package com.epam.tyshchenko.task12.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
public class GooglePage {

    public SelenideElement searchField(){
        return $(By.xpath("//input[@class='gsfi lst-d-f']"));
    }

    public SelenideElement searchButton(){
        return $(By.xpath("//*[@id='sblsbb']/button"));
    }

    public ElementsCollection searchResults(){
        return $$(By.xpath("//*[@id='rso']/div/div/div/h3/a"));
    }
}
