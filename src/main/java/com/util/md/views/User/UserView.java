package com.util.md.views.User;

import com.util.md.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;

@PageTitle("User")
@Route(value ="userView", layout = MainLayout.class)
@PermitAll

@UIScope
@SpringComponent
@EnableAutoConfiguration

public class UserView extends VerticalLayout {

    public Tabs tabs;
    public Component pages;
    public Map<Tab, Component> tabsToPages = new HashMap<>();


    public UserView(@Autowired UserDataView userDataView, UserRegistrationView userDataChangeView) {

        tabsPages(userDataView, userDataChangeView);
        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs,pages);
    }

    public void tabsPages(UserDataView userDataView,
            UserRegistrationView userDataChangeView){

        Tab tab1 = new Tab("Personal Data");
        Component page1 = userDataView;

        Tab tab2 = new Tab("Change Data");
        Component page2 = userDataChangeView;
        page2.setVisible(false);

        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);

        tabs = new Tabs(tab1, tab2);
        pages = new HorizontalLayout(page1, page2);
    }
}
