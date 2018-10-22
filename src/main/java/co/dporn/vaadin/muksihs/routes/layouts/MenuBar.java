/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package co.dporn.vaadin.muksihs.routes.layouts;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;

/**
 * Menu that is dynamically populated from registered routes.
 */
@SuppressWarnings("serial")
public class MenuBar extends Div {

    /**
     * Constructor that collects the routes and builds the menu.
     */
    public MenuBar() {
    	System.out.println("#MenuBar");
    	init();
    }
    
    @Override
    protected void onAttach(AttachEvent attachEvent) {
    	super.onAttach(attachEvent);
    }

    private void init() {
        setId("menu");
        this.addClassName("topnav");
        Div logo = new Div();
        logo.setText(" ");
        logo.setClassName("logo");
		add(logo);
		Anchor a = new Anchor();
		a.setText("OPTION 1");
    }
}
