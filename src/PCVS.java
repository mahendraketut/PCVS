//import java arraylist library
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

/**
 * PCVS.java is a class controller that contains a whole method that
 * will be used to process the input of the users
 *
 * @author I Ketut Mahendra
 */
public class PCVS implements Serializable
{
    //instance variable
    private ArrayList<healthCareCentre> CentreOfHealth;
    private ArrayList<vaccine> dataVaccine;
    private ArrayList<administrator> adminData;
    private ArrayList<patient> patientsData;
    
    /**
     * constructor of PCVS.java
     */
    public PCVS()
    {
        CentreOfHealth = new ArrayList<healthCareCentre>();
        CentreOfHealth.add(new healthCareCentre("FMC General Hospital", "Jalan Arjuna 18, Gianyar, Bali"));
        CentreOfHealth.add(new healthCareCentre("SMCDenpasar", "Jalan P.B. Sudirman, Denpasar, Bali"));

        dataVaccine = new ArrayList<vaccine>();
        dataVaccine.add(new vaccine("mRNA-1273", "Moderna", "Cov-19 Moderna"));
        dataVaccine.add(new vaccine("BNT162B2", "BioNTech, Pfizer", "Pfizer"));

        this.adminData = new ArrayList<>();
        
        this.patientsData = new ArrayList<>();
    }

    /**
     * getter method of CentreOfHealth.
     * the method will return the CentreOfHealth object.
     */
    public ArrayList<healthCareCentre> getCentreOfHealth()
    {
        return CentreOfHealth;
    }

    /**
     *getter method of dataVaccine
     * the method will return the dataVaccine object.
     */
    public ArrayList<vaccine> getVaccineData()
    {
        return dataVaccine;
    }

    /**
     * getter method of AdminData.
     * the method will return the adminData object.
     */
    public ArrayList<administrator> getAdminData()
    {
        return adminData;
    }

    /**
     * getter method of patientsData.
     * the method will return the patientsData object.
     */
    public ArrayList<patient> getPatientsData()
    {
        return patientsData;
    }

    /**
     * setter method of adminData.
     * @param thisAdmin it is the parameter of the method with data type: administrator
     */
    public void setAdminData(administrator thisAdmin)
    {
        this.adminData.add(thisAdmin);
    }

    /**
     * setter method of patientsData.
     * @param thisPatient it is the parameter of the method with data type: patient
     */
    public void setPatientsData(patient thisPatient)
    {
        this.patientsData.add(thisPatient);
    }

    /**
     * method to get only the name of the healthcare centre in CentreOfHealth.
     * the method will return String data of healthcare centre name
     */
    public String getNameOfHealthCare()
    {
        String nameHealthCare = "";
        for (int i = 0; i < CentreOfHealth.size(); i++)
        {
            nameHealthCare = nameHealthCare + (i + 1) + ("). ") + CentreOfHealth.get(i).getCentreName() + ("\n");
        }
        return nameHealthCare;
    }

    /**
     * method that is used for getting the data of the healthcare centre using the index of the healthcare centre array after
     * the administrator select the healthcare centre name before the administrator wants to register himself.
     * @param numIndex is the parameter of the method that will contain integer data of the Healthcare Centre Index.
     * @return CentreOfHealth it will return the data from an index of CentreOfHealth.
     */
    public healthCareCentre selectedHealthCareCentre(int numIndex)
    {
        return CentreOfHealth.get(numIndex);
    }

    /**
     * method that is used for returning a notice that the administrator has been registered at a healthcare centre.
     * @param numIndex is the parameter of the method that will contain the index number of healthcare centre with data type: int
     * @return registeredAdminHealthCare it will return the notice.
     */
    public String healthCareCentreAdminRegistered(int numIndex) {
        String registeredAdminHealthCare = "";
        for (int i = 0; i < CentreOfHealth.size(); i++)
        {
            if (i == numIndex) {
                registeredAdminHealthCare = registeredAdminHealthCare +
                        "You are successfully registered" +
                        "Healthcare Centre  : "+ CentreOfHealth.get(i).getCentreName() + "Address    : " + CentreOfHealth.
                        get(i).getAddress();
            }
        }
        return registeredAdminHealthCare;
    }

    /**
     * method used to verify the admin username when the admin wants to sign-in to the system.
     * the method will return false if the data entered by the user (according to the parameters)
     * is the same as the username data that has been recorded in the system,
     * the method will return true if the opposite happens.
     * @param username is the parameter of the method that will contain the username that will be compared. username has data type: String
     * @return boolean type (true/false)
     */
    public boolean inspectSignInAdmin(String username)
    {
        for (int i = 0; i < adminData.size(); i++)
        {
            if (adminData.get(i).getUsername().compareTo(username) == 0)
                return true;
        }
        return false;
    }

    /**
     * method used to verify the patient username when the patient wants to sign-in to the system.
     * the method will return false if the data entered by the user (according to the parameters) is the same as the username data
     * that has been recorded in the system, the method will return true if the opposite happens.
     * @param username is the parameter of the method that will contain the username that will be compared. username has data type: String
     * @return boolean type (true/false)
     */
    public boolean inspectSignInPatient(String username)
    {
        for (int i = 0; i < patientsData.size(); i++)
        {
            if (patientsData.get(i).getUsername().compareTo(username) == 0)
                return true;
        }
        return false;
    }

    /**
     * method used to verify the username and password when the administrator wants to log into the system,
     * this method will check the suitability of the username and password entered by the administrator with the data owned
     * by the system, if appropriate then the method will return true, and vice versa if the method does not find the appropriate username and password data,
     * the method will return false.
     * @param username is the parameter of the method that will contain the username that will be compared.
     * @param password is the parameter of the method that will contain the password that will be compared.
     * @return boolean type (true/false)
     */
    public boolean loginCheckAdmin(String username, String password) {
        for (int i = 0; i < adminData.size(); i++) {
            if (adminData.get(i).getUsername().equals(username) && adminData.get(i).getPassword().equals(password))
                return true;
        }
        return false;
    }

    /**
     * method used to verify the username and password when the patient wants to log into
     * the system, this method will check the suitability of the username and password entered by the
     * patient with the data owned by the system, if appropriate then the method will return true,
     * and vice versa if the method does not find the appropriate username and password data,
     * the method will return false.
     * @param username is the parameter of the method that will contain the username that will be compared.
     * @param password is the parameter of the method that will contain the password that will be compared.
     * @return boolean type (true/false)
     */
    public boolean loginCheckPatient(String username, String password) {
        for (int i = 0; i < patientsData.size(); i++) {
            if (patientsData.get(i).getUsername().equals(username) && patientsData.get(i).getPassword().equals(password))
                return true;
        }
        return false;
    }

    /**
     * method used to generate the staffID automatically for the Administrator.
     * the staffID pattern is A + HealthCareIndex + 4 digits index number of administrator
     * character "A" : Administrator
     * @param healthCareCentre is the parameter of the method that will contain the healthcare index
     * @return Staff ID : Sample: A10001
     */
    public String generateID(int healthCareCentre)
    {
        String StaffId = "";
        for (int i = 0; i < adminData.size(); i++)
        {
            String range = String.format("%04d", i+1);
            StaffId = "A" + healthCareCentre + range;
        }
        return StaffId;
    }
    
    /**
     * method used to generate the vaccination ID automatically
     * @param vaccine is the parameter vaccine that selected by patient
     * @param hc is the parameter health care centre that selected by patient
     * @param batch is the parameter vaccine batch that selected by patient
     * @return this method will return the vaccination id
     */
    public String generateVaccinationID(int vaccine, int hc, int batch) {
		String vaccinationID = "";
		for (int i = 0; i < 100; i++) {
			String range = String.format("%04d", i+1);
			vaccinationID = "VA"+(vaccine+1)+"iHC"+(hc+1)+"sBt"+(batch+1);
		}
		return vaccinationID;
	}
    
    /**
     * method used to return the Healthcare Centre based on index of health care
     * @param num index of healthcare centre
     * @return healthcare centre object based on the index
     */
    public healthCareCentre getHealthcareCentre(int num) {
        for (int i = 0; i < CentreOfHealth.size(); i++) {
            if (i == num)
                return CentreOfHealth.get(i);
        }
        return null;
    }
    
    /**
     * method used to return the patient data based on username data
     * @param username parameter username of the patient
     * @return patient data object based on the username
     */
    public patient getPatientVaccination(String	username) {
    	for (int i = 0; i < patientsData.size(); i++) {
			if(patientsData.get(i).getUsername()==username) {
				return patientsData.get(i);
			}
		}
    	return null;
    }
    
    /**
     * method used to return the health care centre based on healthcare centre login
     * @param name is the name of health care centre
     * @return health care centre object based on the name
     */
    public healthCareCentre getHealthCareCentreBasedOnName(String name) {
		for(int i = 0; i < CentreOfHealth.size();i++) {
			if(CentreOfHealth.get(i).getCentreName().equals(name))
				return CentreOfHealth.get(i);
		}
		return null;
	}
    /**
     * method used to return the vaccine based on the vaccine id
     * @param id is the vaccine id
     * @return it will return the vaccine object based on the vaccine id
     */
    public vaccine getVaccineById(String id) {
    	for(int i = 0; i < dataVaccine.size();i++) {
    		if(dataVaccine.get(i).getVaccineID().equals(id))
    			return dataVaccine.get(i);
    	}
    	return null;
    }
    /**
     * method used to return the name of healthcare centre when the username login to system.
     * @param usernameLogin the parameter that contain username of the administrator that will be compared,
     *                      and return the healthcare centre name where the method found the same username
     *                      that inputted by administrator and the arraylist
     * @return healthCareAdmin: name of the health care with "String" data type
     */
    public String getHealthCareCentreNameForAdminLogin(String usernameLogin){
        String healthCareAdmin = "";

        // loop to get the centre
        for (int i = 0; i < getCentreOfHealth().size(); i++){
            healthCareCentre hc = getCentreOfHealth().get(i);

            // loop to get the admin
            for (int j = 0; j < hc.getAdminHealthCare().size(); j++)
            {
                if (hc.getAdminHealthCare().get(j).getUsername().equals(usernameLogin))
                {
                    healthCareAdmin =  hc.getCentreName();
                }
            }
        }
        return healthCareAdmin;
    }

    /**
     * method that used for returning the vaccine id.
     * @return vaccine id i vaccine arraylist.
     */
    public String getVaccineID()
    {
        String vaccineID = "";
        for (int i = 0; i < dataVaccine.size(); i++)
        {
            vaccineID = vaccineID + (i+1) + ("). ") + dataVaccine.get(i).getVaccineID() + ("\n");
        }
        return vaccineID;
    }
    
    

    /**
     * method that used for displaying the detail of vaccine that chosen by administrator
     * @param numIndex is the parameter that contain vaccine index with data type: int
     * @return detail vaccine based on the vaccine index
     */
    public vaccine selectedVaccineByAdmin(int numIndex)
    {
        return dataVaccine.get(numIndex);
    }

    /**
     * method that used to get a vaccine object in vaccine class based on the index number of the vaccine.
     * @param num is the parameter of the vaccine index that inputted by the administrator
     * @return it will return null if the vaccine index is not same with the input, and it will return
     *          the data if the vaccine index is same with the data in vaccine arraylist in class vaccine
     */
    public vaccine getVaccineBatch(int num) {
        for (int i = 0; i < dataVaccine.size(); i++) {
            if (i == num)
                return dataVaccine.get(i);
        }
        return null;
    }

    /**
     * method used to get a vaccine object in healthcare class based on the index number of the vaccine.
     * @param num is the parameter of the vaccine index that inputted by the administrator
     * @return it will return null if the vaccine index is not same with the input, and it will return the data
     * if the vaccine index same with data in vaccine arraylist in class healthcare centre
     */
    public healthCareCentre getVaccineBatchHealthCare(int num)
    {
        for (int i = 0; i < CentreOfHealth.size(); i++)
        {
            if (i == num)
                return CentreOfHealth.get(i);
        }
        return null;
    }

    /**
     * method used for getting the full name of user and displaying it when the patient successfully logged in to the system
     * @param usernameLogin is the parameter of username that will be used
     *                      for comparing the data inputted with the data
     *                      in the ArrayList
     * @return patientName: the patient name based on the same username on
     * arraylist and parameter
     */
    public String getFullNamePatientForLogin(String usernameLogin){
        String patientName = "";
        for (int i = 0; i < getPatientsData().size(); i++)
        {
            patient pName = getPatientsData().get(i);
            if (pName.getUsername().equals(usernameLogin))
            {
                patientName =  pName.getFullName();
            }
        }
        return patientName;
    }

    /**
     * method used for return the vaccine name and the manufacturer from vaccine arraylist
     * @return vaccine name and manufacturer
     */
    public String getVaccineNameAndManufacturer()
    {
        String vaccine = "";
        for (int i = 0; i < dataVaccine.size(); i++)
        {
            vaccine = vaccine + (i + 1) + ". Vaccine name: " + dataVaccine.get(i).getVaccineName() + ", Manufactured by: " + dataVaccine.get(i).getManufacturer() + "\n";
        }
        return vaccine;
    }
    
    /**
     * method used for return the vaccine manufacturer based on the vaccine id that selected by user
     * @param index index number of vaccine id that selected from combo box
     * @return the manufacturer name
     */
    public String getVaccineManufacturer(int index) {
    	for(int i = 0; i < getVaccineData().size();i++) {
    		if(i==index) {
    			return dataVaccine.get(i).getManufacturer();
    		}
    	}
		return null;
    }
    
    public String getVaccineName(int index) {
    	for (int i = 0; i < getVaccineData().size(); i++) {
			if (i==index) {
				return dataVaccine.get(i).getVaccineName();
			}
		}
    	return null;
    }

    /**
     * method used for getting the healthcare centre that offering the vaccine that selected by patient.
     * The way this method works is by looping the vaccine batch in the vaccine batch arraylist in the vaccine class. if it is found it will be entered into the healthcareVaccineBatch variable. then looping again through the vaccine batch at the healthcare center class. then the data will be entered into the healthcareVaccineDataBatch variable. then a comparison will be made between the results in the healthcareVaccineBatch variable and the healthcareVaccineDataBatch variable using if. if a match is found, healthcareVaccineDataBatch will be added to the storeHealthCareProvideVaccine arraylist.
     * then a for loop is done to enter the data into the centerHealthOfferingVac variable and then return it
     * @param indexVac
     * @return
     */
    public String healthCreCentreOfferingVaccine(int indexVac)
    {
        String centreHealthOfferingVac = "";
        ArrayList<healthCareCentre> storeHealthCareProvideVaccine = new ArrayList<>();
        vaccine centreHealthVaccine = getVaccineBatch(indexVac);
        
        for (int i = 0; i < centreHealthVaccine.getVaccineBatch().size(); i++)
        {
            batch healthcareVaccineBatch = centreHealthVaccine.getVaccineBatch().get(i);

            for (int j = 0; j < getCentreOfHealth().size(); j++)
            {
                healthCareCentre healthcareVaccineDataBatch = getCentreOfHealth().get(j);

                if(healthcareVaccineDataBatch.getBatchesVaccine().contains(healthcareVaccineBatch))
                {
                    storeHealthCareProvideVaccine.add(healthcareVaccineDataBatch);
                }
            }
        }
        for (int k = 0; k < storeHealthCareProvideVaccine.size(); k++)
        {
            centreHealthOfferingVac = centreHealthOfferingVac + (k + 1) + ". " + storeHealthCareProvideVaccine.get(k) + "\n";
        }
        return centreHealthOfferingVac;
    }
    
    /**
     * method used for getting the batch number of vaccine based on healthcare centre and type of vaccine that selected by patient 
     * @param indexVacc is the index of vaccine that selected by the user in JCombobox
     * @param indexHC is the index of health care that selected by the user in JCombobox
     * @return batch number of vaacine
     */
    public int vaacBatch(int indexVacc, int indexHC) {
    	int vaccBatch=0;
    	ArrayList<batch>vaccBatchAvailable = new ArrayList<>();
    	vaccine vaccineBatchData = getVaccineBatch(indexVacc);
    	healthCareCentre vBatchinHc = getHealthcareCentre(indexHC);
    	for(int i = 0; i < vaccineBatchData.getVaccineBatch().size();i++) {
    		batch vaccineBatch = vaccineBatchData.getVaccineBatch().get(i);
    		for(int j = 0; j < getCentreOfHealth().size();j++) {
    			healthCareCentre hcBatch = getCentreOfHealth().get(j);
    			if(hcBatch.getBatchesVaccine().contains(vaccineBatch)) {
    				vaccBatchAvailable.add(vaccineBatch);
    			}
    		}
    	}
    	for(int k = 0; k < vaccBatchAvailable.size(); k++) {
    		vaccBatch = vaccBatchAvailable.get(k).getBatchNo();
    	}
    	return vaccBatch;
    }
    
    public ArrayList<String> getVaccineBatchForAppoimtment(int indexHC, int indexVac){
    	ArrayList<String>batchData=new ArrayList<>();
    	for(int i = 0; i < getHealthcareCentre(indexHC).getBatchesVaccine().size();i++) {
    		batch newBatchInHC = getHealthcareCentre(indexHC).getBatchesVaccine().get(i);
    		for(int j = 0; j < getVaccineData().get(indexVac).getVaccineBatch().size();j++) {
    			batch newBatchInVacc = getVaccineData().get(indexVac).getVaccineBatch().get(j);
    			if(newBatchInHC.getBatchNo()==newBatchInVacc.getBatchNo()) {
    				batchData.add(String.valueOf(newBatchInHC.getBatchNo()));
    			}
    		}
    	}
    	return batchData;
    }
}