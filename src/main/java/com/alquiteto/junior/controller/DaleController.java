package com.alquiteto.junior.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Books", description = "Endpoints for book operations")
@RestController
@RequestMapping("/books")
@Validated
public class DaleController {

    @Operation(summary = "Get book info", description = "Get book info by id", tags = {"Books"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Book with given id does not exist.", content = @Content)
    })
    public ResponseEntity<String> dale() {
        return ResponseEntity.ok("piza, cuida, dale");
    }
}
