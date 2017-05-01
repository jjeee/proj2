import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Method2 {

    ReadArtistD artistDFile=new ReadArtistD();
    ArrayList<ArtistD> artistD = new ArrayList<>();
    Scanner fileChange;


    public Method2() throws IOException{
        java.io.PrintWriter output=new java.io.PrintWriter("p2artists2b.txt");

        long startTime=System.nanoTime();
        artistDFile.readFile(artistD);

        part2();
        long stopTime=System.nanoTime();
        long elapsedTime=stopTime-startTime;
        for (ArtistD artD:artistD)
            output.println(artD);


        output.println("\nStartTime = " + startTime + " StopTime = " + stopTime
                           + " ElapsedTime = " + elapsedTime);
        output.close();
    }

    public void delete(int id) {
        int i = 0;
        boolean found=false;
        while(found!=true) {
            if (id == (artistD.get(i)).getID()) {
                found = true;
                (artistD.get(i)).setDeleteByte(true);
            } else i++;
        }
    }

    public void add(int id,String name) {
        artistD.add(new ArtistD(id,name,false));
    }

    public void part2() throws IOException{

        fileChange=new Scanner(new File("p2changes.txt"));

        int i=artistD.size()+1;

        while (fileChange.hasNext()) {
            String sample=fileChange.nextLine();
            String[] sample2=sample.split("\t");
            String codeStr = sample2[0];

            if (codeStr.charAt(0) == 'D'||codeStr.charAt(0) == 'd') {
                int id = Integer.parseInt(sample2[1]);
                delete(id);
                pt2Del();
            } else if (codeStr.charAt(0) == 'A'||codeStr.charAt(0) == 'a') {
                String itemname=sample2[1];
                add(i,itemname);
                i++;
            }
        }fileChange.close();
    }

    public void pt2Del(){
        for (ArtistD ArtD:artistD){
            if (ArtD.isDeleteByte()==true){
                artistD.remove(ArtD);
                break;
            }
        }
    }
}
