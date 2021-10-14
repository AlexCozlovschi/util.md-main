package com.util.md.views.Tasks;

import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.content.Item;
import com.util.md.views.MainLayout;

import com.util.md.views.PersonalData.CCardFormView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;

/**
 * A Designer generated component for the tasks-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */

@Route(value = "taskView", layout = MainLayout.class)
@PermitAll


@UIScope
@SpringComponent
@EnableAutoConfiguration
public class TasksView extends VerticalLayout {
    public Tabs tabs;
    public Component pages;
    public Map<Tab, Component> tabsToPages = new HashMap<>();

    public TasksView(@Autowired ActiveTaskView activeTaskView, TaskFormView cCardFormView) {

        tabsPages(activeTaskView, cCardFormView);
        tabs.addSelectedChangeListener(event-> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs,pages);

    }
    public void tabsPages(ActiveTaskView activeTaskView, TaskFormView cCardFormView){

        Tab tab1 = new Tab("Active Tasks");
        Component page1 = activeTaskView;

        Tab tab2 = new Tab("Add Task");
        Component page2 = cCardFormView;

        // page2.setText("page 2");
        page2.setVisible(false);



        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);

        tabs = new Tabs(tab1, tab2);
        pages = new HorizontalLayout(page1, page2);

    }


        }


