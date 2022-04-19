/**
 * @author Karthik Kolathumani
 * Print out the multiplication table for input n
 */
public class PrintMultiplicationTable {

    int table[][];

    public PrintMultiplicationTable(int n){
        table = new int[n][n];

        //Populating the first row
        for(int i= 0; i < table.length; i++ ){
            table[i][0] = i+1;
        }

        //Populating the first column
        for(int j=0; j< table[0].length; j++){
            if(j == 0) continue;
            else table[0][j] = j+1;
        }


        //Populate the multiplication table
        for(int i= 1; i < table.length; i++){
                for(int j = 1; j < table[0].length; j++){
                    table[i][j] = table[i][0] * table[0][j];
                }

        }
    }

    public void printMultiplicationTable(){

        for(int i=0; i<table.length; i ++){
            for(int j = 0; j<table.length; j++){
                System.out.print(table[i][j] +" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 12;
        PrintMultiplicationTable obj = new PrintMultiplicationTable(n);
        obj.printMultiplicationTable();

    }

}
