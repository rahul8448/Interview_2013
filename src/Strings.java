import java.util.Hashtable;


public class Strings {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Strings st = new Strings();
        //System.out.println(st.findFirstNonReapetedChar("RRAHHUULL"));
        //System.out.println(st.removeChar("RRAHHUULLL A",""));
        //st.reverseWord("RAHUL SHARMA");
       // st.reverseWord2("RAHUL SHARMA");
        //st.StringToInteger("-44");
        //st.IntegerToString(-44);
        System.out.println(st.reveseWords("RAHUL SHARMA".toCharArray()));
    }

    public Character findFirstNonReapetedChar(String str) {
        Hashtable ht = new Hashtable();

        int len = str.length();

        int i = 0;

        while (len > 0) {
            char c = str.charAt(i);
            Integer val = (Integer) ht.get(c);

            if (val == null) {
                ht.put(c, 1);
            } else {
                int temp = val;
                temp++;
                ht.put(c, temp);
            }

            i++;
            len--;
        }

        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            int count = (Integer) ht.get(c);

            if (count == 1) {
                return c;
            }
        }

        return null;
    }

    public void reverseWord(String word) {
        int len = word.length();

        char[] temp = new char[len];
        int pos = temp.length - 1;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if ((c != ' ') && (i < (len - 1))) {
                sb.append(c);
            } else {
                if (i == (len - 1)) {
                    c = word.charAt(i);
                    sb.append(c);
                }

                String tem = sb.toString();

                for (int j = tem.length() - 1; j >= 0; j--) {
                    temp[pos] = tem.charAt(j);
                    pos--;
                }

                if (i < (len - 1)) {
                    temp[pos] = ' ';
                }

                pos--;
                sb = new StringBuffer();
            }
        }

        System.out.println(temp);
    }

    public String removeChar(String term, String rem) {
        Hashtable ht = new Hashtable();

        if ((term == null) || (rem == null)) {
            return null;
        }

        for (int i = 0; i < rem.length(); i++) {
            char c = rem.charAt(i);
            ht.put(c, 1);
        }

        StringBuffer sb = new StringBuffer();

        for (int j = 0; j < term.length(); j++) {
            char c = term.charAt(j);
            Integer intg = (Integer) ht.get(c);

            if (intg == null) {
                sb.append(c);
            }
        }

        return (sb.toString());
    }

    public void reverseWord2(String word) {
        int len = word.length();
        char[] temp = new char[len];
        int start = 0;
        int end = 0;

        //int pos=len-1;
        int pos = 0;

        for (int i = start; i < len; i++) {
            char c = word.charAt(i);

            if ((c == ' ') || (i == (len - 1))) {
                if (c == ' ') {
                    end = i - 1;
                }

                if (i == (len - 1)) {
                    end = i;
                }

                for (int j = end; j >= start; j--) {
                    temp[pos] = word.charAt(j);
                    //pos--;
                    pos++;
                }

                if (end == (len - 1)) {
                    break;
                }

                temp[pos] = ' ';
                //pos--;
                pos++;
                start = end + 2;
                i = start;
            }
        }

        System.out.println(temp);
    }

    public void StringToInteger(String val) {
        int len = val.length();
        boolean isNegative = false;
        char c = val.charAt(0);
        int mul = 1;
        int start = 0;
        int asciiForZero = '0';
        int result = 0;

        if (c == '-') {
            isNegative = true;
            start = 1;
        }

        for (int i = len - 1; i >= start; i--) {
            c = val.charAt(i);

            int temp = (int) c - asciiForZero;
            temp = mul * temp;
            result = result + temp;
            mul = mul * 10;
        }

        if (isNegative) {
            result = -1 * result;
        }

        System.out.println(result);
    }

    public void IntegerToString(int num) {
        boolean isNegative = false;
        int zeroAscii = '0';

        if (num < 0) {
            isNegative = true;
            num = num * -1;
        }

        StringBuffer sb = new StringBuffer();

        while (num > 0) {
            int temp = num % 10;
            int asciiVal = zeroAscii + temp;
            char c = (char) asciiVal;
            sb.append(c);
            num = num / 10;
        }

        if (isNegative) {
            sb.append("-");
        }

        System.out.println(sb.reverse().toString());
    }

    public String reveseWords(char[] list) {
        int len = list.length;

        StringBuffer sb = new StringBuffer();
        int last = 0;
        int first = 0;

        boolean breakLoop = false;

        while (true) {
            while ((last < len) && (list[last] != ' ')) 
                last++;
            
  
            last = last - 1;

            int temp = last + 1;

            if (last == (len - 1)) {
                breakLoop = true;
            }

            while (last >= first) {
                char c = list[last];
                sb.append(c);
                last--;
            }
            

            if (breakLoop) {
                break;
            }
            sb.append(" ");
            while (list[temp] == ' ')
                temp++;

            first = temp;
            last = temp;
        }
        return sb.toString();
    }
}
