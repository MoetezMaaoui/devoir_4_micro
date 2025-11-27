package com.moetez.driver.service;


import com.moetez.driver.dto.ChampionnatDto;
import org.springframework.stereotype.Component;
@Component
public class DeptFallback implements APIDriver {
    @Override
    public ChampionnatDto getChampionnatByNom(String departmentCode) {
        return null;
    }
}