public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeSort hs=new MergeSort();
		int[] list = { 1, 10, 0, 8,6,1,3,5,6,3,4,11};
		list=hs.MergeSort(list, 0);
		System.out.println(list);
		
	}

	public int[] MergeSort(int[] list, int start) {

		if (list.length <= 1)
			return list;

		int mid = list.length / 2;
		int low = 0;
		int high = list.length ;

		int l1[] = new int[mid - low];
		int l2[] = new int[high - mid];

		//createArray(list, low, mid - low, l1);
		for (int i = 0; i < mid-low; i++) {
			l1[i]=list[i];
		}
		for (int j = mid-low; j < high; j++) {
			int pos=j-(mid-low);
			l2[pos]=list[j];
		}
		
		l1 = MergeSort(l1, low);
		l2 = MergeSort(l2, mid - low);

		int[] result = merge(l1, l2);

		return result;

	}

	

	public int[] merge(int[] l1, int[] l2) {
		int len1 = l1.length;
		int len2 = l2.length;
		int result[] = new int[len1 + len2];
		//int end = 0;
		
		/*if (len1 > len2)
			end = len2;
		else
			end = len1;*/
		int pos = 0;
		int i = 0;
		int j = 0;
		while (i < len1 && j < len2) {
			int v1 = l1[i];
			int v2 = l2[j];

			if (v1 < v2) {
				result[pos] = v1;
				i++;
				pos++;
			} else {
				result[pos] = v2;
				j++;
				pos++;
			}
		}
		while (i<len1) {
			result[pos] = l1[i];
			pos++;
			i++;
			
		} while (j<len2) {
			result[pos] = l2[j];
			pos++;
			j++;
			
		}

		return result;

	}
}
