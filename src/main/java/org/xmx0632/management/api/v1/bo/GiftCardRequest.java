package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class GiftCardRequest {

	private List<CardReq> giftCards = new ArrayList<CardReq>();

	@Override
	public String toString() {
		return "GiftCardRequest [giftCards=" + giftCards + "]";
	}

	public List<CardReq> getGiftCards() {
		return giftCards;
	}

	public void setGiftCards(List<CardReq> giftCards) {
		this.giftCards = giftCards;
	}

	public static class CardReq {
		private String id;
		private String password;

		@Override
		public String toString() {
			return "CardReq [id=" + id + ", password=" + password + "]";
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

}
