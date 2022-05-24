package com.example.myrproject;

public class refrigeitem {
    private int id;
    private String type;
    private String name;
    private int cnt;
    private String unit;
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

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
