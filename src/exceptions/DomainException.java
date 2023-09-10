package exceptions;

@SuppressWarnings("serial")
public class DomainException extends Exception{
	public DomainException(String Message) {
		super(Message);
	}
}
