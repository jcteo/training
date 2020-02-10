package bex.training;

import com.psddev.dari.db.Modification;
import com.psddev.dari.db.Recordable;

import java.util.ArrayList;
import java.util.List;

@Recordable.FieldInternalNamePrefix("mediaTaggable")
public class MediaTaggableData extends Modification<MediaTaggable> {
    @Indexed
    private List<MediaTag> media;

    @Indexed
    public List<MediaTag> getMedia(){
        if(media == null){
            media = new ArrayList<>();
        }
        return media;
    }

    public void setMedia(List<MediaTag> media){
        this.media = media;

    }

}
