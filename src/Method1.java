import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Method1 {
    ArrayList<Artist> artistList=new ArrayList<>();


    public Method1() throws IOException{
        java.io.PrintWriter output=new java.io.PrintWriter("p2artists2a.txt");
        long startTime=System.nanoTime();

        Scanner fileList=new Scanner(new File("p1artists.txt"));
        Scanner fileChange=new Scanner(new File("p2changes.txt"));

        fileList.useDelimiter("\t|\r\n");
        while (fileList.hasNext()) {
            int ID=fileList.nextInt();
            String name=fileList.next();

            artistList.add(new Artist(ID,name));
        }/*for (Artist artist:artistList) {
            System.out.println(artist);
        }System.out.println();*/
        int count=artistList.size()+1;
        while (fileChange.hasNext()){
            String sample=fileChange.nextLine();
            String[] sample2=sample.split("\t");
            char addDel=sample2[0].charAt(0);

            switch (addDel){
                case 'a':case 'A':
                    String name=sample2[1];
                    add(count,name);
                    count++;
                    break;
                case 'd':case 'D':
                    int index=Integer.parseInt(sample2[1]);
                    delete(index);
                    break;
            }
        }

        long stopTime=System.nanoTime();
        long elapsedTime=stopTime-startTime;

        for (Artist artist:artistList)
            output.println(artist);

        output.println("\nStartTime = " + startTime + " StopTime = " + stopTime
                + " ElapsedTime = " + elapsedTime);
        output.close();
    }

    public void add(int count,String name){
        artistList.add(new Artist(count,name));
    }

    public void delete(int index){
        for (Artist artist:artistList){
            if (artist.getArtistID()==index) {
                artistList.remove(artistList.indexOf(artist));
                break;
            }
        }
    }
}
