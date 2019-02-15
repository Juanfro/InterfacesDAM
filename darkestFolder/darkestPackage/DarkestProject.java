package darkestPackage;

import java.io.IOException;

import darkestPackage.darkestModel.Hero;
import darkestPackage.darkestModel.Hero.HeroType;
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

public class DarkestProject extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Hero> heroData = FXCollections.observableArrayList();

	public DarkestProject() {
		heroData.add(new Hero("Dismas", HeroType.HIGHWAYMAN));
		heroData.add(new Hero("Reynauld", HeroType.CRUSADER));
		heroData.add(new Hero("Pepe", HeroType.BOUNTY_HUNTER));
		heroData.add(new Hero("Paco", HeroType.GRAVE_ROBBER));
		heroData.add(new Hero("Manolo", HeroType.CRUSADER));
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
			loader.setLocation(DarkestProject.class.getResource("darkestView/RootLayout.fxml"));
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
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DarkestProject.class.getResource("darkestView/HeroOverView.fxml"));

			AnchorPane heroOverview = loader.load();
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		launch(args);

	}
}
