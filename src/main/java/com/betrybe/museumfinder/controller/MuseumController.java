package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/museums")
public class MuseumController {

  MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumDto museum) {
    Museum newMuseum = new Museum();
    newMuseum.setName(museum.name());
    newMuseum.setDescription(museum.description());
    newMuseum.setAddress(museum.address());
    newMuseum.setCollectionType(museum.collectionType());
    newMuseum.setSubject(museum.subject());
    newMuseum.setUrl(museum.url());
    newMuseum.setCoordinate(museum.coordinate());
    return ResponseEntity.status(HttpStatus.CREATED).body(museumService.createMuseum(newMuseum));
  }
}
