package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public class CarRepository implements Repository<Car> {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    public Car create(Car car){
        if (car.getCarId() == null){
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }

    public List<Car> findAll(){
        return carData;
    }

    public Car findById(String id){
        for (Car car: carData){
            if (car.getCarId().equals(id)){
                return car;
            }
        }
        return null;
    }

    public Car update(String id, Car updatedCar){
        for (int i=0; i<carData.size(); i++){
            Car car = carData.get(i);
            if(car.getCarId().equals(id)){
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
            }
        }
        return null;
    }

    public Car delete(String id){
        for(Car car: carData){
            if(car.getCarId().equals(id)){
                carData.remove(car);
                return car;
            }
        }
        return null;
    }
}
