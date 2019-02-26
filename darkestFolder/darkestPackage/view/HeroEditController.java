package darkestPackage.view;

import darkestPackage.darkestModel.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Dialogo para editar los datos de un heroe
 * 
 * @author Juan Antonio Rodríguez
 *
 */

public class HeroEditController {

	@FXML
	private TextField heroNameField;
	@FXML
	private ComboBox<String> classComboBox;
	@FXML
	private ComboBox<String> levelComboBox;
	@FXML
	private ComboBox<String> armorComboBox;
	@FXML
	private ComboBox<String> weaponComboBox;

	private Stage dialogStage;
	private Hero hero;
	private boolean okClicked;

	@FXML
	private void initialize() {
		// Añadir contenido a ComboBox

		// Clase
		classComboBox.getItems().removeAll(classComboBox.getItems());// Limpiar el ComboBox
		classComboBox.getItems().addAll("ABOMINATION", "ANTIQUARIAN", "ARBALEST", "BOUNTY HUNTER", "CRUSADER",
				"GRAVE_ROBBER", "HELLION", "HIGHWAYMAN", "HOUNDMASTER", "JESTER", "LEPER", "MAN AT ARMS", "OCCULTIST",
				"PLAGUE DOCTOR", "VESTAL");// Añadir items

		// Nivel
		levelComboBox.getItems().removeAll(levelComboBox.getItems());// Limpiar el ComboBox
		levelComboBox.getItems().addAll("1", "2", "3", "4", "5", "6");// Añadir items

		// Armadura
		armorComboBox.getItems().removeAll(armorComboBox.getItems());// Limpiar el ComboBox
		armorComboBox.getItems().addAll("1", "2", "3", "4", "5");// Añadir items

		// Arma
		weaponComboBox.getItems().removeAll(weaponComboBox.getItems());// Limpiar el ComboBox
		weaponComboBox.getItems().addAll("1", "2", "3", "4", "5");// Añadir items

	}

	/**
	 * Applica el stage del dialogo
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setHero(Hero hero) {
		this.hero = hero;

		heroNameField.setText(hero.getHeroName());
		classComboBox.getSelectionModel().select(hero.getHeroClass());
		levelComboBox.getSelectionModel().select(hero.getLevel());
		armorComboBox.getSelectionModel().select(hero.getArmorTier());
		weaponComboBox.getSelectionModel().select(hero.getWeaponTier());

	}

	/**
	 * 
	 * 
	 * @return true si el usuario hace click en OK, false si no.
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cuando se hace click en ok
	 */
	@FXML
	private void handleOK() {
		if (isInputValid()) {
			hero.setHeroName(heroNameField.getText());
			hero.setHeroClass(classComboBox.getSelectionModel().getSelectedItem());
			hero.setLevel(Integer.parseInt(levelComboBox.getSelectionModel().getSelectedItem()));
			hero.setArmorTier(Integer.parseInt(armorComboBox.getSelectionModel().getSelectedItem()));
			hero.setWeaponTier(Integer.parseInt(weaponComboBox.getSelectionModel().getSelectedItem()));

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Validar los inputs
	 * 
	 * @return True si los inputs son válidos
	 */
	private boolean isInputValid() {
		boolean valida;

		String errorMessage = "";

		// Comprobaciones
		if (heroNameField.getText() == null || heroNameField.getText().length() == 0) {
			errorMessage += "Invalid Name!\n";
		}

		if (classComboBox.getSelectionModel().getSelectedItem() == null
				|| classComboBox.getSelectionModel().getSelectedItem().length() == 0) {
			errorMessage += "Invalid Class!\n";
		}

		if (levelComboBox.getSelectionModel().getSelectedItem() == null
				|| levelComboBox.getSelectionModel().getSelectedItem().length() == 0) {
			errorMessage += "Invalid Level!\n";
		}

		if (armorComboBox.getSelectionModel().getSelectedItem() == null
				|| armorComboBox.getSelectionModel().getSelectedItem().length() == 0) {
			errorMessage += "Invalid Armor Tier!\n";
		}

		if (weaponComboBox.getSelectionModel().getSelectedItem() == null
				|| weaponComboBox.getSelectionModel().getSelectedItem().length() == 0) {
			errorMessage += "Invalid Weapon Tier!\n";
		}

		if (errorMessage.length() == 0) {
			valida = true;
		} else {// Mostrar mensaje de error
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos no Válidos");
			alert.setHeaderText("Error");
			alert.setContentText("Please correct invalid fields");
			alert.showAndWait();
		}

		return false;
	}

}
