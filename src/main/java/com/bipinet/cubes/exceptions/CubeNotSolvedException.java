package com.bipinet.cubes.exceptions;

public class CubeNotSolvedException extends Exception {
    public CubeNotSolvedException() {
        super();
    }

    public CubeNotSolvedException(String message) {
        super(message);
    }

    public CubeNotSolvedException(String message, 
                                  Throwable cause) {
        super(message, cause);
    }

    public CubeNotSolvedException(Throwable cause) {
        super(cause);
    }

    protected CubeNotSolvedException(String message, 
                                     Throwable cause, 
                                     boolean enableSuppression, 
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
