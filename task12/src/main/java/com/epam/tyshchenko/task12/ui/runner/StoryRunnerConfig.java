package com.epam.tyshchenko.task12.ui.runner;

import com.epam.tyshchenko.task12.ui.GoogleUiTest;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;

import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Story runner.
 */
public class StoryRunnerConfig extends ConfigurableEmbedder {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withDefaultFormats().withFormats(Format.HTML, Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        List<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new GoogleUiTest());
        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    /**
     * Story paths list.
     *
     * @return the list
     */
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
                Arrays.asList("**/*.story"), Arrays.asList(""));
    }

    @Override
    public void run() {
        Embedder embedder = configuredEmbedder();
        embedder.embedderControls().doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true);
        try {
            embedder.runStoriesAsPaths(storyPaths());
        } finally {
            embedder.generateCrossReference();
        }
    }


}
