package usabilidad.examenUsabilidad;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873057743945066148L;

	MigLayout migLayout = new MigLayout("FillX");

	public Formulario() {
		setLayout(new MigLayout("fillX"));
		setTitle("Formulario de introducción de datos");
		setBounds(0, 0, 500, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	void init() {

		JTabbedPane tabs = new JTabbedPane();

		// Panel datos

		JPanel panelDatos = new JPanel(migLayout);

		JLabel labelNombre = new JLabel("Nombre");
		JLabel labelApellidos = new JLabel("Apellidos");
		JLabel labelDirección = new JLabel("Direccion");
		JLabel labelEstadoCivil = new JLabel("Direccion");

		JTextField campoNombre = new JTextField();
		JTextField campoApellidos = new JTextField();
		JTextField campoDireccion = new JTextField();

		String[] estados = new String[] { "Solter@", "casad@", "Viud@" };
		JComboBox<String> estadoCivil = new JComboBox<String>(estados);

		panelDatos.add(labelNombre);
		panelDatos.add(campoNombre, "wrap, growX, pushX");
		panelDatos.add(labelApellidos);
		panelDatos.add(campoApellidos, "growX");

		this.add(panelDatos, "growX, pushX, wrap");

		// Panel sexo

		// Panel resultados
	}

}
