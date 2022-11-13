/**
 * administrator.java is an extends class of user.java. this class will inherit the abstract class method
 *
 * @author I Ketut Mahendra
 */
public class administrator extends user
{
    //instance variable
    private String staffID;

    /**
     * constructor of administrator.java. this constructor refers to member of the superclass with super keyword
     * @param username is the username of the administrator
     * @param password is the password of the administrator
     * @param email is the email of the administrator
     * @param fullName is the full name of the administrator
     * @param staffID is the staff id of the administrator
     */
    public administrator(String username, String password, String email, String fullName, String staffID)
    {
        super(username, password, email, fullName);
        this.staffID = staffID;
    }

    /**
     * setter method for staff id of the administrator
     * @param staffID is the staff id of the administrator
     */
    public void setStaffID(String staffID)
    {
        this.staffID = staffID;
    }

    /**
     * getter method for staff id of the administrator
     * @return the staff id of the administrator
     */
    public String getStaffID()
    {
        return staffID;
    }

    //toString

    /**
     * toString method for administrator class
     * @return staff id of the administrator
     */
    @Override
    public String toString() {
        return "administrator{" +
                "staffID=" + staffID +
                '}';
    }
}
