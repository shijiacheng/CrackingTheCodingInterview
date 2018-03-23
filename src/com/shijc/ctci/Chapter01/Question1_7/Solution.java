package com.shijc.ctci.Chapter01.Question1_7;

/**
 * 1.7清除行列
 * 题目描述
 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
 测试样例：
 [[1,2,3],[0,1,2],[0,0,1]]
 返回：[[0,0,3],[0,0,0],[0,0,0]]
 * @author shijiacheng
 * @date 2018/03/23
 */
public class Solution {
    public int[][] clearZero(int[][] mat, int n) {

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]){
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }
}
