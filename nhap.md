Canteen Popular Time Analysis
Problem Statement

Trong một học kỳ, hệ thống quản lý căng tin ghi nhận dữ liệu theo từng giờ hoạt động.

Mỗi bản ghi bao gồm:

Khung giờ (Morning, Noon, Afternoon)
Số lượng sinh viên đến trong giờ đó.

Ban quản lý muốn phân tích dữ liệu để:

Xác định khoảng K giờ liên tiếp có tổng số sinh viên lớn nhất.
Xác định khung giờ có tổng lượng sinh viên lớn nhất trong toàn bộ dữ liệu.

Hãy hỗ trợ ban quản lý thực hiện hai yêu cầu trên.

Input Format
Dòng đầu tiên:
N K

Trong đó:
N là số bản ghi.
K là số giờ liên tiếp cần phân tích.

N dòng tiếp theo:
timeSlot students

Trong đó:
timeSlot ∈ {Morning, Noon, Afternoon}
students là số sinh viên trong giờ đó.

Constraints
1 ≤ K ≤ N ≤ 100000
0 ≤ students ≤ 10000

Output Format
In ra 2 dòng.

Dòng thứ nhất:
Tổng số sinh viên lớn nhất trong một khoảng K giờ liên tiếp.

Dòng thứ hai:
Tên khung giờ có tổng lượng sinh viên lớn nhất.
Nếu nhiều khung giờ có cùng tổng lớn nhất:
In ra khung giờ đứng trước theo thứ tự từ điển.

Sample Input
8 3
Morning 80
Noon 120
Morning 150
Afternoon 200
Morning 250
Noon 300
Afternoon 180
Morning 100

Sample Output
750
Morning

Giải thích: 
Yêu cầu 1
Dãy số sinh viên:
80 120 150 200 250 300 180 100

Các cửa sổ độ dài 3:
350
470
600
750
730
580

Lớn nhất: 750

Yêu cầu 2
Cộng dồn theo khung giờ:

Morning   = 80 + 150 + 250 + 100 = 580

Noon      = 120 + 300 = 420

Afternoon = 200 + 180 = 380

Lớn nhất: Morning

UDT
class HourRecord {
    String timeSlot;
    int students;

    public HourRecord(String timeSlot, int students) {
        this.timeSlot = timeSlot;
        this.students = students;
    }
}
Thuật toán sử dụng
1. Sliding Window
Tìm:
max sum of K consecutive hours

Độ phức tạp: O(N)

2. HashMap
HashMap<String, Long> totalByTimeSlot

Ví dụ:
totalByTimeSlot.put(
    slot,
    totalByTimeSlot.getOrDefault(slot, 0L)
    + students
);

Độ phức tạp: O(N)
Time Complexity: O(N)
Space Complexity: O(N)