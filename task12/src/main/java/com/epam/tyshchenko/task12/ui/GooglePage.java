package com.epam.tyshchenko.task12.ui;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;



/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
public class GooglePage {

    /**
     * Search field selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement searchField(){
        return $(By.xpath("//input[@class='gsfi lst-d-f']"));
    }

    /**
     * Search button selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement searchButton(){
        return $(By.xpath("//*[@id='sblsbb']/button"));
    }

    /**
     * Search results elements collection.
     *
     * @return the elements collection
     */
    public ElementsCollection searchResults(){
        return $$(By.xpath("//*[@id='rso']/div/div/div/h3/a"));
    }
}
