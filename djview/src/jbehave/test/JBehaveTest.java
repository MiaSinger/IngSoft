package jbehave.test;


	/*
	// Here we specify the configuration, starting from default
	// MostUsefulConfiguration, and changing only what is needed
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		// where to find the stories
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.TXT));
	}

	// Here we specify the steps classes
	@Override
	public List<CandidateSteps> candidateSteps() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new IniciarPomodoro())
				.createCandidateSteps();
	}

	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return new StoryFinder().findPaths("/IngSoft/djview/src/jbehave/test", null, null);
		
	}
	*/

import java.util.List;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = JBehaveTest.StoryLoader.class,storyReporterBuilder = JBehaveTest.ReportBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false,ignoreFailureInView = true)
@UsingSteps(instances = { IniciarPomodoro.class, SilenciarPomodoro.class, EncenderSonido.class, ApagarPomodoro.class })
public class JBehaveTest extends InjectableEmbedder {
	
	
    @Test
    public void run() {
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
        System.out.println(storyPaths.toString());
        injectedEmbedder().runStoriesAsPaths(storyPaths);
    }

    public static class StoryLoader extends LoadFromClasspath {

        public StoryLoader() {
            super(JBehaveTest.class.getClassLoader());
        }
    }

    public static class ReportBuilder extends StoryReporterBuilder {

        public ReportBuilder() {
            this.withFormats(org.jbehave.core.reporters.Format.CONSOLE,org.jbehave.core.reporters.Format.HTML).withDefaultFormats();
        }
    }
    
    

    
}
    