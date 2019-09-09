package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public javafx.scene.control.Label welcomeLabel;
	@FXML
	public javafx.scene.control.ChoiceBox<String> choiceBox;
	@FXML
	public javafx.scene.control.Button convertButton;
	@FXML
	public javafx.scene.control.TextField textField;

	public static final String C_F="C to F";
	public static final String F_C="F to C";

	public boolean isCtoF=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Choice Box Controller

		choiceBox.getItems().add(C_F);
		choiceBox.getItems().add(F_C);
		choiceBox.setValue(C_F);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.equals(F_C)) {
						isCtoF = false;
					} else {
						isCtoF = true;
					}
				});
		//Button Controller
		convertButton.setOnAction(event -> {

			System.out.println("Click");
			convert();
		});


	}

	private void convert() {
		String input=textField.getText();
		float enteredTemp=Float.parseFloat(input);

		float newTemp;
		if(isCtoF)
		{
			newTemp= (enteredTemp*9/5)+32;
		}
		else
		{
			newTemp=(enteredTemp-32)*5/9;
		}

		display(newTemp,isCtoF);
	}

	private void display(float newTemp, boolean isCtoF) {

		System.out.println(newTemp);
		// STOPSHIP: 2019-
		String unit;
		if(isCtoF)
		{
			unit="F";
		}
		else
		{
			unit="C";
		}
		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("Temp is:" + newTemp + unit);
		alert.show();
	}
}
