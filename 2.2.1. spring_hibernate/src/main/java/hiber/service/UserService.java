package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void add(User user, Car car);
    List<User> userCar(String model, String series);
    List<User> listUsers();

    User getOwner(String model, int series);

    public void getUserByModelAndSeries(String model, int series);
}
