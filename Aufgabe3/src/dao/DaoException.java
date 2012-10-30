package dao;

/**
 * Exception class for Dao-Layer
 * Daos should only throw this Exception (and map all other Exceptions to DaoException)
 * 
 * @author Simon
 * 
 */
public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public DaoException()
	{
		super();
	}

	public DaoException(String message)
	{
		super(message);
	}

	public DaoException(Throwable cause)
	{
		super(cause);
	}

	public DaoException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
