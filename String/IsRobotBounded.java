public class IsRobotBounded {
    public static void main(String[] args) {
        IsRobotBounded sol = new IsRobotBounded();
        String str = "GGLLGG";
        System.out.println(sol.isRobotBounded(str)); ;
    }
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int d = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < instructions.length(); i++) {
            char tmp = instructions.charAt(i);
            
            if (tmp == 'L') {
                d += 3;
                d = d % 4;
            } else if (tmp == 'R') {
                d++;
                d = d % 4;
            } else {
                x += dir[d][0];
                y += dir[d][1];
            }
        }
        return x == 0 && y == 0 || d > 0; 
    }   
    public boolean isRobotBounded2(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}}; // up, right, down, left  
        for (int j = 0; j < ins.length(); ++j) {
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }            
        }
        return x == 0 && y == 0 || i > 0;
    } 
}
// Ref: https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC%2B%2BPython-Let-Chopper-Help-Explain