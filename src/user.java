/**
 * user.java is an abstract class that will be inherited in child class patient.java and administrator.java
 *
 * @author I Ketut Mahendra
 */
public abstract class user
{
    //instance variable
    private String username;
    private String password;
    private String email;
    private String fullName;

    /**
     * the constructor of user.java
     * @param username is the username of the user
     * @param password is the password of the user
     * @param email is the email address of the user
     * @param fullName is the full name of the user
     */
    public user(String username, String password, String email, String fullName)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * setter method for username of the user
     * @param username is the parameter of the method that contain the username of the user
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * setter method for password of the user
     * @param password is the parameter of this method that contain the password of the user
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * setter method for email of the user
     * @param email is the parameter of this method that contain the email of the user
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * setter method for full name of the user
     * @param fullName is the parameter of this method that contain the full name of the user
     */
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    /**
     * getter method for username of the user
     * @return username of the user
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * getter method for password of the user
     * @return password of the user
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * getter method for email of the user
     * @return email of the user
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * getter method for full name of the user
     * @return full name of the user
     */
    public String getFullName()
    {
        return fullName;
    }

    /**
     * to string method for user.java
     * @return the username, password, email, and full name of the user
     */
    @Override
    public String toString()
    {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

}
