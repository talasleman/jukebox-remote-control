package jukeboxremotecontrol;

import jukeboxremotecontrol.service.JukeboxService;
import jukeboxremotecontrol.controller.JukeboxController;
import jukeboxremotecontrol.model.Jukebox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class JukeboxControllerTest {

    @Mock
    private JukeboxService jukeboxService;

    @InjectMocks
    private JukeboxController jukeboxController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void getJukeboxesBySettingReturnsCorrectResponse() throws Exception {
        // Arrange
        String settingId = "some-setting-id";
        List<Jukebox> mockJukeboxes = Arrays.asList(/* ...populate with test data... */);
        when(jukeboxService.getJukeboxesBySetting(settingId, null, 0, 10))
                .thenReturn(mockJukeboxes);

        // Act
        ResponseEntity<?> responseEntity = jukeboxController.getJukeboxesBySetting(settingId, null, 0, 10);

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(mockJukeboxes, responseEntity.getBody());
    }
}
