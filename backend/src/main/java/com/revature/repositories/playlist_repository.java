package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Playlist;
import com.revature.models.Track;

public interface playlist_repository extends JpaRepository<Playlist,Long>{
List <Track> getByplaylistId(long playlist_id);
List<Playlist> findByTitleContaining(String title);
}
