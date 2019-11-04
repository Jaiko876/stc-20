package ru.stc20.molostvov.lesson02.task03;

class MergeSort implements Sorting {
    /**
     * Сортировка массива методом слияния
     * @param array - массив объектов типа Person
     * @return отсортированный массив объектов типа Person
     * @see Sorting
     */
    @Override
    public Person[] sort(Person[] array) {
        if (array.length <= 1) {
            return array;
        }
        int midpoint = array.length / 2;
        Person[] leftArray = new Person[midpoint];
        Person[] rightArray = new Person[array.length - midpoint];

        for (int i = 0; i < midpoint ; i++) {
            leftArray[i] = array[i];
        }

        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = array[midpoint + j];
        }

        Person[] result;
        leftArray = sort(leftArray);
        rightArray = sort(rightArray);
        result = merge(leftArray, rightArray);
        return result;
    }

    /**
     * Сортировка слиянием
     * @param leftArray - левая половина исходного массива
     * @param rightArray - правая половина массива
     * @return - возвращает отсортированный массив объектов
     */
    private static Person[] merge(Person[] leftArray, Person[] rightArray) {
        Person[] result = new Person[leftArray.length + rightArray.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < leftArray.length || rightPointer < rightArray.length) {
            if (leftPointer < leftArray.length && rightPointer < rightArray.length) {
                if (leftArray[leftPointer].compareTo(rightArray[rightPointer]) < 0) {
                    result[resultPointer++] = leftArray[leftPointer++];
                } else {
                    result[resultPointer++] = rightArray[rightPointer++];
                }
            } else if (leftPointer < leftArray.length) {
                result[resultPointer++] = leftArray[leftPointer++];
            } else if (rightPointer < rightArray.length) {
                result[resultPointer++] = rightArray[rightPointer++];
            }
        }
        return result;
    }

    /**
     * Возвращает название сортировки
     * @return Возвращает название сортировки
     */
    @Override
     public String sortName() {
        return "Сортировка слиянием";
    }
}
