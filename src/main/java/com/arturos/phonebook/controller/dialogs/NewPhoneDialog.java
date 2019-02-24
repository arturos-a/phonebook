package com.arturos.phonebook.controller.dialogs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.stereotype.Component;



@Component
@UIScope
public class NewPhoneDialog extends VerticalLayout {

    public NewPhoneDialog() {

        setAlignItems(Alignment.CENTER);
        TextField firstName = new TextField();
        firstName.setLabel("First Name");

        add(firstName);
        TextField lastName = new TextField();
        lastName.setLabel("Last Name");

        add(lastName);
        TextField note = new TextField();
        note.setLabel("Note");

        add(note);

        TextField phone1 = new TextField();
        note.setLabel("Phone 1");

        add(phone1);

        TextField phone2 = new TextField();
        note.setLabel("Phone 2");

        add(phone2);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button back = new Button("Back");
        back.addClickListener(i->{
            getUI().ifPresent(e->e.navigate(PhoneListComponent.class));
        });

        horizontalLayout.add(back);

        Button save = new Button("Save");
        back.addClickListener(i->{
            getUI().ifPresent(e->e.navigate(PhoneListComponent.class));
        });

        horizontalLayout.add(save);

        add(horizontalLayout);

    }

}
