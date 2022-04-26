package org.virajshah.practicum.finalproject;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface NoteRepository extends CrudRepository<Note, String> {
}