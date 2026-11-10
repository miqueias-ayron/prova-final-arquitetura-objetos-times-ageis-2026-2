package insper.prova.common;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> validation(MethodArgumentNotValidException ex) {
    ErrorResponseDTO response = new ErrorResponseDTO();
    for (org.springframework.validation.FieldError error : ex.getBindingResult().getFieldErrors())
      response.getErrors().add(error.getDefaultMessage());
    response.setStatus(400);
    response.setMessage("Erro de validação");
    return ResponseEntity.badRequest().body(response);
  }
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponseDTO> runtime(RuntimeException ex) {
    ErrorResponseDTO response = new ErrorResponseDTO();
    response.setStatus(404);
    response.setMessage(ex.getMessage());
    response.getErrors().add(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
