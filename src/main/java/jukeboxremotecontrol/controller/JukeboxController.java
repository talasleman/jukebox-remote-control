package jukeboxremotecontrol.controller;

import jukeboxremotecontrol.model.Jukebox;
import jukeboxremotecontrol.service.JukeboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/jukeboxes")
public class JukeboxController {

    private final JukeboxService jukeboxService;

    @Autowired
    public JukeboxController(JukeboxService jukeboxService) {
        this.jukeboxService = jukeboxService;
    }

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
