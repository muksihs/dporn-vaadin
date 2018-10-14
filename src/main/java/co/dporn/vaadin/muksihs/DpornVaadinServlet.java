package co.dporn.vaadin.muksihs;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/*", name = "DpornVaadinServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = DpornVaadinUI.class, productionMode = false)
public class DpornVaadinServlet extends VaadinServlet { }