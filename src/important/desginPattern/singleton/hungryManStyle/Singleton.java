package important.desginPattern.singleton.hungryManStyle;

import java.io.Serializable;

/**
 * @author qcy
 * @create 2021/06/03 15:06:16
 * 饿汉式
 */
public class Singleton implements Serializable {

    private static final Singleton instance = new Singleton();

    private Singleton() {
        //避免反射破坏
        if (instance != null) {
            throw new RuntimeException("unable to create instance");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    //避免序列化破坏
    private Object readResolve() {
        return instance;
    }

}
