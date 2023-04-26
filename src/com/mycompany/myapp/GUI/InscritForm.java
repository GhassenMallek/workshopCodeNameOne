/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.*;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author macbookpro
 */
public class InscritForm  extends Form{
    
    //Déclaration des variables
    private TextField usernameField;
    private TextField emailField;
    private TextField passwordField;
    
    private TextArea adresseField;
    private Button annulerButton;
    private Button inscritButton;
    
    private Picker dateDeNField;
    
    public InscritForm(Resources theme) {
        super(new BorderLayout());
        
        //Creation de Form
        Form form = new Form("Inscription", new BorderLayout());
        
        // Load an image from the resources
        Image image = theme.getImage("minecraft.jpg");
        
        // Create the ImageView component with the image
        ImageViewer imageView = new ImageViewer(image);
        
        //changer la taille de l'image
        imageView.setPreferredH(600);
        imageView.setPreferredW(200);
      
        form.add(BorderLayout.CENTER, imageView); 
        
        // Create UI components
        emailField = new TextField("", "Email", 20, TextField.ANY);
        passwordField = new TextField("", "mot de passe", 20, TextField.PASSWORD);
        usernameField = new TextField("", "Username", 20, TextField.ANY);
        
        dateDeNField = new Picker();
        dateDeNField.setType(Display.PICKER_TYPE_DATE);
        
        adresseField = new TextArea();
        adresseField.setRows(5);
        adresseField.setHint("Adresse de facturation");
        
        
        // Create a container for the buttons
        Container buttonContainer = new Container(new FlowLayout(CENTER));
        
        // Create a "Inscrit" button
        inscritButton = new Button("S'inscrire");
        inscritButton.getAllStyles().setBorder(Border.createEmpty());
        inscritButton.getAllStyles().setBgTransparency(255);
        inscritButton.getAllStyles().setBgColor( 0x2196F3);
        inscritButton.getAllStyles().setFgColor(0xFFFFFF);
        inscritButton.getAllStyles().setMargin(10, 10, 10, 10);
        
       
        
        // Add the "Inscrit" button to the button container
        buttonContainer.add(inscritButton);
        
        // Create a "Annuler" button
        annulerButton = new Button("Annuler");
        annulerButton.getAllStyles().setBorder(Border.createEmpty());
        annulerButton.getAllStyles().setBgTransparency(255);
        annulerButton.getAllStyles().setBgColor( 0x2196F3);
        annulerButton.getAllStyles().setFgColor(0xFFFFFF);
        annulerButton.getAllStyles().setMargin(10, 10, 10, 10);
        
        
        //validator 
        Validator validator = new Validator();
        validator.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
        validator.addConstraint(emailField, RegexConstraint.validEmail());
        validator.addConstraint(passwordField, new LengthConstraint(6));
        validator.addConstraint(usernameField, new LengthConstraint(6));
        validator.addConstraint(dateDeNField, new LengthConstraint(6));
        validator.addConstraint(adresseField, new LengthConstraint(6));
        
         // Add an action listener to the "Inscrit" button
        inscritButton.addActionListener(e -> {
            // TODO: handle sign up logic
            if (validator.isValid()) {
             Dialog.show("Validation Succes", "formulaire bien saisire" , "OK", null);
              
            } else {
                Dialog.show("Validation Error", "Vérifier les champs" , "OK", null);
            }
        });
        
        // Add an action listener to the "Annuler" button
        annulerButton.addActionListener(e -> {
            // TODO: handle cancel logic
            new LoginForm(theme).showBack();
        });
        
        // Add the "Annuler" button to the button container
        buttonContainer.add(annulerButton);
       
         // Add components to form
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        centerContainer.add(form);
        centerContainer.add(usernameField);
        centerContainer.add(emailField);
        centerContainer.add(passwordField);
        centerContainer.add(dateDeNField);
        centerContainer.add(adresseField);
        centerContainer.add(buttonContainer);
        
        add(BorderLayout.CENTER, centerContainer);
        

    }
    
}
