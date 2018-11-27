package usabilidad.examenUsabilidad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * Ventana inicial solicitando usuario y contraseña. Si el usuario es
 * "Desarrollo" y la contraseña es "Interfaz", accederá a una nueva ventana con
 * título "Formulario de introducción de datos", en la que aparecerán dos
 * pestañas ("Personas", y "Empresas")
 * 
 * @author Juan Antonio Rodriguez
 *
 */
@SuppressWarnings("serial")
public class InicioSesion extends JFrame implements ActionListener {

	JTextField usuario;
	JPasswordField pwd;
	Formulario vFormulario;

	public InicioSesion() {
		setLayout(new MigLayout("fillX"));
		setTitle("Inicio de Sesión");
		setBounds(0, 0, 300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	static InicioSesion miVentana = new InicioSesion();

	public static void main(String[] args) {

		miVentana.Inicio();
		miVentana.setVisible(true);

	}

	void Inicio() {

		// JPanel panelInicio = new JPanel(miLayout);
		// panelInicio.setBackground(Color.lightGray);

		JLabel lUsuario = new JLabel("Usuario");
		JLabel lPwd = new JLabel("Contraseña");

		usuario = new JTextField();
		pwd = new JPasswordField();

		JButton btAceptar = new JButton("Aceptar");
		btAceptar.addActionListener(this);

		miVentana.add(lUsuario);
		miVentana.add(usuario, "wrap, growX, pushX");
		miVentana.add(lPwd);
		miVentana.add(pwd, "wrap, growX");
		miVentana.add(btAceptar, "span, center");

	}

	/*
	 * ActionListener evento = new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { String usuarioCorrecto
	 * = "Desarrollo"; String pwdCorrecta = "interfaz";
	 * 
	 * String textoUsuario = usuario.getText(); String textoPwd = new
	 * String(pwd.getPassword());
	 * 
	 * boolean usuarioOk = (textoUsuario.equals(usuarioCorrecto)); boolean pwdOk =
	 * (textoPwd.equals(pwdCorrecta));
	 * 
	 * if (usuarioOk && pwdOk) { System.out.println("Pasa"); }else {
	 * System.out.println("No pasa"); } } };
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String usuarioCorrecto = "123";
		String pwdCorrecta = "123";

		String textoUsuario = usuario.getText();
		String textoPwd = new String(pwd.getPassword());

		boolean usuarioOk = (textoUsuario.equals(usuarioCorrecto));
		boolean pwdOk = (textoPwd.equals(pwdCorrecta));

		if (usuarioOk && pwdOk) {
			System.out.println("Pasa");
			abrirFormulario();
			miVentana.dispose();

		} else {
			System.out.println("No pasa");

			JOptionPane.showMessageDialog(miVentana, "Datos incorrectos", "Error de login", JOptionPane.ERROR_MESSAGE);

			usuario.setText("");
			pwd.setText("");
		}
	}

	void abrirFormulario() {
		vFormulario = new Formulario();

		vFormulario.init();

		vFormulario.setVisible(true);
	}

}
