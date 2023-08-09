

const infoToast = document.querySelector('.btn-toast.btn-info-toast')


function addToCart(pId, pName, pPrice){
	
	let cart= localStorage.getItem("cart");
	
	//no cart, so create new cart and add products
	if(cart==null){
		
		let products= [];
		let product= {prodId:pId, prodName:pName, prodPrice:pPrice, prodQuantity:1};
		products.push(product);
		
		localStorage.setItem("cart",JSON.stringify(products));
		new CustomToast().show(`Product Added`, 'info', 10000)
		
	}
	else{
		//cart is present
		let pcart= JSON.parse(cart);
		
		let oldProduct= pcart.find((item)=> item.prodId==pId)
		
		//if product already present, increase count
		if(oldProduct){
			oldProduct.prodQuantity= oldProduct.prodQuantity + 1;
			pcart.map((item)=>{
				if(item.prodId== oldProduct.prodId){
					item.prodQuantity= oldProduct.prodQuantity;
				}
			});
			localStorage.setItem("cart",JSON.stringify(pcart));
			new CustomToast().show(`Count Increased`, 'info', 10000)
			
		}
		//if product not already present, add it
		else{
			let product= {prodId:pId, prodName:pName, prodPrice:pPrice, prodQuantity:1};
			pcart.push(product);
			
			localStorage.setItem("cart",JSON.stringify(pcart));
			new CustomToast().show(`Product Added`, 'info', 10000)
			
		}
		
		updateCart();
	}
}


function updateCart(){
	
	let cartString= localStorage.getItem("cart");
	let cart= JSON.parse(cartString);
	
	if(cart==null || cart.length==0){
		
		console.log("Cart is empty !!");
		$(".cart-items").html("( 0 )");
		$(".cart-body").html("<h4> Cart does not have any items </h4>");
		$(".order-button").attr('disabled',true);
		
	}
	else{
		
		$(".cart-items").html(`(${cart.length})`);
		let table= `
			<table class='table'>
			<thead class= 'thead-light'>
			<tr>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Price</th>
				<th>Action</th>
			</tr>
			</thead>
			`;
			
			let totalPrice=0;
			
			cart.map((item)=> {
				table += `
					<tr>
						<td>${item.prodName}</td>
						<td>&#8377;${item.prodPrice}</td>
						<td>${item.prodQuantity}</td>
						<td>&#8377;${item.prodQuantity * item.prodPrice}</td>
						<td><button class="btn btn-outline-danger btn-sm" onclick= "deleteFromCart(${item.prodId})">Remove</button></td>
					</tr>
				`
				
				totalPrice+= item.prodQuantity * item.prodPrice;
			});
			
			table= table + ` 
				<tr><td colspan='5' class="text-right"> Total price : &#8377;${totalPrice} </td></tr>
			</table>`
			$(".cart-body").html(table);
			$(".order-button").attr('disabled',false);
				
	}
}

function deleteFromCart(pid){
	
	let cartString= localStorage.getItem("cart");
	let cart= JSON.parse(cartString);
	
	let newcart= cart.filter((item) => item.prodId != pid);
	
	localStorage.setItem("cart", JSON.stringify(newcart));
	
	updateCart();
		
}

$(document).ready(function(){
	updateCart();
})

function goToCheckout(){
	
	window.location= "checkout.jsp";
	
}