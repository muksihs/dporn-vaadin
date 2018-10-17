package co.dporn.vaadin.muksihs;

import javax.servlet.annotation.WebServlet;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/*", name = "DpornVaadinServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = DpornVaadinUI.class, productionMode = false)
public class DpornVaadinServlet extends VaadinServlet { }