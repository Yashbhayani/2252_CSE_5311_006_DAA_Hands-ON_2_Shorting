import timeit


def mergeSort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_side_array = arr[:mid]
        right_side_array = arr[mid:]

        mergeSort(left_side_array)
        mergeSort(right_side_array)

        i = j = k = 0

        while i < len(left_side_array) and j < len(right_side_array):
            if left_side_array[i] < right_side_array[j]:
                arr[k] = left_side_array[i]
                i += 1
            else:
                arr[k] = right_side_array[j]
                j += 1
            k += 1

        while i < len(left_side_array):
            arr[k] = left_side_array[i]
            i += 1
            k += 1

        while j < len(right_side_array):
            arr[k] = right_side_array[j]
            j += 1
            k += 1

    return arr


arr = [5, 2, 4, 7, 1, 3, 2, 6]
print(f"Original Array: {arr}")
start = timeit.default_timer()
print(
    f"Sorted Array: {str(mergeSort(arr))} within a time of {(timeit.default_timer() - start) * 1000:.2f} milliseconds\n")