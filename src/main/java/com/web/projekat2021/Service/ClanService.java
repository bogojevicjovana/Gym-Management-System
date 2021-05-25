package com.web.projekat2021.Service;

import com.web.projekat2021.Model.Clan;
import org.springframework.stereotype.Service;

@Service
public interface ClanService {

    Clan create(Clan clan) throws Exception;

}
