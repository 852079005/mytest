import cn.itlhd.utils.DateUtil2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        try {
           Date parse = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new Date().toString());
            System.out.println(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
