package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {
    public static String getUniqueStringWithDate(String str){
      return str +  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }


    public static String getUniqueString(String str){
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
