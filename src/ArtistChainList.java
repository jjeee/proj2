import java.util.ArrayList;

public class ArtistChainList {
    static ArtistL tempNode, firstNode,replace;
    static int totalEntries;
    int nextID;

    public ArtistChainList(){
        tempNode=null;
        totalEntries=0;
        nextID=0;
    }

    public int getNextID() {return nextID;}

    public void setNextID(int nextID) {this.nextID = nextID;}

    public static boolean isEmpty(){ return  totalEntries==0;}

    public static void addNode(int id,String name){
        if (isEmpty()){
            ArtistL newNode=new ArtistL(id,name,null);
            firstNode=newNode;
            totalEntries++;
        }else {
            ArtistL newNode = new ArtistL(id,name,null);
            newNode.next=firstNode;
            firstNode=newNode;
            totalEntries++;
        }
    }

    public boolean delete(int id){
        boolean result=false;
        tempNode=getRef(id+1);

        if (tempNode !=null){
            replace=tempNode.next.next;
            tempNode.next=replace;

            totalEntries--;

            result=true;
        }return result;
    }

    private ArtistL getRef(int id){
        boolean found=false;
        ArtistL current=firstNode;

        while (!found && (current!=null)){
            if (id==current.getArtistID())
                found=true;
            else
                current=current.getNext();
        }
        return current;
    }

    public ArrayList<Artist> makeList(ArrayList<Artist> artLList){
        ArtistL current=firstNode;
        int i=0;
            while ((i<totalEntries)&&(current!=null)){
                artLList.add(new Artist(current.getArtistID(),current.getArtistName()));
                i++;
                current=current.getNext();
            }
        return artLList;
    }

    @Override
    public String toString() {
        return firstNode+" ";
    }
}
