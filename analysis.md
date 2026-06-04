# Problem Analysis and Design

## Real-World Context
University canteens often experience varying levels of student traffic throughout the day. Understanding these traffic patterns helps management:

* Allocate staff more efficiently.
* Prepare sufficient food and beverages.
* Reduce waiting times during peak periods.
* Improve overall service quality.

This problem simulates the analysis of canteen activity records collected over a semester.

The management is interested in two types of information:
1. The busiest consecutive period of K hours.
2. The time slot (Morning, Noon, or Afternoon) that serves the largest total number of students.

## Problem Modeling
Each record consists of:
* A time slot (Morning, Noon, or Afternoon)
* The number of students during that hour

A record can be represented using a User Defined Type (UDT):

class HourRecord {
    String timeSlot;
    int students;

    public HourRecord(String timeSlot, int students) {
        this.timeSlot = timeSlot;
        this.students = students;
    }
}

The input data is stored in an array of HourRecord objects.

Two independent tasks must be solved:

### Task 1
Find the maximum total number of students among all consecutive segments of exactly K records.

### Task 2
Find the time slot whose accumulated student count is the largest.

## Expected Solution

### Task 1: Sliding Window
#### Idea
1. Compute the sum of the first K records.
2. Move the window one position at a time.
3. Remove the value leaving the window.
4. Add the new value entering the window.
5. Update the maximum sum.

#### Example
Student counts:
80 120 150 200 250 300 180 100

K = 3
First window:
80 + 120 + 150 = 350

Move right:
350 - 80 + 200 = 470

Continue until all windows are processed.

#### Complexity
Time:
O(N)

Space:
O(1)

excluding input storage.

### Task 2: HashMap
Use a HashMap to accumulate the total number of students for each time slot.

Example:
HashMap<String, Long> totalByTimeSlot = new HashMap<>();

For every record:

totalByTimeSlot.put(
    slot,
    totalByTimeSlot.getOrDefault(slot, 0L) + students
);

After processing all records:
* Find the largest accumulated value.
* If multiple time slots share the same value, choose the lexicographically smallest one.

#### Complexity

Time:
O(N)

Space:
O(1)

Since there are only three possible time slots.

## Overall Complexity

### Time Complexity

Task 1:
O(N)

Task 2:
O(N)

Total:
O(N)

### Space Complexity
Input storage:
O(N)

HashMap:
O(1)

Total:
O(N)

## Test Case Design
The official test suite should cover:

### Basic Cases
* Small values of N and K
* Typical mixed records

### Boundary Cases
* N = 1
* K = 1
* K = N

### Uniform Data
* All student counts are zero
* All student counts are equal

### Tie Cases
* Multiple time slots have identical accumulated totals
* Verify lexicographical tie-breaking

### Large Cases
* N = 100000
* Random student counts
* Performance stress testing

### Special Patterns
* Increasing sequence
* Decreasing sequence
* Alternating large and small values

## Edge Cases
### Case 1: Single Record
Input
1 1
Morning 500

Output
500
Morning

### Case 2: K Equals N
Input
5 5
Morning 10
Noon 20
Afternoon 30
Morning 40
Noon 50

Output
150
Morning

### Case 3: All Zero Values
Input
4 2
Morning 0
Noon 0
Afternoon 0
Morning 0

Output
0
Afternoon

Explanation:
All accumulated totals are 0.
Lexicographical order:
Afternoon < Morning < Noon

Therefore, the answer is:
Afternoon

### Case 4: Tie in Total Students
Input
4 2
Morning 100
Noon 100
Morning 100
Noon 100

Output
200
Morning

Explanation:
Morning = 200
Noon = 200
Choose the lexicographically smaller time slot.
