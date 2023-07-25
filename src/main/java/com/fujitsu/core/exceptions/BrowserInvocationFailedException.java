
package com.fujitsu.core.exceptions;

/**
 *
  * @version 1.0
 * @since 1.0
 */
@SuppressWarnings ("serial")
public class BrowserInvocationFailedException extends FrameworkException {

    /**
     *
     * @param message Details about the exception or custom message
     */
    public BrowserInvocationFailedException (String message) {
        super (message);
    }

    /**
     *
     * @param message Details about the exception or custom message
     * @param cause Pass the enriched stacktrace or customised stacktrace
     */
    public BrowserInvocationFailedException (String message, Throwable cause) {
        super (message, cause);
    }

}
