package com.techhub.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L; //serialID
    
    //here we create parameterized constructor to string message and just pass this ,sg to supperclass
	public ResourceNotFoundException(String message) {
        super(message);
    }
	//run time exception
    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);

    }
}
