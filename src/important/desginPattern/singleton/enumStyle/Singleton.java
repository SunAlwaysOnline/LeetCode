package important.desginPattern.singleton.enumStyle;

/**
 * @author qcy
 * @create 2021/06/03 15:19:19
 * 枚举方式
 */
public enum Singleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
