package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.HistoriqueDao;
import Dao.IProduitDao;
import Dao.ProduitDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Produit;

public class ModifProduitController implements Initializable {
	@FXML
	private Button accueil;
	@FXML
	private Button supprimer;
	@FXML
    private AnchorPane mod;
	@FXML
	private ComboBox<Integer> article;
	@FXML
	private TableView<Produit> table;
	@FXML
	private TableColumn<Produit, Integer> id;
	@FXML
	private TableColumn<Produit, String> nom;
	@FXML
	private TableColumn<Produit, Integer> prix;
	
	@FXML
	void Facceuil (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		mod.getScene().getWindow().hide();
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
	
	private IProduitDao produitDao = new ProduitDao();
	
	public void supprimer(ActionEvent event) {
		Integer idProduit = article.getValue();
		produitDao.supprimerProduit(Integer.valueOf(idProduit));
		initialize(null, null);
		Parent root;
		Stage primaryStage = new Stage();
		mod.getScene().getWindow().hide();
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
		ProduitDao pro = new ProduitDao();
		ProduitDao art = new ProduitDao();
		id.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		prix.setCellValueFactory(new PropertyValueFactory<>("prixProduit"));
		table.getItems().setAll(pro.listProduit());
		for (Produit id : art.listProduit()) {
			article.getItems().addAll(FXCollections.observableArrayList(id.getIdProduit()));			
		}
		
	}

}
