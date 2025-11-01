package com.music.track.controller;

import com.music.track.dto.TrackRequest;
import com.music.track.model.Track;
import com.music.track.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("music/platform/v1/tracks")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Create a track
     *
     * @param trackRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<Track> createTrack(@RequestBody TrackRequest trackRequest) {
        Track track = trackService.createTrack(trackRequest);
        return ResponseEntity.status(201).body(track);
    }

    /**
     * Get all tracks
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> allTracks = trackService.getAllTracks();
        return ResponseEntity.ok(allTracks);
    }

    /**
     * Delete a track
     *
     * @param trackId
     * @return
     */
    @DeleteMapping("/{trackId}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long trackId) {
        trackService.deleteTrack(trackId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get Track sorted
     *
     * @return
     */
    @GetMapping("/sorted")
    public ResponseEntity<List<Track>> getTracksSorted() {
        List<Track> tracks = trackService.sortedTracks();
        return ResponseEntity.ok(tracks);
    }
}
