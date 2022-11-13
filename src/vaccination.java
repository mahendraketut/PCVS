/**
 * class vaccination is a class that will be a class for vaccination data
 *
 * @author I Ketut Mahendra
 */
public class vaccination
{
    private String vaccinationID;
    private String appointmentDate;
    private String status;
    private String remarks;

    /**
     * constructor for class vaccination
     * @param vaccinationID is the parameter for the id of vaccination
     * @param appointmentDate is the parameter for the appointment date inputted by the user for vaccination
     * @param status is the parameter for vaccination status
     * @param remarks is the parameter for the remarks of the vaccination progress/condition
     */
    public vaccination(String vaccinationID, String appointmentDate, String status, String remarks)
    {
        this.vaccinationID = vaccinationID;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.remarks = remarks;
    }

    /**
     * setter method for vaccination id
     * @param vaccinationID is the parameter for vaccination id
     */
    public void setVaccinationID(String vaccinationID)
    {
        this.vaccinationID = vaccinationID;
    }

    /**
     * setter method for appointment date of vaccination
     * @param appointmentDate is the parameter for appointment date for vaccination
     */
    public void setAppointmentDate(String appointmentDate)
    {
        this.appointmentDate = appointmentDate;
    }

    /**
     * setter method for vaccination status
     * @param status is the parameter for vaccination status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * setter method for vaccination remarks
     * @param remarks is the parameter for vaccination remarks
     */
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    /**
     * getter method for vaccination id
     * @return the vaccination id will be returned
     */
    public String getVaccinationID()
    {
        return vaccinationID;
    }

    /**
     * getter method for vaccination appointment date
     * @return the appointment date that inputted by patient will be returned
     */
    public String getAppointmentDate()
    {
        return appointmentDate;
    }

    /**
     * getter method for vaccination status
     * @return the vaccination status will be returned
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * getter method for vaccination remarks
     * @return the vaccination remarks will be returned
     */
    public String getRemarks()
    {
        return remarks;
    }

    /**
     * toString method for vaccination class
     * @return the vaccination id, appointment date, status, and remarks will be returned
     */
    @Override
    public String toString()
    {
        return "vaccination{" +
                "vaccinationID=" + vaccinationID +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
