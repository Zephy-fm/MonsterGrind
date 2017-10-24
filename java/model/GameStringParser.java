package model;

/**
 * GameStringParser will take any Strings
 * 	that are going to be printed to the console 
 * 	and check the Strings for any Char sequences 
 *	that actually stand for game data.
 * 
 * @author frankminyon
 * 
 * @version 10/24/17
 */
public class GameStringParser {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private Player thePlayer;
	
	/**
	 * Instantiates the GameStringParser with
	 * 	a player so that the parser have reference.
	 *  
	 * @param thePlayer	Player to gather data from
	 * 
	 * @precondition 	Player != null
	 * 
	 * @postcondition 	ready to parse
	 */
	public GameStringParser(Player thePlayer) {
		if (thePlayer == null) {
			throw new IllegalArgumentException("thePlayer cannot be null");
		}
		this.thePlayer = thePlayer;
	}
	
	/**
	 * Parses the String provided and returns it.
	 * 	Check the class comments for a parsing symbol guide.
	 * 
	 * @param message	message to check for game data placeholders
	 * 
	 * @precondition 	message != null
	 * 
	 * @return 			String parsed of data placeholders
	 */
	public String parse(String message) {
		boolean loopChecker = message.contains("$$");
		String editedMessage = message;
		while (loopChecker) {
			editedMessage = parsePlayer(editedMessage);
			editedMessage = this.checkForBadDataPlaceholders(editedMessage);
			loopChecker = editedMessage.contains("$$");
		}
		return editedMessage;
	}

	private String parsePlayer(String editedMessage) {
		editedMessage = this.pName(editedMessage);
		editedMessage = this.pLvl(editedMessage);
		editedMessage = this.pHp(editedMessage);
		editedMessage = this.pMp(editedMessage);
		editedMessage = this.pStr(editedMessage);
		editedMessage = this.pDex(editedMessage);
		editedMessage = this.pInt(editedMessage);
		editedMessage = this.pDef(editedMessage);
		editedMessage = this.pLuck(editedMessage);
		editedMessage = this.pAttp(editedMessage);
		editedMessage = this.pMgkp(editedMessage);
		editedMessage = this.pCrit(editedMessage);
		editedMessage = this.pExp(editedMessage);
		editedMessage = this.pExplvl(editedMessage);
		editedMessage = this.pWepid(editedMessage);
		editedMessage = this.pWep(editedMessage);
		editedMessage = this.pArmid(editedMessage);
		editedMessage = this.pArm(editedMessage);
		editedMessage = this.pAcc1id(editedMessage);
		editedMessage = this.pAcc1(editedMessage);
		editedMessage = this.pAcc2id(editedMessage);
		editedMessage = this.pAcc2(editedMessage);
		return editedMessage;
	}

	private String pName(String newMessage) {
		if (newMessage.contains("$$pname")) {
			newMessage = newMessage.replaceAll("\\$\\$pname", this.thePlayer.getName());
		}
		return newMessage;
	}

	private String pLvl(String newMessage) {
		if (newMessage.contains("$$plvl")) {
			newMessage = newMessage.replaceAll("\\$\\$plvl", "" + this.thePlayer.getLevel());
		}
		return newMessage;
	}

	private String pHp(String newMessage) {
		if (newMessage.contains("$$php")) {
			newMessage = newMessage.replaceAll("\\$\\$php", "" + this.thePlayer.getMaxHp());
		}
		return newMessage;
	}

	private String pMp(String newMessage) {
		if (newMessage.contains("$$pmp")) {
			newMessage = newMessage.replaceAll("\\$\\$pmp", "" + this.thePlayer.getMaxMp());
		}
		return newMessage;
	}

	private String pStr(String newMessage) {
		if (newMessage.contains("$$pstr")) {
			newMessage = newMessage.replaceAll("\\$\\$pstr", "" + this.thePlayer.getStrength());
		}
		return newMessage;
	}

	private String pDex(String newMessage) {
		if (newMessage.contains("$$pdex")) {
			newMessage = newMessage.replaceAll("\\$\\$pdex", "" + this.thePlayer.getDexterity());
		}
		return newMessage;
	}

	private String pInt(String newMessage) {
		if (newMessage.contains("$$pint")) {
			newMessage = newMessage.replaceAll("\\$\\$pint", "" + this.thePlayer.getIntellect());
		}
		return newMessage;
	}

	private String pDef(String newMessage) {
		if (newMessage.contains("$$pdef")) {
			newMessage = newMessage.replaceAll("\\$\\$pdef", "" + this.thePlayer.getDefense());
		}
		return newMessage;
	}

	private String pLuck(String newMessage) {
		if (newMessage.contains("$$pluck")) {
			newMessage = newMessage.replaceAll("\\$\\$pluck", "" + this.thePlayer.getLuck());
		}
		return newMessage;
	}

	private String pAttp(String newMessage) {
		if (newMessage.contains("$$pattp")) {
			newMessage = newMessage.replaceAll("\\$\\$pattp", "" + this.thePlayer.getAttackPower());
		}
		return newMessage;
	}

	private String pMgkp(String newMessage) {
		if (newMessage.contains("$$pmgkp")) {
			newMessage = newMessage.replaceAll("\\$\\$pmgkp", "" + this.thePlayer.getMagicPower());
		}
		return newMessage;
	}

	private String pCrit(String newMessage) {
		if (newMessage.contains("$$pcrit")) {
			newMessage = newMessage.replaceAll("\\$\\$pcrit", "" + this.thePlayer.getCriticalChance());
		}
		return newMessage;
	}

	private String pExp(String newMessage) {
		if (newMessage.contains("$$pexp")) {
			newMessage = newMessage.replaceAll("\\$\\$pexp", "" + this.thePlayer.getExperience());
		}
		return newMessage;
	}

	private String pExplvl(String newMessage) {
		if (newMessage.contains("$$pexplvl")) {
			newMessage = newMessage.replaceAll("\\$\\$pexplvl", "" + this.thePlayer.getExperienceToLevelUp());
		}
		return newMessage;
	}

	private String pWepid(String newMessage) {
		if (newMessage.contains("$$pwepid")) {
			newMessage = newMessage.replaceAll("\\$\\$pepnid", "" + this.thePlayer.getWeaponID());
		}
		return newMessage;
	}

	private String pWep(String newMessage) {
		if (newMessage.contains("$$pwep")) {
			newMessage = newMessage.replaceAll("\\$\\$pwep", "" + this.thePlayer.getEquipmentManager().getWeapon().getName());
		}
		return newMessage;
	}

	private String pArmid(String newMessage) {
		if (newMessage.contains("$$parmid")) {
			newMessage = newMessage.replaceAll("\\$\\$parmid", "" + this.thePlayer.getArmorID());
		}
		return newMessage;
	}

	private String pArm(String newMessage) {
		if (newMessage.contains("$$parm")) {
			newMessage = newMessage.replaceAll("\\$\\$parm", "" + this.thePlayer.getEquipmentManager().getArmor().getName());
		}
		return newMessage;
	}

	private String pAcc1id(String newMessage) {
		if (newMessage.contains("$$pacc1id")) {
			newMessage = newMessage.replaceAll("\\$\\$pacc1id", "" + this.thePlayer.getAccessory1ID());
		}
		return newMessage;
	}

	private String pAcc1(String newMessage) {
		if (newMessage.contains("$$pacc1")) {
			newMessage = newMessage.replaceAll("\\$\\$pacc1", "" + this.thePlayer.getEquipmentManager().getAccessory1().getName());
		}
		return newMessage;
	}

	private String pAcc2id(String newMessage) {
		if (newMessage.contains("$$pacc2id")) {
			newMessage = newMessage.replaceAll("\\$\\$pacc2id", "" + this.thePlayer.getAccessory2ID());
		}
		return newMessage;
	}

	private String pAcc2(String newMessage) {
		if (newMessage.contains("$$pacc2")) {
			newMessage = newMessage.replaceAll("\\$\\$pacc2", "" + this.thePlayer.getEquipmentManager().getAccessory2().getName());
		}
		return newMessage;
	}
	
	private String checkForBadDataPlaceholders(String newMessage) {
		if (newMessage.contains("$$")) {
			int startIndex = newMessage.indexOf("$$");
			int endIndex = newMessage.indexOf(" ", startIndex);
			endIndex = checkEndIndex(newMessage, endIndex);
			String subStr = newMessage.substring(startIndex, endIndex);
			return newMessage.replace(subStr, "bad_args");
		}
		return newMessage;
	}

	private int checkEndIndex(String newMessage, int endIndex) {
		if (endIndex < 0) {
			endIndex = newMessage.length();
		}
		return endIndex;
	}

}
