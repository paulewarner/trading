/**
 *  Header handling code
 */

var switchToIndex;

(function () {
	// IDs for key items in the document.
	const NAVITEMS_ID = 'navitems';
	const BODYITEMS_ID = 'bodyitems';
	
	// Maps the items in the navigation by by index to the items in the body by index.
	const NAV_BODY_MAP = {
		0: 0,
		1: 1,
		2: 2,
	};
	
	function switchToIndexPrivate(navIndex) {
		var bodyIndex = NAV_BODY_MAP[navIndex];
		var navItems = document.getElementById(NAVITEMS_ID).children;
		var bodyItems = document.getElementById(BODYITEMS_ID).children;
		for (var i = 0; i < bodyItems.length; i++) {
			bodyItems[i].style = 'display: none';
		}
		bodyItems[bodyIndex].style = 'display: block';
		
		for (var i = 0; i < navItems.length; i++) {
			navItems[i].classList.remove('active');
		}
		
		navItems[navIndex].classList.add('active');
	}
	
	switchToIndex = switchToIndexPrivate;
	
	function addHeaderListeners() {
		
		function createListener(index) {
			return function() {
				switchToIndex(index);
			};
		}
		var headerItems = document.getElementById(NAVITEMS_ID).children;
		for (var i = 0; i < headerItems.length; i++) {
			headerItems[i].onclick = createListener(i);
		}
	}
	
	addHeaderListeners();
}());