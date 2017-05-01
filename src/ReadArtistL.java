import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadArtistL {
    private Scanner fileArtist;

    public ReadArtistL(){
        try {
            fileArtist=new Scanner(new File("p1artists.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile(ArtistChainList list){
        fileArtist.useDelimiter("\t|\r\n");
        while (fileArtist.hasNext()){
            int id=fileArtist.nextInt();
            String name=fileArtist.next();

            list.addNode(id,name);
        }
    }

}
