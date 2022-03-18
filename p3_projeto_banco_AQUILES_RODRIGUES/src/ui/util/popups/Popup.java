package ui.util.popups;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup {
	
	private JFrame popup;

	public Popup() {
		popup = new JFrame();
	}
	
	public void getAnyMessage(String msg) {
		JOptionPane.showMessageDialog(popup, msg);
	}

}
