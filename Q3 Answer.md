## 3. Mathematically derive the average runtime complexity of the non-random pivot version of quicksort.

The average runtime complexity of the system's **non-random pivot version of quicksort** can be mathematically derived through an algorithmic behavior analysis assuming a **fixed pivot selection strategy** (usually the first or last element) intending to compute expected time complexity across a number of recursive calls. The analysis is broken down into the following steps:

### 1. Quicksort Overview
The non-random pivot version of quicksort works as follows:
1. **Partitioning:** It selects a pivot and separates the input array into two subarrays: one containing elements lesser than the pivot, and the other containing elements greater than the pivot. Then the pivot is set into its correct sorted position.
2. **Recursion:** It applies the same process recursively on the two subarrays (left and right).

### 2. Key Assumptions for Analysis
- **Pivot selection**: The pivot is selected using a deterministic approach; let us assume that it is always the first or the last element of the array.
- **Partitioning:** The array is divided using the partitioning process into two subarrays relative to the pivot. This partitioning step takes linear time, i.e., \(O(n)\), where \(n\) is the number of elements in the current subarray.
- **Recursion**: Upon partitioning quicksort recursively calls itself on the left and the right subarrays called.

### 3. Recursive Relation for Time Complexity
Let \(T(n)\) represent the time complexity of quicksort for an array of size \(n\). The process can be divided into two parts:
- The time taken by partitioning the array, which is \(O(n)\). 
- The time for recursively sorting the two subarrays; on an average each of them will take T(\frac {n}{2}) time (since on average, the pivot will divide the array into two nearly equal halves).

Therefore, the recurrence relation, based on average case time complexity, can be expressed as:

\[
T(n) = T\left(\frac{n}{2}\right) + T\left(\frac{n}{2}\right) + O(n)
\]

Simplifying the equation:

\[
T(n) = 2T\left(\frac{n}{2}\right) + O(n)
\]

### 4. Solving the Recurrence Relation
The recurrence can, therefore, be expressed as:

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

We compare \(a\) with \(b^d\) and \(n^d\):
- \(a = 2\)
- \(b^d = 2^1 = 2\)

Since \(a = b^d\), we fall into the **second case** of the master theorem, which states that the time complexity is \(O(n^d\log n)\).

Thus, we have for the average case time complexity of quicksort:

\[
T(n) = O(n\log n)
\]

### 5. Conclusion
The average case time complexity of the non-random pivot version of quicksort is O(nlogn). This assumes that, on average, the pivot would divide the array into two equal halves, which tends to be the case provided that the pivot selection method allows for reasonably balanced partitioning of the array.

Note: In the worst case (when the pivot is always the lowest or highest element), the time complexity may degenerate to O(n2), but the average case stays O(nlogn).