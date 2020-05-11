package controller;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.UserPlayer;
import model.UserPlayerImpl;

public final class FileLoaderImpl implements FileLoader {

    private UserPlayer player;
    private File userFileName;

    @Override
    public void saveData() {
        final ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(this.userFileName, player);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public UserPlayer loadData(final File userFileName) {
       final ObjectMapper mapper = new ObjectMapper();
       this.userFileName = userFileName;

       try {
        this.player = mapper.readValue(this.userFileName, UserPlayerImpl.class);
    } catch (JsonParseException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
       
        return this.player;
    }

}
