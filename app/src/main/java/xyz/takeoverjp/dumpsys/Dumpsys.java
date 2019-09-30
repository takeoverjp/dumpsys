package xyz.takeoverjp.dumpsys;

import android.util.Log;

public final class Dumpsys {
    static public String[] list() {
        String[] result = {};
        try {
            result = CommandExecuter.execCommand("dumpsys -l").split("\n", 0);
        } catch (Exception e) {
            Log.e("ServiceUtil", "exception: class = " + e.getClass() + ", message = " + e.getMessage());
        }

        return result;
    }

    static public String dump(String name) {
        String result = "";
        try {
            result = CommandExecuter.execCommand("dumpsys " + name);
        } catch (Exception e) {
            Log.e("ServiceUtil", "exception: class = " + e.getClass() + ", message = " + e.getMessage());
        }
        return result;
    }
}

