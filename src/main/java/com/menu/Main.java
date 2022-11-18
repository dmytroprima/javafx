package com.menu;

import com.functional.DBWorker;
//import com.sun.glass.ui.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
//import jdk.javadoc.internal.doclets.toolkit.util.Group;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application{
    private static DBWorker worker = new DBWorker();
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws SQLException {
        launch(args);
            MainMenu mainMenu = new MainMenu();
            while (true){
                System.out.print("Select command:" + mainMenu.getCommands() +"\nYour command: ");
                String command = scan.next();
                mainMenu.execute(command);
            }
    }

    @Override
    public void start(Stage primaryStage)throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu/app.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fracken");
        primaryStage.show();
        /*primaryStage.setTitle("Hello");
        primaryStage.setScene(new Scene(root, 700,400));
        primaryStage.show();*/
        /*Group group = new Group();
        Scene scene = new Scene(group, 700,400);
        Parent content = FXMLLoader.load(getClass().getResource("app.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        group.getChildren().add(root);
        primaryStage.getScene();
        primaryStage.show();*/

    }

    public static void createGift(){
        try {
            Statement statement = worker.connection.createStatement();
            Statement statement1 = worker.connection.createStatement();
            int position = 0;
            System.out.print("Enter gift name: ");
            String name = scan.next();
            while (true){
                position++;
                System.out.println("Store");
                ResultSet res = statement.executeQuery("select * from candies");
                //-----
                while (res.next()){
                    System.out.println("Name: " + res.getString(1) + ", price: " + res.getInt(4));
                }
                //-----
                System.out.print("Select candy (Enter \"save\" if gift are ready):");
                String candyName = scan.next();
                if (candyName.equals("save")){
                    break;
                }
                String query = "0";
                ResultSet res1 = statement.executeQuery("select * from candies");
                while(res1.next()){
                    if(res1.getString(1).equals(candyName)){
                        query = "insert into gifts(name, candy, position) values ('"+ name + "','" + candyName +"'," + position+")";
                    }
                }
                if(query.equals("0")){
                    System.out.println("incorrect name of candy");
                }
                else
                    statement1.execute(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void sortGift() throws SQLException {
        Statement statement = worker.connection.createStatement();
        System.out.print("List of Gifts: ");
        ResultSet res = statement.executeQuery("select distinct name from gifts");
        while (res.next()){
            System.out.print(res.getString(1) + " ");
        }
        System.out.print("\nSelect gift: ");
        String giftName = scan.next();
        System.out.print("Available parameters for sorting of gift composition - ABC, sugar\nSorting by the: ");
        String param = scan.next();
        ResultSet res1 = null;
        if(param.equals("ABC")){
            res1 =  statement.executeQuery("select  * from gifts where gifts.name = '" + giftName +"' order by candy asc");
            while (res1.next()){
                System.out.println("Name: "+ res1.getString(2));
            }
        }
        if (param.equals("sugar")){
            res1 =  statement.executeQuery("select  * from gifts inner join candies on gifts.candy = candies.Name where gifts.name = '" + giftName +"' order by sugar asc ");
            while (res1.next()){
                System.out.println("Name: "+ res1.getString(2) + ", sugar content: " + res1.getInt(5));
            }
        }

    }

    static public void printGiftComposition() throws SQLException {
        ResultSet currentGift = findGift();
        while (currentGift.next()){
            System.out.println("Name: "+ currentGift.getString(2));
        }
        currentGift.first();
        Statement statement = worker.connection.createStatement();
        ResultSet res = statement.executeQuery("select sum(candies.price) from gifts inner join candies on gifts.candy = candies.Name where gifts.name = '" + currentGift.getString(1) + "'");
        while (res.next()) {
            System.out.println("Price of gift: " + res.getInt(1));
        }
    }

    static public void deleteGift() throws SQLException {
        Statement statement = worker.connection.createStatement();
        System.out.print("List of Gifts: ");
        ResultSet res = statement.executeQuery("select distinct name from gifts");
        while (res.next()){
            System.out.print(res.getString(1) + " ");
        }

        System.out.print("\nSelect gift for deleting: ");
        String giftName = scan.next();
        statement.execute("delete from gifts where name ='"+giftName+"'");
    }

    static public ResultSet findGift() throws SQLException {
        Statement statement = worker.connection.createStatement();
        System.out.print("List of Gifts: ");
        ResultSet res = statement.executeQuery("select distinct name from gifts");
        while (res.next()){
            System.out.print(res.getString(1)+ " ");
        }
        System.out.print("\nSelect gift: ");
        String giftName = scan.next();
        ResultSet res1 = statement.executeQuery("select * from gifts where name = '" +giftName+ "'");
        return res1;
    }
}