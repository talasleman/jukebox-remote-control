package jukeboxremotecontrol.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jukeboxremotecontrol.model.Jukebox;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class JukeboxService {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Jukebox> findAllJukeboxes() throws IOException {
    InputStream inputStream = getClass().getResourceAsStream("/db.json");
    if (inputStream == null) {
        throw new FileNotFoundException("File 'db.json' not found in classpath");
    }
    // Read the root JSON node
    JsonNode rootNode = mapper.readTree(inputStream);
    // Get the "jukes" array node from the root node
    JsonNode jukesNode = rootNode.path("jukes");
    // Convert the "jukes" node to a list of Jukebox objects
    return mapper.convertValue(jukesNode, new TypeReference<List<Jukebox>>() {});
    }

    

}
