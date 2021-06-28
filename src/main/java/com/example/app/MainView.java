package com.example.app;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;

@Route("")
public class MainView extends VerticalLayout {

    @Inject
    public MainView(UserRepository userRepository) {
        Long count = userRepository.count();
        Notification.show("Users: " + count);
    }

}
