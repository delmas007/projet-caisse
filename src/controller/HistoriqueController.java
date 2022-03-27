package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import Dao.HistoriqueDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Recu;

public class HistoriqueController implements Initializable{
	 @FXML
	    private TextField Date;

	    @FXML
	    private TextField Produit;

	    @FXML
	    private Button accueil;

	    @FXML
	    private Button entrer;

	    @FXML
	    private AnchorPane his;

	    @FXML
	    private TextField monnaie;

	    @FXML
	    private TextField montant;

	    @FXML
	    private TextField nu;

	    @FXML
	    private TextField total;
	    @FXML
	    private ComboBox<Integer> list;
	    

	
	@FXML
	void Facceuil (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		his.getScene().getWindow().hide();
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
	void entrer(ActionEvent event) {
		HistoriqueDao recu = new HistoriqueDao();
		int Id = list.getValue();
		int id =recu.getRecuById(Id).getNumRecu();
		String idS = String.valueOf(id);
		int monnai =recu.getRecuById(Id).getMonnaie();
		String mo = String.valueOf(monnai);
		int montan =recu.getRecuById(Id).getMontant();
		String motans = String.valueOf(montan);
		int tota =recu.getRecuById(Id).getSomTotal();
		String totas = String.valueOf(tota);
		Date dat =recu.getRecuById(Id).getDate();
		String dats = String.valueOf(dat);
		nu.setText(idS);
		monnaie.setText(mo);
		montant.setText(motans);
		total.setText(totas);
		Date.setText(dats);
		Produit.setText(recu.getRecuById(Id).getProduit());
		
		
	}
	
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		HistoriqueDao historique = new HistoriqueDao();
		for (Recu id : historique.listIdRecus()) {
			list.getItems().addAll(FXCollections.observableArrayList(id.getNumRecu()));			
		}
		
		
	}

}
