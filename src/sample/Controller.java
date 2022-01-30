package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    @FXML
    TextArea originalTextArea;

    @FXML
    TextArea translatedTextArea;

    @FXML
    Button translateButton;

    @FXML
    ComboBox odabirComboBox;

    Map<String, String> latinicaCirilicaMap = new HashMap<>();
    Map<String, String> cirilicaLatinicaMap = new HashMap<>();

    public void initialize(){
        latinicaCirilicaMap.put("a", "а");
        latinicaCirilicaMap.put("b", "б");
        latinicaCirilicaMap.put("c", "ц");
        latinicaCirilicaMap.put("č", "ч");
        latinicaCirilicaMap.put("ć", "ћ");
        latinicaCirilicaMap.put("d", "д");
        latinicaCirilicaMap.put("dž", "џ");
        latinicaCirilicaMap.put("đ", "ђ");
        latinicaCirilicaMap.put("e", "е");
        latinicaCirilicaMap.put("f", "ф");
        latinicaCirilicaMap.put("g", "г");
        latinicaCirilicaMap.put("h", "х");
        latinicaCirilicaMap.put("i", "и");
        latinicaCirilicaMap.put("j", "ј");
        latinicaCirilicaMap.put("k", "к");
        latinicaCirilicaMap.put("l", "л");
        latinicaCirilicaMap.put("lj", "љ");
        latinicaCirilicaMap.put("m", "м");
        latinicaCirilicaMap.put("n", "н");
        latinicaCirilicaMap.put("nj", "њ");
        latinicaCirilicaMap.put("o", "о");
        latinicaCirilicaMap.put("p", "п");
        latinicaCirilicaMap.put("q", "q");
        latinicaCirilicaMap.put("r", "р");
        latinicaCirilicaMap.put("s", "с");
        latinicaCirilicaMap.put("š", "ш");
        latinicaCirilicaMap.put("t", "т");
        latinicaCirilicaMap.put("u", "у");
        latinicaCirilicaMap.put("v", "в");
        latinicaCirilicaMap.put("x", "џ");
        latinicaCirilicaMap.put("y", "y");
        latinicaCirilicaMap.put("z", "з");
        latinicaCirilicaMap.put("ž", "ж");
        latinicaCirilicaMap.put("A", "А");
        latinicaCirilicaMap.put("B", "Б");
        latinicaCirilicaMap.put("C", "Ц");
        latinicaCirilicaMap.put("Č", "Ч");
        latinicaCirilicaMap.put("Ć", "Ћ");
        latinicaCirilicaMap.put("D", "Д");
        latinicaCirilicaMap.put("Dž", "Џ");
        latinicaCirilicaMap.put("Đ", "Ђ");
        latinicaCirilicaMap.put("E", "Е");
        latinicaCirilicaMap.put("F", "Ф");
        latinicaCirilicaMap.put("G", "Г");
        latinicaCirilicaMap.put("H", "Х");
        latinicaCirilicaMap.put("I", "И");
        latinicaCirilicaMap.put("J", "Ј");
        latinicaCirilicaMap.put("K", "К");
        latinicaCirilicaMap.put("L", "Л");
        latinicaCirilicaMap.put("Lj", "Љ");
        latinicaCirilicaMap.put("M", "М");
        latinicaCirilicaMap.put("N", "Н");
        latinicaCirilicaMap.put("Nj", "Њ");
        latinicaCirilicaMap.put("O", "О");
        latinicaCirilicaMap.put("P", "П");
        latinicaCirilicaMap.put("Q", "Q");
        latinicaCirilicaMap.put("R", "Р");
        latinicaCirilicaMap.put("S", "С");
        latinicaCirilicaMap.put("Š", "Ш");
        latinicaCirilicaMap.put("T", "Т");
        latinicaCirilicaMap.put("U", "У");
        latinicaCirilicaMap.put("V", "В");
        latinicaCirilicaMap.put("Y", "Y");
        latinicaCirilicaMap.put("X", "X");
        latinicaCirilicaMap.put("Z", "З");
        latinicaCirilicaMap.put("Ž", "Ж");

        for(String slovo : latinicaCirilicaMap.keySet()){
            if(slovo!="x")
            cirilicaLatinicaMap.put(latinicaCirilicaMap.get(slovo), slovo);
        }

        String listaOdabira[] = {"Latinica -> Ćirilica", "Ćirilica -> Latinica"};
        ObservableList<String> listaOdabiraObservable = FXCollections.observableList(Arrays.asList(listaOdabira));

        odabirComboBox.setItems(listaOdabiraObservable);
        odabirComboBox.setPromptText("Latinica -> Ćirilica");
        odabirComboBox.getSelectionModel().selectFirst();

        translateButton.setStyle("-fx-faint-focus-color: transparent; -fx-focus-color:rgb(255,0,251);");
        odabirComboBox.setStyle("-fx-faint-focus-color: transparent; -fx-focus-color:rgb(255,0,251);");
        translatedTextArea.setStyle("-fx-faint-focus-color: transparent; -fx-focus-color:rgb(255,0,251);");
        originalTextArea.setStyle("-fx-faint-focus-color: transparent; -fx-focus-color:rgb(255,0,251);");
        translatedTextArea.setWrapText(true);
        originalTextArea.setWrapText(true);
    }

    public void translate(){
        String original = originalTextArea.getText();
        String prevedeno = "";
        String smjer = (String) odabirComboBox.getValue();

        if(smjer.equals("Latinica -> Ćirilica"))
            prevedeno = naCirilicu(original, prevedeno);
        else
            prevedeno = naLatinicu(original, prevedeno);

        translatedTextArea.setText(prevedeno);
    }

    private String naCirilicu(String original, String prevedeno){
        for(int i = 0; i<original.length(); i++){
            String trenutni = String.valueOf(original.charAt(i));
            if(latinicaCirilicaMap.containsKey(trenutni)){
                if(i>0){
                    String prosli = String.valueOf(original.charAt(i-1));
                    if(trenutni.equalsIgnoreCase("ž") && prosli.equalsIgnoreCase("d")){
                        if(prosli.equals("D"))
                            trenutni = "Dž";
                        else
                            trenutni="dž";
                        prevedeno = prevedeno.substring(0, prevedeno.length()-1);
                    }
                    if(trenutni.equalsIgnoreCase("j") && prosli.equalsIgnoreCase("l")){
                        if(prosli.equals("L"))
                            trenutni = "Lj";
                        else
                            trenutni="lj";
                        prevedeno = prevedeno.substring(0, prevedeno.length()-1);
                    }
                    if(trenutni.equalsIgnoreCase("j") && prosli.equalsIgnoreCase("n")){
                        if(prosli.equals("N"))
                            trenutni = "Nj";
                        else
                            trenutni="nj";
                        prevedeno = prevedeno.substring(0, prevedeno.length()-1);
                    }
                }
                prevedeno+=latinicaCirilicaMap.get(trenutni);
            }
            else{
                prevedeno+=trenutni;
            }
        }

        return prevedeno;
    }

    private String naLatinicu(String original, String prevedeno){
        System.out.println("prevodim");
        for(int i = 0; i<original.length(); i++){
            String trenutni = String.valueOf(original.charAt(i));
            if(cirilicaLatinicaMap.containsKey(trenutni)){
                prevedeno+=cirilicaLatinicaMap.get(trenutni);
            }
            else{
                prevedeno+=trenutni;
            }
        }
        return prevedeno;
    }
}
