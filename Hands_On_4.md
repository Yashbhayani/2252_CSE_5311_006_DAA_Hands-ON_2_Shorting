# Hands On 4 Answers

## Fibonacci Algorithm
### Implement the Fibonacci sequence
```matlab
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        return fib(n - 1) + fib(n - 2);
    }
```
### Debug the code and "step into" the function for fib(5). I want you to step into all recursive calls and list out the function call stack ex. fib(5) -> fib(4) -> fib(3) ...?  that you observe.
### Note, don't turn on optimization if your programming language allows it.
### Another note make sure to implement the return exactly as
### Return
```matlab
fib(n-1) + fib(n-2)
```
### instead of say
```matlab
a = fib(n-1) 
b = fib(n-2)
return a + b
```
### or as
```matlab
return fib(n-2) + fib(n-1)
```

## 1. Implement the solutions and upload it to github
Let's go for each iterations for the fib(5) step by step, which is need for the debugging task. Here is how debugging will look:
```matlab
1. Starting with fib(5):
    > It calls fib(4) and fib(3) to compute its value.

2. fib(4):
    > Calls fib(3) and fib(2).

3. fib(3):
    > Calls fib(2) and fib(1).

4. fib(2):
    > Calls fib(1) and fib(0).
    > fib(1) returns 1.
    > fib(0) returns 0.
    > Returns 1 + 0 = 1 for fib(2).

5. fib(1):
    > Directly returns 1.

6. Back to fib(2):
    > Now that fib(1) returned 1 and fib(0) returned 0, fib(2) returns 1 + 0 = 2.

7. Back to fib(3):
    > Now that fib(2) returned 2, fib(3) calls fib(1) again.

8. fib(2) (called by fib(3)):
    > Calls fib(1) and fib(0).
    > fib(1) returns 1.
    > fib(0) returns 0.
    > Returns 1 + 0 = 1 for fib(2).

9. fib(1):
    > Directly returns 1.

10. Back to fib(3):
    > Now that fib(2) returned 1 and fib(1) returned 1, fib(3) returns 1 + 1 = 2.

11. Back to fib(4):
    > Now that fib(3) returned 2, fib(4) calls fib(2).

12. fib(2) (called by fib(4)):
    > Calls fib(1) and fib(0).
    > fib(1) returns 1.
    > fib(0) returns 0.
    > Returns 1 + 0 = 1 for fib(2).

13. Back to fib(4):
    > Now that fib(2) returned 1 and fib(3) returned 2, fib(4) returns 2 + 2 = 4.

14. Finally, back to fib(5):
    > Now that fib(4) returned 4 and fib(3) returned 2, fib(5) returns 4 + 3 = 5.
```
The final answer for the fib(5) will be 5.

## 2. Prove the time complexity of the algorithms
The time complexity of this Fibonacci algorithm will be O(2^n) because of these reasons:
* In each iteration, we will call two additional recursive functions.
* This will lead to an exponential growth in the number of called functions, as each call function will call out another two further calls.

Thus, the total number of recursive calls will grow exponentially with the input of n. In the worst case for the time complexity, the recursion tree will grow with a size which will proportional to 2^n.

## 3. Comment on way's you could improve your implementation.
The function fibImproved(n) is an iterative approach to calculating the n-th Fibonacci number, as opposed to the previous recursive approach. Here's the code:
```matlab
    public static int fibImproved(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int a = 0;
        int b = 1;
        
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }
```
Example:
For n = 30, the output will look like this and we can see clearly the difference between both approaches:

![FibonacciAlgorithm](https://github.com/user-attachments/assets/18689229-caff-49e7-9f56-565dc4a51485)

---

## Problem 1
### Given K sorted arrays of size N each, the task is to merge them all maintaining their sorted order.
### Examples: 
```matlab
Input: K = 3, N = 4
array1 = [1, 3, 5, 7]
array2 = [2, 4, 6, 8]
array3 = [0, 9, 10, 11]
```
### Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
### Merged array in a sorted order where every element is greater than the previous element.
```matlab
Input: K = 3, N = 3
array1 = [1, 3, 7]
array2 = [2, 4, 8]
array3 = [9, 10, 11]
```
### Output: [1, 2, 3, 4, 7, 8, 9, 10, 11]
### Merged array in a sorted order where every element is greater than the previous element.
File: (problem1.py)[https://github.com/Yashbhayani/2252_CSE_5311_006_DAA_Hands-ON_2_Shorting/blob/Hands_ON_4/Problem%201.java]

Code Summary:
* Input: K sorted arrays, each of size N.
* Process:
    * For each of the K arrays, the user will input N elements.
    * The program will use a while loop and a min search algorithm to find the smallest element across all arrays based on their current indices.
    * The smallest element will append to the result, and its corresponding array index will increment.
* Output: A single merged array in sorted order.

Example Walkthrough:

![Problem 1](https://github.com/user-attachments/assets/edd7e6bd-3ff5-4671-8954-71c1b0f56afb)


Time Complexity:
* Outer Loop: Executes N*K times to fill the result array.
* Inner Loop: For each pass, iterates through K arrays to find the smallest element.
* Total Time Complexity:
    𝑂(𝑁×(𝐾^2))

Space Complexity:
* The additional space used is for:
    * index array of size K (𝑂(𝐾)).
    * result array of size 𝑁×𝐾(𝑂(𝑁×𝐾)).
* Total Space Complexity: 𝑂(𝑁×𝐾).
---
## Problem 2
### Given a sorted array array of size N, the task is to remove the duplicate elements from the array.
### Examples: 
```matlab
Input: array = [2, 2, 2, 2, 2]
Output: array= [2]
```
### Explanation: All the elements are 2, So only keep one instance of 2.
```matlab
Input: array = [1, 2, 2, 3, 4, 4, 4, 5, 5]
Output: array[] = {1, 2, 3, 4, 5}
```
### Note, you can't use something like the set container in C++.
File: (problem2.java)[https://github.com/Yashbhayani/2252_CSE_5311_006_DAA_Hands-ON_2_Shorting/blob/Hands_ON_4/Problem%202.java]

Code Summary:
* Input: A sorted array of size N.
* Process:
    * Traverse the array using an index pointer.
    * For each element, compare it with the next one.
    * If the current element equals the next, remove the next element using the remove() method.
    * If they are not equal, move to the next index.
* Output: An array with duplicates removed.

Example Walkthrough:

![Problem 2 (1)](https://github.com/user-attachments/assets/ffa5fbd7-812d-4df0-8c7c-6b3b3627648f)

![Problem 2 (2)](https://github.com/user-attachments/assets/c7db4d5b-9826-4623-bdd1-3116c807e6d8)


Time Complexity:
* Outer Loop: Traverses each element of the array.
* Remove Operation: Requires shifting elements, which is 𝑂(𝑁) for each duplicate.
* Total Time Complexity:
    The worst case is 𝑂(𝑁^2), as shifting is required for every duplicate.

Space Complexity:
* No additional data structures are used; the operation is performed in place.
* Total Space Complexity: 𝑂(1).
