package designPatterns.Creational;

import java.util.regex.Pattern;

public class Caller {
    public static void main(String[] args) {
        Pattern adminPattern = Pattern.compile("\\d{10}");
        System.out.println(adminPattern.matcher("123456789").find());
    }
}
