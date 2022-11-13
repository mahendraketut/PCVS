//import java arraylist library
import java.util.ArrayList;

/**
 * patient.java is an extends class of user.java. this class will inherit the abstract class method
 *
 * @author I Ketut Mahendra
 */
public class patient extends user
{
    //instance variable
    private String ICPassport;
    private ArrayList<vaccination> vaccinations;

    /**
     * constructor of patient.java. this constructor refers to member of the superclass with super keyword
     * @param username is the username of the patient
     * @param password is the password of the patient
     * @param email is the email of the patient
     * @param fullName is the full name of the patient
     * @param ICPassport is the IC Number or Passport of the patient
     */
    public patient(String username, String password, String email, String fullName, String ICPassport)
    {
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
        this.vaccinations = new ArrayList<>();
    }

    /**
     * setter method for ICPassport of the user
     * @param ICPassport is the ic passport of the patient
     */
    public void setICPassport(String ICPassport)
    {
        this.ICPassport = ICPassport;
    }

    /**
     * set method for arraylist vaccination
     * @param thisVaccine parameter of this method it will contain the object of the arraylist
     */
    public void setVaccinations(vaccination thisVaccine)
    {
        this.vaccinations.add(thisVaccine);
    }

    //getter

    /**
     * getter method for IC Number or Passport
     * @return the IC Number or Passport of the patient
     */
    public String getICPassport()
    {
        return ICPassport;
    }

    /**
     * getter method for vaccination object in arraylist vaccinations
     * @return the vaccination object of the vaccination arraylist
     */
    public ArrayList<vaccination> getVaccinations()
    {
        return vaccinations;
    }

    //toString

    /**
     * toString method for patient class
     * @return the IC Passport of the patient
     */
    @Override
    public String toString() {
        return "patient{" +
                "ICPassport='" + ICPassport + '\'' +
                ", vaccinations=" + vaccinations +
                '}';
    }
}
