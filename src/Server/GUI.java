package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7282884383222843248L;
	private static final String title = "Server Binary Tetris v0."+serialVersionUID;
	private GridLayout master = new GridLayout(4,1);
	private GridLayout controlsLayout = new GridLayout(1,5);
	private GridLayout serverAreaLayout = new GridLayout(1,1);
	private JPanel masterPanel = new JPanel(master);
	private JPanel controls = new JPanel(controlsLayout);
	private GridLayout layoutParameter = new GridLayout(1,4);
	private GridLayout panelLayout = new GridLayout(3,1);
	private JPanel linesPanel = new JPanel(layoutParameter);	
	private JPanel linesLeft = new JPanel();
	private JPanel linesMiddleLeft = new JPanel(panelLayout);
	private JPanel linesMiddleRight = new JPanel(panelLayout);
	private JPanel linesRight = new JPanel();		
	private JPanel linesLabelUp = new JPanel();
	private JLabel linesLabel = new JLabel("Lines:");
	private JPanel linesLabelDown = new JPanel();		
	private JPanel linesTextFieldUp = new JPanel();
	private JTextField linesTextField = new JTextField();
	private JPanel linesTextFieldDown = new JPanel();
	private JPanel columnsPanel = new JPanel(layoutParameter);
	private JPanel columnsLeft = new JPanel();
	private JPanel columnsMiddleLeft = new JPanel(panelLayout);
	private JPanel columnsMiddleRight = new JPanel(panelLayout);
	private JPanel columnsRight = new JPanel();
	private JPanel columnsLabelUp = new JPanel();
	private JLabel columnsLabel = new JLabel("Columns:");
	private JPanel columnsLabelDown = new JPanel();
	private JPanel columnsTextFieldUp = new JPanel();
	private JTextField columnsTextField = new JTextField();
	private JPanel columnsTextFieldDown = new JPanel();
	private JPanel addressPanel = new JPanel(layoutParameter);
	private JPanel addressLeft = new JPanel();
	private JPanel addressMiddleLeft = new JPanel(panelLayout);
	private JPanel addressMiddleRight = new JPanel(panelLayout);
	private JPanel addressRight = new JPanel();
	private JPanel addressLabelUp = new JPanel();
	private JLabel addressLabel = new JLabel("Server address:");
	private JPanel addressLabelDown = new JPanel();
	private JPanel addressFieldUp = new JPanel();
	private JTextField addressField = new JTextField();
	private JPanel addressFieldDown = new JPanel();
	private JPanel velocityPanel = new JPanel(layoutParameter);
	private JPanel velocityLeft = new JPanel();
	private JPanel velocityMiddleLeft = new JPanel(panelLayout);
	private JPanel velocityMiddleRight = new JPanel(panelLayout);
	private JPanel velocityRight = new JPanel();
	private JPanel velocityLabelUp = new JPanel();
	private JLabel velocityLabel = new JLabel("Difficulty:");
	private JPanel velocityLabelDown = new JPanel();
	private JPanel velocityFieldUp = new JPanel();
	private JTextField velocityField = new JTextField();
	private JPanel velocityFieldDown = new JPanel();
	private JPanel controlsOne = new JPanel();
	private JPanel controlsTwo = new JPanel(panelLayout);
	private JPanel controlsThree = new JPanel(panelLayout);
	private JPanel controlsFour = new JPanel(panelLayout);
	private JPanel controlsFive = new JPanel();	
	private JPanel startButtonUp = new JPanel();
	private JButton start = new JButton("Start");
	private JPanel startButtonDown = new JPanel();	
	private JPanel stopButtonUp = new JPanel();
	private JButton stop = new JButton("Stop");
	private JPanel stopButtonDown = new JPanel();
	private JPanel exitButtonUp = new JPanel();
	private JButton exit = new JButton("Exit");
	private JPanel exitButtonDown = new JPanel();
	private JPanel serverArea = new JPanel(serverAreaLayout);
	private JTextArea serverText = new JTextArea();
	private JScrollPane serverScrollPane = new JScrollPane(serverText);
	private Server server;
	
	
	public GUI() {
		setVisible(true);
		InitConfig();
		

		add(masterPanel, BorderLayout.NORTH);
		add(controls, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	public void InitConfig() {
		ConfigFrame();
		ConfigComponents();
		ConfigControls();
		ConfigServer();	
	}
	private void ConfigComponents() {	
		linesPanel.add(linesLeft);
		linesPanel.add(linesMiddleLeft);
		linesPanel.add(linesMiddleRight);
		linesPanel.add(linesRight);		
		linesMiddleLeft.add(linesLabelUp);
		linesMiddleLeft.add(linesLabel);
		linesMiddleLeft.add(linesLabelDown);		
		linesMiddleRight.add(linesTextFieldUp);
		linesMiddleRight.add(linesTextField);
		linesMiddleRight.add(linesTextFieldDown);		
		columnsPanel.add(columnsLeft);
		columnsPanel.add(columnsMiddleLeft);
		columnsPanel.add(columnsMiddleRight);
		columnsPanel.add(columnsRight);		
		columnsMiddleLeft.add(columnsLabelUp);
		columnsMiddleLeft.add(columnsLabel);
		columnsMiddleLeft.add(columnsLabelDown);		
		columnsMiddleRight.add(columnsTextFieldUp);
		columnsMiddleRight.add(columnsTextField);
		columnsMiddleRight.add(columnsTextFieldDown);
		addressPanel.add(addressLeft);
		addressPanel.add(addressMiddleLeft);
		addressPanel.add(addressMiddleRight);
		addressPanel.add(addressRight);		
		addressMiddleLeft.add(addressLabelUp);
		addressMiddleLeft.add(addressLabel);
		addressMiddleLeft.add(addressLabelDown);	
		addressMiddleRight.add(addressFieldUp);
		addressMiddleRight.add(addressField);
		addressMiddleRight.add(addressFieldDown);
		velocityPanel.add(velocityLeft);
		velocityPanel.add(velocityMiddleLeft);
		velocityPanel.add(velocityMiddleRight);
		velocityPanel.add(velocityRight);
		velocityMiddleLeft.add(velocityLabelUp);
		velocityMiddleLeft.add(velocityLabel);
		velocityMiddleLeft.add(velocityLabelDown);
		velocityMiddleRight.add(velocityFieldUp);
		velocityMiddleRight.add(velocityField);
		velocityMiddleRight.add(velocityFieldDown);
		masterPanel.add(linesPanel);
		masterPanel.add(columnsPanel);
		masterPanel.add(addressPanel);
		masterPanel.add(velocityPanel);	
		
		linesTextField.setText("10");
		columnsTextField.setText("5");
		addressField.setText("127.0.0.1:8080");
		velocityField.setText("1");
		
		setWhite(masterPanel);
	}
	private void ConfigControls() {		
		controls.add(controlsOne);
		controls.add(controlsTwo);
		controls.add(controlsThree);
		controls.add(controlsFour);
		controls.add(controlsFive);
		controlsTwo.add(startButtonUp);
		controlsTwo.add(start);
		controlsTwo.add(startButtonDown);
		controlsThree.add(stopButtonUp);
		controlsThree.add(stop);
		controlsThree.add(stopButtonDown);
		controlsFour.add(exitButtonUp);
		controlsFour.add(exit);
		controlsFour.add(exitButtonDown);
		
		setWhite(controls);
	}
	private void ConfigServer() {
		serverArea.removeAll();
		
		serverText.setText("");
		serverText.setEditable(false);
		serverArea.add(serverScrollPane);	
		
		setWhite(serverArea);
	}	
	
	
	
	private void Idle() { 		
		remove(serverArea);
		add(masterPanel, BorderLayout.NORTH);	
		paintAll(getGraphics());
	}
	
	private void InGame() {
		remove(masterPanel);
		add(serverArea, BorderLayout.CENTER);
		paintAll(getGraphics());
	}
	
	private void ConfigFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 100);
		setSize(500,400);
		setTitle(title);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(server != null) {
//					if(server.isAlive()) {
						if(validateInput()) {
							InGame();
							server.start();
							
							
							start.setEnabled(false);
							stop.setEnabled(true);
						}
						
						
//					}
//				}
			}
		});
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(server != null) {
					if(server.isAlive()) {
						Idle();
						server.interrupt();
						
						
						start.setEnabled(true);
						stop.setEnabled(false);
					}
				}
				
				
				
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	

	private void setWhite(JPanel panel) {
		for(int i = 0; i < panel.getComponents().length; i++) {
			Component component = panel.getComponents()[i];
			if(component instanceof JPanel) {
				setWhite((JPanel)component);
			}
			panel.getComponents()[i].setBackground(Color.white);
		}
	}
	
	
	private boolean validateInput() {
		try {
			int numberLines = Integer.parseInt(linesTextField.getText());
			int numberColumns = Integer.parseInt(columnsTextField.getText());
			String inetAddress = new String("");
			int velocity = 0;
			try {
				velocity = Integer.parseInt(velocityField.getText());
				velocityField.setForeground(Color.BLACK);
			} catch (NumberFormatException numberFormatException) {
				velocityField.setForeground(Color.RED);
				return false;
			}
			
			
			if(velocity < 0 || velocity > 3) {
				velocityField.setForeground(Color.RED);
				return false;
			}else {
				velocityField.setForeground(Color.BLACK);
			}
			
			if(addressField.getText().contains(":")) {
				server = new Server(numberLines,numberColumns,velocity,addressField.getText(),serverText);
				addressField.setForeground(Color.BLACK);;
			}else {
//				address = Integer.parseInt(addressField.getText());
//				server = new Server(numberLines,numberColumns,address,velocity,serverText);
				
				addressField.setForeground(Color.RED);
//				velocityField.setSelectedTextColor(Color.red);
				
				return false;
			}
			
//			System.out.println("Validate input: address -> " + inetAddress);
//			System.out.println("Validate input: velocity -> " + address);
			this.repaint();
//			stop.setEnabled(false);
			return true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		GUI gui = new GUI();
	}

}
