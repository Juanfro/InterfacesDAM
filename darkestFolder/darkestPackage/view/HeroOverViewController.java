package darkestPackage.view;

import darkestPackage.DarkestMain;
import darkestPackage.darkestModel.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

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

	@FXML
	private Button button_dead;
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

		// Limpiar datos de Hero
		showHeroDetails(null);

		// Escuchar cambios en la selección y mostrar los datos del heroe al cambiar
		heroTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showHeroDetails(newValue));

		// Disable dead is no hero selected

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

	/**
	 * Rellena los campos para mostrar detalles sobre el heroe.<br>
	 * Si el heroe es null (no hay uno seleccionado) se limpian todos los campos
	 * 
	 * @param hero
	 */
	private void showHeroDetails(Hero hero) {
		if (hero != null) {
			// Rellenar los labels con la información del objeto Hero

			nameLabel.setText(hero.getHeroName());
			classLabel.setText(hero.getHeroClass());
			levelLabel.setText(Integer.toString(hero.getLevel()));
			armorLabel.setText(Integer.toString(hero.getArmorTier()));
			weaponLabel.setText(Integer.toString(hero.getWeaponTier()));

			// button_dead= new Button();
			int selectedIndex = heroTable.getSelectionModel().getSelectedIndex();

			button_dead.setDisable(false);
		} else {// Hero es null: Borrar todo
			nameLabel.setText("");
			classLabel.setText("");
			levelLabel.setText("");
			armorLabel.setText("");
			weaponLabel.setText("");

		}
	} // Show Hero Overview

	/**
	 * El usuario hace click en el boton "DEAD"
	 */
	@FXML
	private void handleHeroDeath() {
		int selectedIndex = heroTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			heroTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No selected hero");
			alert.setHeaderText("ERROR");
			alert.setContentText("Please select a hero in the table");
			alert.showAndWait();
		}

	}

	/**
	 * El usuario ha hecho click en "New". Abre una ventana de dialogo para editar
	 * los datos del nuvo heroe.
	 */
	@FXML
	private void handleNewHero() {
		Hero tempHero = new Hero();
		boolean okClicked = darkestMain.showHeroEditDialog(tempHero);
		if (okClicked) {
			darkestMain.getHeroData().add(tempHero);
		}

	}

	/**
	 * El usuario ha hecho click en "EDIT". Abre una ventana de dialogo para editar
	 * los datos del heroe seleccionado
	 */
	@FXML
	private void handleEditHero() {
		Hero selectedHero = heroTable.getSelectionModel().getSelectedItem();
		if (selectedHero != null) {
			boolean okClicked = darkestMain.showHeroEditDialog(selectedHero);
			if (okClicked) {
				showHeroDetails(selectedHero);
			}
		} else {
			// Nada seleccionado
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No selected hero");
			alert.setHeaderText("ERROR");
			alert.setContentText("Please select a hero in the table");
			alert.showAndWait();
		}
	}

}
