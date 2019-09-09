package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new
		FXMLLoader(getClass().getResource("app.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar= createMenu();

		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}

	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenu= new MenuItem("New");
		SeparatorMenuItem newSep= new SeparatorMenuItem();
		MenuItem quitMenu= new MenuItem("Quit");
		fileMenu.getItems().addAll(newMenu,newSep,quitMenu);

		newMenu.setOnAction(event -> System.out.println("Clicked"));

		quitMenu.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		//Help Menu
		Menu helpMenu= new Menu("Help");
		MenuItem aboutMenu= new MenuItem("About");
		helpMenu.getItems().addAll(aboutMenu);

		aboutMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				aboutApp();
			}

			private void aboutApp() {
				//TODO
				Alert alertDiag= new Alert(Alert.AlertType.INFORMATION);
				alertDiag.setTitle("First Biatch");
				alertDiag.setHeaderText("Header");
				alertDiag.setContentText("Wassup gamers");
				alertDiag.show();
			}
		});

		MenuBar menuBar= new MenuBar();

		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}
}
