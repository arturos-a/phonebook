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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.List;

@Route("")
@UIScope
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
        grid.addItemClickListener(item -> getUI().ifPresent(ui ->
                ui.navigate(PersonForm.class,item.getItem().getId().toString())
        ));

        add(grid);


        this.personService = personService;
        this.newPhoneDialog = newPhoneDialog;

        Button button = new Button("New");
        button.addClickListener(event -> getUI().ifPresent(i->i.navigate("")));
        add(button);
    }

    private void showPhones(Person item) {

    }


}
