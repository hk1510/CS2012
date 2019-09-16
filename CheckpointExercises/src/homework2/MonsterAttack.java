package homework2;

import java.util.Date;

public class MonsterAttack {
	public String monsterName;
	public String attackLocation;
	public double damagesInMillionUSD;
	public Date date;
	
	public String getMonsterName() {
		return monsterName;
	}
	public String getAttackLocation() {
		return attackLocation;
	}
	public double getDamagesInMillionUSD() {
		return damagesInMillionUSD;
	}
	public Date getDate() {
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
	public void setDate(Date date) {
		this.date = date;
	}
	public String toString() {
		return "Monster: " + monsterName + " \nDamages: $" + damagesInMillionUSD + " million \nAttack Location: " + attackLocation + " \nDate:  " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear();
	}
}
