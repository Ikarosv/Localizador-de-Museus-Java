package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * controllerAdvice.
 */
@ControllerAdvice
public class HandleAdvice {

  /**
   * handleExceptionCoordinate.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleExceptionCoordinate(InvalidCoordinateException error) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  /**
   * handleExceptionMuseum.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public  ResponseEntity<String> handleExceptionMuseum(MuseumNotFoundException error) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  /**
   * handleException.
   */
  @ExceptionHandler
  public ResponseEntity<String> handleException(Exception error) {
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}