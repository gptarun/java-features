package common.designpatterns.singletondp.serializationdpissue;

import java.io.*;

public class SerializableMain {
    public static void main(String[] args) {
        SerializableClass serializableClass = SerializableClass.instance;

        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(serializableClass);
            out.close();
            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
            SerializableClass instance2 = (SerializableClass) in.readObject();
            in.close();
            System.out.println("instance1 hashCode:- " + serializableClass.hashCode());
            System.out.println("instance2 hashCode:- " + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
