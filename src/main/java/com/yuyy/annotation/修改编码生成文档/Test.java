

/**
 * description: 测试类 <br>
 * version: 1.0 <br>
 * date: 2020/7/12 15:50 <br>
 * author: objcat <br>
 *
 * @param null
 * @return
 */
@MyAnno1
public class Test {

    /**
     * description: 有注解的方法 <br>
     * version: 1.0 <br>
     * date: 2020/7/12 15:51 <br>
     * author: objcat <br>
     *
     * @param param1
     * @param param2
     * @return void
     */
    @MyAnno1
    public static void method1(int param1,int param2){

    }

    public void mnethod2() {
        method1(1, 2);
    }
}
