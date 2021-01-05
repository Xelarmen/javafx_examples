package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Random;


public class Controller {
    Random rnd = new Random();
    public static int sayi;
    public static int tahmin_sayisi = 1;
    @FXML private Slider levelsec;
    @FXML private TextField tahminkutusu;
    @FXML private VBox back;

    /*GİRİS*/
    @FXML
    private void basla(ActionEvent event) throws InterruptedException {
        event.consume();
        switch ((int) levelsec.getValue()) {
            case 1:
                sayi = rnd.nextInt(11);
                break;
            case 2:
                sayi = rnd.nextInt(21);
                break;
            case 3:
                sayi = rnd.nextInt(31);
                break;
            case 4:
                sayi = rnd.nextInt(41);
                break;
            case 5:
                sayi = rnd.nextInt(51);
                break;
        }
        System.out.println(sayi);
        loadStage("play.fxml");
    }
    /*GİRİS_END*/

    /*TAHMİN*/
    @FXML
    private void tahminet (ActionEvent event) throws InterruptedException {   //Buton event'i
        event.consume();
        if(tahminkutusu.getText().equals(String.valueOf(sayi))){
            Alert a1 = new Alert(AlertType.NONE,tahmin_sayisi+" Tahminde Sayıyı Doğru Tahmin Ettiniz!",ButtonType.APPLY);
            a1.setTitle("Başarılı");
            a1.show();
            tahmin_sayisi=1;
        }
        else{
            tahmin_sayisi++;
        }
        }
        /*TAHMİN_END*/


        private void loadStage (String fxml){
            try {
                Parent root = FXMLLoader.load(getClass().getResource(fxml));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

