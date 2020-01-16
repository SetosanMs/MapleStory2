package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.Hunt;
import playerAttack.PlayerAttack;

public abstract class ActiveSkill extends Skill {

	private static final long serialVersionUID = 1L;
	
	protected AttackType attackType;
	protected Property property;
	protected int coolTime;
	
	protected int curCoolTime;

	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor);
		this.attackType = attackType;
		this.property = property;
	}
	
	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor);
		this.attackType = attackType;
		this.property = property;
		this.coolTime = coolTime;
	}
	
	public int getCoolTime() {
		return coolTime;
	}

	public void setCoolTime(int coolTime) {
		this.coolTime = coolTime;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public Property getProperty() {
		return property;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "ActiveSkill [attackType=" + attackType + ", property=" + property + "]";
	}
	
	public void resetCoolTime() {
		curCoolTime = coolTime;
	}
	
	public void subCoolTime() {
		if(curCoolTime >= 1) {
			curCoolTime--;
		}
	}

	public boolean isCanUseSkill() {
		return (curCoolTime == 0);
	}
	
	public abstract int getNeedMp(int point);
	public abstract int getLast(int point);
	public abstract PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent);
	
}
