/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fileinterleavetryresourcesobject;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author GENE
 */
public class LineSequentialTryResourcesObject implements AutoCloseable{
    private BufferedReader fileIn;
    private PrintWriter fileOut;
    private String ioMode;
    
    
    public LineSequentialTryResourcesObject(String ioFile, String ioMode) throws 
            IOException {
        if(ioMode == "input")
        {
            fileIn = new BufferedReader(new FileReader(ioFile));
        }
        else 
        {
            fileOut = new PrintWriter(
                new BufferedWriter(
                new FileWriter(ioFile)));
        }
        this.ioMode = ioMode;
    } 
    
    public String read() throws IOException{
//        String inputLine ="";
//        try {
            
          return this.fileIn.readLine();
            
//        }
//        catch(IOException e ) 
//        {
//            System.out.println("IO Error" + e.getMessage());
//        }
//        
//        return inputLine;
    }
    
    public void write(String outputLine) throws IOException 
    {
        this.fileOut.println(outputLine);
    }
    
    public ArrayList<String> readAll() throws IOException
    {
        String inputLine = "";
        ArrayList<String> inputLines = new ArrayList <String> ();
//        try (BufferedReader readFile = new BufferedReader(new FileReader(inFile)))
//        {
            while((inputLine = this.fileIn.readLine()) != null)
                    {
                        inputLines.add(inputLine);
                    }
//        }
//        catch(IOException e) 
//        {
//            System.out.println("IO Error" + e.getMessage());
//        }
        return inputLines;
    }
    
    public void writeAll(ArrayList<String> outputLines)
    {
//        try (PrintWriter writeFile = new PrintWriter(
//        new BufferedWriter(new FileWriter(outFile))))
//        {
            for(int i = 0; i < outputLines.size(); i++)
            {
                this.fileOut.println(outputLines.get(i));
            }
//        }
//        catch(IOException e) 
//        {
//            System.out.println("IO Error" + e.getMessage());
//        }
    }
    
    public void close() throws IOException
    {
        if(this.ioMode == "input")
        {
            this.fileIn.close();
        }
        else
        {
            this.fileOut.close();
        }
    }
}
