package darkestPackage;

import java.io.IOException;

import darkestPackage.darkestModel.Hero;
import darkestPackage.darkestModel.Hero.HeroClassEnum;
import darkestPackage.view.HeroEditController;
import darkestPackage.view.HeroOverViewController;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
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
		this.primaryStage.getIcons()
				.add(new Image("file:darkestFolder/darkestPackage/assets/darkest-dungeon-icon.png"));

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
			Image image = new Image("file:darkestFolder/darkestPackage/assets/Arrow.png");
			scene.setCursor(new ImageCursor(image));

			primaryStage.setScene(scene);

			// TODO Darle al controlador acceso a la aplicacion

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
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

	public static void main(String[] args) {

		launch(args);

	}
}
