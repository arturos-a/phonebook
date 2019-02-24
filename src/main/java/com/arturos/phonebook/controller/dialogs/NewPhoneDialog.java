package com.arturos.phonebook.controller.dialogs;

import com.arturos.phonebook.dto.PersonUi;
import com.arturos.phonebook.entity.Person;
import com.arturos.phonebook.service.PersonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
@UIScope
public class NewPhoneDialog extends VerticalLayout {
    @Autowired
    @Qualifier("mockService")
    private PersonService personService;

    public NewPhoneDialog() {

        Binder<PersonUi> binder = new Binder<>(PersonUi.class);
        PersonUi person = new PersonUi();

        setAlignItems(Alignment.CENTER);
        TextField firstName = new TextField();
        firstName.setLabel("First Name");

        add(firstName);
        binder.forField(firstName).bind(PersonUi::getFirstName,PersonUi::setFirstName);

        TextField lastName = new TextField();
        lastName.setLabel("Last Name");

        add(lastName);

        binder.forField(lastName).bind(PersonUi::getLastName,PersonUi::setLastName);

        TextField note = new TextField();
        note.setLabel("Note");

        add(note);
        binder.forField(note).bind(PersonUi::getNote,PersonUi::setNote);

        TextField phone1 = new TextField();
        note.setLabel("Phone 1");

        add(phone1);

        TextField phone2 = new TextField();
        note.setLabel("Phone 2");

        add(phone2);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button back = new Button("Back");
        back.addClickListener(i->{
            getUI().ifPresent(e->e.navigate(PhoneBookComponent.class));
        });

        horizontalLayout.add(back);

        Button save = new Button("Save");
        save.addClickListener(i->{
            try {
                binder.writeBean(person);
                // A real application would also save the updated person
                // using the application's backend
                personService.savePerson(Person.createPerson(person));
            } catch (ValidationException e) {
                System.out.println(e);
            }
        });

        horizontalLayout.add(save);

        add(horizontalLayout);

    }

}
