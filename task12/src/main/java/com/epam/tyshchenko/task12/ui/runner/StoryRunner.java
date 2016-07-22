package com.epam.tyshchenko.task12.ui.runner;

import com.codeborne.selenide.Configuration;

/**
 * Created by Olena_Tyshchenko on 22.07.2016.
 */
public class StoryRunner {

    private StoryRunner(){}

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        StoryRunnerConfig runnerConfig = new StoryRunnerConfig();
        Configuration.browser = Constants.BROWSER;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = Constants.WAIT;
        runnerConfig.run();
    }
}
