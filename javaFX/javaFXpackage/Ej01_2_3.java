package javaFXpackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * 
 * <ul>
 * <li>Ej1. Desarrollar el programa "Hola Mundo" utilizando una interfaz gráfica
 * de usuario.</li>
 * <li>Ej2. Crear una ventana. Luego no permitir que el operador modifique el
 * tamaño de la ventana.</li>
 * <li>Ej3. Desarrollar una ventana que muestre el nombre de un programa en la
 * parte superior y su número de versión en la parte inferior. No permitir
 * modificar el tamaño de la ventana en tiempo de ejecución.</li>
 * 
 * </ul>
 * 
 * @author Juan Antonio Rodriguez
 *
 */

public class Ej01_2_3 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hola Mundo");
		BorderPane root = new BorderPane();
		Scene escena = new Scene(root, 300, 250);

		// Elementos
		Label nombre = new Label("Sistema de facturación");
		Label version = new Label("Versión 1.4");

		root.setTop(nombre);
		root.setBottom(version);

		root.setPadding(new Insets(10));

		primaryStage.setScene(escena);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

}
