

package com.example.songr.repository;

        import com.example.songr.domain.Song;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository <Song,Long>{

}
