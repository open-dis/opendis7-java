package edu.nps.moves.dis7.test;

import java.io.Serializable;
import java.util.BitSet;

import edu.nps.moves.dis7.enumerations.AntennaSelection;
import edu.nps.moves.dis7.enumerations.Mode5LevelSelection;
import edu.nps.moves.dis7.enumerations.Mode5LocationErrors;
import edu.nps.moves.dis7.enumerations.Mode5PlatformType;
import edu.nps.moves.dis7.enumerations.Mode5Reply;

/**
 * IFFMode5StatusRecord for IFFPduLayer3TransponderFormatData included in IFFPdu.
 */
public class IFFMode5StatusRecord  implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final int MODE_5_REPLY_BIT_1_INDEX = 0;
	private static final int MODE_5_REPLY_BIT_2_INDEX = 1;
	private static final int MODE_5_REPLY_BIT_3_INDEX = 2;
	private static final int MODE_5_REPLY_BIT_4_INDEX = 3;
	private static final int LINE_TEST_BIT_INDEX = 4;
	
	private static final int ANTENNA_SELECTION_BIT_1_INDEX = 5;
	private static final int ANTENNA_SELECTION_BIT_2_INDEX = 6;
	private static final int CRYPTO_CONTROL_BIT_INDEX = 7;
	private static final int LAT_LONG_ALTITUDE_SOURCE_BIT_INDEX = 8;
	private static final int LOCATION_ERRORS_BIT_INDEX = 9;
	
	private static final int PLATFORM_TYPE_BIT_INDEX = 10;
	private static final int MODE_5_LEVEL_SELECTION_BIT_INDEX = 11;
	private static final int PADDING_BIT_INDEX = 12;
	private static final int ON_OFF_STATUS_BIT_INDEX = 13;
	private static final int DAMAGE_STATUS_BIT_INDEX = 14;
	private static final int MALFUNCTION_BIT_INDEX = 15;
	
	private final BitSet bitSet = new BitSet(16);
	
	private IFFMode5StatusRecord(Builder builder) {
		bitSet.set(MODE_5_REPLY_BIT_1_INDEX, builder.mode5ReplyBit1);
		bitSet.set(MODE_5_REPLY_BIT_2_INDEX, builder.mode5ReplyBit2);
		bitSet.set(MODE_5_REPLY_BIT_3_INDEX, builder.mode5ReplyBit3);
		bitSet.set(MODE_5_REPLY_BIT_4_INDEX, builder.mode5ReplyBit4);
		bitSet.set(LINE_TEST_BIT_INDEX, builder.lineTestBit);
		
		bitSet.set(ANTENNA_SELECTION_BIT_1_INDEX, builder.antennaSelectionBit1);
		bitSet.set(ANTENNA_SELECTION_BIT_2_INDEX, builder.antennaSelectionBit2);
		bitSet.set(CRYPTO_CONTROL_BIT_INDEX, builder.cryptoControlBit);
		bitSet.set(LAT_LONG_ALTITUDE_SOURCE_BIT_INDEX, builder.latLongAltitudeSourceBit);
		bitSet.set(LOCATION_ERRORS_BIT_INDEX, builder.locationErrorsBit);
		
		bitSet.set(PLATFORM_TYPE_BIT_INDEX, builder.platformTypeBit);
		bitSet.set(MODE_5_LEVEL_SELECTION_BIT_INDEX, builder.mode5LevelSelectionBit);
		bitSet.set(PADDING_BIT_INDEX, builder.paddingBit);
		bitSet.set(ON_OFF_STATUS_BIT_INDEX, builder.onOffStatusBit);
		bitSet.set(DAMAGE_STATUS_BIT_INDEX, builder.damageStatusBit);
		bitSet.set(MALFUNCTION_BIT_INDEX, builder.malfunctionBit);
	}
	
	private IFFMode5StatusRecord(short mode5status) {		
		for (int i = 0; i < 16; i++) {
			bitSet.set(i, (mode5status >> i & 1) != 0);
		}
	}
	
	/**
	 * 
	 * @return IFFMode5StatusRecord as short
	 */
	public short getAsShort() {
		long value = 0;
		
		for (long bit : bitSet.toLongArray()) {
			value += bit;
		}
		return (short) value;
	}
	
	/**
	 * 
	 * @return true to indicate Malfunction, false to indicate No Malfunction.
	 */
	public boolean getMalfunctionBit() {
		return bitSet.get(DAMAGE_STATUS_BIT_INDEX);
	}
	
	/**
	 * 
	 * @return true to indicate Damaged, false to indicate No Damage.
	 */
	public boolean getDamageStatusBit() {
		return bitSet.get(DAMAGE_STATUS_BIT_INDEX);
	}
	
	/**
	 * @return true to indicate Mode 5 transponder is On, false to indicate Mode 5 transponder is Off.
	 */
	public boolean getOnOffStatusBit() {
		return bitSet.get(ON_OFF_STATUS_BIT_INDEX);
	}
	
	/**
	 * 
	 * @return Mode5LevelSelection UID 412
	 */
	public Mode5LevelSelection getMode5LevelSelection() {
		if (bitSet.get(MODE_5_LEVEL_SELECTION_BIT_INDEX)) {
			return Mode5LevelSelection.MODE_5_LEVEL_2;
		}
		return Mode5LevelSelection.MODE_5_LEVEL_1;
	}
	
	/**
	 * 
	 * @return Mode5PlatformType UID 396
	 */
	public Mode5PlatformType getMode5PlatformType() {
		if (bitSet.get(PLATFORM_TYPE_BIT_INDEX)) {
			return Mode5PlatformType.AIR_VEHICLE;
		}
		return Mode5PlatformType.GROUND_VEHICLE;
	}
	
	/**
	 * 
	 * @return Mode5LocationErrors UID 423
	 */
	public Mode5LocationErrors getMode5LocationErrors() {
		if (bitSet.get(LOCATION_ERRORS_BIT_INDEX)) {
			return Mode5LocationErrors.IFF_DATA_RECORD_PRESENT;
		}
		return Mode5LocationErrors.NO_LOCATION_ERRORS;
	}
	
	/**
	 * @return true to indicate Mode 5 Transponder Location IFF Data Record Present, false to indicate Compute Locally.
	 */
	public boolean getlatLongAltitudeSourceBit() {
		return bitSet.get(LAT_LONG_ALTITUDE_SOURCE_BIT_INDEX);
	}
	
	/**
	 * @return true to indicate Crypto Control IFF Data Record Present, false to indicate Crypto Control IFF data record Not Present.
	 */
	public boolean getCryptoControlBit() {
		return bitSet.get(CRYPTO_CONTROL_BIT_INDEX);
	}
	
	/**
	 * Determine AntennaSelection from bitmasks
	 * @return AntennaSelection UID 351
	 */
	public AntennaSelection getAntennaSelection() {
		boolean bit1 = bitSet.get(ANTENNA_SELECTION_BIT_1_INDEX);
		boolean bit2 = bitSet.get(ANTENNA_SELECTION_BIT_2_INDEX);
		
		if (!bit1 && !bit2) {
			return AntennaSelection.NO_STATEMENT;
		}
		else if (bit1 && !bit2) {
			return AntennaSelection.TOP;
		}
		else if (!bit1 && bit2) {
			return AntennaSelection.BOTTOM;
		}
		else {
			// bit1 and bit2 both true
			return AntennaSelection.DIVERSITY;
		}
	}
	
	/**
	 * @return true to indicate Enabled, false to indicate Not Enabled.
	 */
	public boolean getLineTestBit() {
		return bitSet.get(LINE_TEST_BIT_INDEX);
	}
	
	/**
	 * 
	 * @return Mode5Reply UID 350, default Mode5Reply.NO_RESPONSE. 
	 */
	public Mode5Reply getMode5Reply() {
		Mode5Reply mode5Reply = Mode5Reply.NO_RESPONSE;
		
		boolean bit1 = bitSet.get(MODE_5_REPLY_BIT_1_INDEX);
		boolean bit2 = bitSet.get(MODE_5_REPLY_BIT_2_INDEX);
		boolean bit3 = bitSet.get(MODE_5_REPLY_BIT_3_INDEX);
		boolean bit4 = bitSet.get(MODE_5_REPLY_BIT_4_INDEX);
		
		if (!bit1 && !bit2 && !bit3 && !bit4) {
			mode5Reply = Mode5Reply.NO_RESPONSE;
		}
		else if (bit1 && !bit2 && !bit3 && !bit4) {
			mode5Reply = Mode5Reply.VALID;
		}
		else if (!bit1 && bit2 && !bit3 && !bit4) {
			mode5Reply = Mode5Reply.INVALID;
		}
		else if (bit1 && bit2 && !bit3 && !bit4) {
			mode5Reply = Mode5Reply.UNABLE_TO_VERIFY;
		}
		
		return mode5Reply;
	
	}
	/** nested subclass */
	public static class Builder {
		
		private static final int MODE_5_STATUS_NOT_PRESENT = -1;
		
		private boolean mode5ReplyBit1;
		private boolean mode5ReplyBit2;
		private boolean mode5ReplyBit3;
		private boolean mode5ReplyBit4;
		private boolean lineTestBit;
		
		private boolean antennaSelectionBit1;
		private boolean antennaSelectionBit2;
		private boolean cryptoControlBit;
		private boolean latLongAltitudeSourceBit;
		private boolean locationErrorsBit;
		
		private boolean platformTypeBit;
		private boolean mode5LevelSelectionBit;
		// Unused
		private boolean paddingBit;
		private boolean onOffStatusBit;
		private boolean damageStatusBit;
		private boolean malfunctionBit;
		
		private short mode5Status = MODE_5_STATUS_NOT_PRESENT;
		
		public Builder() {
			
		}
		
		public Builder(short mode5Status) {
                    this();
                    this.mode5Status = mode5Status;
		}
		
		/**
		 * Default value is Mode5Reply.NO_RESPONSE.
		 * @param reply Mode5Reply UID 350
                 * @return this object for chainable invocations
		 */
		public Builder setMode5Reply(Mode5Reply reply) {
			switch (reply) {
				case NO_RESPONSE:
					setMode5ReplyBitValues(false, false, false, false);
					break;
				case VALID:
					setMode5ReplyBitValues(true, false, false, false);
					break;
				case INVALID:
					setMode5ReplyBitValues(false, true, false, false);
					break;
				case UNABLE_TO_VERIFY:
					setMode5ReplyBitValues(true, true, false, false);
					break;
			}
			return this;
		}
		
		private void setMode5ReplyBitValues(boolean bit1, boolean bit2, boolean bit3, boolean bit4) {
			this.mode5ReplyBit1 = bit1;
			this.mode5ReplyBit2 = bit2;
			this.mode5ReplyBit3 = bit3;
			this.mode5ReplyBit4 = bit4;
		}
		
		/**
		 * Set false to indicate Not Enabled, true to indicate Enabled. Default value is false.
		 * @param lineTestBit
                 * @return this object for chainable invocations
		 */
		public Builder setLineTestBit(boolean lineTestBit) {
			this.lineTestBit = lineTestBit;
			return this;
		}
		
		/**
		 * Default value is AntennaSelection.NO_STATEMENT.
		 * @param antennaSelection UID 351
                 * @return this object for chainable invocations
		 */
		public Builder setAntennaSelection(AntennaSelection antennaSelection) {
			switch (antennaSelection) {
				case NO_STATEMENT:
					setAntennaSelectionBitValues(false, false);
					break;
				case TOP:
					setAntennaSelectionBitValues(true, false);
					break;
				case BOTTOM:
					setAntennaSelectionBitValues(false, true);
					break;
				case DIVERSITY:
					setAntennaSelectionBitValues(true, true);
					break;
			}
			return this;
		}
		
		private void setAntennaSelectionBitValues(boolean bit1, boolean bit2) {
			this.antennaSelectionBit1 = bit1;
			this.antennaSelectionBit2 = bit2;
		}
		
		/**
		 * Set false to indicate Crypto Control IFF data record Not Present, true to indicate Crypto Control IFF Data Record Present. Default value is false.
		 * @param cryptoControlBit
                 * @return this object for chainable invocations
		 */
		public Builder setCryptoControlBit(boolean cryptoControlBit) {
			this.cryptoControlBit = cryptoControlBit;
			return this;
		}

		/**
		 * Set false to indicate Compute Locally, true to indicate Mode 5 Transponder Location IFF Data Record Present. Default value is false.
		 * @param latLongAltitudeSourceBit
                 * @return this object for chainable invocations
		 */
		public Builder setLatLongAltitudeSourceBit(boolean latLongAltitudeSourceBit) {
			this.latLongAltitudeSourceBit = latLongAltitudeSourceBit;
			return this;
		}

		/**
		 * Default value is Mode5LocationErrors.NO_LOCATION_ERRORS.
		 * @param locationErrors UID 423
                 * @return this object for chainable invocations
		 */
		public Builder setLocationErrors(Mode5LocationErrors locationErrors) {
			switch (locationErrors) {
				case NO_LOCATION_ERRORS:
					this.locationErrorsBit = false;
					break;
				case IFF_DATA_RECORD_PRESENT:
					this.locationErrorsBit = true;
					break;
			}
			return this;
		}
		
		/**
		 * Default value is Mode5PlatformType.GROUND_VEHICLE.
		 * @param platformType UID 396
                 * @return this object for chainable invocations
		 */
		public Builder setPlatformType(Mode5PlatformType platformType) {
			switch (platformType) {
				case GROUND_VEHICLE:
					this.platformTypeBit = false;
					break;
				case AIR_VEHICLE:
					this.platformTypeBit = true;
					break;
			}
			return this;
		}
		
		/**
		 * Default value is Mode5LevelSelection.MODE_5_LEVEL_1.
		 * @param levelSelection UID 412
                 * @return this object for chainable invocations
		 */
		public Builder setMode5LevelSelection(Mode5LevelSelection levelSelection) {
			switch (levelSelection) {
				case MODE_5_LEVEL_1: 
					this.mode5LevelSelectionBit = false;
					break;
				case MODE_5_LEVEL_2:
					this.mode5LevelSelectionBit = true;
					break;
			}
			return this;
		}
		
		/**
		 * Set false to indicate Mode 5 transponder is Off, true to indicate Mode 5 transponder is On. Default value is false.
		 * @param onOffStatusBit
                 * @return this object for chainable invocations
		 */
		public Builder setOnOffStatusBit(boolean onOffStatusBit) {
			this.onOffStatusBit = onOffStatusBit;
			return this;
		}
		
		/**
		 * Set false to indicate No Damage, true to indicate Damaged. Default value is false.
		 * @param damageStatusBit
                 * @return this object for chainable invocations
		 */
		public Builder setDamageStatusBit(boolean damageStatusBit) {
			this.damageStatusBit = damageStatusBit;
			return this;
		}

		/**
		 * Set false to indicate No Malfunction, true to indicate Malfunction. Default value is false.
		 * @param malfunctionBit
                 * @return this object for chainable invocations
		 */
		public Builder setMalfunctionBit(boolean malfunctionBit) {
			this.malfunctionBit = malfunctionBit;
			return this;
		}
		
		public IFFMode5StatusRecord build() {
			if (this.mode5Status != MODE_5_STATUS_NOT_PRESENT) {
				return new IFFMode5StatusRecord(this.mode5Status);
			}
			return new IFFMode5StatusRecord(this);
		}
	}
}
