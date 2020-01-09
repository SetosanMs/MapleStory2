package character;

import skill.SkillFactory;

public class AdventurerFactory {
	public static Adventurer makeAdventurer(String name, String adventurerType) {
		switch (adventurerType) {
		case "남자초보모험가":
			return new Adventurer(name, "newbieMan",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 4, 0, 0, 0, 0, 0, 0, 0),
					new Status(4, 4, 4, 4), "초보자");
		case "여자초보모험가":
			return new Adventurer(name, "newbieWoman",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 4, 0, 0, 0, 0, 0, 0, 0),
					new Status(4, 4, 4, 4), "초보자");
		}
		return null;
	}
	
	public static void upgradeAdventurer(String careerName, Adventurer adventurer) {
		switch(careerName) {
		case "검사":
			adventurer.addSkill(SkillFactory.makeSkill("HP증가"));
			adventurer.addSkill(SkillFactory.makeSkill("파워스트라이크"));
			adventurer.addSkill(SkillFactory.makeSkill("아이언바디"));
			break;
		case "파이터":
			adventurer.addSkill(SkillFactory.makeSkill("검마스터리"));
			adventurer.addSkill(SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(SkillFactory.makeSkill("브랜디쉬"));
			adventurer.addSkill(SkillFactory.makeSkill("분노"));
			adventurer.addSkill(SkillFactory.makeSkill("콤보어택"));
			break;
		case "크루세이더":
			adventurer.addSkill(SkillFactory.makeSkill("브레이브슬래시"));
			adventurer.addSkill(SkillFactory.makeSkill("패닉"));
			adventurer.addSkill(SkillFactory.makeSkill("샤우트"));
			adventurer.addSkill(SkillFactory.makeSkill("콤보시너지"));
			adventurer.addSkill(SkillFactory.makeSkill("인듀어"));
			break;
		case "페이지":
			adventurer.addSkill(SkillFactory.makeSkill("둔기마스터리"));
			adventurer.addSkill(SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(SkillFactory.makeSkill("플레임차지"));
			adventurer.addSkill(SkillFactory.makeSkill("블리자드차지"));
			adventurer.addSkill(SkillFactory.makeSkill("엘리멘탈차지"));
			break;
		case "나이트":
			adventurer.addSkill(SkillFactory.makeSkill("아킬레스"));
			adventurer.addSkill(SkillFactory.makeSkill("리스토네이션"));
			adventurer.addSkill(SkillFactory.makeSkill("라이트닝차지"));
			adventurer.addSkill(SkillFactory.makeSkill("컴뱃오더스"));
			adventurer.addSkill(SkillFactory.makeSkill("위협"));
			break;
		case "다크나이트":
			adventurer.addSkill(SkillFactory.makeSkill("창마스터리"));
			adventurer.addSkill(SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(SkillFactory.makeSkill("아이언윌"));
			adventurer.addSkill(SkillFactory.makeSkill("하이퍼바디"));
			adventurer.addSkill(SkillFactory.makeSkill("피어싱쓰루"));
			break;
		case "버서커":
			adventurer.addSkill(SkillFactory.makeSkill("로드오브다크니스"));
			adventurer.addSkill(SkillFactory.makeSkill("비홀더스버프"));
			adventurer.addSkill(SkillFactory.makeSkill("라만차스피어"));
			adventurer.addSkill(SkillFactory.makeSkill("비홀더쇼크"));
			adventurer.addSkill(SkillFactory.makeSkill("크로스오버체인"));
			break;
		}
	}
	
}
