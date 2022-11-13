/**
 * class batch is a class that will be a class for vaccine batch data
 *
 * @author I Ketut Mahendra
 */

import java.util.ArrayList;
public class batch
{
    private int batchNo;
    private String expiryDate;
    private int quantityAvailable;
    private int quantityAdministered;
    private ArrayList<vaccination>vaccinations;

    /**
     * constructor for class batch
     * @param batchNo is the parameter for the number of batch of the vaccine
     * @param expiryDate is the parameter for expiry date of the vaccine
     * @param quantityAvailable is the parameter for the quantity of the vaccine that available
     * @param quantityAdministered is the parameter for the quantity of vaccine that has been administered to the patient
     */
    public batch(int batchNo, String expiryDate, int quantityAvailable,int quantityAdministered)
    {
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
        this.vaccinations = new ArrayList<>();
    }

    /**
     * setter method for batch number of vaccine
     * @param batchNo parameter of batch number
     */
    public void setBatchNo(int batchNo)
    {
        this.batchNo = batchNo;
    }

    /**
     * setter method for expiry date of the vaccine
     * @param expiryDate parameter of expiry date of the vaccine
     */
    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    /**
     * setter method for quantity available of the vaccine
     * @param quantityAvailable parameter of quantity available of the vaccine
     */
    public void setQuantityAvailable(int quantityAvailable)
    {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * setter method for quantity of the vaccine that has been administered
     * @param quantityAdministered parameter of quantity of the vaccine that has been administered
     */
    public void setQuantityAdministered(int quantityAdministered)
    {
        this.quantityAdministered = quantityAdministered;
    }

    /**
     * set method for arraylist vaccination
     * @param thisVaccine parameter of this method it will contain the object of the arraylist
     */
    public void setVaccinations(vaccination thisVaccine)
    {
        this.vaccinations.add(thisVaccine);
    }
    
    /**
     * getter method for vaccination object in arraylist vaccinations
     * @return the vaccination object of the vaccination arraylist
     */
    public ArrayList<vaccination> getVaccinations()
    {
        return vaccinations;
    }
    
    /**
     * getter method for batch number of the vaccine
     * @return the batch number of the vaccine will be returned
     */
    public int getBatchNo()
    {
        return batchNo;
    }

    /**
     * getter method for expiry date of the vaccine
     * @return the expiry date of the vaccine will be returned
     */
    public String getExpiryDate()
    {
        return expiryDate;
    }

    /**
     * getter method for quantity vaccine that available
     * @return the available quantity of vaccine will be returned
     */
    public int getQuantityAvailable()
    {
        return quantityAvailable;
    }

    /**
     * getter method for quantity vaccine that administered
     * @return the administered quantity of vaccine will be returned
     */
    public int getQuantityAdministered()
    {
        return quantityAdministered;
    }

    //toString

    /**
     * toString method for class batch
     * @return it will return the batch number of the vaccine, expiry date, quantity vaccine that available, and quantity vaccine that has administered
     */
    @Override
    public String toString()
    {
        return "batch{" +
                "batchNo=" + batchNo +
                ", expiryDate='" + expiryDate +
                ", quantityAvailable=" + quantityAvailable +
                ", quantityAdministered=" + quantityAdministered +
                '}';
    }
}
