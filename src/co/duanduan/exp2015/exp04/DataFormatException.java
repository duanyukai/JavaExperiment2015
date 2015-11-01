package co.duanduan.exp2015.exp04;


import co.duanduan.exp2015.exp01.*;
import co.duanduan.exp2015.exp02.*;
import co.duanduan.exp2015.exp03.*;

/**
 * This exception is thrown when malformed data is detected while
 * a file being parsed.
 *
 * @author iCarnegie
 * @version 1.0.0
 */
public class DataFormatException extends Exception  {

	/**
	 * Constructs a <code>DataFormatException</code> with no detail
	 * message.
	 */
	public DataFormatException() {

	}

	/**
	 * Constructs a <code>DataFormatException</code> with the
	 * specified detail message.
	 *
	 * @param message  the malformed data
	 */
	public DataFormatException(String message) {

		super(message);
	}
}
