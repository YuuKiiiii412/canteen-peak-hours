# Canteen Traffic Analysis

## Problem Statement
During a semester, the canteen management system records operational data on an hourly basis. Each record includes a time slot of the day (Morning, Noon, Afternoon) and the number of students visiting during that hour. 

The canteen management wants to analyze the data to optimize staffing. Write a program to assist the management in fulfilling the following two requests:
1. Identify the consecutive K-hour period with the highest total number of students.
2. Identify the time slot with the highest total number of students across the entire dataset.

## Input Format
The first line contains two integers:
N K
Where:
- N is the number of records.
- K is the number of consecutive hours to analyze.

The next N lines each contain a record in the following format:
timeSlot students
Where:
- timeSlot ∈ {Morning, Noon, Afternoon}
- students is the number of students recorded during that hour.

## Output Format
Print exactly 2 lines:
- First line: The highest total number of students in a consecutive K-hour period.
- Second line: The name of the time slot with the highest total number of students. (If multiple time slots have the same highest total, print the one that comes first in lexicographical order).

## Constraints
- 1 ≤ K ≤ N ≤ 100000
- 0 ≤ students ≤ 10000

## Sample Test Cases

**Sample Input 1**
5 2
Morning 100
Noon 500
Afternoon 300
Morning 200
Noon 400

**Sample Output 1**
800
Noon

**Explanation 1**
- The sums of consecutive K=2 hour periods are: 
  (100+500)=600, (500+300)=800, (300+200)=500, (200+400)=600. 
  The maximum period sum is 800.
- Total students by time slot: 
  Morning = 100 + 200 = 300.
  Noon = 500 + 400 = 900.
  Afternoon = 300.
  The highest time slot is Noon.
