class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>[] rows = new HashSet[9];
                HashSet<String>[] cols = new HashSet[9];
                HashSet<String>[] boxes = new HashSet[9];

                // Khởi tạo 9 HashSet rỗng cho mỗi mảng
                for (int i = 0; i < 9; i++) {
                    rows[i] = new HashSet<>();
                    cols[i] = new HashSet<>();
                    boxes[i] = new HashSet<>();
                }

                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        char c = board[row][col];
                        if (c == '.') continue;   // ô trống, bỏ qua

                        int boxIndex = (row / 3) * 3 + (col / 3);
                        // TODO 1: kiểm tra xem c đã có trong rows[row] chưa
                        if (rows[row].contains(String.valueOf(c))) {

                            return false;
                        }
                        // TODO 2: kiểm tra xem c đã có trong cols[col] chưa
                        if (cols[col].contains(String.valueOf(c))) {
                            return false;
                        }
                        // TODO 3: kiểm tra xem c đã có trong boxes[boxIndex] chưa
                        if (boxes[boxIndex].contains(String.valueOf(c))) {
                            return false;
                        }
                        // Nếu 1 trong 3 điều trên đúng → return false ngay

                        // TODO 4: nếu chưa trùng ở cả 3 nơi, thêm c vào cả rows[row], cols[col], boxes[boxIndex]

                        rows[row].add(String.valueOf(c));
                        cols[col].add(String.valueOf(c));
                        boxes[boxIndex].add(String.valueOf(c));

                    }
                }
                return true;
    }
}
