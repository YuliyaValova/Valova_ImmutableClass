package com.jwd.pattern;

import java.util.Arrays;

final public class ImmutableClass {
    private final int INT_FIELD;
    private final double DOUBLE_FIELD;
    private final boolean IS_BOOLEAN_FIELD;
    private final String STRING_FIELD;
    private final int[] arrayOfInts;
    private final SomeOtherObject OTHER_OBJECT;
    private final SomeOtherObject[] otherObjects;

    public ImmutableClass(int intField,
                          double doubleField,
                          boolean isBooleanField,
                          String stringField,
                          int[] arrayOfInts,
                          SomeOtherObject otherObject,
                          SomeOtherObject[] otherObjects) throws CloneNotSupportedException {

        this.INT_FIELD = intField;
        this.DOUBLE_FIELD = doubleField;
        this.IS_BOOLEAN_FIELD = isBooleanField;
        this.STRING_FIELD = stringField;
        this.arrayOfInts = arrayOfInts.clone();
        this.OTHER_OBJECT = (SomeOtherObject) otherObject.clone();
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
        return INT_FIELD;
    }

    public double getDoubleField() {
        return DOUBLE_FIELD;
    }

    public boolean isBooleanField() {
        return IS_BOOLEAN_FIELD;
    }

    public String getSTRING_FIELD() {
        return STRING_FIELD;
    }


    public SomeOtherObject getOTHER_OBJECT() throws CloneNotSupportedException {
        SomeOtherObject object = new SomeOtherObject();
        object= (SomeOtherObject) this.OTHER_OBJECT.clone();
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

        if (INT_FIELD != that.INT_FIELD) return false;
        if (Double.compare(that.DOUBLE_FIELD, DOUBLE_FIELD) != 0) return false;
        if (IS_BOOLEAN_FIELD != that.IS_BOOLEAN_FIELD) return false;
        if (STRING_FIELD != null ? !STRING_FIELD.equals(that.STRING_FIELD) : that.STRING_FIELD != null) return false;
        if (!Arrays.equals(arrayOfInts, that.arrayOfInts)) return false;
        if (OTHER_OBJECT != null ? !OTHER_OBJECT.equals(that.OTHER_OBJECT) : that.OTHER_OBJECT != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(otherObjects, that.otherObjects);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = INT_FIELD;
        temp = Double.doubleToLongBits(DOUBLE_FIELD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (IS_BOOLEAN_FIELD ? 1 : 0);
        result = 31 * result + (STRING_FIELD != null ? STRING_FIELD.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(arrayOfInts);
        result = 31 * result + (OTHER_OBJECT != null ? OTHER_OBJECT.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(otherObjects);
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "\n INT_FIELD=" + INT_FIELD +
                ",\n DOUBLE_FIELD=" + DOUBLE_FIELD +
                ",\n IS_BOOLEAN_FIELD=" + IS_BOOLEAN_FIELD +
                ",\n STRING_FIELD='" + STRING_FIELD + '\'' +
                ",\n arrayOfInts=" + Arrays.toString(arrayOfInts) +
                ",\n OTHER_OBJECT=" + OTHER_OBJECT +
                ",\n otherObjects=" + Arrays.toString(otherObjects) +
                '}';
    }
}
