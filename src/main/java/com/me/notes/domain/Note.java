/**
 *
 */
package com.me.notes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author sdecker
 *
 */
@Entity
@Table(name = "note")
public class Note {

    @Id
    @SequenceGenerator(name = "note_generator", sequenceName = "note_sequence", initialValue = 5)
    @GeneratedValue(generator = "note_generator")
    private long id;

    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}