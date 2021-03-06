package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import attack.Attack;
import attack.AttackInfor;
import attackImage.EvilEyeBuffUseImage;
import attackImage.SkillImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import item.EquipmentItem;
import lastingImage.DivineShieldLastingImage;
import playerAttack.BlizzardChargeAttack;
import playerAttack.FlameChargeAttack;
import playerAttack.LightningChargeAttack;
import playerAttack.PlayerAttack;
import skill.BlizzardChargeSkill;
import skill.CombatOrdersSkill;
import skill.DivineShieldSkill;
import skill.ElementalChargeSkill;
import skill.FlameChargeSkill;
import skill.LightningChargeSkill;
import skill.ShieldMasterySkill;
import utils.CalUtils;
import utils.ColorUtils;
import utils.FontUtils;
import utils.MusicUtils;

public class PageHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;
	private static final int LINE_THINKNESS = 2;
	
	@Override
	public void drawObject(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(skill != null && skill.getPoint() >= 1) {
			g.setColor(ColorUtils.BLACK_80);
			g.fillRect(280, 20, 200, 40);
			g.setColor(ColorUtils.SEA);
			g.fillRect(280, 20, 200, LINE_THINKNESS);
			g.fillRect(280, 60 - LINE_THINKNESS, 200, LINE_THINKNESS);
			g.fillRect(280, 20, LINE_THINKNESS, 40);
			g.fillRect(480 - LINE_THINKNESS, 20, LINE_THINKNESS, 40);
			g.setFont(FontUtils.SMALL_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("엘리멘탈 차지 : ", 300, 44);
			g.setColor(Color.WHITE);
			g.drawString(skill.getChargeNum()+"", 400, 44);
		}
	}

	@Override
	public void endHunt(Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(skill != null && skill.getPoint() >= 1) {
			skill.setChargeNum(0);
		}
		CombatOrdersSkill combatOrdersSkill = (CombatOrdersSkill)adventurer.getSkillWithName("컴뱃오더스");
		if(!adventurer.isAlreadyBuffed("컴뱃오더스") && combatOrdersSkill != null && combatOrdersSkill.getPoint() >= 1) {
 			combatOrdersSkill.updateToOriginalSkillPoint(adventurer);
 		}
		adventurer.calState();
	}

	@Override
	public void startHunt(Hunt hunt) {
		
	}

	@Override
	public void startTurn(Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(skill != null && skill.getPoint() >= 1 && skill.getChargeNum() >= 1) {
			double hpRate = (double)skill.recoveryEffect(skill.getPoint()) / 100.0;
			adventurer.healHp((int)(hpRate * (double)adventurer.getMaxHp()) * skill.getChargeNum());
		}
		
 		CombatOrdersSkill combatOrdersSkill = (CombatOrdersSkill)adventurer.getSkillWithName("컴뱃오더스");
 		if(!adventurer.isAlreadyBuffed("컴뱃오더스") && combatOrdersSkill != null && combatOrdersSkill.getPoint() >= 1) {
 			combatOrdersSkill.updateToOriginalSkillPoint(adventurer);
 		}
 		
 		if(adventurer.isAlreadyBuffed("블레싱아머") && hunt.getSkillImage(adventurer.getSkillWithName("블레싱아머")) == null) {
 			hunt.addSkillImage(new DivineShieldLastingImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), null));
 		}
 		
		adventurer.calState();
	}

	@Override
	public void startAttack(Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		Attack attack = hunt.getPlayerAttack();
		ElementalChargeSkill elementalCharge = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(adventurer.getUsedSkill() == null ||elementalCharge == null || 
				elementalCharge.getPoint() == 0 || elementalCharge.isHaveMaxChargeNum()) return;
		
		if(adventurer.getUsedSkill() instanceof FlameChargeSkill && (attack instanceof BlizzardChargeAttack || attack instanceof LightningChargeAttack)) {
			elementalCharge.addChargeNum();
		}
		else if(adventurer.getUsedSkill() instanceof BlizzardChargeSkill && (attack instanceof FlameChargeAttack || attack instanceof LightningChargeAttack)) {
			elementalCharge.addChargeNum();
		}
		else if(adventurer.getUsedSkill() instanceof LightningChargeSkill && (attack instanceof FlameChargeAttack || attack instanceof BlizzardChargeAttack)) {
			elementalCharge.addChargeNum();
		}
	}

	@Override
	public void afterAttack(Hunt hunt) {
		
	}

	@Override
	public int hit(Adventurer adventurer, AttackInfor attackInfor) {
		ShieldMasterySkill shieldMasterySkill = (ShieldMasterySkill)adventurer.getSkillWithName("실드마스터리");
		EquipmentItem shieldItem = (EquipmentItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_SHIELD);
		if(shieldMasterySkill != null && shieldMasterySkill.getPoint() >= 1 && shieldItem != null) {
			int point = shieldMasterySkill.getPoint();
			if(CalUtils.calPercent(shieldMasterySkill.guardRate(point))) {
				attackInfor.setPhysicalDamage(attackInfor.getPhysicalDamage() / 2);
				attackInfor.setMagicDamage(attackInfor.getMagicDamage() / 2);
				MusicUtils.startEffectSound("defence");
			}
		}
		DivineShieldSkill divineShieldSkill = (DivineShieldSkill)adventurer.getSkillWithName("블레싱아머");
		if(divineShieldSkill != null && divineShieldSkill.getPoint() >= 1) {
			int point = divineShieldSkill.getPoint();
			if(CalUtils.calPercent(divineShieldSkill.guardRate(point))) {
				divineShieldSkill.subDivineShieldCoolTime();
				if(divineShieldSkill.getDivineShieldCoolTime() == 0) {
					adventurer.addBuff((BuffFactory.makeSpecialBuff("블레싱아머", divineShieldSkill.getLast(point))));
					divineShieldSkill.resetDivineShieldCoolTime();
				}
			}
		}
		return attackInfor.getTotalDamage();
	}
	
}
