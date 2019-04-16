package dcj.ors.mj.exceptions;

public class Non200ReturnException extends Exception {

	/**
	 * This class is used to catch an exception for when the datawarehouse returns a non 200 response. 
	 */
	private static final long serialVersionUID = 2L;

	public Non200ReturnException() {
		// TODO Auto-generated constructor stub
	}

	public Non200ReturnException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Non200ReturnException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public Non200ReturnException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public Non200ReturnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
