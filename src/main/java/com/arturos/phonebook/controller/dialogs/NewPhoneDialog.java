package com.arturos.phonebook.controller.dialogs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;



@Component
public class NewPhoneDialog {
    Dialog dialog = new Dialog();

    public NewPhoneDialog() {
        Button addBut = new Button("Добавить");

        TextField firstName = new TextField();
        firstName.setId("firstname");
        firstName.setLabel("First Name");
        firstName.setPlaceholder("Enter Firstname");


        TextField lastName = new TextField();
        lastName.setId("lastname");
        lastName.setLabel("Last Name");
        lastName.setPlaceholder("Enter Lastname");

        dialog.add(firstName);
        dialog.add(lastName);

        dialog.add(addBut);

        NativeButton cancelButton = new NativeButton("Cancel", event -> {
            dialog.close();
        });

        dialog.add(cancelButton);


        dialog.setCloseOnOutsideClick(false);
        dialog.setCloseOnEsc(true);
    }

    com.vaadin.flow.component.Component getDialog () {
        return dialog;
    }
}
