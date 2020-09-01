/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial09;

import java.util.Random;

/**
 *
 * @author muham
 */
public class SearchTest<T extends Comparable<T>> {

    private final int MAX = 100;
    private final int MAXCHAR = 26;
    private T[] value;
    private int orderType, size;
    private Random r;

    public SearchTest(T b, int size) {
        orderType = 1;
        this.size = size;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for (int i = 0; i < size; i++) {
            if (b instanceof Integer) {
                value[i] = (T) ((Integer) r.nextInt(MAX));
            } else if (b instanceof Double) {
                value[i] = (T) ((Double) (0.01 * r.nextInt(MAX)));
            } else if (b instanceof Character) {
                c = (char) ('A' + r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            } else {
                c = (char) ('A' + r.nextInt(MAXCHAR));
                value[i] = (T) (c + "");
            }
        }
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public T getElement(int index) {
        return value[index];
    }

    public boolean linearSearch(T t) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean linearSearch(T t1, T t2) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                return true;
            }
        }
        return false;
    }

    public int[] linearSearchList(T t, int size) {
        int[] a = new int[size];
        for (int i = 0, j = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                a[j] = i;
                j++;
            }
        }
        return a;
    }

    public int[] linearSearchList(T t1, T t2, int size) {
        int[] a = new int[size];
        for (int i = 0, j = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                a[j] = i;
                j++;
            }
        }
        return a;
    }

    public int linearSearchCount(T t) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                count++;
            }
        }
        return count;
    }

    public int linearSearchCount(T t1, T t2) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int ASCENDING = 1;
    public int DESCENDING = 2;

    public boolean binarySearch(T t) {
        int index = binarySearchCount(0, value.length, t);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean binarySearch(T t1, T t2) {
        int index = binarySearchCountRange(0, value.length, t1, t2);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int binarySearchCountRange(int start, int end, T t1, T t2) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if ((value[middle].compareTo(t1) >= 0) && value[middle].compareTo(t2) <= 0) {
            return middle;
        } else if ((value[middle].compareTo(t1) > 0 && orderType == ASCENDING)
                || (value[middle].compareTo(t1) < 0 && orderType == DESCENDING)) {
            return binarySearchCountRange(start, middle - 1, t1, t2);
        } else {
            return binarySearchCountRange(middle + 1, end, t1, t2);
        }
    }

    public int[] binarySearchList(T t) {
        int count = 0, newIndex;
        int index = binarySearchCount(0, value.length, t);
        newIndex = index;
        if (index != -1) {
            for (int i = index; i >= 0 && t.compareTo(value[i]) == 0; i++) {
                count++;
                newIndex = i;
            }
            for (int i = index + 1; i < value.length && t.compareTo(value[i]) == 0; i--) {
                count++;
            }
            int[] a = new int[count];
            for (int i = 0; newIndex < value.length && t.compareTo(value[newIndex]) == 0; i++, newIndex++) {
                a[i] = newIndex;
            }
            return a;
        }
        return null;
    }

    public int[] binarySearchList(T t1, T t2) {
        int count = 0, newIndex;
        int index = binarySearchCountRange(0, value.length, t1, t2);
        newIndex = index;
        if (index != -1) {
            for (int i = index; i >= 0 && t1.compareTo(value[i]) <= 0 && t2.compareTo(value[i]) >= 0; i--) {
                count++;
                newIndex = i;
            }
            for (int i = index + 1; i < value.length && t1.compareTo(value[i]) <= 0 && t2.compareTo(value[i]) >= 0; i++) {
                count++;
            }
            int[] a = new int[count];
            for (int i = 0; newIndex < value.length && t1.compareTo(value[newIndex]) <= 0 && t2.compareTo(value[newIndex]) >= 0; i++, newIndex++) {
                a[i] = newIndex;
            }
            return a;
        }
        return null;
    }

    public int binarySearchCount(T t1, T t2) {
        int count = 0;
        int index = binarySearchCountRange(0, value.length, t1, t2);
        if (index != -1) {
            for (int i = index; i >= 0 && t1.compareTo(value[i]) <= 0 && t2.compareTo(value[i]) >= 0; i--) {
                count++;
            }
            for (int i = index + 1; i < value.length && t1.compareTo(value[i]) <= 0 && t2.compareTo(value[i]) >= 0; i++) {
                count++;
            }
        }
        return count;
    }

    public int binarySearchCount(T t) {
        int count = 0;
        int index = binarySearchCount(0, value.length, t);
        if (index != -1) {
            for (int i = index; i >= 0 && t.compareTo(value[i]) == 0; i--) {
                count++;
            }
            for (int i = index + 1; i < value.length && t.compareTo(value[i]) == 0; i++) {
                count++;
            }
        }
        return count;
    }

    public int binarySearchCount(int start, int end, T t) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (value[middle].compareTo(t) == 0) {
            return middle;
        } else if ((value[middle].compareTo(t) > 0 && orderType == ASCENDING)
                || (value[middle].compareTo(t) < 0 && orderType == DESCENDING)) {
            return binarySearchCount(start, middle - 1, t);
        } else {
            return binarySearchCount(middle + 1, end, t);
        }
    }

    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }

    public int getMinIndex(int start) {
        T temp = value[start];
        int index = start;
        for (int i = start + 1; i < value.length; i++) {
            if (temp.compareTo(value[i]) > 0 && orderType == ASCENDING) {
                index = i;
                temp = value[i];
            } else if (temp.compareTo(value[i]) < 0 && orderType == DESCENDING) {
                index = i;
                temp = value[i];
            }
        }
        return index;
    }

    public void selectionSort(int b) {
        for (int i = 0; i < value.length - 1; i++) {
            swap(i, getMinIndex(i));
        }
    }
}
