/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class GamesList extends Form {

    public GamesList(Resources theme) {
        super(new BorderLayout());
        
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        // 2eme créer notre list des jeux
        ArrayList<Game> games = new ArrayList<>();
        // 3éme créer des instance pour notre jeux
        Game game1 = new Game("Devil May Cry 5", 200, "/dmc5.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game2 = new Game("Resident Evill VIII", 200, "/re8.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game3 = new Game("Need For Speed Heat", 100, "/nfs.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game4 = new Game("Red Dead Redemption II", 150, "/rdr2.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game5 = new Game("FIFA 22", 100, "/fifa.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game6 = new Game("Minecraft", 200, "/minecraft.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        // 4eme add all the games to the array list of games
        Collections.addAll(games, game1, game2, game3, game4, game5, game6);
        //5eme instance notre form avec box layout pour metre tous les element sur laxe de Y 
        Form f = new Form("G-Store Esprit", BoxLayout.y());
        for (Game game : games) {
            ImageViewer img = null;
            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            try {
                img = new ImageViewer(Image.createImage(game.getImg()));

            } catch (IOException ex) {
                System.out.println("err" + ex.getMessage());
            }
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Label name = new Label(game.getName());
            name.setWidth(60);
            name.setHeight(30);

            Label price = new Label(game.getPrice() + " TND");
            price.setWidth(100);
            price.setHeight(50);

            //ajouter les label pour note contaier sur laxe de y
            c2.add(name);
            c2.add(price);
            // ajouter notre image et lautre container sur laxe de x
            c1.add(img);
            c1.add(c2);
            
            // ajouter le container c1 pour notre form f 
            f.add(c1);

            f.refreshTheme(true);

        }
        add(BorderLayout.CENTER, f);

    }

}
