package generics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private Integer personId;

    private String personName;

    /*public void Person(Integer employeeId, String employeeName) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }*/
}
