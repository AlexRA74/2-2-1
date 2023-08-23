package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      System.out.println("бин создан");

      User user1 = new User("Aleks", "Russ", "Rail@nemail.rucom");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      System.out.println("пользователи созданы");

      Car car1 = new Car("BMW", "5");
      Car car2 = new Car("Mini-R", "2");
      Car car3 = new Car("Lada", "2104");
      System.out.println("машины созданы");

      userService.add(user1, car2);
      userService.add(user2, car1);
      userService.add(user3, car3);
      System.out.println("пользователь + машина добавлена в список");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car: "+user.getUserCar());
         System.out.println();
      }
      System.out.println("лист пользователь выведен");

      System.out.println(userService.userCar("Lada", "Granta"));
      System.out.println("пользователь с машиной найден");

      context.close();
   }
}
