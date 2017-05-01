public class ArtistL extends  Artist{
    public ArtistL next;
    public ArtistL(int id, String name, ArtistL next) {
        super(id, name);
    }

    public ArtistL getNext() {return next;}

    public void setNext(ArtistL next) {this.next = next;}

    @Override
    public String toString() {
        return getArtistID()+" "+getArtistName();
    }
}
