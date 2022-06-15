package com.yue.learning.algorithm.matrix;

/**
 * 学生矩阵
 * <p>
 * 学校组织活动，将学生排成一个矩形方阵。请在矩形方阵中找到最大的位置相连的男生数量。这个相连位置在一个直线上，方向可以是水平的、垂直的、呈对角线的或者反对角线的。
 * 注：学生个数不会超过10000.
 * <p>
 * F,M,M,F
 * F,M,M,F
 * F,F,F,M
 */
public class StudentMatrix {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'F', 'M', 'M', 'F'}, {'F', 'M', 'M', 'F'}, {'F', 'F', 'F', 'M'}};
        System.out.println(process(matrix));
    }

    private static int process(char[][] matrix) {
        int max = 0;
        //横
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'M') {
                    int count = 0;
                    while (j < matrix[0].length && matrix[i][j] == 'M') {
                        count++;
                        j++;
                    }
                    max = Math.max(max, count);
                }
            }
        }

        //竖
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 'M') {
                    int count = 0;
                    while (i < matrix.length && matrix[i][j] == 'M') {
                        count++;
                        i++;
                    }
                    max = Math.max(max, count);

                }
            }
        }

        //斜
        for (int i = 1; i < (matrix[0].length + matrix.length - 2); i++) {
            int h = Math.min(matrix.length - 1, i);
            int s = i - h;
            while (h >= 0 && s < matrix[0].length) {
                if (matrix[h][s] == 'M') {
                    int count = 0;
                    while (h >= 0 && matrix[h][s] == 'M') {
                        count++;
                        h--;
                        s++;
                    }
                    max = Math.max(max, count);
                }
                h--;
                s++;
            }
        }

        //反斜
        for (int i = matrix.length - 1; i > -matrix[0].length; i--) {

            int s = Math.min();
            int h = matrix.length - 1;
            while (h >= 0 && s < matrix[0].length&&s>=0) {
                if (matrix[h][s] == 'M') {
                    int count = 0;
                    while (h >= 0 && matrix[h][s] == 'M') {
                        count++;
                        h--;
                        s--;
                    }
                    max = Math.max(max, count);
                }
                h--;
                s--;
            }
        }

        return max;
    }
}
