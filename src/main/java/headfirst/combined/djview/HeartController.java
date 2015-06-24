package main.java.headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		
		//tratar de generar una nueva instancia de HeartModel
				HeartModel modelo = HeartModel.getInstance();
				modelo.notifyBPMObservers();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}
