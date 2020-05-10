package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class FileLoaderImpl implements FileLoader {
    
    private UserPlayer player;

    @Override
    public void saveData() {
        // TODO Auto-generated method stub

    }

    @Override
    public UserPlayer loadData(final File userFileName) {
       final ObjectMapper mapper = new ObjectMapper();
       
       
       try {
        this.player = mapper.readValue(userFileName, UserPlayerImpl.class);
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
