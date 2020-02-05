package bex.training.team;

import com.psddev.cms.view.ViewModel;
import com.psddev.styleguide.training.team.TeamView;

public class TeamViewModel extends ViewModel<Team> implements TeamView{
    @Override
    public CharSequence getName() {
        return model.getName();
    }
}

