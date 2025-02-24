To mathematically derive the average runtime complexity of the **non-random pivot version of quicksort**, we will analyze the behavior of the algorithm assuming a **fixed pivot selection** strategy (typically the first element or last element) and calculate the expected time complexity over multiple recursive calls. The analysis will focus on the following steps:

### 1. Quicksort Overview
The non-random pivot version of quicksort operates as follows:
1. **Partitioning:** It selects a pivot and divides the input array into two subarrays: one containing elements less than the pivot, and the other containing elements greater than the pivot. The pivot is then placed in its correct sorted position.
2. **Recursion:** It recursively applies the same process to the two subarrays (left and right).

### 2. Key Assumptions for Analysis
- **Pivot selection**: The pivot is chosen deterministically. Let’s assume it is always the first or last element of the array.
- **Partitioning:** The array is divided into two subarrays by partitioning the elements around the pivot. The partitioning step takes linear time, i.e., \(O(n)\), where \(n\) is the number of elements in the current subarray.
- **Recursion**: After partitioning, quicksort is recursively called on the left and right subarrays.

### 3. Recursive Relation for Time Complexity
Let \(T(n)\) represent the time complexity of quicksort for an array of size \(n\). The process consists of two parts:
- The time spent partitioning the array, which is \(O(n)\).
- The time spent recursively sorting the two subarrays, which on average will be \(T\left(\frac{n}{2}\right)\) each (since on average, the pivot will divide the array into two roughly equal parts).

Thus, the recurrence relation for the average case time complexity can be written as:

\[
T(n) = T\left(\frac{n}{2}\right) + T\left(\frac{n}{2}\right) + O(n)
\]

Simplifying the equation:

\[
T(n) = 2T\left(\frac{n}{2}\right) + O(n)
\]

### 4. Solving the Recurrence Relation
The recurrence is of the form:

\[
T(n) = 2T\left(\frac{n}{2}\right) + O(n)
\]

This is a standard recurrence and can be solved using the **master theorem**. The general form of the recurrence is:

\[
T(n) = aT\left(\frac{n}{b}\right) + O(n^d)
\]

In our case:
- \(a = 2\)
- \(b = 2\)
- \(d = 1\)

We need to compare the values of \(a\), \(b^d\), and \(n^d\):
- \(a = 2\)
- \(b^d = 2^1 = 2\)

Since \(a = b^d\), we are in the **second case** of the master theorem, which states that the time complexity is \(O(n^d \log n)\).

Thus, the average case time complexity of quicksort is:

\[
T(n) = O(n \log n)
\]

### 5. Conclusion
The average case time complexity of the **non-random pivot version of quicksort** is **\(O(n \log n)\)**. This assumes that the pivot divides the array into two roughly equal parts on average, which happens if the pivot selection method leads to a reasonably balanced partitioning of the array.

Note: In the worst case (e.g., if the pivot is always the smallest or largest element), the time complexity can degrade to \(O(n^2)\), but the average case remains \(O(n \log n)\).