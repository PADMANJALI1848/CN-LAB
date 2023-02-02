import java.util.*;

class LeakyBucket
{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int capacity = 4,storage=0,sent ,accepted,output_rate=3;  
        System.out.println("Enter the number of packets");
        int n = read.nextInt();

        int input_packets[] = new int[n];
        System.out.println("Enter the size of each packet");
        for (int i = 0; i < n; i++) {
            input_packets[i] = read.nextInt();
        }

        System.out.println("Clock\tPacket Size\t  Accepted\t  Sent\t  Remaning");
        for (int i = 0; i < n; i++) {
           if (input_packets[i] != 0) {
            if (input_packets[i]+storage <= capacity) {
                accepted = input_packets[i];
                storage += input_packets[i];
            } else {
                accepted = -1;
            }
           } else {
            accepted = 0;
           }

           if(storage > 0)
           {
                if(storage <= output_rate)
                {
                    sent = storage;
                    storage = 0;
                }
                else{
                    sent = output_rate;
                    storage -= output_rate;
                }
           }
           else
           {
            sent = 0;
           }

           if (accepted == -1) {
            System.out.println((i+1) + "\t\t" + input_packets[i] +"\t\t" + "Dropped" + "\t  " + sent +"\t  " + storage);
           } else {
            System.out.println((i+1) + "\t\t" + input_packets[i] +"\t\t" + accepted + "\t  " + sent +"\t  " + storage);
           }
        }
        read.close();
    }
}
