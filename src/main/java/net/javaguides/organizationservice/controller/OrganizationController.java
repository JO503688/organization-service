package net.javaguides.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "OrganizationController Exposes REST APIs Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

@Operation(
        summary ="Save Organization REST API",
        description = "Save Organization REST API is used to Organization object in the Databse"
)
@ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
)
    // Build Save organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> savedOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return  new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @Operation(
            summary ="Get Organization REST API",
            description = "Get Organization REST API is used to get a simple Organization object from the Databse"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    //Build GetOrganizationByCode REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode){

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);

    }
}
