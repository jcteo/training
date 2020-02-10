package bex.training.artist;

import bex.training.MediaTaggable;
import com.psddev.cms.db.Content;
import com.psddev.cms.db.ToolUi;
import com.psddev.dari.db.Recordable;
import org.apache.commons.lang.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToolUi.Main
public class Artist extends Content implements MediaTaggable {
    @Recordable.Indexed
    private String preferredName;
    private String firstName;

    private String lastName;

    @Recordable.Indexed
    private String nationality;

    @Recordable.Indexed
    public String getPreferredName(){
        if(!StringUtils.isBlank(preferredName)){
            return preferredName;
        }

        return Stream.of(getFirstName(), getLastName())
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining(" "));
    }

    @Override
    public String getLabel(){
        return "Artist" + getPreferredName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
