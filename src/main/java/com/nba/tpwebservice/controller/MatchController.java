package com.nba.tpwebservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/equipe")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatchController {
}