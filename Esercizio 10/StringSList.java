public class StringSList {
    
    public static final StringSList NULL_STRINGLIST = new StringSList();
    private boolean empty;
    private String first;
    private StringSList resto;
    
    public StringSList() {
        empty = true;
        first = null;
        resto = null;
    }
    
    public StringSList (String s, StringSList sl) {
        empty = false;
        first = s;
        resto = sl;
    }
    
    public boolean isNull() {
        return (first == null);
    }
    
    public String car() {
        return first;
    }
    
    public StringSList cdr() {
        return resto;
    }
    
    public StringSList cons (String e) {
        return new StringSList(e, this);
    }
    
    public int length() {
        if (isNull()) {
            return 0;
        } else {
            return this.cdr().length() + 1;
        }
    }
    
    public String listRef(int k) {
        if (k == 0) {
            return car();
        } else {
            return cdr().listRef(k - 1);
        }
    }
    
    public boolean equals (StringSList sl) {
        if (isNull()) {
            return sl.isNull();
        } else if (sl.isNull()) {
            return false;
        }
        else if (car() == sl.car()) {
            return cdr().equals(sl.cdr());
        } else {
            return false;
        }
    }
    
    public StringSList append (StringSList sl) {
        if (isNull()) {
            return sl;
        } else {
            return cdr().append(sl).cons(car());
        }
    }
    
    public StringSList reverse() {
        return reverseRec (NULL_STRINGLIST);
    }
    private StringSList reverseRec (StringSList sl) {
        if (isNull()) {
            return sl;
        } else {
            return cdr().reverseRec(sl.cons(car()));
        }
    }
    
    public String toString() {
        if (isNull()) {
            return "()";
        } else if (resto.isNull()) {
            return "(" + first + ")";
        } else {
            String rep = "(" + first;
            StringSList s = resto;
            while (!s.isNull()) {
                rep = rep + "," + s.car();
                s = s.cdr();
            }
            return rep + ")";
        }
    }
        
    
    

    
}// class StringSList
