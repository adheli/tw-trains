package br.adheli.tw.trains.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import br.adheli.tw.trains.exception.NoRoutesException;
import br.adheli.tw.trains.exception.NoSuchRouteException;
import br.adheli.tw.trains.model.Route;

/**
 * 
 * @author adheli.tavares
 *
 */
public class RouteService {

	private List<Route> routes;

	public List<Route> getRoutes() {
		if (this.routes == null || this.routes.isEmpty())
			throw new NoRoutesException();

		return routes;
	}

	public List<Route> readInRawRoutes(String strRoutes) {
		this.routes = new ArrayList<Route>();

		if (strRoutes == null || strRoutes.isEmpty()) {
			throw new IllegalArgumentException("The routes must be informed");
		} else {
			strRoutes = strRoutes.toUpperCase();
			List<String> rawRoutes = Arrays.asList(strRoutes.split(","));

			for (String raw : rawRoutes) {
				this.insertRoute(raw);

			}
		}

		return this.routes;
	}

	public void insertRoute(String rawRoute) {
		rawRoute = rawRoute.replace(" ", "");

		if (!rawRoute.isEmpty() && rawRoute.length() > 2) {
			Route route = new Route(rawRoute);

			if (this.findDuplicate(route) == null) {
				this.routes.add(route);
			}
		}
	}

	public int getRouteDistance(Route route) {
		route = this.findRoute(route);
		return route.getDistance();
	}

	private Route findDuplicate(Route input) {
		try {
			return this.routes.stream().filter(route -> route.equals(input)).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Route findRoute(Route input) {
		try {
			return this.routes.stream().filter(route -> route.sameRoute(input)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchRouteException();
		}
	}

	public Route findRouteByCityStart(String cityStart) {
		try {
			return this.routes.stream().filter(route -> route.getCityStart().equals(cityStart)).findAny().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}
