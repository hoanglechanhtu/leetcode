/*
Canadian Computing Competition: 2007 Stage 2, Day 1, Problem 2
You may have heard that no two snowflakes are alike. Your task is to write a program to determine whether this is really true. Your program will read information about a collection of snowflakes, and search for a pair that may be identical.

Each snowflake has six arms. For each snowflake, your program will be provided with a measurement of the length of each of the six arms. Any pair of snowflakes which have the same lengths of corresponding arms should be flagged by your program as possibly identical.

Note: The original CCO data were weak and have been augmented with some custom test cases.

Input Specification
The first line of input will contain a single integer n, 0 <= n <= 100000 the number of snowflakes to follow. This will be followed by  lines, each describing a snowflake. Each snowflake will be described by a line containing six integers (each integer is at least 0 and less than 10000000), the lengths of the arms of the snowflake. The lengths of the arms will be given in order around the snowflake (either clockwise or counterclockwise), but they may begin with any of the six arms. For example, the same snowflake could be described as 1 2 3 4 5 6 or 4 3 2 1 6 5.

Output Specification
If all of the snowflakes are distinct, your program should print the message: No two snowflakes are alike.

If there is a pair of possibly identical snowflakes, your program should print the message: Twin snowflakes found.

Sample Input
Copy
2
1 2 3 4 5 6
4 3 2 1 6 5
Output for Sample Input
Copy
Twin snowflakes found.

*/

//Brute force
    class Solution {
        boolean snowflakes(int arr[][], int n) {
            for (int i = 0; i < arr.length; i ++) {
                for (int j = i + 1; j < arr.length; j ++) {
                    if (areIdentical(arr[i], arr[j])) {
                        log.info("{} {}", arr[i], arr[j]);
                        return true;
                    }
                }
            }
            return false;
        }

        boolean areIdentical(int[] arr1, int[] arr2) {
            for (int start = 0; start < 6; start ++) {
                if (identicalRight(arr1, arr2, start)) return true;
                if (identicalLeft(arr1, arr2, start)) return true;
            }
            return false;
        }

        boolean identicalRight(int[] arr1, int[] arr2, int start) {
            for (int i = 0; i < 6; i ++) {
                if (arr1[i] != arr2[(start + i) % 6]) return false;
            }
            return true;
        }

        boolean identicalLeft(int[] arr1, int[] arr2, int start) {
            int index = start;
            for (int i = 0; i < 6; i ++) {
                if (index < 0) index = 5;
                if (arr1[i] != arr2[index]) return false;
                index = index - 1;
            }
            return true;
        }

    }
// Hash


    class Solution {
        int SIZE = 100000;
        class Node {
            int[] arr;
            Node next;
            Node(int[] arr, Node next) {
                this.arr = arr;
                this.next = next;
            }
        }
        boolean snowflakes(int arr[][], int n) {
            Node[] bucket = new Node[SIZE];
            for (int i = 0; i < n; i ++) {
                int code = code(arr[i]);
                Node node = new Node(arr[i], bucket[code]);
                bucket[code] = node;
            }
            for (int i = 0; i < SIZE; i ++) {
                Node node1 = bucket[i];
                while(node1 != null) {
                    Node node2 = node1.next;
                    while(node2 != null) {
                        if (areIdentical(node1.arr, node2.arr)) {
                            log.info("{} {}", node1.arr, node2.arr);
                            return true;
                        }
                        node2 = node2.next;
                    }
                    node1 = node1.next;
                }
            }
            return false;
        }

        int code(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i ++) {
                sum += arr[i];
            }
            return  sum % SIZE;
        }

        boolean areIdentical(int[] arr1, int[] arr2) {
            for (int start = 0; start < 6; start ++) {
                if (identicalRight(arr1, arr2, start)) return true;
                if (identicalLeft(arr1, arr2, start)) return true;
            }
            return false;
        }

        boolean identicalRight(int[] arr1, int[] arr2, int start) {
            for (int i = 0; i < 6; i ++) {
                if (arr1[i] != arr2[(start + i) % 6]) return false;
            }
            return true;
        }

        boolean identicalLeft(int[] arr1, int[] arr2, int start) {
            int index = start;
            for (int i = 0; i < 6; i ++) {
                if (index < 0) index = 5;
                if (arr1[i] != arr2[index]) return false;
                index = index - 1;
            }
            return true;
        }

    }
