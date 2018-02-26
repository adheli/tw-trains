package br.adheli.tw.trains.exception;

public class NoSuchRouteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchRouteException() {
		super("NO SUCH ROUTE");
	}

}
