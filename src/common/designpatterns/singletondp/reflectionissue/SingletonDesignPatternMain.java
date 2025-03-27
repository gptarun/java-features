package common.designpatterns.singletondp.reflectionissue;

import java.lang.reflect.Constructor;

public class SingletonDesignPatternMain {
    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.singletonClass;
        SingletonClass singletonClass2;

        SingletonReflection singletonReflection = SingletonReflection.INSTANCE;
        SingletonReflection singletonReflection1 = null;

        try {
            System.out.println("singletonClass.hashCode():- " + singletonClass.hashCode());
            Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            singletonClass2 = constructor.newInstance();
            System.out.println("singletonClass2.hashCode():- " + singletonClass2.hashCode());

            /*
             * You will get exception here java.lang.NoSuchMethodException:
             * com.designpatterns.singletondp.reflectionissue.SingletonReflection.<init>()
             * at getDeclaredConstructor() (SingletonDesignPatternMain.java:25)
             */
            Constructor<SingletonReflection> constructor1 = SingletonReflection.class.getDeclaredConstructor();
            constructor1.setAccessible(true);
            singletonReflection1 = constructor1.newInstance();
            System.out.println("singletonReflection.hashCode():- " + singletonReflection.hashCode());
            System.out.println("singletonReflection1.hashCode():- " + singletonReflection1.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
