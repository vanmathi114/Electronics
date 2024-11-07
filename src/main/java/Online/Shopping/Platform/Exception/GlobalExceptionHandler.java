package Online.Shopping.Platform.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle ProductNotFound exception
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFound ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    // Handle DatabaseOperationException
    @ExceptionHandler(DatabaseOperationException.class)
    public ResponseEntity<String> handleDatabaseOperationException(DatabaseOperationException ex) {
        return new ResponseEntity<>("Database error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        // Custom response for Access Denied
        return new ResponseEntity<>("You do not have permission to access this resource", HttpStatus.FORBIDDEN);
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
