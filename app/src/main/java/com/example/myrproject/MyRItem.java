package com.example.myrproject;

public class MyRItem {
    private int id;
    private String food;
    private String info;
    private String type;
    private String name;
    private String cnt;
    private String unit;
    private String writedate;
    //Alt + Insert(gettersetter)(Constructor-> selectNone)(빈 생성자)
    //Alt + Insert -> gettersetter -> control+a 다잡고 enter

    public MyRItem() {
    }

    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }


    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
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

    public String getWriteDate() {
        return writedate;
    }

    public void setWriteDate(String writedate) {
        this.writedate = writedate;
    }
}
