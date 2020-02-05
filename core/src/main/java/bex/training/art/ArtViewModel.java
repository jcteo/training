package bex.training.art;

import brightspot.core.tool.RichTextUtils;
import com.psddev.cms.image.ImageSize;
import com.psddev.cms.view.PageEntryView;
import com.psddev.cms.view.ViewModel;
import com.psddev.styleguide.art.ArtView;
import com.psddev.styleguide.art.ArtViewArtistField;

import java.util.Map;

public class ArtViewModel extends ViewModel<Art> implements ArtView, PageEntryView {
    @Override
    public Iterable<? extends ArtViewArtistField> getArtist() {
        return createViews(ArtViewArtistField.class, model.getArtist());
    }

    @Override
    public CharSequence getDescription() {
        return RichTextUtils.buildInlineHtml(model.getState().getDatabase(), model.getDescription(), this::createView);
    }

    @Override
    public Map<String, ?> getImage() {
        return ImageSize.getAttributes(model.getImage());
    }

    @Override
    public CharSequence getName() {
        return model.getName();
    }
}
