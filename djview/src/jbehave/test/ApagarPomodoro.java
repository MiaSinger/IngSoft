package jbehave.test;

import static org.junit.Assert.assertFalse;

import org.jbehave.core.annotations.*;
public class ApagarPomodoro{

	@Then("pomodoroTimer cancelado")
	
	public void thenPomodoroTimerCancelado() throws InterruptedException{
		assertFalse(PomodoroTimerTest.timer.getSequencer().isRecording()); 
		
	}
	@When("el usuario pulsa el boton apagarTimer en el menu")
	
	public void whenElUsuarioPulsaElBotonApagarTimerEnElMenu() throws InterruptedException{
		PomodoroTimerTest.timercontroller.getView().getMenu().doClick();;
		Thread.sleep(3000);
		PomodoroTimerTest.timercontroller.getView().getStopMenuItem().doClick();
		Thread.sleep(3000);
	}
}