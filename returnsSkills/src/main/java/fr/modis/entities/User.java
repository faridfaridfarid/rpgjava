package fr.modis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private Double buyPrice;
	@Column
	private Double volume;
	@Column
	private Double btcDollars;
	@Column
	private Double sellPrice;
	@Column
	private Double totalBuy;
	@Column
	private Double totalSell;
	@Column
	private Date dateBuy;
	@Column
	private Date dateSell;
	
	public User() {
		super();
	}

	public User(Double buyPrice, Double volume, Double btcDollars, Double sellPrice, Double totalBuy,
			Double totalSell, Date dateBuy, Date dateSell) {
		super();
		this.buyPrice = buyPrice;
		this.volume = volume;
		this.btcDollars = btcDollars;
		this.sellPrice = sellPrice;
		this.totalBuy = totalBuy;
		this.totalSell = totalSell;
		this.dateBuy = dateBuy;
		this.dateSell = dateSell;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getBtcDollars() {
		return btcDollars;
	}

	public void setBtcDollars(Double btcDollars) {
		this.btcDollars = btcDollars;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getTotalBuy() {
		return totalBuy;
	}

	public void setTotalBuy(Double totalBuy) {
		this.totalBuy = totalBuy;
	}

	public Double getTotalSell() { 
		return totalSell;
	}

	public void setTotalSell(Double totalSell) {
		this.totalSell = totalSell;
	}

	public Date getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(Date dateBuy) {
		this.dateBuy = dateBuy;
	}

	public Date getDateSell() {
		return dateSell;
	}

	public void setDateSell(Date dateSell) {
		this.dateSell = dateSell;
	}

	
	
	
}
