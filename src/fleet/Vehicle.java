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
public class Vehicle implements java.io.Serializable
{
    private String brand;
    private String regNo;
    private int mileage;
    private LocalDate regServiceDate;    
    private LocalDate CVRTExpireDate;    
    private LocalDate taxExpireDate;    
    private String vehicleMessage;
    
    Vehicle(String brandIn, String regNoIn, int mileageIn, LocalDate regServiceDateIn, LocalDate CVRTExpireDateIn, LocalDate taxExpireDateIn, String vehicleMessageIn)
    {
        brand = brandIn;
        regNo = regNoIn;
        mileage = mileageIn;
        regServiceDate = regServiceDateIn;
        CVRTExpireDate = CVRTExpireDateIn;
        taxExpireDate = taxExpireDateIn;
        vehicleMessage = vehicleMessageIn;        
    }
          
    public String getBrand()
    {
        return brand;
    }

    void setBrand(String brand)
    {
        brand = brand;
    }

    public String getRegNo()
    {
        return regNo;
    }
                   
    void setRegNo(String regNo)
    {
        regNo = regNo;
    }
    
    public LocalDate getRegServiceDate()
    {
        return regServiceDate;
    }
        
    void setRegServiceDate(LocalDate regServiceDate)
    {
        regServiceDate = regServiceDate;
    }
                  
    public LocalDate getCVRTExpireDate()
    {
        return CVRTExpireDate;
    }

    void setCvrtDate(LocalDate CVRTExpireDateIn)
    {
        CVRTExpireDate = CVRTExpireDateIn;
    }
   
    public LocalDate getTaxExpireDate()
    {
        return taxExpireDate;
    }

    void setTaxExpireDate(LocalDate taxExpireDateIn)
    {
        taxExpireDate = taxExpireDateIn;
    }

    public int getMileage()
    {
        return mileage;
    }

    void setMileage(int mileage)
    {
        mileage = mileage;
    }

    public String getVehicleMessage()
    {
        return vehicleMessage;
    }

    void setVehicleMessage(String vehicleMessage)
    {
        vehicleMessage = vehicleMessage;
    }    
    
    @Override
    public String toString()
    {
        return ("--------------------------------" + "\n" +
                "brand = " + brand + "\n" +
                "regNo = " + regNo + "\n" + 
                "mileage = " + mileage + "\n" +
                "--------------------------------");
    }    
}
