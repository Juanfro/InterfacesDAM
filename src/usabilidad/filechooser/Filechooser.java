package usabilidad.filechooser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;

public class Filechooser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filechooser window = new Filechooser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Filechooser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFileChooser fileChooser = new JFileChooser();
		frame.getContentPane().add(fileChooser, BorderLayout.CENTER);
	}

}
