package usabilidad.examenUsabilidad;

import javax.swing.JFrame;

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
public class InicioSesion extends JFrame {
	public InicioSesion() {
		setLayout(new MigLayout("fillX"));
		setTitle("Inicio de Sesión");
		setBounds(0, 0, 500, 800);
		setLocationRelativeTo(null);
	}

	static InicioSesion miVentana = new InicioSesion();

	public static void main(String[] args) {

		miVentana.setVisible(true);

	}

	void Inicio() {

	}

}
