package jukeboxremotecontrol;

import jukeboxremotecontrol.model.Jukebox;
import jukeboxremotecontrol.model.Settings;
import jukeboxremotecontrol.service.JukeboxService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JukeboxServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private JukeboxService jukeboxService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getJukeboxesBySettingShouldFilterCorrectly() throws Exception {
        // Arrange
        String settingId = "some-setting-id";
        Jukebox.Component component = new Jukebox.Component("component-name");
        Jukebox jukebox = new Jukebox("jukebox-id", "model-name", Collections.singletonList(component));
        List<Jukebox> mockJukeboxes = Arrays.asList(jukebox);

        Settings.Setting setting = new Settings.Setting();
        setting.setId(settingId);
        setting.setRequires(Collections.singletonList("component-name"));
        Settings mockSettings = new Settings();
        mockSettings.setSettings(Collections.singletonList(setting));

        when(restTemplate.exchange(
        anyString(),
        any(HttpMethod.class),
        any(),
        eq(new ParameterizedTypeReference<List<Jukebox>>() {})
)).thenReturn(new ResponseEntity<>(mockJukeboxes, HttpStatus.OK));

when(restTemplate.exchange(
        anyString(),
        any(HttpMethod.class),
        any(),
        eq(new ParameterizedTypeReference<Settings>() {})
)).thenReturn(new ResponseEntity<>(mockSettings, HttpStatus.OK));


        // Act
        List<Jukebox> result = jukeboxService.getJukeboxesBySetting(settingId, null, 0, 10);

        // Assert
        assertEquals(1, result.size());
        assertEquals(jukebox.getId(), result.get(0).getId());
        assertEquals(jukebox.getModel(), result.get(0).getModel());
        assertEquals(component.getName(), result.get(0).getComponents().get(0).getName());
    }
}
