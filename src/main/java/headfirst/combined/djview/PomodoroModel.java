package main.java.headfirst.combined.djview;

import java.util.ArrayList;

//aca implementamos todo lo que tiene que ver con el reloj
public class PomodoroModel implements BeatModelInterface{
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	
	public void initialize(){}
	  
	public void on(){}
  
	public void off(){}
  
    public void setBPM(int bpm){}
  
	public int getBPM(){return 0;}
  
	public void registerObserver(BeatObserver o){}
  
	public void removeObserver(BeatObserver o){}
  
	public void registerObserver(BPMObserver o){}
  
	public void removeObserver(BPMObserver o){}

}
