package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Dao.BonDao;
import Dao.CaisseDao;
import Dao.HistoriqueDao;
import Dao.IBonDao;
import Dao.ICaisseDao;
import Dao.IProduitDao;
import Dao.ProduitDao;
import Dao.RecuDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.BonReduction;
import model.Produit;
import model.Recu;
import net.bytebuddy.agent.builder.AgentBuilder.Ignored;

public class CaisseprogramController implements Initializable {
	@FXML
	private Button accueil;
	@FXML
	private Button plus;
	@FXML
	private Button moin;
	@FXML
	private Button imprimer;
	@FXML
	private TextField quan;
	@FXML
	private DatePicker date;
	@FXML
	private TextField codeArticle;
	@FXML
	private TextArea console;
	@FXML
    private AnchorPane cai;
	@FXML
	private ComboBox<Integer> article;
	@FXML
	private ComboBox<Integer> article1;
	@FXML
	private TextField montant;
	@FXML
	private TextField total;
	@FXML
	private TextField bon1;
	@FXML
	void Facceuil (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		cai.getScene().getWindow().hide();
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
	int P=0;
	private ICaisseDao rec = new CaisseDao();
	private Recu recu =  new Recu();
	private IBonDao rec2 = new BonDao();
	public void ajouter(ActionEvent event) {
		Integer c = article.getValue();
		Produit id  = rec.getProduitById(Integer.valueOf(c));
		String nom= id.getNomProduit();
		String q = quan.getText();
		Integer Q = Integer.valueOf(q);
		int pr = id.getPrixProduit();
		int prq = id.getPrixProduit()*Q;
		console.setText(""+System.getProperty("line.separator")+nom+"                 "+pr+" 				x"+Q+"			 ="+prq+console.getText());
		Integer c1 = article1.getValue();
		if (c1 != null ) {
			BonReduction id1  = rec2.getNimBonById(c1);
			int prixBon =id1.getPrixBon();
			bon1.setText(""+prixBon);
		}
		P=P+prq;
		total.setText(""+P);
		P=P;
		quan.setText("");
		article.setValue(null);
	}
	@FXML
	void imprimer (ActionEvent event) throws DocumentException, IOException,IllegalArgumentException,RuntimeException {
		LocalDate D = date.getValue();
		String cons = console.getText();
		String toto = total.getText();
		Integer tot= Integer.valueOf(toto);
		String m = montant.getText();
		Integer mont =Integer.valueOf(m);
		Integer c1 = article1.getValue();
		if (c1 != null) {
			BonReduction id1  = rec2.getNimBonById(c1);
			int prixBon =id1.getPrixBon();
			Integer monn = Integer.valueOf(mont-(tot-prixBon));
			Recu recu = new Recu();
			RecuDao r = new RecuDao();
			
			try {
				recu.setDate(Date.valueOf(D));
				recu.setMonnaie(monn);
				recu.setMontant(mont);
				recu.setSomTotal(P);
				recu.setProduit(cons);
				r.saveProduit(recu);
				
		
				
			} catch (Exception e) {
				// TODO: handle exception
			}int A = tot-prixBon;
			int M= mont -A;
			Document docu = new Document();
			PdfWriter.getInstance(docu, new FileOutputStream("facture.pdf"));
			docu.open();
			String format = "dd/mm/yy hh:mm";
			SimpleDateFormat formater = new SimpleDateFormat();
			java.util.Date date = new java.util.Date();
			docu.add(new Paragraph("O PRIX CASSE \n"));
			docu.add(new Paragraph("supermarche 123\n"));
			docu.add(new Paragraph("tel : 0779562248 \n\n"));
			docu.add(new Paragraph("cassier :delmas\n"));
			docu.add(new Paragraph("Date :"+formater.format(date)+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph(cons));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("total :"+tot+"\n"));
			docu.add(new Paragraph("bon de reduction :"+prixBon+"\n"));
			docu.add(new Paragraph("TOTAL :"+A+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("montant donne :"+mont+"\n"));
			docu.add(new Paragraph("monnaie :"+M+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("merci; passez une agrehable journee\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.close();
			Desktop.getDesktop().open(new File("facture.pdf"));
			
		}else {
			Integer monn = Integer.valueOf(mont-tot);
			Recu recu = new Recu();
			RecuDao r = new RecuDao();
			
			try {
				recu.setDate(Date.valueOf(D));
				recu.setMonnaie(monn);
				recu.setMontant(mont);
				recu.setSomTotal(P);
				recu.setProduit(cons);
				r.saveProduit(recu);
				
		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			int M= mont -tot;
			Document docu = new Document();
			PdfWriter.getInstance(docu, new FileOutputStream("facture.pdf"));
			docu.open();
			String format = "dd/mm/yy hh:mm";
			SimpleDateFormat formater = new SimpleDateFormat();
			java.util.Date date = new java.util.Date();
			docu.add(new Paragraph("O PRIX CASSE \n"));
			docu.add(new Paragraph("supermarche 123\n"));
			docu.add(new Paragraph("tel : 0779562248\n\n"));
			docu.add(new Paragraph("cassier :delmas\n"));
			docu.add(new Paragraph("Date :"+formater.format(date)+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph(cons));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("bon de reduction :\n"));
			docu.add(new Paragraph("TOTAL :"+tot+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("montant donne :"+mont+"\n"));
			docu.add(new Paragraph("monnaie : :"+M+"\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.add(new Paragraph("merci; passez une agrehable journee\n"));
			docu.add(new Paragraph("---------------------------\n"));
			docu.close();
			Desktop.getDesktop().open(new File("facture.pdf"));
		}
		
	}
	
	
	@FXML
	void Frecu (ActionEvent a) {
		Parent root;
		Stage primaryStage = new Stage();
		cai.getScene().getWindow().hide();
		try {
			root=FXMLLoader.load(getClass().getResource("/application/RecuCaisse.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@FXML
	void annuler(ActionEvent event) {
		
		quan.setText("");
		console.setText("");
		total.setText("");
		bon1.setText("");
		montant.setText("");
		article.setValue(null);
		article1.setValue(null);
		date.setValue(null);
		P=0;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ProduitDao art = new ProduitDao();
		for (Produit id : art.listProduit()) {
			article.getItems().addAll(FXCollections.observableArrayList(id.getIdProduit()));			
		}
		BonDao BON = new BonDao();
		for (BonReduction b : BON.getAllId()) {
			article1.getItems().addAll(FXCollections.observableArrayList(b.getNumBon()));
		}
		
	}
	

}
