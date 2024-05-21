package util;

public class ColorText {
    //use ANSI escape codes for colored text
    //Each ANSI escape sequence starts with ESC(\u001B) means the following characters are a control sequence
    //m means the end of control code and the number is color code
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[96m";

    public static String colorText(String text, String colorCode){
        return colorCode + text + RESET;
    }
}
