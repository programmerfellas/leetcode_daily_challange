package Q_1323_Maximum69Number;

public class Maximum69Number {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        for(int i = 0; i < sb.length();i++) {
            if(sb.charAt(i) == '6') {
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
