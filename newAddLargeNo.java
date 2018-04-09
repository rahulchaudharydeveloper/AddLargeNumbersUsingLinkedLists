import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.LinkedList; 
public class newAddLargeNo
{
    public static void Display()
    {
        System.out.println("Nummber of nodes of first list = "+l1);
        System.out.println("Nummber of nodes of second list = "+l2);
        /* Printing ans list */
        System.out.print("\nSum = ");
        for (int i = ans.size() - 1; i >= 0; i--)
            System.out.print(ans.get(i));
        System.out.println();       
    }

    public static void AddLN(String s1,String s2)
    {
        l1 = s1.length(); l2 = s2.length();        
        for (int i = l1 - 1; i >= 0; i--)
            num1.add(s1.charAt(i) - '0');
        for (int i = l2 - 1; i >= 0; i--)
            num2.add(s2.charAt(i) - '0');
        /* Adding digits and storing in ans list */
        int len = l1 > l2 ? l1 : l2;
        int carry = 0;
        for (int i = 0; i < len; i++)
        {
            int d1 = 0, d2 = 0;            
            try {
                d1 = num1.get(i);
            } 
            catch(Exception e){}            
            try {
                d2 = num2.get(i);
            } 
            catch(Exception e){}                        
            int x = d1 + d2 + carry;
            ans.add(x % 10);
            carry = x / 10;
        }
        /* Adding carry */
        while (carry != 0)
        {
            ans.add(carry % 10);
            carry /= 10;
        }
        Display();
    }

    public static void ValidateData(String firstline,String secondline)
    {
        if (firstline.matches("[0-9]+") && secondline.matches("[0-9]+") ) {
            AddLN(firstline,secondline);
        }
        else
            System.out.println("make sure file contain only numbers");
    }

    public static void ReadFile(String a)
    {
        try
        {
            File f = new File(a);
            if(f.exists() && !f.isDirectory()) { 
                BufferedReader b = new BufferedReader(new FileReader(f));
                String readLine = "",firstline="",secondline="";
                System.out.println("Reading file");
                for(int i=0;i<2;i++)
                {
                    readLine = b.readLine();
                    if(i==0)
                    {
                        System.out.println("First Line "+readLine);
                        firstline=readLine;
                    }
                    else
                    {
                        System.out.println("Second Line "+readLine);
                        secondline=readLine;
                    }
                }
                ValidateData(firstline,secondline);
            }
            else
                System.out.println("File Not Found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        try
        {
            ReadFile(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Enter the file name (make sure file is in the current directory)");
            String filename=scan.next();
            ReadFile(filename);
        }
    }
    static int l1=0,l2=0;
    static Scanner scan=new Scanner(System.in);
    static LinkedList<Integer> num1 = new LinkedList<Integer>();
    static LinkedList<Integer> num2 = new LinkedList<Integer>();
    static LinkedList<Integer> ans = new LinkedList<Integer>();
}