/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;

/**
 *
 * @author pet1
 */
public class Driver
{
    private String password; 

    
    Driver()
    {
        setPassword("d");
    }
    
    public String getPassword()
    {
        return password;
    }

    void setPassword(String passwordIn)
    {
        password = passwordIn;
    }   
}
