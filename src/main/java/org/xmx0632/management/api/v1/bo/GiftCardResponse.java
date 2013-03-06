package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class GiftCardResponse {

	private Result result;

	private List<GiftCard> giftCards = new ArrayList<GiftCard>();;

	@Override
	public String toString() {
		return "GiftCardResponse [result=" + result + ", giftCards="
				+ giftCards + "]";
	}

	public List<GiftCard> getGiftCards() {
		return giftCards;
	}

	public void setGiftCards(List<GiftCard> giftCards) {
		this.giftCards = giftCards;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class GiftCard {
		private String id;
		private String cardBalance;

		@Override
		public String toString() {
			return "giftCard [id=" + id + ", cardBalance=" + cardBalance + "]";
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCardBalance() {
			return cardBalance;
		}

		public void setCardBalance(String cardBalance) {
			this.cardBalance = cardBalance;
		}

	}

}
