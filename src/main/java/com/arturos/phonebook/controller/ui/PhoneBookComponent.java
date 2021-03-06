package com.arturos.phonebook.controller.ui;

import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.service.PersonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.List;

@Route("")
@UIScope
public class PhoneBookComponent extends VerticalLayout {
    //Beans
    private final PersonService personService;

    @Autowired
    public PhoneBookComponent(@Qualifier("prodService") PersonService personService) {
        //Creating grid component
        this.personService = personService;

        //Create grid view
        Grid<Person> grid = new Grid<>(Person.class);
        //Get persons list from service
        List<Person> personList = this.personService.getPersonList();
        grid.setItems(personList);
        grid.setColumns("firstName","lastName");
        //Event listener in each row. Navigate to Person form
        grid.addItemClickListener(item -> getUI().ifPresent(ui ->
                ui.navigate(PersonForm.class,item.getItem().getId().toString())
        ));
        //Binding to layout
        add(grid);


        Button button = new Button("New");
        button.addClickListener(event -> getUI().ifPresent(ui->ui.navigate(PersonForm.class)));
        add(button);
    }


}
