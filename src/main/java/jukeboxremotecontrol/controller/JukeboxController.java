package jukeboxremotecontrol.controller;

import jukeboxremotecontrol.model.Jukebox;
import jukeboxremotecontrol.service.JukeboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

/**
 * REST controller for managing jukebox-related operations.
 */
@RestController
@RequestMapping("/api/jukeboxes")
public class JukeboxController {

    private final JukeboxService jukeboxService;

    /**
     * Autowired constructor for injecting JukeboxService.
     *
     * @param jukeboxService The service for jukebox-related business logic.
     */
    @Autowired
    public JukeboxController(JukeboxService jukeboxService) {
        this.jukeboxService = jukeboxService;
    }

    /**
     * Endpoint to search jukeboxes by setting ID with optional filters for model, offset, and limit.
     *
     * @param settingId The setting ID to filter jukeboxes.
     * @param model     Optional filter to specify the model of the jukebox.
     * @param offset    Pagination offset.
     * @param limit     Pagination limit.
     * @return A filtered list of jukeboxes.
     * @throws IOException When an input or output exception occurred.
     */
    @GetMapping("/search")
    public ResponseEntity<?> getJukeboxesBySetting(
        @RequestParam String settingId,
        @RequestParam(required = false) String model,
        @RequestParam(required = false, defaultValue = "0") int offset,
        @RequestParam(required = false, defaultValue = "10") int limit
    ) throws IOException {
        List<Jukebox> filteredJukeboxes = jukeboxService.getJukeboxesBySetting(settingId, model, offset, limit);
        return ResponseEntity.ok(filteredJukeboxes);
    }
}
