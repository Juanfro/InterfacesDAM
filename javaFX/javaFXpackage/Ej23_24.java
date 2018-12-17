package javaFXpackage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * 
 * <ol start="23">
 * <li>Disponer tres objetos de la clase JCheckBox con nombres de navegadores
 * web. Cuando se presione un botón mostrar en el título del JFrame los
 * programas seleccionados.</li>
 * <li>Desarrollar un programa que muestre 3 objetos de la clase JRadioButton
 * que permitan configurar el ancho y alto del JFrame.</li>
 * </ol>
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class Ej23_24 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Ejercicio 23");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 430);

		VBox ej23Pane = new VBox(20);
		ej23Pane.setPadding(new Insets(15));
		ej23Pane.setBorder(new Border(new BorderStroke(Color.CADETBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10),
				BorderWidths.DEFAULT, new Insets(20))));

		CheckBox chrome = new CheckBox("Chrome");
		CheckBox firefox = new CheckBox("Firefox");
		CheckBox opera = new CheckBox("Opera");

		Button bAceptar = new Button("Aceptar");
		bAceptar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String titulo = (chrome.isSelected() ? "Chrome " : "") + (firefox.isSelected() ? "Firefox " : "")
						+ (opera.isSelected() ? "Opera" : "");
				primaryStage.setTitle(titulo);
			}
		});

		ej23Pane.getChildren().addAll(chrome, firefox, opera, bAceptar);

		VBox ej24Pane = new VBox(20);

		ToggleGroup radioGroup = new ToggleGroup();

		RadioButton small = new RadioButton("Pequeño");
		RadioButton medium = new RadioButton("mediano");
		RadioButton big = new RadioButton("Grande");

		small.setToggleGroup(radioGroup);
		medium.setToggleGroup(radioGroup);
		big.setToggleGroup(radioGroup);

		radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

				if (radioGroup.getSelectedToggle() == small) {
					primaryStage.setWidth(150);
					primaryStage.setHeight(130);
				}

				if (radioGroup.getSelectedToggle() == medium) {
					primaryStage.setWidth(300);
					primaryStage.setHeight(250);
				}

				if (radioGroup.getSelectedToggle() == big) {
					primaryStage.setWidth(500);
					primaryStage.setHeight(400);
				}

			}
		});

		ej24Pane.getChildren().addAll(small, medium, big);
		ej24Pane.setPadding(new Insets(15));
		ej24Pane.setBorder(new Border(new BorderStroke(Color.INDIANRED, BorderStrokeStyle.SOLID, new CornerRadii(10),
				BorderWidths.DEFAULT, new Insets(20))));

		root.getChildren().addAll(ej23Pane, ej24Pane);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
