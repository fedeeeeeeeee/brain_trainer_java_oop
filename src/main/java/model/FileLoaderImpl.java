package model;

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
    public UserPlayer loadData(final String userFileName) {
       final ObjectMapper mapper = new ObjectMapper();
       
       try {
        this.player = mapper.readValue(userFileName, UserPlayerImpl.class);
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
       
        return this.player;
    }

}
