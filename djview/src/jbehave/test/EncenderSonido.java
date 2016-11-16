package jbehave.test;



import org.jbehave.core.annotations.*;
public class EncenderSonido{
	
	@When("el usuario pulsa el boton para encender sonido")
	
	public void whenElUsuarioPulsaElBotonDeEncender() throws InterruptedException{
		PomodoroTimerTest.timercontroller.getView().getIncreaseBPMButton().doClick();
		Thread.sleep(3000);
	}
	
}