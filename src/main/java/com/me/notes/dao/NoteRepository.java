package com.me.notes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.notes.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByBodyContaining(String query);
}
