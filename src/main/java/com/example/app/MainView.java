package com.example.app;

import javax.inject.Inject;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    @Inject
    public MainView(GreetService greetService) {
	TextField textField = new TextField("Your name");

	Button button = new Button("Say hello", event -> {
	    String message = greetService.greet(textField.getValue());
	    Notification.show(message);
	});

	add(textField, button);
    }

}
