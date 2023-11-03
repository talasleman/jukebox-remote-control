package jukeboxremotecontrol.controller;

import jukeboxremotecontrol.model.Jukebox;
import jukeboxremotecontrol.service.JukeboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Jukebox> findAllJukeboxes() throws IOException {
        return jukeboxService.findAllJukeboxes();
    }

    // add other endpoints here
}
