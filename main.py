import time
import numpy as np
import matplotlib.pyplot as plt

def f(n):
    x = 1
    for i in range(n):
        for j in range(n):
            x = x + 1

values_of_n = np.arange(0, 1000, 5)
values_of_times = []

for n in values_of_n:
    start_time = time.time()
    f(n)
    end_time = time.time()
    values_of_times.append(end_time - start_time)

coefficients = np.polyfit(values_of_n, values_of_times, 2)
polynomial_fit = np.poly1d(coefficients)

residuals = np.abs(values_of_times - polynomial_fit(values_of_n))
max_residual_index = np.argmax(residuals)
n_0 = values_of_n[max_residual_index]

plt.figure(figsize=(8, 5))
plt.scatter(values_of_n, values_of_times, label="Measured Time", color="red", s=20)
plt.plot(values_of_n, polynomial_fit(values_of_n), label=f"Polynomial Fit: {polynomial_fit}", color="blue")
plt.axvline(x=n_0, color='green', linestyle='--', label=f"n_0 ≈ {n_0}")
plt.axhline(y=values_of_times[max_residual_index], color='green', linestyle='--', label=f"n_0 ≈ {n_0}")
plt.text(n_0, values_of_times[max_residual_index], f' Location of N_0\n({n_0}, {values_of_times[max_residual_index]:.3f})', fontsize = 10)
plt.xlabel("n")
plt.ylabel("Time (seconds)")
plt.title("Execution Time of f(n)")
plt.legend()
plt.grid()
plt.show()