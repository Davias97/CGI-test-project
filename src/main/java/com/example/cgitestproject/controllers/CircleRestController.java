package com.example.cgitestproject.controllers;

import com.example.cgitestproject.dtos.CircleRequestDTO;
import com.example.cgitestproject.dtos.CircleResponseDTO;
import com.example.cgitestproject.models.Circle;
import com.example.cgitestproject.models.Point;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleRestController {

    @PostMapping("/circle/isInside")
    public CircleResponseDTO isInsideCircle(@RequestBody CircleRequestDTO circleRequestDTO) throws BadRequestException {

        if (circleRequestDTO == null) {
            throw new BadRequestException("Invalid input: Input cannot be null.");
        }

        if (circleRequestDTO.getRadius() <= 0 || circleRequestDTO.getPointX() < 0 || circleRequestDTO.getPointY() < 0 ||
                circleRequestDTO.getCentreX() < 0 || circleRequestDTO.getCentreY() < 0) {
            throw new BadRequestException("Invalid input: Circle radius cannot be zero or negative and centreX, centreY, pointX, or pointY cannot be negative.");
        }

        Circle circle = new Circle(new Point(circleRequestDTO.getCentreX(), circleRequestDTO.getCentreY()), circleRequestDTO.getRadius());
        Point point = new Point(circleRequestDTO.getPointX(), circleRequestDTO.getPointY());

        CircleResponseDTO responseDTO = new CircleResponseDTO();
        responseDTO.setInsideCircle(circle.isInside(point));
        return responseDTO;
    }
}