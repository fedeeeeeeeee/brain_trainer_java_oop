package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.score.ProgressImpl;

/**
 * The implementation of the {@link LoginModel} interface.
 * 
 */
public class LoginModelImpl implements LoginModel {

    private static final String PATH = System.getProperty("user.home") + File.separator + ".brainTrainer";
    private final File brainTrainer = new File(PATH);
    private File userFile;

    private boolean checkIfUserExist(final String userFileName) {
        if (this.brainTrainer.listFiles() != null) {
            for (final File file : brainTrainer.listFiles()) {
                if (userFileName.equals(file.getName())) {
                    this.userFile = file;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkPassword(final String password) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            if (mapper.readValue(userFile, UserPlayerImpl.class).getPassword().equals(password)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void initializeDirectory() {
        if (!brainTrainer.exists()) {
            try {
                brainTrainer.mkdir();
            } catch (SecurityException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean loginUser(final UserPlayer player) {
        final String userFileName = player.getUsername() + ".txt";
        return this.checkIfUserExist(userFileName) && this.checkPassword(player.getPassword());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean registerUser(final UserPlayer player) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        this.initializeDirectory();
        final String userFileName = player.getUsername() + ".txt";

        if (!this.checkIfUserExist(userFileName)) {
            this.userFile = new File(PATH + File.separator + userFileName);
            player.setProgress(new ProgressImpl());
            try {
                mapper.writeValue(userFile, player);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getUserFile() {
        return this.userFile;
    }

}
