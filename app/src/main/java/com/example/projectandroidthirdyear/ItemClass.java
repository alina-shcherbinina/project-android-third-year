package com.example.projectandroidthirdyear;

public class ItemClass {

    private int img;
    private String name;
    private int index;

    public ItemClass(int img, String name, int index) {
        this.img = img;
        this.name = name;
        this.index = index;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getIndex() { return index; }

}