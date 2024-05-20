package pro.sky.skyprocollectionsversion2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.w3c.dom.ranges.RangeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeuserNotEnterFirstOrLastNameInformationException extends RuntimeException {

}
