package cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.exceptions;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
}
