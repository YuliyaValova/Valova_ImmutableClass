package com.jwd;

import com.jwd.pattern.ImmutableClass;
import com.jwd.pattern.SomeOtherObject;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] ints = {1, 2, 3};
        SomeOtherObject[] arrayOfInternalObjects = creatingInternalObjectsArray();
        SomeOtherObject internalObject = new SomeOtherObject(5, "KY");
        ImmutableClass immutableObject = new ImmutableClass(8,
                5.03,
                false,
                "HELLO",
                ints,
                internalObject,
                arrayOfInternalObjects);

        System.out.println(immutableObject.toString() + "\n ____________");
      /*  internalObject=new SomeOtherObject(999, "ERROR");
        arrayOfInternalObjects[1]=internalObject;
        System.out.println(immutableObject.toString()+"\n ____________");
        System.out.println(arrayOfInternalObjects[1]);*/

     /* SomeOtherObject obj= immutableObject.getOTHER_OBJECT();
       obj.setObjectString("ERROR");
        System.out.println(immutableObject.getOTHER_OBJECT().getObjectString());*/

       /* SomeOtherObject[] array = immutableObject.getOtherObjects();
        array[1].setObjectString("Error");
        System.out.println(immutableObject.toString() + "\n ____________");*/

    }

    private static SomeOtherObject[] creatingInternalObjectsArray() {
        SomeOtherObject internalObject1 = new SomeOtherObject();
        SomeOtherObject internalObject2 = new SomeOtherObject(5, "Lol");
        SomeOtherObject internalObject3 = new SomeOtherObject(15, "Olo");
        SomeOtherObject[] array = {internalObject1, internalObject2, internalObject3};
        return array;
    }
}
