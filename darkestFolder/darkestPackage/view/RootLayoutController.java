package darkestPackage.view;

import java.io.File;

import darkestPackage.DarkestMain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/**
 * Controladaor para el layout Raiz.<br>
 * El layout raiz proporciona la funcionalidad basica de la aplicacion. <br>
 * Contiene una barra de menú y espacio donde los otros layout se mostrarán
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class RootLayoutController {
	// Referencia a la aplicación principal

	private DarkestMain darkestMain;

	/**
	 * Da a la aplicación principal una referencia a si misma
	 * 
	 * @param darkestMain Instancia de la aplicación principal
	 */
	public void setMainApp(DarkestMain darkestMain) {
		this.darkestMain = darkestMain;
	}

	/**
	 * Crea una lista de heroes vacia.
	 */
	@FXML
	private void handleNew() {
		darkestMain.getHeroData().clear();
		darkestMain.setHeroFilePath(null);
	}

	/**
	 * Abre un filechooser para elegir la lista de heroes a cargar
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Filtro paa la extensión del archivo
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Muestra el dialogo de guardar fichero
		File file = fileChooser.showOpenDialog(darkestMain.getPrimaryStage());

		if (file != null) {
			darkestMain.loadHeroDataFromFile(file);
		}
	}

	/**
	 * Guarda os datos en el fichero que está abierto en el momento.<br>
	 * Si no hay un fichero abierto aparece el dialogo "guardar como..."
	 */
	@FXML
	private void handleSave() {
		File heroFile = darkestMain.getHeroFilePath();
		if (heroFile != null) {
			darkestMain.saveHeroDataToFile(heroFile);
		} else {
			handleSaveAs();
		}
	}

	/**
	 * Abre un filechooser para que el usuario eliga el fichero al que guardar
	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Filtro para la extensión del archivo
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Mostrar dialogo de guardar fichero

		File file = fileChooser.showSaveDialog(darkestMain.getPrimaryStage());

		if (file != null) {
			// Asegurarse de que la extensión es correcta
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			darkestMain.saveHeroDataToFile(file);
		}

	}

	/**
	 * Abre la información sobre la aplicacion
	 */
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("Darkest Project");
		alert.setContentText("AUTOR: Juan Antonio Rodríguez\n CON LA COLABORACIÓN DE: StackOverflow y google");
		alert.showAndWait();
	}

	/**
	 * Cierra la Aplicación
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}

}
