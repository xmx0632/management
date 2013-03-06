package org.xmx0632.management.api.v1.bo;

import java.util.ArrayList;
import java.util.List;

public class SettlementRequest {

	private String transactionID;
	// 购物清单
	private List<ShoppingItem> shoppingList = new ArrayList<ShoppingItem>();

	@Override
	public String toString() {
		return "SettlementRequest [transactionID=" + transactionID
				+ ", shoppingList=" + shoppingList + "]";
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public List<ShoppingItem> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(List<ShoppingItem> shoppingList) {
		this.shoppingList = shoppingList;
	}

	public static class ShoppingItem {
		private String productId;
		private int quantity;

		@Override
		public String toString() {
			return "ShoppingItem [productId=" + productId + ", quantity="
					+ quantity + "]";
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

	}

}
