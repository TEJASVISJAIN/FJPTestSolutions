//QUESTION LINK:
//https://www.hackerrank.com/contests/fjp-4-till-recursion/challenges/path-of-a-snake

package FJP4.Hackerrank;
import java.util.*;

public class PathOfSnake {
    public static void main(String[] args) {

        //**        IMPORTANT NOTE      **
        //In this question as we aren't given any ladders and anything and just the dimension of the
        //board, thus we only have to calculate the number of ways the snake can go across the board.
        //that is across just a single row, therefore this question is no different that 'get Stair Path' question
        //*********************************************************************************************************
        // Link to 'get Stair Path' question(arraylist) : https://nados.io/question/get-stair-paths
        // Link to 'Print Stair Path' question(printing)  : https://nados.io/question/print-stair-paths
        // *********************************************************************************************************

        
        
        //declaring an scn variable
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt(); // board length
        int M = scn.nextInt(); // Number of faces of dice

        //We are calling 3 different methods in this question:

        System.out.println(count(N,M));// Number of paths
        System.out.println(paths(N, M));//Paths in an arraylist
        print(N,M);// listing all the paths
    }

    //Returning the number of paths possible for the snake
    public static int count(int N,int M){
        //initialising a 'count' variable for this recursion call
        int count = 0;
        
        //if the stair is equal to 0, we return 1 because we have reached to one of the possible answers
        if(N == 0){
            return 1;
        }
        if(N >0){
            for(int i = 1; i <= M; i++){
                //here we are incrementing the 'count' variable for this recursion call, fetching the values of all the calls that this makes
                count += count(N-i,M);
            }
        }
        //returning the count to the above recursion calls
        return count;
        
        //  NOTE:  in this function/question, we aren't entertaining N<0 as we don't want that.
    }
    
    
    //This is the 2nd function which prints the different paths 
    public static void print(int N,int M){
        //in order to maintain the original signature of the function, we are using a helper function to ge what we want 
        helper(N,M,"");
    }
    
    private static void helper(int N, int M, String s) {
        //as here we are in a void function, we can simply return from N<0 as it is undesirable
        if( N < 0){
            return;
        }
        // here if N == 0, this is one desirable way that the snake can traverse, therefore we print this and return to find more ways
        else if(N == 0){
            System.out.println(s);
            return;
        }
        else{
            // we used a for loop because we have the dice with sides M and keeping in mind we have to get every permutation of the path that we can get
            for(int i = 1; i <= M; i++){
                //if there is any error like, N<0 , we have used appropriate error handling in the top of the function
                helper(N-i,M,s+i);
            }
        }
    }
    
    // this is the 3rd function where we return the arraylist containing all the paths
    public static ArrayList<String> paths(int N,int M){
        //making a new arraylist to return the output
        ArrayList<String> ans = new ArrayList<>();
        //in this function we handle the N<0 and N == 0 cases differently ( watch the video mentioned in line 15)
        if( N < 0){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        else if(N == 0){
            //if N == 0, we just return an ArrayList of size 1, but be careful that the element in the arraylist has size 0
            ArrayList<String> list2 = new ArrayList<>();
            list2.add("");
            return list2;
        }
        else{
            for(int i = 1; i <= M; i++){
                //here we are getting all the possible ways from recursion call beneath it also known as out Faith 
                ArrayList<String> list3 = paths(N-i,M);
                // here we are just appending the number on the dice corresponding to the path it further took
                for(String s : list3){
                    ans.add(i+s);
                }
            }
        }
        // returning the ans to the function call above
        return ans;
    }
}
