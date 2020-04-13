/*
 * Author: Miriam Ekiye
 * Program purpose: This program will read a first name and last name, and sequencially search a file for the name entered
 * Date: 2/16/2020
 */
package infosystem2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
 *
 * @author Miriam
 */
public class InfoSystem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        
        //collect the info of the file name, user first, and last name which the program will search for
        
        System.out.println("Enter the file name: ");
        String seqFile = sc.next();
        System.out.println("Enter the first name: ");
        String firstName = sc.next();
        System.out.println("Enter the last name: ");
        String lastName = sc.next();
       
        
        //Variables for searching 
        boolean found = false;
        int index = 0;
        int element = -1;
        
        try{
            File fw = new File(seqFile);
       
            PrintWriter pw = new PrintWriter(fw);
            pw.print( firstName + " ");
            pw.print(lastName + " ");
            
        
            pw.close();
       }
        catch(IOException e)
        {
            System.out.println("ERROR");
    
        
         }
        
        
        //Reading input from the file
        
        try{
             File fw = new File(seqFile);
            Scanner data = new Scanner(fw);
            FileReader fr = new FileReader(seqFile);
            BufferedReader br = new BufferedReader(fr);
            
            String str;
   
          while((str = br.readLine()) != null){
               out.println(str + " was found ");
                
               //used to get the lenght of the file 
             File f = new File("F:\\seqFile.txt"); 
           
             //sequencially searching through the files
            while(!found && index < f.length())
            {
               //cheching if the names of the files are on the file
                if(str == (firstName) || str == (lastName))
                {
                    found = true;
                    System.out.print(" Names where found ");
                     
                }
                else
                {
                    System.out.println(" Record not found. ");
                
                }
                    
            }
            
          }  
            
          
            br.close();
        } catch (IOException e){
            out.println("File not found ");
        }
     
        
        
    }
    
}
