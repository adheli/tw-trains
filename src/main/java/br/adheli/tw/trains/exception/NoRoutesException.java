package br.adheli.tw.trains.exception;

public class NoRoutesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1888920625800785314L;

	public NoRoutesException() {
		super("No route available. Should create some routes, hm?");
	}
}
