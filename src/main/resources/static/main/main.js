
// uses strict to prevent any unexpected behavior
"use strict";

// selector for the form
const postForm = document.querySelector("#post-form");

// selector for the post input
const text = document.querySelector("[name='text']");

// selector for css on input
const csrfToken = document.querySelector("input[name='_csrf']").value;

// form submit response
postForm.addEventListener("submit",async(e)=>{
	 // prevents default behavior
	 e.preventDefault();
	 
	 //instantiate the form on thymeleaf
	 const formData = new FormData(postForm);
	 
	 // Assigned a selector to a variable
	 const errorEl = document.querySelectorAll(".error-el");
	
     // Serializing the values to key/value pair and store it to a variable
	 const serialized = new URLSearchParams(formData).toString();
	
	
	 // DOM manipulation which checks the existing thymeleaf if there are any selector that has "error-el".
	 if(errorEl.length > 0) {
		errorEl.forEach(val=>val.remove());
	 }
	
	
	 // fetch for the insert.
	 fetch("/main/insert/rest",{
		 
		 // Method for post to match on the java
		 method: "POST",
		 // headers which indicates to the server the passed data matches what we have here. Which is the key/value pair instead of our normal JSON.
		  headers: {
	      "Content-Type": "application/x-www-form-urlencoded"
	      // body is the form data that has been serialized to key/value pair
	    },body: serialized
	 }) 
	 // we receieved then the response as json
	 .then(response => response.json())
	 // get the response data
	 .then(data => {
		 
		 // based on the response of the server we will be expecting a string which can be used as URL
	    if (data.redirectUrl) {
		  // runs the URL thru javascrip which will route to a new page
	      window.location.href = data.redirectUrl;
	      
	      // if there is no data response
	    } else {
			// iterates the error and store it thru key value pair
			for(const[key,value] of Object.entries(data.errors))
			{
				// javascript will manipulate the DOM and post the following errors.
				postForm.insertAdjacentHTML("afterbegin",
	    	`<div class="error-el"><p style = "color:red;">${value}</p></div>`)
			}
	    }
	  })
	  // if an error encounters in this fetch. Throws an error exception
	  .catch(error => console.error('Error:', error));
})


