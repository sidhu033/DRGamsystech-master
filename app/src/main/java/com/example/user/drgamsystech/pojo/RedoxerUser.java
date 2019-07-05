package com.example.user.drgamsystech.pojo;

import android.media.Image;

public class RedoxerUser
{
    int image;
    String name;
    String age;
    String gender;

    /*parameterized constructor*/
    public RedoxerUser(int image, String name, String age,String gender)
    {
        this.name = name;
        this.image = image;
        this.age = age;
        this.gender = gender;
    }

    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /*To String method*/
    @Override
    public String toString()
    {
        return "RedoxerUser{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
