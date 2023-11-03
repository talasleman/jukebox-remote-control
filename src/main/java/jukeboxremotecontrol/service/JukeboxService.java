package jukeboxremotecontrol.service;

import jukeboxremotecontrol.model.Jukebox;
import jukeboxremotecontrol.model.Jukebox.Component;
import jukeboxremotecontrol.model.Settings;
import jukeboxremotecontrol.model.Settings.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service class for business logic related to Jukeboxes.
 */
@Service
public class JukeboxService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String JUKEBOX_API_URL = "http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes";
    private static final String SETTINGS_API_URL = "http://my-json-server.typicode.com/touchtunes/tech-assignment/settings";

    /**
     * Fetches the list of all jukeboxes from the external API.
     * 
     * @return A list of Jukeboxes.
     */
    public List<Jukebox> fetchJukeboxes() {
        ResponseEntity<List<Jukebox>> response = restTemplate.exchange(
            JUKEBOX_API_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Jukebox>>() {}
        );
        return response.getBody();
    }
    
    /**
     * Fetches the settings configuration from the external API.
     * 
     * @return Settings configuration.
     */
    public Settings fetchSettings() {
        ResponseEntity<Settings> response = restTemplate.exchange(
            SETTINGS_API_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Settings>() {}
        );
        return response.getBody();
    }
    
    /**
     * Filters jukeboxes based on the provided setting ID and optional model filter.
     * Applies pagination based on offset and limit.
     * 
     * @param settingId The setting ID to filter jukeboxes.
     * @param model     Optional model filter for jukeboxes.
     * @param offset    Pagination offset.
     * @param limit     Pagination limit.
     * @return A list of filtered and paginated jukeboxes.
     * @throws IOException When an input or output exception occurred.
     */
    public List<Jukebox> getJukeboxesBySetting(String settingId, String model, int offset, int limit) throws IOException {
        List<Jukebox> allJukeboxes = fetchJukeboxes();
        Settings settings = fetchSettings();
        List<String> requiredComponents = settings.getSettings().stream()
                .filter(s -> s.getId().equals(settingId))
                .findFirst()
                .map(Setting::getRequires)
                .orElseThrow(() -> new IllegalArgumentException("Invalid setting ID"))
                .stream() 
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    
                Stream<Jukebox> filteredJukeboxesStream = allJukeboxes.stream()
                .filter(jukebox -> {
                    List<String> jukeboxComponentNames = jukebox.getComponents().stream()
                            .map(Component::getName)
                            .collect(Collectors.toList());
                    boolean containsAllComponents = jukeboxComponentNames.containsAll(requiredComponents);
                    return containsAllComponents;
                });
            


        if (model != null && !model.isEmpty()) {
            filteredJukeboxesStream = filteredJukeboxesStream.filter(jukebox -> model.equalsIgnoreCase(jukebox.getModel().trim()));
        }
    
        List<Jukebox> paginatedJukeboxes = filteredJukeboxesStream
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    
        return paginatedJukeboxes;
    }

}

