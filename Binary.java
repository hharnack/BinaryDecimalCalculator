import java.lang.*;
import java.util.*;
import javax.swing.*;
/**
 * Binary - This is a calculator that converts binary to decimal values and decimal to binary values.
 * 
 * @author Holly Harnack
 * @version Septemper 2018
 */
public class Binary {
    public static void main (String [] args) {
        //Declaring variables        
        String[] options = {"Binary to Decimal", "Decimal to Binary"};
        Integer  remainder = 0;
        int number, length, i, add = 0, decimal = 0;
        String input, binary = "", addBit = "";
        char bit;

        //This shows the message in a dialog box asking for the type of conversion
        int selection = JOptionPane.showOptionDialog(null, "Binary to decimal or "+
                "Decimal to Binary?","Calculator",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);

        if (selection == 0) //If binary to decimal
        {
            input = JOptionPane.showInputDialog("Enter the number in binary: ");
            length = input.length(); 
            
            //Evaluates each bit in the binary value and adds a number in base 2 depending on if its a 0 or 1
            for(i = 0; i<=(length-1) ; i++)
            {
                bit = input.charAt(i); 
       
                if (bit == 49)
                {
                    add = (int)Math.pow(2,i);
                    decimal += add;
                }
                else if (bit != 48)
                {
                    System.out.print("not a valid number"); 
                }
            }
            
            JOptionPane.showMessageDialog(null, "The number in decimal is " + decimal);
        }
        else if (selection == 1) //if decimal to binary 
        {
            input = JOptionPane.showInputDialog("Enter the number in Decimal: ");
            number = Integer.parseInt(input);
            
            //Adds a zero or one to the binary value depending on the remainder of the decimal value divided by two  
            while (number > 0) 
            {
                remainder = number % 2;
                if (remainder == 1 )
                {
                    addBit = "1"; 
                } else if (remainder == 0 )
                {
                    addBit = "0";
                }
                number /= 2;
                binary += addBit;
            }  
            
            //Must display in reverse 
            JOptionPane.showMessageDialog(null, "The number in binary is " + new StringBuilder(binary).reverse().toString());
        } 
        
        System.exit(0);
    } 
}
