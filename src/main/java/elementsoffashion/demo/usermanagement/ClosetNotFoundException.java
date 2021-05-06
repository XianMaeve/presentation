package elementsoffashion.demo.usermanagement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "closet not found")
public class ClosetNotFoundException extends Exception {
}
