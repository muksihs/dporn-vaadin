package co.dporn.vaadin.muksihs.routes;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import co.dporn.vaadin.muksihs.routes.layouts.ApplicationLayout;

/**
 * The main view of the application
 */
@SuppressWarnings("serial")
@Route(value="about", layout=ApplicationLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
    	System.out.println("#AboutView");
        setClassName("app-view");
        Label hello = new Label("About!");
        add(hello);
    }
}