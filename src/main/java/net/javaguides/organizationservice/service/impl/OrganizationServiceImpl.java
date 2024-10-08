package net.javaguides.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.mapper.OrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl  implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // Convert OrganizationDto into Organization JPA entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization=organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
