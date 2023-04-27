
public class NegativeNumberException extends RuntimeException{

	public NegativeNumberException() {
		super("Negative input.");

	}
	
	public NegativeNumberException(String mesg) {
		super (mesg);

	}

}