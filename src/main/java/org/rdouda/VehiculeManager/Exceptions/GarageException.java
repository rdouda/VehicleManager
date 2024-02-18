package org.rdouda.VehiculeManager.Exceptions;

/**
 * A custom exception class for errors related to garage operations.
 */
public class GarageException extends Exception {

    /**
     * Constructor to create a GarageException with a specific message.
     *
     * @param message The error message explaining the exception.
     */
    public GarageException(String message) {
        super(message); // Pass the message to the parent Exception class constructor
    }
}
