package com.jwd.pattern;

public class SomeOtherObject implements Cloneable {
    private int objectInt;
    private String objectString;

    public SomeOtherObject(int objectInt, String objectString) {
        this.objectInt = objectInt;
        this.objectString = objectString;
    }

    public SomeOtherObject() {
        this.objectInt = 0;
        this.objectString = "";
    }

    public int getObjectInt() {
        return objectInt;
    }

    public void setObjectInt(int objectInt) {
        this.objectInt = objectInt;
    }

    public String getObjectString() {
        return objectString;
    }

    public void setObjectString(String objectString) {
        this.objectString = objectString;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        SomeOtherObject object = new SomeOtherObject();
        object.setObjectInt(objectInt);
        object.setObjectString(objectString);
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeOtherObject that = (SomeOtherObject) o;

        if (objectInt != that.objectInt) return false;
        return objectString != null ? objectString.equals(that.objectString) : that.objectString == null;
    }

    @Override
    public int hashCode() {
        int result = objectInt;
        result = 31 * result + (objectString != null ? objectString.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "objectInt=" + objectInt +
                ",objectString='" + objectString + '\'' +
                '}';
    }
}
