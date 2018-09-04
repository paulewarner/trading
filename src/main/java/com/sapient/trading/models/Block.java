package com.sapient.trading.models;

public class Block {
	
	private String blockId;
	private String symbol;
	private String side;		// In database its '0' for Buy and '1' for Sell
	private String status;		// In database its '0' for Pending and '1' for Completed
	private float limitPrice;
	private float stopPrice;
	private int totalQuantity;
	private int openQuantity;
	private int executedQuantity;
	
	public Block(String blockId, String symbol, String side, String status,
			int totalQuantity, float limitPrice, float stopPrice) {
		super();
		this.blockId = blockId;
		this.symbol = symbol;
		this.side = side; 			
		this.status = status;
					
		this.totalQuantity = totalQuantity;
		this.openQuantity = totalQuantity;
				
//		Optional parameters can be passed as last parameters
		this.limitPrice = limitPrice;		
		this.stopPrice = stopPrice;
		
//		Following code finds executed orders and initializes "executedQuantity" variable. 
		this.executedQuantity = 0;			//Temporary
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result + executedQuantity;
		result = prime * result + Float.floatToIntBits(limitPrice);
		result = prime * result + openQuantity;
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Float.floatToIntBits(stopPrice);
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + totalQuantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Block)) {
			return false;
		}
		Block other = (Block) obj;
		if (blockId == null) {
			if (other.blockId != null) {
				return false;
			}
		} else if (!blockId.equals(other.blockId)) {
			return false;
		}
		if (executedQuantity != other.executedQuantity) {
			return false;
		}
		if (Float.floatToIntBits(limitPrice) != Float.floatToIntBits(other.limitPrice)) {
			return false;
		}
		if (openQuantity != other.openQuantity) {
			return false;
		}
		if (side == null) {
			if (other.side != null) {
				return false;
			}
		} else if (!side.equals(other.side)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (Float.floatToIntBits(stopPrice) != Float.floatToIntBits(other.stopPrice)) {
			return false;
		}
		if (symbol == null) {
			if (other.symbol != null) {
				return false;
			}
		} else if (!symbol.equals(other.symbol)) {
			return false;
		}
		if (totalQuantity != other.totalQuantity) {
			return false;
		}
		return true;
	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(float limitPrice) {
		this.limitPrice = limitPrice;
	}

	public float getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(float stopPrice) {
		this.stopPrice = stopPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getOpenQuantity() {
		return openQuantity;
	}

	public void setOpenQuantity(int openQuantity) {
		this.openQuantity = openQuantity;
	}

	public int getExecutedQuantity() {
		return executedQuantity;
	}

	public void setExecutedQuantity(int executedQuantity) {
		this.executedQuantity = executedQuantity;
	}

	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", symbol=" + symbol + ", side=" + side + ", status=" + status
				+ ", limitPrice=" + limitPrice + ", stopPrice=" + stopPrice + ", totalQuantity=" + totalQuantity
				+ ", openQuantity=" + openQuantity + ", executedQuantity=" + executedQuantity + "]";
	}
	
		
}
