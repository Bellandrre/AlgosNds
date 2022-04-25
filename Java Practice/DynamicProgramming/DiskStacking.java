package DynamicProgramming;
import java.util.*;
public class DiskStacking {

    static List<Disk> diskObjectList;
    static List<Disk> sortedByWidth;
    static List<Disk> sortedByDepth;
    static List<Disk> sortedByHeight;
    static HashMap<Disk, Integer> seenSubProblem;

    public DiskStacking(){
        diskObjectList = new ArrayList<>();
        seenSubProblem = new HashMap<>();
        sortedByWidth = new ArrayList<>();
        sortedByDepth = new ArrayList<>();
        sortedByHeight = new ArrayList<>();
    }
    static class Disk{
        Integer width;
        Integer depth;
        Integer height;

        public Disk(int width, int depth, int height){
            this.width = width;
            this.depth = depth;
            this.height = height;
        }
    }



    public static int diskStacking(List<Integer[]> disks) {
        // Write your code here.

        // Create Disk objects[width, depth, height]

        constructObjects(disks);

        // Construct sort by width
        sortByWidth();

        // Construct sort by depth
        sortByDepth();

        //Construct sort by height
        sortByHeight();

        int maxHeight = Integer.MIN_VALUE;

        for(int i = 0; i < diskObjectList.size(); i++){

            Disk currentDiskObject = diskObjectList.get(i);
            int currentMaxHeight = Integer.MIN_VALUE;

            for(int j = 0; j < diskObjectList.size(); j++){
                if(i == j) continue;

                Disk compareWidthDiskObject = diskObjectList.get(j);
                if(compareWidthDiskObject.width > currentDiskObject.width){

                    if(compareWidthDiskObject.depth > currentDiskObject.depth){

                        if(seenSubProblem.containsKey(compareWidthDiskObject)){
                            currentMaxHeight = currentDiskObject.height + seenSubProblem.get(compareWidthDiskObject);
                            maxHeight = Math.max(maxHeight, currentMaxHeight);

                        }else{



                        }
                    }
                }

            }
        }

        return maxHeight;
    }

    private static void constructObjects(List<Integer[]> disks){
        for(Integer[] disk : disks){
            int width = disk[0];
            int depth = disk[1];
            int height = disk[2];

            Disk newDisk = new Disk(width, depth, height);
            diskObjectList.add(newDisk);
        }
    }

    private static void sortByWidth(){
        Collections.copy(diskObjectList, sortedByWidth);
        sortedByWidth.sort(new Comparator<Disk>(){
            public int compare(Disk a, Disk b){
                return a.width - b.width;
            }
        });
    }

    private static void sortByDepth(){
        Collections.copy(diskObjectList, sortedByDepth);
        sortedByWidth.sort(new Comparator<Disk>(){
            public int compare(Disk a, Disk b){
                return a.depth - b.depth;
            }
        });
    }

    private static void sortByHeight(){
        Collections.copy(diskObjectList, sortedByHeight);
        sortedByWidth.sort(new Comparator<Disk>(){
            public int compare(Disk a, Disk b){
                return a.height - b.height;
            }
        });
    }

    public static void main(String[] args) {
        int input[][] = {{2, 1, 2}, {3, 2, 3}, {2, 2, 8}, {2, 3, 4}, {1, 3, 1}, {4, 4, 5}};
        DiskStacking diskStackingObj = new DiskStacking();
        List<Integer[]> listIntArray = new ArrayList<>();

        for(int i = 0 ; i < input.length ; i++){
            Integer newIntArray[] = new Integer[3];
            newIntArray[0] = input[i][0];
            newIntArray[1] = input[i][1];
            newIntArray[2] = input[i][2];

            listIntArray.add(newIntArray);
        }
        System.out.print(diskStackingObj.diskStacking(listIntArray));

        System.out.print("\n");
        System.out.print("Happy");
    }

}
