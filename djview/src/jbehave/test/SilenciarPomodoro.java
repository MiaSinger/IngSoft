package jbehave.test;

import static org.junit.Assert.assertFalse;


import org.jbehave.core.annotations.*;

public class SilenciarPomodoro{
	@Then("PomodoroTimer corriendo silenciado")
	
	public void thenPomodoroTimerSilenciado(){
		assertFalse(PomodoroTimerTest.timer.getSequencer().isRunning());
		//assertTrue(PomodoroTimerTest.timer.getSequencer().isRecording());
		
	}
	@When("el usuario pulsa el boton mute")
	
	public void whenElUsuarioPulsaElBotonMute() throws InterruptedException{
		 PomodoroTimerTest.timercontroller.getView().getDecreaseBPMButton().doClick();
		 Thread.sleep(3000);
	}
	
}