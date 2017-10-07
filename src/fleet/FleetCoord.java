/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*; 

/**
 *
 * @author Peter Lesko
 */
public class FleetCoord implements java.io.Serializable
{
    private transient Driver driver;
    private transient Manager manager;
    private transient Mechanic mechanic;   
    private transient LocalDate localNow;   
    private Map<String, Vehicle> vehicles;    
    private Vehicle vehic;    
    private Map<Integer, PreCheckReport> reports;
    private PreCheckReport report;  
    private ScheduledService scheduledService;    
    private Map<Integer, ScheduledService> scheduledServices;    
    private int notifPeriod;
                
    /**
     * New coordinating object is created. 
     */
    FleetCoord()
    {
        driver = new Driver();
        manager = new Manager();
        mechanic = new Mechanic();                 
        vehicles = new HashMap<>();
        reports = new HashMap<>();
        localNow = LocalDate.now();
        scheduledServices = new HashMap<>();
        notifPeriod = 30;
    }
      
    public Map getScheduledServices()
    {
        return scheduledServices;
    }
    
    public Map getReports()
    {
        return reports;
    }    
    
    public int setNotifPeriod(int valueIn)
    {        
        notifPeriod = valueIn;    
        return notifPeriod; 
    }
        
    public int getNotifPeriod()
    {
        return notifPeriod;
    }
            
    /**
     * New singleton coordinating object is created.
     */
    public static FleetCoord getFleetCoordObject()  
    {
        FleetCoord fleet = null;
        try
        {            
            File fl = new File("Fleet.ser");
            FileInputStream flInpStr = new FileInputStream(fl);
            ObjectInputStream objInpStr = new ObjectInputStream(flInpStr);
            fleet = (FleetCoord)objInpStr.readObject();                       
            flInpStr.close();
            objInpStr.close();            
        }
        catch (IOException | ClassNotFoundException ex)
        {
            fleet = new FleetCoord();
        }            
        return fleet;
    }

    /**
     * The state of the coordinating object is saved when program is closed. 
     */
    public void saveFleetCoordObject()   
    {
        try
        {
            File fl = new File("Fleet.ser");
            FileOutputStream flOutStr = new FileOutputStream(fl); 
            ObjectOutputStream objoutstr = new ObjectOutputStream(flOutStr);
            objoutstr.writeObject(this);           
            flOutStr.close();
            objoutstr.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
     }
    
    /**
     * Adds schedule to the collection  
     * @param regNoIn
     * @param defectedItemsIn
     * @param defectDetailsIn
     * @param mechanicsIn
     * @param regulServiceIn
     * @param CVRTServiceIn
     * @param reportDefectsIn 
     */
    public void addScheduledService(String regNoIn, List<String> defectedItemsIn, String defectDetailsIn, String[] mechanicsIn, 
                                    boolean regulServiceIn, boolean CVRTServiceIn, boolean reportDefectsIn)
    {
        scheduledService = new ScheduledService(regNoIn, defectedItemsIn, defectDetailsIn, mechanicsIn, regulServiceIn, CVRTServiceIn, reportDefectsIn);                
        scheduledServices.put(scheduledService.getID(), scheduledService);                
    }
          
    /**
     * Returns the set reg. numbers of the vehicles for which regular service alert is raised.
     * @return 
     */      
    public Set getRegServiceDateAlerts()
    {     
        Set<String> listForRegService = new HashSet<>();
        
        for (String each : vehicles.keySet())
        {            
            LocalDate vehicleDate = vehicles.get(each).getRegServiceDate();                        

            long difference = ChronoUnit.DAYS.between(localNow, vehicleDate);
            
            if (difference < notifPeriod)
            {
                listForRegService.add(each);            
            }
        }               
        return listForRegService;
    }
    
    /**
     * Returns the set of reg. numbers of the vehicles for which is CVRT expire date alert is raised.
     * @return 
     */
    public Set getCVRTExpireDateAlerts() 
    {     
        Set<String> listForVRTExpire = new HashSet<>();
        
        for (String each : vehicles.keySet())
        {                                   
            LocalDate vehicleDate = vehicles.get(each).getCVRTExpireDate();
            long difference = ChronoUnit.DAYS.between(localNow, vehicleDate);
               
            if (difference < notifPeriod)
            {
                listForVRTExpire.add(each);            
            }
        }               
        return listForVRTExpire;
    }
    
        
    public Set getTaxExpireDateAlerts()
    {
        Set<String> listForTaxExpire = new HashSet<>();
        
        for (String each : vehicles.keySet())
        { 
            LocalDate vehicleDate = vehicles.get(each).getTaxExpireDate();
            long difference = ChronoUnit.DAYS.between(localNow, vehicleDate);
            
            if (difference < notifPeriod)
            {
                listForTaxExpire.add(each);            
            }
        }        
        return listForTaxExpire;
    }
                      
   /**
    * Adds the vehicle to a collection. 
    * @param brand
    * @param regNo
    * @param mileage
    * @param regServiceDate
    * @param CVRTExpDate
    * @param taxExpDate
    * @param vehicleMessage 
    */ 
    public void addVehicle(String brand, String regNo, int mileage, LocalDate regServiceDate, LocalDate CVRTExpDate, LocalDate taxExpDate, String vehicleMessage)
    {  
        vehic = new Vehicle(brand, regNo, mileage, regServiceDate, CVRTExpDate, taxExpDate, vehicleMessage); 
        
        try 
        {
            vehicles.put(vehic.getRegNo(), vehic);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }       
    
    /**
     * Indicates that report has been set for service
     * @param report 
     */
    public void setForService(PreCheckReport report)
    {
        report.setWasServiced();
    }
    
        
    /**
     * Creates new report.
     * @param regN
     * @param name
     * @param reportDateIn
     * @param breaks
     * @param lights
     * @param mirrors 
     */
    public void saveAddReport(String regN, String name, int mileage, LocalDate reportDateIn, boolean breaks, boolean lights, boolean mirrors, String defectDetails) 
    {               
        try
        {
            report = new PreCheckReport(regN, mileage, name, reportDateIn, breaks, lights, mirrors, defectDetails); 
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        report.toString();        
        Integer i = report.getID();
        
        try
        {
            reports.put(i, report);                        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }                      
    }
        
    /**
     * Returns all vehicles.
     */
    public Map getVehicles()
    {
        return vehicles;
    }
    
    /**
     * Returns all reg. no of all vehicles. 
     */
    public Set getKeys()
    {
       return vehicles.keySet(); 
    }
    
    /**
     * Delete specific vehicle.
     */
    public boolean deleteVehicle(String keyIn)
    {
        this.vehicles.remove(keyIn);
        if (!vehicles.containsKey(keyIn))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
            
    /**
     * Verifies validity of the password. 
    */        
    public boolean checkPassword(String employeePosIn, String passwString)
    {
        
        if (employeePosIn.equals("manager") && passwString.equals(manager.getPassword()))
        {
            return true;
        }        
        else if (employeePosIn.equals("driver") && passwString.equals(driver.getPassword()))
        {
            return true;
        }
        else if (employeePosIn.equals("mechanic") && passwString.equals(mechanic.getPassword()))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }                  
}
