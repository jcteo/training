package bex.training.artist;

import brightspot.core.tool.DirectoryItemUtils;
import com.psddev.cms.db.Site;
import com.psddev.cms.view.PageEntryView;
import com.psddev.cms.view.ViewModel;
import com.psddev.cms.view.servlet.CurrentSite;
import com.psddev.styleguide.art.ArtistPromoView;

public class ArtistPromoViewModel extends ViewModel<Artist> implements ArtistPromoView, PageEntryView {

    @CurrentSite
    private Site site;
    @Override
    public CharSequence getName() {
        return model.getPreferredName();
    }

    @Override
    public CharSequence getNationality() {
        return model.getNationality();
    }

    @Override
    public CharSequence getUrl() {
        return DirectoryItemUtils.getCanonicalUrl(site, model);
    }
}
