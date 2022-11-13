//import java arraylist library
import java.util.ArrayList;

/**
 * class vaccine is a class that will be a class for vaccine data
 *
 * @author I Ketut Mahendra
 */
public class vaccine
{
    //instance variable
    private String vaccineID;
    private String manufacturer;
    private String vaccineName;
    private ArrayList<batch>vaccineBatch;

    /**
     * constructor for class vaccine
     * @param vaccineID is the parameter for id of the vaccine
     * @param manufacturer is the parameter for vaccine
     *                     manufacturer
     * @param vaccineName is the parameter for vaccine name
     */
    public vaccine(String vaccineID, String manufacturer,
                   String vaccineName)
    {
        this.vaccineID = vaccineID;
        this.manufacturer = manufacturer;
        this.vaccineName = vaccineName;
        this.vaccineBatch = new ArrayList<>();
    }

    /**
     * setter method for vaccine id
     * @param vaccineID is the parameter of the vaccine id
     */
    public void setVaccineID(String vaccineID)
    {
        this.vaccineID = vaccineID;
    }

    /**
     * setter method for vaccine name
     * @param vaccineName is the parameter of the vaccine name
     */
    public void setVaccineName(String vaccineName)
    {
        this.vaccineName = vaccineName;
    }

    /**
     * setter method for vaccine manufacturer
     * @param manufacturer is the parameter of the vaccine
     *                     manufacturer
     */
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    /**
     * method to set the vaccine batch in vaccineBatch ArrayList
     * @param vaccineBatch is the parameter of the vaccine batch that
     *                     contain the vaccine batch object
     */
    public void setVaccineBatch(batch vaccineBatch)
    {
        this.vaccineBatch.add(vaccineBatch);
    }

    /**
     * getter method for vaccine id
     * @return it will return the vaccine id
     */
    public String getVaccineID()
    {
        return vaccineID;
    }

    /**
     * getter method for vaccine name
     * @return it will return the vaccine name
     */
    public String getVaccineName()
    {
        return vaccineName;
    }

    /**
     * getter method for vaccine manufacturer
     * @return it will return the vaccine manufacturer
     */
    public String getManufacturer()
    {
        return manufacturer;
    }

    public ArrayList<batch> getVaccineBatch()
    {
        return vaccineBatch;
    }

    //toString
    @Override
    public String toString()
    {
        return "Vaccine ID: " + vaccineID +
                ", Manufacturer: " + manufacturer +
                ", Vaccine Name: " + vaccineName;
    }
}