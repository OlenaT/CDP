package com.epam.tyshchenko.task12.ui;

import static org.junit.Assert.assertTrue;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;



/**
 * Created by Olena_Tyshchenko on 18.07.2016.
 */
@Resource.Classpath("properties/test.properties")
public class GoogleUiTest extends Steps {

    /**
     * Instantiates a new Google ui test.
     */
    public GoogleUiTest() {
        PropertyLoader.populate(this);
    }

    @Property("url")
    private String url;

    private GooglePage googlePage = new GooglePage();

    /**
     * Open google.
     */
    @Given("I open Google Search")
    public void openGoogle() {
        Selenide.open(url);
    }

    /**
     * Type text.
     *
     * @param text the text
     */
    @When("I type text $text")
    public void typeText(String text) {
        googlePage.searchField().val(text);
        googlePage.searchButton().click();
    }

    /**
     * Check results.
     *
     * @param text the text
     */
    @Then("search results should contain text $text")
    public void checkResults(String text) {
        for (SelenideElement el : googlePage.searchResults()) {
            assertTrue(el.getText().contains(text));
        }
    }
}
