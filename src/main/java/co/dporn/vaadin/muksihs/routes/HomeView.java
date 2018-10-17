package co.dporn.vaadin.muksihs.routes;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import co.dporn.vaadin.muksihs.routes.layouts.ApplicationLayout;

/**
 * The main view of the application
 */
@SuppressWarnings("serial")
@Route(value="", layout=ApplicationLayout.class)
public class HomeView extends VerticalLayout {
    public HomeView() {
    	System.out.println("#HomeView");
    	Label hello = new Label("Home");
    	add(hello);
    }
}