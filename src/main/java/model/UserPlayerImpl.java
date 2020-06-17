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
     * Creates instance of {@link UserPlayer}.
     */
    public UserPlayerImpl() {
        // this is intentionally empty, nothing needed here.
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
         * Constructs a player builder with a specified name.
         * 
         * @param username the name of the player.
         * @return playerBuilder
         */
        public PlayerBuilder username(final String username) {
            this.username = username;
            return this;
        }

        /**
         * Constructs a player builder with a specified password.
         * 
         * @param password the password of the player.
         * @return playerBuilder
         */
        public PlayerBuilder password(final String password) {
            this.password = password;
            return this;
        }

        /**
         * Builds the UserPlayer.
         * 
         * @return userPlayer
         */
        public UserPlayer build() {
            return new UserPlayerImpl(this);
        }
    }

}

