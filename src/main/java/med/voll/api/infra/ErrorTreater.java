package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

// Annotation to treat errors automatically
@RestControllerAdvice
public class ErrorTreater {
//    To catch a specific error
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> treatError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationDataError>> treatError400(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationDataError::new).toList());
    }

    private record ValidationDataError(String field, String message) {
        public ValidationDataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
