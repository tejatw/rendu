package generics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonResponse {

    private List<Person> persons;

    private List<Person> missingPersons;
}
