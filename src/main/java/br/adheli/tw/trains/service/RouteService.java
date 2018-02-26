package br.adheli.tw.trains.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import br.adheli.tw.trains.exception.NoSuchRouteException;
import br.adheli.tw.trains.model.Route;

public class RouteService {

	private List<Route> routes;

	/**
	 * Method for reading the routes and organizing them
	 * 
	 * @param strRoutes
	 *            Must be received as one letter for each city (where the route
	 *            begins and where it ends) and a number for the distance The comma
	 *            is used as split parameter.
	 * @return a List of Route class
	 */
	public List<Route> insertRoutes(String strRoutes) {
		this.routes = new ArrayList<Route>();

		if (strRoutes == null || strRoutes.isEmpty()) {
			throw new IllegalArgumentException("The routes must be informed");
		} else {
			strRoutes = strRoutes.toUpperCase();
			List<String> rawRoutes = Arrays.asList(strRoutes.split(","));

			for (String string : rawRoutes) {
				string = string.replace(" ", "");
				if (!string.isEmpty() && string.length() > 2) {
					this.routes.add(new Route(string));
				}
			}
		}

		return this.routes;
	}

	/**
	 * Calculates the distance for a travel between multiples cities If there isn't
	 * a route between two cities sequentially, a NoSuchRouteException is issued.
	 * 
	 * @param cities
	 *            Must be informed as a string, one letter for city, separated only
	 *            by "-" The hyphen is used as split parameter.
	 * @return
	 */
	public int distance(String cities) {
		int distance = 0;

		if (cities.isEmpty()) {
			throw new IllegalArgumentException(
					"The cities you need to calculate the distance between must be informed");
		} else {
			String[] rawCities = cities.split("-");

			for (int i = 0; i < rawCities.length; i++) {
				int j = i;

				if (i + 1 < rawCities.length) {
					j = i + 1;

					Route route = this.findRoute(new Route(rawCities[i], rawCities[j]));

					if (route != null) {
						distance += route.getDistance();
					} else {
						throw new NoSuchRouteException();
					}
				}
			}
		}

		return distance;
	}

	/**
	 * Finds a route between two cities
	 * 
	 * @param input
	 * @return a Route object if there is such route or null if there isn't a way
	 *         between the two cities.
	 */
	private Route findRoute(Route input) {
		try {
			return this.routes.stream().filter(route -> route.sameRoute(input)).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	// TODO - I didn't find a solution to get the route chain.
	public List<String> makeTravels(String cityStart, String cityEnd, int stops) {

		List<String> probRoutes = new ArrayList<>();

		String travel = "";
		while (stops > 0) {
			Route route = this.findRouteByCityStart(cityStart);
			travel = travel.concat(route.getCityStart() + "-");

			if (route != null) {

			}
		}

		return probRoutes;
	}

	private Route findRouteByCityStart(String cityStart) {
		try {
			return this.routes.stream().filter(route -> route.getCityStart().equals(cityStart)).findAny().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}
