/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;


import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.list.DefaultListModel;
import com.mycompany.myapp.entity.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMultilist extends Form {

    public GameMultilist(Resources theme) {
        super( new BorderLayout());
 Toolbar tb =new Toolbar();
      setToolbar(tb);
      tb.addCommandToLeftBar("List view",null, (e) -> new GamesList(theme).showBack());
        ArrayList<Map<String, Object>> data = new ArrayList<>();

        // Create your Game objects with resource paths
     Game game1 = new Game("Devil May Cry 5", 200, "/dmc5.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game2 = new Game("Resident Evill VIII", 200, "/re8.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game3 = new Game("Need For Speed Heat", 100, "/nfs.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game4 = new Game("Red Dead Redemption II", 150, "/rdr2.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game5 = new Game("FIFA 22", 100, "/fifa.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game6 = new Game("Minecraft", 200, "/minecraft.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        
        // Add your Game objects to the data list
        data.add(createListEntry(game1));
        data.add(createListEntry(game2));
        data.add(createListEntry(game3));
        data.add(createListEntry(game4));
        data.add(createListEntry(game5));
        data.add(createListEntry(game6));

        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);
        add(BorderLayout.CENTER, ml);

        // Add a selection listener to the MultiList
        ml.addSelectionListener(new SelectionListener() {
            @Override
            public void selectionChanged(int oldSelected, int newSelected) {
                // Get the selected game's details from the data
                Map<String, Object> selectedEntry = data.get(newSelected);
                Game selectedGame = (Game) selectedEntry.get("game"); // Assuming you store the Game object in the entry

                // Navigate to the GameDetails form with the selected game's details
                new GameDetails(theme, selectedGame).show();
            }
        });
    }

    private Map<String, Object> createListEntry(Game game) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", game.getName());
        entry.put("Line2", game.getPrice() + " TND");
        try {
            // You can set the "icon" entry with the image associated with the game
            entry.put("icon", Image.createImage(game.getImg())); // Assuming theme contains the images
        } catch (IOException ex) {
            System.out.println(ex);
        }
        entry.put("game", game); // Store the Game object for later retrieval
        return entry;
    }
}
