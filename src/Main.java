import java.util.*;
import java.io.*;
public class Main {
    // Draws the first two rectangles then desets(?) the original two rectangles with the third rectangle
    // with the use of a boolean array. Then individually count all the filled out squares.
    static int N = 1000;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter("billboard.out");

        boolean[][] board = new boolean[2*N+1][2*N+1];
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            minX = Math.min(minX, x1);
            maxX = Math.max(maxX, x2);
            minY = Math.min(minY, y1);
            maxY = Math.max(maxY, y2);
            for (int a = x1; a < x2; a++) {
                for (int b = y1; b < y2; b++) {
                    board[b+N][a+N] = true;
                }
            }
        }

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        minX = Math.min(minX, x1);
        maxX = Math.max(maxX, x2);
        minY = Math.min(minY, y1);
        maxY = Math.max(maxY, y2);
        for (int a = x1; a < x2; a++) {
            for (int b = y1; b < y2; b++) {
                board[b+N][a+N] = false;
            }
        }
        System.out.println("X: " + minX + " " + maxX);
        System.out.println("Y: " + minY + " " + maxY);
        int area = 0;
        for (int i = minX + N; i <= maxX+N; i++) {
            for (int j = minY+N; j <= maxY+N; j++) {
                if (board[j][i]) { area++;}
            }
        }

        pw.println(area);
        pw.close();

    }
}