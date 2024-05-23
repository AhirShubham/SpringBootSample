package com.shubham.springboot.journal.controllers;

import com.shubham.springboot.journal.models.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Component and @ResponseBody -serialize object to http response
@RequestMapping("journal")

public class JournalEntryController {

    private Map<Long, JournalEntry> journeyEntries = new HashMap<>();

    //@ResponseEntity helps us to customize http response using header, body and status code

    @GetMapping("all")
    public ResponseEntity<List<JournalEntry>> getAll(){

        List<JournalEntry> journalEntries= new ArrayList<>(journeyEntries.values());
        return new ResponseEntity<List<JournalEntry>>(journalEntries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getById(@PathVariable Long id){

        JournalEntry journalEntry= journeyEntries.get(id);
        if(journalEntry!=null){
            return new ResponseEntity<JournalEntry>(journalEntry, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("add")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry){
        journeyEntries.put(entry.getId(), entry);
        return new ResponseEntity<>(entry,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public Boolean updateEntry(@RequestBody JournalEntry entry,@PathVariable("id") Long id){
        journeyEntries.put(id, entry);
        return true;
    }

    @DeleteMapping("{id}")
    public Boolean deleteEntry(@RequestBody JournalEntry entry,@PathVariable("id") Long id){
        journeyEntries.remove(id, entry);
        return true;
    }

}
