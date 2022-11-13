//import java arraylist library
import java.util.ArrayList;

/**
 * healthCareCentre class is a class that will be a class for
 * healthcare center data
 *
 * @author I Ketut Mahendra
 */
public class healthCareCentre
{
    //instance variable
    private String centreName;
    private String address;
    private ArrayList<administrator> adminHealthCare;
    private ArrayList<batch> batchesVaccine;

    /**
     * constructor for class healthCareCentre
     * @param centreName is the parameter for name of
     *                   healthcare centre
     * @param address is the parameter for the address of
     *                healthcare centre
     */
    public healthCareCentre(String centreName, String address)
    {
        this.centreName = centreName;
        this.address = address;
        this.adminHealthCare = new ArrayList<>();
        this.batchesVaccine = new ArrayList<>();
    }

    /**
     * setter for centre of health name
     * @param centreName name of the healthcare centre
     */
    public void setCentreName(String centreName)
    {
        this.centreName = centreName;
    }

    /**
     * setter for centre of health address
     * @param address address of the healthcare centre
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * set object arraylist of administrator in healthcare centre
     * @param thisAdmin object of the administrator arraylist
     */
    public void setAdminHealthCare(administrator thisAdmin)
    {
        this.adminHealthCare.add(thisAdmin);
    }

    /**
     * set object arraylist of vaccine batches in healthcare centre
     * @param thisBatch object of the vaccine batch arraylist
     */
    public void setBatchesVaccine(batch thisBatch)
    {
        this.batchesVaccine.add(thisBatch);
    }

    //getter

    /**
     * getter method for healthcare centre name
     * @return name of healthcare centre
     */
    public String getCentreName()
    {
        return centreName;
    }

    /**
     * getter method for healthcare centre address
     * @return address of the healthcare centre
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * getter method for admin healthcare centre arraylist
     * @return object of healthcare centre admin arraylist
     */
    public ArrayList<administrator> getAdminHealthCare()
    {
        return adminHealthCare;
    }

    /**
     * getter method for vaccine in healthcare centre arraylist
     * @return object of vaccine batch arraylist
     */
    public ArrayList<batch> getBatchesVaccine() {
        return batchesVaccine;
    }

    /**
     * to string method for healthCareCentre class
     * @return healthcare centre name and healthcare
     * centre address
     */
    @Override
    public String toString()
    {
        return "Health Care Centre Name: " +
                centreName + ", Address:" + address ;
    }
}
