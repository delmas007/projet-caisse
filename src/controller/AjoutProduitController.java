package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.HistoriqueDao;
import Dao.IProduitDao;
import Dao.ProduitDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Produit;

public class AjoutProduitController implements Initializable {
	@FXML
	private Button accueil;
	@FXML
	private Button ajouter;
	@FXML
    private AnchorPane aj;
	@FXML
	private TextField nomP;
	@FXML
	private TextField prixP;
	@FXML
	private TextField codeP;
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
		aj.getScene().getWindow().hide();
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
	private Produit produit =  new Produit();
	
	
	int a = 0;
	public void ajouter(ActionEvent event) {
		String nom_produit = nomP.getText();
		String prix_p = prixP.getText();
		Integer prix_produit = Integer.valueOf(prix_p);
		String code_P = codeP.getText();
		Integer code_produit = Integer.valueOf(code_P);
		
		try {
			produit.setNomProduit(nom_produit);
			produit.setIdProduit(code_produit);
			produit.setPrixProduit(prix_produit);
			produitDao.saveProduit(produit);
			a++;
			if (a==1) {
				Parent root;
				Stage primaryStage = new Stage();
				aj.getScene().getWindow().hide();
				try {
					primaryStage.getIcons().add(new Image("application/spv.jpg"));
					primaryStage.setTitle("0 prix cassé");
					root=FXMLLoader.load(getClass().getResource("/application/AjoutProduit.fxml"));
					Scene scene = new Scene(root);
					primaryStage.setScene(scene);
					primaryStage.show();
					a--;
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ProduitDao pro= new ProduitDao();
		id.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
		prix.setCellValueFactory(new PropertyValueFactory<>("prixProduit"));
		table.getItems().setAll(pro.listProduit());
		
	}
	
	

}
