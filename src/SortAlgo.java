public class SortAlgo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortAlgo st = new SortAlgo();
		int a[] = { 2, 5, 11, 1, 8, 15, 2, 5, 1, 0, 18, 1, 5, 8, 18 };
		// int a[]={2,5,11,1,8,15};
		//st.quickSort(a, 0, a.length - 1);
		int res[]=st.mergeSort(a, 0, a.length - 1);
		System.out.println(res);
	}

	public int[] quickSort(int[] a, int low, int high) {

		if (high - low <= 0)
			return a;

		int i = low + 1;
		int j = high;

		int pivot = a[low];

		while (i < j) {
			while (i < high && a[i] < pivot)
				i++;

			while (j > low && a[j] > pivot)
				j--;

			if (i < j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}

		if (a[low] > a[j]) {
			a[low] = a[j];
			a[j] = pivot;
		}

		quickSort(a, low, j - 1);
		quickSort(a, j + 1, high);

		return a;
	}

public int[] mergeSort(int[] a, int low, int high) {	
		
		int len = a.length;
		if (len<=1) {
			return a;
		}
		//int len = a.length;
		int mid = len / 2;

		int a1[] = new int[mid-low];
		int a2[] = new int[len - mid];
		for (int i = 0; i < mid; i++) {
			a1[i] = a[i];
		}

		for (int j = 0; j < len - mid; j++) {
			a2[j] = a[j + mid];
		}

		int[] r1 = mergeSort(a1, low, mid - 1);
		int[] r2 = mergeSort(a2, mid + 1, high);

		int[] res = merge(r1, r2);

		return res;

	}

	public int[] merge(int[] r1, int[] r2) {
		int l1 = r1.length;
		int l2 = r2.length;
		int i = 0;
		int j = 0;
		int res[] = new int[l1 + l2];
		int k = 0;

		while (i < l1 && j < l2) {
			if (r1[i] > r2[j])
				res[k++] = r2[j++];
			else
				res[k++] = r1[i++];

		}

		while (i < l1)
			res[k++] = r1[i++];

		while (j < l2)
			res[k++] = r2[j++];

		return res;
	}

}
