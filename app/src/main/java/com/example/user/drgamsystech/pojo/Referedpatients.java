package com.example.user.drgamsystech.pojo;

public class Referedpatients
{
    private String Date,Name,status,status2 ;

    //constructor
    public Referedpatients(String date, String name, String status2)
    {
        Date = date;
        Name = name;
        this.status2 = status2;
    }
    


    public String getDate()
    {
        return Date;
    }

    public void setDate(String date)
    {
        Date = date;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }



    public String getStatus2()
    {
        return status2;
    }

    public void setStatus2(String status2)
    {
        this.status2 = status2;
    }

    /*object to string convertion*/
    @Override
    public String toString()
    {
        return "Referedpatients{" +
                "Date='" + Date + '\'' +
                ", Name='" + Name + '\'' +
                /* ", status='" + status + '\'' +*/
                ", status2='" + status2 + '\'' +
                '}';
    }





}
