package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class ShoppingCartItem extends AnchorPane {
    IMatDataHandler iMatDataHandler;
    ImatMainController imatMainController;
    private int id;

    @FXML
    ImageView image;
    @FXML Label name;
    @FXML
    Label price;
    @FXML
    Label from;
    @FXML
    Label weight;
    @FXML
    Label amount;
    @FXML
    Label totPris;


    @FXML ImageView plusImage;
    @FXML ImageView minusImage;
    @FXML ImageView ECOlabel;
    @FXML ImageView papperskorg;

    int antalInt =1;

    ShoppingItem shoppingItem;

    public ShoppingCartItem(IMatDataHandler iMatDataHandler,
                                   ImatMainController imatMainController,
                            int id,ShoppingItem s){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                ("ShoppingCartItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.iMatDataHandler =iMatDataHandler;
        this.imatMainController=imatMainController;
        this.id = id;
        this.shoppingItem=s;

        image.setImage(iMatDataHandler.getFXImage(iMatDataHandler.getProduct(id)));
        name.setText(iMatDataHandler.getProduct(id).getName());
      ECOlabel.setImage(new Image("pic/eco.png"));
        if (iMatDataHandler.getProduct(id).isEcological()){
            ECOlabel.setVisible(true);
        } else {
            ECOlabel.setVisible(false);
        }

        price.setText(String.valueOf(s.getProduct().getPrice()) + " kr");
        totPris.setText(s.getTotal()+" kr");
        amount.setText(String.valueOf(s.getAmount()) + " " + s.getProduct().getUnitSuffix());

        for (ShoppingItem shoppingItem : iMatDataHandler.getShoppingCart().getItems()) {
            if (shoppingItem.getProduct().equals(iMatDataHandler.getProduct(id))) {
                System.out.println(shoppingItem.getAmount());
                System.out.println(shoppingItem.getTotal() + "total");
                price.setText((iMatDataHandler.getProduct(id).getPrice() + " kr"));


            }
        }

       // price.setText(iMatDataHandler.getShoppingCart().getPrice()+ "kr");
        //from.setText(iMatDataHandler.getProduct(id).get);
    }

    public void removeFromCart(){
        iMatDataHandler.getShoppingCart().removeItem(shoppingItem);
        imatMainController.setCartCards();
        imatMainController.totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }

    public void removeAllFromCart(){
        iMatDataHandler.getShoppingCart().clear();
        imatMainController.flowPane.getChildren().clear();
        imatMainController.flowPane1.getChildren().clear();
        imatMainController.totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }


    @FXML
    private void plusAntal () {

        shoppingItem.setAmount(shoppingItem.getAmount()+1);
        imatMainController.setCartCards();
        imatMainController.totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
    }

    @FXML
    private void minusAntal () {
        if (shoppingItem.getAmount() > 1) {
            shoppingItem.setAmount(shoppingItem.getAmount()+-1);
            imatMainController.setCartCards();
            imatMainController.setCartCards();
            imatMainController.totPriceMain.setText(iMatDataHandler.getShoppingCart().getTotal() + " kr");
        } else if (shoppingItem.getAmount() == 1) {
            removeFromCart();
        }
    }

    @FXML
    public void setAmountLabel(ShoppingItem s){
        amount.setText((int)s.getAmount() + " " + iMatDataHandler.getProduct(id).getUnitSuffix());
    }

    @FXML
    public void Betalasida(){
        minusImage.setVisible(false);
        plusImage.setVisible(false);
        papperskorg.setVisible(false);
    }

    @FXML
    public void Varukorg(){
        minusImage.setVisible(true);
        plusImage.setVisible(true);
        papperskorg.setVisible(true);
    }
}
