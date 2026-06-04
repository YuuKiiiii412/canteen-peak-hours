# Canteen Popular Time Analysis

## Problem Statement
A university canteen records its activity during a semester. Each record contains:

* A time slot indicating when the activity occurred:
    Morning
    Noon
    Afternoon
* The number of students who visited the canteen during that hour.

The canteen management wants to analyze the data for two purposes:

1. Determine the maximum total number of students within any consecutive period of exactly K hours.
2. Determine which time slot has the highest total number of students across all records.

Your task is to help the management perform this analysis.

If multiple time slots have the same highest total number of students, output the lexicographically smallest time slot.

## Input Format
The first line contains two integers:
N K
where:
    N is the number of records.
    K is the number of consecutive hours to analyze.

The next N lines each contain:
timeSlot students
where:

* timeSlot is one of:
    Morning
    Noon
    Afternoon
* students is the number of students recorded in that hour.

## Output Format
Print two lines.

Line 1:
The maximum total number of students in any consecutive period of exactly **K** hours.

Line 2:
The time slot with the highest accumulated number of students.

## Constraints
* 1 <= K <= N <= 100000
* 0 <= students <= 10000

## Sample Test Case

### Sample Input
8 3
Morning 80
Noon 120
Morning 150
Afternoon 200
Morning 250
Noon 300
Afternoon 180
Morning 100

### Sample Output
750
Morning

<!-- ### Explanation
For the student counts:
80 120 150 200 250 300 180 100

All consecutive windows of length 3 have sums:

* 80 + 120 + 150 = 350
* 120 + 150 + 200 = 470
* 150 + 200 + 250 = 600
* 200 + 250 + 300 = 750
* 250 + 300 + 180 = 730
* 300 + 180 + 100 = 580

The maximum sum is:
750

Accumulated students by time slot:
* Morning = 80 + 150 + 250 + 100 = 580
* Noon = 120 + 300 = 420
* Afternoon = 200 + 180 = 380

The highest total belongs to:
Morning -->
