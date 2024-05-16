class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int i=0;
        int j= l-1;
        while(i<j) {
            for(int count=0; i+count<j; count++){
                rotate(matrix, i, j, count);
            }
            i++; j--;
        }
    }

    public void rotate(int[][] matrix, int i, int j, int count ) {
        int temp = matrix[i][i+count];
        matrix[i][i+count] = matrix[j-count][i];
        matrix[j-count][i] = matrix[j][j-count];
        matrix[j][j-count] = matrix[i+count][j];
        matrix[i+count][j] = temp;
    }
}
