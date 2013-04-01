import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class SortRotatedArray {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortRotatedArray sa = new SortRotatedArray();
        int[] s = { 10, 11, 12, 13, 14, 4, 5, 6, 7, 8, 9 };
        System.out.println(sa.findPivot(s, 0, s.length - 1));
        sa.searchArrayOfString();
    }

    public void searchArrayOfString() {
        String[] s = new String[6];
        s[0] = "abc";
        s[1] = "abd";
        s[2] = "mno";
        s[3] = "pqr";
        s[4] = "srm";
        s[5] = "mn";

        java.util.Arrays.sort(s);

        System.out.println(s);

        System.out.println(binarySearchStringArray(s, 0, s.length - 1, "abc"));
        System.out.println("xyz".compareTo("abc"));
    }

    private int binarySearchStringArray(String[] s, int low, int high,
        String key) {
        int mid = (high + low) / 2;
        int res = 0;

        if (high < low) {
            return -1;
        } else {
            String midString = s[mid];

            if (key.compareTo(midString) == 0) {
                return mid;
            } else if (key.compareTo(midString) < 0) {
                res = binarySearchStringArray(s, low, mid - 1, key);
            } else {
                res = binarySearchStringArray(s, mid + 1, high, key);
            }
        }

        return res;
    }

    public static int findPivot(int[] a, int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[low] > a[mid]) {
                return findPivot(a, low, mid - 1);
            } else {
                return findPivot(a, mid + 1, high);
            }
        }

        return -1;
    }
}
