package fi.haagahelia.pizza.exceptions;

public class TuoteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1246103173814828219L;
	private String tuoteId;

	public TuoteNotFoundException(String id) {
		tuoteId = id;
	}

	public String haeTuoteTunnuksella() {
		return tuoteId;
	}
}
