package com.mycompany.myapp.GUI;

import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.util.Resources;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.plaf.Border;
import com.mycompany.myapp.entity.Game;
import java.io.IOException;

public class GameDetails extends Form {

    private Button acheterBtn;
    private SpanLabel description;
    private Label price;

    public GameDetails(Resources theme, Game game) {
        super(new BorderLayout());

        // Creation de Form
        Form form = new Form(game.getName(), new BorderLayout());
        Toolbar tb = new Toolbar();
        setToolbar(tb);
        tb.addCommandToLeftBar("back", null, (e) -> new GamesList(theme).showBack());

        // Create the ImageView component with the image
        ImageViewer imageView;
        try {
            imageView = new ImageViewer(Image.createImage(game.getImg()));
            // changer la taille de l'image
            imageView.setPreferredH(600);
            imageView.setPreferredW(200);
            form.add(BorderLayout.CENTER, imageView);

        } catch (IOException ex) {
            System.out.println("err" + ex.getMessage());
        }

        // Create a SpanButton
        description = new SpanLabel(game.getDescription());
        description.getAllStyles().setAlignment(Component.CENTER);

        price = new Label(game.getPrice() + " TND");
        price.setAlignment(Component.CENTER);

        // Create the "Buy" button
        acheterBtn = new Button("Buy");
        acheterBtn.addActionListener(e -> {
           Dialog.show("Succes", "item added successfully" , "OK", null);
        });

        // Add components to form
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        centerContainer.add(form);
        centerContainer.add(description);
        centerContainer.add(price);

        // Add the "Buy" button
        Container buttonContainer = new Container(new FlowLayout(Component.CENTER));
        buttonContainer.add(acheterBtn);

        add(BorderLayout.CENTER, centerContainer);
        add(BorderLayout.SOUTH, buttonContainer);
    }
}
