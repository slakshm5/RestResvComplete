package solutions.egen.exceptions;

public class AppException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AppException (String msg){
		super();
	}
	public AppException(String msg, Throwable cause){
		super(msg, cause);
	}
}
