/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;

import java.util.List;

/**
 *
 * @author pet1
 */
public class ScheduledService implements java.io.Serializable
{    
    private String regNo;
    private List<String> defectedItems;    
    private String defectDetails;
    private String[] mechanics;
    private boolean regulServiceChBox;  
    private boolean CVRTChBox;   
    private boolean reportDefectsChBox;    
    private int ID;
    private static int counter = 0;
      
    ScheduledService(String regNoIn, List<String> defectedItemsIn, String defectDetailsIn, String[] mechanicsIn, 
                      boolean regulServiceIn, boolean CVRTIn, boolean reportDefects)
    {
        regNo = regNoIn;
        defectedItems = defectedItemsIn;
        defectDetails = defectDetailsIn;
        mechanics = mechanicsIn; 
        counter++;        
        ID = counter;    
        regulServiceChBox = regulServiceIn;
        CVRTChBox = CVRTIn;               
        reportDefectsChBox = reportDefects;       
    }
    
    public String getDefectDetails()
    {
        return defectDetails;
    }
    
    public List<String> getDefectedItems()
    {
        return defectedItems;
    }
    
    public String getRegNo()
    {
        return regNo;
    }
    
    public boolean getRegulServiceChBox()
    {
        return regulServiceChBox; 
    }
    
    public boolean getCVRTChBox()
    {
        return CVRTChBox; 
    }    
    
    public boolean getReportDefectsChBox()
    {
        return reportDefectsChBox; 
    }  
                                        
    public int getID()
    {
        return ID;
    } 
    
    public String[] getMechanics()
    {
        return mechanics; 
    }
            
    @Override
    public String toString()
    {
        return ("--------------------------------" + "\n" +
                "Newly created vehicle is: "  + "\n" +
                "regN = " + regNo + "\n" +
                "defectDetails = " + defectDetails + "\n" + 
                "--------------------------------");
    }      
}
