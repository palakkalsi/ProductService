package dev.pkalsi.productservice.controlleradvice;

import dev.pkalsi.productservice.ProductNotFoundException;
import dev.pkalsi.productservice.dto.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDto nullPointerExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong");
        errorDto.setStatus("FAILED");
        return errorDto;
    }

    @ExceptionHandler
    public ErrorDto ProductNotFoundExceptionHandler(ProductNotFoundException ex){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(ex.getMessage());
        errorDto.setStatus("FAILED");
        return errorDto;
    }
}
