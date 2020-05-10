package model;

import model.score.Progress;
import model.score.ProgressImpl;

/**
 * The implementation of the {@link UserPlayer}.
 *
 */
public class UserPlayerImpl implements UserPlayer {

    private String username;
    private String password;
    private ProgressImpl progress;


    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Progress getProgress() {
        return this.progress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProgress(final ProgressImpl progress) {
        this.progress = progress;
    }

}
