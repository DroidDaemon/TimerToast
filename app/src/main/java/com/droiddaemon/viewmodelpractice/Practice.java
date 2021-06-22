package com.droiddaemon.viewmodelpractice;

import java.util.ArrayList;

class Practice {

    public static void main(String[] args) {
       int [][]arr =  matrixGeneration();
       matrixIteration(arr);

    }


    public static int [][] matrixGeneration(){
        int [][] arr = new int[3][3];
        int count = 1;
        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr.length;j++){
                arr[i][j] = count;
                count++;
//                System.out.println(" "+arr[i][j]);

            }
        }
        return arr;
    }


    public static void matrixIteration(int [][]arr){

        ArrayList<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr.length-1;

        System.out.println("left to right ");

        //left to right
            for(int k=left;k<=right;k++){
                System.out.println(" "+arr[top][k]);
            }
            top++;



        System.out.println(" top to bottom");

        //top to bottom

            for(int k=top;k<=bottom;k++){
                System.out.println(" "+arr[k][right]);
            }
            right--;

        System.out.println("right to left ");

        //right to left

            for(int j=right;j>=left;j--){
                System.out.println(" "+arr[bottom][j]);
            }
            bottom --;

        System.out.println("bottom to top");

       //bottom to top

            for(int j=bottom;j>=top;j--){
                System.out.println(" "+arr[j][left]);
            }


    }
}
