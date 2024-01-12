package org.example.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@Stateless
public class PersonsService {
    @PersistenceContext(unitName = "jeswin")
    EntityManager entityManager;

//  CRUD

    public void savePersons(int id, String lastName, String firstName, String address, String city) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

//        entityManager.getTransaction().begin();

        Persons object = new Persons();
        object.setPersonID(id);
        object.setLastName(lastName);
        object.setFirstName(firstName);
        object.setAddress(address);
        object.setCity(city);

        entityManager.persist(object);
        entityManager.flush();
//        entityManager.getTransaction().commit();
    }

    public Persons createPersons(PersonsVO personsVO) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

//        entityManager.getTransaction().begin();

        Persons object = new Persons();
        object.setPersonID(personsVO.getPersonID());
        object.setLastName(personsVO.getLastName());
        object.setFirstName(personsVO.getFirstName());
        object.setAddress(personsVO.getAddress());
        object.setCity(personsVO.getCity());

        entityManager.persist(object);
        entityManager.flush();
//        entityManager.getTransaction().commit();
        return object;
    }

    public Persons getPerson(int id){
        Persons object1 = entityManager.find(Persons.class,id);
        return object1;
    }
    public Persons updatePerson(int id, String firstName){
        Persons object2 = entityManager.find(Persons.class,id);
        object2.setFirstName(firstName);
        entityManager.merge(object2);
        return object2;
    }
    public boolean deletePerson(int id){
        Persons object3 = entityManager.find(Persons.class,id);
        if (object3!=null){
            entityManager.remove(object3);
            return true;
        }else {
            return false;
        }
    }

    public void savePersonsAndInsurance(int id, String lastName, String firstName, String address, String city, InsuranceVO insuranceVO) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

//        entityManager.getTransaction().begin();

        Persons object = new Persons();
        object.setPersonID(id);
        object.setLastName(lastName);
        object.setFirstName(firstName);
        object.setAddress(address);
        object.setCity(city);
        Insurance obj1= InsuranceService.getInsurance(insuranceVO);
        obj1.setPersonID(id);
        object.setInsurance(obj1);

        entityManager.persist(object);
        entityManager.flush();
//        entityManager.getTransaction().commit();
    }

    public Persons getPersonAndInsurance(int id){
        Persons object1 = entityManager.find(Persons.class,id);
        return object1;
    }

    public Persons updatePersonAndInsurance(int id, String firstName){
        Persons object2 = entityManager.find(Persons.class,id);
        object2.setFirstName(firstName);
        entityManager.merge(object2);
        return object2;
    }

    public boolean deletePersonAndInsurance(int id){
        Persons object3 = entityManager.find(Persons.class,id);
        if (object3!=null){
            entityManager.remove(object3);
            return true;
        }else {
            return false;
        }
    }

    public Persons getByLastName (String lastName){
        Persons result = (Persons) entityManager.createNativeQuery("Persons_0selectByLastName", Persons.class).setParameter("name",lastName).getSingleResult();
        return result;
    }

}
