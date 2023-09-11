package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }


   @Override
   public void add(User user) {

   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void getUserByModelAndSeries(String model, int series) {
      Session session = sessionFactory.openSession();
      try (session) {
         String HQL = "from Car c left join c.user where c.model=:model and c.series=:series";
         Car car = session.createQuery(HQL, Car.class)
                 .setParameter("model", model).setParameter("series", series).getSingleResult();
//         User user = car.getUser();
//         System.out.println(user);
      } catch (RuntimeException e) {
         System.out.println("Warning! User with car " + model + " " + series + " is not found");
      }
   }

}