public class Sorting {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sorting st = new Sorting();

        int[] list = { 1, 10, 0, 8, 6, };
        //int[] list = { 1, 2, 3, 4, 5 };
        // System.out.println(st.bubbleSort(list));
        //st.insertionSort(list);
        // st.selectionSort(list);
        st.quickSort(list, 0, list.length - 1);
        st.printValues(list);
        int[] list1 = { 1, 5, 7, 9, 11,12};
        System.out.println(st.binarySearch(list1, 0, list1.length-1, -2));
        System.out.println(st.reverseString("RAHUL"));
    }

    public int[] bubbleSort(int[] list) {
        int len = list.length;

        //boolean noSwap=true;
        while (len > 1) {
            boolean noSwap = true;

            for (int i = 1; i < len; i++) {
                int n1 = list[i - 1];
                int n2 = list[i];

                if (n1 > n2) {
                    list[i - 1] = n2;
                    list[i] = n1;
                    noSwap = false;
                }
            }

            if (noSwap) {
                break;
            }

            len--;
        }

        System.out.println(list);

        return list;
    }

    public void insertionSort(int[] list) {
        int len = list.length;

        for (int i = 0; i < (len - 1); i++) {
            boolean terminate = true;

            for (int j = i + 1; j > 0; j--) {
                int n1 = list[j];
                int n2 = list[j - 1];

                if (n1 < n2) {
                    list[j - 1] = n1;
                    list[j] = n2;
                    terminate = false;
                }

                if (terminate) {
                    break;
                }
            }
        }

        System.out.println(list);
    }

    public void selectionSort(int[] list) {
        int len = list.length;

        for (int i = 0; i < len; i++) {
            int n1 = list[i];

            for (int j = i + 1; j < len; j++) {
                int n2 = list[j];

                if (n2 < n1) {
                    list[i] = n2;
                    list[j] = n1;
                    n1 = n2;
                }
            }
        }

        System.out.println(list);
    }

    public void quickSort(int[] list, int start, int end) {
        int low = start;
        int high = end;
        int pivot = list[start];

        if ((high - low) < 1) {
            return;
        }

        while (start <= end) {
            while ((start < high) && (list[start] <= pivot)) {
                start++;
            }

            while ((end > low) && (list[end] >= pivot)) {
                end--;
            }

            if (start <= end) {
                int tmp = list[start];
                list[start] = list[end];
                list[end] = tmp;
                start++;
                end--;
            }
        }

        if (end >= low) {
            int tmp = list[end];
            list[end] = list[low];
            list[low] = tmp;
        }

        if (low <= (end - 1)) {
            quickSort(list, low, end - 1);
        }

        if (high >= (end + 1)) {
            quickSort(list, end + 1, high);
        }
    }

    public void printValues(int[] list) {
        int len = list.length;

        for (int i = 0; i < len; i++) {
            System.out.print(list[i]);
            System.out.print(" ");
        }

        System.out.println("");
    }

    public boolean binarySearch(int[] list, int low, int high, int val) {
        

    	 /* if ((low > list.length-1) || (high < 0)) {
              return false;
          }*/
    	  
    	  if(low>high)
    		  return false;

        int mid = (low + high) / 2;
        
      
        if (list[mid] == val) {
            return true;
        }
        else if (list[mid] < val) {
            low = mid + 1;
        } else if (list[mid] > val) {
            high = mid - 1;
        }

        return binarySearch(list, low, high, val);
    }
    
    public String reverseString(String s){
        if (s.length() == 0) 
             return s;

        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
