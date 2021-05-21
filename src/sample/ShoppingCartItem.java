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

        for (ShoppingItem shoppingItem : iMatDataHandler.getShoppingCart().getItems()) {
            if (shoppingItem.getProduct().equals(iMatDataHandler.getProduct(id))) {
                System.out.println(shoppingItem.getAmount());
                System.out.println(shoppingItem.getTotal() + "total");
                price.setText((iMatDataHandler.getProduct(id).getPrice() + "kr"));


            }
        }
       // price.setText(iMatDataHandler.getShoppingCart().getPrice()+ "kr");
        //from.setText(iMatDataHandler.getProduct(id).get);
    }

    public void removeFromCart(){
    }

    public void removeAllFromCart(){
        iMatDataHandler.getShoppingCart().clear();
        imatMainController.flowPane.getChildren().clear();
        imatMainController.flowPane1.getChildren().clear();
    }


    @FXML
    private void plusAntal () {


        shoppingItem.setAmount(shoppingItem.getAmount()+1);
        imatMainController.setCartCards();
    }

    @FXML
    private void minusAntal () {
        if (shoppingItem.getAmount() > 0) {
            shoppingItem.setAmount(shoppingItem.getAmount()+-1);
            imatMainController.setCartCards();
            imatMainController.setCartCards();
        }
    }
}
