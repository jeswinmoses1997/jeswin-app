package org.example.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@Stateless
public class InsuranceService {
    @PersistenceContext(unitName = "merlin")
    EntityManager entityManager;

    public void saveInsurance(int PolicyNumber, String Name, int Years, int Amount,int PhoneNumber) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException{
        Insurance object = new Insurance();
        object.setPolicyNumber(PolicyNumber);
        object.setName(Name);
        object.setYears(Years);
        object.setAmount(Amount);
        object.setPhoneNumber(PhoneNumber);

        entityManager.persist(object);
        entityManager.flush();
    }
    public Insurance createInsurance(InsuranceVO insuranceVO) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException{
        Insurance object = getInsurance(insuranceVO);

        entityManager.persist(object);
        entityManager.flush();
        return object;
    }

    public static Insurance getInsurance(InsuranceVO insuranceVO) {
        Insurance object = new Insurance();
        object.setPolicyNumber(insuranceVO.getPolicyNumber());
        object.setName(insuranceVO.getName());
        object.setYears(insuranceVO.getYears());
        object.setAmount(insuranceVO.getAmount());
        object.setPhoneNumber(insuranceVO.getPhoneNumber());
        return object;
    }

    public Insurance getInsurance(int PolicyNumber){
        Insurance object1=entityManager.find(Insurance.class,PolicyNumber);
        return object1;
    }
    public Insurance updateInsurance(int PolicyNumber, int Years, int Amount){
        Insurance object2 = entityManager.find(Insurance.class,PolicyNumber);
        object2.setYears(Years);
        object2.setAmount(Amount);
        entityManager.merge(object2);
        return object2;
    }
    public boolean deleteInsurance(int PolicyNumber){
        Insurance object3 = entityManager.find(Insurance.class,PolicyNumber);
        if (object3!=null){
            entityManager.remove(object3);
            return true;
        }else {
            return false;
        }
    }

}
