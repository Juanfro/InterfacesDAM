package javaFXpackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Permitir introducir dos números en controles de tipo JTextField y mediante
 * dos controles de tipo JRadioButton permitir seleccionar si queremos sumarlos
 * o restarlos. Al presionar un botón mostrar en el título del JFrame el
 * resultado de la operación.
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class Ej25 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 25");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		TextField num1 = new TextField();
		// num1.setText("0");
		TextField num2 = new TextField();
		// num2.setText("0");

		ToggleGroup grupoRadio = new ToggleGroup();

		RadioButton sumar = new RadioButton("Sumar");
		sumar.setToggleGroup(grupoRadio);
		sumar.setSelected(true);
		RadioButton restar = new RadioButton("Restar");
		restar.setToggleGroup(grupoRadio);

		Button bOperar = new Button("Operar");

		bOperar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				int value1 = Integer.parseInt(num1.getText());
				int value2 = Integer.parseInt(num2.getText());
				int valSuma = value1 + value2;
				int valResta = value1 - value2;

				if (grupoRadio.getSelectedToggle() == sumar) {
					primaryStage.setTitle(Integer.toString(valSuma));

				}

				if (grupoRadio.getSelectedToggle() == restar) {
					primaryStage.setTitle(Integer.toString(valResta));
				}

			}
		});

		root.getChildren().addAll(num1, num2, sumar, restar, bOperar);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
