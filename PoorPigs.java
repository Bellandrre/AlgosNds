
public class PoorPigs {
public static void main(String[] args) {
	int buckets =1000;
	int minutesToDie = 15;
	int minutesToTest = 60;
	poorPigs(buckets,minutesToDie,minutesToTest);
	}
public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
	int pigs=0;
	
	pigs =  (int) (buckets/minutesToDie);
	//System.out.println(pigs+1);
    return pigs;
}
}
