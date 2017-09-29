package com.jk.solution;

public class ZigZag_6 {

    public static void test() {
        System.out.println("6 ZigZag:");
        System.out.println(convert("PAYPALISHIRING", 2));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        int minRow = Math.max(1, numRows / 2);
        int numCol = (s.length() / minRow) + 1;
        Character[][] array0 = new Character[numCol][numRows];

        int row = 0;
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            // the pattern sucks
            if (numRows == 2) {
                if (row % 2 == 0) {
                    if (col == 1) {
                        i--;
                    } else {
                        array0[row][col] = s.charAt(i);
                    }
                } else {
                    if (col == 0) {
                        i--;
                    } else {
                        array0[row][col] = s.charAt(i);
                    }
                }
                col++;
            } else {
                if (row % 2 == 0) {
                    array0[row][col] = s.charAt(i);
                    col++;
                } else {
                    if (col == 0 || col == numRows - 1) {
                        i--;
                    } else {
                        array0[row][col] = s.charAt(i);
                    }
                    col--;
                }
            }

            if (col > (numRows - 1) || col < 0) {
                row++;
                if (row % 2 == 0) {
                    col = 0;
                } else {
                    col = numRows - 1;
                }
            }
        }

        StringBuilder ret = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < numCol; i++) {
                Character c = array0[i][j];
                if (c != null) {
                    line.append(c);
                }
            }
            ret.append(line.toString());
        }

        return ret.toString();
    }
}
