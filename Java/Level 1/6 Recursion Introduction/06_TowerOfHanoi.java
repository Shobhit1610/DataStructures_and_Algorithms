import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int disks = scanner.nextInt();
        int towerA = scanner.nextInt();
        int towerB = scanner.nextInt();
        int towerC = scanner.nextInt();
        scanner.close();

        toh(disks,towerA,towerB,towerC);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        
        if(n==0) return;

        toh(n-1,t1id,t3id,t2id);
        System.out.println(n+"["+t1id+" -> "+t2id+"]");
        toh(n-1,t3id,t2id,t1id);
    }

}