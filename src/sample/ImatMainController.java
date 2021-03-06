package sample;

import javafx.animation.PauseTransition;
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
import javafx.scene.shape.Circle;
import javafx.util.Duration;
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
    SplitPane mainScen;
    @FXML
    SplitPane categories;
    @FXML
    AnchorPane bekraftelse;

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

    @FXML
    AnchorPane payscen;
    @FXML
    FlowPane flowpay;
    @FXML
    Button pay;
    @FXML
    Label pricetot;
    @FXML
    AnchorPane itemsAnchor1;
    @FXML
    FlowPane flowPane1;

    @FXML
    AnchorPane histoDet;
    @FXML
    FlowPane histoFlow;


    @FXML
    Label datumDet;
    @FXML
    Label orderNummerDet;
    @FXML
    Label totPrisDet;

    @FXML
    Button betalaLabel;
    @FXML
    Label totPriceVaro;
    @FXML
    Label totPriceVaro1;
    @FXML
    Button tömmaVarukorgen;

    @FXML
    Button historikButton;
    @FXML
    Button homeButton;
    @FXML
    Button favoritButton;
    @FXML
    Button varukorgButton;
    @FXML
    Button dryckButton;

    @FXML
    ImageView homeIcon;
    @FXML
    ImageView favoritIcon;
    @FXML
    ImageView varukorgIcon;
    @FXML
    ImageView kontoIcon;
    @FXML
    ImageView historikIcon;

    @FXML
    Label titel;
    @FXML
    Label sparadLabel;
    @FXML
    Label totPriceMain;

    @FXML
    TextField betName;
    @FXML
    TextField betLastName;
    @FXML
    TextField betSecnum;
    @FXML
    TextField betPhonenum;
    @FXML
    TextField betEmail;
    @FXML
    TextField betAdress;
    @FXML
    TextField betPostcode;
    @FXML
    TextField betCardtype;
    @FXML
    TextField betCardnum;
    @FXML
    TextField betCardDate;
    @FXML
    TextField betCardYear;
    @FXML
    TextField betCVV;
    @FXML
    TextField betCardHolder;

    @FXML
    Circle priceCounterCircle;


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
        antalLabel.setText(antalInt + "");
        setHome();

        totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }

    public void getInfoScen() {
        infoScen.toFront();

    }

    public void getMainScen(Event event) {
        categories.toFront();
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.CITRUS_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.MELONS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.ROOT_VEGETABLE))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
        //dryckButton.getStyleClass().add("redbuttons");
        dryckButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");

        flowPane.getChildren().clear();
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        for (Product p : iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS))
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
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
        for (Product p : iMatDataHandler.findProducts(searchFilter.getText())) {
            flowPane.getChildren().add(new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false));
        }
        if (flowPane.getChildren().isEmpty()) {
            page_label.setText("Hittade inga varor.. ");

        }
        setItemsFlow();
    }

    Order currO;
    historikCardsController historikCardsController;

    @FXML
    public void setHistorikCards() {
        categories.toFront();
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

        //dryckButton.getStyleClass().remove("redbuttons");
    }


    @FXML
    public void setFavoritCards() {
        categories.toFront();
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
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false);
            itemsCardsController.favorit.setImage(new Image("pic/star (1).png"));
            flowPane.getChildren().add(itemsCardsController);

        }
        setItemsFlow();
    }

    @FXML
    private void plusAntal() {
        antalInt++;
        antalLabel.setText(antalInt + "");
    }

    @FXML
    private void minusAntal() {
        if (antalInt > 0) {
            antalInt--;
            antalLabel.setText(antalInt + "");
        }
    }

    @FXML
    private void changeName() {

    }

    @FXML
    private void changeLastName() {

    }

    @FXML
    private void changeTelefonNummer() {
    }

    @FXML
    private void changeEmail() {
    }

    @FXML
    private void changeAdress() {
    }

    @FXML
    private void changePostNummer() {
    }

    @FXML
    private void setHome() {
        antal.setVisible(false);

        setAllButtonsBlue();
        homeButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        homeIcon.setImage(new Image("/pic/homewhite.png"));

        startFlow.getChildren().clear();
        ItemsCardsController itemsCardsController;
        for (Product p : iMatDataHandler.favorites()) {
            itemsCardsController = new ItemsCardsController(iMatDataHandler, this, p.getProductId(), false);
            itemsCardsController.favorit.setImage(new Image("pic/star (1).png"));
            startFlow.getChildren().add(itemsCardsController);

        }
        if (iMatDataHandler.favorites().size() == 0) {
            ingaFav.setVisible(true);
        } else ingaFav.setVisible(false);
        homeAnchor.toFront();
    }

    @FXML
    private void setItemsFlow() {
        itemsAnchor.toFront();
    }

    ;


    @FXML
    private void updateKontoInfo() {

        namnKonto.setText(iMatDataHandler.getCustomer().getFirstName());
        efterNamnKonto.setText(iMatDataHandler.getCustomer().getLastName());
        telefonnummerKonto.setText(iMatDataHandler.getCustomer().getMobilePhoneNumber());
        epostAdressKonto.setText(iMatDataHandler.getCustomer().getEmail());
        adressKonto.setText(iMatDataHandler.getCustomer().getAddress());
        postnummerKonto.setText(iMatDataHandler.getCustomer().getPostCode());

        cvvKonto.setText(iMatDataHandler.getCreditCard().getVerificationCode() + "");
        kortnummerKonto.setText(iMatDataHandler.getCreditCard().getCardNumber());
        korthållareKonto.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMonthKonto.setText(iMatDataHandler.getCreditCard().getValidMonth() + "");
        giltigTillYearKonto.setText(iMatDataHandler.getCreditCard().getValidYear() + "");

        kontoUppgifterScen.toFront();


        giltigError.setVisible(false);
        cvvError.setVisible(false);
        korthållareKonto.setText(iMatDataHandler.getCreditCard().getHoldersName());
        giltigTillMonthKonto.setText(iMatDataHandler.getCreditCard().getValidMonth() + "");
        giltigTillYearKonto.setText(iMatDataHandler.getCreditCard().getValidYear() + "");


    }

    public void setSparadLabelInvisible() {
        sparadLabel.setVisible(false);
    }

    public void saveKonto() {

        giltigError.setVisible(false);
        cvvError.setVisible(false);
        sparadLabel.setVisible(false);
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

        } catch (NumberFormatException e) {
            System.out.println("hello there");

            giltigError.setVisible(true);
            return;

            //updateKontoInfo();
        }

        try {
            iMatDataHandler.getCreditCard().setVerificationCode(Integer.parseInt(cvvKonto.getText()));
            ;
        } catch (NumberFormatException e) {
            cvvError.setVisible(true);
            return;
            //updateKontoInfo();
        }
        sparadLabel.setVisible(true);
        updateKontoInfo();

    }


    public void getPayScen(Event event) {
        payscen.toFront();
        betName.setText(iMatDataHandler.getCustomer().getFirstName());
        betLastName.setText(iMatDataHandler.getCustomer().getLastName());
        //betSecnum.setText(iMatDataHandler.getCustomer().get);
        betPhonenum.setText(iMatDataHandler.getCustomer().getMobilePhoneNumber());
        betEmail.setText(iMatDataHandler.getCustomer().getEmail());
        betAdress.setText(iMatDataHandler.getCustomer().getAddress());
        betPostcode.setText(iMatDataHandler.getCustomer().getPostCode());
        betCardnum.setText(iMatDataHandler.getCreditCard().getCardNumber());
        betCardDate.setText(String.valueOf(iMatDataHandler.getCreditCard().getValidMonth()));
        betCardYear.setText(String.valueOf(iMatDataHandler.getCreditCard().getValidYear()));
        betCVV.setText(String.valueOf(iMatDataHandler.getCreditCard().getVerificationCode()));
        betCardHolder.setText(iMatDataHandler.getCreditCard().getHoldersName());
        ShoppingCartItem shoppingCartItem;

        flowpay.getChildren().clear();
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowpay.getChildren().add(shoppingCartItem = new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId(), s));
            shoppingCartItem.Betalasida();
        }

        pricetot.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }


    @FXML
    public void setCartCards() {
        categories.toFront();
        betalaLabel.setVisible(true);
        totPriceVaro.setVisible(true);
        tömmaVarukorgen.setVisible(true);
        totPriceVaro.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
        ShoppingCartItem shoppingCartItem;
        antal.setVisible(true);
        flowPane.getChildren().clear();
        setAllButtonsBlue();
        varukorgButton.setStyle("-fx-background-color: #1B4378; -fx-text-fill: #FAFAFA");
        varukorgIcon.setImage(new Image("/pic/shopping-cartwhite.png"));

        page_label.setText("Varukorg");
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            flowPane.getChildren().add(shoppingCartItem = new ShoppingCartItem(
                    iMatDataHandler, this, s.getProduct().getProductId(), s));
            //shoppingCartItem.amount.setText(+(int)(s.getAmount())+ " " + shoppingCartItem.iMatDataHandler.);
            shoppingCartItem.setAmountLabel(s);
            shoppingCartItem.totPris.setText(s.getTotal() + " kr");
            shoppingCartItem.Varukorg();

        }
        setItemsFlow();
    }


    @FXML
    public void placeNow() {
        iMatDataHandler.placeOrder();
        flowPane.getChildren().clear();
        bekraftelse.toFront();
        totPriceMain.setText("0.0 kr");
    }


/*@FXML public void setHistoDet(Order order, double price){
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

        histoFlow.getChildren().clear();
        histoDet.toFront();
        for(ShoppingItem s: order.getItems()) {
            histoFlow.getChildren().add( new ItemsCardsController(iMatDataHandler,this,s.getProduct().getProductId(), true));
        }
        orderNummerDet.setText(order.getOrderNumber()+"");
        datumDet.setText(formatter.format(order.getDate()));
        totPrisDet.setText(price+"");

}*/

    @FXML
    public void setHistoDet(Order order, double price) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ShoppingCartItem shoppingCartItem;
        histoFlow.getChildren().clear();
        histoDet.toFront();
        for (ShoppingItem s : order.getItems()) {
            histoFlow.getChildren().add(shoppingCartItem = new ShoppingCartItem(iMatDataHandler, this, s.getProduct().getProductId(), s));
            shoppingCartItem.Betalasida();
        }
        orderNummerDet.setText(order.getOrderNumber() + "");
        datumDet.setText(formatter.format(order.getDate()));
        totPrisDet.setText(price + "");
        currO = order;
        orderToCartLabel.setVisible(true);

    }

    @FXML
    public void setHistDetBack() {
        histoDet.toBack();

    }

    @FXML
    public void infoScenToBack() {
        infoScen.toBack();
    }

    @FXML
    public void emptyCart() {
        iMatDataHandler.getShoppingCart().clear();
        flowPane.getChildren().clear();
        totPriceVaro.setText(String.valueOf(iMatDataHandler.getShoppingCart().getTotal()));
        totPriceMain.setText(String.valueOf(iMatDataHandler.getShoppingCart().getTotal()));
    }

    public boolean isAlreadyInCart(int id) {
        boolean there = false;
        for (ShoppingItem shoppingItem : iMatDataHandler.getShoppingCart().getItems()) {
            if (shoppingItem.getProduct().equals(iMatDataHandler.getProduct(id))) {
                there = true;
            }

        }
        return there;


    }

    public ShoppingItem getShoppingItem(int id){
        ShoppingItem item=null;
        for(ShoppingItem shoppingItem: iMatDataHandler.getShoppingCart().getItems()){
            if(shoppingItem.getProduct().equals(iMatDataHandler.getProduct(id))) {
                item =shoppingItem;
            }

        }
        return item;

    }

    @FXML
    Button orderToCartLabel;

    @FXML
    public void orderToCart() {

        for (ShoppingItem s : currO.getItems()) {
            if (isAlreadyInCart(s.getProduct().getProductId())) {
                getShoppingItem(s.getProduct().getProductId()).setAmount(getShoppingItem(s.getProduct().getProductId()).getAmount() + 1);
            } else {
                iMatDataHandler.getShoppingCart().addProduct(iMatDataHandler.getProduct(s.getProduct().getProductId()));

            }
        }


            orderToCartLabel.setVisible(false);
            totPriceMain.setText(String.valueOf(iMatDataHandler.getShoppingCart().getTotal()));
        }


    ShoppingItem CurrVara;
    Product product;
    @FXML Button LaggTill;
    @FXML
    public void LaggTill() {
        LaggTill.setVisible(false);
        //   antalLabel.setText(getShopingitem().getAmount()+"");
        // Product p = iMatDataHandler.getProduct(id);
        Plusset();

    }


    public boolean FinnsDen(ShoppingItem ss){
        boolean there=false;
        for(ShoppingItem shoppingItem: iMatDataHandler.getShoppingCart().getItems()){
            if(shoppingItem.getProduct().equals(ss.getProduct())) {
                there = true;
            }

        }
        return there;


    }

    @FXML
    private void Plusset () {
        if (CurrVara == null) {
            iMatDataHandler.getShoppingCart().addProduct(product);
            for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()){
                if (s.getProduct().equals(product)){
                    CurrVara = s;
                }
            }
        } else {
            if(FinnsDen(CurrVara)){
                CurrVara.setAmount(CurrVara.getAmount()+1);
            }
        }

        //antalLabel.setText(String.valueOf((int) CurrVara.getAmount()));

        /*System.out.println(CurrVara.getProduct());
        if(FinnsDen(CurrVara)){
            CurrVara.setAmount(CurrVara.getAmount()+1);
        }
        else {
            //iMatDataHandler.getShoppingCart().addProduct(CurrVara.getProduct());

        }*/

        antalLabel.setText((int)CurrVara.getAmount() + " " + CurrVara.getProduct().getUnitSuffix());
        totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
        totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
        priceCounterCircle.setStyle("-fx-fill: #24ff3a;");
        totPriceMain.setStyle("-fx-font-weight: 700");
        PauseTransition pause = new PauseTransition(Duration.seconds(0.6));
        pause.setOnFinished(event -> {
            priceCounterCircle.setStyle("-fx-fill: #e2f1ff;");
            totPriceMain.setStyle("-fx-font-weight: 500");
        });
        pause.play();
    }

    @FXML
    private  void Minuset () {
        if (CurrVara.getAmount() > 1) {
            if(FinnsDen(CurrVara)){
                CurrVara.setAmount(CurrVara.getAmount()-1);
                antalLabel.setText((int)CurrVara.getAmount() + " " + CurrVara.getProduct().getUnitSuffix());
                totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
                priceCounterCircle.setStyle("-fx-fill: #24ff3a;");
                totPriceMain.setStyle("-fx-font-weight: 700");
                PauseTransition pause = new PauseTransition(Duration.seconds(0.6));
                pause.setOnFinished(event -> {
                    priceCounterCircle.setStyle("-fx-fill: #e2f1ff;");
                    totPriceMain.setStyle("-fx-font-weight: 500");
                });
                pause.play();
            }
        }
        else{

            iMatDataHandler.getShoppingCart().removeItem(CurrVara);
            totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
            LaggTill.setVisible(true);
            //  parentController.setCartCards();

        }
    }


    }