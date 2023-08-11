package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  MuseumFakeDatabase database;

  /**
   * MuseumService constructor.
   */
  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    this.validateCoordinate(museum.getCoordinate());
    return this.database.saveMuseum(museum);
  }

  private void validateCoordinate(Coordinate coordinate) {
    Boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException("Invalid coordinate");
    }
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
