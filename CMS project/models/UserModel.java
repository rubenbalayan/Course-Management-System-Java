package models;

import Interfaces.ILoginable;

public class UserModel implements ILoginable{
    
    private String username;
    private String pass;
    private String type;

    public UserModel(){}

    public UserModel(String username, String pass, String type)
    {
        this.username = username;
        this.pass = pass;
        this.type = type;
    }

    public UserModel(UserModel user)
    {
        this.username = user.username;
        this.pass = user.pass;
        this.type = user.type;
    }

    public void SetUsername(String username)
    {
        this.username = username;
    }
    public void SetPassword(String password)
    {
        this.pass = password;
    }
    public void SetType(String type)
    {
        this.type = type;
    }
    public String GetUsername()
    {
        return this.username;
    }
    public String GetPass()
    {
        return this.username;
    }
    public String GetType()
    {
        return this.username;
    }

    public String toString()
    {
        return username + " " + pass + " " + type;
    }
}
