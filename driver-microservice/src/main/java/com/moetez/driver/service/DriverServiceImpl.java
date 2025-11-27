package com.moetez.driver.service;


import com.moetez.driver.dto.APIResponseDto;
import com.moetez.driver.dto.ChampionnatDto;
import com.moetez.driver.dto.DriverDto;
import com.moetez.driver.entities.Driver;
import com.moetez.driver.repos.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;
    private APIDriver apiClient;

    @Override
    public APIResponseDto getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).get();
        ChampionnatDto championnatDto = apiClient.getChampionnatByNom(driver.getChampId());

        String dname;
        if (championnatDto == null)
            dname="NOT AVAILABLE";
        else
            dname = championnatDto.getNom();

        DriverDto driverDto = new DriverDto(
                driver.getId(),
                driver.getFullName(),
                driver.getEquipe(),
                driver.getAge(),
                driver.getChampId(),
                dname
        );
        
        return new APIResponseDto(driverDto, championnatDto);
    }
}
