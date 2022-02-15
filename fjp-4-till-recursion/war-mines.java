//QUESTION LINK:-
//https://www.hackerrank.com/contests/fjp-4-till-recursion/challenges/war-mines


package FJP4.Hackerrank;
import java.util.*;

public class WarMines {
    public static void main(String[] args) {
        //declaring an scn variable
        Scanner scn = new Scanner(System.in);
        // inputting number of rows
        int m = scn.nextInt();
        //inputting number of columns
        int n = scn.nextInt();
        //initialising a new array
        int[][] field = new int[m][n];
        //inputting the values in that array
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                field[i][j] = scn.nextInt();
            }
        }
        //marking -1 in all the adjacent elements of 0
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field[0].length; j++) {
                if(field[i][j] == 0){
                    if( i > 0){
                        field[i-1][j] = -1;
                    }
                    if( i < field.length - 1){
                        field[i+1][j] = -1;
                    }
                    if( j > 0){
                        field[i][j-1] = -1;
                    }
                    if( j < field[0].length - 1){
                        field[i][j+1] = -1;
                    }
                }
            }
        }
        // UNCOMMENT THE BELOW CODE IF YOU WANT TO SEE HOW IS THE FINAL ARRAY LOOKING LIKE
        //********************************************************************************
//        for(int[] arr : field){
//            for(int a: arr){
//                System.out.print(a+" ");
//            }
//            System.out.println();
//        }
        //*********************************************************************************

        //calling the function 'paths'
        paths(field);


        //TO REACH HERE FIRST LOOK AT THE 'paths' FUNCTION AND BEYOND, THAT IS EVERYTHING BEYOND THIS BLOCK
        //*********************************************************************************************************
        //declaring a min integer with an initialised value of the maximum int possible
        int min = Integer.MAX_VALUE;

        //if the list is empty we just return a line
        if(list.isEmpty()){
            System.out.println("soldier:KIA");
        }
        //else we iterate through the arraylist comparing the size of every string stored in it to the 'min' integer
        else{
            for(String s: list){
                if( s.length() < min){
                    min = s.length();
                }
            }
            //when we finish the loop, we obtain the answer which we simply output
            System.out.println(min);
        }
        //***********************************************************************************************************

    }


    //declaring a static 2d array for all the possible directions
    static int[][] dir = {{0,-1},{0,1},{1,0},{-1,0} };
    //declaring a static 1d array for all the string values for the above corresponding directions
    static String[] p = {"l","r","u","d"};
    //declaring a static arraylist of type string to store all the paths possible
    static ArrayList<String> list = new ArrayList<>();


    //function paths is used to iterate through all the possible rows and their first column only
    public static void paths(int[][] field){
        for(int i = 0; i < field.length; i++){
            //calling a helper function 'fpath'
            fpath(i,0,field,"");
        }
    }

    //helper function which will try to find paths starting from the row provided by the 'paths' function and first column
    private static void fpath(int row, int col, int[][] field, String s) {
        //adding constraints which when met will just return the function as they are undesirable
        if(row < 0 || col < 0 || row >= field.length || col >= field[0].length || field[row][col] < 1){
            return;
        }
        //if we somehow reach at last column we just add the path to the 'list' arraylist made earlier
        if( col == field[0].length - 1){
            list.add(s);
            return;
        }
        else{
            //iterating through the directions 2d array made earlier using a for loop
            for(int i = 0; i < dir.length; i++){
                //marking the current element cell as -1 so that it wont be traverse again in one path
                field[row][col] = -1;
                fpath(row+dir[i][0], col+dir[i][1],field,s+p[i]);
                //if the algorithm backtrcks then we unmark the element cell by assigning the original value to it
                field[row][col] = 1;
            }
        }
    }

}


}
