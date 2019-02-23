package com.arturos.phonebook.controller.dialogs;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.service.PersonService;
import com.arturos.phonebook.service.PersonServiceMock;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Route("")
public class PhoneListComponent extends VerticalLayout {
    //Beans
    private final PersonService personService;
    private NewPhoneDialog newPhoneDialog;

    @Autowired
    public PhoneListComponent(@Qualifier("mockService") PersonService personService, NewPhoneDialog newPhoneDialog) {
        Grid<Person> grid = new Grid<>(Person.class);
        List<Person> personList = personService.getPersonList();
        grid.setItems(personList);
        grid.setColumns("firstName","lastName");

        add(grid);
        this.personService = personService;
        this.newPhoneDialog = newPhoneDialog;

        Dialog dialog = (Dialog) newPhoneDialog.getDialog();
        add(dialog);

        Button button = new Button("Add");
        button.addClickListener(event -> dialog.open());
        add(button);
    }



}
