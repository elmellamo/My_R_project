package com.example.myrproject;

public class refrigeitem {
    private int id;
    private String loc;
    private String type;
    private String name;
    //Alt + Insert(gettersetter)(Constructor-> selectNone)(빈 생성자)
    //Alt + Insert -> gettersetter -> control+a 다잡고 enter
    public refrigeitem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
