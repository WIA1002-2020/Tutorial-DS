/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial08;

import java.util.Random;

/**
 *
 * @author muham
 */
public class SortTest<T extends Comparable<T>> {

    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    private final int MAX = 100;
    private final int MAXCHAR = 26;
    private T[] value;
    private Random r;
    private int orderType;

    public SortTest(int a, T b, int size) {
        orderType = a;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for (int i = 0; i < value.length; i++) {
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

    public SortTest(int a, T b, int size, int numChar) {
        orderType = a;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for (int i = 0; i < value.length; i++) {
            if (b instanceof Integer) {
                value[i] = (T) ((Integer) r.nextInt(MAX));
            } else if (b instanceof Double) {
                value[i] = (T) ((Double) (0.01 * r.nextInt(MAX)));
            } else if (b instanceof Character) {
                c = (char) ('A' + r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            } else {
                String str ="";
                for (int j = 0; j < numChar; j++) {
                    c=(char)('a'+r.nextInt(MAXCHAR));
                    str+=c;
                }
                value[i]=(T)(str);
            }
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < value.length - 1; i++) {
            if (value[i].compareTo(value[i + 1]) > 0 && orderType == ASCENDING) {
                return false;
            } else if (value[i].compareTo(value[i + 1]) < 0 && orderType == DESCENDING) {
                return false;
            }
        }
        return true;
    }

    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    //Selection Sort
    private int getMinIndex(int start) {
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

    public void selectionSort() {
        for (int i = 0; i < value.length - 1; i++) {
            swap(i, getMinIndex(i));
        }
    }

    //Bubble Sort
    public void bubbleSort() {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length - 1 - i; j++) {
                if (value[j].compareTo(value[j + 1]) > 0 && orderType == ASCENDING) {
                    swap(j, j + 1);
                } else if (value[j].compareTo(value[j + 1]) < 0 && orderType == DESCENDING) {
                    swap(i, i + 1);
                }
            }
        }
    }

    //Insertion Sort
    public void insertionSort() {
        int j;
        for (int i = 1; i < value.length; i++) {
            for (j = 0; j < i; j++) {
                if (value[i].compareTo(value[j]) < 0 && orderType == ASCENDING) {
                    swap(i, j);
                    break;
                } else if (value[i].compareTo(value[j]) > 0 && orderType == DESCENDING) {
                    swap(i, j);
                    break;
                }
            }
            for (j = j + 1; j < i; j++) {
                swap(j, i);
            }
        }
    }

    //Merge Sort
    public void mergeSort() {
        mergeSort(0, value.length - 1);
    }

    private void mergeSort(int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        T[] temp = (T[]) new Comparable[value.length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if ((value[leftFirst].compareTo(value[rightFirst]) < 0) && orderType == ASCENDING
                    || (value[leftFirst].compareTo(value[rightFirst]) > 0) && orderType == DESCENDING) {
                temp[index] = value[leftFirst];
                leftFirst++;
            } else {
                temp[index] = value[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while (leftFirst <= leftLast) {
            temp[index] = value[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast) {
            temp[index] = value[rightFirst];
            rightFirst++;
            index++;
        }
        for (int i = currentIndex; i <= rightLast; i++) {
            value[i] = temp[i];
        }
    }

    //Quick Sort
    public void quickSort() {
        quickSort(0, value.length - 1);
    }

    private void quickSort(int first, int last) {
        if (first < last) {
            int splitIndex = split(first, last);
            quickSort(first, splitIndex - 1);
            quickSort(splitIndex + 1, last);
        }
    }

    private int split(int first, int last) {
        boolean correctSide;
        T splitValue = value[first];
        int index = first;
        first++;
        do {
            correctSide = true;
            while (correctSide) {
                if ((splitValue.compareTo(value[first]) < 0 && orderType == ASCENDING)
                        || (splitValue.compareTo(value[first]) >= 0 && orderType == ASCENDING)) {
                    correctSide = false;
                } else {
                    first++;
                    if (first <= last) {
                        correctSide = true;
                    } else {
                        correctSide = false;
                    }
                }
            }
            if (first <= last) {
                correctSide = true;
            } else {
                correctSide = false;
            }
            while (correctSide) {
                if ((splitValue.compareTo(value[last]) >= 0 && orderType == ASCENDING)
                        || (splitValue.compareTo(value[last]) < 0 && orderType == ASCENDING)) {
                    correctSide = false;
                } else {
                    last--;
                    if (first <= last) {
                        correctSide = true;
                    } else {
                        correctSide = false;
                    }
                }
            }
            if (first <= last) {
                swap(first, last);
                first++;
                last--;
            }
        } while (first <= last);
        swap(index, last);
        return last;
    }
}
