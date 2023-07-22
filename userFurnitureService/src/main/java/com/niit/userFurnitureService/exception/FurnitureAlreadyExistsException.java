package com.niit.userFurnitureService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Furniture already exist")
public class FurnitureAlreadyExistsException extends Exception {
}
