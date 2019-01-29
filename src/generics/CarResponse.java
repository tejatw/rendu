package generics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CarResponse {

    private List<Car> cars;

    private List<Car> missingCars;
}
