package bex.training.museum;

import bex.training.art.Art;
import brightspot.core.tool.RichTextUtils;
import com.psddev.cms.view.PageEntryView;
import com.psddev.cms.view.ViewModel;
import com.psddev.cms.view.servlet.HttpParameter;
import com.psddev.dari.db.Query;
import com.psddev.styleguide.art.MuseumView;
import com.psddev.styleguide.art.MuseumViewDescriptionField;
import com.psddev.styleguide.art.MuseumViewWorksField;

import java.util.List;

public class MuseumPageViewModel extends ViewModel<Museum> implements MuseumView, PageEntryView {

    @HttpParameter
    private int offset;

    @Override
    public Iterable<? extends MuseumViewDescriptionField> getDescription() {
        return RichTextUtils.buildHtml(model.getState().getDatabase(), model.getDescription(), e -> createView(MuseumViewDescriptionField.class, e));
    }

    @Override
    public CharSequence getName() {
        return model.getName();
    }

    @Override
    public Iterable<? extends MuseumViewWorksField> getWorks() {
        List<Art> artWorks = Query.from(Art.class)
            .where("owner = ?", model)
            .sortAscending("name")
            .select(Math.max(0, offset), 10)
            .getItems();

        return createViews(MuseumViewWorksField.class, artWorks);
    }
}
