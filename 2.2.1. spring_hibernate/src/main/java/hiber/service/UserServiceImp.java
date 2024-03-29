package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {

      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {

      userDao.add(user);
   }

   @Override
   public void add(User user, Car car) {

   }

   @Override
   public List<User> userCar(String model, String series) {
      return null;
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getOwner(String model, int series) {
      return null;
   }

   @Transactional
   @Override
   public void getUserByModelAndSeries(String model, int series) {
      userDao.getUserByModelAndSeries(model, series);
   }

}