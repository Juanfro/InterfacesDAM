package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ejemplo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hola Mundo");
		StackPane root = new StackPane();
		Scene escena = new Scene(root, 300, 250);
		Button btnHola = new Button();
		btnHola.setText("Hola");
		btnHola.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hola mundo");

			}
		});

		root.getChildren().add(btnHola);
		primaryStage.setScene(escena);
		primaryStage.show();
	}

	/*
	 * @Override public void init() throws Exception { // TODO Auto-generated method
	 * stub super.init(); }
	 */

}
