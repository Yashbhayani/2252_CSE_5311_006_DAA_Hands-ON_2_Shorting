# Assignment Answers

```matlab
function x = f(n)
   x = 1;
   for i = 1:n
        for j = 1:n
             x = x + 1;
```

## Question 1: Find the runtime of the algorithm mathematically.

![Que1](https://github.com/user-attachments/assets/b258207e-103c-4178-baa8-ae089c88e817)


---

## Question 2: Time this function for various n e.g. n = 1,2,3.... You should have small values of n all the way up to large values. Plot "time" vs "n" (time on y-axis and n on x-axis). Also, fit a curve to your data, hint it's a polynomial. 

The function is timed for values of \(n\), and the time for the execution is plotted against \(n\).
The data is fitted with a polynomial to capture the relationship between the input size and execution time.

![Que1](https://github.com/user-attachments/assets/538059bd-2531-47cd-9f26-9d5e331e591c)

---

## Question 3: Upper and Lower Bound Polynomials, Big-O, Big-Omega, and Big-Theta

The fitted curve is a quadratic function of the form:

\[
y = ax^2 + bx + c
\]

- **Big-O**: \( O(n^2) \). This means the runtime is bound above every time by a constant multiple of \(n^2\).

- **Big-Omega**: \( \Omega(n^2) \). This means runtime is bound below every time by a constant multiple of \(n^2\).

- **Big-Theta**: \( \Theta(n^2) \). This means runtime is asymptotically equivalent to \(n^2\).

---

## Question 4: Approximate Location of `n_0`

The approximate value of `n_0`, where the measured time is height deviates from the actual time which is shown in the plot by `Location of N_0`. Also, `n_0` shows the height deviation that occurred during the run of the algorithm.

![Que4](https://github.com/user-attachments/assets/9df34d44-1ac2-473e-8047-dc9dfe67414c)


In the plot, **`n_0`** is indicated by the green dashed line. Based on the visual inspection, we can conclude that `n_0` occurs around **[935]**.

---

If I modified the function to be:

```matlab
   x = f(n)
      x = 1;
      y = 1;
      for i = 1:n
         for j = 1:n
            x = x + 1;
            y = i + j;
```

## Question 4: Will this increate how long it takes the algorithm to run (e.x. you are timing the function like in #2)? 

Yes, the addition line of code `y = i + j` will increase the runtime a bit by adding one more operation per iteration. However, the overall time complexity of the algorithm will remain the same: \(O(n^2)\), so the growth rate is still quadratic.

---

## Question 5: Will it effect your results from #1?

No, it will not affect the results. The time complexity will remain the same \(O(n^2)\), and the added operation does not change the behavior, it will only increase the constant time factor.

---

## Question 6: Implement merge sort, upload your code to github and show/test it on the array [5,2,4,7,1,3,2,6].

Merge Sort code file name: MergeSort.py

![Que6](https://github.com/user-attachments/assets/acf7707d-7ead-4208-8b1c-f1d1c2b2810f)
