package com.util.md.views.masterManager;

import com.util.md.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@PageTitle("Master Manager")
@Route(value = "masterView", layout = MainLayout.class)
@RolesAllowed("ROLE_ADMIN")
@UIScope
@SpringComponent
@EnableAutoConfiguration

public class MasterView extends VerticalLayout {

    public Tabs tabs;
    public Component pages;
    public Map<Tab, Component> tabsToPages = new HashMap<>();

    public MasterView(@Autowired MasterRegistrationView masterRegistrationView) {

        tabsPages(masterRegistrationView);
        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs,pages);
    }

    public void tabsPages(MasterRegistrationView masterRegistrationView){
        Tab tab1 = new Tab("User Registration");
        Component page1 = masterRegistrationView;

        Tab tab2 = new Tab("Master List");
        Div page2 = new Div();
        page2.setText("Page#2");
        page2.setVisible(false);

        Tab tab3 = new Tab("Tab three");
        Div page3 = new Div();
        page3.setText("Page#3");
        page3.setVisible(false);

        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);

        tabs = new Tabs(tab1, tab2, tab3);
        pages = new HorizontalLayout(page1, page2, page3);
    }
}
