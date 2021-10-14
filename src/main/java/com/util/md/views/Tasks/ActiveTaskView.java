package com.util.md.views.Tasks;

import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.content.Item;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.security.PermitAll;

@UIScope
@PermitAll
@SpringComponent
public class ActiveTaskView extends VerticalLayout {
    public ActiveTaskView() {
        RippleClickableCard card = new RippleClickableCard(
                componentEvent -> Notification.show("Ura"),
                new Item("tile", "descriptaszfxdgfhjhgkjkzscxdfghion")
        );
        card.setWidthFull();

        add(card);

    }
}
