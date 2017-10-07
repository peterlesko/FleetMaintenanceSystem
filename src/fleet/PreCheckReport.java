/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;

import java.time.LocalDate;

/**
 *
 * @author Peter Lesko
 */
public class PreCheckReport implements java.io.Serializable
{    
    private String regNo;    
    private String name;
    private int mileage;
    private LocalDate reportDate;       
    private boolean breaks;
    private boolean lights;
    private boolean mirrors;
    private String defectDetails;    
    private boolean wasServiced;
    private int ID;
    private static int counter = 0;
        
    /**
     * New pre check report is created.
     * @param regNoIn
     * @param nameIn
     * @param reportDateIn
     * @param breaksIn
     * @param lightsIn
     * @param mirrorsIn 
     */
    PreCheckReport(String regNoIn, int mileageIn, String nameIn, LocalDate reportDateIn, boolean breaksIn, boolean lightsIn, boolean mirrorsIn, String defectDetailsIn) 
    {
        regNo = regNoIn;
        mileage = mileageIn;
        name = nameIn;
        reportDate = reportDateIn;        
        breaks = breaksIn;
        lights = lightsIn;
        mirrors = mirrorsIn;
        defectDetails = defectDetailsIn; 
        wasServiced = false;
        counter++;        
        ID = counter;        
    }
        
    public String getName()
    {
        return name;
    }
    
    public int getMileage()
    {
        return mileage;
    }
    
    public boolean getWasServiced()
    {
        return wasServiced;        
    }
    
    void setWasServiced()
    {
        wasServiced = true;
    }
                
    public boolean hasAnyDefect()
    {                                  
        if ((breaks && lights && mirrors) && (defectDetails.equals("")))
        {
            return false;             
        }
        else
        {
            return true;    
        }     
    }
   
    public int getID()
    {
        return ID;
    }    
    
    public String getRegNo()
    {        
        return regNo;
    }
    
    public boolean getBreaks()
    {
       return breaks; 
    }
    
    public boolean getLights()
    {
       return lights; 
    }
    
    public boolean getMirrors()
    {
       return mirrors; 
    }
        
    public String getDefectDetails()
    {
        return defectDetails;
    }
    
    
    @Override
    public String toString()
    {
        return ("--------------------------------" + "\n" +
                "Newly created vehicle is: "  + "\n" +
                "regN = " + regNo + "\n" +
                "mileage" + mileage + "\n" +
                "name = " + name + "\n" + 
                "--------------------------------");
    }                
}
