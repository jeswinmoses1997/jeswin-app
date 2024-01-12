package org.example.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@Stateless
public class LaptopService {
    @PersistenceContext(unitName = "merlin")
    EntityManager entityManager;

    public void saveLaptop(int id, String model, int capacity, int price) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Laptop object = new Laptop();
        object.setId(id);
        object.setModel(model);
        object.setCapacity(capacity);
        object.setPrice(price);

        entityManager.persist(object);
        entityManager.flush();
    }

    public Laptop createLaptop(LaptopVO laptopVO) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, java.sql.SQLIntegrityConstraintViolationException {
                Laptop object = new Laptop();
                object.setId(laptopVO.getId());
                object.setModel(laptopVO.getModel());
                object.setCapacity(laptopVO.getCapacity());
                object.setPrice(laptopVO.getPrice());

                entityManager.persist(object);
                entityManager.flush();

                return object;
    }

    public Laptop getLaptop(int id){
        Laptop object1 = entityManager.find(Laptop.class,id);
        return object1;
    }
    public Laptop updateLaptop(int id, int price){
        Laptop object2 = entityManager.find(Laptop.class,id);
        object2.setPrice(price);
        entityManager.merge(object2);
        return object2;
    }
    public boolean deleteLaptop(int id){
        Laptop object3 = entityManager.find(Laptop.class,id);
        if (object3!=null){
            entityManager.remove(object3);
            return true;
        }else {
            return false;
        }
    }
}
