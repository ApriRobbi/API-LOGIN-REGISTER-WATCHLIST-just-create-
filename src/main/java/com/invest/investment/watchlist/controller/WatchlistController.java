package com.invest.investment.watchlist.controller;

import com.invest.investment.watchlist.dto.WatchlistDto;
import com.invest.investment.watchlist.entity.WatchlistEntity;
import com.invest.investment.watchlist.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/watchlist")
    public WatchlistEntity create(@RequestBody WatchlistDto watchlistDto){
        return watchlistService.create(watchlistDto.getProdukId(), watchlistDto.getUserId());
    }
}
