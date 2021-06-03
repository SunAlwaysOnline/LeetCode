package important.desginPattern.singleton.doubleCheckedLocking;

/**
 * @author qcy
 * @create 2021/06/03 14:43:10
 * 双重检验锁
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {
    }

    public Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
