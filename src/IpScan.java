import java.util.ArrayList;
import java.util.List;

public class IpScan {

    public static void main(String[] args) {
        IpScan ipScan = new IpScan();
        List<String> all = ipScan.getAll("25525511135");
        System.out.println(all);
    }

    public List<String> getAll(String number) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        function(number, 0, sb, result, 0);
        return result;
    }

    public void function(String number, int start, StringBuilder sb, List<String> result, int count) {
        if ((number.length() - start) > (3 * (4 - count))) {
            return;
        }
        if (number.length() == start) {
            if (count == 4) {
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        if (start > number.length() || count == 4) {
            return;
        }
        StringBuilder newSb = new StringBuilder(sb);
        sb.append(number.charAt(start));
        sb.append(".");
        function(number, start + 1, sb, result, count + 1);
        if (number.charAt(start) == '0') return;
        if (start + 1 < number.length()) {
            sb = new StringBuilder(newSb);
            sb.append(number.substring(start, start + 2));
            sb.append(".");
            function(number, start + 2, sb, result, count + 1);
        }
        if (start + 2 < number.length()) {
            sb = new StringBuilder(newSb);
            int num = Integer.parseInt(number.substring(start, start + 3));
            if (num >= 0 && num <= 255) {
                sb.append(number.substring(start, start + 3));
                sb.append(".");
                function(number, start + 3, sb, result, count + 1);
            }
        }

    }
}


