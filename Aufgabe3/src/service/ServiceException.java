package service;

/**
 * @author Simon
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = -5532751923084103006L;

	public ServiceException()
	{
		super();
	}

	public ServiceException(String message)
	{
		super(message);
	}

	public ServiceException(Throwable cause)
	{
		super(cause);
	}

	public ServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
