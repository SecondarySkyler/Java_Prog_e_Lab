public class btrList {
    
    public static String btrSucc (String btr) {
        int length = btr.length();
        int index = length - 1;
        char lsb = btr.charAt(index);
        String pre = btr.substring(0, index);
        
        if (length == 1) {
            if (lsb == '+') {
                return "+-";
            } else {
                return "+";
            }
        }
        if (lsb == '+') {
            return btrSucc(pre) + '-';
        } else if (lsb == '-') {
            return pre + ".";
        } else {
            return pre + "+";
        }
    }
    
    public static StringSList succList (String btr, int n) {
        StringSList sl = new StringSList();
        sl = sl.cons(btr);
        if (n == 1) {
            return sl;
        } else {
            String cl = btrSucc(btr);
            sl = sl.append(succList (cl, n-1));
        }  
        return sl;
    }
}// class btrList
