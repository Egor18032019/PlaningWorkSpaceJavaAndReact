package com.work.space.controller.place;

import com.work.space.entity.Employment;
import com.work.space.service.employment.EmploymentService;
import com.work.space.to.AuthorizedUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/place")
public class PlaceRestController {
    static final Logger log = LoggerFactory.getLogger(PlaceRestController.class);
    @Autowired
    private final EmploymentService employmentService;

    public PlaceRestController(EmploymentService employmentService) {
        this.employmentService = employmentService;
    }

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<?> saveNewPlace(@RequestBody Employment employment,
                                          @AuthenticationPrincipal AuthorizedUser user) {
        String role = "ADMIN";
        System.out.println(employmentService.get(employment.getId()).isPresent());
        if (user.getRole().equals(role)) {
            try {
                if (employmentService.get(employment.getId()).isPresent()) {
                    final Employment result = employmentService.save(employment);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("")
    public ResponseEntity<?> getPlace(@RequestParam(value = "employment_id") Integer employment_id) {
        if (employment_id > 0) {
            if (employmentService.getPlace(employment_id).isPresent()) {
                final Employment result = employmentService.getPlace(employment_id).get();
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getfloor")
    public ResponseEntity<?> getAllPlaceFromThisFloor(@RequestParam(value = "floor") Integer floor ) {
        if (floor > 0) {
            final List<Employment> result= employmentService.getAllPlaceFromThisFloor(floor);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("")
    public ResponseEntity<?> deleteById(@RequestParam(value = "employment_id")  Integer employment_id) {
        if (employment_id > 0) {
            if (employmentService.getPlace(employment_id).isPresent()) {
                employmentService.delete(employment_id);
                log.warn("Deleting a employment " + employment_id + ".");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                log.info("attempt to Delete a employment " + employment_id + " .");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}