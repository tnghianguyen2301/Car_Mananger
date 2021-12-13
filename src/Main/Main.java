package Main;

import java.awt.EventQueue;

import GUI.Login;
import GUI.Main_Interface;
import GUI.Mananger;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Interface frame = new Main_Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
