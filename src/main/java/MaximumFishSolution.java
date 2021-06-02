public class MaximumFishSolution {
    private static int maximumFishSum;

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}};
        int[][] arr2 = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
        int[][] arr3 = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};
        int[][] arr4 = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
        int[][] arr5 = {{10, 0, 0, 0}, {2, 1, 3, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {5, 6, 7, 8}};
        int[][] arr6 = {{36, 5, 46, 29, 13, 57, 24, 95}, {82, 45, 14, 67, 34, 64, 43, 50}, {87, 8, 76, 78, 88, 84, 3, 51}, {54, 99, 32, 60, 76, 68, 39, 12},
                {26, 86, 94, 39, 95, 70, 34, 78}};

        testMaximumFishProblemSolution(arr1, 12);
        testMaximumFishProblemSolution(arr2, 16);
        testMaximumFishProblemSolution(arr3, 83);
        testMaximumFishProblemSolution(arr4, 16);
        testMaximumFishProblemSolution(arr5, 21);
        testMaximumFishProblemSolution(arr6, 650);
    }

    //get all the values of first column where the Whale could be located at and returns the maximum no of fish by calling processElement
    private static void getFirstColumnValuesAndReturnMaximumFishSum(int[][] arr) {
        maximumFishSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                processElement(arr, i - 1, 1, arr[i][0]);
            }
            if (i != arr.length - 1) {
                processElement(arr, i + 1, 1, arr[i][0]);
            }
        }

    }

    // calculates the sum of all possible paths by using recursion
    private static void processElement(int[][] arr, int i, int j, int currentRunningFishSum) {
        if (j <= arr[i].length - 1) {
            currentRunningFishSum += arr[i][j];
            if (maximumFishSum < currentRunningFishSum) {
                maximumFishSum = currentRunningFishSum;
            }

            if (i != 0) {
                processElement(arr, i - 1, j + 1, currentRunningFishSum);
            }
            processElement(arr, i, j + 1, currentRunningFishSum);
            if (i != arr.length - 1) {
                processElement(arr, i + 1, j + 1, currentRunningFishSum);
            }
        }
    }

    // tests the algorithm
    private static void testMaximumFishProblemSolution(int[][] arr, int expectedFishSum) {
        getFirstColumnValuesAndReturnMaximumFishSum(arr);
        System.out.println(String.format("Maximum fish sum from algorithm: %d and Expected Fish Sum: %d", maximumFishSum,
                expectedFishSum));
        if (maximumFishSum == expectedFishSum) {
            System.out.println("Maximum fish sum algorithm is working fine.");
        } else {
            System.out.println("Maximum fish sum algorithm is not working fine. It still has some bugs.");
        }
    }
}
