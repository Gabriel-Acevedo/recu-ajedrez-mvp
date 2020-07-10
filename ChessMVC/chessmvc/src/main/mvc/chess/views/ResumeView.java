package src.main.mvc.chess.views;

import src.main.mvc.chess.controllers.ResumeController;
import src.main.mvc.utils.YesNoDialog;

public class ResumeView extends SubView{

    private YesNoDialog yesNoDialog;

    public ResumeView() {
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(Message.PLAY_AGAIN.getMessage())) {
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }
	
}
