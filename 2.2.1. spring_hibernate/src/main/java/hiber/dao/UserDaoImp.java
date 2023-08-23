package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {

      sessionFactory.getCurrentSession().save(user);
      user.setUserCar(car);
   }

   @Override
   @Transactional
   public List<User> userCar(String model, String series) {


      String HQL="FROM User user WHERE user.userCar.model=:model and user.userCar.series=:series";
      System.out.println("метод в DAO выполнен");
      return sessionFactory.getCurrentSession().createQuery(HQL).setParameter("model", model).setParameter("series", series).getResultList();


   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
