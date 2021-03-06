package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BlizzardChargeHitImage;
import attackImage.BlizzardChargeUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.AdvancedChargeSkill;
import skill.BlizzardChargeSkill;
import skill.CombatOrdersSkill;
import skill.ElementalForceSkill;

public class BlizzardChargeAttack extends PlayerAttack {

	private int canMoreHit = 0; 
	
	public BlizzardChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
		getAdvancedChargeEffect();
	}
	
	private void getAdvancedChargeEffect() {
		AdvancedChargeSkill advancedChargeSkill = (AdvancedChargeSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("어드밴스드차지");
		if(advancedChargeSkill != null && advancedChargeSkill.getPoint() >= 1) {
			canMoreHit = advancedChargeSkill.getEffect(advancedChargeSkill.getPoint());
		}
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new BlizzardChargeUseImage(hunt, attacker, opponent, makeAttackInfor()),
				new BlizzardChargeHitImage(hunt, opponent, opponent, null), true);
		makeFrostBiteBuff();
		afterAttack();
	}
	
	private void makeFrostBiteBuff() {
		double frostRate = ((BlizzardChargeSkill)activeSkill).frostBiteRate(activeSkill.getPoint());
		int frostLast = ((BlizzardChargeSkill)activeSkill).getLast(activeSkill.getPoint());
		int frost100Rate = (int)(Math.random() *  99) + 1;
		if(frost100Rate <= frostRate) {
			double burnDamageRate = ((BlizzardChargeSkill)activeSkill).frostBiteEffect(activeSkill.getPoint()) / 100.0;
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("동상", frostLast, attacker.getCharacter().calNormalDamge(burnDamageRate)));
		}
	}
	
	private double elementalForceEffect() {
		double extraRate = 0.0;
		ElementalForceSkill elementalForceSkill = (ElementalForceSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("엘리멘탈포스");
		if(elementalForceSkill != null && elementalForceSkill.getPoint() >= 1) {
			extraRate = elementalForceSkill.getEffect(elementalForceSkill.getPoint()) / 100.0;
		}
		return extraRate;
	}

	private double combatOrdersEffect() {
		double extraRate = 0.0;
		CombatOrdersSkill combatOrdersSkill = (CombatOrdersSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("컴뱃오더스");
		if(combatOrdersSkill != null && combatOrdersSkill.getPoint() >= 1) {
			extraRate = combatOrdersSkill.getExtraChargeEffect(combatOrdersSkill.getPoint()) / 100.0;
		}
		return extraRate;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		rate += combatOrdersEffect();
		rate += elementalForceEffect();
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		if(opponent.getCharacter().isAlreadyBuffed("화상")) {
			double extraDamageRate = (double)((BlizzardChargeSkill)activeSkill).extraEffect(activeSkill.getPoint()) / 100.0;
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(extraDamageRate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		for(int i = 0; i < canMoreHit; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
