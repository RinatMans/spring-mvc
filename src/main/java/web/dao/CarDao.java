package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private List<Car> car;

    {
        car = new ArrayList<>();
        car.add(new Car("vw", "golf", 210));
        car.add(new Car("kia", "ceed", 200));
        car.add(new Car("bugatti", "veyron", 410));
        car.add(new Car("tesla", "model 3", 261));
        car.add(new Car("toyota", "avensis 4", 200));

    }

    public List<Car> getCars() {
        return car;
    }

    public List<Car> show(int count) {
        return car.stream().limit(count).collect(Collectors.toList());

    }

}
