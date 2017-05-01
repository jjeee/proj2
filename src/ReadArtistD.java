import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadArtistD {
    private Scanner fileArtist;

    public ReadArtistD(){
        try {
            fileArtist=new Scanner(new File("p1artists.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArtistD> readFile(ArrayList<ArtistD> list){

        fileArtist.useDelimiter("\t|\r\n");
        while (fileArtist.hasNext()) {
            int ID=fileArtist.nextInt();
            String name=fileArtist.next();

            list.add(new ArtistD(ID,name,false));
        }
        closeFile();
        return list;
    }
    public void closeFile(){
        fileArtist.close();
    }
}
