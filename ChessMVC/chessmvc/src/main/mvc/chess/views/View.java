package src.main.mvc.chess.views;

import src.main.mvc.chess.controllers.Controller;
import src.main.mvc.chess.controllers.ControllersVisitor;
import src.main.mvc.chess.controllers.PlayController;
import src.main.mvc.chess.controllers.ResumeController;
import src.main.mvc.chess.controllers.StartController;

public class View implements ControllersVisitor {

    private StartView startView;
    
    private PlayView playView;
    
    private ResumeView resumeView;

    public View() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    public void interact(Controller controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        assert startController != null;
        this.startView.interact(startController);
    }
    
	@Override
	public void visit(PlayController playController) {
		assert playController != null;
        this.playView.interact(playController);
		
	}

	@Override
	public void visit(ResumeController resumeController) {
		assert resumeController != null;
        this.resumeView.interact(resumeController);
		
	}
}
