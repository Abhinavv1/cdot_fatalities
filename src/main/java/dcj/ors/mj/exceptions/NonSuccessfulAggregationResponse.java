package dcj.ors.mj.exceptions;

public class NonSuccessfulAggregationResponse extends Exception {

	/**
	 * This class is used to catch an exception for when the datawarehouse aggregation does not return the message "successful"
	 */
	private static final long serialVersionUID = 3L;

	public NonSuccessfulAggregationResponse() {
		// TODO Auto-generated constructor stub
	}

	public NonSuccessfulAggregationResponse(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NonSuccessfulAggregationResponse(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NonSuccessfulAggregationResponse(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NonSuccessfulAggregationResponse(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
