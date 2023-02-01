import java.util.*;
// import java.io.*;

class CRC
{
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the data : ");
        String message = read.nextLine();
        System.out.println("Enter the generator : ");
        String gen = read.nextLine();

        int dividend[] = new int[message.length() + gen.length() - 1];
        int divisor[] = new int[gen.length()];

        for (int i = 0; i < message.length(); i++) {
            dividend[i] = Integer.parseInt(message.charAt(i)+"");
        }
        for (int i = 0; i < gen.length(); i++) {
            divisor[i] = Integer.parseInt(gen.charAt(i)+"");
        }

        //CRC
        for (int i = 0; i < message.length(); i++) {
            if(dividend[i] == 1)
            {
                for (int j = 0; j < divisor.length; j++) 
                {
                    dividend[i+j] ^= divisor[j];
                }
            }
        }

        System.out.println("CRC is");
        for (int i = (dividend.length - divisor.length + 1); i < dividend.length ; i++) {
            System.out.print(dividend[i]);
        }
        System.out.println(" ");

        System.out.println("Checksum code : ");
        for (int i = 0; i < message.length(); i++) {
            dividend[i] = Integer.parseInt(message.charAt(i)+"");
        }
        for (int i = 0; i < dividend.length; i++) {
            System.out.print(dividend[i]);
        }
        System.out.println(" ");

        //At receiver side
        for (int i = 0; i < message.length(); i++) {
            if(dividend[i] == 1)
            {
                for (int j = 0; j < divisor.length; j++) 
                {
                    dividend[i+j] ^= divisor[j];
                }
            }
        }

        boolean valid  = true;
        for (int i = 0; i < dividend.length; i++) {
            if(dividend[i] != 0)
            {
                valid = false;
                break;
            }
        }
        if(valid)
        {
            System.out.println("Data transmitted is valid");
        }
        else
        {
            System.out.println("Data transmitted is invalid");
        }
        read.close();
    }
}