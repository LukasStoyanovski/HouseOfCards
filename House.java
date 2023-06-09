
public class House {
	private boolean available;
	private int currentValue;
	public final static int MAX_VALUE = 31;

	public House() {
		available = true;
		currentValue = 0;

	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public boolean isAvailable() {
		return available && currentValue < MAX_VALUE;
	}

	public boolean getAvailable() {
		return available;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void placeCard(Card card) throws HouseNotAvailableException {
		if (!isAvailable()) {
			throw new HouseNotAvailableException("The house is not available for placing cards.");
		}

		int value = card.getCardValue();
		currentValue += value;
	}

	public void calculateHouse(Player player) {
		if (currentValue == MAX_VALUE) {
			player.addPoints(100);
			currentValue = 0;
		} else if (currentValue > MAX_VALUE) {
			available = false;
		}
	}

	@Override
	public String toString() {
		return "House [available=" + available + ", currentValue=" + currentValue + "]";
	}
}