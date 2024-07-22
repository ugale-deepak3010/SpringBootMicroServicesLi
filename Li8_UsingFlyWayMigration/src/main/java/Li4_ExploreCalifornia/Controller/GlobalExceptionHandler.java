package Li4_ExploreCalifornia.Controller;

import java.util.NoSuchElementException;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException noSuchElementException,
			WebRequest webRequest) {

		log.error("Error is 1: "+noSuchElementException.getMessage());
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
				noSuchElementException.getMessage());

		return createResponseEntity(problemDetail, null, HttpStatus.NOT_FOUND, webRequest);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException,
			WebRequest webRequest) {

		log.error("Error is 2: "+resourceNotFoundException.getMessage());
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
				resourceNotFoundException.getMessage());

		return createResponseEntity(problemDetail, null, HttpStatus.NOT_FOUND, webRequest);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> anyOtherException(Exception e, WebRequest webRequest) {

		log.error("Error is: "+e.getMessage());
		
		
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				e.getMessage());

		return createResponseEntity(problemDetail, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);

	}
}
