package usabilidad.filechooser;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class FilechooserAMano extends JFrame {

	public FilechooserAMano() {
		setLayout(new MigLayout("fillX"));
		setBounds(0, 0, 600, 380);
		setLocationRelativeTo(null);
		setTitle("Filechooser a mano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		FilechooserAMano miVentana = new FilechooserAMano();

		JFileChooser miFileChooser = new JFileChooser(".");
		// miFileChooser.setBounds(20, 20, 300, 400);
		miFileChooser.setVisible(true);	

		miVentana.add(miFileChooser, "growX");

		miVentana.setVisible(true);

	}

}
