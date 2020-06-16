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

    public UserPlayerImpl() {
    }

    private UserPlayerImpl(final PlayerBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

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

    /**
     * Builder for User.
     * 
     */
    public static class PlayerBuilder {
        private String username;
        private String password;

        /**
         * Set the username of the user.
         * 
         * @param username the username of the user.
         * @return {@link PlayerBuilder}
         */
        public PlayerBuilder username(final String username) {
            this.username = username;
            return this;
        }

        /**
         * Set the password for the user.
         * 
         * @param password the password for the user
         * @return {@link PlayerBuilder}
         */
        public PlayerBuilder password(final String password) {
            this.password = password;
            return this;
        }

        /**
         * build the {@link UserPlayer}.
         * @return
         *      {@link UserPlayer}
         */
        public UserPlayer build() {
            return new UserPlayerImpl(this);
        }
    }

}
