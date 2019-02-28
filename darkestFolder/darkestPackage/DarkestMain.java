package darkestPackage;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import darkestPackage.darkestModel.Hero;
import darkestPackage.darkestModel.Hero.HeroClassEnum;
import darkestPackage.darkestModel.HeroListWrapper;
import darkestPackage.view.HeroEditController;
import darkestPackage.view.HeroOverViewController;
import darkestPackage.view.RootLayoutController;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DarkestMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Hero> heroData = FXCollections.observableArrayList();

	public DarkestMain() {
		heroData.add(new Hero("Dismas", "HIGHWAYMAN"));
		heroData.add(new Hero("Reynauld", "CRUSADER"));
		heroData.add(new Hero("Pepe", "BOUNTY HUNTER"));
		heroData.add(new Hero("Paco", "GRAVE ROBBER"));
		heroData.add(new Hero("Manolo", "CRUSADER"));
	}

	/**
	 * Devuelve los datos como una ObservableList objetos Hero
	 * 
	 * @return
	 */
	public ObservableList<Hero> getHeroData() {
		return heroData;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Darkest Dungeon");

		// this.primaryStage.getIcons().add(new
		// Image("file:resources/images/darkest-dungeon-icon.png"));
		// this.primaryStage.getIcons().add(new
		// Image("file:darkestFolder/darkestPackage/assets/darkest-dungeon-icon.png"));
		// this.primaryStage.getIcons().add(new
		// Image("file:darkestFolder/darkestPackage/assets/darkest-dungeon-icon.png"));
		this.primaryStage.getIcons()
				.add(new Image(this.getClass().getResourceAsStream("images/darkest-dungeon-icon.png")));

		initRootLayout();
		showHeroOverView();

	}

	private void initRootLayout() {

		try {
			// Cargar root layout desde el fichero fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DarkestMain.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostrar la escena que contiene rootlayout
			Scene scene = new Scene(rootLayout);

			// Cursor
			Image image = new Image(this.getClass().getResourceAsStream("images/Arrow.png"));

			scene.setCursor(new ImageCursor(image));

			primaryStage.setScene(scene);

			// Darle al controlador acceso a la aplicacion
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to load last opened person file.
		File file = getHeroFilePath();
		if (file != null) {
			loadHeroDataFromFile(file);
		}

	}

	private void showHeroOverView() {
		// Cargar heroOverView
		try {

			// Cargar la vista heroOverview en una pestaña de la vista raiz
			FXMLLoader loader = new FXMLLoader();
			// loader.setLocation(DarkestMain.class.getResource("darkestView/HeroOverView.fxml"));

			loader.setLocation(DarkestMain.class.getResource("view/HeroOverview.fxml"));

			AnchorPane heroOverview = loader.load();

			TabPane tabPane = (TabPane) rootLayout.getChildren().get(1);
			tabPane.getTabs().get(0).setContent(heroOverview);

			// Darle al controlador acceso a la aplicacion main
			HeroOverViewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre el dialogo para editar los datos de un heroe. Si el usuario hace click
	 * en OK, los cambios se guardan en el objeto "Heroe" asignado y se devuelve
	 * true.
	 * 
	 * @param hero
	 * @return
	 */
	public boolean showHeroEditDialog(Hero hero) {
		/**
		 * resultado
		 */
		boolean res;
		try {
			// Cargar el fichero fxml y crear un nuevo stage para el dialogo
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DarkestMain.class.getResource("view/HeroEdit.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Crear el stage del dialogo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Hero");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Asignar al heroe en el controlador
			HeroEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHero(hero);

			// Mostrar el dialogo y esperar a que el usuario lo cierre
			dialogStage.showAndWait();

			res = controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			res = false;
		}

		return res;
	}

	/**
	 * El último fichero que fué abiert.<br>
	 * Preference se lee desde un registro en el sistema operativo. Si no se
	 * encuenta devuelve null
	 * 
	 * @return El fichero preference del Heroe. Si no se encuenta devuelve null
	 */
	public File getHeroFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(DarkestMain.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	} // getHeroFilePath

	/**
	 * Determina el path del fichero que hay cargado actualmente en memoria. <br>
	 * El path está guardado en el registro del sistema operativo
	 * 
	 * @param file El fichero o null para borrar la ruta
	 */
	public void setHeroFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(DarkestMain.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Actualizar el titulo de stage
			primaryStage.setTitle("Darkest - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Actualizar el titulo de stage
			primaryStage.setTitle("Darkest");
		}
	}// setHeroFilePath

	/**
	 * Carga los datos de Heroe al fichero especificado. Los datos anteriores son
	 * reemplazados
	 * 
	 * @param file Fichero al que se guardan los datos
	 */
	public void loadHeroDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(HeroListWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// Leer el XML de "file" y hacer unmarshall
			HeroListWrapper wrapper = (HeroListWrapper) unmarshaller.unmarshal(file);

			heroData.clear();
			heroData.addAll(wrapper.getHeroes());

			// Guardar el path en el registro
			setHeroFilePath(file);
		} catch (Exception e) { // Si hay algún error
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("ERROR");
			alert.setContentText(
					"En algún lugar algo ha ido mal. \nNo se han podido cargar datos del fichero:\n" + file.getPath());
			alert.showAndWait();

			e.printStackTrace();
		}
	}

	/**
	 * Guarda los datos actuales de Heroe
	 * 
	 * @param file Fichero dodne se guardan los datos
	 */
	public void saveHeroDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(HeroListWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Envolver los datos de Heroe
			HeroListWrapper wrapper = new HeroListWrapper();
			wrapper.setHeroes(heroData);

			// Hacer Marshall y guardar en e fichero con formato XML
			marshaller.marshal(wrapper, file);

			// Guardar el path del fichero en el registro
			setHeroFilePath(file);

		} catch (Exception e) {// Si hay algún error
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("ERROR");
			alert.setContentText(
					"En algún lugar algo ha ido mal. \nNo se han podido guardar datos al fichero:\n" + file.getPath());
			alert.showAndWait();

			e.printStackTrace();
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve main Stage
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {

		launch(args);

	}
}
