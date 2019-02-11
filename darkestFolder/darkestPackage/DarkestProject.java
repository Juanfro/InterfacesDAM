package darkestPackage;

import darkestModel.Hero;
import darkestModel.Hero.HeroType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DarkestProject extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Hero> heroData = FXCollections.observableArrayList();

	public DarkestProject() {
		//heroData.add(new He)
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		launch(args);
		
	}
}
