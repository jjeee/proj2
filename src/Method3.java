import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Method3 {
    ArtistChainList list=new ArtistChainList();
    ReadArtistL readArtistL=new ReadArtistL();
    ArrayList<Artist> artList=new ArrayList<>();
    Scanner fileChange;

    public Method3() throws IOException{
        java.io.PrintWriter output=new java.io.PrintWriter(new File("p2artists2c.txt"));
        long startTime=System.nanoTime();

        readArtistL.readFile(list);
        changes();
        long stopTime=System.nanoTime();
        long elapsedTime=stopTime-startTime;

        list.makeList(artList);
        Collections.reverse(artList);
        for (Artist art:artList){
            output.println(art);
        }
        output.println("\nStartTime = " + startTime + " StopTime = " + stopTime
                + " ElapsedTime = " + elapsedTime);

        output.close();
    }

    public void changes() throws IOException{
        fileChange=new Scanner(new File("p2changes.txt"));
        int i=list.totalEntries+1;

        while (fileChange.hasNext()){
            String sample=fileChange.nextLine();
            String[] sample2=sample.split("\t");
            String codeStr = sample2[0];

            if (codeStr.charAt(0) == 'D'||codeStr.charAt(0) == 'd') {
                int id = Integer.parseInt(sample2[1]);
                list.delete(id);
            } else if (codeStr.charAt(0) == 'A'||codeStr.charAt(0) == 'a') {
                String itemname=sample2[1];
                list.addNode(i,itemname);
                i++;
            }
        }fileChange.close();

    }

}
