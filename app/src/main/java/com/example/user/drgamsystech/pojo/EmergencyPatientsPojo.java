package com.example.user.drgamsystech.pojo;

public class EmergencyPatientsPojo
{
    String EPDate,EpName,EpGender;
    int EpTime,EpAge,Epsys,EpDia,EpPulse;

    public EmergencyPatientsPojo()
    {

    }

    public EmergencyPatientsPojo(String EPDate, String epName, String epGender, int epTime, int epAge, int epsys, int epDia, int epPulse)
    {
        this.EPDate = EPDate;
        this.EpName = epName;
        this.EpGender = epGender;
        this.EpTime = epTime;
        this.EpAge = epAge;
        this.Epsys = epsys;
        this.EpDia = epDia;
        this.EpPulse = epPulse;
    }

    public String getEPDate() {
        return EPDate;
    }

    public void setEPDate(String EPDate) {
        this.EPDate = EPDate;
    }

    public String getEpName() {
        return EpName;
    }

    public void setEpName(String epName) {
        EpName = epName;
    }

    public String getEpGender() {
        return EpGender;
    }

    public void setEpGender(String epGender) {
        EpGender = epGender;
    }

    public int getEpTime() {
        return EpTime;
    }

    public void setEpTime(int epTime) {
        EpTime = epTime;
    }

    public int getEpAge() {
        return EpAge;
    }

    public void setEpAge(int epAge) {
        EpAge = epAge;
    }

    public int getEpsys() {
        return Epsys;
    }

    public void setEpsys(int epsys) {
        Epsys = epsys;
    }

    public int getEpDia() {
        return EpDia;
    }

    public void setEpDia(int epDia) {
        EpDia = epDia;
    }

    public int getEpPulse() {
        return EpPulse;
    }

    public void setEpPulse(int epPulse) {
        EpPulse = epPulse;
    }


    @Override
    public String toString() {
        return "EmergencyPatientsPojo{" +
                "EPDate='" + EPDate + '\'' +
                ", EpName='" + EpName + '\'' +
                ", EpGender='" + EpGender + '\'' +
                ", EpTime=" + EpTime +
                ", EpAge=" + EpAge +
                ", Epsys=" + Epsys +
                ", EpDia=" + EpDia +
                ", EpPulse=" + EpPulse +
                '}';
    }
}
