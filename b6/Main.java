package b6;

public class Main {
    public static void main(String[] args) {
        BaLo balo = new BaLo();
        balo.createBaLo();//7 4 5 6 9 2
        //12 4 6 12 11 4
        double sum = balo.sumValue();
        System.out.println(sum);
    }
}
