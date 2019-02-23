import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Document doc;
    @FXML
    private ComboBox<String> cbBox;


    private ObservableList<String> cbLista;
    private String urlWikia = "https://leagueoflegends.fandom.com/wiki/", urlOSite = "https://universe.leagueoflegends.com/en_US/champion/", param = "List_of_champions";

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try{
            doc = Jsoup.connect((urlWikia +param)).get();
            String titulo = doc.title();
            System.out.println(titulo);
            ArrayList<String> champs = new ArrayList<String>();
            Elements e = doc.getElementsByAttribute("data-sort-value");

            for (int i=0; i< e.size();i+=3) {
                champs.add(e.get(i).attr("data-sort-value"));
            }
            cbLista = FXCollections.observableArrayList(champs);

            cbBox.setItems(cbLista);
        } catch (IOException e){
            System.out.println("IOException: "+e.getLocalizedMessage());
        }
    }

    public void abrirWikia(ActionEvent actionEvent) {
        try{
            Desktop.getDesktop().browse(new URI(urlWikia +cbBox.getValue()));
        } catch (URISyntaxException e){

        } catch (IOException e2){

        }
    }

    public void abrirOSite(ActionEvent actionEvent) {
        try{
            Desktop.getDesktop().browse(new URI(urlOSite +cbBox.getValue()));
        } catch (URISyntaxException e){

        } catch (IOException e2){

        }

    }

}
