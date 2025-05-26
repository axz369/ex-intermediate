package com.example.form;

public class ClothForm {
    /** 性別 */
    private Integer gender;

    /** 性別 */
    private String color;


    // getter setter
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "ClothForm{" +
                "gender=" + gender +
                ", color='" + color + '\'' +
                '}';
    }
}
