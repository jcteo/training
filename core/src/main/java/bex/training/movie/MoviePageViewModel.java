package bex.training.movie;

import bex.training.character.Character;
import brightspot.core.page.AbstractContentPageViewModel;
import brightspot.core.section.Section;
import brightspot.core.tool.RichTextUtils;
import com.psddev.cms.view.PageEntryView;
import com.psddev.dari.db.Database;
import com.psddev.dari.util.ObjectUtils;
import com.psddev.dari.util.StringUtils;
import com.psddev.styleguide.core.list.ListView;
import com.psddev.styleguide.core.list.ListViewItemsField;
import com.psddev.styleguide.training.movie.MoviePageView;
import com.psddev.styleguide.training.movie.MoviePageViewCoverField;
import com.psddev.styleguide.training.movie.MoviePageViewFeaturedCharactersField;
import com.psddev.styleguide.training.movie.MoviePageViewPlotField;
import com.psddev.styleguide.training.movie.MoviePageViewSummaryField;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Optional;

public class MoviePageViewModel extends AbstractContentPageViewModel<Movie> implements MoviePageView, PageEntryView {

    private static final SimpleDateFormat RELEASE_DATE_FORMAT = new SimpleDateFormat("MMMM dd, yyyy");

    // Movie Page Support.

    @Override
    public Iterable<? extends MoviePageViewCoverField> getCover() {
        return createViews(MoviePageViewCoverField.class, model.getCover());
    }

    @Override
    public Iterable<? extends MoviePageViewFeaturedCharactersField> getFeaturedCharacters() {
        if (!ObjectUtils.isBlank(model.getFeaturedCharacters())) {

            ListView.Builder builder = new ListView.Builder();
            builder.title("Featured Characters");

            for (Character character : model.getFeaturedCharacters()) {
                builder.addToItems(createView(ListViewItemsField.class, character));
            }

            return Collections.singletonList(builder.build());
        }

        return null;
    }

    @Override
    public CharSequence getName() {
        return model.getName();
    }

    @Override
    public CharSequence getPhase() {
        return Optional.ofNullable(model.getPhase())
                .map(Section::getDisplayName)
                .orElse(null);
    }

    @Override
    public Iterable<? extends MoviePageViewPlotField> getPlot() {
        if (!StringUtils.isBlank(model.getPlot())) {
            return RichTextUtils.buildHtml(Database.Static.getDefault(), model.getPlot(),
                    s -> createView(MoviePageViewPlotField.class, s));
        }

        return null;
    }

    @Override
    public CharSequence getReleaseDate() {
        return RELEASE_DATE_FORMAT.format(model.getReleaseDate());
    }

    @Override
    public Iterable<? extends MoviePageViewSummaryField> getSummary() {
        if (!StringUtils.isBlank(model.getSummary())) {
            return RichTextUtils.buildHtml(Database.Static.getDefault(), model.getSummary(),
                    s -> createView(MoviePageViewSummaryField.class, s));
        }

        return null;
    }

    // Page Support.

    @Override
    public CharSequence getPageSubHeading() {
        return null;
    }
}
