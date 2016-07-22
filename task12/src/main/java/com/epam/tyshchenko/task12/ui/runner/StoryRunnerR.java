package com.epam.tyshchenko.task12.ui.runner;

import com.codeborne.selenide.Configuration;

/**
 * Created by Olena_Tyshchenko on 22.07.2016.
 */
public class StoryRunnerR {

    private StoryRunnerR(){}

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String... args) {
        StoryRunner runnerConfig = new StoryRunner();
        Configuration.browser = Constants.BROWSER;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = Constants.WAIT;
        //runnerConfig.run();
    }
}
