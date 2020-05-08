package model;

import model.score.Progress;

/**
 * Represent a Player in the software domain.
 * 
 */
public interface UserPlayer extends User {

    /**
     * The user's progress.
     * 
     * @return
     *          progress
     */
    Progress getProgress();

}
