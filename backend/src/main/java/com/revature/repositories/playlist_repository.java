package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Playlist_OBSOLETE;
import com.revature.models.Track;

public interface playlist_repository extends JpaRepository<Playlist_OBSOLETE,Long>{
List <Track> getByplaylistId(long playlist_id);
List<Playlist_OBSOLETE> findByTitleContaining(String title);
}
