package main.java.headfirst.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		//HeartModel heartModel = new HeartModel();
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
    }
}