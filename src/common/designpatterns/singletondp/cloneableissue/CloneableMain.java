package common.designpatterns.singletondp.cloneableissue;

public class CloneableMain {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.instance;
        SingletonClass instance2 = (SingletonClass) instance1.clone();
        System.out.println("instance1 hashCode:- " + instance1.hashCode());
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
    }
}
