/**
 *
 */
package com.me.notes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.me.notes.dao.NoteRepository;
import com.me.notes.domain.Note;

/**
 * @author sdecker
 *
 */
@RestController
@RequestMapping("/api/items")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Note add(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Note get(@PathVariable("id") long id) {
        return noteRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> get(@RequestParam(value = "query", required = false) String query) {
        if ((query != null) && (query.length() > 0)) {
            return noteRepository.findByBodyContaining(query);
        } else {
            return noteRepository.findAll();
        }
    }

}