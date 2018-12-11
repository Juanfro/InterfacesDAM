package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <ol start ="11">
 * <li>Desarrollar un programa que permita introducir una dirección de mail en
 * un control de tipo JTextField y el cuerpo del mail en un control de tipo
 * JTextArea.</li>
 * <li>Desarrollar un programa que permita introducir una dirección de mail en
 * un control de tipo JTextField y el cuerpo del mail en un control de tipo
 * JTextArea.</li>
 * 
 * <li>Desarrollar un programa que permita introducir en un control de tipo
 * JTextArea una carta. Luego al presionar un botón mostrar un mensaje si la
 * carta contiene el String "argentina"</li>
 * </ol>
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Ej11_12_13 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicios 10, 11 y 12");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		FlowPane emailPane = new FlowPane();
		emailPane.setHgap(20);
		// emailPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,
		// CornerRadii.EMPTY, Insets.EMPTY)));

		Label lEmail = new Label("Email:");
		TextField campoEmail = new TextField();
		campoEmail.setPromptText("Escribe aquí el email destinatario");
		campoEmail.setPrefWidth(200);
		campoEmail.setAlignment(Pos.CENTER_RIGHT);

		emailPane.getChildren().addAll(lEmail, campoEmail);

		// Contenido
		Label lContenido = new Label("Contenido:");
		TextArea campoContenido = new TextArea();
		campoContenido.setPromptText("Escribe aquí el contenido del email");

		Button bBuscar = new Button("Buscar Argentina");
		bBuscar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String palabra = "Argentina";
				String contenido = campoContenido.getText();

				int indice = contenido.indexOf(palabra);
				String regex = "\\bArgentina\\b";

				if (indice != -1) {
					Alert alert = new Alert(AlertType.INFORMATION, "Palabra encontrada", ButtonType.OK);
					alert.showAndWait();

				} else {
					Alert alert = new Alert(AlertType.ERROR, "Palabra no encontrada", ButtonType.OK);
					alert.showAndWait();
				}

			}
		});

		root.getChildren().addAll(emailPane, lContenido, campoContenido, bBuscar);

		primaryStage.setScene(escena);
		primaryStage.show();

		root.requestFocus();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
