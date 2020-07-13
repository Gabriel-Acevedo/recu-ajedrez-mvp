package src.main.mvp.chess.views;

import src.main.mvp.chess.controllers.ResumeController;
import src.main.mvp.utils.YesNoDialog;

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
