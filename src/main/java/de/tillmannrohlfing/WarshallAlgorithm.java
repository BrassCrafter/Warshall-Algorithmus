package de.tillmannrohlfing;

public class WarshallAlgorithm {
    public static boolean[][] calculate(boolean[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int k = 0; k < matrix[i].length; k++){
                    matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
                }
            }
        }
        return matrix;
    }

    public static double[][] calculate(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                for(int k = 0; k < matrix[i].length; k++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return matrix;
    }
}
