package address.view;

import address.MainApp;
import address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.DateUtil;

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

		// Limpia detalles de person
		showPersonDetails(null);

		// Escucha cambios de seleccion y muestra los datos de person.
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
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

	/**
	 * Rellena todos los campos de texto para mostrar los detalles sobr la
	 * persona.<br>
	 * Si la persona especificada es null, todos los campos se liberan
	 * 
	 * @param person
	 */
	private void showPersonDetails(Person person) {
		if (person != null) {
			// Rellena los labels con información del objeto person
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			cityLabel.setText(person.getCity());
			birthdayLabel.setText(DateUtil.format(person.getBirthday()));

		} else {
			// Person es null. Borrar todo el texto
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");
		}
	}

	/**
	 * Llamado cuando el usuario hace click en el botón DELETE
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex > 0) {
			personTable.getItems().remove(selectedIndex);
			System.out.println("Borra");
		} else {
			// Nada seleccionado

			/*
			 * Dialogs.create() .title("No Selection") .masthead("No Person Selected")
			 * .message("Please select a person in the table.").showWarning();
			 */

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No selection");
			alert.setHeaderText("Header");
			alert.setContentText("Please select a person in the table");
			alert.showAndWait();

			System.out.println("no borra");

		}
		// personTable.getItems().remove(selectedIndex);
	}

	/**
	 * El usuario hace click en New. Abre un dialogo para editar detalles de una
	 * persona nueva.
	 */
	@FXML
	private void handleNewPerson() {
		Person tempPerson = new Person();
		boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		if (okClicked) {
			mainApp.getPersonData().add(tempPerson);
		}
	}

	/**
	 * El usuario hace click en EDIT. Abre un dialogo para editar detalles de una
	 * persona seleccionada.
	 */
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			/*
			 * Dialogs.create() .title("No Selection") .masthead("No Person Selected")
			 * .message("Please select a person in the table.") .showWarning();
			 */

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No hay seleccion");
			alert.setHeaderText("ERROR");
			alert.setContentText("Elige una persona en la tabla");
			alert.showAndWait();
		}
	}

}