package important.desginPattern.singleton.staticInnerClass;

/**
 * @author qcy
 * @create 2021/06/03 15:16:56
 * 静态内部类
 */
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {
    }

    public Singleton getInstance() {
        return SingletonHolder.instance;
    }

}
