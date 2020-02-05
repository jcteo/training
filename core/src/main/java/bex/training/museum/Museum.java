package bex.training.museum;

import bex.training.art.Art;
import bex.training.artist.Artist;
import com.psddev.cms.db.Content;
import com.psddev.cms.db.ToolUi;
import com.psddev.dari.db.Query;
import com.psddev.dari.db.Recordable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@ToolUi.Main
public class Museum extends Content {
    @Recordable.Indexed
    private String name;

    @ToolUi.RichText
    private String description;

    @Recordable.Indexed
    @ToolUi.Hidden
    public Set<Artist> getArtistsOnDisplay(){
        return Query.from(Art.class)
                .where("owner = ?", this)
                .groupBy("artist")
                .stream()
                .map(g -> (Artist) g.getKeys().get(0))
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
