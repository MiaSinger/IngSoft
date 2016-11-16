package jbehave.test;


import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.*;

public class IniciarPomodoro{
	
	@Given("GUI del PomodoroTimer")
	public void givenGUIDelPomodoroTimer() throws InterruptedException{
		
		Thread.sleep(1500);

	}
	
	@When("el usuario ingresa un valor en minutos")

	public void whenElUsuarioIngresaUnValorEnMinutos() throws InterruptedException{
		
		 PomodoroTimerTest.timercontroller.getView().getBpmTextField().setText("2");
		
		 Thread.sleep(2000);
	}
	
	@When("el usuario setea el valor pulsando el boton setTimer")

	public void whenElUsuarioSeteaElValorPulsandoElBotonSetTimer() throws InterruptedException{
		
		 PomodoroTimerTest.timercontroller.getView().getSetBPMButton().doClick();
		 
		 Thread.sleep(2000);
	}
	
	@When("el usuario pulsa el boton iniciarTimer en el menu")

	public void whenElUsuarioPulsaElBotonIniciarTimerEnElMenu() throws InterruptedException{
		 
		PomodoroTimerTest.timercontroller.getView().getMenu().doClick();
		 
		 Thread.sleep(1500);
		
		 PomodoroTimerTest.timercontroller.getView().getStartMenuItem().doClick();
		 
		 Thread.sleep(1500);
		 	 
	}
		 
	
	@Then("PomodoroTimer corriendo con sonido")
	
	public void thenElPomodoroTimerIniciaConSonido() throws InterruptedException{
		
		Thread.sleep(1500);
		
		assertTrue(PomodoroTimerTest.timer.getSequencer().isRunning());
		//assertTrue(PomodoroTimerTest.timer.getSequencer().isRecording());
		//this.timercontroller.getView().getStopMenuItem().doClick();
		Thread.sleep(1500);
		//System.exit(0);
		
		
	}
		 
}