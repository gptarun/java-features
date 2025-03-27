package common.designpatterns.singletondp.serializationdpissue;

import java.io.Serial;
import java.io.Serializable;

public class SerializableClass implements Serializable {
    // public instance initialized
    // when loading the class
    public static SerializableClass instance = new SerializableClass();

    private SerializableClass() {
        // private constructor
    }

    // OUTPUT without using readResolve
    // instance1 hashCode:- 1834188994
    // instance2 hashCode:- 1364335809

    /**
     * This function will not allow to create another instance, same instance will be created
     *
     * @return object of the class
     */
    @Serial
    protected Object readResolve() {
        return instance;
    }

    // OUTPUT with using readResolve
    // instance1 hashCode:- 1834188994
    // instance2 hashCode:- 1834188994
}
