package view.controllers;

import model.score.Progress;

public interface FxHandleDataScene extends FxController {

    /**
     * Initialize the scene to show.
     * @param progress
     *             user's progress
     */
    void init(Progress progress);

}
