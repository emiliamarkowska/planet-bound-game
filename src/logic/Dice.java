package logic;

public class Dice {

    public static int throwd6(){
        return (int) (Math.random() * 6 + 1);
    }

    public static int throwd6twice(){
        return (int)(Math.random() * 12 + 1);
    }

    public static int throwd3(){
        return (int)(Math.random() * 3 + 1);
    }

    public static int throwd2(){
        return (int)(Math.random() * 2 + 1);
    }

    public static int throwd8() {
        return (int)(Math.random() * 8 + 1);
    }
}
