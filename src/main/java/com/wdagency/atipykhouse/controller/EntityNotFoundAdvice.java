package com.wdagency.atipykhouse.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wdagency.atipykhouse.exception.EntityException;

@ControllerAdvice
class EntityNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(EntityException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(EntityException ex) {
    return ex.getMessage();
  }
}