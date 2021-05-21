package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
    TextField kortnummerKonto;
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

     @FXML Button betalaLabel;
     @FXML Label  totPriceVaro;
    @FXML Label  totPriceVaro1;
    @FXML Button tömmaVarukorgen;

    @FXML Button historikButton;
    @FXML Button homeButton;
    @FXML Button favoritButton;
    @FXML Button varukorgButton;
    @FXML Button dryckButton;

    @FXML ImageView homeIcon;
    @FXML ImageView favoritIcon;
    @FXML ImageView varukorgIcon;
    @FXML ImageView kontoIcon;
    @FXML ImageView historikIcon;











    int antalInt = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // flowPane.setPrefWrapLength(2);
       flowPane.setHgap(20);
        flowPane.setVgap(20);
        startFlow.setVgap(20);
        startFlow.setHgap(20);
        histoFlow.setHgap(20);
        histoFlow.setVgap(20);
        antalLabel.setText(antalInt+"");
        setHome();

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
       betalaLabel.setVisible(false);
       totPriceVaro.setVisible(false);
       tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        grönsaker.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
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
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        bröd.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.BREAD))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Bröd");
        setItemsFlow();


    }


    @FXML
    public void meatFilter() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        chark.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MEAT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Chark");
        setItemsFlow();


    }

    @FXML
    public void sweetFilter() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        godis.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.SWEET))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Godis");
        setItemsFlow();

    }

    @FXML
    public void milkProductFilter() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        mejeri.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.DAIRIES))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Mejeri");
        setItemsFlow();
    }

    @FXML
    public void kryddorFilter() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        kryddor.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HERB))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(),false));
        page_label.setText("Kryddor");
        setItemsFlow();
    }

    @FXML
    public void dryckFilter() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
        dryckButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
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
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        setAllButtonsBlue();
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
        betalaLabel.setVisible(false);
        antal.setDisable(true);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        flowPane.getChildren().clear();
        page_label.setText("Historik");
        setAllButtonsBlue();
        historikButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        historikIcon.setImage(new Image("/pic/documentwhite.png"));

        for (Order o : orderList) {
            flowPane.getChildren().add(new historikCardsController(
                    iMatDataHandler, this, o));
        }
        setItemsFlow();
    }

    public void setAllButtonsBlue() {
        historikButton.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        historikIcon.setImage(new Image("/pic/document.png"));
        homeButton.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        homeIcon.setImage(new Image("/pic/home.png"));
        favoritButton.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        favoritIcon.setImage(new Image("/pic/star (2).png"));
        varukorgButton.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        varukorgIcon.setImage(new Image("/pic/shopping-cart.png"));
        konto.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        kontoIcon.setImage(new Image("/pic/user.png"));
        mejeri.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        chark.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        grönsaker.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        bröd.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        kryddor.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        godis.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");
        dryckButton.setStyle("-fx-background-color: #5697ef; -fx-text-fill: #000000");

    }


    @FXML
    public void setFavoritCards() {
        betalaLabel.setVisible(false);
        antal.setDisable(false);
        totPriceVaro.setVisible(false);
        tömmaVarukorgen.setVisible(false);
        flowPane.getChildren().clear();
        page_label.setText("Favorit");
        ItemsCardsController itemsCardsController;
        setAllButtonsBlue();
        favoritButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        favoritIcon.setImage(new Image("/pic/starwhite.png"));
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

        setAllButtonsBlue();
        homeButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        homeIcon.setImage(new Image("/pic/homewhite.png"));

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

        namnKonto.setText(iMatDataHandler.getCustomer().getFirstName());
        efterNamnKonto.setText(iMatDataHandler.getCustomer().getLastName());
        telefonnummerKonto.setText(iMatDataHandler.getCustomer().getMobilePhoneNumber());
        epostAdressKonto.setText(iMatDataHandler.getCustomer().getEmail());
        adressKonto.setText(iMatDataHandler.getCustomer().getAddress());
        postnummerKonto.setText(iMatDataHandler.getCustomer().getPostCode());

        cvvKonto.setText(iMatDataHandler.getCreditCard().getVerificationCode()+"");
        kortnummerKonto.setText(iMatDataHandler.getCreditCard().getCardNumber());
        korthållareKonto.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMonthKonto.setText(iMatDataHandler.getCreditCard().getValidMonth()+"");
        giltigTillYearKonto.setText(iMatDataHandler.getCreditCard().getValidYear()+"");

        kontoUppgifterScen.toFront();


        //giltigError.setText("");
        //cvvError.setText("");
        korthållareKonto.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMonthKonto.setText(iMatDataHandler.getCreditCard().getValidMonth()+"");
        giltigTillYearKonto.setText(iMatDataHandler.getCreditCard().getValidYear()+"");


    }

    public void saveKonto(){
        kontoUppgifterScen.toFront();

        iMatDataHandler.getCustomer().setFirstName(namnKonto.getText());
        System.out.println(namnKonto.getText());
        iMatDataHandler.getCustomer().setLastName(efterNamnKonto.getText());
        iMatDataHandler.getCustomer().setMobilePhoneNumber(telefonnummerKonto.getText());
        iMatDataHandler.getCustomer().setEmail(epostAdressKonto.getText());
        iMatDataHandler.getCustomer().setAddress(adressKonto.getText());
        iMatDataHandler.getCustomer().setPostCode(postnummerKonto.getText());



        iMatDataHandler.getCreditCard().setCardNumber(kortnummerKonto.getText());
        iMatDataHandler.getCreditCard().setHoldersName(korthållareKonto.getText());
        try {
            iMatDataHandler.getCreditCard().setValidYear(Integer.parseInt(giltigTillYearKonto.getText()));
            iMatDataHandler.getCreditCard().setValidMonth(Integer.parseInt(giltigTillMonthKonto.getText()));

        }
        catch (NumberFormatException e) {
            updateKontoInfo();
        //    giltigError.setText("Ogiltig input, skriv gärna giltighetsdatum med siffror");
        }

        try {
            iMatDataHandler.getCreditCard().setVerificationCode(Integer.parseInt(cvvKonto.getText()));;
        }
        catch (NumberFormatException e) {
            updateKontoInfo();
          //  cvvError.setText("Ogiltig input, skriv gärna CVV med siffror");
        }

        updateKontoInfo();

    }





    public void getPayScen(Event event) {
        payscen.toFront();

        flowpay.getChildren().clear();
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowpay.getChildren().add(new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId(),s));

        }

        pricetot.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }


    @FXML
    public void setCartCards() {
        betalaLabel.setVisible(true);
        totPriceVaro.setVisible(true);
        tömmaVarukorgen.setVisible(true);
        totPriceVaro.setText(iMatDataHandler.getShoppingCart().getTotal()+ " kr");
        ShoppingCartItem shoppingCartItem;
        antal.setVisible(true);
        flowPane.getChildren().clear();
        setAllButtonsBlue();
        varukorgButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        varukorgIcon.setImage(new Image("/pic/shopping-cartwhite.png"));

        page_label.setText("Varukorg");
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowPane.getChildren().add(shoppingCartItem=new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId(),s));
            shoppingCartItem.amount.setText(+(int)(s.getAmount())+" st");
            shoppingCartItem.totPris.setText(s.getTotal()+" kr");

        }
       setItemsFlow();
    }

    @FXML public void placeNow(){
        iMatDataHandler.placeOrder();
        flowPane.getChildren().clear();
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
            itemsCardsController.amount.setText((int)(s.getAmount())+" st");
            itemsCardsController.totPrisLebel.setText(s.getTotal()+" kr");
        }
        orderNummerDet.setText(order.getOrderNumber()+"");
        datumDet.setText(formatter.format(order.getDate()));
        totPrisDet.setText(price+"");
}

@FXML
public void setHistDetBack(){
        histoDet.toBack();

}

@FXML
    public  void infoScenToBack(){
        infoScen.toBack();
}

@FXML
    public void emptyCart(){
        iMatDataHandler.getShoppingCart().clear();
        flowPane.getChildren().clear();
}





}