package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PageDaccueilController implements Initializable {
	@FXML
	private Button accueil;
	@FXML
	private Button historique;
	@FXML
	private Button caisse;
	@FXML
	private Button ajouter;
	@FXML
	private Button modifier;
	@FXML
    private AnchorPane acc;
	
	@FXML
	void Facceuil (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		acc.getScene().getWindow().hide();
		try {
			primaryStage.getIcons().add(new Image("application/spv.jpg"));
			primaryStage.setTitle("0 prix cassé");
			root=FXMLLoader.load(getClass().getResource("/application/PageDaccueil.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	@FXML
	void Fcaisse(ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		acc.getScene().getWindow().hide();
		try {
			primaryStage.getIcons().add(new Image("application/spv.jpg"));
			primaryStage.setTitle("0 prix cassé");
			root=FXMLLoader.load(getClass().getResource("/application/Caisseprogram.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	@FXML
	void Fhistorique (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		acc.getScene().getWindow().hide();
		try {
			primaryStage.getIcons().add(new Image("application/spv.jpg"));
			primaryStage.setTitle("0 prix cassé");
			root=FXMLLoader.load(getClass().getResource("/application/Historique.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@FXML
	void Fajouter (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		acc.getScene().getWindow().hide();
		try {
			primaryStage.getIcons().add(new Image("application/spv.jpg"));
			primaryStage.setTitle("0 prix cassé");
			root=FXMLLoader.load(getClass().getResource("/application/AjoutProduit.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@FXML
	void Fmodifier (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		acc.getScene().getWindow().hide();
		try {
			primaryStage.getIcons().add(new Image("application/spv.jpg"));
			primaryStage.setTitle("0 prix cassé");
			root=FXMLLoader.load(getClass().getResource("/application/ModifProduit.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
