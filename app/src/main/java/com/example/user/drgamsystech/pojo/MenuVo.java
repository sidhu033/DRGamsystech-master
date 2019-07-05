package com.example.user.drgamsystech.pojo;

public class MenuVo
{
    public String img;
    public String imgName;

    public MenuVo(String img, String imgName)
    {
        this.img = img;
        this.imgName = imgName;
    }


    /*Getter and Setter*/
    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }

    /*ToString Method OBject ot string Representation*/
    @Override
    public String toString()
    {
        return "MenuVo{" +
                "img='" + img + '\'' +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
