package comp3350.umhub.business;

import java.util.List;

public class Utils {

    public static String listToString(List list) {
        String res = "List:";
        res += "\n";
        if (list != null) {
            for (Object c : list) {
                res += " " + c.toString() + "\n";
            }
        }
        return res;
    }


    public static String listToString(List list, String lname) {
        String res = "List:";
        if (lname != null) res += lname;
        res += "\n";
        if (list != null) {
            for (Object c : list) {
                res += " " + c.toString() + "\n";
            }
        }
        return res;
    }

}

