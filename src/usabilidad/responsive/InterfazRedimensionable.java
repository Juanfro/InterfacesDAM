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
public class InterfazRedimensionable extends JFrame {

	public InterfazRedimensionable() {
		setLayout(new MigLayout("fillX"));
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Formulario");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// setBackground(Color.decode("#c2ba85"));
		getContentPane().setBackground(Color.decode("#c2ba85"));
	}

	public static void main(String[] args) {
		InterfazRedimensionable miVentana = new InterfazRedimensionable();

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

		miVentana.add(tituloForm, "align center, wrap, span");
		// Añadir componentes al panel

		// JPanel panelPrincipal = new JPanel(new MigLayout("fillX"));//Funciona
		JPanel panelPrincipal = new JPanel(new MigLayout());

		panelPrincipal.setOpaque(false);

		panelPrincipal.add(pais);
		panelPrincipal.add(paises, "wrap, pushX, growX, span");
		panelPrincipal.add(formato);
		panelPrincipal.add(formatos, "wrap, growX");
		panelPrincipal.add(autor);
		panelPrincipal.add(campoAutor, "wrap, growX");
		panelPrincipal.add(titulo);
		panelPrincipal.add(campoTitulo, "wrap, growX");
		panelPrincipal.add(isbn);
		panelPrincipal.add(campoisbn, "wrap, growX");
		panelPrincipal.add(clave);
		panelPrincipal.add(campoClave, "wrap, growX");

		miVentana.add(panelPrincipal, "span, growX");

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
		JComboBox<String> selectOrdenar = new JComboBox<>(ordenaciones);
		// END ELEMENTOS

		JPanel panelOpciones = new JPanel(new MigLayout()); // panelOpciones.setBackground(Color.YELLOW);
		panelOpciones.setOpaque(false);

		botonOpciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelOpciones.isVisible()) {
					panelOpciones.setVisible(false);

					System.out.println("Ocultar");
				} else if (!panelOpciones.isVisible()) {
					panelOpciones.setVisible(true);
					System.out.println("Mostrar");
				}
			}
		});

		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setBackground(Color.decode("#56320c"));
		botonBuscar.setForeground(Color.WHITE);

		miVentana.add(botonOpciones, "align center, wrap, span");

		// Añadir elementos
		panelOpciones.add(publicacion);
		panelOpciones.add(campoPublicacion, "wrap, pushX, growX");
		panelOpciones.add(condicion);
		panelOpciones.add(selectCondicion, "wrap, growX");
		panelOpciones.add(tapa);
		panelOpciones.add(selectTapa, "wrap, growX");
		panelOpciones.add(ordenar);
		panelOpciones.add(selectOrdenar, "wrap, growX");

		panelOpciones.setVisible(false);
		miVentana.add(panelOpciones, "span, growX");
		miVentana.add(botonBuscar, "align center, wrap, span");

		miVentana.setVisible(true);

	}

}
