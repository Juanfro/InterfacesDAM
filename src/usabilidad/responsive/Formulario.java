package usabilidad.responsive;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Formulario extends JFrame {

	public Formulario() {
		setLayout(new MigLayout("fillX"));
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Formulario");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.decode("#c2ba85"));
		getContentPane().setBackground(Color.decode("#c2ba85"));
	}

	public static void main(String[] args) {
		Formulario miVentana = new Formulario();

		// JPanel miPanel = new JPanel();
		// miPanel.setBounds(20, 20, 300, 400);
		// miPanel.setBackground(Color.BLUE);

		// Componentes

		JLabel tituloForm = new JLabel("Busca libros por autor, titulo, ISBN y palabra clave");
		tituloForm.setBackground(Color.decode("#56320c"));
		tituloForm.setForeground(Color.white);
		tituloForm.setOpaque(true);

		JLabel pais = new JLabel("Pais");
		JLabel formato = new JLabel("Selecciona formato");
		JLabel autor = new JLabel("Autor");
		JLabel titulo = new JLabel("Título");
		JLabel isbn = new JLabel("ISBN");
		JLabel clave = new JLabel("Palabra Clave");

		String[] countries = { "España", "Ejpaña", "Spain", "Jpain" };
		JComboBox<String> paises = new JComboBox<String>(countries);
		String[] formatosOpciones = { "Impresos", "E-books" };
		JComboBox<String> formatos = new JComboBox<String>(formatosOpciones);

		JTextField campoAutor = new JTextField();
		campoAutor.setBackground(Color.decode("#eff0da"));
		JTextField campoTitulo = new JTextField();
		campoTitulo.setBackground(Color.decode("#eff0da"));
		JTextField campoisbn = new JTextField();
		campoisbn.setBackground(Color.decode("#eff0da"));
		JTextField campoClave = new JTextField();
		campoClave.setBackground(Color.decode("#eff0da"));

		// Añadir componentes al panel

		miVentana.add(tituloForm, "align center,   wrap, span");
		miVentana.add(pais);
		miVentana.add(paises, "wrap, growX");
		miVentana.add(formato);
		miVentana.add(formatos, "wrap, growX");
		miVentana.add(autor);
		miVentana.add(campoAutor, "wrap, growX");
		miVentana.add(titulo);
		miVentana.add(campoTitulo, "wrap, growX");
		miVentana.add(isbn);
		miVentana.add(campoisbn, "wrap, growX");
		miVentana.add(clave);
		miVentana.add(campoClave, "wrap, growX");

		// Botones

		JButton botonOpciones = new JButton("más opciones");
		botonOpciones.setBackground(Color.decode("#56320c"));
		botonOpciones.setForeground(Color.WHITE);

		// Más opciones

		// ELEMENTOS
		JLabel publicacion = new JLabel("Año de publicación");
		JLabel condicion = new JLabel("Condicion");
		JLabel tapa = new JLabel("Tapa blanda o dura");
		JLabel ordenar = new JLabel("Ordenar por");

		JTextField campoPublicacion = new JTextField();
		String[] condiciones = { "Nuevo", "Usado", "Sellado" };
		JComboBox<String> selectCondicion = new JComboBox<String>(condiciones);

		String[] tapas = { "Dura", "Blanda" };
		JComboBox<String> selectTapa = new JComboBox<>(tapas);

		String[] ordenaciones = { "Opiniones", "Precio" };
		JComboBox<String> selectOrcenar = new JComboBox<>(ordenaciones);
		// END ELEMENTOS

		JPanel panelOpciones = new JPanel(new MigLayout("fillX"));
		panelOpciones.setBackground(Color.YELLOW);
		// Añadir elementos
		panelOpciones.add(publicacion);
		panelOpciones.add(campoPublicacion, "wrap, growX, span 2");
		panelOpciones.add(condicion);
		panelOpciones.add(selectCondicion, "wrap, growX");

		panelOpciones.setVisible(false);
		miVentana.add(panelOpciones, "wrap, growX");

		botonOpciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelOpciones.isVisible()) {
					panelOpciones.setVisible(false);
					System.out.println("Ocultar");
				} else if (!panelOpciones.isVisible()) {
					panelOpciones.setVisible(true);

				}

			}
		});

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setBackground(Color.decode("#56320c"));
		botonBuscar.setForeground(Color.WHITE);

		miVentana.add(botonOpciones, "align center, wrap, span");
		miVentana.add(botonBuscar, "align center, wrap, span");

		miVentana.setVisible(true);

	}

}
