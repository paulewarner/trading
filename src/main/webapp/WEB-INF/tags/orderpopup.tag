<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<div id="orderpopup" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-heading order-header">
				Confirm Order
				<button class="order-close close" data-dismiss="modal">
					<img src="icons/cancel.png" />
				</button>
			</div>
			<div class="modal-body">
				<div>
					<h2>
						<span id="orderStockName">APPLE INC</span>
						<span class="order-symbol">(<span id="orderStockSymbol">NASDAQ: AAPL</span>)</span>
					</h2>
				</div>
				<div>
					<h4>
						PORTFOLIO ID: <span id="orderPortfolioId">123456789</span>
					</h4>
				</div>
				<br />
				<table class="table table-borderless">
					<tbody>
						<tr class="order-table-header">
							<th>Quantity</th>
							<th></th>
							<th>Price</th>
							<th class="order-tablecell-last">Investment Amount</th>
						</tr>
						<tr class="order-table-body">
							<td class="order-tablecell" id="orderQuantity">1000</td>
							<td class="order-tablecell" style="width: 1%">@</td>
							<td class="order-tablecell" id="orderPrice">2.76</td>
							<td class="order-tablecell-last">= <span id="orderAmount">2760.00 USD</span></td>
						</tr>
					</tbody>
				</table>
				<table class="table table-borderless">
					<thead>
						<tr class="order-table-header">
							<th>Target</th>
							<th>Stop/Loss</th>
						</tr>
					</thead>
					<tbody>
						<tr class="order-table-body">
							<td id="orderTarget">N/A</td>
							<td id="orderStopLoss">N/A</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button class="order-button btn" data-dismiss="modal">Edit</button>
				<button class="order-button btn">Place Order</button>
			</div>
		</div>
	</div>
</div>