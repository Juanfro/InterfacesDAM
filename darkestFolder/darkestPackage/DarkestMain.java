package darkestPackage;

import java.io.IOException;

import darkestPackage.darkestModel.Hero;
import darkestPackage.darkestModel.Hero.HeroClassEnum;
import darkestPackage.darkestView.HeroOverViewController;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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

		this.primaryStage.getIcons().add(new Image("file:resources/images/darkest-dungeon-icon.png"));

		initRootLayout();
		showHeroOverView();

	}

	private void initRootLayout() {

		try {
			// Cargar root layout desde el fichero fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DarkestMain.class.getResource("darkestView/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostrar la escena que contiene rootlayout
			Scene scene = new Scene(rootLayout);
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
			loader.setLocation(DarkestMain.class.getResource("darkestView/HeroOverView.fxml"));

			AnchorPane heroOverview = loader.load();

			TabPane tabPane = (TabPane) rootLayout.getChildren().get(1);
			tabPane.getTabs().get(0).setContent(heroOverview);

			// Darle al controlador acceso a la aplicacion main
			HeroOverViewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		launch(args);

	}
}
