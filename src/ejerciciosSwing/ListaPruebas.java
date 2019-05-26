package ejerciciosSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListaPruebas extends JFrame {

	public ListaPruebas() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setTitle("Lista de pruebas");
	}

	static ListaPruebas miVentana = new ListaPruebas();
	static List<String> ficherosSeleccionados = new ArrayList<String>();
	static String rutaLista = "G:\\CarpetaListaPruebas\\Config\\testlist.json";

	public static void main(String[] args) {
		List<File> listado = listado();

		pintarCheckboxes(listado);

	}

	/**
	 * Devuelve una lista con los lanzadores de las pruebas: Archivos .cmd que
	 * comienzan con 3 numeros y guion bajo
	 * 
	 * @return
	 */
	private static List<File> listado() {
		String ruta = "G:\\CarpetaListaPruebas";

		List<File> listaFicheros = new ArrayList<File>();

		File carpeta = new File(ruta);
		File[] contenido = new File[carpeta.list().length];

		contenido = carpeta.listFiles();

		for (File file : contenido) {

			Pattern pattern = Pattern.compile("(\\d\\d\\d_)");
			Matcher matcher = pattern.matcher(file.getName());

			Boolean pasa = matcher.find();

			if (file.isFile() && pasa && file.getName().endsWith(".cmd")) {
				System.out.println(file.getName());
				listaFicheros.add(file);
			}

		}

		return listaFicheros;

	}

	private static void pintarCheckboxes(List<File> listado) {
		int y = 60;

		ActionListener checkboxListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox checkBox = (JCheckBox) e.getSource();
				if (checkBox.isSelected()) {
					ficherosSeleccionados.add(checkBox.getText());
				} else {
					ficherosSeleccionados.remove(checkBox.getText());
				}
			}
		};

		ActionListener buttonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				escribirListado();

			}
		};

		for (File file : listado) {

			JCheckBox checkBox = new JCheckBox(file.getName());
			checkBox.setVisible(true);
			checkBox.setBounds(20, y, 200, 30);
			checkBox.setSize(200, 20);
			checkBox.addActionListener(checkboxListener);
			miVentana.add(checkBox);
			y += 20;
		}

		JButton button = new JButton("Generar");
		button.setBounds(20, 20, 200, 30);
		button.addActionListener(buttonListener);
		button.setVisible(true);

		miVentana.add(button);

		miVentana.setVisible(true);

	}

	private static void escribirListado() {

		System.out.println("DEBUG: Boton Pulsado");

		try (BufferedWriter out = new BufferedWriter(new FileWriter(rutaLista));
				BufferedWriter outAppend = new BufferedWriter(new FileWriter(rutaLista, true))) {
			out.write("{\n");

			for (String string : ficherosSeleccionados) {
				System.out.println(string);
				outAppend.write("\"Testname\": " + string.substring(4) + ",\n" //
						+ "\"testfile\": " + string + ",\n" //
						+ "\"config\": C:\\rutaconfiguracion\n");
			}

			outAppend.write("}");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
