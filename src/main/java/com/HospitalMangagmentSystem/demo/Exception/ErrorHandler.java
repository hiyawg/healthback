package com.HospitalMangagmentSystem.demo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleResourceNotFound(DataNotFoundException exception) {


		return new ResponseEntity<>(
				ErrorMessage.builder()
						.title("not found")
						.status(HttpStatus.NOT_FOUND.value())
						.taimesmap(new Date())
						.message(exception.getMessage())
						.build(), HttpStatus.NOT_FOUND);


	}
}