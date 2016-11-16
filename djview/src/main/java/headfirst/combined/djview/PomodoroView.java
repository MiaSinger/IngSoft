package main.java.headfirst.combined.djview;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PomodoroView implements ActionListener,  BeatObserver, BPMObserver {
	BeatModelInterface model;
	ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    

    public PomodoroView(ControllerInterface controller, BeatModelInterface model) {	
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
    }
    
    public void createView() {
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("Pomodoro");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        label1=new JLabel("", SwingConstants.CENTER);
        label1.setIcon(new ImageIcon(getClass().getResource("pomodoro-timer.png")));
        label2=new JLabel();
        label3=new JLabel();
        bpmOutputLabel = new JLabel("", SwingConstants.LEFT);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        beatBar=new BeatBar();
        bpmPanel.add(beatBar);
		bpmPanel.add(label2);
        bpmPanel.add(label1);
        bpmPanel.add(label3);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
	}
  
  
    public void createControls() {
		// Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Pomodoro Timer");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));
        

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        startMenuItem = new JMenuItem("Iniciar Timer");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("Apagar Timer");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Salir");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Ingresar tiempo en minutos:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set Timer");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(new ImageIcon(getClass().getResource("sound.png")));
        decreaseBPMButton = new JButton(new ImageIcon(getClass().getResource("mute.png")));
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }

	public void enableStopMenuItem() {
    	stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
    	stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
    	startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
    	startMenuItem.setEnabled(false);
	}

    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
        	controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
    }

	public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
					label2.setIcon(new ImageIcon(getClass().getResource("cafe.png")));
        			label2.setText("<html><body><br><br><br>POMODORO COMPLETADO!!!<html><body>");
        			bpmOutputLabel.setText("     minutos restantes: "+model.getBPM() );
        			
				}
			} else {
				if (bpmOutputLabel != null) {
					label2.setIcon(new ImageIcon(getClass().getResource("libro.jpg")));
        			label2.setText( "<html><body><br><br><br><br> A TRABAJAR!!! <br><br><br><br>");
        		    bpmOutputLabel.setText("     minutos restantes: "+model.getBPM() );
        			updateBeat();
				}
			}
		}
	}
  
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}

	public JTextField getBpmTextField() {
		return bpmTextField;
	}

	public JButton getSetBPMButton() {
		return setBPMButton;
	}

	public JMenu getMenu() {
		return menu;
	}

	public JMenuItem getStartMenuItem() {
		return startMenuItem;
	}

	public JButton getDecreaseBPMButton() {
		return decreaseBPMButton;
	}

	public JMenuItem getStopMenuItem() {
		return stopMenuItem;
	}

	public void setStopMenuItem(JMenuItem stopMenuItem) {
		this.stopMenuItem = stopMenuItem;
	}

	public JButton getIncreaseBPMButton() {
		return increaseBPMButton;
	}
	
	


}