package bex.training.art;

import bex.training.MediaTaggable;
import bex.training.artist.Artist;
import bex.training.museum.Museum;
import com.psddev.cms.db.Content;
import com.psddev.dari.util.StorageItem;

public class Art extends Content implements MediaTaggable {

    @Indexed
    private String name;

    private StorageItem image;

    private String description;


    @Indexed
    private Artist artist;

    @Indexed
    private Museum owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StorageItem getImage() {
        return image;
    }

    public void setImage(StorageItem image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Museum getOwner() {
        return owner;
    }

    public void setOwner(Museum owner) {
        this.owner = owner;
    }
}
