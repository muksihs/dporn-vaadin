package co.dporn.vaadin.muksihs;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@SuppressWarnings("serial")
@HtmlImport("frontend://styles/dpornvaadin-theme.html")
@Theme(value = Lumo.class, variant = "dark")
public class DpornVaadinUI extends UI {
	public DpornVaadinUI() {
		System.out.println("#DpornVaadinUI");
	}
}
