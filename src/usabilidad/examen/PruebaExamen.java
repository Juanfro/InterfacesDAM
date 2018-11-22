package usabilidad.examen;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PruebaExamen extends JFrame {

	public PruebaExamen() {
		setLayout(new MigLayout("fillX", "", ""));
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#c2ba85"));
	}

	public static void main(String[] args) {

		PruebaExamen miVentana = new PruebaExamen();

		JLabel titulo = new JLabel("Este es el titulo");

		JLabel jLabel1 = new JLabel("Texto1");
		JLabel jLabel2 = new JLabel("Texto2");
		JLabel jLabel3 = new JLabel("Texto3");
		JLabel jLabel4 = new JLabel("Texto4");
		JLabel jLabel5 = new JLabel("Texto5");
		JLabel jLabel6 = new JLabel("Texto6");

		JTextField campoTexto1 = new JTextField();
		JTextField campoTexto2 = new JTextField();
		JTextField campoTexto3 = new JTextField();

		JComboBox<String> combo1 = new JComboBox<String>();
		JComboBox<String> combo2 = new JComboBox<String>();
		JComboBox<String> combo3 = new JComboBox<String>();

		JButton button1 = new JButton("Boton1");
		JButton button2 = new JButton("Boton2");
		JButton button3 = new JButton("Boton3");

		miVentana.add(titulo, "span, center");

		miVentana.add(jLabel1);
		miVentana.add(campoTexto1, "growX, pushX, wrap, span2");
		miVentana.add(jLabel2);
		miVentana.add(campoTexto2, "growX, wrap, span2");
		miVentana.add(jLabel3);
		miVentana.add(campoTexto3, "growX, wrap 15, span2");

		miVentana.add(jLabel4);
		miVentana.add(combo1, "growX, pushX, wrap, span2");

		miVentana.add(jLabel5);
		miVentana.add(combo2, "growX, pushX, wrap, span2");

		miVentana.add(jLabel6);
		miVentana.add(combo3, "growX, pushX, wrap 30, span2");

		miVentana.add(button1, "growX");
		miVentana.add(button2, "growX");
		miVentana.add(button3, "growX");

		miVentana.setVisible(true);

	}

}
