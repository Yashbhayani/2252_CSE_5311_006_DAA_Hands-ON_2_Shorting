import numpy as np

def simplex(A, b, c):
    m, n = A.shape
    N = set(range(n))
    B = set(range(n, n + m))
    x = np.zeros(n + m)

    while True:
        # Step 3: Choose an index e in N for which c[e] > 0
        e = None
        for j in N:
            if c[j] > 0:
                e = j
                break

        if e is None:
            return "Optimal", x[:n]

        # Step 4: Choose an index l in B that minimizes b[i] / A[i, e] for i in B where A[i, e] > 0
        min_ratio = float('inf')
        l = None
        for i in B:
            if A[i, e] > 0:
                ratio = b[i] / A[i, e]
                if ratio < min_ratio:
                    min_ratio = ratio
                    l = i

        if l is None:
            return "Unbounded", None

        # Step 12: Pivot
        x[l] = b[l] / A[l, e]
        for i in B:
            if i != l:
                x[i] = 0
        for j in N:
            if j != e:
                x[j] = 0

        # Step 13: Update N, B, A, b, and c
        N.discard(e)
        B.discard(l)
        N.add(l)

        for i in range(m):
            if i != l:
                A[i] -= A[i, e] * A[l]
                b[i] -= A[i, e] * b[l]
        c -= c[e] * A[l]
        b[l] /= A[l, e]
        A[l] /= A[l, e]
        c[e] /= A[l, e]

# Test
A = np.array([[1, -1, 1],
              [-1, 1, 0],
              [0, 1, -1]])
b = np.array([2, 1, 1])
c = np.array([1, 1, 1])

status, solution = simplex(A, b, c)
if status == "Optimal":
    print("Optimal solution:", solution)
elif status == "Unbounded":
    print("The problem is unbounded.")
