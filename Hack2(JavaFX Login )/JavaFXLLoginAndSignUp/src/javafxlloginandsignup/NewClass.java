package javafxlloginandsignup;

import java.util.regex.Pattern;

public class NewClass {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([a-z0-9_\\-\\.])+\\@([a-z0-9_\\-\\.])+\\.([a-z]{2,4})$");
        System.out.println(pattern.matcher("mu@gmail.com").matches());
    }
}
