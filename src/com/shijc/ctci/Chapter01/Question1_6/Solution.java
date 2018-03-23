package com.shijc.ctci.Chapter01.Question1_6;

/**
 * 1.6像素翻转
 * 题目描述
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
 * 在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于
 * 500，图像元素小于等于256。
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author shijiacheng
 * @date 2018/03/23
 */
public class Solution {
    public int[][] transformImage(int[][] mat, int n) {


        for (int layer = 0; layer < n/2; layer++) {

            int first = layer;
            int last = n-layer-1;

            for (int i = first; i < last; i++) {
                int offset = i-first;

                int top = mat[first][i];

                mat[first][i] = mat[last-offset][first];

                mat[last-offset][first] = mat[last][last-offset];

                mat[last][last-offset] = mat[i][last];

                mat[i][last] = top;

            }


        }

        return mat;
    }

    //[[1,2,3],[4,5,6],[7,8,9]],3
    public static void main(String[] args){
        Solution s = new Solution();

        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.transformImage(array,3));
    }
}
