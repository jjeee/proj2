public class ArtistD extends Artist {
    private boolean deleteByte;
    private int ID;
    private String name;

    public ArtistD(int ID, String name, boolean ifDelete){
        super(ID,name);
        deleteByte=ifDelete;
    }

    public boolean isDeleteByte() {
        return deleteByte;
    }

    public void setDeleteByte(boolean deleteByte) {
        this.deleteByte = deleteByte;
    }

    @Override
    public String toString() {
        return getArtistID() +"\t" + getArtistName() +"\t"+ deleteByte;
    }

    public int getID() {return getArtistID();}
}