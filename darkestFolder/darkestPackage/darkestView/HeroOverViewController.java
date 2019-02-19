package darkestPackage.darkestView;

import darkestPackage.DarkestMain;
import darkestPackage.darkestModel.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HeroOverViewController {

	// Contenido de la lista (izquierda)
	@FXML
	private TableView<Hero> heroTable;
	@FXML
	private TableColumn<Hero, String> heroNameColumn;
	@FXML
	private TableColumn<Hero, String> heroClassColumn;

	// Contenido de la tabla de datos(derecha)
	@FXML
	private Label nameLabel;
	@FXML
	private Label classLabel;
	@FXML
	private Label levelLabel;
	@FXML
	private Label armorLabel;
	@FXML
	private Label weaponLabel;

	// Referencia a la aplicacion main
	private DarkestMain darkestMain;

	/**
	 * Constructor vacío
	 */
	public HeroOverViewController() {
	}

	/**
	 * Inicializa la clase controller. Este método es llamado automáticamente cuando
	 * se carga el archivo fxml
	 */
	@FXML
	private void initialize() {
		// Inicializa hero table con sus dos columnas
		heroNameColumn.setCellValueFactory(CellData -> CellData.getValue().heroNameProperty());
		heroClassColumn.setCellValueFactory(CellData -> CellData.getValue().heroClassProperty());
	}

	/**
	 * Se llama a este método desde la aplicacion main para que deuelva una
	 * referencia a si misma
	 * 
	 * @param darkestMain
	 */
	public void setMainApp(DarkestMain darkestMain) {
		this.darkestMain = darkestMain;

		// Añadir lista con los datos a la tabla
		heroTable.setItems(darkestMain.getHeroData());

	}

}
