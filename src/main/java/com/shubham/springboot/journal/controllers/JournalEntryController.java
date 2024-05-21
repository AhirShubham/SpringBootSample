package com.shubham.springboot.journal.controllers;

import com.shubham.springboot.journal.models.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Component and @ResponseBody -serialize object to http response
@RequestMapping("journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journeyEntries = new HashMap<>();

    @GetMapping("all")
    public List<JournalEntry> getAll(){

        return new ArrayList<>(journeyEntries.values());
    }

    @PostMapping("add")
    public Boolean createEntry(@RequestBody JournalEntry entry){
        journeyEntries.put(entry.getId(), entry);
        return true;
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
