package org.example;

import org.example.control.FamilyInfo;
import org.example.control.VehicleService;
import org.example.model.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Path("public/family/all")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@RequestScoped

public class MySecondRestService {
    public static final String FAMILY_NAMES = "ASHOK, MERLIN, JESWIN, SHALWIN";
    @Inject
    private VehicleService vehicleObject;
    @Inject
    private FamilyInfo familyInfo;
    @Inject
    private MobileService mobileService;
    @Inject
    private VegetableService vegetableService;
    @Inject
    private PlaceService placeService;
    @Inject
    private PersonsService personsService;
    @Inject
    private LaptopService laptopService;
    @Inject
    private InsuranceService insuranceService;
    @Inject
    private  StudentAndCourseService studentAndCourseService;

    @GET
    public String getAllFamilyMembersNmae() {
        return FAMILY_NAMES;
    }

    @POST
    @Path("new/family/member/test/put/{newmembername}")
    public String addNewFamilyMember (@PathParam("newmembername") String newmembername) {
        return FAMILY_NAMES +", " +newmembername.toUpperCase();
    }
    @POST
    @Path("new/family/member/test/query")
    public String addNewFamilyMemberTwo (@QueryParam("newmembername") String newmembername,@QueryParam("newmembernametwo") String newmembernametwo) {
        return FAMILY_NAMES +", " +newmembername.toUpperCase()+", " +newmembernametwo.toUpperCase();
    }
    @POST
    @Path("new/family/member/test/put/body")
    public String addNewFamilyMemberBody (String newmembername) {
        return FAMILY_NAMES +", " +newmembername.toUpperCase();
    }
    @PUT
    @Path("create/person/{name}/{age}")
    public Person createPerson (@PathParam("name") String name, @PathParam("age") String age){
        PersonService service=new PersonService();
        Person person = service.createUsingParameterized(name, Integer.parseInt(age));
        return person;
    }

    @GET
    @Path("welcome/message")
    public String welcomeMessage() {
        return SingletonExample.getInstance().getWelcomeMessage();
    }

    @GET
    @Path("get/person/salary")
    public int getSalary(@QueryParam("jobtitle") String jobtitle) {
        PersonInterface object=null;
        if (jobtitle.equals("Teacher")) {
             object = new Teacher();
            return object.getSalary();
        }
        if (jobtitle.equals("Police")) {
             object = new Police();
            return object.getSalary();
        }
        return 0;
    }

    @GET
    @Path("get/car/{brand}/{speed}/{kmpl}")
    public Car createCar (@PathParam("brand") String brand, @PathParam("speed") int speed, @PathParam("kmpl") int kmpl){
        Car kia=new Car( brand, speed, kmpl);
        return kia;
    }

    @GET
    @Path("get/person/salarylist")
    public List<Integer> getSalary(@QueryParam("jobtitle") String jobtitle, @QueryParam("job") String job) {
        List<Integer> salaryList = new ArrayList<>();
        PersonInterface object=null;
        if (jobtitle.equals("Teacher")) {
            object = new Teacher();
            salaryList.add(object.getSalary());
        }
        if (job.equals("Police")) {
            object = new Police();
            salaryList.add(object.getSalary());
        }
        return salaryList;
    }

    @PUT
    @Path("create/person/builder/{name}/{age}")
    public PersonBuilderPattern usingBuilderPattern (@PathParam("name") String name, @PathParam("age") String age){
        PersonService service=new PersonService();
        PersonBuilderPattern personBuilderPattern = service.createUsingBuilderPattern(name, Integer.parseInt(age));
        return personBuilderPattern;
    }

    @PUT
    @Path("create/car/builder/{brand}/{speed}")
    public CarBuilderPattern usingBuilder (@PathParam("brand") String brand, @PathParam("speed") String speed){
        PersonService service=new PersonService();
        CarBuilderPattern carBuilderPattern = service.createUsingBuilder(brand, Integer.parseInt(speed));
        return carBuilderPattern;
    }

    @PUT
    @Path("polymorphism/{number1}/{number2}/{number3}")
    public int add (@PathParam("number1") String number1, @PathParam("number2") String number2, @PathParam("number3") String number3){
        Polymorphism object = new Polymorphism();
        int sum=0;
        if (Integer.parseInt(number3)==0){
//            					NONSTATIC METHOD:
//						Objectname.functionname(argument1, argument2,…)
            sum= object.add(Integer.parseInt(number1) , Integer.parseInt(number2));
        }
        else {
            sum= object.add(Integer.parseInt(number1),Integer.parseInt(number2),Integer.parseInt(number3));
        }
        return sum;
    }

    @GET
    @Path("get/person/welcome")
    public String getWelcome(@QueryParam("jobtitle") String jobtitle, @QueryParam("job") String job) {
//        List<Integer> salaryList = new ArrayList<>();
        String welcomeMessage;
        PersonInterface object=null;
        if (jobtitle.equals("Teacher")) {
            object = new Teacher();
            welcomeMessage=object.welcome();
            return welcomeMessage;
        }
        if (job.equals("Police")) {
            object = new Police();
            welcomeMessage=object.welcome();
            return welcomeMessage;
        }
        return "Unknown Jobtitle";
    }

    @GET
    @Path("get/person/science")
    public int getScience() {
        Teacher object=new ScienceTeacher();
        return object.getBonusPercentage();
    }

    @GET
    @Path("get/person/government")
    public int getTopManager() {
        Police object=new Police();
        return object.getNumberOfPublicHolidays();
    }

    @GET
    @Path("get/mobile")
    public MobileInterface getMobile(@QueryParam("model") String model) {
        MobileInterface object=null;
        if (model.equals(MOBILE_TYPE.samsung.toString())) {
            object = new Samsung();

            return object;
        }
        if (model.equals(MOBILE_TYPE.apple.toString())) {
            object = new Mobile();
            return object;
        }
        return null;
    }

    @PUT
    @Path("put/mobile")
    public MobileInterface getMobile(@QueryParam("brand") String brand, @QueryParam("model") String model, @QueryParam("price")int price) {
        Mobile mobileObject = new Mobile();
        mobileObject.setBrand(brand);
        mobileObject.setModel(model);
        mobileObject.setPrice(price);
        return mobileObject;
    }

    @PUT
    @Path("put/vehicle/bus")
    public VehicleInterface getBus(@QueryParam("type") String type, @QueryParam("model") String model) {
        Bus busObject = new Bus();
        busObject.setType(type);
        busObject.setModel(model);
        return busObject;
    }

    @PUT
    @Path("put/vehicle/truck")
    public VehicleInterface createTruck(@QueryParam("type") String type, @QueryParam("model") String model) {
//        VehicleService vehicleObject=new VehicleService();
        return vehicleObject.createTruck(type,model);
    }

    @PUT
    @Path("put/vegetable")
    public VegetableInterface createVegetable(@QueryParam("name") String name){
        return vegetableService.createVegetable(name);
    }

    @PUT
    @Path("put/mobile/version")
    public MobileInterface createMobile(@QueryParam("brand") String brand, @QueryParam("model") String model,@QueryParam("price") int price){
        return mobileService.createMobile(brand,model,price);
    }

    @PUT
    @Path("put/place/earth")
    public PlaceInterface createPlace(@QueryParam("place") String place){
        return placeService.createPlace(place);
    }

    @POST
    @Path("post/persons")
    public Response createPersons(@QueryParam("PersonID")int id,@QueryParam("FirstName") String firstName,
                                  @QueryParam("LastName") String lastName, @QueryParam("Address")String address,
                                  @QueryParam("city") String city) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        personsService.savePersons(id,firstName,lastName,address,city);
        return Response.ok().build();
    }
    @GET
    @Path("get/persons")
    public Response getPersons(@QueryParam("id")int id){
        Persons object5= personsService.getPerson(id);
        if (object5 != null){
            return Response.ok().entity(object5).build();
        }else {
            return Response.noContent().build();
        }
    }

    @GET
    @Path("get/laptop")
    public Response getLaptop(@QueryParam("id")int id){
        Laptop object = laptopService.getLaptop(id);
        if (object != null){
            return Response.ok().entity(object).build();
        }else {
            return Response.noContent().build();
        }
    }

    @PUT
    @Path("put/update/persons")
    public Response updatePerson(@QueryParam("id")int id, @QueryParam("firstName")String firstName){
        Persons updatePerson = personsService.updatePerson(id, firstName);
        if (updatePerson != null){
            return Response.ok().entity(updatePerson).build();
        } else {
            return Response.noContent().build();
        }
    }
    @DELETE
    @Path("perons/delete")
    public Response deletePerson(@QueryParam("id")int id){
        boolean deletePerson = personsService.deletePerson(id);
        if (deletePerson){
            return Response.ok().build();
        }else {
            return Response.noContent().build();
        }
    }
    @PUT
    @Path("laptop/update")
    public Response updateLaptop(@QueryParam("id")int id,@QueryParam("price")int price){
        Laptop updateLaptop = laptopService.updateLaptop(id, price);
        if (updateLaptop!=null){
            return Response.ok().entity(updateLaptop).build();
        }else {
            return Response.noContent().build();
        }
    }
    @DELETE
    @Path("laptop/delete")
    public Response deleteLaptop(@QueryParam("id")int id){
        boolean deleteLaptop=laptopService.deleteLaptop(id);
        if (deleteLaptop){
            return Response.ok().build();
        }else {
            return Response.noContent().build();
        }
    }
    @GET
    @Path("get/insurance")
    public Response getInsurance(@QueryParam("PolicyNumber")int PolicyNumber) {
        Insurance object5 = insuranceService.getInsurance(PolicyNumber);
        if (object5!=null){
            return Response.ok().entity(object5).build();
        }else{
            return Response.noContent().build();
        }
        }

        @PUT
    @Path("put/insurance")
    public Response updateInsurance(@QueryParam("PolicyNumber")int PolicyNumber, @QueryParam("Years")int Years, @QueryParam("Amount")int Amount){
        Insurance updateInsurance = insuranceService.updateInsurance(PolicyNumber, Years, Amount);
        if (updateInsurance!=null){
            return Response.ok().entity(updateInsurance).build();
        }else{
            return Response.noContent().build();
        }
        }

        @DELETE
    @Path("delete/insurance")
    public Response deleteInsurance(@QueryParam("PolicyNumber")int PolicyNumber){
        boolean deleteInsurance = insuranceService.deleteInsurance(PolicyNumber);
        if(deleteInsurance){
            return Response.ok().build();
        }else{
            return Response.noContent().build();
        }
        }
        @POST
    @Path("create/insurance")
    public Response saveInsurance(@QueryParam("PolicyNumber")int PolicyNumber, @QueryParam("Name") String Name, @QueryParam("Years") int Years, @QueryParam("Amount") int Amount, @QueryParam("PhoneNumber") int PhoneNumber)throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException{
        insuranceService.saveInsurance(PolicyNumber, Name, Years,Amount,PhoneNumber);
        return Response.ok().build();
        }

        @POST
    @Path("create/insurance/vo")
    public Response createInsurance(InsuranceVO insuranceVO) throws HeuristicRollbackException, SystemException, HeuristicMixedException, NotSupportedException, RollbackException {
        try {
            validate(insuranceVO);
        }catch (InvalidPolicyNumberException | InvalidAmountException invalidPolicyNumberException){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input check policy number and amount").build();
        }
        finally {
            System.out.println("inside finally.");
        }
//        catch (InvalidAmountException invalidAmountException){
//            return Response.status(Response.Status.BAD_REQUEST).entity(invalidAmountException.getMessage()).build();
//        }
        Insurance insurance = insuranceService.createInsurance(insuranceVO);
            if (insurance!=null) {
                return Response.ok().entity(insurance).build();
            }else {
                return Response.noContent().build();
            }
        }
        public void validate(InsuranceVO insuranceVO) throws InvalidPolicyNumberException, InvalidAmountException {
            if (insuranceVO.getPolicyNumber()<10000){
                throw new InvalidPolicyNumberException("Invalid Policy Number", "Please enter policy number with minimum 5 digits");
            }
            if (insuranceVO.getAmount()<100){
                throw new InvalidAmountException("Policy Amount Is Wrong. ", " should have minium Rs. 100/-.");
            }
        }
        @POST
    @Path("create/persons/vo")
    public Response createPersons (PersonsVO personsVO) throws HeuristicRollbackException, SystemException, HeuristicMixedException, NotSupportedException, RollbackException, InvalidCityNameException {
            try {
                validatepersons(personsVO);
            } catch(InvalidCityNameException cityNameException){
                return Response.status(Response.Status.BAD_REQUEST).entity(cityNameException.getMessage()).build();
            }
            Persons persons=personsService.createPersons(personsVO);
        if (persons!=null){
            return Response.ok().entity(persons).build();
        }else {
            return Response.noContent().build();
        }
        }
    public void validatepersons(PersonsVO personsVO) throws InvalidCityNameException {
        if (personsVO.getCity().length()<5){
            throw new InvalidCityNameException("City Is Wrong. ","Should have minimum 5 letters.");
        }
    }

    @POST
    @Path("create/laptop/vo")
    public Response createLaptop (LaptopVO laptopVO) throws HeuristicRollbackException, SystemException, HeuristicMixedException, NotSupportedException, RollbackException {
        Laptop laptop=null;
        try { validatelaptop(laptopVO);
             laptop = laptopService.createLaptop(laptopVO);
        } catch (InvalidCapacityException capacityException){
            return Response.status(Response.Status.BAD_REQUEST).entity(capacityException.getMessage()).build();
        }
            catch (Throwable error){
            boolean SQL=isCausedBySQLIntegrityConstraintViolationException(error);
            if (SQL) {
                return Response.status(Response.Status.BAD_REQUEST).entity(error.getMessage()).build();
            }
        }
        if (laptop!=null){
            return Response.ok().entity(laptop).build();
        }
        else {
            return Response.noContent().build();
            }
        }

    public void validatelaptop(LaptopVO laptopVO) throws InvalidCapacityException {
        if (laptopVO.getCapacity()%8!=0) {
            throw new InvalidCapacityException("Capacity Is Wrong. ", "Should be multiple of 8.");
        }
    }

//        java.sql.SQL IntegrityConstraint ViolationException
private boolean isCausedBySQLIntegrityConstraintViolationException(final Throwable throwable) {
    Throwable currentThrowable = throwable;
    do {
        if (currentThrowable instanceof SQLIntegrityConstraintViolationException) {
            return true;
        }
        currentThrowable = currentThrowable.getCause();
    }
    while (currentThrowable != null);
    return false;
}

    @POST
    @Path("post/persons/with/insurance")
    public Response createPersonsAndInsurance(@QueryParam("PersonID")int id,@QueryParam("FirstName") String firstName,
                                      @QueryParam("LastName") String lastName, @QueryParam("Address")String address,
                                  @QueryParam("city") String city, @QueryParam("PolicyNumber")int PolicyNumber,
                                              @QueryParam("Name")String Name, @QueryParam("Years")int Years, @QueryParam("Amount")int Amount,
                                              @QueryParam("PhoneNumber")int PhoneNumber) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        InsuranceVO object =new InsuranceVO();
        object.setYears(Years);
        object.setName(Name);
        object.setPolicyNumberr(PolicyNumber);
        object.setAmount(Amount);
        object.setPhoneNumber(PhoneNumber);
        personsService.savePersonsAndInsurance(id,firstName,lastName,address,city,object);
        return Response.ok().build();
    }

    @GET
    @Path("get/person/and/insurance")
    public Response getPersonAndInsurance(@QueryParam("id")int id){
        Persons object5= personsService.getPersonAndInsurance(id);
        if (object5 != null){
            return Response.ok().entity(object5).build();
        }else {
            return Response.noContent().build();
        }
    }

    @PUT
    @Path("put/update/persons/and/insurance")
    public Response updatePersonAndInsurance(@QueryParam("id")int id, @QueryParam("firstName")String firstName){
        Persons updatePerson = personsService.updatePersonAndInsurance(id, firstName);
        if (updatePerson != null){
            return Response.ok().entity(updatePerson).build();
        } else {
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("perons/delete/persons/and/insurance")
    public Response deletePersonAndInsurance(@QueryParam("id")int id){
        boolean deletePerson = personsService.deletePersonAndInsurance(id);
        if (deletePerson){
            return Response.ok().build();
        }else {
            return Response.noContent().build();
        }
    }

    @POST
    @Path("post/course/with/student")
    public Response saveCourse(@QueryParam("courseId")int courseId,@QueryParam("courseName") String courseName,
                                              @QueryParam("years") int years) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        studentAndCourseService.saveCourse(courseId,courseName,years);
        return Response.ok().build();
    }

    @GET
    @Path("get/persons/last/name")
    public  Response getByLastName(@QueryParam("lastName")String lastName){
        return Response.ok().entity(personsService.getByLastName(lastName)).build();
    }
}



//    create a new rest service in the same project, which has one GET method and returns all
//       of your family members name.

