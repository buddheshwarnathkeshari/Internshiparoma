package com.buddheshwar.internshiparoma;

public class SignOperations {

    public static String validateUser(String userName, String userPhone, String userEmail, String password, String confirmPassword)
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPatternAlphabets = "(.*)[a-zA-Z]+(.*)";
        String passwordPatternNumerics = "(.*)[0-9]+(.*)";
        String phonePattern="[0-9](10)";

        if (userEmail.matches(emailPattern)!=true)
        {
            return "Invalid Email Id";
        }
        else if(password.matches(""))
        {
            return "Password is required!" ;
        }
        else if(userPhone.length()!=10 && userPhone.length()>0)
        {
            return "Invalid Mobile Number" ;
        }
        else if(password.length()<6)
        {
            return "Password should contain minimum 6 characters" ;
        }
        else if (password.matches(passwordPatternAlphabets)!=true)
        {
            return "Password should also contain alphabets";
        }
        else if (password.matches(confirmPassword)!=true)
        {
            return "Confirm Password doesn't match with password";

        }
        else if (password.matches(passwordPatternNumerics)!=true)
        {
            return "Password should also contain at least one number";
        }
        return "Valid";

    }



    public static String validateLoginUser(String userEmail, String password)
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPatternAlphabets = "(.*)[a-zA-Z]+(.*)";
        String passwordPatternNumerics = "(.*)[0-9]+(.*)";

        if (userEmail.matches(emailPattern)!=true)
        {
            return "Invalid Email Id";
        }
        else if(password.matches(""))
        {
            return "Password is required!" ;
        }
        else if(password.length()<6)
        {
            return "Password should contain minimum 6 characters" ;
        }
        else if (password.matches(passwordPatternAlphabets)!=true)
        {
            return "Password should also contain alphabets";
        }
        else if (password.matches(passwordPatternNumerics)!=true)
        {
            return "Password should also contain at least one number";
        }
        return "Valid";

    }

    public static String validateMail(String userEmail)
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userEmail.matches(emailPattern)!=true)
        {
            return "Invalid Email Id";
        }
        return "Valid";
    }

    public static String validatePassword( String password, String confirmPassword)
    {
        String passwordPatternAlphabets = "(.*)[a-zA-Z]+(.*)";
        String passwordPatternNumerics = "(.*)[0-9]+(.*)";
        String phonePattern="[0-9](10)";

        if(password.matches(""))
        {
            return "Password is required!" ;
        }
        else if(password.length()<6)
        {
            return "Password should contain minimum 6 characters" ;
        }
        else if (password.matches(passwordPatternAlphabets)!=true)
        {
            return "Password should also contain alphabets";
        }
        else if (password.matches(confirmPassword)!=true)
        {
            return "Confirm Password doesn't match with password";

        }
        else if (password.matches(passwordPatternNumerics)!=true)
        {
            return "Password should also contain at least one number";
        }
        return "Valid";
    }

    public static String validateContact(String userName, String userPhone, String userEmail,String userMsg)
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String phonePattern="[0-9](10)";

        if (userEmail.matches(emailPattern)!=true)
        {
            return "Invalid Email Id";
        }
        else if(userPhone.length()!=10)
        {
            return "Invalid Mobile Number" ;
        }
        else if(userName.length()<=0){
            return "Name is required";
        }
        else if(userMsg.length()<10){
            return "Message should contain atleast one line.";
        }
        return "Valid";
    }

}
