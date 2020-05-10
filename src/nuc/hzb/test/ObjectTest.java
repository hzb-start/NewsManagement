package nuc.hzb.test;

/**
 * @author 黄朝博
 */
public class ObjectTest {

    public static void testObject1(Object... params){
        for (Object object : params) {
            System.out.println(object);
        }
    }
    public static void testObject2(Object[] params){
        for (Object object : params) {
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        testObject1(1, "黄", 1.5, false);
        testObject1();
        testObject2(new Object[]{2, "白"});
        // testObject2(); 空参数报错
    }
}
