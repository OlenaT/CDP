package com.epam.tyshchenko.task12.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.tyshchenko.task12.ui.runner.Constants;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

import static org.junit.Assert.assertTrue;

/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
@Resource.Classpath("properties/test.properties")
public class GoogleUiTest extends Steps {

    public GoogleUiTest() {
        PropertyLoader.populate(this);
        Configuration.browser = Constants.BROWSER;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = Constants.WAIT;
    }

    @Property("url")
    private String url;

    private GooglePage googlePage = new GooglePage();

    @Given("I open Google Search")
    public void openGoogle() {
        Selenide.open(url);
    }

    @When("I type text $text")
    public void typeText(String text) {
        googlePage.searchField().val(text);
        googlePage.searchButton().click();
    }

    @Then("search results should contain text $text")
    public void checkResults(String text) {
        for (SelenideElement el : googlePage.searchResults()) {
            assertTrue(el.getText().contains(text));
        }
    }
}
