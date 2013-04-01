public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeapSort hp = new HeapSort();
		//int[] list = { 1, 10, 0, 8, 15, 7, 11 ,11,8,10};
		int[] list = { 1, 10, 0, 10,10,1};
		hp.mergeSort(list);

	}

	public void mergeSort(int[] list) {
		list = createHeap(list);
		list = sort(list, list.length - 2, list.length - 1);
		System.out.println(list);
		// list=sort(list,list.length-1);
	}

	public int[] sort(int[] list, int limit, int last) {
		/*
		 * int len = list.length; int limit = list.length - 2; int last =
		 * list.length-1;
		 */

		if (last < 1)
			return list;

		int tmp = list[0];
		list[0] = list[last];
		list[last] = tmp;

		int parent = 0;
		int l = 0;
		int r = 0;

		while (true) {

			boolean left = false;
			boolean right = false;

			int childL = 2 * parent + 1;
			int childR = 2 * parent + 2;

			if (childL <= limit) {
				l = list[childL];
				left = true;
			}
			if (childR <= limit) {
				r = list[childR];
				right = true;
			}

			if (childL > limit && childR > limit)
				break;

			int p = list[parent];

			if (left && right && (p < l && p < r)) {
				if (l > r) {
					list[parent] = l;
					list[childL] = p;
					parent = childL;
					/*
					 * limit--; last--;
					 */
				} else if (r >= l) {
					list[parent] = r;
					list[childR] = p;
					parent = childR;

				}
			} else if (left && (p < l )) {
				list[parent] = l;
				list[childL] = p;
				parent = childL;
			} else if (right && (p < r )) {
				list[parent] = r;
				list[childR] = p;
				parent = childR;
			} else
				break;

		}
		limit--;
		last--;

		return sort(list, limit, last);
	}

	public int[] createHeap(int[] list) {
		int len = list.length;
		int temp[] = new int[len];

		for (int i = 0; i < len; i++) {
			temp[i] = list[i];
			int child = i;
			while (true) {
				int parent = 0;
				if (child % 2 != 0)
					parent = (child - 1) / 2;
				else
					parent = (child - 2) / 2;
				if (parent < 0)
					break;
				int p = temp[parent];
				int c = temp[child];
				if (p < c) {
					temp[parent] = c;
					temp[child] = p;
					child = parent;
				} else
					break;

			}
		}
		return temp;

	}

}
