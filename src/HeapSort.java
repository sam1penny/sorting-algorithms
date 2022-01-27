public class HeapSort implements SortingAlgo {
    public static void main(String[] args) {
        SortTesting.test(new HeapSort());
    }

    private static void FormHeap(int[] array) {
        int iChildA;
        int iChildB;
        int childA;
        int childB;
        int greaterChild;
        int iGreaterChild;
        int parent;
        int iParent;

        for (int pointer = array.length - 1; pointer >= 0; pointer--) {
            iParent = pointer;
            while (true) {
                parent = array[iParent];

                iChildA = 2 * iParent + 1;

                // If node has no children
                if (iChildA > array.length - 1) {
                    break;
                }
                childA = array[iChildA];

                iChildB = iChildA + 1;
                // If node has two children
                if (iChildB <= array.length - 1) {
                    childB = array[iChildB];

                    // Find the greater child
                    if (childB > childA) {
                        greaterChild = childB;
                        iGreaterChild = iChildB;
                    } else {
                        greaterChild = childA;
                        iGreaterChild = iChildA;
                    }

                    // Node only has one child
                } else {
                    greaterChild = childA;
                    iGreaterChild = iChildA;
                }

                // If a swap must be made
                if (greaterChild > parent) {
                    array[iParent] = greaterChild;
                    array[iGreaterChild] = parent;
                    iParent = iGreaterChild;
                } else {
                    break;
                }
            }
        }
    }

    public void sort(int[] array) {
        FormHeap(array);

        int iParent;
        int iChildA;
        int iChildB;
        int iGreaterChild;
        int parent;
        int childA;
        int childB;
        int greaterChild;

        for (int pointer = array.length - 1; pointer > 0; pointer--) {
            // Swap top of heap with current index
            parent = array[pointer];
            array[pointer] = array[0];
            array[0] = parent;
            iParent = 0;

            while (true) {
                iChildA = 2 * iParent + 1;

                // If node has no children
                if (iChildA > pointer - 1) {
                    break;
                }
                childA = array[iChildA];

                iChildB = iChildA + 1;
                // If node has two children
                if (iChildB <= pointer - 1) {
                    childB = array[iChildB];

                    // Find the greater child
                    if (childB > childA) {
                        greaterChild = childB;
                        iGreaterChild = iChildB;
                    } else {
                        greaterChild = childA;
                        iGreaterChild = iChildA;
                    }

                // Node only has one child
                } else {
                    greaterChild = childA;
                    iGreaterChild = iChildA;
                }

                // If a swap must be made
                if (greaterChild > parent) {
                    array[iParent] = greaterChild;
                    array[iGreaterChild] = parent;
                    iParent = iGreaterChild;
                } else {
                    break;
                }
            }
        }
    }
}
