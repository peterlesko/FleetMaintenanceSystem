/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;

/**
 *
 * @author Peter Lesko
 */
public class Mechanic
{
    private String password; 

    Mechanic()
    {
        setPassword("mc");
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
