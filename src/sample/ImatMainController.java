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
import java.text.SimpleDateFormat;
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
    Label antal;
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

    @FXML AnchorPane payscen;
    @FXML FlowPane flowpay;
    @FXML Button pay;
    @FXML Label pricetot;
    @FXML AnchorPane itemsAnchor1;
    @FXML FlowPane flowPane1;

    @FXML AnchorPane histoDet;
    @FXML FlowPane histoFlow;


    @FXML Label datumDet;
    @FXML Label orderNummerDet;

     @FXML Label totPrisDet;







    int antalInt = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // flowPane.setPrefWrapLength(2);
       flowPane.setHgap(7);
        flowPane.setVgap(7);
        startFlow.setVgap(7);
        startFlow.setHgap(7);
        histoFlow.setHgap(7);
        histoFlow.setVgap(7);
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
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.POD))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.BERRY))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.CITRUS_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MELONS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.ROOT_VEGETABLE))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Grönsaker & Frukt");
        setItemsFlow();
    }


    @FXML
    public void breadFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.BREAD))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Bröd");
        setItemsFlow();


    }


    @FXML
    public void meatFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MEAT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Chark");
        setItemsFlow();


    }

    @FXML
    public void sweetFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.SWEET))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Godis");
        setItemsFlow();

    }

    @FXML
    public void milkProductFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.DAIRIES))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Mejeri");
        setItemsFlow();
    }

    @FXML
    public void kryddorFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HERB))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Kryddor");
        setItemsFlow();
    }

    @FXML
    public void dryckFilter() {
        antal.setDisable(false);
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Dryck");
        setItemsFlow();
    }


    @FXML
    public void setSearchFilter() {
        antal.setDisable(false);
        page_label.setText("söker...");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.findProducts(searchFilter.getText())){
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));}
        if(flowPane.getChildren().isEmpty()){
            page_label.setText("Hittade inga varor.. ");

        }
        setItemsFlow();
    }

    @FXML
    public void setHistorikCards() {
        antal.setDisable(true);
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
        antal.setDisable(false);
        flowPane.getChildren().clear();
        page_label.setText("Favorit");
        ItemsCardsController itemsCardsController;
        for (Product p : iMatDataHandler.favorites()) {
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false);
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
        antal.setVisible(false);

        startFlow.getChildren().clear();
        ItemsCardsController itemsCardsController;
        for (Product p : iMatDataHandler.favorites()) {
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false);
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


    public void getPayScen(Event event) {
        payscen.toFront();

        flowpay.getChildren().clear();
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowpay.getChildren().add(new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId()));

        }

        pricetot.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }


    @FXML
    public void setCartCards() {
        antal.setVisible(true);
        flowPane.getChildren().clear();
        flowPane1.getChildren().clear();
        page_label.setText("Varukorg");
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowPane1.getChildren().add(new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId()));
        }
        //setItemsFlow();
        itemsAnchor1.toFront();
    }

    @FXML public void placeNow(){
        iMatDataHandler.placeOrder();
        flowPane.getChildren().clear();
        flowPane1.getChildren().clear();
        mainScen.toFront();
    }


@FXML public void setHistoDet(Order order, double price){
    //antal.setVisible(true);
    ItemsCardsController itemsCardsController;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

        histoFlow.getChildren().clear();
        histoDet.toFront();
        for(ShoppingItem s: order.getItems()) {
            histoFlow.getChildren().add(itemsCardsController= new ItemsCardsController(iMatDataHandler,this,s.getProduct().getProductId(), true));
            itemsCardsController.amount.setText("X"+s.getAmount()+"");
        }
        orderNummerDet.setText(order.getOrderNumber()+"");
        datumDet.setText(formatter.format(order.getDate()));
        totPrisDet.setText(price+"");
}

@FXML
public void setHistDetBack(){
        histoDet.toBack();

}





}