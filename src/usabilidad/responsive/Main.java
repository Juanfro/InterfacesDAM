package usabilidad.responsive;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class Main extends JFrame {
	public Main() {
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Decoration example");
		setSize(400, 400);
		
		Object[] options = { "COLOR_CHOOSER_DIALOG", "ERROR_DIALOG", "FILE_CHOOSER_DIALOG", "FRAME",
				"INFORMATION_DIALOG", "NONE", "PLAIN_DIALOG", "QUESTION_DIALOG", "WARNING_DIALOG" };
		final JComboBox combobox = new JComboBox(options);
		combobox.setSelectedItem("FRAME");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(combobox);

		combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String selected = (String) combobox.getSelectedItem();
				if (selected.equals("COLOR_CHOOSER_DIALOG"))
					setDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
				else if (selected.equals("ERROR_DIALOG"))
					setDecorationStyle(JRootPane.ERROR_DIALOG);
				else if (selected.equals("FILE_CHOOSER_DIALOG"))
					setDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
				else if (selected.equals("FRAME"))
					setDecorationStyle(JRootPane.FRAME);
				else if (selected.equals("INFORMATION_DIALOG"))
					setDecorationStyle(JRootPane.INFORMATION_DIALOG);
				else if (selected.equals("NONE"))
					setDecorationStyle(JRootPane.NONE);
				else if (selected.equals("PLAIN_DIALOG"))
					setDecorationStyle(JRootPane.PLAIN_DIALOG);
				else if (selected.equals("QUESTION_DIALOG"))
					setDecorationStyle(JRootPane.QUESTION_DIALOG);
				else if (selected.equals("WARNING_DIALOG"))
					setDecorationStyle(JRootPane.WARNING_DIALOG);
			}
		});
	}

	public void setDecorationStyle(int decorationStyle) {
		setVisible(false);
		getRootPane().setWindowDecorationStyle(decorationStyle);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}