package com.example.user.drgamsystech.pojo;

public class Follouppojo
{
    private String fDate,fName,fstatus ;

    //constructor
    public Follouppojo(String fdate, String fname, String fstatus)
    {
        this.fDate = fdate;
        this.fName = fname;
        this.fstatus = fstatus;
    }

    public String getfDate()
    {
        return fDate;
    }

    public void setfDate(String fDate)
    {
        this.fDate = fDate;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getFstatus()
    {
        return fstatus;
    }

    public void setFstatus(String fstatus)
    {
        this.fstatus = fstatus;
    }

    /*to string method*/
    @Override
    public String toString()
    {
        return "Follouppojo{" +
                "fDate='" + fDate + '\'' +
                ", fName='" + fName + '\'' +
                ", fstatus='" + fstatus + '\'' +
                '}';
    }
}
