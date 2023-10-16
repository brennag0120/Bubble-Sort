import java.util.Arrays;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Assignment_6_2300 {

    public static int[] createRandomArray(int arrayLength){
        int[] array= new int[arrayLength];
        Random random= new Random(arrayLength);

        for(int i=0; i < array.length; i++){
            array[i]= random.nextInt(0,100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) throws IOException{
        FileWriter Writer = new FileWriter(filename);
        for(int i = 0; i < array.length; i ++){
            Writer.write(array[i] + "\n");
        }
        Writer.close();
     }


    public static int[] readFileToArray(String filename) throws FileNotFoundException{
        Scanner scanner= new Scanner(new File(filename));
        ArrayList<Integer> arrayList= new ArrayList<>();
            //int i=0;

        while(scanner.hasNextLine()){
            //System.out.println(i ++);
            arrayList.add(Integer.parseInt(scanner.nextLine()));

        }
        scanner.close();
        int []  array= new int[arrayList.size()];
        for( int i=0; i< arrayList.size(); i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    //public static void bubbleSort(int [] array){
      // Arrays.sort(array,Collections.reverseOrder());
        //bubbleSort(array,0,array.length);
    

    public static void bubbleSort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] <array[j]){
                    int temp=array[i];
                    array[i]= array[j];
                    array[j]=temp;
                }
            }
        }
        //if(end - start <= 1){
          //  return;
       // }
        
       // for(int i=start; i< end; i++){
           // if(array[i] > array[i+1]){
               // int temp=array[i];
              //  array[i]=array[i+1];
               // array[i+1]=temp;
          //  }
       // }
       // bubbleSort(array,start,end-1);
    }

    public static void main(String[] args) throws Exception{
        int [] array= createRandomArray(10);
        writeArrayToFile(array,"array.txt");
        System.out.println(Arrays.toString(array));

        readFileToArray("array.txt");
        bubbleSort(array);
        writeArrayToFile(array,"array2.txt");
        System.out.println(Arrays.toString(array));
        



    }
}
