package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.*;



import java.net.URL;
import java.util.*;
import java.util.List;

public class ImatMainController implements Initializable {
    //database
   static IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    private List<Order> orderList = iMatDataHandler.getOrders();


    @FXML
    FlowPane startFlow;
    @FXML
    ImageView logo;
    @FXML
    Button mejeri;
    @FXML
    Button chark;
    @FXML
    Button grönsaker;
    @FXML
    Button bröd;
    @FXML
    Button kryddor;
    @FXML
    Button godis;
    @FXML
    Button hygein;

    @FXML
    Button add;
    @FXML
    ImageView cardImage;
    @FXML
    TextArea description;
    @FXML
    Label antalLabel;
    @FXML
    ImageView plus;
    @FXML
    ImageView minus;
    @FXML
    ProgressBar progres;
    @FXML
    Label detInfoPris;

    @FXML
    TextField searchFilter;
    @FXML
    Button historik;
    @FXML
    Button konto;


    @FXML
    Label page_label;
    @FXML
    FlowPane flowPane;
    @FXML
    AnchorPane infoScen;
    @FXML
    AnchorPane mainScen;

    @FXML
    ImageView exit;


    @FXML
    Label namn;
    @FXML
    Label efterNamn;
    @FXML
    Label personnummer;
    @FXML
    Label telefonNummer;
    @FXML
    Label epostAdress;
    @FXML
    Label adress;
    @FXML
    Label postNummer;
    @FXML
    Label kortNummer;
    @FXML
    Label giltigTillYear;
    @FXML
    Label giltigTillMount;
    @FXML
    Label cvv;
    @FXML
    Label korthållare;






    @FXML
    TextField namnKonto;
    @FXML
    TextField efterNamnKonto;
    @FXML
    TextField perssonnummerKonto;
    @FXML
    TextField telefonnummerKonto;
    @FXML
    TextField epostAdressKonto;
    @FXML
    TextField adressKonto;
    @FXML
    TextField postnummerKonto;
    @FXML
    TextField KortnummerKonto;
    @FXML
    TextField giltigTillYearKonto;
    @FXML
    TextField giltigTillMonthKonto;
    @FXML
    TextField cvvKonto;
    @FXML
    TextField korthållareKonto;
    @FXML
    AnchorPane kontoUppgifterScen;
    @FXML
    AnchorPane changeKontoUppgifterScen;
    @FXML
    ImageView closeChangeKontoUpp;
    @FXML
    Button changeKontoButton;

    @FXML
    Label giltigError;
    @FXML
    Label cvvError;

    @FXML
    AnchorPane homeAnchor;
    @FXML
    AnchorPane itemsAnchor;

    @FXML
    Label ingaFav;





    int antalInt = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Product p : iMatDataHandler.getProducts()) {
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        }
       // flowPane.setPrefWrapLength(2);
       flowPane.setHgap(7);
        flowPane.setVgap(7);
        startFlow.setVgap(7);
        startFlow.setHgap(7);
        antalLabel.setText(antalInt+"");

    }

    public void getInfoScen() {
        infoScen.toFront();

    }

    public void getMainScen(Event event) {
        mainScen.toFront();
        setHome();

    }


    @FXML
    public void vegeFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.POD))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.BERRY))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.CITRUS_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MELONS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.ROOT_VEGETABLE))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Grönsaker & Frukt");
        setItemsFlow();
    }


    @FXML
    public void breadFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.BREAD))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Bröd");
        setItemsFlow();


    }


    @FXML
    public void meatFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MEAT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Chark");
        setItemsFlow();


    }

    @FXML
    public void sweetFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.SWEET))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Godis");
        setItemsFlow();

    }

    @FXML
    public void milkProductFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.DAIRIES))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Mejeri");
        setItemsFlow();
    }

    @FXML
    public void kryddorFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HERB))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Kryddor");
        setItemsFlow();
    }

    @FXML
    public void dryckFilter() {
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));
        page_label.setText("Dryck");
        setItemsFlow();
    }


    @FXML
    public void setSearchFilter() {
        page_label.setText("söker...");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.findProducts(searchFilter.getText())){
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId()));}
        if(flowPane.getChildren().isEmpty()){
            page_label.setText("Hittade inga varor.. ");

        }
        setItemsFlow();
    }

    @FXML
    public void setHistorikCards() {
        flowPane.getChildren().clear();
        page_label.setText("Historik");
        for (Order o : orderList) {
            flowPane.getChildren().add(new historikCardsController(
                    iMatDataHandler, this, o));

        }
        setItemsFlow();
    }

    @FXML
    public void setFavoritCards() {
        flowPane.getChildren().clear();
        page_label.setText("Favorit");
        ItemsCardsController itemsCardsController;
        for (Product p : iMatDataHandler.favorites()) {
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId());
            itemsCardsController.favorit.setImage(new Image("pic/star (1).png"));
            flowPane.getChildren().add(itemsCardsController);

        }
        setItemsFlow();
    }
@FXML
    private void plusAntal(){
        antalInt++;
    antalLabel.setText(antalInt+"");
    }

    @FXML
    private void minusAntal(){
        if(antalInt>0) {
            antalInt--;
            antalLabel.setText(antalInt + "");
        }
    }

    @FXML
    private  void setKontoUppgifterScen(){

        namn.setText(iMatDataHandler.getCustomer().getFirstName());
        efterNamn.setText(iMatDataHandler.getCustomer().getLastName());
        telefonNummer.setText(iMatDataHandler.getCustomer().getMobilePhoneNumber());
        epostAdress.setText(iMatDataHandler.getCustomer().getEmail());
        adress.setText(iMatDataHandler.getCustomer().getAddress());
        postNummer.setText(iMatDataHandler.getCustomer().getPostCode());

        cvv.setText(iMatDataHandler.getCreditCard().getVerificationCode()+"");
        kortNummer.setText(iMatDataHandler.getCreditCard().getCardNumber());
        korthållare.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMount.setText(iMatDataHandler.getCreditCard().getValidMonth()+"");
        giltigTillYear.setText(iMatDataHandler.getCreditCard().getValidYear()+"");


        kontoUppgifterScen.toFront();
    }
    @FXML
    private  void setChangeKontoUppgifterScen(){

        changeKontoUppgifterScen.toFront();

        giltigError.setText("");
        cvvError.setText("");
        korthållareKonto.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMonthKonto.setText(iMatDataHandler.getCreditCard().getValidMonth()+"");
        giltigTillYearKonto.setText(iMatDataHandler.getCreditCard().getValidYear()+"");




    }

    @FXML
    private void changeName(){

    }
    @FXML
    private void changeLastName(){

    }
    @FXML
    private void changeTelefonNummer(){

    }
    @FXML
    private void changeEmail(){

    }
    @FXML
    private void changeAdress(){

    }
    @FXML
    private void changePostNummer(){

    }

    @FXML
    private  void setHome(){

        startFlow.getChildren().clear();
        ItemsCardsController itemsCardsController;
        for (Product p : iMatDataHandler.favorites()) {
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId());
            itemsCardsController.favorit.setImage(new Image("pic/star (1).png"));
            startFlow.getChildren().add(itemsCardsController);

        }
        if(iMatDataHandler.favorites().size()==0) {ingaFav.setVisible(true); }
        else ingaFav.setVisible(false);
        homeAnchor.toFront();
    }
    @FXML
    private  void setItemsFlow(){
        itemsAnchor.toFront();
    };


    @FXML
    private void updateKontoInfo(){


        kontoUppgifterScen.toFront();

        iMatDataHandler.getCustomer().setFirstName(namnKonto.getText());
        System.out.println(namnKonto.getText());
        iMatDataHandler.getCustomer().setLastName(efterNamnKonto.getText());
        iMatDataHandler.getCustomer().setMobilePhoneNumber(telefonnummerKonto.getText());
        iMatDataHandler.getCustomer().setEmail(epostAdressKonto.getText());
        iMatDataHandler.getCustomer().setAddress(adressKonto.getText());
        iMatDataHandler.getCustomer().setPostCode(postnummerKonto.getText());



        iMatDataHandler.getCreditCard().setCardNumber(KortnummerKonto.getText());
        iMatDataHandler.getCreditCard().setHoldersName(korthållareKonto.getText());
        try {
            iMatDataHandler.getCreditCard().setValidYear(Integer.parseInt(giltigTillYearKonto.getText()));
            iMatDataHandler.getCreditCard().setValidMonth(Integer.parseInt(giltigTillMonthKonto.getText()));

        }
           catch (NumberFormatException e) {
              setChangeKontoUppgifterScen();
              giltigError.setText("Ogiltig input, skriv gärna giltighetsdatum med siffror");
            }

        try {
            iMatDataHandler.getCreditCard().setVerificationCode(Integer.parseInt(cvvKonto.getText()));;
        }
        catch (NumberFormatException e) {
            setChangeKontoUppgifterScen();
            cvvError.setText("Ogiltig input, skriv gärna CVV med siffror");
        }




        namn.setText(iMatDataHandler.getCustomer().getFirstName());
        efterNamn.setText(iMatDataHandler.getCustomer().getLastName());
        telefonNummer.setText(iMatDataHandler.getCustomer().getMobilePhoneNumber());
        epostAdress.setText(iMatDataHandler.getCustomer().getEmail());
        adress.setText(iMatDataHandler.getCustomer().getAddress());
        postNummer.setText(iMatDataHandler.getCustomer().getPostCode());

       cvv.setText(iMatDataHandler.getCreditCard().getVerificationCode()+"");
       kortNummer.setText(iMatDataHandler.getCreditCard().getCardNumber());
        korthållare.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMount.setText(iMatDataHandler.getCreditCard().getValidMonth()+"");
        giltigTillYear.setText(iMatDataHandler.getCreditCard().getValidYear()+"");


    }
  /*  @FXML
    public static void onClose(){
        iMatDataHandler.shutDown();
    }

*/






}