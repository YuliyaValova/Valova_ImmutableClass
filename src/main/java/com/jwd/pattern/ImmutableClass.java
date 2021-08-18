package com.jwd.pattern;

import java.util.Arrays;

final public class ImmutableClass {
    private final int intField;
    private final double doubleField;
    private final boolean booleanField;
    private final String stringField;
    private final int[] arrayOfInts;
    private final SomeOtherObject otherObject;
    private final SomeOtherObject[] otherObjects;

    public ImmutableClass(int intField,
                          double doubleField,
                          boolean isBooleanField,
                          String stringField,
                          int[] arrayOfInts,
                          SomeOtherObject otherObject,
                          SomeOtherObject[] otherObjects) throws CloneNotSupportedException {

        this.intField = intField;
        this.doubleField = doubleField;
        this.booleanField = isBooleanField;
        this.stringField = stringField;
        this.arrayOfInts = arrayOfInts.clone();
        this.otherObject = (SomeOtherObject) otherObject.clone();
        this.otherObjects = getSomeOtherObjects(otherObjects);
    }

    private SomeOtherObject[] getSomeOtherObjects(SomeOtherObject[] otherObjects) throws CloneNotSupportedException {
        int arraySize = otherObjects.length;
        SomeOtherObject[] array = new SomeOtherObject[arraySize];
        int numberOfObjects = 0;
        for (SomeOtherObject object : otherObjects) {
            array[numberOfObjects] = (SomeOtherObject) otherObjects[numberOfObjects].clone();
            numberOfObjects++;
        }
        return array;
    }

    public int getIntField() {
        return intField;
    }

    public double getDoubleField() {
        return doubleField;
    }

    public boolean isBooleanField() {
        return booleanField;
    }

    public String getstringField() {
        return stringField;
    }


    public SomeOtherObject getotherObject() throws CloneNotSupportedException {
        SomeOtherObject object = new SomeOtherObject();
        object = (SomeOtherObject) this.otherObject.clone();
        return object;
    }


    public int[] getArrayOfInts() {
        return arrayOfInts.clone();
    }

    public SomeOtherObject[] getOtherObjects() throws CloneNotSupportedException {
        SomeOtherObject[] objects = new SomeOtherObject[this.otherObjects.length];
        objects = getSomeOtherObjects(this.otherObjects);
        return objects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableClass that = (ImmutableClass) o;

        if (intField != that.intField) return false;
        if (Double.compare(that.doubleField, doubleField) != 0) return false;
        if (booleanField != that.booleanField) return false;
        if (stringField != null ? !stringField.equals(that.stringField) : that.stringField != null) return false;
        if (!Arrays.equals(arrayOfInts, that.arrayOfInts)) return false;
        if (otherObject != null ? !otherObject.equals(that.otherObject) : that.otherObject != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(otherObjects, that.otherObjects);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = intField;
        temp = Double.doubleToLongBits(doubleField);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (booleanField ? 1 : 0);
        result = 31 * result + (stringField != null ? stringField.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(arrayOfInts);
        result = 31 * result + (otherObject != null ? otherObject.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(otherObjects);
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "\n intField=" + intField +
                ",\n doubleField=" + doubleField +
                ",\n booleanField=" + booleanField +
                ",\n stringField='" + stringField + '\'' +
                ",\n arrayOfInts=" + Arrays.toString(arrayOfInts) +
                ",\n otherObject=" + otherObject +
                ",\n otherObjects=" + Arrays.toString(otherObjects) +
                '}';
    }
}
