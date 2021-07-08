package com.example.app;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import javax.inject.Inject;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    @Inject
    public MainView(UserRepository userRepository) {
        Long count = userRepository.count();
        Notification.show("Users: " + count);

        Grid<User> grid = new Grid<>(User.class);
        grid.setColumns("email", "birthDate");
        grid.setItems(userRepository.findAll());

        TextField filter = new TextField();
        filter.setPlaceholder("Filter by email...");
        filter.addValueChangeListener(event -> {
            List<User> users = userRepository.findByEmailLike("%" + filter.getValue() + "%");
            grid.setItems(users);
        });


        add(filter, grid);
    }

}
