package view.controllers;

import model.score.Progress;

public interface FxHandleDataScene extends FxController{

    /**
     * Initialize the scene to show.
     */
    void init(Progress progress);

}
