package application;

import java.time.LocalDate;

public class MonsterAttack {
	public String monsterName;
	public String attackLocation;
	public double damagesInMillionUSD;
	public LocalDate date;
	
	public String getMonsterName() {
		return monsterName;
	}
	public String getAttackLocation() {
		return attackLocation;
	}
	public double getDamagesInMillionUSD() {
		return damagesInMillionUSD;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	public void setAttackLocation(String attackLocation) {
		this.attackLocation = attackLocation;
	}
	public void setDamagesInMillionUSD(double damagesInMillionUSD) {
		this.damagesInMillionUSD = damagesInMillionUSD;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String toString() {
		return String.format("%1$-15s%2$-10.2f%3$-15s%4$-15s\n", monsterName, damagesInMillionUSD, attackLocation, date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear());
	}
}
