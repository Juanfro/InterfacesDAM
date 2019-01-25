package address.view;

import address.MainApp;
import address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {

	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	// referencia a la aplicación principal
	private MainApp mainApp;

	/**
	 * Constructor. Se llama al consrtuctor antes de initialize()
	 * 
	 * @see #initialize
	 */
	public PersonOverviewController() {
	}

	/**
	 * Inicializa la clase controller. Este método es llamado automáticamente
	 * despues de que se cargue el fichero fxml
	 */
	@FXML
	private void initialize() {
		// Inicializa la tabla de person con las dos columnas
		firstNameColumn.setCellValueFactory(CellData -> CellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(CellData -> CellData.getValue().lastNameProperty());
	}

	/**
	 * Lo llama la aplicación principal para dar una referencia a si misma
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Añadir datos de observable list a la tabla
		personTable.setItems(mainApp.getPersonData());
	}
}
