import random
import timeit


def quicksort_fixed(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[-1]
    less_than_pivot_arr = [x for x in arr[:-1] if x <= pivot]
    equal_pivot_arr = [x for x in arr if x == pivot]
    greater_than_pivot_arr = [x for x in arr[:-1] if x > pivot]

    return quicksort_fixed(less_than_pivot_arr) + equal_pivot_arr + quicksort_fixed(greater_than_pivot_arr)


def quicksort_random(arr):
    if len(arr) <= 1:
        return arr

    random_pivot_index = random.randint(0, len(arr) - 1)
    pivot = arr[random_pivot_index]
    arr[0], arr[random_pivot_index] = arr[random_pivot_index], arr[0]
    less_than_pivot_arr = [x for x in arr[1:] if x <= pivot]
    greater_than_pivot_arr = [x for x in arr[1:] if x > pivot]

    return quicksort_random(less_than_pivot_arr) + [pivot] + quicksort_random(greater_than_pivot_arr)


if __name__ == '__main__':
    arr = [random.randint(0, 10000) for _ in range(10)]
    print(f"Original Array: {str(arr)} with a length of {len(arr)}.\n")
    start = timeit.default_timer()
    print("Quicksort with the fixed pivot.")
    print(f"Sorted Array: {str(quicksort_fixed(arr))} within a time of {(timeit.default_timer() - start) * 1000:.4f} milliseconds.\n")
    start = timeit.default_timer()
    print("Quicksort without the fixed pivot.")
    print(f"Sorted Array: {str(quicksort_random(arr))} within a time of {(timeit.default_timer() - start) * 1000:.4f} milliseconds.\n")

    arr = [random.randint(0, 10000) for _ in range(20)]
    print(f"Original Array: {str(arr)} with a length of {len(arr)}.\n")
    start = timeit.default_timer()
    print("Quicksort with the fixed pivot.")
    print(f"Sorted Array: {str(quicksort_fixed(arr))} within a time of {(timeit.default_timer() - start) * 1000:.4f} milliseconds.\n")
    start = timeit.default_timer()
    print("Quicksort without the fixed pivot.")
    print(f"Sorted Array: {str(quicksort_random(arr))} within a time of {(timeit.default_timer() - start) * 1000:.4f} milliseconds.")