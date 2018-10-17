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

import java.util.Arrays;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.di.Instantiator;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * Main view layout for the application containing the dynamically built menu.
 */
@SuppressWarnings("serial")
@Theme(value = Lumo.class, variant = "dark")
@BodySize(height = "100%", width = "100%")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class ApplicationLayout extends VerticalLayout implements RouterLayout, BeforeLeaveObserver {

	private final MenuBar menuBar;

	/**
	 * Constructor.
	 */
	public ApplicationLayout() {
		System.out.println("#ApplicationLayout");
		menuBar = new MenuBar();
		init();
	}

	private void init() {
		add(menuBar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void beforeLeave(BeforeLeaveEvent event) {
		if (menuBar.isExternal(event.getNavigationTarget())) {
			Component routeTarget = getRouteTarget((Class<? extends Component>) event.getNavigationTarget());

			UI.getCurrent().getInternals().showRouteTarget(event.getLocation(),
					routeTarget.getClass().getAnnotation(Route.class).value(), routeTarget, Arrays.asList(this));
			((HasUrlParameter<?>) routeTarget).setParameter(event, null);
			event.postpone();
		}
	}

	@SuppressWarnings("unchecked")
	protected <T extends HasElement> T getRouteTarget(Class<T> routeTargetType) {
		UI ui = UI.getCurrent();
		Optional<HasElement> currentInstance = ui.getInternals().getActiveRouterTargetsChain().stream()
				.filter(component -> component.getClass().equals(routeTargetType)).findAny();
		return (T) currentInstance.orElseGet(() -> Instantiator.get(ui).createRouteTarget(routeTargetType, null));
	}
}
