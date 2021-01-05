package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    /*DEĞİŞLENLER*/
    public static String username,password;
    @FXML private TextField kyd_user;       //kayit formu
    @FXML private PasswordField kyd_pass;   //kayit formu
    @FXML private PasswordField kyd_passdgr;//kayit formu
    @FXML private TextField user;           //login formu
    @FXML private PasswordField pass;       //login formu
    /*DEĞİŞLENLER-SON*/

/*sample fxml*/
    @FXML
    private void grsyp(ActionEvent event) throws InterruptedException {
        event.consume();
        loadStage("login.fxml");
    }
    @FXML
    private void kydl(ActionEvent event) throws InterruptedException {
        event.consume();
        loadStage("register.fxml");
    }
/*sample fxml-end*/

/*register fxml*/
@FXML
private void kydlbtn(ActionEvent event) throws InterruptedException {
    event.consume();
    if (kyd_pass.getText().equals(kyd_passdgr.getText()) && !kyd_user.getText().isEmpty() && !kyd_passdgr.getText().isEmpty() && !kyd_pass.getText().isEmpty()) {//Parolaların aynı olması ve boş olmaması, kullanıcı adının boş olmaması
        username=kyd_user.getText();
        password=kyd_pass.getText();
        Alert a1 = new Alert(AlertType.NONE,"Sisteme Başarıyla Kaydoldunuz Giriş Ekranına Gidebilirsiniz!",ButtonType.APPLY);
        a1.setTitle("Başarılı");
        a1.show();
    }
    else {
        Alert a2 = new Alert(AlertType.ERROR,"Bilgilerinizi Kontrol Ediniz",ButtonType.CLOSE);
        a2.setTitle("Hata");
        a2.show();
    }
}
/*register fxml*/

/*login fxml*/
@FXML
private void lgnbtn(ActionEvent event) throws InterruptedException {
    event.consume();
    System.out.println(username);
    System.out.println(password);
    System.out.println(user.getText());
    System.out.println(pass.getText());

    if (user.getText().equals(username) && pass.getText().equals(password)) {
        Alert a3 = new Alert(AlertType.NONE,"Sisteme Başarıyla Giriş Yaptınız!",ButtonType.APPLY);
        a3.setTitle("Hoşgeldiniz");
        a3.show();
    }
    else {
        Alert a4 = new Alert(AlertType.ERROR,"Hatalı Bilgiler, Lütfen Bilgilerinizi Kontrol Ediniz",ButtonType.CLOSE);
        a4.setTitle("Hata");
        a4.show();
    }
}
    /*login fxml*/


    private void loadStage(String fxml){
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
