package com.invest.investment.watchlist.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WatchlistDto implements Serializable {

    private Long userId;
    private Long produkId;
}
