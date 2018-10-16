package co.dporn.vaadin.muksihs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view of the application
 */
@SuppressWarnings("serial")
@Route(value="", layout=DpornVerticalLayout.class)
public class DpornVaadinView extends VerticalLayout {

    public DpornVaadinView() {
        setClassName("app-view");

        Label hello = new Label("Hello Gradle app!");
        add(hello);

        Button button = new Button("Click me", event -> {
            hello.setText("Clicked!");
            hello.setClassName("clicked");
        });
        add(button);
    }
}