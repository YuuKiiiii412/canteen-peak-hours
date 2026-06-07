# Problem Analysis and Design

## Real-World Context
Managing customer flow and allocating staff is a classic problem in restaurant chains, canteens, and food services. Knowing the "busiest time period" (to prepare ingredients/staff in advance) and the "overall busiest time slot" (to set up long-term shifts) helps the management system save costs and improve service quality.

## Problem Modeling
The problem is divided into two independent parts that can be processed simultaneously while reading the input data stream:
1. **Finding the maximum consecutive K-hour period:** This is the problem of finding a contiguous subarray of fixed length K with the maximum sum on a 1D array.
2. **Counting frequency by category:** The problem of grouping and summing values based on a String Key, then finding the key with the maximum value along with a lexicographical tie-breaking condition.

## Expected Solution (including Time/Space Complexity)
**Optimal Algorithm:**
- Store the student count of each record in an array of size N.
- Use the **Sliding Window** technique to calculate the sum of K consecutive elements. Instead of recalculating from scratch for each segment of K, we simply add the new element and subtract the oldest element that just left the window.
- Use a **HashMap** to map the time slot name to the total number of students. After traversing the data, we iterate through the HashMap to find the Key with the maximum Value, using `String.compareTo()` to handle tie-breaks.

**Complexity:**
- **Time Complexity:** O(N) since we only traverse the data array exactly once for both requests. Iterating through the HashMap at the end takes constant time O(1) because there are at most 3 Keys (Morning, Noon, Afternoon).
- **Space Complexity:** O(N) to allocate the array storing the student counts of N records to serve the Sliding Window technique.

## Test Case Design
The test case suite will be designed (from 20-40 cases) to cover the following aspects:
- **Typical Cases:** Randomized datasets with N from 10 to 1000, with an even distribution of data.
- **Stress Tests:** N = 100,000 to check for Time Limit Exceeded (TLE) errors if the code runs in O(N^2).
- **Boundary Conditions:** K = 1 (each window is 1 hour) and K = N (the window covers the entire dataset).

## Edge Cases
1. **Multiple time slots with the same maximum student total (Tie-break):** The code must choose "Afternoon" if it equals "Morning", or "Morning" if it equals "Noon" based on lexicographical order (A-Z).
2. **Zero-value data:** Some hours have no students (students = 0).
3. **Integer Overflow Prevention:** The maximum possible sum is 100,000 * 10,000 = 1,000,000,000. Although it falls within the safe range of a 32-bit `int`, proactively using the `long` type for sums (`maxSum`) ensures the program will not suffer from arithmetic overflow if the OJ system injects hidden tests that exceed standard constraints.