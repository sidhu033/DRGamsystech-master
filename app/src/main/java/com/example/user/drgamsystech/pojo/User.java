package com.example.user.drgamsystech.pojo;

public class User
{
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String almobile;
    private String houseno;
    private String streetaddress;
    private String area;
    private String ciy;
    private String state;

    public User()
    {

    }

    public User(int id, String name, String email, String mobile, String almobile, String houseno, String streetaddress, String area, String ciy, String state)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.almobile = almobile;
        this.houseno = houseno;
        this.streetaddress = streetaddress;
        this.area = area;
        this.ciy = ciy;
        this.state = state;
    }

    public User(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlmobile() {
        return almobile;
    }

    public void setAlmobile(String almobile) {
        this.almobile = almobile;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCiy() {
        return ciy;
    }

    public void setCiy(String ciy) {
        this.ciy = ciy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
