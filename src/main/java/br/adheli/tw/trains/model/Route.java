package br.adheli.tw.trains.model;

/**
 * Model class for a Route
 * @author adheli.tavares
 *
 */
public class Route {

	private String cityStart;
	private String cityEnd;
	private int distance;

	public Route(String c1, String c2) {
		this.cityStart = c1;
		this.cityEnd = c2;
	}

	public Route(String route) {
		this.cityStart = route.substring(0, 1);
		this.cityEnd = route.substring(1, 2);
		this.distance = Integer.parseInt(route.substring(2));
	}

	public String getCityStart() {
		return cityStart;
	}

	public void setCityStart(String cityStart) {
		this.cityStart = cityStart;
	}

	public String getCityEnd() {
		return cityEnd;
	}

	public void setCityEnd(String cityEnd) {
		this.cityEnd = cityEnd;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getRoute() {
		return this.cityStart.concat(this.cityEnd);
	}

	@Override
	public String toString() {
		return this.cityStart.concat(this.cityEnd).concat(String.valueOf(this.distance));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityEnd == null) ? 0 : cityEnd.hashCode());
		result = prime * result + ((cityStart == null) ? 0 : cityStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (cityEnd == null) {
			if (other.cityEnd != null)
				return false;
		} else if (!cityEnd.equals(other.cityEnd))
			return false;
		if (cityStart == null) {
			if (other.cityStart != null)
				return false;
		} else if (!cityStart.equals(other.cityStart))
			return false;
		return true;
	}
	
	public boolean sameRoute(Route route) {
		if (route != null) {			
			return getRoute().equals(route.getRoute());
		} else return false;
	}
}
