import java.lang.annotation.*;


/**
 * description:  ����һ��ע��<br>
 * version: 1.0 <br>
 * date: 2020/7/12 15:42 <br>
 * author: objcat <br>
 * 
 * @param null
 * @return 
 */ 
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno1 {
}
