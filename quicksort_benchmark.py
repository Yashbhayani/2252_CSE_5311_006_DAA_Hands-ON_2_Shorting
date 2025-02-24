import random
import time
import matplotlib.pyplot as plt
import pandas as pd
import sys

sys.setrecursionlimit(1000000)


def quicksort_fixed(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[-1]
    less_than_pivot_arr = [x for x in arr[:-1] if x <= pivot]
    equal_pivot_arr = [x for x in arr if x == pivot]
    greater_than_pivot_arr = [x for x in arr[:-1] if x > pivot]

    return quicksort_fixed(less_than_pivot_arr) + equal_pivot_arr + quicksort_fixed(greater_than_pivot_arr)


if __name__ == '__main__':
    sizes = [10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000]
    best_case_times = []
    worst_case_times = []
    average_case_times = []

    for n in sizes:
        array_best_case = list(range(n))
        array_worst_case = list(range(n, 0, -1))
        array_average_case = [random.randint(0, 10000) for _ in range(n)]

        start = time.time()
        quicksort_fixed(array_best_case)
        best_case_times.append(time.time() - start)

        start = time.time()
        quicksort_fixed(array_worst_case)
        worst_case_times.append(time.time() - start)

        start = time.time()
        quicksort_fixed(array_average_case)
        average_case_times.append(time.time() - start)

    pd.set_option('display.max_rows', None)
    pd.set_option('display.max_columns', None)
    pd.set_option('display.width', None)
    pd.set_option('display.colheader_justify', 'center')

    data = {
        "Array Size (n)": sizes,
        "Best Case Time (s)": best_case_times,
        "Worst Case Time (s)": worst_case_times,
        "Average Case Time (s)": average_case_times
    }

    df = pd.DataFrame(data)
    print(df)

    plt.plot(sizes, best_case_times, label="Best Case", color='blue')
    plt.plot(sizes, worst_case_times, label="Worst Case", color='red')
    plt.plot(sizes, average_case_times, label="Average Case", color='green')

    plt.scatter(sizes, best_case_times, color='blue', marker='.', s=100)
    plt.scatter(sizes, worst_case_times, color='red', marker='.', s=100)
    plt.scatter(sizes, average_case_times, color='green', marker='.', s=100)

    plt.xlabel("Array Size (n)")
    plt.ylabel("Time (seconds)")
    plt.legend()
    plt.show()