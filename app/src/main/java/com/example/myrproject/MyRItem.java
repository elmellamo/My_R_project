package com.example.myrproject;

public class MyRItem {
    private int id;
    private String type;
    private String name;
    private String cnt;
    private String unit;
    private String writedate;
    //Alt + Insert(gettersetter)(Constructor-> selectNone)(빈 생성자)
    //Alt + Insert -> gettersetter -> control+a 다잡고 enter

    public MyRItem() {
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

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }
}
