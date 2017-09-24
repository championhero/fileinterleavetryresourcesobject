/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinterleavetryresourcesobject;

import java.io.IOException;

/**
 *
 * @author GENE
 */
public class FileInterLeaveTryResourcesObject {
    
    public static void main(String[] args) {
        String inFile1 = "C:/Users/GENE/Desktop/test/PayrollMasterA.DAT";
        String inFile2 = "C:/Users/GENE/Desktop/test/PayrollMasterB.DAT";
        String outFile = "C:/Users/GENE/Desktop/test/PayrollMaster.DAT";
        String inputLine;
        
        try(
                LineSequentialTryResourcesObject inFileStream1 = new 
        LineSequentialTryResourcesObject(inFile1, "input");
                LineSequentialTryResourcesObject inFileStream2 = new
        LineSequentialTryResourcesObject(inFile2, "input");
                LineSequentialTryResourcesObject outFileStream = new
        LineSequentialTryResourcesObject(outFile, "output");
           )
        {
            while((inputLine = inFileStream1.read()) != null)
            {
                outFileStream.write(inputLine);
                inputLine = inFileStream2.read();
                outFileStream.write(inputLine);  
            }
        }
        catch(IOException e)
        {
            System.out.println("IO Error" + e.getMessage());
        }
        
       System.out.println("file Complete");
    }
    
}
