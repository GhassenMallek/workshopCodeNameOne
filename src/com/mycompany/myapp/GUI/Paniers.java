package com.mycompany.myapp.GUI;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import static com.codename1.io.Util.cleanup;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.GUI.GameMultilist;
import com.mycompany.myapp.entity.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paniers extends Form {

    EncodedImage enc;
    Image img = null;

    private static ArrayList<Game> basket = new ArrayList<>();

    public Paniers(Resources theme) {
        Toolbar tb = new Toolbar();
        setToolbar(tb);
        tb.addCommandToLeftBar("Back", null, e -> new GameMultilist(theme).showBack());

        ArrayList<Map<String, Object>> gamesList = new ArrayList<>();
        try {
            Database db = Database.openOrCreate("G-Store.db");
            Cursor cur = db.executeQuery("SELECT * FROM games");

            //  Cursor cursor = database.executeQuery("SELECT * FROM games");
            while (cur.next()) {
                String name = cur.getRow().getString(0);
                String price = cur.getRow().getString(1);
                String urlImg = cur.getRow().getString(2);
                Game game = new Game(name, price, urlImg);
                gamesList.add(createListEntry(name, price, urlImg));
            }
            DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(gamesList);
            MultiList ml = new MultiList(model);
            ml.addSelectionListener(new SelectionListener() {
                @Override
                public void selectionChanged(int oldSelected, int newSelected) {
                    // Get the selected game's details from the data
                    if (gamesList.size() > 0) {
                        Map<String, Object> selectedEntry = gamesList.get(newSelected);
                        
                        System.out.println("delete from games where name = '" + selectedEntry.get("Line1") + "'");
                        try {
                            Database.openOrCreate("G-Store.db").execute("delete from games where name = '" + selectedEntry.get("Line1") + "'");

                        } catch (IOException ex) {
                            System.out.println("error 61 " + ex);
                        }

                    }
                }
            });
            add(ml);

        } catch (IOException ex) {
            System.out.println(ex);
        }

        // basket.addAll(gamesList);
    }

    private Map<String, Object> createListEntry(String name, String price, String urlImg) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", price + " TND");
        // You can set the "icon" entry with the image associated with the game
        entry.put("icon", GetImage(urlImg)); // Assuming theme contains the images
        Game game = new Game(name, price, GetImage(urlImg).toString());
        entry.put("game", game); // Store the Game object for later retrieval
        return entry;
    }

    private Image GetImage(String url) {
        Image img = null;
        try {
            img = Image.createImage(url);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return img;
    }
}
