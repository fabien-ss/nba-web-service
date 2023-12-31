package com.nba.tpwebservice.controller;

import com.nba.tpwebservice.service.MatchService;
import com.nba.tpwebservice.specific.ActionForm;
import com.nba.tpwebservice.specific.ApiResponse;
import com.nba.tpwebservice.specific.MatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/match")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatchController {
    @Autowired
    MatchService matchService;
    @PostMapping
    public ApiResponse InsertNewMatch(@RequestBody MatchForm matchForm){
        return this.matchService.InsertionMatch(matchForm);
    }
}
